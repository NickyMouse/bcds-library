package com.alibaba.intl.bcds.goldroom.action.books;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
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
    
    private String              aliTalk;

    private BookBigObjectPage   bigObjectPage;

    public BookBigObjectPage getBigObjectPage() {
        return bigObjectPage;
    }
    
    public String getAliTalk() {
        return aliTalk;
    }
    
    public void setAliTalk(String aliTalk) {
        this.aliTalk = aliTalk;
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
        bt = SearchBookType.getSearchBookType(bookType);
        
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
    
    public String findWangWang() throws IOException{
        String httpUrl = this.getRequest().getParameter("httpUrl");
        long start = System.currentTimeMillis();
        log.info("chaosenww1:" + start + ":" + httpUrl);
        URL url = new URL(httpUrl);
        log.info("chaosenww2:" + start + ":" + httpUrl + ":" + (System.currentTimeMillis() - start));
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        log.info("chaosenww3:" + start + ":" + httpUrl + ":" + (System.currentTimeMillis() - start));
        log.debug(httpUrl + ":" +conn.getResponseCode());//必须对conn做一次动作，不然返回的URL不会变，即返回的不是重定向后的图片URL
        if(conn.getURL().toString().endsWith("online.gif")){
            log.info("chaosenww4:" + start + ":" + httpUrl + ":" + (System.currentTimeMillis() - start));
            this.getRequest().setAttribute("userOnline", "yes");
        }
        long end = System.currentTimeMillis();
        log.info("chaosenww5:" + end+ ":" + httpUrl + ":" + (end - start) );
        return "json";
    }
    
    public void testQz() throws IOException{
        log.info("loop for test Quartz");
        long start = System.currentTimeMillis();
        String httpUrl = "http://amos.im.alisoft.com/online.aw?v=2&uid=linchaosen&site=cnalichn&s=1";
        log.info("loop chaosenww1:" + start + ":" + httpUrl);
        URL url = new URL(httpUrl);
        log.info("loop chaosenww2:" + start + ":" + httpUrl + ":" + (System.currentTimeMillis() - start));
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        log.info("loop chaosenww3:" + start + ":" + httpUrl + ":" + (System.currentTimeMillis() - start));
        log.debug(httpUrl + ":" +conn.getResponseCode());//必须对conn做一次动作，不然返回的URL不会变，即返回的不是重定向后的图片URL
        if(conn.getURL().toString().endsWith("online.gif")){
            log.info("loop chaosenww4:" + start + ":" + httpUrl + ":" + (System.currentTimeMillis() - start));
        }
        long end = System.currentTimeMillis();
        log.info("loop chaosenww5:" + end+ ":" + httpUrl + ":" + (end - start) );
    }
}
