package com.alibaba.intl.bcds.goldroom.mail.utils;

public class MailDto {

	public String from;
	public String subject;
	public String text;

	
	public String[] to;

	public String[] getTo() {
		return to;
	}

	public void setTo(String[] to) {
		this.to = to;
	}

	public String getFrom() {
		return from;
	}

	public void setFrom(String from) {
		this.from = from;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}


}
