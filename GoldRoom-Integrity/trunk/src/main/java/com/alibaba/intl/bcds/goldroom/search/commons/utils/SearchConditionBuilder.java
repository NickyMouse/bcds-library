package com.alibaba.intl.bcds.goldroom.search.commons.utils;

import java.util.Date;

public class SearchConditionBuilder {

    private static String ZERO_STRING = "0000000000000";
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
     * @return
     */
    public SearchConditionBuilder addTerm(String field, String key, boolean isAnd) {
        if (isAnd) {
            sb.append(" +");
        } else {
            sb.append(" ");
        }
        sb.append(field).append(":").append(key);
        return this;
    }

    public SearchConditionBuilder addTerm(String field, String key) {
        return addTerm(field, key, false);
    }

    public SearchConditionBuilder addFuzzy(String field, String key, boolean isAnd) {
        if (isAnd) {
            sb.append(" +");
        } else {
            sb.append(" ");
        }
        sb.append(field).append(":").append(key).append("~");
        return this;
    }

    public SearchConditionBuilder addFuzzy(String field, String key) {
        return addFuzzy(field, key, false);
    }

    public SearchConditionBuilder addRange(String field, String min, String max, boolean isAnd) {
        if (isAnd) {
            sb.append(" +");
        } else {
            sb.append(" ");
        }
        sb.append(field).append(":[").append(min).append(" TO ").append(max).append("]");
        return this;
    }

    public SearchConditionBuilder addRange(String field, String min, String max) {
        return addRange(field, min, max, false);
    }

    public SearchConditionBuilder addDateRange(String field, Date startTime, Date endTime, boolean isAnd) {
        if (isAnd) {
            sb.append(" +");
        } else {
            sb.append(" ");
        }
        sb.append(field).append(":[").append(dateToString(startTime)).append(" TO ").append(dateToString(endTime)).append(
                                                                                                                          "]");
        return this;
    }

    public SearchConditionBuilder addDateRange(String field, Date startTime, Date endTime) {
        return addDateRange(field, startTime, endTime, false);
    }

    private String dateToString(Date date) {
        StringBuilder strBuilder = new StringBuilder();
        strBuilder.append(date.getTime());

        if (strBuilder.length() < ZERO_STRING.length()) {
            strBuilder.insert(0, ZERO_STRING);
        } else {
            return strBuilder.toString();
        }
        int len = strBuilder.length();

        return strBuilder.substring(len - 13, len);
    }
}
