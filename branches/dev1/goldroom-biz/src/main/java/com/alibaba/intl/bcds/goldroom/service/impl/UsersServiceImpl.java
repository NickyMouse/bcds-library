package com.alibaba.intl.bcds.goldroom.service.impl;

import com.alibaba.intl.bcds.goldroom.dao.UserInfoDao;
import com.alibaba.intl.bcds.goldroom.dataobject.Member;
import com.alibaba.intl.bcds.goldroom.service.UsersService;

public class UsersServiceImpl implements UsersService {

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
	public void updateUserInfo(Member member) {
		userInfoDao.update(member);
	}
}
