/**
 * Project: goldroom-web
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
package com.alibaba.intl.bcds.goldroom.web.utils;

import java.util.List;

import com.alibaba.intl.bcds.goldroom.dao.CategoryDao;
import com.alibaba.intl.bcds.goldroom.dataobject.Category;

/**
 * TODO Comment of CategoryCache
 * 
 * @author Zimmem
 */
public class CategoryCache {
    private List<Category> cache;

    private CategoryDao    categoryDao;

    /**
     * @return the categoryDao
     */
    public CategoryDao getCategoryDao() {
        return categoryDao;
    }

    /**
     * @param categoryDao the categoryDao to set
     */
    public void setCategoryDao(CategoryDao categoryDao) {
        this.categoryDao = categoryDao;
    }

    public List<Category> getCategorys() {
        return cache;
    }

    public void init() {
        List<Category> categories = categoryDao.listAll();
        cache = categories;
    }

    public void reBuild() {
        init();
    }
}
