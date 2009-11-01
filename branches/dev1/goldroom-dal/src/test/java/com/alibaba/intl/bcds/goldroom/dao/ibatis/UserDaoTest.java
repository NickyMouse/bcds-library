/**
 * Project: goldroom-dal
 * 
 * File Created at 2009-10-27
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
package com.alibaba.intl.bcds.goldroom.dao.ibatis;

import java.util.List;

import org.junit.Test;
import static org.junit.Assert.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import com.alibaba.intl.bcds.goldroom.dao.test.BaseTest;
import com.alibaba.intl.bcds.goldroom.sample.User;
import com.alibaba.intl.bcds.goldroom.sample.dao.UserDao;

/**
 * TODO Comment of UserDaoTest
 * 
 * @author Zimmem
 */
@TransactionConfiguration(defaultRollback = true)
public class UserDaoTest extends BaseTest {

    @Autowired
    private UserDao userDao;

    /**
     * 
     */
    //@Test
    public void testInsert() {
        User user = new User();
        user.setUsername("中文");
        user.setAge(10);
        userDao.insertUser(user);

    }

    @Test
    public void testList() {
        List<User> list = userDao.listAllUser();
        System.out.println(list.get(0).getUsername());
        assertEquals(list.get(0).getUsername(), "中文");

    }
}
