package com.alibaba.intl.bcds.goldroom.search.commons.service.impl;

import java.util.Date;
import java.util.List;

import com.alibaba.intl.bcds.goldroom.search.commons.dao.BookSearchDao;
import com.alibaba.intl.bcds.goldroom.search.commons.dataobject.BookSearchDO;
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

	public List<BookSearchDO> searchBookByCategoryId(Integer id, Integer number) {
		SearchConditionBuilder builder = SearchConditionBuilder.getInstance().addTerm("bookCategoryId", id.toString());
		BookSearchQueryObject query = BookSearchQueryObject.getInstance(builder)
				.setN(number)
				.setPrimarySortFiled("");
		return bookSearchDao.searchByQuery(query);
	}

	public List<BookSearchDO> searchBookByKeyword(String fieldName,
			String keyword, Integer number) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<BookSearchDO> searchBookByTime(Date startTime, Date endTime,
			Integer number) {
		// TODO Auto-generated method stub
		return null;
	}

}
