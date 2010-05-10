/**
 * Project: goldroom-biz
 * 
 * File Created at 2009-12-12
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
package com.alibaba.intl.bcds.goldroom.service;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.alibaba.intl.bcds.goldroom.dataobject.BookInfo;
import com.alibaba.intl.bcds.goldroom.service.test.BaseTest;

/**
 * TODO Comment of BookInfoServiceTest
 * 
 * @author Zimmem
 */
public class BookInfoServiceTest extends BaseTest {

    @Autowired
    private BookInfoService bookInfoService;

    /**
     * Test method for
     * {@link com.alibaba.intl.bcds.goldroom.service.BookInfoService#getBookInfoFromDbAndNetWork(java.lang.String)}
     * .
     */
    @Test
    public void testGetBookInfoFromDbAndNetWork() {
        BookInfo info = bookInfoService.getBookInfoFromDbAndNetWork("9787508616780");
        assertNotNull(info);
    }

}
