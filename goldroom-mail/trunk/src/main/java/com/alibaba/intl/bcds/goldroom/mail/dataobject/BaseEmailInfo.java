package com.alibaba.intl.bcds.goldroom.mail.dataobject;

import java.util.ArrayList;
import java.util.List;

import com.alibaba.intl.bcds.goldroom.mail.enumeration.ServiceType;

public abstract class BaseEmailInfo {
	protected List<String> receiverEmails = new ArrayList<String>();
	private ServiceType serviceType;

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

}
