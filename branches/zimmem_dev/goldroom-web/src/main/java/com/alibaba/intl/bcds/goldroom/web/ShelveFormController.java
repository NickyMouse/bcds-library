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

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.validation.BindException;
import org.springframework.validation.Errors;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.SimpleFormController;

import com.alibaba.intl.bcds.goldroom.dataobject.BookInfo;
import com.alibaba.intl.bcds.goldroom.dataobject.BookItem;
import com.alibaba.intl.bcds.goldroom.service.BookInfoService;
import com.alibaba.intl.bcds.goldroom.service.BookItemService;
import com.alibaba.intl.bcds.goldroom.web.command.Shelve;
import com.alibaba.intl.bcds.goldroom.web.utils.UserUtil;

/**
 * TODO Comment of FindIsbnController
 * 
 * @author Zimmem
 */
public class ShelveFormController extends SimpleFormController {

    private BookInfoService bookInfoService;
    private BookItemService bookItemService;

    /**
     * @param bookInfoService the bookInfoService to set
     */
    public void setBookInfoService(BookInfoService bookInfoService) {
        this.bookInfoService = bookInfoService;
    }

    @Override
    protected ModelAndView onSubmit(HttpServletRequest request, HttpServletResponse response,
                                    Object command, BindException errors) throws Exception {
        Shelve shelve = (Shelve) command;
        if (shelve.isNewBookInfo()) {
            bookInfoService.addBookInfo(shelve.getBookInfo());

        } else if (shelve.isUpdateCategory()) {
            bookInfoService.updateCategory(shelve.getBookInfo());
        }
        BookItem item = shelve.getBookItem();
        item.setGmtCreate(new Date());
        item.setBookInfoId(shelve.getBookInfo().getId());
        item.setLoginId(UserUtil.getLoginId());
        bookItemService.addBookItem(shelve.getBookItem());
        return new ModelAndView("redirect:/user/shelveSuccess.htm");
    }

    @Override
    protected Map<String, Object> referenceData(HttpServletRequest request, Object command,
                                                Errors errors) throws Exception {
        Map<String, Object> map = new HashMap<String, Object>();
        String isbn = (String) request.getParameter("isbn");
        BookInfo bookInfo = bookInfoService.getBookInfoFromDbAndNetWork(isbn);
        map.put("bookInfo", bookInfo);
        Shelve shelve = (Shelve) command;
        if (bookInfo == null) {
            shelve.setNewBookInfo(true);
            map.put("isbn", isbn);
        } else if (bookInfo != null) {
            shelve.setBookInfo(bookInfo);
            if (bookInfo.getCategoryId() == null)
                shelve.setUpdateCategory(true);
        }
        return map;
    }

    /**
     * @param bookItemService the bookItemService to set
     */
    public void setBookItemService(BookItemService bookItemService) {
        this.bookItemService = bookItemService;
    }

    /**
     * @return the bookItemService
     */
    public BookItemService getBookItemService() {
        return bookItemService;
    }

}
