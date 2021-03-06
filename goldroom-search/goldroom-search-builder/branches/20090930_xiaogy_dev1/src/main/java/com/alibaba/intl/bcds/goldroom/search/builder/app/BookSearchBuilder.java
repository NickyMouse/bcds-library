package com.alibaba.intl.bcds.goldroom.search.builder.app;

import java.io.IOException;
import java.util.Calendar;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

import org.apache.log4j.Logger;

import com.alibaba.intl.bcds.goldroom.search.builder.builder.BookInfoBuilder;
import com.alibaba.intl.bcds.goldroom.search.builder.utils.BuildSearchMode;

public class BookSearchBuilder {
	static BookInfoBuilder builder;
	private static Logger logger = Logger.getLogger(BookInfoBuilder.class);
	static int startHour;
	static int endHour;

	/**
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {
		String usage = "<Usage> java com.alibaba.intl.bcds.goldroom.search.builder.app.BookSearchBuilder "
				+ "[mode] [targeIndexFolder] [interval] [startHour] [endHour]";
		String fullExample = "<Example> Full Build : java com.alibaba.intl.bcds.goldroom.search.builder.app."
				+ "BookSearchBuilder full /home/admin/index/ 60 0 8\nfull build every 60 mins between 0~8 o'clock";
		String incExample = "<Example> Increment Build : java com.alibaba.intl.bcds.goldroom.search.builder.app."
				+ "BookSearchBuilder inc /home/admin/index/ 3 8 23\nincrement build every 3 mins between 8~23 o'clock";

		if (args.length != 5) {
			System.out.println(usage);
			System.out.println(fullExample);
			System.out.println(incExample);
			return;
		}

		// build 模式
		String mode = args[0];
		// 目标路径
		String targeIndexFolder = args[1];
		// 时间间隔为分钟
		long interval = Long.valueOf(args[2]) * 60000;
		startHour = Integer.valueOf(args[3]);
		endHour = Integer.valueOf(args[4]);

		builder = new BookInfoBuilder();
		Date endTime = new Date();
		if (BuildSearchMode.FULL.getValue().equalsIgnoreCase(mode)) {
			builder.setIncrementBuild(false);
		} else {
			builder.setIncrementBuild(true);
			builder.setModifiedEndTime(endTime);
		}
		builder.setDestination(targeIndexFolder);
		builder.setInterval(interval);

		Timer timer = new Timer("BookSearchBuilder");
		timer.schedule(new TimerTask() {
			@Override
			public void run() {
				if (builder.isIncrementBuild()
						&& !isWorkingHour(startHour, endHour)) {
					logger.info("[Sleep]Increament Build Sleep " + new Date());
					return;
				} else if (!builder.isIncrementBuild()
						&& !isWorkingHour(startHour, endHour)) {
					logger.info("[Sleep]Full Build Sleep " + new Date());
					return;
				}
				builder.process();
			}
		}, new Date(), interval);
	}

	public static boolean isWorkingHour(int startHour, int endHour) {
		int hour = Calendar.getInstance().get(Calendar.HOUR_OF_DAY);
		if (startHour > endHour) {
			if (hour >= startHour && hour <= 23) {
				return true;
			} else if (hour >= 0 && hour <= endHour) {
				return true;
			}
		}else{
			if(hour >= startHour && hour <= endHour){
				return true;
			}
		}
		return false;
	}
}
