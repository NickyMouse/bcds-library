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

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

import com.alibaba.intl.bcds.goldroom.dataobject.BookInfo;
import com.alibaba.intl.bcds.goldroom.service.BookInfoService;

/**
 * TODO Comment of FindIsbnController
 * 
 * @author Zimmem
 */
public class FindIsbnController extends AbstractController {

    private BookInfoService bookInfoService;

    /**
     * @param bookInfoService the bookInfoService to set
     */
    public void setBookInfoService(BookInfoService bookInfoService) {
        this.bookInfoService = bookInfoService;
    }

    /**
    * 
    */
    @Override
    protected ModelAndView handleRequestInternal(HttpServletRequest request,
                                                 HttpServletResponse response) throws Exception {
        String isbn = (String) request.getParameter("isbn");
        if (StringUtils.isEmpty(isbn)) {
            return new ModelAndView("redirect:/user/beforeShelve.htm");
        }
        BookInfo bookInfo = bookInfoService.findBookInfoByIsbn(isbn);
        if (bookInfo == null) {
            return new ModelAndView("redirect:fillBookInfo.htm", "isbn", isbn);
        } else {
            return new ModelAndView("redirect:confirmedShelves.htm", "isbn", isbn);
        }
    }

}
