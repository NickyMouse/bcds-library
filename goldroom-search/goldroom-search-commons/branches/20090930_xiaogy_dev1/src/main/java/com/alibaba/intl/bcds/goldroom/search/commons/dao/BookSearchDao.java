package com.alibaba.intl.bcds.goldroom.search.commons.dao;

import com.alibaba.intl.bcds.goldroom.search.commons.queryobject.BookSearchQueryObject;


public interface BookSearchDao {
	void searchByQuery(BookSearchQueryObject query);
}
