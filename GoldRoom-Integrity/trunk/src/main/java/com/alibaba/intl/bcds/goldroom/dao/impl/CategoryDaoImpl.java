package com.alibaba.intl.bcds.goldroom.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.alibaba.intl.bcds.goldroom.dao.CategoryDao;
import com.alibaba.intl.bcds.goldroom.dataobject.Category;

@SuppressWarnings("unchecked")
public class CategoryDaoImpl implements CategoryDao {

    @PersistenceContext(unitName = "goldroomPU")
    private EntityManager em;

    public List<Category> listAll() {
        return em.createNamedQuery("listAllCategory").getResultList();
    }

}
