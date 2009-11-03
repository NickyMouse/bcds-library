/**
 * Project: goldroom-web
 * 
 * File Created at 2009-10-18
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
 * TODO Comment of ReservatedBooksControler
 * 
 * @author Zimmem
 */
public class ReservatedBooksController extends AbstractController {
    BookItemService bookItemService;

    /**
     * @param bookItemService the bookItemService to set
     */
    public void setBookItemService(BookItemService bookItemService) {
        this.bookItemService = bookItemService;
    }

    @SuppressWarnings("unchecked")
    @Override
    protected ModelAndView handleRequestInternal(HttpServletRequest request,
                                                 HttpServletResponse response) throws Exception {

        String pageStr = request.getParameter("page");
        String pagesizeStr = request.getParameter("pagesize");
        Result result = bookItemService.listReservatedBooksBySubscriber(UserUtil.getLoginId(),
                NumberUtils.toInt(pageStr, 1), NumberUtils.toInt(pagesizeStr, 10));
        Map<String, Object> map = (Map<String, Object>) result.getReturnObject();
        ModelAndView mv = new ModelAndView("user/reservatedBooks");
        mv.addObject("bookItemList", map.get("bookItemList"));
        mv.addObject("pageNavView", PageUtils.createPageNavView((Integer) map.get("totalCount"),
                request));
        return mv;
    }
}
