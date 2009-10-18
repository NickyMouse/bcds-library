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

import java.util.List;

import com.alibaba.intl.bcds.goldroom.dataobject.BookItem;

/**
 * TODO Comment of BookItemService
 * 
 * @author Zimmem
 */
public interface BookItemService {
    /**
     * ����鱾
     * 
     * @param bookInfo
     */
    void addBookItem(BookItem bookItem);

    /**
     * 新书上架
     * 
     * @param loginId �û���¼ id
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
    List<BookItem> listBookItemsByLoginIdAndState(String loginId, String state);
}
