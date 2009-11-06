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
package com.alibaba.intl.bcds.goldroom.service;

import java.util.Date;
import java.util.List;

import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.alibaba.intl.bcds.goldroom.dataobject.BookItem;
import com.alibaba.intl.bcds.goldroom.service.result.Result;

/**
 * TODO Comment of BookItemService
 * 
 * @author Zimmem
 */
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public interface BookItemService {
    /**
     *添加图书
     * 
     * @param bookInfo
     */
    void addBookItem(BookItem bookItem);

    /**
     * 新书上架
     * 
     * @param loginId
     * @param isbn
     */
    void newShelves(String loginId, String isbn);

    /**
     * 通过loginId查找bookitem
     * 
     * @param loginId
     * @return
     */
    List<BookItem> listBookItemsByLoginId(String loginId);

    /**
     * 通过loginId和state查找bookitem
     * 
     * @param loginId
     * @return
     */
    Result listBookItemsByLoginIdAndState(String loginId, String state, int page,
                                                  int pagesize);

    /**
     * @param bookInfoId
     * @return
     */
    List<BookItem> listBookItemByBookInfoId(int bookInfoId);

    /**
     * @param ownerLoginID
     * @return
     */
    Result listLendedBookItemBySubscriber(String ownerLoginID, int page, int pagesize);

    /**
     * @param loginId
     * @return
     */
    Result listReservatedBooksBySubscriber(String loginId, int page, int pagesize);

    /**
     * 预约
     * 
     * @param subscriber
     * @param bookItemId
     */
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    Result reserve(String subscriber, int bookItemId);

    /**
     * 还书
     * 
     * @param lendId
     */
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    Result returnBook(int lendId, String currentUser);

    /**
     * 确定借书
     * 
     * @param reservationId
     * @param lendTime
     * @param returnTime
     * @param owner
     * @return
     */
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    Result lend(int reservationId, Date lendTime, Date returnTime, String currentUser);

    /**
     * 书籍下架
     * @param bookItemId
     * @param currentUser
     * @return
     */
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    Result offShelves(int bookItemId, String currentUser);
}
