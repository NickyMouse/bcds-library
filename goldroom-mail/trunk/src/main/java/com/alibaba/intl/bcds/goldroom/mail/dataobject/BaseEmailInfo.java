package com.alibaba.intl.bcds.goldroom.mail.dataobject;

import com.alibaba.intl.bcds.goldroom.mail.enumeration.EmailType;
import com.alibaba.intl.bcds.goldroom.mail.enumeration.ServiceType;

public abstract class BaseEmailInfo {
	protected String receiverEmail;

	protected EmailType emailType = EmailType.TEXT;
	protected ServiceType serviceType;

	public String getReceiverEmail() {
		return receiverEmail;
	}

	public void setReceiverEmail(String receiverEmail) {
		this.receiverEmail = receiverEmail;
	}

	public void setEmailType(EmailType emailType) {
		this.emailType = emailType;
	}

	public EmailType getEmailType() {
		return emailType;
	}

	public ServiceType getServiceType() {
		return serviceType;
	}

}
