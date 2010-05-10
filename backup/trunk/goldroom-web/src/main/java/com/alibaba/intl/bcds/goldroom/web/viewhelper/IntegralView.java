package com.alibaba.intl.bcds.goldroom.web.viewhelper;

import org.apache.commons.lang.StringUtils;

import com.alibaba.intl.bcds.goldroom.dataobject.Integral;
import com.alibaba.intl.bcds.goldroom.dataobject.Member;

public class IntegralView {

    private Member   member;
    private Integral integral;

    public IntegralView(Member member, Integral integral){
        this.member = member;
        this.integral = integral;
    }
    public Member getMember() {
        return member;
    }

    public void setMember(Member member) {
        this.member = member;
    }

    public Integral getIntegral() {
        return integral;
    }

    public void setIntegral(Integral integral) {
        this.integral = integral;
    }

    public String getMemberName() {
        return member == null ? StringUtils.EMPTY : member.getName();
    }

    public String getMemberLoginId() {
        return integral == null ? StringUtils.EMPTY : integral.getLoginId();
    }
    
    public long getIntegralValue(){
        return integral == null ? 0 : integral.getValue();
    }
}
