/**
 * Project: goldroom-web
 * 
 * File Created at 2009-10-17
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

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.math.NumberUtils;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

import com.alibaba.intl.bcds.goldroom.dataobject.BookItem;
import com.alibaba.intl.bcds.goldroom.service.BookItemService;
import com.alibaba.intl.bcds.goldroom.service.result.Result;
import com.alibaba.intl.bcds.goldroom.web.utils.PageUtils;
import com.alibaba.intl.bcds.goldroom.web.utils.UserUtil;

/**
 * TODO Comment of MyBooks
 * 
 * @author Zimmem
 */
public class MyBooksController extends AbstractController {

    private BookItemService bookItemService;

    /**
     * @param bookItemService the bookItemService to set
     */
    public void setBookItemService(BookItemService bookItemService) {
        this.bookItemService = bookItemService;
    }

    /*
     * (non-Javadoc)
     * @see
     * org.springframework.web.servlet.mvc.AbstractController#handleRequestInternal
     * (javax.servlet.http.HttpServletRequest,
     * javax.servlet.http.HttpServletResponse)
     */
    @Override
    protected ModelAndView handleRequestInternal(HttpServletRequest request,
                                                 HttpServletResponse response) throws Exception {
        String state = request.getParameter("state");
        String loginId = UserUtil.getLoginId();
        String pageStr = request.getParameter("page");
        String pagesizeStr = request.getParameter("pagesize");
        int page = NumberUtils.toInt(pageStr, PageUtils.DEFAULT_PAGE);
        int pagesize = NumberUtils.toInt(pagesizeStr, PageUtils.DEFAULT_PAGE_SIZE);
        Result result = bookItemService.listBookItemsByLoginIdAndState(UserUtil.getLoginId(),
                state, page, pagesize);
        Map<String, Object> map = (Map<String, Object>) result.getReturnObject();

        ModelAndView mv = new ModelAndView("user/myBooks");
        mv.addObject("state", state);
        mv.addObject("bookItemList", map.get("bookItemList"));
        mv.addObject("pageNavView", PageUtils.createPageNavView((Integer) map.get("totalCount"),
                request));
        return mv;
    }
}
