/**
 * Project: goldroom-web
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
package com.alibaba.intl.bcds.goldroom.web;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.SimpleFormController;

import com.alibaba.intl.bcds.goldroom.dataobject.BookInfo;
import com.alibaba.intl.bcds.goldroom.service.BookInfoService;

/**
 * TODO Comment of FillBookInfoController
 * 
 * @author Zimmem
 */
public class FillBookInfoController extends SimpleFormController {

    private BookInfoService bookInfoService;

    /**
     * @param bookInfoService the bookInfoService to set
     */
    public void setBookInfoService(BookInfoService bookInfoService) {
        this.bookInfoService = bookInfoService;
    }

    @Override
    protected ModelAndView onSubmit(Object command) throws Exception {
        BookInfo bookInfo = (BookInfo) command;
        bookInfoService.addBookInfo(bookInfo);
        return new ModelAndView("confirmedShelves", "bookInfo", bookInfo);
    }

}
