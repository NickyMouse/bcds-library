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
import com.alibaba.intl.bcds.goldroom.service.result.Result;

/**
 * TODO Comment of FillBookInfoController
 * 
 * @author Zimmem
 */
@SuppressWarnings("unchecked")
public class FillBookInfoController extends SimpleFormController {

    private BookInfoService bookInfoService;

    /**
     * @param bookInfoService the bookInfoService to set
     */
    public void setBookInfoService(BookInfoService bookInfoService) {
        this.bookInfoService = bookInfoService;
    }

    @Override
    protected ModelAndView onSubmit(HttpServletRequest request, HttpServletResponse response,
                                    Object command, BindException errors) throws Exception {
        BookInfo bookInfo = (BookInfo) command;
        Result result = bookInfoService.addBookInfo(bookInfo);
        if (result.isSuccess()) {
            return new ModelAndView("redirect:confirmedShelves.htm", "isbn", bookInfo.getIsbn());
        } else {
            return showForm(request, response, errors);
        }
    }

    @Override
    protected ModelAndView showForm(HttpServletRequest request, HttpServletResponse response,
                                    BindException errors, Map controlModel) throws Exception {
        controlModel = new HashMap();
        String isbn = request.getParameter("isbn");
        String imgSrc = request.getParameter("imgSrc");
        if (StringUtils.isNotEmpty(isbn)) {
            controlModel.put("isbn", isbn);
            if (!StringUtils.isEmpty(imgSrc)) {
                controlModel.put("imgSrc", imgSrc);
            }
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
