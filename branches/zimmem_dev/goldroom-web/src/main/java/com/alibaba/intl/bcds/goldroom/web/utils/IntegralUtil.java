/**
 * Project: goldroom-web
 * 
 * File Created at 2010-1-1
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
package com.alibaba.intl.bcds.goldroom.web.utils;

import com.alibaba.intl.bcds.goldroom.service.IntegralService;

/**
 * TODO Comment of IntegralUtil
 * 
 * @author Larry Su
 */
public class IntegralUtil {

    private IntegralService integralService;

    public void setIntegralService(IntegralService integralService) {
        this.integralService = integralService;
    }

    public long getIntegral() {
        return this.integralService.findByLoginId(UserUtil.getLoginId()).getValue();
    }

    public long getIntegral(String loginId) {
        return this.integralService.findByLoginId(loginId).getValue();
    }

    public String getIntegralLevelUrl(long integral) {
        String levelImg = "";
        if (integral < 500) {
            //
        } else if (integral < 1000) {
            levelImg = "1.png";
        } else if (integral < 2000) {
            levelImg = "2.png";
        } else if (integral < 5000) {
            levelImg = "3.png";
        } else if (integral < 10000) {
            levelImg = "4.png";
        } else if (integral < 20000) {
            levelImg = "5.png";
        } else if (integral < 50000) {
            levelImg = "6.png";
        } else if (integral < 100000) {
            levelImg = "7.png";
        } else {
            levelImg = "8.png";
        }

        return "/images/level/" + levelImg;
    }
}
