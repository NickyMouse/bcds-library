package com.alibaba.intl.bcds.goldroom.search.commons.dao;

import com.alibaba.intl.bcds.goldroom.search.commons.queryobject.BookSearchQueryObject;

/**
 * 图书搜索接口
 * @author Giraffe
 *
 */
public interface BookSearchDao {
	/**
	 * 根据条件进行搜索，搜索结果放入 query中的resultList中
	 * @param query 搜索条件
	 */
	void searchByQuery(BookSearchQueryObject query);
}
