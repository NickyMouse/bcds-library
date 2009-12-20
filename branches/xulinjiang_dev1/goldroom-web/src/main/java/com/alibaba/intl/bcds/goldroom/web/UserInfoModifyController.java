package com.alibaba.intl.bcds.goldroom.web;


import org.apache.commons.lang.StringUtils;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.SimpleFormController;

import com.alibaba.intl.bcds.goldroom.service.MemberService;
import com.alibaba.intl.bcds.goldroom.service.result.Result;
import com.alibaba.intl.bcds.goldroom.web.command.UserInfoCommand;
import com.alibaba.intl.bcds.goldroom.web.utils.UserUtil;

public class UserInfoModifyController extends SimpleFormController {

    private static final String EMPTY = "";

    private MemberService       memberService;

    public void setMemberService(MemberService memberService) {
        this.memberService = memberService;
    }

    public MemberService getMemberService() {
        return memberService;
    }

    /**
     * 判断用户有没修改
     * 
     * @param userInfo
     * @return
     */
    public boolean isNotModified(UserInfoCommand userInfo) {
        if (EMPTY.equals(userInfo.getNewPassword()) || EMPTY.equals(userInfo.getName())
            || EMPTY.equals(userInfo.getEmail()) || EMPTY.equals(userInfo.getAliTalkId())
            || EMPTY.equals(userInfo.getWorkId()) || EMPTY.equals(userInfo.getLocation())
            || EMPTY.equals(userInfo.getExt())) {
            return true;
        }
        return false;
    }

    @Override
    protected ModelAndView onSubmit(Object command) throws Exception {
        UserInfoCommand userInfo = (UserInfoCommand) command;
        // 判断原密码是否正确
        if (userInfo.getOldPassword() != UserUtil.getPassword()) {
            return new ModelAndView("/resources/changePasswordFailed");
        }
        // 判断用户有没修改
        if (isNotModified(userInfo)) {
            return new ModelAndView("/resources/changePasswordFailed");
        }
        Result result = new Result(false);
        if (UserUtil.getPassword().equals(userInfo.getOldPassword())
            && StringUtils.isNotEmpty(userInfo.getNewPassword())) {
            result = memberService.changePasswordByLoginId(UserUtil.getLoginId(), userInfo.getNewPassword());
        }
        if (result.isSuccess()) {
            return new ModelAndView("/resources/changePasswordSuccess");
        } else {
            return new ModelAndView("/resources/changePasswordFailed");
        }
    }
}