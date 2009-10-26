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

import com.alibaba.intl.bcds.goldroom.dataobject.BookInfo;

/**
 * TODO Comment of BookInfoService
 * 
 * @author Zimmem
 */
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
    void addBookInfo(BookInfo bookInfo);

    /**
     * 根据ISBN查找书籍信息
     * 
     * @param isbn
     * @return
     */
    BookInfo findBookInfoById(int id);

}
