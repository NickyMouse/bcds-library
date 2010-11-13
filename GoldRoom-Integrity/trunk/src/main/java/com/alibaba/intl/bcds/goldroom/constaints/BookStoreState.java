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

    public static BookStoreState getUpdatedStoreState(String oldState, String newState) {
        return getUpdatedStoreState(getBookStoreState(oldState), getBookStoreState(newState));
    }

    public static BookStoreState getUpdatedStoreState(String oldState, BookStoreState newState) {
        return getUpdatedStoreState(getBookStoreState(oldState), newState);
    }

    public static BookStoreState getUpdatedStoreState(BookStoreState oldState, BookStoreState newState) {
        if (oldState == null) {
            return newState;
        }
        if (BOTH.equals(oldState)) {
            return BOTH;
        }
        if (oldState.equals(newState)) {
            return oldState;
        } else {
            return BOTH;
        }
    }

    public static BookStoreState getBookStoreState(String state) {
        if (PAPER_BOOK.getValue().equals(state)) {
            return PAPER_BOOK;
        } else if (EBOOK.getValue().equals(state)) {
            return EBOOK;
        } else if (BOTH.getValue().equals(state)) {
            return BOTH;
        } else {
            return null;
        }
    }

    public static boolean isEBookExist(String state) {
        if (EBOOK.getValue().equals(state) || BOTH.getValue().equals(state)) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean isPaperBookExist(String state) {
        if (PAPER_BOOK.getValue().equals(state) || BOTH.getValue().equals(state)) {
            return true;
        } else {
            return false;
        }
    }
}
