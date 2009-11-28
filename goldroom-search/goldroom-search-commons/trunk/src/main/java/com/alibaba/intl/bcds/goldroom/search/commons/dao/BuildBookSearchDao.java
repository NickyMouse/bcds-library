package com.alibaba.intl.bcds.goldroom.search.commons.dao;

import java.util.Date;
import java.util.List;

import com.alibaba.intl.bcds.goldroom.search.commons.dataobject.BuildBookSearch;

/**
 * 从db中获取用于build search数据的DAO接口
 * 
 * @author Giraffe
 * 
 */
public interface BuildBookSearchDao {

	public List<BuildBookSearch> listAllBook(Integer page);

	public List<BuildBookSearch> listBookByTime(Date startTime, Date endTime);
}
