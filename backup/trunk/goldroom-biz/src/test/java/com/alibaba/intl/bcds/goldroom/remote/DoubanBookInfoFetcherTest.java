/**
 * Project: goldroom-web
 * 
 * File Created at 2009-12-6
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
package com.alibaba.intl.bcds.goldroom.remote;

import static org.junit.Assert.*;

import org.junit.Test;

import com.alibaba.intl.bcds.goldroom.dataobject.BookInfo;

/**
 * TODO Comment of DoubanBookInfoFetcherTest
 * 
 * @author Zimmem
 */
public class DoubanBookInfoFetcherTest {

    /**
     * Test method for
     * {@link com.alibaba.intl.bcds.goldroom.remote.DoubanBookInfoFetcher#fetch(java.lang.String)}
     * .
     */
    @Test
    public void testFetch() {
        DoubanBookInfoFetcher fetcher = new DoubanBookInfoFetcher();
        fetcher.setFetchUrl("http://api.douban.com/book/subject/isbn/");
        BookInfo info = fetcher.fetch("9787121025389");
        assertNotNull(info);
        System.out.println(info);
    }

}
