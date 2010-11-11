/**
 * Project: goldroom-dal File Created at 2009-10-24 $Id$ Copyright 2008 Alibaba.com Croporation Limited. All rights
 * reserved. This software is the confidential and proprietary information of Alibaba Company.
 * ("Confidential Information"). You shall not disclose such Confidential Information and shall use it only in
 * accordance with the terms of the license agreement you entered into with Alibaba.com.
 */
package com.alibaba.intl.bcds.goldroom.dao.impl;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.alibaba.intl.bcds.goldroom.dao.BaseDao;
import com.alibaba.intl.bcds.goldroom.dao.LendingDao;
import com.alibaba.intl.bcds.goldroom.dataobject.Lending;

@SuppressWarnings("unchecked")
public class LendingDaoImpl extends BaseDao implements LendingDao {

//    @PersistenceContext(unitName = "goldroomPU")
    private EntityManager em;

    public Lending save(Lending lending) {
        lending.setId(null);
        Date now = new Date();
        lending.setGmtCreate(now);
        lending.setGmtModified(now);
        em.persist(lending);
        return lending;
    }

    public boolean cutLendingToLog(int lendId) {
        Query q = em.createNamedQuery("deleteLendingById");
        q.setParameter("id", lendId);
        int resultCount = q.executeUpdate();
        return resultCount > 0 ? true : false;
    }

    public boolean cutLendingToLog(Lending lending) {
        Query q = em.createNamedQuery("deleteLendingById");
        q.setParameter("id", lending.getId());
        int resultCount = q.executeUpdate();
        return resultCount > 0 ? true : false;
    }

    public Lending findById(int lendId) {
        return em.find(Lending.class, lendId);
    }

    public boolean updateRealReturnTime(int lendingId) {
        Lending l = em.find(Lending.class, lendingId);
        if (l == null) {
            return false;
        }
        l.setRealReturnTime(new Date());
        em.merge(l);
        return true;
    }

    public List<Lending> listLendingByLoginId(String loginId, int page, int pageSize) {
        Query q = em.createNamedQuery("listLendingByLoginId");
        q.setParameter("loginId", loginId);
        return q.setFirstResult((page - 1) * pageSize).setMaxResults(pageSize).getResultList();
    }

    public List<Lending> listByLoginId(String loginId, int page, int pageSize) {
        Query q = em.createNamedQuery("listLendingByLoginId");
        q.setParameter("loginId", loginId);
        return q.setFirstResult((page - 1) * pageSize).setMaxResults(pageSize).getResultList();
    }

    public int countByLogindId(String loginId) {
        Query q = em.createNamedQuery("countLendingByLoginId");
        q.setParameter("loginId", loginId);
        return ((Long) q.getSingleResult()).intValue();
    }

    public int countByBookItemId(Integer bookItemId) {
        Query q = em.createNamedQuery("countLendingByBookItemId");
        q.setParameter("bookItemId", bookItemId);
        return ((Long) q.getSingleResult()).intValue();
    }

    public List<Lending> listByBookItemId(Integer bookItemId) {
        Query q = em.createNamedQuery("listLendingByBookItemId");
        q.setParameter("bookItemId", bookItemId);
        return q.getResultList();
    }
}
