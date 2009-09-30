/**
 * Project: goldroom-dal
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
package com.alibaba.intl.bcds.goldroom.sample.dao;

import java.util.List;

import com.alibaba.intl.bcds.goldroom.sample.User;

/**
 * TODO Comment of UserDao
 * 
 * @author Zimmem
 */
public interface UserDao {
    void insertUser(User user);

    List<User> listAllUser();
}
