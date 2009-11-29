package com.alibaba.intl.bcds.goldroom.mail.enumeration;

public enum EmailType {
	TEXT("text"), EVENT("event");

	private String typeName;

	public String getTypeName() {
		return typeName;
	}

	EmailType(String typeName) {
		this.typeName = typeName;
	}
}
