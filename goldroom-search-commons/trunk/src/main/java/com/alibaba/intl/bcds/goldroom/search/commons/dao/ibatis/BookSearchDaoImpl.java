package com.alibaba.intl.bcds.goldroom.search.commons.dao.ibatis;

import java.util.List;

import com.alibaba.intl.bcds.goldroom.search.commons.dao.BookSearchDao;
import com.alibaba.intl.bcds.goldroom.search.commons.dao.datasource.SearchDatasource;
import com.alibaba.intl.bcds.goldroom.search.commons.dataobject.BookSearchDO;
import com.alibaba.intl.bcds.goldroom.search.commons.queryobject.BookSearchQuery;

public class BookSearchDaoImpl implements BookSearchDao {
	private SearchDatasource searchDatasource;

	public SearchDatasource getSearchDatasource() {
		return searchDatasource;
	}

	public void setSearchDatasource(SearchDatasource searchDatasource) {
		this.searchDatasource = searchDatasource;
	}

	public List<BookSearchDO> searchByQuery(BookSearchQuery query) {
		// TODO Auto-generated method stub
		return null;
	}

}
