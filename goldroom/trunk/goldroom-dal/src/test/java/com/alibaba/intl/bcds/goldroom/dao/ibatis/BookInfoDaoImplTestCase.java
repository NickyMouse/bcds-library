/**
 * Project: goldroom-dal
 * 
 * File Created at 2009-10-17
 * $Id$
 * 
 * Copyright 2008 Alibaba.com Croporation Limited.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information of
 * Alibaba Company. ("Confidential Information").  You shall not
 * disclose such Confidential Information and shall use it only in
 * accordance with the terms of the license agreement you entered into
 * with Alibaba.com.
 */
package com.alibaba.intl.bcds.goldroom.dao.ibatis;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.alibaba.intl.bcds.goldroom.dao.BookItemDao;
import com.alibaba.intl.bcds.goldroom.dao.test.BaseTest;
import com.alibaba.intl.bcds.goldroom.dataobject.BookItem;

/**
 * TODO Comment of BookInfoDaoImplTestCase
 * 
 * @author Zimmem
 */
public class BookInfoDaoImplTestCase extends BaseTest {

    /**
     * @throws java.lang.Exception
     */
    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
    }

    /**
     * @throws java.lang.Exception
     */
    @AfterClass
    public static void tearDownAfterClass() throws Exception {
    }

    /**
     * @throws java.lang.Exception
     */
    @Before
    public void setUp() throws Exception {
    }

    /**
     * @throws java.lang.Exception
     */
    @After
    public void tearDown() throws Exception {
    }

    @Autowired
    private BookItemDao bookItemDao;

    @Test
    public void testGetBookItemWithInfoById() {
        BookItem item = bookItemDao.getBookItemWithInfoById(16);
        assertNotNull(item.getBookInfo());
        System.out.println(item.getBookInfo().getName());
    }

    @Test
    public void testListBookItemsByLoginIdAndState() {
        List<BookItem> list = bookItemDao.listBookItemsByLoginIdAndState("zhaowen.zhuangzw", null, 0, 0);
        assertNotNull(list.get(3).getBookInfo());
        System.out.println(list.get(3).getBookInfo().getName());
    }
}
