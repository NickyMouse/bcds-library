package com.alibaba.intl.bcds.goldroom.dao.impl;

import java.util.Date;
import java.util.List;

import org.hibernate.Query;

import com.alibaba.intl.bcds.goldroom.dao.AdminConfigDao;
import com.alibaba.intl.bcds.goldroom.dao.BaseDao;
import com.alibaba.intl.bcds.goldroom.dataobject.AdminConfig;

@SuppressWarnings("unchecked")
public class AdminConfigDaoImpl extends BaseDao implements AdminConfigDao {


    public List<AdminConfig> listByType(String type) {
        Query q = this.createNamedQuery("listConfigByType");
        q.setParameter("type", type);
        return q.list();
    }

    public boolean updateConfig(String type, String config) {
        Query q = this.createNamedQuery("listConfigByType");
        q.setParameter("type", type);

        List<AdminConfig> configs = q.list();
        if (configs.size() == 0) {
            return false;
        }
        Date now = new Date();
        for (AdminConfig c : configs) {
            c.setGmtModified(now);
            c.setConfig(config);
            this.update(c);
        }
        return true;
    }

}
