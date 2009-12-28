package com.alibaba.intl.bcds.goldroom.web;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.SimpleFormController;

import com.alibaba.intl.bcds.goldroom.dataobject.Member;
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
     * @param userInfo
     * @return
     */
    public Member setToMember(UserInfoCommand userInfo) {
        Member member = new Member();
        if (EMPTY.equals(userInfo.getNewPassword())) {
            member.setPassword(userInfo.getOldPassword());
        } else {
            member.setPassword(userInfo.getNewPassword());
        }
        member.setLoginId(UserUtil.getLoginId());
        member.setName(userInfo.getName());
        member.setEmail(userInfo.getEmail());
        member.setAliTalkId(userInfo.getAliTalkId());
        member.setWorkId(userInfo.getWorkId());
        member.setLocation(userInfo.getLocation());
        member.setExt(userInfo.getExt());
        return member;
    }

    @Override
    protected ModelAndView onSubmit(Object command) throws Exception {
        UserInfoCommand userInfo = (UserInfoCommand) command;
        // 判断原密码是否正确
        if (!userInfo.getOldPassword().equals(UserUtil.getPassword())) {
            return new ModelAndView("/resources/passwordIncorrect");
        }
        Result result = new Result(false);
        Member member = setToMember(userInfo);
        result = memberService.updateUserInfoByLoginId(member);
        if (result.isSuccess()) {
            return new ModelAndView("/resources/changeUserInfoSuccess");
        } else {
            return new ModelAndView("/resources/changeUserInfoFailed");
        }
    }
}
