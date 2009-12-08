/**
 * Project: goldroom-web
 * 
 * File Created at 2009-11-25
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
package com.alibaba.intl.bcds.goldroom.web.command;

import com.alibaba.intl.bcds.goldroom.dataobject.BookInfo;
import com.alibaba.intl.bcds.goldroom.dataobject.BookItem;

/**
 * TODO Comment of ShelveCommand
 * 
 * @author Zimmem
 */
public class Shelve {

    public Shelve() {
        bookInfo = new BookInfo();
        bookItem = new BookItem();
    }

    private BookInfo bookInfo;

    private BookItem bookItem;

    private String   createType;

    private boolean  addCategoryFirstTime;

    /**
     * @return the bookInfo
     */
    public BookInfo getBookInfo() {
        return bookInfo;
    }

    /**
     * @param bookInfo the bookInfo to set
     */
    public void setBookInfo(BookInfo bookInfo) {
        this.bookInfo = bookInfo;
    }

    /**
     * @return the bookItem
     */
    public BookItem getBookItem() {
        return bookItem;
    }

    /**
     * @param bookItem the bookItem to set
     */
    public void setBookItem(BookItem bookItem) {
        this.bookItem = bookItem;
    }

    /**
     * @return the createType
     */
    public String getCreateType() {
        return createType;
    }

    /**
     * @param createType the createType to set
     */
    public void setCreateType(String createType) {
        this.createType = createType;
    }

    /**
     * @return the addCategoryFirstTime
     */
    public boolean isAddCategoryFirstTime() {
        return addCategoryFirstTime;
    }

    /**
     * @param addCategoryFirstTime the addCategoryFirstTime to set
     */
    public void setAddCategoryFirstTime(boolean addCategoryFirstTime) {
        this.addCategoryFirstTime = addCategoryFirstTime;
    }

}
