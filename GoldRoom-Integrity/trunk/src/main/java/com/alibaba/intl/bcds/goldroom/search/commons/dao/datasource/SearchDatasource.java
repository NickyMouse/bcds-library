package com.alibaba.intl.bcds.goldroom.search.commons.dao.datasource;

import org.apache.lucene.search.Searcher;

/**
 * 搜索的数据源接口
 * 
 * @author Giraffe
 * 
 */
public interface SearchDatasource {
	/**
	 * 获取索引的存放路径
	 * 
	 * @return
	 */
	String getIndexLocation();

	/**
	 * 获取Searcher
	 * 
	 * @return
	 */
	Searcher getSearcher();
}
