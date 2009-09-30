package com.alibaba.intl.bcds.goldroom.search.commons.dao.datasource;

import org.apache.lucene.search.Searcher;

public interface SearchDatasource {
	String getIndexLocation();
	Searcher getSearcher();
}
