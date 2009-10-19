package com.alibaba.intl.bcds.goldroom.search.commons.dao;

import java.util.Date;
import java.util.List;
import java.util.Map;

import com.alibaba.intl.bcds.goldroom.search.commons.dataobject.BuildBookSearch;
import com.alibaba.intl.bcds.goldroom.search.commons.dataobject.BuildCategorySearch;

public interface BuildBookSearchDao {
	public Map<Integer, BuildCategorySearch> listAllCategory();

	public List<BuildBookSearch> listAllBook(Integer page);
	
	public List<BuildBookSearch> listBookByTime(Date startTime, Date endTime);
}
