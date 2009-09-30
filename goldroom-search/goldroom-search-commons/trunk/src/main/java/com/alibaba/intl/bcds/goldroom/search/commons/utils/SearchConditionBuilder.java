package com.alibaba.intl.bcds.goldroom.search.commons.utils;

import java.util.Date;

public class SearchConditionBuilder {
	private StringBuilder sb;

	public static SearchConditionBuilder getInstance() {
		return new SearchConditionBuilder();
	}

	private SearchConditionBuilder() {
		sb = new StringBuilder();
	}

	public String buildConditions() {
		return sb.toString();
	}

	/**
	 * 
	 * 
	 * @return
	 */
	public SearchConditionBuilder addTerm(String field, String key) {
		sb.append("+").append(field).append(":").append(key);
		return this;
	}

	public SearchConditionBuilder addFuzzy(String field, String key) {
		sb.append("+").append(field).append(":").append(key).append("~");
		return this;
	}

	public SearchConditionBuilder addRange(String field, String min, String max) {
		sb.append("+").append(field).append(":[").append(min).append(" TO ")
				.append(max).append("]");
		return this;
	}

	public SearchConditionBuilder addDateRange(String field, Date startTime,
			Date endTime) {
		sb.append("+").append(field).append(":[").append(startTime.getTime()).append(" TO ")
				.append(endTime.getTime()).append("]");
		return this;
	}
}
