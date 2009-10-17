package com.alibaba.intl.bcds.goldroom.web;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.SimpleFormController;

import com.alibaba.intl.bcds.goldroom.dataobject.Member;
import com.alibaba.intl.bcds.goldroom.service.UsersService;

public class UserInfoModifyController extends SimpleFormController {

	private UsersService usersService;

	public void setUsersService(UsersService usersService) {
		this.usersService = usersService;
	}

	protected ModelAndView onSubmit(Object command) throws Exception {
		Member member = (Member) command;
		// 更改用户信息
		usersService.updateUserInfo(member);
		return new ModelAndView("");
	}
}
