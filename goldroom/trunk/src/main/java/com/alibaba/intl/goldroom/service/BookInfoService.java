package com.alibaba.intl.goldroom.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.flex.remoting.RemotingDestination;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.alibaba.intl.bcds.goldroom.search.commons.dataobject.BookSearch;
import com.alibaba.intl.bcds.goldroom.search.commons.queryobject.BookSearchOption;
import com.alibaba.intl.bcds.goldroom.search.commons.queryobject.BookSearchQueryObject;
import com.alibaba.intl.bcds.goldroom.search.commons.service.BookSearchService;
import com.alibaba.intl.goldroom.dao.BookInfoDao;
import com.alibaba.intl.goldroom.dataobject.BookInfo;
import com.alibaba.intl.goldroom.remote.BookInfoFetcher;
import com.alibaba.intl.goldroom.result.BookSearchResult;

@Service
@RemotingDestination
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

    public boolean addBookInfo(BookInfo bookInfo) {
        if (bookInfoDao.findBookInfoByIsbn(bookInfo.getIsbn()) != null) {
            return false;
        }
        bookInfoDao.save(bookInfo);
        return true;
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

    public BookSearchResult searchBookByKeyword(String keyword, int page, int pageSize) {
        BookSearchQueryObject obj = bookSearchService.searchBookByKeyword(keyword, (page - 1) * pageSize, pageSize);
        return new BookSearchResult(obj.getResultList(), obj.getTotalCount());

    }

    public BookSearchResult searchBookByTime(Date startTime, Date endTime, int page, int pageSize) {
        BookSearchQueryObject obj = bookSearchService.searchBookByTime(startTime, endTime, (page - 1) * pageSize,
                                                                       pageSize);
        return new BookSearchResult(obj.getResultList(), obj.getTotalCount());
    }

    public BookSearch searchBookByInfoId(Integer bookInfoId) {
        BookSearch obj = bookSearchService.searchBookByInfoId(bookInfoId);
        return obj;
    }

    public BookSearchResult advancedBookSearch(String bookName, String publisher, String isbn, String description,
                                               String daysBefore, int page, int pageSize) {
        BookSearchOption option = new BookSearchOption();
        option.setBookName(bookName);
        option.setPublisher(publisher);
        option.setIsbn(isbn);
        option.setDaysBefore(daysBefore);
        option.setDescription(description);
        BookSearchQueryObject obj = bookSearchService.advancedBookSearch(option, (page - 1) * pageSize, pageSize);
        return new BookSearchResult(obj.getResultList(), obj.getTotalCount());
    }

    public BookSearchResult listAllBook(int page, int pageSize) {
        BookSearchQueryObject obj = bookSearchService.listAllBook((page - 1) * pageSize, pageSize);
        return new BookSearchResult(obj.getResultList(), obj.getTotalCount());
    }

    public BookSearchResult searchBookByInfoIds(List<Integer> infoIdlist) {
        BookSearchQueryObject obj = bookSearchService.searchBookByInfoIds(infoIdlist);
        return new BookSearchResult(obj.getResultList(), obj.getTotalCount());
    }

    public BookSearchResult searchBookByOwnersAndKeyword(String loginId, String keyword, int page, int pageSize) {
        BookSearchQueryObject obj = bookSearchService.searchBookByOwnersAndKeyword(loginId, keyword, (page - 1)
                                                                                                     * pageSize,
                                                                                   pageSize);
        return new BookSearchResult(obj.getResultList(), obj.getTotalCount());
    }

}
