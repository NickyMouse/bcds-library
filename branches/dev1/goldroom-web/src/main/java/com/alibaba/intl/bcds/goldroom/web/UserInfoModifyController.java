package com.alibaba.intl.bcds.goldroom.web;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.SimpleFormController;

import com.alibaba.intl.bcds.goldroom.dataobject.User;
import com.alibaba.intl.bcds.goldroom.service.UserService;
import com.alibaba.intl.bcds.goldroom.util.MD5;
import com.alibaba.intl.bcds.goldroom.web.utils.UserUtil;

public class UserInfoModifyController extends SimpleFormController {

	private UserService userService;

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	@SuppressWarnings("unchecked")
	@Override
	protected ModelAndView onSubmit(Object command) throws Exception {
		User userInfo = (User) command;
		Map map = new HashMap();
		if (userInfo.getNewPassword().equals(userInfo.getConfirmPassword())) {
			// MD5加密
			map.put("password", MD5
					.getMD5(userInfo.getNewPassword().getBytes()));
			// 登录名
			map.put("login_id", UserUtil.getLoginId());
			// 更改用户信息
			userService.updateUserInfo(map);
			return new ModelAndView(getSuccessView());
		} else {
			return new ModelAndView("userInfoModify");
		}
	}

}
