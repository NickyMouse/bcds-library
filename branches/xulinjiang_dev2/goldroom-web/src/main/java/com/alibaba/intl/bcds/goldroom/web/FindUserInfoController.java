package com.alibaba.intl.bcds.goldroom.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

import com.alibaba.intl.bcds.goldroom.dataobject.Member;
import com.alibaba.intl.bcds.goldroom.service.MemberService;
import com.alibaba.intl.bcds.goldroom.web.command.UserInfoCommand;
import com.alibaba.intl.bcds.goldroom.web.utils.UserUtil;

public class FindUserInfoController extends AbstractController {

    private static final String COMMAND_NAME = "userInfoCommand";

    private MemberService       memberService;

    public void setMemberService(MemberService memberService) {
        this.memberService = memberService;
    }

    public MemberService getMemberService() {
        return memberService;
    }

    @Override
    protected ModelAndView handleRequestInternal(HttpServletRequest request, HttpServletResponse response)
                                                                                                          throws Exception {
        UserInfoCommand userInfoCommand = new UserInfoCommand();
        Member member = memberService.selectByLoginId(UserUtil.getLoginId());
        setToUserInfoCommand(member, userInfoCommand);
        ModelAndView modelAndView = new ModelAndView("/user/userInfoModify", COMMAND_NAME, userInfoCommand);
        return modelAndView;
    }

    /**
     * 转换格式
     * 
     * @param member
     * @param userInfoCommand
     */
    public void setToUserInfoCommand(Member member, UserInfoCommand userInfoCommand) {
        userInfoCommand.setName(member.getName());
        userInfoCommand.setEmail(member.getEmail());
        userInfoCommand.setAliTalkId(member.getAliTalkId());
        userInfoCommand.setWorkId(member.getWorkId());
        userInfoCommand.setLocation(member.getLocation());
        userInfoCommand.setExt(member.getExt());
    }
}
