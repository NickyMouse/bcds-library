package com.alibaba.intl.goldroom.action.test;

import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;

import com.alibaba.intl.bcds.goldroom.search.commons.constrans.SearchBookType;
import com.alibaba.intl.goldroom.result.BookSearchResult;
import com.alibaba.intl.goldroom.service.BookInfoService;
import com.opensymphony.xwork2.ActionSupport;

public class SearchTestAction extends ActionSupport {

    private BookInfoService  bookInfoService;
    private String           keyword;
    private BookSearchResult bookSearchResult;

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    public BookSearchResult getBookSearchResult() {
        return bookSearchResult;
    }

    public void setBookSearchResult(BookSearchResult bookSearchResult) {
        this.bookSearchResult = bookSearchResult;
    }

    public BookInfoService getBookInfoService() {
        return bookInfoService;
    }

    public void setBookInfoService(BookInfoService bookInfoService) {
        this.bookInfoService = bookInfoService;
    }

    public String execute() throws Exception {
        bookSearchResult = bookInfoService.searchBookByKeyword(keyword, SearchBookType.ALL, 1, 20);
        if (bookSearchResult != null) {
            return SUCCESS;
        } else {
            return ERROR;
        }
    }
}
