package com.alibaba.intl.bcds.goldroom.mail.dataobject;

import java.util.Date;

public class EventEmailInfo extends BaseEmailInfo {
	private Date eventStartDate;
	private Date eventEndDate;
	private String toDo;

	public Date getEventStartDate() {
		return eventStartDate;
	}

	public void setEventStartDate(Date eventStartDate) {
		this.eventStartDate = eventStartDate;
	}

	public Date getEventEndDate() {
		return eventEndDate;
	}

	public void setEventEndDate(Date eventEndDate) {
		this.eventEndDate = eventEndDate;
	}

	public void setToDo(String toDo) {
		this.toDo = toDo;
	}

	public String getToDo() {
		return toDo;
	}
}
