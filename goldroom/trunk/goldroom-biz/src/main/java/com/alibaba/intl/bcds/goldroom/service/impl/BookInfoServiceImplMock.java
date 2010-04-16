/**
 * Project: goldroom-biz
 * 
 * File Created at 2009-11-24
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
package com.alibaba.intl.bcds.goldroom.service.impl;

import java.util.Date;

import com.alibaba.intl.bcds.goldroom.dataobject.BookInfo;

/**
 * TODO Comment of BookInfoServiceImplMock
 * 
 * @author Zimmem
 */
public class BookInfoServiceImplMock extends BookInfoServiceImpl {

    @Override
    public BookInfo findBookInfoByIsbn(String isbn) {
        BookInfo info = new BookInfo();
        info.setIsbn(isbn);

        info.setAuthor("author");
        info.setDescription("description");
        info.setEdition("1");
        info.setGmtCreate(new Date());
        info.setName("book_name");
        info.setId(1);
        info.setPublisher("publisher");
        if (isbn.equals("exsit_in_db")) {
            info.setCategoryId(234);
        } else if (isbn.equals("not_exsit")) {
            return null;
        }
        return info;
    }
}
