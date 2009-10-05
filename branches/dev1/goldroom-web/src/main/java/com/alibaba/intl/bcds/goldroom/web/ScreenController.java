/**
 * Project: goldroom-web
 * 
 * File Created at 2009-10-3
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

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

/**
 * TODO Comment of ScreenController
 * 
 * @author Zimmem
 */

public class ScreenController extends AbstractController {

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
        String path = request.getServletPath();
        String view = path.substring(1, path.indexOf("."));
        return new ModelAndView(view);
    }

    /*
     * public String execute() { return "user"; }
     */

}
