package com.alibaba.intl.bcds.goldroom.search.commons.utils;

import org.apache.commons.lang.StringUtils;

public class NumberUtils {

    public static Integer toInteger(String number) {
        Integer value = null;
        if (StringUtils.isNotEmpty(number)) {
            try {
                value = Integer.valueOf(number);
            } catch (NumberFormatException e) {
                return null;
            }
        }
        return value;
    }

    public static Long toLong(String number) {
        Long value = null;
        if (StringUtils.isNotEmpty(number)) {
            try {
                value = Long.valueOf(number);
            } catch (NumberFormatException e) {
                return null;
            }
        }
        return value;
    }

    public static Long toLong(String number, long defaultValue) {
        Long value = null;
        if (StringUtils.isNotEmpty(number)) {
            try {
                value = Long.valueOf(number);
                return value;
            } catch (NumberFormatException e) {
                return defaultValue;
            }
        } else {
            return defaultValue;
        }
    }
}
