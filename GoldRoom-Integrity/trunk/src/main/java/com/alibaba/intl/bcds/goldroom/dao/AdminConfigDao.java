package com.alibaba.intl.bcds.goldroom.dao;

import java.util.List;

import com.alibaba.intl.bcds.goldroom.dataobject.AdminConfig;


public interface AdminConfigDao {

    List<AdminConfig> listByType(String type);

    
    boolean updateConfig(String type, String config);
}
