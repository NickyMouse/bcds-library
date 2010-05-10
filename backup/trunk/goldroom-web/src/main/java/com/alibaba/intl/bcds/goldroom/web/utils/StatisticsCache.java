package com.alibaba.intl.bcds.goldroom.web.utils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;

/**
 * 借阅统计缓存
 * 
 * @author Giraffe
 * 
 */
public class StatisticsCache {

	protected class BookMark implements Comparable<BookMark> {
		private int bookInfoId;
		private int mark = 1;

		protected BookMark(int bookInfoId) {
			this.bookInfoId = bookInfoId;
		}

		protected void incMark() {
			mark++;
		}

		protected void incMark(int increment) {
			mark += increment;
		}

		protected void setBookInfoId(int bookInfoId) {
			this.bookInfoId = bookInfoId;
		}

		protected int getBookInfoId() {
			return bookInfoId;
		}

		protected void setMark(int mark) {
			this.mark = mark;
		}

		protected int getMark() {
			return mark;
		}

		@Override
		public int compareTo(BookMark o) {
			return this.mark - o.mark;
		}

	}

	/**
	 * statisticsMap 是用于记录一本书的分值的一个map，key为bookInfoId,value为分值
	 */
	private static Map<Integer, BookMark> statisticsMap = new Hashtable<Integer, BookMark>();
	private int count = 0;
	private List<Integer> popularBookInfoIds = new ArrayList();

	public List<Integer> getPopularBookInfoIds() {
		return popularBookInfoIds;
	}

	/**
	 * 增加分值
	 * 
	 * @param bookInfoId
	 */
	public void addOne(int bookInfoId) {
		// 由于统计数据并不要求非常精确，所以这里不是线程安全
		if (statisticsMap.containsKey(bookInfoId)) {
			statisticsMap.get(bookInfoId).incMark();
		} else {
			statisticsMap.put(bookInfoId, new BookMark(bookInfoId));
		}
		count++;
		if (count > 20) {
			reflesh();
			count = 0;
		}
	}

	public void init() {
	}

	public void reflesh() {
		if (statisticsMap.size() == 0) {
			return;
		}
		List<BookMark> tempList = new ArrayList<BookMark>();
		tempList.addAll(statisticsMap.values());
		Collections.sort(tempList);
		synchronized (popularBookInfoIds) {
			for (int i = 0; i < tempList.size(); i++) {
				if (i < 5) {
					popularBookInfoIds.add(tempList.get(i).getBookInfoId());
				}
			}
		}

	}

}
