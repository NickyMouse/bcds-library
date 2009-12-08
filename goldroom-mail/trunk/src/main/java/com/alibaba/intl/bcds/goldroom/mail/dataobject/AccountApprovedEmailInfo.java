package com.alibaba.intl.bcds.goldroom.mail.dataobject;

import com.alibaba.intl.bcds.goldroom.dataobject.Member;
import com.alibaba.intl.bcds.goldroom.mail.enumeration.ServiceType;

public class AccountApprovedEmailInfo extends BaseEmailInfo {
	private Member member;

	public AccountApprovedEmailInfo(Member member) {
		this.setServiceType(ServiceType.NOTIFY_ACCOUNT_APPROVED);
		this.member = member;
		this.addReceiverEmail(member.getEmail());
		this.setSubject("黄金屋 [Gold Room] 系统邮件：您的帐号审批通过了。");
	}

	public void setMember(Member member) {
		this.member = member;
	}

	public Member getMember() {
		return member;
	}

}
