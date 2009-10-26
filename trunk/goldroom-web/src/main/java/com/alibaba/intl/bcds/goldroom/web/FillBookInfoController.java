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

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.validation.BindException;
import org.springframework.web.bind.ServletRequestDataBinder;
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
        return new ModelAndView("redirect:confirmedShelves.htm", "isbn", bookInfo.getIsbn());
    }

    /*
     * (non-Javadoc)
     * @see
     * org.springframework.web.servlet.mvc.SimpleFormController#showForm(javax
     * .servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse,
     * org.springframework.validation.BindException, java.util.Map)
     */
    @Override
    protected ModelAndView showForm(HttpServletRequest request, HttpServletResponse response,
                                    BindException errors, Map controlModel) throws Exception {
        controlModel = new HashMap();
        String isbn = request.getParameter("isbn");
        if (StringUtils.isNotEmpty(isbn)) {
            controlModel.put("isbn", isbn);
        }
        return super.showForm(request, response, errors, controlModel);
    }

    protected void initBinder(HttpServletRequest request, ServletRequestDataBinder binder)
            throws Exception {

        DateFormat fmt = new SimpleDateFormat("yyyy-M-d");
        CustomDateEditor dateEditor = new CustomDateEditor(fmt, true);
        binder.registerCustomEditor(Date.class, dateEditor);
        super.initBinder(request, binder);
    }

}
