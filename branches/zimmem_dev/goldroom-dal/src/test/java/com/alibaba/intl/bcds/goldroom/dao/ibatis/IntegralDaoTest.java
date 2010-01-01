package com.alibaba.intl.bcds.goldroom.dao.ibatis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import com.alibaba.intl.bcds.goldroom.dao.IntegralDao;
import com.alibaba.intl.bcds.goldroom.dao.test.BaseTest;

@Transactional()
@TransactionConfiguration(defaultRollback = true)
public class IntegralDaoTest extends BaseTest {
	
    @Autowired
    IntegralDao integralDao;
    
}
