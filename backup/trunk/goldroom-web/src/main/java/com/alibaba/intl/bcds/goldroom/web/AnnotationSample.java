/**
 * Project: goldroom-web
 * 
 * File Created at 2009-10-4
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

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * TODO Comment of AnnotationSample
 * 
 * @author Zimmem
 */
@Controller
@RequestMapping("/AnnotationSample.htm")
public class AnnotationSample {

    public String execute() {
        return "user";
    }
}
