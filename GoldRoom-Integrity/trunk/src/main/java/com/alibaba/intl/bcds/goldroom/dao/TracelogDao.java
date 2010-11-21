package com.alibaba.intl.bcds.goldroom.dao;

import java.util.Collection;

import com.alibaba.intl.bcds.goldroom.dataobject.Tracelog;

public interface TracelogDao {

    void saveAll(Collection<Tracelog> tracelogs);

    void save(Tracelog tracelog);
}
