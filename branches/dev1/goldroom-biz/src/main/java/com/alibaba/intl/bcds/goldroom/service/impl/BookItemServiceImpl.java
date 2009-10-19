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

import java.util.List;

import com.alibaba.intl.bcds.goldroom.dao.BookItemDao;
import com.alibaba.intl.bcds.goldroom.dataobject.BookInfo;
import com.alibaba.intl.bcds.goldroom.dataobject.BookItem;
import com.alibaba.intl.bcds.goldroom.service.BookItemService;

/**
 * TODO Comment of BookItemServiceImpl
 * 
 * @author Zimmem
 */
public class BookItemServiceImpl implements BookItemService {

    BookItemDao bookItemDao;

    /**
     * @param bookItemDao the bookItemDao to set
     */
    public void setBookItemDao(BookItemDao bookItemDao) {
        this.bookItemDao = bookItemDao;
    }

    /*
     * (non-Javadoc)
     * @see
     * com.alibaba.intl.bcds.goldroom.service.BookItemService#addBookItem(com
     * .alibaba.intl.bcds.goldroom.dataobject.BookItem)
     */
    @Override
    public void addBookItem(BookItem bookItem) {
        bookItemDao.insert(bookItem);

    }

    /*
     * (non-Javadoc)
     * @see
     * com.alibaba.intl.bcds.goldroom.service.BookItemService#newShelves(java
     * .lang.String, java.lang.String)
     */
    @Override
    public void newShelves(String loginId, String isbn) {
        bookItemDao.addBookItem(loginId, isbn);

    }

    /*
     * (non-Javadoc)
     * @see
     * com.alibaba.intl.bcds.goldroom.service.BookItemService#listBookItemsByLoginId
     * (java.lang.String)
     */
    @Override
    public List<BookItem> listBookItemsByLoginId(String loginId) {
        return bookItemDao.listBookItemsByLoginId(loginId);
    }

    /*
     * (non-Javadoc)
     * @seecom.alibaba.intl.bcds.goldroom.service.BookItemService#
     * listBookItemsByLoginIdAndState(java.lang.String, java.lang.String)
     */
    @Override
    public List<BookItem> listBookItemsByLoginIdAndState(String loginId, String state) {
        return bookItemDao.listBookItemsByLoginIdAndState(loginId, state);
    }

    /*
     * (non-Javadoc)
     * @seecom.alibaba.intl.bcds.goldroom.service.BookItemService#
     * listBookItemByBookInfoId(int)
     */
    @Override
    public List<BookItem> listBookItemByBookInfoId(int bookInfoId) {
        return bookItemDao.listBookItemByBookInfoId(bookInfoId);
    }

    /*
     * (non-Javadoc)
     * @seecom.alibaba.intl.bcds.goldroom.service.BookItemService#
     * listBookItemBySubscriber(java.lang.String)
     */
    @Override
    public List<BookItem> listLendedBookItemBySubscriber(String ownerLoginID) {
        return bookItemDao.listLendedBookItemBySubscriber(ownerLoginID);
    }

    /*
     * (non-Javadoc)
     * @seecom.alibaba.intl.bcds.goldroom.service.BookItemService#
     * listReservatedBooksBySubscriber(java.lang.String)
     */
    @Override
    public List<BookItem> listReservatedBooksBySubscriber(String loginId) {
        return bookItemDao.listReservatedBooksBySubscriber(loginId);
    }
}
