package com.alibaba.intl.bcds.goldroom.dao.impl;

import java.util.Date;
import java.util.List;

import org.hibernate.Query;

import com.alibaba.intl.bcds.goldroom.dao.BaseDao;
import com.alibaba.intl.bcds.goldroom.dao.LendingLogDao;
import com.alibaba.intl.bcds.goldroom.dataobject.LendingLog;

public class LendingLogDaoImpl extends BaseDao implements LendingLogDao {

    @Override
    public List<LendingLog> listLendingLogByBookInfoId(int bookInfoId) {
        Query q = this.createNamedQuery("listLendingLogByBookInfoId");
        q.setParameter("bookInfoId", bookInfoId);
        return q.list();
    }

    @Override
    public int countLendingLogByBookInfoId(int bookInfoId) {
        Query q = this.createNamedQuery("countLendingLogByBookInfoId");
        q.setParameter("bookInfoId", bookInfoId);
        return ((Long) q.list().get(0)).intValue();
    }

    @Override
    public List<LendingLog> listLendingLogByLoginId(String loginId, int page, int pageSize) {
        Query q = this.createNamedQuery("listLendingLogByLoginId");
        q.setParameter("loginId", loginId);
        return q.setFirstResult((page - 1) * pageSize).setMaxResults(pageSize).list();
    }

    @Override
    public int countLendingLogByLoginId(String loginId) {
        Query q = this.createNamedQuery("countLendingLogByLoginId");
        q.setParameter("loginId", loginId);
        return ((Long) q.list().get(0)).intValue();
    }

    @Override
    public LendingLog save(LendingLog lendingLog) {
        lendingLog.setId(null);
        Date now = new Date();
        lendingLog.setGmtCreate(now);
        lendingLog.setGmtModified(now);
        super.save(lendingLog);
        return lendingLog;
    }

}
