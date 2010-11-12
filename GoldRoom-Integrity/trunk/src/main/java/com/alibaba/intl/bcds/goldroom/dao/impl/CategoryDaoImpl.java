package com.alibaba.intl.bcds.goldroom.dao.impl;

import java.util.List;

import com.alibaba.intl.bcds.goldroom.dao.BaseDao;
import com.alibaba.intl.bcds.goldroom.dao.CategoryDao;
import com.alibaba.intl.bcds.goldroom.dataobject.Category;

@SuppressWarnings("unchecked")
public class CategoryDaoImpl extends BaseDao implements CategoryDao {

    public List<Category> listAll() {
        return this.createNamedQuery("listAllCategory").list();
    }

}
