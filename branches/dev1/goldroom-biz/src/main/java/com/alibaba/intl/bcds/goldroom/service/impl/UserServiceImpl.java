package com.alibaba.intl.bcds.goldroom.service.impl;

import java.util.Map;

import com.alibaba.intl.bcds.goldroom.dao.UserInfoDao;
import com.alibaba.intl.bcds.goldroom.service.UserService;

public class UserServiceImpl implements UserService {

	private UserInfoDao userInfoDao;

	public void setUserInfoDao(UserInfoDao userInfoDao) {
		this.userInfoDao = userInfoDao;
	}

	/*
	 * 更改用户信息
	 * 
	 * @see
	 * com.alibaba.intl.bcds.goldroom.service.UsersService#update(com.alibaba
	 * .intl.bcds.goldroom.dataobject.Member)
	 */
	@SuppressWarnings("unchecked")
	public void updateUserInfo(Map userInfo) {
		userInfoDao.update(userInfo);
	}
}
