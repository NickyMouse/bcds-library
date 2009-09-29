package com.alibaba.intl.bcds.goldroom.search.commons.utils;

import java.util.Date;

public class SearchConditionHelper {
	private StringBuilder sb;

	public static SearchConditionHelper getInstance() {
		return new SearchConditionHelper();
	}

	private SearchConditionHelper() {
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
	public SearchConditionHelper addTerm(String field, String key) {
		sb.append("+").append(field).append(":").append(key);
		return this;
	}

	public SearchConditionHelper addFuzzy(String field, String key) {
		sb.append("+").append(field).append(":").append(key).append("~");
		return this;
	}

	public SearchConditionHelper addRange(String field, String min, String max) {
		sb.append("+").append(field).append(":[").append(min).append(" TO ")
				.append(max).append("]");
		return this;
	}

	public SearchConditionHelper addDateRange(String field, Date startTime,
			Date endTime) {
		sb.append("+").append(field).append(":[").append(startTime.getTime()).append(" TO ")
				.append(endTime.getTime()).append("]");
		return this;
	}
}
