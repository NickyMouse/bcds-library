package com.alibaba.intl.bcds.goldroom.search.commons.constrans;

public enum SearchBookType {
    ALL("all"), EBOOK("ebook"), PAPER_BOOK("pbook");

    private String value;

    SearchBookType(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static SearchBookType getSearchBookType(String type) {
        if (EBOOK.value.equalsIgnoreCase(type)) {
            return EBOOK;
        } else if (PAPER_BOOK.value.equalsIgnoreCase(type)) {
            return PAPER_BOOK;
        } else {
            return ALL;
        }
    }
}
