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
package com.alibaba.intl.bcds.goldroom.web.utils;

import org.springframework.security.GrantedAuthority;
import org.springframework.security.context.SecurityContextHolder;
import org.springframework.security.userdetails.UserDetails;

/**
 * 使用该类更方便地获取<b>spring security</b>框架的验证信息
 * 
 * @author Zimmem
 */
public class UserUtil {
    public static String getLoginId() {
        return getUserDetails().getUsername();
    }

    public static String getPassword() {
        return getUserDetails().getPassword();
    }

    public static GrantedAuthority[] getAuthorities() {
        getUserDetails().getAuthorities();
        return null;

    }

    public static UserDetails getUserDetails() {
        return (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    }
    
    public static boolean isLogin(){
    	return SecurityContextHolder.getContext().getAuthentication().isAuthenticated();
    }
}
