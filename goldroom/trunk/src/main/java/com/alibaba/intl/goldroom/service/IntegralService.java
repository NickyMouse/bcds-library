package com.alibaba.intl.goldroom.service;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.alibaba.intl.goldroom.dao.IntegralDao;
import com.alibaba.intl.goldroom.dataobject.Integral;

@Transactional
public class IntegralService {

    private static Logger   logger = Logger.getLogger(IntegralService.class);

    @Autowired
    private IntegralDao     integralDao;

    public List<Integral> listAll(int page, int pageSize){
        return integralDao.listAllIntegral(page, pageSize);
    }
}
