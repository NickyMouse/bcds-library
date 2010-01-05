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
 * @author Zimmem
 *
 */
public class IntegralUtil {
    
    private IntegralService   integralService;
    
    public void setIntegralService(IntegralService integralService) {
        this.integralService = integralService;
    }
    
    public long getIntegral() {
        return this.integralService.findByLoginId(UserUtil.getLoginId()).getValue();
    }
    
    public long getIntegral(String loginId) {
        return this.integralService.findByLoginId(loginId).getValue();
    }
}
