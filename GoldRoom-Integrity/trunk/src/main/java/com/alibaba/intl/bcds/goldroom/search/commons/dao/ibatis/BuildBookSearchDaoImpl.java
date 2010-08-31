package com.alibaba.intl.bcds.goldroom.search.commons.dao.ibatis;

import java.util.Date;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import com.alibaba.intl.bcds.goldroom.search.commons.dao.BuildBookSearchDao;
import com.alibaba.intl.bcds.goldroom.search.commons.dataobject.BuildBookSearch;

@SuppressWarnings("unchecked")
public class BuildBookSearchDaoImpl extends SqlMapClientDaoSupport implements
		BuildBookSearchDao {
	/**
	 * 一页的大小：一次获取的记录数
	 */
	private Integer pageSize;

	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}

	public List<BuildBookSearch> listAllBook(Integer page) {
		Map param = new Hashtable();
		param.put("skipRow", (page - 1) * pageSize);
		param.put("pageSize", pageSize);
		return getSqlMapClientTemplate().queryForList(
				"BUILD_BOOK_SEARCH.listAllBook", param);
	}

	

	public List<BuildBookSearch> listBookByTime(Date startTime, Date endTime) {
		Map param = new Hashtable();
		param.put("startTime", startTime);
		param.put("endTime", endTime);
		return getSqlMapClientTemplate().queryForList(
				"BUILD_BOOK_SEARCH.listBookByTime", param);
	}
}
