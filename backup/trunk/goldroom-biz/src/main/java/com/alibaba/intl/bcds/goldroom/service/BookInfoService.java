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

import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.alibaba.intl.bcds.goldroom.dataobject.BookInfo;
import com.alibaba.intl.bcds.goldroom.service.result.Result;

/**
 * TODO Comment of BookInfoService
 * 
 * @author Zimmem
 */
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public interface BookInfoService {

    /**
     * 根据ISBN查找书籍信息
     * 
     * @param isbn
     * @return
     */
    BookInfo findBookInfoByIsbn(String isbn);

    /**
     * 添加书籍信息
     * 
     * @param bookInfo
     */
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    Result addBookInfo(BookInfo bookInfo);

    /**
     * 根据ISBN查找书籍信息
     * 
     * @param isbn
     * @return
     */
    BookInfo findBookInfoById(int id);

    /**
     * 先从数据库查找bookInfo，如果查到，直接返回，如果查不到，先从其它图书网站拉一份 bookInfo下来，存入数据库，并返回
     * 
     * @param isbn
     * @return
     */
    BookInfo getBookInfoFromDbAndNetWork(String isbn);

    /**
     * @param bookInfo
     */
    void updateCategory(BookInfo bookInfo);

}
