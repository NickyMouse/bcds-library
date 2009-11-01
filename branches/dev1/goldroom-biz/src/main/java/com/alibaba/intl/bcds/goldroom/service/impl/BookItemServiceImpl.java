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
import com.alibaba.intl.bcds.goldroom.dao.LendingDao;
import com.alibaba.intl.bcds.goldroom.dao.ReservationDAO;
import com.alibaba.intl.bcds.goldroom.dataobject.BookItem;
import com.alibaba.intl.bcds.goldroom.dataobject.Lending;
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
    LendingDao     lendingDao;

    /**
     * @param lendingDao the lendingDao to set
     */
    public void setLendingDao(LendingDao lendingDao) {
        this.lendingDao = lendingDao;
    }

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
        if (item.getLoginId().equals(subscriber)) {
            //不能预约自已的书
            return new Result(false);
        }
        if (item.getState().equals(BookItem.STATE_IDLE)) {

            Reservation reservation = new Reservation();
            reservation.setBookItemId(bookItemId);
            reservation.setSubscriber(subscriber);
            reservationDAO.insert(reservation);
            item.setState(BookItem.STATE_RESERVATED);
            bookItemDao.updateById(item);
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
    public Result lend(int reservationId, Date lendTime, Date returnTime, String currentUser) {
        Reservation reservation = reservationDAO.selectByPrimaryKey(reservationId);
        BookItem bookItem = bookItemDao.getBookItemByReservationId(reservationId);
        if (!bookItem.getLoginId().equals(currentUser)) {
            //如果书的主人跟登录用户不同
            return new Result(false);
        }
        if (bookItem.getState().equals(BookItem.STATE_RESERVATED)) {

            Lending lending = new Lending();
            lending.setBookItemId(reservation.getBookItemId());
            lending.setReturnTime(returnTime);
            lending.setSubscriber(reservation.getSubscriber());
            lendingDao.insert(lending);
            bookItem.setState(BookItem.STATE_LENDED);
            bookItemDao.changeItemState(bookItem);
            reservationDAO.cutReservationToLog(reservation);
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
    public Result returnBook(int lendId, String currentUser) {

        Lending lending = lendingDao.findById(lendId);
        BookItem bookItem = bookItemDao.findById(lending.getBookItemId());
        if (!bookItem.getLoginId().equals(currentUser)) {
            return new Result(false);
        }
        lendingDao.cutLendingToLog(lending);
        lendingDao.updateRealReturnTime(lendId);
        bookItem.setState(BookItem.STATE_IDLE);
        bookItemDao.changeItemState(bookItem);
        return Result.SUCCESS;
    }
}
