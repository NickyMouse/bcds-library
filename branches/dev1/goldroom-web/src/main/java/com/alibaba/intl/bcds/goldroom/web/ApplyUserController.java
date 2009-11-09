package com.alibaba.intl.bcds.goldroom.web;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.SimpleFormController;

import com.alibaba.intl.bcds.goldroom.service.MemberService;
import com.alibaba.intl.bcds.goldroom.service.result.Result;
import com.alibaba.intl.bcds.goldroom.web.command.ApplyUser;

public class ApplyUserController extends SimpleFormController {

    MemberService memberService;

    public void setMemberService(MemberService memberService) {
        this.memberService = memberService;
    }

    @Override
    protected ModelAndView onSubmit(Object command) throws Exception {
        ApplyUser memberCommand = (ApplyUser) command;
        Result result = memberService.applyMember(memberCommand.toMember());
        if (result.isSuccess()) {
            return new ModelAndView(getSuccessView());
        }
        return new ModelAndView("/resources/applyUserFailed");
    }
}
