package com.alibaba.intl.bcds.goldroom.action.mygoldroom;

import com.alibaba.intl.bcds.goldroom.action.base.BaseAction;
import com.alibaba.intl.bcds.goldroom.dataobject.Member;
import com.alibaba.intl.bcds.goldroom.dataobject.UserDTO;
import com.alibaba.intl.bcds.goldroom.service.MemberService;

public class EditProfileAction extends BaseAction {

    /**
     *
     */
    private static final long serialVersionUID = 7307354140114286485L;

    private String            aliTalkId;

    private String            location;

    private String            ext;

    private String            submitFlag;

    private MemberService     memberService;

    private String            result;

    public String execute() throws Exception {

        UserDTO user = this.getUserDTO();
        if (user == null) {
            return ERROR;
        }
        Member m = memberService.findMemberByLoginId(user.getLoginId());

        if (m == null) {
            return ERROR;
        }
        if ("y".equalsIgnoreCase(submitFlag)) {
            m.setAliTalkId(aliTalkId);
            m.setLocation(location);
            m.setExt(ext);
            this.result = String.valueOf(memberService.updateMemberByLoginId(m));
            return SUCCESS;
        } else {
            this.aliTalkId = m.getAliTalkId();
            this.location = m.getLocation();
            this.ext = m.getExt();
            return "showForm";
        }
    }

    public String getAliTalkId() {
        return aliTalkId;
    }

    public void setAliTalkId(String aliTalkId) {
        this.aliTalkId = aliTalkId;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getExt() {
        return ext;
    }

    public void setExt(String ext) {
        this.ext = ext;
    }

    public void setMemberService(MemberService memberService) {
        this.memberService = memberService;
    }

    public MemberService getMemberService() {
        return memberService;
    }

    public void setSubmitFlag(String submitFlag) {
        this.submitFlag = submitFlag;
    }

    public String getSubmitFlag() {
        return submitFlag;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public String getResult() {
        return result;
    }

}
