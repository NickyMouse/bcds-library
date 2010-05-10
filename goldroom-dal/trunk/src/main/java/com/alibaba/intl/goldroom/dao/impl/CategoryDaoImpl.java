package com.alibaba.intl.goldroom.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.alibaba.intl.goldroom.dao.CategoryDao;
import com.alibaba.intl.goldroom.dataobject.Category;

@SuppressWarnings("unchecked")
public class CategoryDaoImpl implements CategoryDao {

    @PersistenceContext(unitName = "goldroomPU")
    private EntityManager em;

    public List<Category> listAll() {
        return em.createNamedQuery("listAllCategory").getResultList();
    }

}
