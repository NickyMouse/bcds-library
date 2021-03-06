/**
 * Project: goldroom-dal
 * 
 * File Created at 2009-10-17
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

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import com.alibaba.intl.bcds.goldroom.dao.CategoryDao;
import com.alibaba.intl.bcds.goldroom.dataobject.Category;

/**
 * TODO Comment of CategoryDaoImpl
 * 
 * @author Zimmem
 */
public class CategoryDaoImpl extends SqlMapClientDaoSupport implements CategoryDao {

    /*
     * (non-Javadoc)
     * @see com.alibaba.intl.bcds.goldroom.dao.CategoryDao#listAll()
     */
    @Override
    public List<Category> listAll() {
        return getSqlMapClientTemplate().queryForList("CATEGORY.listAll");
    }

}
