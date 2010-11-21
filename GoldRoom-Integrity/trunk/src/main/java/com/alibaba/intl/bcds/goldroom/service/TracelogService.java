package com.alibaba.intl.bcds.goldroom.service;

import com.alibaba.intl.bcds.goldroom.dao.TracelogDao;
import com.alibaba.intl.bcds.goldroom.dataobject.Tracelog;

public class TracelogService {

    private TracelogDao tracelogDao;

    public void saveTracelog(Tracelog tl) {
        getTracelogDao().save(tl);
    }

    public void setTracelogDao(TracelogDao tracelogDao) {
        this.tracelogDao = tracelogDao;
    }

    public TracelogDao getTracelogDao() {
        return tracelogDao;
    }

}
