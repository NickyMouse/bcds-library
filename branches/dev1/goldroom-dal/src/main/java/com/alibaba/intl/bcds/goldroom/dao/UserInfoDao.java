package com.alibaba.intl.bcds.goldroom.dao;

import java.util.Map;

public interface UserInfoDao {
	/**
	 * 更改用户信息
	 */
	@SuppressWarnings("unchecked")
	void update(Map userInfo);

	void insertUser();

}
