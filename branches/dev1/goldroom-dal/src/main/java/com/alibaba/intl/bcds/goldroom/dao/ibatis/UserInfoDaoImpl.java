package com.alibaba.intl.bcds.goldroom.dao.ibatis;

import java.util.Map;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import com.alibaba.intl.bcds.goldroom.dao.UserInfoDao;

public class UserInfoDaoImpl extends SqlMapClientDaoSupport implements
		UserInfoDao {
	/**
	 * 更改用户信息
	 */
	@SuppressWarnings("unchecked")
	public void update(Map userInfo) {
		getSqlMapClientTemplate().update("MEMBER.updatePassword", userInfo);
	}

}
