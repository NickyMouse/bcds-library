package com.alibaba.intl.bcds.goldroom.web;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.SimpleFormController;

import com.alibaba.intl.bcds.goldroom.dataobject.Member;
import com.alibaba.intl.bcds.goldroom.service.MemberService;
import com.alibaba.intl.bcds.goldroom.service.result.Result;

public class ApplyUserController extends SimpleFormController {

    MemberService memberService;

    public void setMemberService(MemberService memberService) {
        this.memberService = memberService;
    }

    @Override
    protected ModelAndView onSubmit(Object command) throws Exception {
        Member member = (Member) command;
        member.getPassword();
        Result result = memberService.applyMember(member);
        if (result.isSuccess()) {
            return new ModelAndView(getSuccessView());
        }
        return new ModelAndView("returnError");
    }
}
