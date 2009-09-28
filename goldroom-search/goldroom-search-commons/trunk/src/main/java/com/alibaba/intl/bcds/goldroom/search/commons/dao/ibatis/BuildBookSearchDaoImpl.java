package com.alibaba.intl.bcds.goldroom.search.commons.dao.ibatis;

import java.util.Hashtable;
import java.util.List;
import java.util.Map;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import com.alibaba.intl.bcds.goldroom.search.commons.dao.BuildBookSearchDao;
import com.alibaba.intl.bcds.goldroom.search.commons.dataobject.BuildBookSearchDO;
import com.alibaba.intl.bcds.goldroom.search.commons.dataobject.BuildCategorySearchDO;

@SuppressWarnings("unchecked")
public class BuildBookSearchDaoImpl extends SqlMapClientDaoSupport implements
		BuildBookSearchDao {

	public List<BuildBookSearchDO> listAllBook(Integer rows, Integer page) {
		Map param = new Hashtable();
		param.put("rows", rows);
		param.put("page", page);
		return getSqlMapClientTemplate().queryForList("BUILD_BOOK_SEARCH.listAllBook", param);
	}

	public Map<Integer, BuildCategorySearchDO> listAllCategory() {
		return getSqlMapClientTemplate().queryForMap("BUILD_BOOK_SEARCH.listAllCategory", null,
				"id");
	}

}
