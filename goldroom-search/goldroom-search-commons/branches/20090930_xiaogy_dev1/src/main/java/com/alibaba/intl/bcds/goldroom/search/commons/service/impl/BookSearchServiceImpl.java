package com.alibaba.intl.bcds.goldroom.search.commons.service.impl;

import java.util.Date;
import java.util.List;

import com.alibaba.intl.bcds.goldroom.search.commons.dao.BookSearchDao;
import com.alibaba.intl.bcds.goldroom.search.commons.dataobject.BookSearchDO;
import com.alibaba.intl.bcds.goldroom.search.commons.dataobject.helper.BookSearchConstrains;
import com.alibaba.intl.bcds.goldroom.search.commons.queryobject.BookSearchQueryObject;
import com.alibaba.intl.bcds.goldroom.search.commons.service.BookSearchService;
import com.alibaba.intl.bcds.goldroom.search.commons.utils.SearchConditionBuilder;

public class BookSearchServiceImpl implements BookSearchService {

	private BookSearchDao bookSearchDao;

	public BookSearchDao getBookSearchDao() {
		return bookSearchDao;
	}

	public void setBookSearchDao(BookSearchDao bookSearchDao) {
		this.bookSearchDao = bookSearchDao;
	}

	public List<BookSearchDO> searchBookByCategoryId(Integer id,
			Integer skipResult, Integer number) {
		SearchConditionBuilder builder = SearchConditionBuilder.getInstance()
				.addTerm(BookSearchConstrains.BOOK_CATEGORY_ID, id.toString());
		BookSearchQueryObject query = BookSearchQueryObject
				.getInstance(builder).setN(number).setSkipResult(skipResult)
				.setPrimarySortFiled("");
		return bookSearchDao.searchByQuery(query);
	}

	public List<BookSearchDO> searchBookByKeyword(String keyword,
			Integer skipResult, Integer number) {
		SearchConditionBuilder builder = SearchConditionBuilder.getInstance()
				.addTerm(BookSearchConstrains.BOOK_NAME, keyword).addTerm(
						BookSearchConstrains.BOOK_DESCRIPTION, keyword);
		BookSearchQueryObject query = BookSearchQueryObject
				.getInstance(builder).setN(number).setSkipResult(skipResult)
				.setPrimarySortFiled("");
		return bookSearchDao.searchByQuery(query);
	}

	public List<BookSearchDO> searchBookByTime(Date startTime, Date endTime,
			Integer skipResult, Integer number) {
		SearchConditionBuilder builder = SearchConditionBuilder.getInstance()
				.addDateRange(BookSearchConstrains.ITEM_FIRST_ADD_TIME,
						startTime, endTime);
		BookSearchQueryObject query = BookSearchQueryObject
				.getInstance(builder).setN(number).setSkipResult(skipResult)
				.setPrimarySortFiled("");
		return bookSearchDao.searchByQuery(query);
	}

}
