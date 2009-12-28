/**
 * Project: goldroom-biz
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
package com.alibaba.intl.bcds.goldroom.service.impl;

import com.alibaba.intl.bcds.goldroom.dao.BookInfoDao;
import com.alibaba.intl.bcds.goldroom.dataobject.BookInfo;
import com.alibaba.intl.bcds.goldroom.service.BookInfoService;
import com.alibaba.intl.bcds.goldroom.service.result.Result;

/**
 * TODO Comment of BookInfoServiceImpl
 * 
 * @author Zimmem
 */
public class BookInfoServiceImpl implements BookInfoService {

    private BookInfoDao bookInfoDao;

    /**
     * @param bookInfoDao the bookInfoDao to set
     */
    public void setBookInfoDao(BookInfoDao bookInfoDao) {
        this.bookInfoDao = bookInfoDao;
    }

    /*
     * (non-Javadoc)
     * @see
     * com.alibaba.intl.bcds.goldroom.service.BookInfoService#findBookInfoByIsbn
     * (java.lang.String)
     */
    @Override
    public BookInfo findBookInfoByIsbn(String isbn) {
        //通过isbn查询书的信息
        return bookInfoDao.findBookInfoByIsbn(isbn);

    }

    /*
     * (non-Javadoc)
     * @see
     * com.alibaba.intl.bcds.goldroom.service.BookInfoService#addBookInfo(com
     * .alibaba.intl.bcds.goldroom.dataobject.BookInfo)
     */
    @Override
    public Result addBookInfo(BookInfo bookInfo) {
        if (bookInfoDao.findBookInfoByIsbn(bookInfo.getIsbn()) != null) {
            return new Result(false);
        }
        bookInfoDao.insert(bookInfo);
        return Result.SUCCESS;
    }

    /*
     * (non-Javadoc)
     * @see
     * com.alibaba.intl.bcds.goldroom.service.BookInfoService#findBookInfoById
     * (int)
     */
    @Override
    public BookInfo findBookInfoById(int id) {
        return bookInfoDao.findById(id);
    }

}
