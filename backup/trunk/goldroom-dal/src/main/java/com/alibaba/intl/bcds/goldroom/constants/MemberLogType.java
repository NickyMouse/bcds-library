package com.alibaba.intl.bcds.goldroom.constants;

public enum MemberLogType {
	SIGN_IN("sign_in", 1), SIGN_OUT("sign_out", 2), APPLY("apply", 3), APPROVE(
			"approve", 4);

	private String strValue;

	private Integer intValue;

	private MemberLogType(String strValue, Integer intValue) {
		this.strValue = strValue;
		this.intValue = intValue;
	}

	public String getStrValue() {
		return this.strValue;
	}

	public Integer getIntValue() {
		return this.intValue;
	}

}
