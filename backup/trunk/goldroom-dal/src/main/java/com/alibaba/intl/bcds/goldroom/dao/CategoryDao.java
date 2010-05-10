/**
 * Project: goldroom-dal
 * 
 * File Created at 2009-10-15
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
package com.alibaba.intl.bcds.goldroom.dao;

import java.util.List;

import com.alibaba.intl.bcds.goldroom.dataobject.Category;

/**
 * TODO Comment of CategoryDao
 * @author Zimmem
 *
 */
public interface CategoryDao {

    /**
     * @return
     */
    List<Category> listAll();

}
