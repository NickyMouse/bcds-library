package com.alibaba.intl.goldroom.service;

import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.flex.remoting.RemotingDestination;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.alibaba.intl.goldroom.constaints.AdminConfigTypeEnum;
import com.alibaba.intl.goldroom.dao.AdminConfigDao;
import com.alibaba.intl.goldroom.dataobject.AdminConfig;

@Service
@RemotingDestination
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
}
