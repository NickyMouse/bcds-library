package com.alibaba.intl.bcds.goldroom.search.commons.service;

import java.util.List;

import com.alibaba.intl.bcds.goldroom.search.commons.dataobject.BuildBookSearchDO;

public interface BuildBookSearchService {
	public List<BuildBookSearchDO> listAllBook(int pageSize, int page);
}
