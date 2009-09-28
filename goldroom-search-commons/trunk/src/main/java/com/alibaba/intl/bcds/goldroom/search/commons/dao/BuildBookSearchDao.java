package com.alibaba.intl.bcds.goldroom.search.commons.dao;

import java.util.List;
import java.util.Map;

import com.alibaba.intl.bcds.goldroom.search.commons.dataobject.BuildBookSearchDO;
import com.alibaba.intl.bcds.goldroom.search.commons.dataobject.BuildCategorySearchDO;

public interface BuildBookSearchDao {
	public Map<Integer, BuildCategorySearchDO> listAllCategory();

	public List<BuildBookSearchDO> listAllBook(Integer rows, Integer page);
}
