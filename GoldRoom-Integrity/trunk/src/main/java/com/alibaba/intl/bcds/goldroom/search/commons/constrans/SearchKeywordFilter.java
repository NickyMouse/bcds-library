package com.alibaba.intl.bcds.goldroom.search.commons.constrans;

public class SearchKeywordFilter {

    public static String filter(String word) {
        return word.replace(":", " ");
    }
}
