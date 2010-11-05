package com.alibaba.intl.bcds.goldroom.result;

import java.util.List;

import com.alibaba.intl.bcds.goldroom.dataobject.BookInfo;

public class BookSearchResult extends Result {

    private List<BookInfo> bookList;

    public BookSearchResult(List<BookInfo> bookList, int totalCount) {
        this.totalCount = totalCount;
        this.setBookList(bookList);
    }

    public void setBookList(List<BookInfo> bookList) {
        this.bookList = bookList;
    }

    public List<BookInfo> getBookList() {
        return bookList;
    }
}
