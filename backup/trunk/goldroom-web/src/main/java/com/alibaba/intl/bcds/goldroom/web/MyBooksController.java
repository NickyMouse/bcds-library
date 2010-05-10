/**
 * Project: goldroom-web File Created at 2009-10-17 $Id$ Copyright 2008 Alibaba.com Croporation Limited. All rights
 * reserved. This software is the confidential and proprietary information of Alibaba Company.
 * ("Confidential Information"). You shall not disclose such Confidential Information and shall use it only in
 * accordance with the terms of the license agreement you entered into with Alibaba.com.
 */
package com.alibaba.intl.bcds.goldroom.web;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.math.NumberUtils;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

import com.alibaba.intl.bcds.goldroom.dataobject.BookInfo;
import com.alibaba.intl.bcds.goldroom.dataobject.BookItem;
import com.alibaba.intl.bcds.goldroom.search.commons.dataobject.BookSearch;
import com.alibaba.intl.bcds.goldroom.search.commons.service.BookSearchService;
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

    private static final String Integer = null;
    private BookItemService     bookItemService;
    private BookSearchService   bookSearchService;

    /**
     * @param bookItemService the bookItemService to set
     */
    public void setBookItemService(BookItemService bookItemService) {
        this.bookItemService = bookItemService;
    }

    public void setBookSearchService(BookSearchService bookSearchService) {
        this.bookSearchService = bookSearchService;
    }

    /*
     * (non-Javadoc)
     * @see org.springframework.web.servlet.mvc.AbstractController#handleRequestInternal
     * (javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
     */
    @SuppressWarnings("unchecked")
    @Override
    protected ModelAndView handleRequestInternal(HttpServletRequest request, HttpServletResponse response)
                                                                                                          throws Exception {
        String state = request.getParameter("state");
        String loginId = UserUtil.getLoginId();
        String pageStr = request.getParameter("page");
        String pageSizeStr = request.getParameter("pagesize");
        String keywords = request.getParameter("keywords");

        int page = NumberUtils.toInt(pageStr, PageUtils.DEFAULT_PAGE);
        int pageSize = NumberUtils.toInt(pageSizeStr, PageUtils.DEFAULT_PAGE_SIZE);
        List<BookItem> bookItemList = new ArrayList();
        int totalCount = 0;
        if (StringUtils.isNotBlank(keywords)) {
            int skipResult = PageUtils.getSkipResult(page, pageSize);
            List<BookSearch> bookInfoList = bookSearchService.searchBookByOwnersAndKeyword(loginId, keywords,
                                                                                           skipResult, pageSize).getResultList();
            if (bookInfoList.size() > 0) {
                List<Integer> bookInfoIds = new ArrayList();
                for (BookSearch bookSearchInfo : bookInfoList) {
                    bookInfoIds.add(bookSearchInfo.getBookInfoId());
                }
                bookItemList = bookItemService.listBookItemsByLoginIdAndStateAndBookInfoIds(loginId, state, bookInfoIds);
            }
        } else {
            Result result = bookItemService.listBookItemsByLoginIdAndState(loginId, state, page, pageSize);
            Map<String, Object> map = (Map<String, Object>) result.getReturnObject();
            bookItemList = (List<BookItem>) map.get("bookItemList");
            totalCount = (Integer) map.get("totalCount");
        }

        ModelAndView mv = new ModelAndView("user/myBooks");
        mv.addObject("state", state);
        mv.addObject("keywords", keywords);
        mv.addObject("bookItemList", bookItemList);
        mv.addObject("pageNavView", PageUtils.createPageNavView(totalCount, request));
        return mv;
    }
}
