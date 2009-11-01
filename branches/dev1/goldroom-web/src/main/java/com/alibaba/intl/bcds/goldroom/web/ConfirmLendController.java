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

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.SimpleFormController;

import com.alibaba.intl.bcds.goldroom.service.BookItemService;
import com.alibaba.intl.bcds.goldroom.service.result.Result;
import com.alibaba.intl.bcds.goldroom.web.command.ConfirmLending;
import com.alibaba.intl.bcds.goldroom.web.utils.UserUtil;

/**
 * TODO Comment of ConfirmLendController
 * 
 * @author Zimmem
 */
public class ConfirmLendController extends SimpleFormController {

    BookItemService bookItemService = null;

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
        ConfirmLending confirmLending = (ConfirmLending) command;
        Result result = bookItemService.lend(confirmLending.getReservationId(), new Date(),
                confirmLending.getReturnTime(), UserUtil.getLoginId());
        if (result.isSuccess())
            return new ModelAndView(getSuccessView());
        else
            return new ModelAndView("lendError");
    }

    protected void initBinder(HttpServletRequest request, ServletRequestDataBinder binder)
            throws Exception {

        DateFormat fmt = new SimpleDateFormat("yyyy-M-d");
        CustomDateEditor dateEditor = new CustomDateEditor(fmt, true);
        binder.registerCustomEditor(Date.class, dateEditor);
        super.initBinder(request, binder);
    }

}
