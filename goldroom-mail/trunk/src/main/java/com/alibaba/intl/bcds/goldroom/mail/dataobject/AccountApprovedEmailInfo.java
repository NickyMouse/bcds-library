package com.alibaba.intl.bcds.goldroom.mail.dataobject;

import com.alibaba.intl.bcds.goldroom.dataobject.Member;
import com.alibaba.intl.bcds.goldroom.mail.enumeration.ServiceType;

public class AccountApprovedEmailInfo extends BaseEmailInfo{
	private Member member;
	public AccountApprovedEmailInfo(Member member){
		this.serviceType = ServiceType.NOTIFY_ACCOUNT_APPROVED;
		this.member = member;
		this.receiverEmail = member.getEmail();
	}

	public void setMember(Member member) {
		this.member = member;
	}

	public Member getMember() {
		return member;
	}
	
}
