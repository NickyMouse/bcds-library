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

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.springframework.validation.BindException;
import org.springframework.validation.Errors;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;
import org.springframework.web.servlet.mvc.SimpleFormController;

import com.alibaba.intl.bcds.goldroom.dataobject.BookInfo;
import com.alibaba.intl.bcds.goldroom.service.BookInfoService;

/**
 * TODO Comment of FindIsbnController
 * 
 * @author Zimmem
 */
public class ShelveFormController extends SimpleFormController {

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
        String isbn = (String) request.getParameter("isbn");
        if (StringUtils.isEmpty(isbn)) {
            response.setStatus(404);
            return new ModelAndView();
        }
        return super.onSubmit(request, response, command, errors);
    }

    @Override
    protected Map referenceData(HttpServletRequest request, Object command, Errors errors)
            throws Exception {
        Map<String, Object> map = new HashMap<String, Object>();
        String isbn = (String) request.getParameter("isbn");
        BookInfo bookInfo = bookInfoService.findBookInfoByIsbn(isbn);
        map.put("bookInfo", bookInfo);
        return map;
    }

}
