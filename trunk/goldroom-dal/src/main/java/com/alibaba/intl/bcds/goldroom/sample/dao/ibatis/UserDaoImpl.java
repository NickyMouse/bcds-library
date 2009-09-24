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
package com.alibaba.intl.bcds.goldroom.sample.dao.ibatis;

import java.util.List;

import org.springframework.orm.ibatis.SqlMapClientTemplate;
import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import com.alibaba.intl.bcds.goldroom.sample.User;
import com.alibaba.intl.bcds.goldroom.sample.dao.UserDao;

/**
 * TODO Comment of UserDaoImpl
 * 
 * @author Zimmem
 */
public class UserDaoImpl extends SqlMapClientDaoSupport implements UserDao {

    /*
     * (non-Javadoc)
     * @see
     * com.alibaba.intl.bcds.goldroom.sample.dao.UserDao#insertUser(com.alibaba
     * .intl.bcds.goldroom.sample.User)
     */
    @Override
    public void insertUser(User user) {
        getSqlMapClientTemplate().insert("user.insert", user);

    }

    /*
     * (non-Javadoc)
     * @see com.alibaba.intl.bcds.goldroom.sample.dao.UserDao#listAllUser()
     */
    @Override
    public List<User> listAllUser() {
        return getSqlMapClientTemplate().queryForList("user.listAll");
    }

}
