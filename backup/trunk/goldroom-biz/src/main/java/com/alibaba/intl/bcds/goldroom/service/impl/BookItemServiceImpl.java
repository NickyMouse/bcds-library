/**
 * Project: goldroom-biz File Created at 2009-10-5 $Id$ Copyright 2008 Alibaba.com Croporation Limited. All rights
 * reserved. This software is the confidential and proprietary information of Alibaba Company.
 * ("Confidential Information"). You shall not disclose such Confidential Information and shall use it only in
 * accordance with the terms of the license agreement you entered into with Alibaba.com.
 */
package com.alibaba.intl.bcds.goldroom.service.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.alibaba.intl.bcds.goldroom.dao.BookInfoDao;
import com.alibaba.intl.bcds.goldroom.dao.BookItemDao;
import com.alibaba.intl.bcds.goldroom.dao.IntegralDao;
import com.alibaba.intl.bcds.goldroom.dao.LendingDao;
import com.alibaba.intl.bcds.goldroom.dao.ReservationDAO;
import com.alibaba.intl.bcds.goldroom.dataobject.BookInfo;
import com.alibaba.intl.bcds.goldroom.dataobject.BookItem;
import com.alibaba.intl.bcds.goldroom.dataobject.IntegralQuery;
import com.alibaba.intl.bcds.goldroom.dataobject.Lending;
import com.alibaba.intl.bcds.goldroom.dataobject.Member;
import com.alibaba.intl.bcds.goldroom.dataobject.Reservation;
import com.alibaba.intl.bcds.goldroom.mail.dataobject.EmailInfo;
import com.alibaba.intl.bcds.goldroom.mail.enumeration.ServiceType;
import com.alibaba.intl.bcds.goldroom.mail.service.SendMailService;
import com.alibaba.intl.bcds.goldroom.service.BookItemService;
import com.alibaba.intl.bcds.goldroom.service.result.Result;
import com.alibaba.intl.bcds.goldroom.util.MemberInfoCache;

/**
 * Comment of BookItemServiceImpl
 * 
 * @author Zimmem
 */
public class BookItemServiceImpl implements BookItemService {

    private BookItemDao     bookItemDao;
    private ReservationDAO  reservationDAO;
    private LendingDao      lendingDao;
    private MemberInfoCache memberInfoCache;
    private BookInfoDao     bookInfoDao;
    private IntegralDao     integralDao;
    private static Logger   logger = Logger.getLogger(BookItemServiceImpl.class);

    public void setMemberInfoCache(MemberInfoCache memberInfoCache) {
        this.memberInfoCache = memberInfoCache;
    }

    SendMailService sendMailService;

    public void setSendMailService(SendMailService sendMailService) {
        this.sendMailService = sendMailService;
    }

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

    public void setIntegralDao(IntegralDao integralDao) {
        this.integralDao = integralDao;
    }

    /*
     * (non-Javadoc)
     * @see com.alibaba.intl.bcds.goldroom.service.BookItemService#addBookItem(com
     * .alibaba.intl.bcds.goldroom.dataobject.BookItem)
     */
    @Override
    public void addBookItem(BookItem bookItem) {
        bookItemDao.insert(bookItem);
        IntegralQuery integralQuery = new IntegralQuery(bookItem.getLoginId());
        integralQuery.setAlterValue(50);
        int modifiedRows = this.integralDao.increaseIntegral(integralQuery);
        if (modifiedRows > 0) {
            logger.info("Successfully addBookItem integral 50, " + bookItem.getLoginId());
        } else {
            logger.warn("Failed to addBookItem integral 50, " + bookItem.getLoginId());
        }
    }

    /*
     * (non-Javadoc)
     * @see com.alibaba.intl.bcds.goldroom.service.BookItemService#newShelves(java .lang.String, java.lang.String)
     */
    @Override
    public void newShelves(String loginId, String isbn) {
        bookItemDao.addBookItem(loginId, isbn);

    }

    /*
     * (non-Javadoc)
     * @see com.alibaba.intl.bcds.goldroom.service.BookItemService#listBookItemsByLoginId (java.lang.String)
     */
    @Override
    public List<BookItem> listBookItemsByLoginId(String loginId) {
        return bookItemDao.listBookItemsByLoginId(loginId);
    }

    /*
     * (non-Javadoc)
     * @seecom.alibaba.intl.bcds.goldroom.service.BookItemService# listBookItemsByLoginIdAndState(java.lang.String,
     * java.lang.String)
     */
    @Override
    public Result listBookItemsByLoginIdAndState(String loginId, String state, int page, int pagesize) {

        Map<String, Object> returnMap = new HashMap<String, Object>(2);
        returnMap.put("totalCount", bookItemDao.countBookItemsByLoginIdAndState(loginId, state));
        returnMap.put("bookItemList", bookItemDao.listBookItemsByLoginIdAndState(loginId, state, page, pagesize));
        return new Result(true, null, returnMap);
    }

    /*
     * (non-Javadoc)
     * @seecom.alibaba.intl.bcds.goldroom.service.BookItemService# listBookItemByBookInfoId(int)
     */
    @Override
    public List<BookItem> listBookItemByBookInfoId(int bookInfoId) {
        return bookItemDao.listBookItemByBookInfoId(bookInfoId);
    }

    /*
     * (non-Javadoc)
     * @seecom.alibaba.intl.bcds.goldroom.service.BookItemService# listBookItemBySubscriber(java.lang.String)
     */
    @Override
    public Result listLendedBookItemBySubscriber(String ownerLoginID, int page, int pagesize) {
        Map<String, Object> returnMap = new HashMap<String, Object>(2);
        returnMap.put("totalCount", bookItemDao.countLendedBookItemBySubscriber(ownerLoginID));
        returnMap.put("bookItemList", bookItemDao.listLendedBookItemBySubscriber(ownerLoginID, page, pagesize));
        return new Result(true, null, returnMap);
    }

    /*
     * (non-Javadoc)
     * @seecom.alibaba.intl.bcds.goldroom.service.BookItemService# listReservatedBooksBySubscriber(java.lang.String)
     */
    @Override
    public Result listReservatedBooksBySubscriber(String loginId, int page, int pagesize) {

        Map<String, Object> returnMap = new HashMap<String, Object>(2);
        returnMap.put("totalCount", bookItemDao.countReservatedBooksBySubscriber(loginId));
        returnMap.put("bookItemList", bookItemDao.listReservatedBooksBySubscriber(loginId, page, pagesize));
        return new Result(true, null, returnMap);
    }

    /*
     * (non-Javadoc)
     * @see com.alibaba.intl.bcds.goldroom.service.BookItemService#reserve(java.lang .String, int)
     */
    @Override
    public Result reserve(String subscriber, int bookItemId, Date lendTime, Date returnTime) {
        BookItem item = bookItemDao.findById(bookItemId);
        if (item.getLoginId().equals(subscriber)) {
            // 不能预约自已的书
            return new Result(false);
        }
        if (item.getState().equals(BookItem.STATE_IDLE)) {
            if (reservationDAO.updateStateByBookItemId(bookItemId, Reservation.STATE_TO_BE_COMFIRM) == 0) {
                Reservation reservation = new Reservation();
                reservation.setOwnerId(item.getLoginId());
                reservation.setLendTime(lendTime);
                reservation.setReturnTime(returnTime);
                reservation.setBookItemId(bookItemId);
                reservation.setSubscriber(subscriber);
                reservation.setState(Reservation.STATE_TO_BE_COMFIRM);
                reservationDAO.insert(reservation);
                // 发送邮件
                Member owner = memberInfoCache.getMemberInfo(item.getLoginId());
                Member subcriber = memberInfoCache.getMemberInfo(reservation.getSubscriber());
                BookInfo bookInfo = bookInfoDao.findById(item.getBookInfoId());

                EmailInfo emailInfo = new EmailInfo(ServiceType.RESERVATION);
                emailInfo.setOwner(owner);
                emailInfo.setBorrower(subcriber);
                emailInfo.setBookInfo(bookInfo);
                emailInfo.setReservation(reservation);
                emailInfo.addReceiverEmail(owner.getEmail());
                sendMailService.sendMail(emailInfo);
            }
            // 书籍被预约
            IntegralQuery integralQuery = new IntegralQuery(item.getLoginId());
            integralQuery.setAlterValue(10);
            int modifiedRows = this.integralDao.increaseIntegral(integralQuery);
            if (modifiedRows > 0) {
                logger.info("Successfully reserve integral 10, " + item.getLoginId());
            } else {
                logger.warn("Failed to reserve integral 10, " + item.getLoginId());
            }

            item.setState(BookItem.STATE_RESERVATED);
            bookItemDao.updateById(item);
            return Result.SUCCESS;
        } else {
            return new Result(false);
        }
    }

   

    /*
     * (non-Javadoc)
     * @see com.alibaba.intl.bcds.goldroom.service.BookItemService#returnBook(int)
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

        BookInfo bookInfo = bookInfoDao.findById(bookItem.getBookInfoId());
        Member owner = memberInfoCache.getMemberInfo(bookItem.getLoginId());
        Member subcriber = memberInfoCache.getMemberInfo(lending.getSubscriber());
        EmailInfo emailInfo = new EmailInfo(ServiceType.CONFIRM_RETURN_BOOK);
        emailInfo.setOwner(owner);
        emailInfo.setBorrower(subcriber);
        emailInfo.setBookInfo(bookInfo);
        emailInfo.setLending(lending);
        emailInfo.addReceiverEmail(subcriber.getEmail());
        sendMailService.sendMail(emailInfo);

        return Result.SUCCESS;
    }

    @Override
    public Result offShelves(int bookItemId, String currentUser) {
        BookItem bookItem = bookItemDao.findById(bookItemId);
        if (bookItem == null || currentUser == null) {
            return new Result(false);
        } else {
            // 确定该书是属于currentUser的，并且这本书不处于借出（lended）这个状态
            if (currentUser.equals(bookItem.getLoginId()) && !BookItem.STATE_LENDED.equals(bookItem.getState())) {
                // 改变书籍状态
                bookItem.setState(BookItem.STATE_UNAVAILABLE);
                bookItemDao.changeItemState(bookItem);

                // 拒绝所有预约
                reservationDAO.updateStateByBookItemId(bookItem.getId(), Reservation.STATE_REJECT);

                return Result.SUCCESS;
            } else {
                return new Result(false);
            }
        }
    }

    @Override
    public Result reputOnShelves(int bookItemId, String currentUser) {
        BookItem bookItem = bookItemDao.findById(bookItemId);
        if (bookItem == null || currentUser == null) {
            return new Result(false);
        } else {
            // 确保该书是属于currentUser的，并且书的状态是UNAVAILABLE
            if (currentUser.equals(bookItem.getLoginId()) && BookItem.STATE_UNAVAILABLE.equals(bookItem.getState())) {
                bookItem.setState(BookItem.STATE_IDLE);
                bookItemDao.changeItemState(bookItem);
                return Result.SUCCESS;
            } else {
                return new Result(false);
            }
        }
    }

    @Override
    public Result lend(int reservationId, String currentUser) {
        Reservation reservation = reservationDAO.selectByPrimaryKey(reservationId);
        BookItem bookItem = bookItemDao.getBookItemByReservationId(reservationId);
        if (!bookItem.getLoginId().equals(currentUser)) {
            // 如果书的主人跟登录用户不同
            return new Result(false);
        }
        if (bookItem.getState().equals(BookItem.STATE_RESERVATED)) {

            Lending lending = new Lending();
            lending.setBookItemId(reservation.getBookItemId());
            lending.setReturnTime(reservation.getReturnTime());
            lending.setSubscriber(reservation.getSubscriber());
            lending.setLendTime(reservation.getLendTime());

            lendingDao.insert(lending);
            bookItem.setState(BookItem.STATE_LENDED);
            bookItemDao.changeItemState(bookItem);
            reservationDAO.cutReservationToLog(reservation);

            // 发送邮件
            Member owner = memberInfoCache.getMemberInfo(bookItem.getLoginId());
            Member subcriber = memberInfoCache.getMemberInfo(lending.getSubscriber());
            BookInfo bookInfo = bookInfoDao.findById(bookItem.getBookInfoId());

            // 书籍被借约
            IntegralQuery integralQuery = new IntegralQuery(bookItem.getLoginId());
            integralQuery.setAlterValue(50);
            int modifiedRows = this.integralDao.increaseIntegral(integralQuery);

            if (modifiedRows > 0) {
                logger.info("Successfully lend integral 50, " + bookItem.getLoginId());
            } else {
                logger.warn("Failed to lend integral 50, " + bookItem.getLoginId());
            }
            
            EmailInfo emailInfo = new EmailInfo(ServiceType.GET_BOOK);
            emailInfo.setOwner(owner);
            emailInfo.setBorrower(subcriber);
            emailInfo.setBookInfo(bookInfo);
            emailInfo.setLending(lending);
            emailInfo.addReceiverEmail(subcriber.getEmail());
            sendMailService.sendMail(emailInfo);

            return Result.SUCCESS;
        } else {
            return new Result(false);
        }
    }

    public Result rejectLend(int reservationId, String currentUser) {
        BookItem bookItem = bookItemDao.getBookItemByReservationId(reservationId);

        // 如果书的主人跟登录用户不同 或者该书不在预约状态
        if (bookItem == null || !bookItem.getLoginId().equals(currentUser)
            || !BookItem.STATE_RESERVATED.equals(bookItem.getState())) {
            return new Result(false);
        }
        reservationDAO.updateStateByBookItemId(bookItem.getId(), Reservation.STATE_REJECT);
        bookItem.setState(BookItem.STATE_IDLE);
        bookItemDao.updateById(bookItem);

        Reservation reservation = reservationDAO.selectByPrimaryKey(reservationId);
        if (reservation != null) {
            BookInfo bookInfo = bookInfoDao.findById(bookItem.getBookInfoId());
            Member owner = memberInfoCache.getMemberInfo(reservation.getOwnerId());
            Member subcriber = memberInfoCache.getMemberInfo(reservation.getSubscriber());

            EmailInfo emailInfo = new EmailInfo(ServiceType.REJECT_LEND_BOOK);
            emailInfo.setOwner(owner);
            emailInfo.setBorrower(subcriber);
            emailInfo.setBookInfo(bookInfo);
            emailInfo.setReservation(reservation);
            emailInfo.addReceiverEmail(subcriber.getEmail());
            sendMailService.sendMail(emailInfo);
        }

        return Result.SUCCESS;
    }

    /*
     * (non-Javadoc)
     * @seecom.alibaba.intl.bcds.goldroom.service.BookItemService# getBookDetailByIdAndOwner(java.lang.String, int)
     */
    @Override
    public BookItem getBookDetailByIdAndOwner(String owner, int bookItemId) {
        BookItem bookItem = bookItemDao.getBookItemWithAllInfo(bookItemId);
        if (bookItem != null && bookItem.getLoginId().equals(owner)) {
            return bookItem;
        }
        return bookItem;
    }

    /*
     * (non-Javadoc)
     * @see com.alibaba.intl.bcds.goldroom.service.BookItemService#deleteBookItem (int)
     */
    @Override
    public void deleteBookItem(int id, String loginId) {
        BookItem bookItem = bookItemDao.findById(id);
        if (bookItem.getState().equals(BookItem.STATE_UNAVAILABLE) && loginId.equals(bookItem.getLoginId())) {
            bookItemDao.deleteById(id);
        }

    }

    public void setBookInfoDao(BookInfoDao bookInfoDao) {
        this.bookInfoDao = bookInfoDao;
    }

    @Override
    public List<BookItem> listBookItemsByLoginIdAndStateAndBookInfoIds(String loginId, String state,
                                                                       List<Integer> bookInfoIds) {
        return bookItemDao.listBookItemsByLoginIdAndStateAndBookInfoIds(loginId, state, bookInfoIds);

    }
}
