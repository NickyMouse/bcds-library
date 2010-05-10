package com.alibaba.intl.bcds.goldroom.dto;

import com.alibaba.intl.bcds.goldroom.constants.RoleEnum;
import com.alibaba.intl.bcds.goldroom.dataobject.Member;
import com.alibaba.intl.bcds.goldroom.dataobject.MemberRole;

public class MemberDTO {

    private Integer id;

    private String  name;

    private String  loginId;

    private Integer workId;

    private String  email;

    private String  role;

    private String  aliTalkId;

    public MemberDTO() {

    }

    public MemberDTO(Member member, MemberRole role) {
        this.id = member.getId();
        this.name = member.getName();
        this.aliTalkId = member.getAliTalkId();
        this.workId = member.getWorkId();
        this.loginId = member.getLoginId();
        this.email = member.getEmail();
        this.role = RoleEnum.getRoleById(role.getRoleId()).getName();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLoginId() {
        return loginId;
    }

    public void setLoginId(String loginId) {
        this.loginId = loginId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getAliTalkId() {
        return aliTalkId;
    }

    public void setAliTalkId(String aliTalkId) {
        this.aliTalkId = aliTalkId;
    }

    public Integer getWorkId() {
        return workId;
    }

    public void setWorkId(Integer workId) {
        this.workId = workId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

}
