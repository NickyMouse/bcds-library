package com.alibaba.intl.bcds.goldroom.search.commons.service.impl;

import java.util.Date;
import java.util.List;

import com.alibaba.intl.bcds.goldroom.search.commons.dao.BuildBookSearchDao;
import com.alibaba.intl.bcds.goldroom.search.commons.dataobject.BuildBookSearch;
import com.alibaba.intl.bcds.goldroom.search.commons.service.BuildBookSearchService;

public class BuildBookSearchServiceImpl implements BuildBookSearchService {
	
	private BuildBookSearchDao buildBookSearchDao;

	public BuildBookSearchDao getBuildBookSearchDao() {
		return buildBookSearchDao;
	}

	public void setBuildBookSearchDao(BuildBookSearchDao buildBookSearchDao) {
		this.buildBookSearchDao = buildBookSearchDao;
	}

	public List<BuildBookSearch> listAllBook(int page) {
		return buildBookSearchDao.listAllBook(page);
	}

	public List<BuildBookSearch> listBookByTime(Date startTime, Date endTime) {
		return buildBookSearchDao.listBookByTime(startTime,endTime);
	}

}
