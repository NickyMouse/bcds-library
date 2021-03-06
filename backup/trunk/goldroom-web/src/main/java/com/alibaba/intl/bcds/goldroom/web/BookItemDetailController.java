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

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

import com.alibaba.intl.bcds.goldroom.dataobject.BookItem;
import com.alibaba.intl.bcds.goldroom.service.BookItemService;
import com.alibaba.intl.bcds.goldroom.web.utils.UserUtil;

/**
 * TODO Comment of BookDetailController
 * 
 * @author Zimmem
 */
public class BookItemDetailController extends AbstractController {

    private BookItemService bookItemService;

    /**
     * @param bookItemService the bookItemService to set
     */
    public void setBookItemService(BookItemService bookItemService) {
        this.bookItemService = bookItemService;
    }

    @Override
    protected ModelAndView handleRequestInternal(HttpServletRequest request,
                                                 HttpServletResponse response) throws Exception {

        int bookItemId = Integer.parseInt(request.getParameter("id"));
        BookItem bookItem = bookItemService.getBookDetailByIdAndOwner(UserUtil.getLoginId(),
                bookItemId);
        ModelAndView mv = new ModelAndView("/user/bookItemDetail");
        mv.addObject("bookItem", bookItem);
        return mv;

    }
}
