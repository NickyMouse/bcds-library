package com.alibaba.intl.bcds.goldroom.web;

import org.apache.commons.lang.StringUtils;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.SimpleFormController;

import com.alibaba.intl.bcds.goldroom.service.MemberService;
import com.alibaba.intl.bcds.goldroom.service.result.Result;
import com.alibaba.intl.bcds.goldroom.web.command.UserInfoCommand;
import com.alibaba.intl.bcds.goldroom.web.utils.UserUtil;

public class UserInfoModifyController extends SimpleFormController {

	private MemberService memberService;

	public void setMemberService(MemberService memberService) {
		this.memberService = memberService;
	}

	public MemberService getMemberService() {
		return memberService;
	}

	@Override
	protected ModelAndView onSubmit(Object command) throws Exception {
		UserInfoCommand userInfo = (UserInfoCommand) command;
		Result result = new Result(false);
		if (UserUtil.getPassword().equals(userInfo.getOldPassword())
				&& StringUtils.isNotEmpty(userInfo.getNewPassword())) {
			result = memberService.changePasswordByLoginId(UserUtil
					.getLoginId(), userInfo.getNewPassword());
		}
		if(result.isSuccess()){
			return new ModelAndView("/resources/changePasswordSuccess");
		}else{
			return new ModelAndView("/resources/changePasswordFailed");
		}
	}
}
