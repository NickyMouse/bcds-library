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
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.validation.BindException;
import org.springframework.validation.Errors;
import org.springframework.web.bind.ServletRequestDataBinder;
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
    public static Pattern   isbnPattern = Pattern.compile("^[1-9](\\d{9}|\\d{12})$");

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
        if (!validateIsbn(isbn) && !request.getMethod().equals("POST")) {
            map.put("isbnError", true);
            map.put("isbn", isbn);
            return map;
        }
        BookInfo bookInfo = bookInfoService.getBookInfoFromDbAndNetWork(isbn);
        map.put("bookInfo", bookInfo);
        Shelve shelve = (Shelve) command;
        if (bookInfo == null) {
            shelve.setNewBookInfo(true);
            shelve.getBookInfo().setIsbn(isbn);
            map.put("isbn", isbn);
        } else if (bookInfo != null) {
            shelve.setBookInfo(bookInfo);
            if (bookInfo.getCategoryId() == null)
                shelve.setUpdateCategory(true);
        }
        map.put("showForm", true);
        map.put("isbnError", false);
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

    /**
     * @param isbn
     */
    private boolean validateIsbn(String isbn) {
        if (StringUtils.isEmpty(isbn))
            return false;

        Matcher matcher = isbnPattern.matcher(isbn);
        return matcher.matches();

    }

    protected void initBinder(HttpServletRequest request, ServletRequestDataBinder binder)
            throws Exception {

        DateFormat fmt = new SimpleDateFormat("yyyy-MM-dd");
        CustomDateEditor dateEditor = new CustomDateEditor(fmt, true);
        binder.registerCustomEditor(Date.class, dateEditor);
        super.initBinder(request, binder);
    }
}
