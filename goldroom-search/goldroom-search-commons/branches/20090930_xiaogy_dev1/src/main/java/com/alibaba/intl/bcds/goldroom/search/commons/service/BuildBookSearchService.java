package com.alibaba.intl.bcds.goldroom.search.commons.service;

import java.util.Date;
import java.util.List;

import com.alibaba.intl.bcds.goldroom.search.commons.dataobject.BuildBookSearch;

public interface BuildBookSearchService {
	public List<BuildBookSearch> listAllBook(int page);
	public List<BuildBookSearch> listBookByTime(Date startTime, Date endTime);
}
