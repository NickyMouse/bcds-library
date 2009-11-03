package com.alibaba.intl.bcds.goldroom.dao;

import java.util.Map;

import com.alibaba.intl.bcds.goldroom.dataobject.User;

public interface UserInfoDao {
	/**
	 * 更改用户信息
	 */
	@SuppressWarnings("unchecked")
	void update(Map userInfo);
}
