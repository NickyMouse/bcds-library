package com.alibaba.intl.bcds.goldroom.action.books;

import com.alibaba.intl.bcds.goldroom.action.base.BaseAction;
import com.alibaba.intl.bcds.goldroom.result.BookSearchResult;
import com.alibaba.intl.bcds.goldroom.search.commons.constrans.SearchBookType;
import com.alibaba.intl.bcds.goldroom.service.BookInfoService;

public class SearchBookListAction extends BaseAction {

    private static final long serialVersionUID = -6714583660333399107L;

    private BookInfoService   bookInfoService;
    private String            keyword;
    private BookSearchResult  bookSearchResult;

    private int               page;
    private int               pageSize;
    
    
    public int getPage() {
        return page;
    }
    
    public void setPage(int page) {
        this.page = page;
    }

    public int getPageSize() {
        return pageSize;
    }
    
    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public BookInfoService getBookInfoService() {
        return bookInfoService;
    }
    
    public void setBookInfoService(BookInfoService bookInfoService) {
        this.bookInfoService = bookInfoService;
    }

    public BookSearchResult getBookSearchResult() {
        return bookSearchResult;
    }
    
    public void setBookSearchResult(BookSearchResult bookSearchResult) {
        this.bookSearchResult = bookSearchResult;
    }

    public String getKeyword() {
        return keyword;
    }

    
    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    public String execute() throws Exception {
        if (page <= 0) {
            page = 1;
        }
        bookSearchResult = bookInfoService.searchBookByKeyword(keyword, SearchBookType.ALL, page, pageSize);
        return SUCCESS;
    }

}
