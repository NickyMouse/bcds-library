package com.alibaba.intl.goldroom.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.alibaba.intl.goldroom.dao.AdminConfigDao;
import com.alibaba.intl.goldroom.dataobject.AdminConfig;

@SuppressWarnings("unchecked")
public class AdminConfigDaoImpl implements AdminConfigDao {

    @PersistenceContext(unitName = "goldroomPU")
    private EntityManager em;

    public List<AdminConfig> listByType(String type) {
        Query q = em.createNamedQuery("listConfigByType");
        q.setParameter("type", type);
        return q.getResultList();
    }

}
