/**
 * Project: goldroom-web
 * 
 * File Created at 2009-10-5
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
package com.alibaba.intl.bcds.goldroom.web.test.mock;

import com.alibaba.intl.bcds.goldroom.dataobject.BookInfo;
import com.alibaba.intl.bcds.goldroom.service.BookInfoService;
import com.alibaba.intl.bcds.goldroom.service.result.Result;

/**
 * TODO Comment of BookInfoServiceMock
 * 
 * @author Zimmem
 */
public class BookInfoServiceMock implements BookInfoService {

    /*
     * (non-Javadoc)
     * @see
     * com.alibaba.intl.bcds.goldroom.biz.BookInfoService#findBookInfoByIsbn()
     */
    @Override
    public BookInfo findBookInfoByIsbn(String isbn) {
        if (!isbn.equals("100000000")) {
            return null;
        } else {
            BookInfo info = new BookInfo();
            info.setIsbn("100000000");
            return info;
        }
    }

    /*
     * (non-Javadoc)
     * @see
     * com.alibaba.intl.bcds.goldroom.service.BookInfoService#addBookInfo(com
     * .alibaba.intl.bcds.goldroom.dataobject.BookInfo)
     */
    @Override
    public Result addBookInfo(BookInfo bookInfo) {
        // TODO Auto-generated method stub
    	return null;
    }

    /*
     * (non-Javadoc)
     * @see
     * com.alibaba.intl.bcds.goldroom.service.BookInfoService#findBookInfoById
     * (int)
     */
    @Override
    public BookInfo findBookInfoById(int id) {
        // TODO Auto-generated method stub
        return null;
    }

}
