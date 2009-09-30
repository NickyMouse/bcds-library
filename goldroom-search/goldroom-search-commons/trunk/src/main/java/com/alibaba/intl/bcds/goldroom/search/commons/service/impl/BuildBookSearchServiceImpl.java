package com.alibaba.intl.bcds.goldroom.search.commons.service.impl;

import java.util.List;

import com.alibaba.intl.bcds.goldroom.search.commons.dao.BuildBookSearchDao;
import com.alibaba.intl.bcds.goldroom.search.commons.dataobject.BuildBookSearchDO;
import com.alibaba.intl.bcds.goldroom.search.commons.service.BuildBookSearchService;

public class BuildBookSearchServiceImpl implements BuildBookSearchService {
	
	private BuildBookSearchDao buildBookSearchDao;

	public BuildBookSearchDao getBuildBookSearchDao() {
		return buildBookSearchDao;
	}

	public void setBuildBookSearchDao(BuildBookSearchDao buildBookSearchDao) {
		this.buildBookSearchDao = buildBookSearchDao;
	}

	public List<BuildBookSearchDO> listAllBook(int page) {
		return buildBookSearchDao.listAllBook(page);
	}

}
