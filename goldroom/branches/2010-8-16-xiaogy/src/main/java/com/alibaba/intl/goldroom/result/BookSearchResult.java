package com.alibaba.intl.goldroom.result;

import java.util.List;

import com.alibaba.intl.bcds.goldroom.search.commons.dataobject.BookSearch;

public class BookSearchResult extends Result {

    private List<BookSearch> bookList;

    public BookSearchResult(List<BookSearch> bookList, int totalCount) {
        this.totalCount = totalCount;
        this.setBookList(bookList);
    }

    public void setBookList(List<BookSearch> bookList) {
        this.bookList = bookList;
    }

    public List<BookSearch> getBookList() {
        return bookList;
    }
}
