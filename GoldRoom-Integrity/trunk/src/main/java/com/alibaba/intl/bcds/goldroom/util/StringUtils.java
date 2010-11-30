package com.alibaba.intl.bcds.goldroom.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class StringUtils extends org.apache.commons.lang.StringUtils {

    public static Date conver(String string) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        try {
            return sdf.parse(string);
        } catch (ParseException e) {
            return null;
        }
    }

    public static String converDateToString(Date date) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        try {
            return sdf.format(date);
        } catch (Exception e) {
            return null;
        }
    }

}
