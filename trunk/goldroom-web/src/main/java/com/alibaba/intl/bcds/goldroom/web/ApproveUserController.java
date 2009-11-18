package com.alibaba.intl.bcds.goldroom.web;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.validation.BindException;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.SimpleFormController;

import com.alibaba.intl.bcds.goldroom.constants.MemberEnableEnum;
import com.alibaba.intl.bcds.goldroom.dto.MemberDTO;
import com.alibaba.intl.bcds.goldroom.service.MemberService;
import com.alibaba.intl.bcds.goldroom.service.result.Result;
import com.alibaba.intl.bcds.goldroom.web.command.MemberCommand;
import com.alibaba.intl.bcds.goldroom.web.utils.MemberInfoCache;

@SuppressWarnings("unchecked")
public class ApproveUserController extends SimpleFormController {

    MemberService memberService;
    private MemberInfoCache memberInfoCache;

	
	
    public void setMemberService(MemberService memberService) {
        this.memberService = memberService;
    }

    @Override
    protected ModelAndView onSubmit(Object command) throws Exception {
        MemberCommand memberCommand = (MemberCommand) command;
        String status = memberCommand.getStatus();
        List<Integer> ids = new ArrayList<Integer>();
        ids.add(memberCommand.getId());
        Result result = null;
        if (status.equals(MemberEnableEnum.APPROVE.getName())) {
            result = memberService.approveMembers(ids);
        } else if (status.equals(MemberEnableEnum.TBD.getName())) {
            result = memberService.tbdMembers(ids);
        } else {
            throw new RuntimeException("status is not in enum");
        }
        if (result.isSuccess()) {
        	memberInfoCache.reBuild();
        	return new ModelAndView(getSuccessView());
        }
        else return new ModelAndView("lendError");
    }

    @Override
    protected ModelAndView showForm(HttpServletRequest request, HttpServletResponse response, BindException errors,
                                    Map controlModel) throws Exception {
        controlModel = new HashMap();
        List<MemberDTO> members = memberService.listMemberByStatus(MemberEnableEnum.NEW);
        controlModel.put("members", members);
        return super.showForm(request, response, errors, controlModel);
    }

	public void setMemberInfoCache(MemberInfoCache memberInfoCache) {
		this.memberInfoCache = memberInfoCache;
	}

	


}
