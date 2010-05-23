package com.alibaba.intl.goldroom.dao;

import java.util.List;

import com.alibaba.intl.goldroom.dataobject.AdminConfig;

public interface AdminConfigDao {

    List<AdminConfig> listByType(String type);

    
    boolean updateConfig(String type, String config);
}
