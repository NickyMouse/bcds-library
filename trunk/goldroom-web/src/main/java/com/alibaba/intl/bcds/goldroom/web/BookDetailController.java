/**
 * Project: goldroom-web
 * 
 * File Created at 2009-10-18
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

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

import com.alibaba.intl.bcds.goldroom.dataobject.BookInfo;
import com.alibaba.intl.bcds.goldroom.dataobject.BookItem;
import com.alibaba.intl.bcds.goldroom.service.BookInfoService;
import com.alibaba.intl.bcds.goldroom.service.BookItemService;

/**
 * TODO Comment of BookDetailController
 * 
 * @author Zimmem
 */
public class BookDetailController extends AbstractController {

    private BookItemService bookItemService;
    private BookInfoService bookInfoService;

    /**
     * @param bookInfoService the bookInfoService to set
     */
    public void setBookInfoService(BookInfoService bookInfoService) {
        this.bookInfoService = bookInfoService;
    }

    /**
     * @param bookItemService the bookItemService to set
     */
    public void setBookItemService(BookItemService bookItemService) {
        this.bookItemService = bookItemService;
    }

    @Override
    protected ModelAndView handleRequestInternal(HttpServletRequest request,
                                                 HttpServletResponse response) throws Exception {

        int bookInfoId = Integer.parseInt(request.getParameter("id"));
        BookInfo bookInfo = bookInfoService.findBookInfoById(bookInfoId);
        List<BookItem> items = bookItemService.listBookItemByBookInfoId(bookInfoId);
        ModelAndView mv = new ModelAndView("bookDetail");
        mv.addObject("bookInfo", bookInfo);
        mv.addObject("bookItemList", items);
        return mv;

    }
}
