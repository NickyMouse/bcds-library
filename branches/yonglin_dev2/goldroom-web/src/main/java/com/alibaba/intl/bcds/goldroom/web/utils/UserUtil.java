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

import org.springframework.security.Authentication;
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
		UserDetails details = getUserDetails();
		if (details != null) {
			return details.getUsername();
		}else{
			return null;
		}
	}

	public static String getPassword() {
		UserDetails details = getUserDetails();
		if (details != null) {
			return details.getPassword();
		}else{
			return null;
		}
	}

	public static GrantedAuthority[] getAuthorities() {
		UserDetails details = getUserDetails();
		if (details != null) {
			return details.getAuthorities();
		}else{
			return null;
		}
	}

	public static String getUserName(){
		UserDetails details = getUserDetails();
		if (details != null) {
			return details.getUsername();
		}else{
			return null;
		}
	}
	public static UserDetails getUserDetails() {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		Object result=null;
		if(authentication != null){
			result= authentication.getPrincipal();
		}
		if (result != null && result instanceof UserDetails) {
			return (UserDetails) result;
		} else {
			return null;
		}
	}

	public static boolean isLogin() {
		return getUserDetails() != null;
	}
}
