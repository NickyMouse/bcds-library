package com.alibaba.intl.bcds.goldroom.search.commons.dao;

import java.util.List;

import com.alibaba.intl.bcds.goldroom.search.commons.dataobject.BookSearchDO;
import com.alibaba.intl.bcds.goldroom.search.commons.queryobject.BookSearchQuery;


public interface BookSearchDao {
	List<BookSearchDO> searchByQuery(BookSearchQuery query);
}
