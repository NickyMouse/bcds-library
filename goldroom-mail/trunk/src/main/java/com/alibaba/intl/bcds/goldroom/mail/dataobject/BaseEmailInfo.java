package com.alibaba.intl.bcds.goldroom.mail.dataobject;

import java.util.ArrayList;
import java.util.List;

import com.alibaba.intl.bcds.goldroom.mail.enumeration.ServiceType;

public abstract class BaseEmailInfo {
	protected List<String> receiverEmails = new ArrayList<String>();
	private ServiceType serviceType;
	private String subject;
	public List<String> getReceiverEmails() {
		return receiverEmails;
	}

	public void addReceiverEmail(String receiverEmail) {
		this.receiverEmails.add(receiverEmail);
	}

	public ServiceType getServiceType() {
		return serviceType;
	}

	public void setServiceType(ServiceType serviceType) {
		this.serviceType = serviceType;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getSubject() {
		return subject;
	}

}
