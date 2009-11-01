/**
 * Project: goldroom-web
 * 
 * File Created at 2009-10-25
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

import com.alibaba.intl.bcds.goldroom.service.BookItemService;
import com.alibaba.intl.bcds.goldroom.service.result.Result;
import com.alibaba.intl.bcds.goldroom.web.command.ReserveCommand;
import com.alibaba.intl.bcds.goldroom.web.utils.UserUtil;

/**
 * TODO Comment of ReserveBookController
 * 
 * @author Zimmem
 */
public class ReserveBookController extends SimpleFormController {

    BookItemService bookItemService = null;

    /*
     * (non-Javadoc)
     * @see
     * org.springframework.web.servlet.mvc.SimpleFormController#onSubmit(java
     * .lang.Object)
     */
    /**
     * @param bookItemService the bookItemService to set
     */
    public void setBookItemService(BookItemService bookItemService) {
        this.bookItemService = bookItemService;
    }

    @Override
    protected ModelAndView onSubmit(Object command) throws Exception {
        ReserveCommand reserveCommand = (ReserveCommand) command;
        Result result = bookItemService.reserve(UserUtil.getLoginId(), reserveCommand
                .getBookItemId());
        if (result.isSuccess())
            return new ModelAndView(getSuccessView());
        return new ModelAndView("reserveError");
    }

    /*
     * (non-Javadoc)
     * @see
     * org.springframework.web.servlet.mvc.AbstractFormController#formBackingObject
     * (javax.servlet.http.HttpServletRequest)
     */
    //    @Override
    //    protected Object formBackingObject(HttpServletRequest request) throws Exception {
    //        int bookItemId = Integer.parseInt(request.getParameter("bookItemId"));
    //        return bookItemId;
    //    }

}
