package com.alibaba.intl.bcds.goldroom.action.books;

import java.util.ArrayList;
import java.util.List;

import com.alibaba.intl.bcds.goldroom.action.base.BaseAction;
import com.alibaba.intl.bcds.goldroom.action.books.dto.BookBigObject;
import com.alibaba.intl.bcds.goldroom.action.books.dto.BookBigObjectPage;
import com.alibaba.intl.bcds.goldroom.dataobject.BookInfo;
import com.alibaba.intl.bcds.goldroom.dataobject.BookItem;
import com.alibaba.intl.bcds.goldroom.result.BookSearchResult;
import com.alibaba.intl.bcds.goldroom.search.commons.constrans.SearchBookType;
import com.alibaba.intl.bcds.goldroom.service.BookInfoService;
import com.alibaba.intl.bcds.goldroom.service.BookItemService;

public class SearchBookListAction extends BaseAction {

    private static final long   serialVersionUID = -6714583660333399107L;

    private BookInfoService     bookInfoService;
    private String              keyword;
    private String              bookType;
    private BookItemService     bookItemService;

    private int                 page;
    private int                 pageSize;

    private BookBigObjectPage   bigObjectPage;

    public BookBigObjectPage getBigObjectPage() {
        return bigObjectPage;
    }

    public void setBookItemService(BookItemService bookItemService) {
        this.bookItemService = bookItemService;
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

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    public String execute() throws Exception {
        List<BookBigObject> bigObjects       = new ArrayList<BookBigObject>();
        BookSearchResult bookSearchResult = null;
        SearchBookType bt = null;
        if (page <= 0) {
            page = 1;
        }
        if (bookType == null || "all".equals(bookType)) {
            bt = SearchBookType.ALL;
        } else if ("ebook".equals(bookType)) {
            bt = SearchBookType.EBOOK;
        } else {
            bt = SearchBookType.PAPER_BOOK;
        }
        if (keyword == null || "".equals(keyword.trim())) {
            bookSearchResult = bookInfoService.listAllBook(bt, page, pageSize);
        } else {
            bookSearchResult = bookInfoService.searchBookByKeyword(keyword, bt, page, pageSize);
        }
        if (bookSearchResult != null && bookSearchResult.getBookList() != null) {
            for (int i = 0; i < bookSearchResult.getBookList().size(); i++) {
                BookInfo info = bookSearchResult.getBookList().get(i);
                List<BookItem> item = null;
                if (info.getId() != null) {
                    item = bookItemService.listBookItemByBookInfoId(info.getId());
                }
                BookBigObject bigObject = new BookBigObject(info, item);
                bigObjects.add(bigObject);
            }
        }
        bigObjectPage = new BookBigObjectPage(bigObjects, bookSearchResult.getTotalCount());
        return SUCCESS;
    }

}
