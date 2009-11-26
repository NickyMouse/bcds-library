package com.alibaba.intl.bcds.goldroom.search.commons.service;

import java.util.Date;
import java.util.List;

import com.alibaba.intl.bcds.goldroom.search.commons.dataobject.BookSearch;
import com.alibaba.intl.bcds.goldroom.search.commons.queryobject.BookSearchOption;
import com.alibaba.intl.bcds.goldroom.search.commons.queryobject.BookSearchQueryObject;

public interface BookSearchService {
	public BookSearchQueryObject searchBookByCategoryId(Integer catId,
			Integer skipResult, Integer number);

	public BookSearchQueryObject searchBookByKeyword(String keyword,
			Integer skipResult, Integer number);

	public BookSearchQueryObject searchBookByTime(Date startTime, Date endTime,
			Integer skipResult, Integer number);

	public BookSearch searchBookByInfoId(Integer bookInfoId);

	public BookSearchQueryObject advancedBookSearch(BookSearchOption option,
			Integer skipResult, Integer number);

	public BookSearchQueryObject listAllBook(Integer skipResult, Integer number);
	
	public BookSearchQueryObject searchBookByInfoIds(List<Integer> infoIdlist);
}
