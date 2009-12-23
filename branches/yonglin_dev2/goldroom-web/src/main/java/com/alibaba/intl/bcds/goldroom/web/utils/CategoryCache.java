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

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.alibaba.intl.bcds.goldroom.dao.CategoryDao;
import com.alibaba.intl.bcds.goldroom.dataobject.Category;

/**
 * TODO Comment of CategoryCache
 * 
 * @author Zimmem
 */
public class CategoryCache {
    private List<Category>         cache;
    private Map<Integer, Category> cacheMap;

    /**
     * @return the cacheMap
     */
    public Map<Integer, Category> getCacheMap() {
        return cacheMap;
    }

    /**
     * @param cacheMap the cacheMap to set
     */
    public void setCacheMap(Map<Integer, Category> cacheMap) {
        this.cacheMap = cacheMap;
    }

    private CategoryDao categoryDao;

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

        Map<Integer, Category> map = new HashMap<Integer, Category>(categories.size());
        for (Category category : categories) {
            map.put(category.getId(), category);
        }
        cache = categories;
        cacheMap = map;
    }

    public void reBuild() {
        init();
    }

    public String getName(Integer id) {
        Category category = cacheMap.get(id);
        if (category != null && category.getId() > 0) {
            return category.getName();
        }
        return null;
    }

    public String getFullName(Integer id, String separator) {
        StringBuilder sb = new StringBuilder();
        Category category = cacheMap.get(id);
        if (category != null && category.getId() > 0) {
            sb.append(category.getName());
            while (category != null && category.getParentId() > 0) {
                int parentId = category.getParentId();
                category = cacheMap.get(parentId);
                sb.insert(0, separator).insert(0, category.getName());
            }
        }
        return sb.toString();
    }
}
