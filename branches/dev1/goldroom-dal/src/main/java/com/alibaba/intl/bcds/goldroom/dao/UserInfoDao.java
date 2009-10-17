package com.alibaba.intl.bcds.goldroom.dao;

import com.alibaba.intl.bcds.goldroom.dataobject.Member;

public interface UserInfoDao {
	/**
	 * 更改用户信息
	 */
	void update(Member member);
}
