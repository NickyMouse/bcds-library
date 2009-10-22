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

import java.util.Date;
import java.util.List;

import com.alibaba.intl.bcds.goldroom.dao.BookItemDao;
import com.alibaba.intl.bcds.goldroom.dao.ReservationDAO;
import com.alibaba.intl.bcds.goldroom.dataobject.BookItem;
import com.alibaba.intl.bcds.goldroom.dataobject.Reservation;
import com.alibaba.intl.bcds.goldroom.service.BookItemService;
import com.alibaba.intl.bcds.goldroom.service.result.Result;

/**
 * TODO Comment of BookItemServiceImpl
 * 
 * @author Zimmem
 */
public class BookItemServiceImpl implements BookItemService {

    BookItemDao    bookItemDao;
    ReservationDAO reservationDAO;

    /**
     * @param reservationDAO the reservationDAO to set
     */
    public void setReservationDAO(ReservationDAO reservationDAO) {
        this.reservationDAO = reservationDAO;
    }

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

    /*
     * (non-Javadoc)
     * @see
     * com.alibaba.intl.bcds.goldroom.service.BookItemService#reserve(java.lang
     * .String, int)
     */
    @Override
    public Result reserve(String subscriber, int bookItemId) {
        BookItem item = bookItemDao.findById(bookItemId);
        if (item.getState().equals(BookItem.STATE_IDLE)) {

            Reservation reservation = new Reservation();
            reservation.setBookItemId(bookItemId);
            reservation.setSubscriberId(subscriber);
            reservationDAO.insert(reservation);
            //TODO 往reservation里添加预约信息
            //TODO 改不改书的状态？
            return Result.SUCCESS;
        } else {
            return new Result(false);
        }
    }

    /*
     * (non-Javadoc)
     * @see com.alibaba.intl.bcds.goldroom.service.BookItemService#lend(int,
     * java.util.Date, java.util.Date)
     */
    @Override
    public Result lend(int reservationId, Date lendTime, Date returnTime) {
        Reservation reservation = reservationDAO.selectByPrimaryKey(reservationId);
        BookItem bookItem = bookItemDao.getBookItemByReservationId(reservationId);
        if (bookItem.getState().equals(BookItem.STATE_IDLE)) {
            //TODO 
            //TODO 把预约信息迁至log表?
            //TODO 添加借阅信息
            bookItem.setState(BookItem.STATE_LENDED);
            bookItemDao.updateById(bookItem);
            return Result.SUCCESS;
        } else {
            return new Result(false);
        }

    }

    /*
     * (non-Javadoc)
     * @see
     * com.alibaba.intl.bcds.goldroom.service.BookItemService#returnBook(int)
     */
    @Override
    public Result returnBook(int lendId) {
        //TODO 把借阅信息迁到log表
        //TODO 更改书本状态 
        //
        return new Result(false);
    }
}
