package com.alibaba.intl.bcds.goldroom.dao.ibatis;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import com.alibaba.intl.bcds.goldroom.dao.UserInfoDao;
import com.alibaba.intl.bcds.goldroom.dataobject.Member;

public class UserInfoDaoImpl extends SqlMapClientDaoSupport implements
		UserInfoDao {
	/**
	 * 更改用户信息
	 */
	public void update(Member member) {
		getSqlMapClientTemplate().update("", member);
	}
}
