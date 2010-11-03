package com.alibaba.intl.bcds.goldroom.action.books;

import com.alibaba.intl.bcds.goldroom.action.base.BaseAction;
import com.alibaba.intl.bcds.goldroom.result.BookSearchResult;
import com.alibaba.intl.bcds.goldroom.search.commons.constrans.SearchBookType;
import com.alibaba.intl.bcds.goldroom.service.BookInfoService;

public class SearchBookListAction extends BaseAction {

    private static final long serialVersionUID = -6714583660333399107L;

    private BookInfoService   bookInfoService;
    private String            keyword;
    private String            bookType;
    private BookSearchResult  bookSearchResult;

    private int               page;
    private int               pageSize;
    private int               pageSize1;
    
    public int getPageSize1() {
        return pageSize1;
    }
    
    public void setPageSize1(int pageSize1) {
        this.pageSize1 = pageSize1;
    }

    public String getBookType() {
        return bookType;
    }

    public void setBookType(String bookType) {
        this.bookType = bookType;
    }

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
        SearchBookType bt = null;
        if (page <= 0) {
            page = 1;
        }
        if (pageSize1 <= 0) {
            pageSize1 = 10;
        }
        if(bookType == null || "all".equals(bookType)){
            bt = SearchBookType.ALL;
        }else if("ebook".equals(bookType)){
            bt = SearchBookType.EBOOK;
        }else{
            bt = SearchBookType.PAPER_BOOK;
        }
        if(keyword == null || "".equals(keyword.trim())){
            bookSearchResult = bookInfoService.listAllBook(bt, page, pageSize1);
        }else{
            System.out.println("keyword:" + keyword +",bt:" + bt +",pageSize1:" + pageSize1);
            bookSearchResult = bookInfoService.searchBookByKeyword(keyword, bt, page, pageSize1);
        }
        return SUCCESS;
    }

}
