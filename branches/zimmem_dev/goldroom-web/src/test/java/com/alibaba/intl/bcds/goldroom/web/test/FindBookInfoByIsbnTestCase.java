package com.alibaba.intl.bcds.goldroom.web.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.alibaba.intl.bcds.goldroom.dataobject.BookInfo;
import com.alibaba.intl.bcds.goldroom.web.FindIsbnController;
import com.alibaba.intl.bcds.goldroom.web.test.mock.BookInfoServiceMock;

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

/**
 * TODO Comment of FindBookInfoByIsbnTestCase
 * 
 * @author Zimmem
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "file:src/main/webapp/WEB-INF/goldroom-servlet.xml" })
public class FindBookInfoByIsbnTestCase {

    Controller controller = null;

    @Before
    public void before() {
        FindIsbnController _controller = new FindIsbnController();
        _controller.setBookInfoService(new BookInfoServiceMock());
        controller = _controller;
    }

    @Test
    public void testExistIsbn() throws Exception {
        MockHttpServletRequest request = new MockHttpServletRequest();
        request.setMethod("POST");
        MockHttpServletResponse response = new MockHttpServletResponse();
        request.addParameter("isbn", "100000000");
        try {
            ModelAndView mv = controller.handleRequest(request, response);
            assertEquals(mv.getViewName(), "redirect:confirmedShelves.htm");
            BookInfo info = (BookInfo) mv.getModelMap().get("info");
            assertEquals(info.getIsbn(), "100000000");
        } catch (Exception e) {
            e.printStackTrace();
            fail("fail on running FindIsbnController");
            throw e;
        }
    }

    @Test
    public void testNotExistIsbn() {
        MockHttpServletRequest request = new MockHttpServletRequest();
        request.setMethod("POST");
        MockHttpServletResponse response = new MockHttpServletResponse();
        request.addParameter("isbn", "222222222");
        try {
            ModelAndView mv = controller.handleRequest(request, response);
            assertEquals(mv.getViewName(), "redirect:fillBookInfo.htm");
            assertEquals(mv.getModel().get("isbn"), "222222222");
        } catch (Exception e) {
            e.printStackTrace();
            fail("fail on running FindIsbnController");
        }
    }
}
