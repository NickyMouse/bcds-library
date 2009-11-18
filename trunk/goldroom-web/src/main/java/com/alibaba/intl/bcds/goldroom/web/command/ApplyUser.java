package com.alibaba.intl.bcds.goldroom.web.command;

import java.util.Date;

import com.alibaba.intl.bcds.goldroom.dataobject.Member;

public class ApplyUser {

    private Integer id;

    private String  name;

    private Integer workId;

    private String  loginId;

    private String  password;

    private String  confirmPassword;

    private String  email;

    private String  aliTalkId;

    private Date    gmtCreate;

    private Date    gmtModified;

    private Integer enable;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getWorkId() {
        return workId;
    }

    public void setWorkId(Integer workId) {
        this.workId = workId;
    }

    public String getLoginId() {
        return loginId;
    }

    public void setLoginId(String loginId) {
        this.loginId = loginId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * @return the confirmPassword
     */
    public String getConfirmPassword() {
        return confirmPassword;
    }

    /**
     * @param confirmPassword the confirmPassword to set
     */
    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAliTalkId() {
        return aliTalkId;
    }

    public void setAliTalkId(String aliTalkId) {
        this.aliTalkId = aliTalkId;
    }

    public Date getGmtCreate() {
        return gmtCreate;
    }

    public void setGmtCreate(Date gmtCreate) {
        this.gmtCreate = gmtCreate;
    }

    public Date getGmtModified() {
        return gmtModified;
    }

    public void setGmtModified(Date gmtModified) {
        this.gmtModified = gmtModified;
    }

    public Integer getEnable() {
        return enable;
    }

    public void setEnable(Integer enable) {
        this.enable = enable;
    }

    public Member toMember() {
    	Member member = new Member();
    	member.setLoginId(this.loginId);
    	member.setAliTalkId(aliTalkId);
    	member.setName(name);
    	member.setPassword(password);
    	member.setWorkId(workId);
    	member.setEmail(email);
        return member;
    }
}
