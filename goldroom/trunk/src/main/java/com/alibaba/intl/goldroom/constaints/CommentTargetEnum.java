package com.alibaba.intl.goldroom.constaints;

public enum CommentTargetEnum {
    BOOK_INFO("bookInfo");

    private String value;

    private CommentTargetEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return this.value;
    }

}
