package com.alibaba.intl.bcds.goldroom.service;

import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.alibaba.intl.bcds.goldroom.constaints.AdminConfigTypeEnum;
import com.alibaba.intl.bcds.goldroom.dao.AdminConfigDao;
import com.alibaba.intl.bcds.goldroom.dataobject.AdminConfig;

@Transactional
public class AdminConfigService {

    @Autowired
    private AdminConfigDao adminConfigDao;

    public String getAnnouncement() {
        List<AdminConfig> configs = adminConfigDao.listByType(AdminConfigTypeEnum.ANNOUNCEMENT.getValue());
        if (configs.size() > 0) {
            return configs.get(0).getConfig();
        } else {
            return StringUtils.EMPTY;
        }
    }

    public boolean setAnnouncement(String announcement) {
        return adminConfigDao.updateConfig(AdminConfigTypeEnum.ANNOUNCEMENT.getValue(), announcement);
    }
}
