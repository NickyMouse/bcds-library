package com.alibaba.intl.bcds.goldroom.search.builder.utils;

public enum BuildSearchMode {

	FULL("full"), INCREMENT("inc");

	private String value;

	public String getValue() {
		return value;
	}

	BuildSearchMode(String value) {
		this.value = value;
	}
}
