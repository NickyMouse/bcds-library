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
import com.alibaba.intl.bcds.goldroom.remote.BookInfoFetcher;
import com.alibaba.intl.bcds.goldroom.service.BookInfoService;
import com.alibaba.intl.bcds.goldroom.service.result.Result;

/**
 * TODO Comment of BookInfoServiceImpl
 * 
 * @author Zimmem
 */
public class BookInfoServiceImpl implements BookInfoService {

    private BookInfoDao     bookInfoDao;

    private BookInfoFetcher bookInfoFetcher;

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
        int id = bookInfoDao.insert(bookInfo);
        bookInfo.setId(id);
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

    /*
     * (non-Javadoc)
     * @seecom.alibaba.intl.bcds.goldroom.service.BookInfoService#
     * getBookInfoFromDbAndNetWork(java.lang.String)
     */
    @Override
    public BookInfo getBookInfoFromDbAndNetWork(String isbn) {
        BookInfo bookInfo = bookInfoDao.findBookInfoByIsbn(isbn);
        if (bookInfo == null) {
            bookInfo = bookInfoFetcher.fetch(isbn);
            if (bookInfo != null) {
                bookInfoDao.insert(bookInfo);
            }
        }
        return bookInfo;
    }

    /**
     * @param bookInfoFetcher the bookInfoFetcher to set
     */
    public void setBookInfoFetcher(BookInfoFetcher bookInfoFetcher) {
        this.bookInfoFetcher = bookInfoFetcher;
    }

    /**
     * @return the bookInfoFetcher
     */
    public BookInfoFetcher getBookInfoFetcher() {
        return bookInfoFetcher;
    }

    /*
     * (non-Javadoc)
     * @see
     * com.alibaba.intl.bcds.goldroom.service.BookInfoService#updateCategory
     * (com.alibaba.intl.bcds.goldroom.dataobject.BookInfo)
     */
    @Override
    public void updateCategory(BookInfo bookInfo) {
        bookInfoDao.updateCategory(bookInfo);

    }

}
