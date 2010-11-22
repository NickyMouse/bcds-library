package com.alibaba.intl.bcds.goldroom.search.commons.constrans;

import org.apache.commons.lang.xwork.StringUtils;

public class SearchKeywordFilter {

    public static String filter(String word) {
        if (StringUtils.isNotBlank(word)) {
            return word.replaceAll("[:\\[\\]]", " ");
        } else {
            return StringUtils.EMPTY;
        }
    }
}
