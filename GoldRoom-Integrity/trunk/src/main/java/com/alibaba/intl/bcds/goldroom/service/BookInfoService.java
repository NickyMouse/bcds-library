package com.alibaba.intl.bcds.goldroom.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.alibaba.intl.bcds.goldroom.dao.BookInfoDao;
import com.alibaba.intl.bcds.goldroom.dataobject.BookInfo;
import com.alibaba.intl.bcds.goldroom.remote.BookInfoFetcher;
import com.alibaba.intl.bcds.goldroom.result.BookSearchResult;
import com.alibaba.intl.bcds.goldroom.search.commons.constrans.SearchBookType;
import com.alibaba.intl.bcds.goldroom.search.commons.queryobject.BookSearchOption;

@Transactional
@SuppressWarnings("unchecked")
public class BookInfoService {

    @Autowired
    private BookInfoDao       bookInfoDao;

    @Autowired
    private BookInfoFetcher   bookInfoFetcher;

    @Autowired
    private BookSearchService bookSearchService;

    public BookInfo findBookInfoByIsbn(String isbn) {
        return bookInfoDao.findBookInfoByIsbn(isbn);
    }

    public List<BookInfo> listBookInfoByIds(List<Integer> bookInfoIds) {
        return bookInfoDao.listBookInfoByIds(bookInfoIds);
    }

    public boolean updateBookInfo(BookInfo bookInfo) {
        return bookInfoDao.updateById(bookInfo);
    }

    public BookInfo addBookInfo(BookInfo bookInfo) {
        if (bookInfoDao.findBookInfoByIsbn(bookInfo.getIsbn()) != null) {
            return null;
        }
        bookInfoDao.save(bookInfo);
        return bookInfo;
    }

    public BookInfo findBookInfoById(int id) {
        return bookInfoDao.findById(id);
    }

    public BookInfo getBookInfoFromDbAndNetWork(String isbn) {
        BookInfo bookInfo = bookInfoDao.findBookInfoByIsbn(isbn);
        if (bookInfo == null) {
            bookInfo = bookInfoFetcher.fetch(isbn);
            if (bookInfo != null) {
                return bookInfoDao.save(bookInfo);
            }
        }
        return bookInfo;
    }

    // @RemotingInclude
    // public void updateCategory(BookInfo bookInfo) {
    // bookInfoDao.updateCategory(bookInfo);
    // }

    public BookSearchResult searchBookByKeyword(String keyword, SearchBookType type, int page, int pageSize) {
        return bookSearchService.searchBookByKeyword(keyword, type, (page - 1) * pageSize, pageSize);

    }

    public BookSearchResult searchBookByTime(Date startTime, Date endTime, SearchBookType type, int page, int pageSize) {
        return bookSearchService.searchBookByTime(startTime, endTime, type, (page - 1) * pageSize, pageSize);
    }

    public BookInfo searchBookByInfoId(Integer bookInfoId) {
        return bookSearchService.searchBookByInfoId(bookInfoId);
    }

    public BookSearchResult advancedBookSearch(String bookName, String publisher, String isbn, String description,
                                               String daysBefore, int page, int pageSize) {
        BookSearchOption option = new BookSearchOption();
        option.setBookName(bookName);
        option.setPublisher(publisher);
        option.setIsbn(isbn);
        option.setDaysBefore(daysBefore);
        option.setDescription(description);
        return bookSearchService.advancedBookSearch(option, SearchBookType.ALL, (page - 1) * pageSize, pageSize);
    }

    public BookSearchResult listAllBook(SearchBookType type, int page, int pageSize) {
        return bookSearchService.listAllBook(type, (page - 1) * pageSize, pageSize);
    }

    public BookSearchResult searchBookByInfoIds(List<Integer> infoIdlist) {
        return bookSearchService.searchBookByInfoIds(infoIdlist);
    }

    public BookSearchResult searchBookByOwnersAndKeyword(String loginId, String keyword, int page, int pageSize) {
        return bookSearchService.searchBookByOwnersAndKeyword(loginId, keyword, (page - 1) * pageSize, pageSize);
    }

}
