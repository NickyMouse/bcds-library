package com.alibaba.intl.bcds.goldroom.search.commons.constrans;

public enum SortField {

    BOOK_INFO_GMT_CREATE("bookInfo.gmtCreate");

    private String fieldName;

    SortField(String fieldName) {
        this.fieldName = fieldName;
    }

    public String getFieldName() {
        return fieldName;
    }

}
