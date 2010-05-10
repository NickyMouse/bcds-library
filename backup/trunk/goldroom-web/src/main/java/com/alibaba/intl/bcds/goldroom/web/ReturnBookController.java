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
import com.alibaba.intl.bcds.goldroom.web.command.ReturnBookCommand;
import com.alibaba.intl.bcds.goldroom.web.utils.UserUtil;

/**
 * TODO Comment of ReturnBookController
 * 
 * @author Zimmem
 */
public class ReturnBookController extends SimpleFormController {

    BookItemService bookItemService;

    /**
     * @param bookItemService the bookItemService to set
     */
    public void setBookItemService(BookItemService bookItemService) {
        this.bookItemService = bookItemService;
    }

    /*
     * (non-Javadoc)
     * @see
     * org.springframework.web.servlet.mvc.SimpleFormController#onSubmit(java
     * .lang.Object)
     */
    @Override
    protected ModelAndView onSubmit(Object command) throws Exception {
        ReturnBookCommand returnBookCommand = (ReturnBookCommand) command;
        Result result = bookItemService.returnBook(returnBookCommand.getLendingId(), UserUtil
                .getLoginId());
        if (result.isSuccess()) {
            return new ModelAndView(getSuccessView());
        }
        return new ModelAndView("returnError");
    }

}
