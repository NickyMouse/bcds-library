package com.alibaba.intl.bcds.goldroom.constaints;

public enum BookStoreState {
    BOTH("both"), EBOOK("ebook"), PAPER_BOOK("paper");

    private String value;

    private BookStoreState(String value) {
        this.value = value;
    }

    public String getValue() {
        return this.value;
    }

}
