package com.alibaba.intl.bcds.goldroom.mail.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.lang.StringUtils;

public class FormatUtils {

    private static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

    public static String formatDate(Date date) {
        if (date != null) {
            return sdf.format(date);
        } else {
            return StringUtils.EMPTY;
        }

    }
}
