package com.alibaba.intl.bcds.goldroom.dao.impl;

import java.util.Collection;

import com.alibaba.intl.bcds.goldroom.dao.BaseDao;
import com.alibaba.intl.bcds.goldroom.dao.TracelogDao;
import com.alibaba.intl.bcds.goldroom.dataobject.Tracelog;

public class TracelogDaoImpl extends BaseDao implements TracelogDao {

    public void saveAll(Collection<Tracelog> tracelogs) {
        this.saveOrUpdateAll(tracelogs);
    }

    public void save(Tracelog tracelog) {
        super.save(tracelog);
    }
}
