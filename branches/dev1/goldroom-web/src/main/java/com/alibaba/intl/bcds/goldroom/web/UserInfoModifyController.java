package com.alibaba.intl.bcds.goldroom.web;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.SimpleFormController;

import com.alibaba.intl.bcds.goldroom.dataobject.Member;
import com.alibaba.intl.bcds.goldroom.service.UserService;

public class UserInfoModifyController extends SimpleFormController {

	private UserService userService;

	public void setUsersService(UserService usersService) {
		this.userService = usersService;
	}

	protected ModelAndView onSubmit(Object command) throws Exception {
		Member member = (Member) command;
		// 更改用户信息
		userService.updateUserInfo(member);
		return new ModelAndView("");
	}
}
