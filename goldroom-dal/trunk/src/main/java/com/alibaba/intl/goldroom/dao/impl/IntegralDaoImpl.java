package com.alibaba.intl.goldroom.dao.impl;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.beans.BeanUtils;

import com.alibaba.intl.goldroom.dao.IntegralDao;
import com.alibaba.intl.goldroom.dataobject.Integral;

@SuppressWarnings("unchecked")
public class IntegralDaoImpl implements IntegralDao {

    @PersistenceContext(unitName = "goldroomPU")
    private EntityManager em;

    public Integral save(Integral integral) {
        integral.setId(null);
        Date now = new Date();
        integral.setGmtCreate(now);
        integral.setGmtModified(now);
        em.persist(integral);
        return integral;
    }

    public boolean updateByLoginId(Integral integral) {
        Integral i = em.find(Integral.class, integral.getLoginId());
        if (i == null) {
            return false;
        }
        BeanUtils.copyProperties(integral, i);
        i.setGmtModified(new Date());
        em.merge(i);
        return true;
    }

    

    public Integral findByLoginId(String loginId) {
        return em.find(Integral.class, loginId);
    }

    public List<Integral> listAllIntegral(int page, int pageSize) {
        Query q = em.createNamedQuery("listAllIntegral");
        return q.setFirstResult((page - 1) * pageSize).setMaxResults(pageSize).getResultList();
    }
}
