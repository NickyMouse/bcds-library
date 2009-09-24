/**
 * Project: goldroom-biz
 * 
 * File Created at 2009-9-23
 * $Id$
 * 
 * Copyright 2008 Alibaba.com Croporation Limited.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information of
 * Alibaba Company. ("Confidential Information").  You shall not
 * disclose such Confidential Information and shall use it only in
 * accordance with the terms of the license agreement you entered into
 * with Alibaba.com.
 */
package com.alibaba.intl.bcds.goldroom.sample.service.impl;

import java.util.List;

import com.alibaba.intl.bcds.goldroom.sample.User;
import com.alibaba.intl.bcds.goldroom.sample.dao.UserDao;
import com.alibaba.intl.bcds.goldroom.sample.service.UserService;

/**
 * TODO Comment of UserServiceImpl
 * 
 * @author Zimmem
 */
public class UserServiceImpl implements UserService {

    private UserDao userDao;

    /**
     * @param userDao the userDao to set
     */
    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    /*
     * (non-Javadoc)
     * @see
     * com.alibaba.intl.bcds.goldroom.sample.service.UserService#addUser(com
     * .alibaba.intl.bcds.goldroom.sample.User)
     */
    @Override
    public void addUser(User user) {
        userDao.insertUser(user);

    }

    /*
     * (non-Javadoc)
     * @see
     * com.alibaba.intl.bcds.goldroom.sample.service.UserService#listAllUser()
     */
    @Override
    public List<User> listAllUser() {
        return userDao.listAllUser();
    }

}
