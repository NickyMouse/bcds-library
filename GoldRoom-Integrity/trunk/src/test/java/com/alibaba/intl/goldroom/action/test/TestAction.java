package com.alibaba.intl.goldroom.action.test;

import com.alibaba.intl.bcds.goldroom.dataobject.Member;
import com.alibaba.intl.bcds.goldroom.service.MemberService;
import com.opensymphony.xwork2.ActionSupport;

public class TestAction extends ActionSupport {

    private String        loginId;
    private Member        member;
    private MemberService memberService;

    public String getLoginId() {
        return loginId;
    }

    public void setLoginId(String loginId) {
        this.loginId = loginId;
    }

    public Member getMember() {
        return member;
    }

    public void setMember(Member member) {
        this.member = member;
    }

    public MemberService getMemberService() {
        return memberService;
    }

    public void setMemberService(MemberService memberService) {
        this.memberService = memberService;
    }

    public String execute() throws Exception {
        member = memberService.findMemberByLoginId(loginId);
        if (member != null) {
            return "success";
        } else {
            return "failed";
        }
    }

}
