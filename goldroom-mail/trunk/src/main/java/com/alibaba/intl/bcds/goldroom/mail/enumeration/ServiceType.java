package com.alibaba.intl.bcds.goldroom.mail.enumeration;

public enum ServiceType {
	/**
	 * 有人预约的时候，邮件提醒
	 */
	NOTIFY_RETURN_BOOK("notify.return.book", "notifyReturnBook.vm"),

	/**
	 * 图书成功预约后,书主确认借书时,通知成功借阅者去拿书.
	 */
	NOTIFY_GET_BOOK("notify.get.book", "notifyGetBook.vm"),

	/**
	 * 用户申请帐号,审核通过邮件
	 */
	NOTIFY_ACCOUNT_APPROVED("notify.account.approved",
			"notifyAccountApproved.vm"),

	/**
	 * 有人预约的时候，邮件提醒
	 */
	NOTIFY_RESERVATION("notify.Reservation", "notifyReservation.vm");

	private String serviceName;
	private String templateName;

	ServiceType(String serviceName, String templateName) {
		this.serviceName = serviceName;
		this.templateName = templateName;
	}

	public String getServiceName() {
		return serviceName;
	}

	public String getTemplateName() {
		return templateName;
	}

}
