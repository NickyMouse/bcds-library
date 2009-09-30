package com.alibaba.intl.bcds.goldroom.search.commons.dao;

import java.util.List;

import com.alibaba.intl.bcds.goldroom.search.commons.dataobject.BookSearchDO;
import com.alibaba.intl.bcds.goldroom.search.commons.queryobject.BookSearchQueryObject;


public interface BookSearchDao {
	void searchByQuery(BookSearchQueryObject query);
}
