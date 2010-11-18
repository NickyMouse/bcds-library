package com.alibaba.intl.bcds.goldroom.util;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.compass.core.CompassCallback;
import org.compass.core.CompassException;
import org.compass.core.CompassHit;
import org.compass.core.CompassHits;
import org.compass.core.CompassQuery;
import org.compass.core.CompassQuery.SortDirection;
import org.compass.core.CompassQueryBuilder;
import org.compass.core.CompassQueryBuilder.CompassBooleanQueryBuilder;
import org.compass.core.CompassSession;
import org.compass.core.CompassTemplate;

import com.alibaba.intl.bcds.goldroom.constaints.BookStoreState;
import com.alibaba.intl.bcds.goldroom.dataobject.BookInfo;
import com.alibaba.intl.bcds.goldroom.result.BookSearchResult;
import com.alibaba.intl.bcds.goldroom.search.commons.constrans.BookSearchOption;
import com.alibaba.intl.bcds.goldroom.search.commons.constrans.SearchBookType;
import com.alibaba.intl.bcds.goldroom.search.commons.constrans.SearchKeywordFilter;

public class BookSearchHelper {

    private static Logger   logger = Logger.getLogger(BookSearchHelper.class);
    private CompassTemplate compassTemplate;

    public BookSearchResult searchBookByKeyword(final String kw, final SearchBookType type, final Integer skipSize,
                                                final Integer pageSize) {
        final String keyword = SearchKeywordFilter.filter(kw);
        return compassTemplate.execute(new CompassCallback<BookSearchResult>() {

            public BookSearchResult doInCompass(CompassSession session) throws CompassException {
                List<BookInfo> results = new ArrayList<BookInfo>(pageSize);
                CompassQueryBuilder queryBuilder = session.queryBuilder();
                CompassQuery query = null;
                CompassHit[] hits = null;
                if (SearchBookType.EBOOK.equals(type)) {
                    query = queryBuilder.bool().addMust(queryBuilder.queryString(keyword).toQuery()).addMustNot(queryBuilder.spanEq("bookInfo.storeState",
                                                                                                                                    BookStoreState.PAPER_BOOK.getValue())).toQuery();
                } else if (SearchBookType.PAPER_BOOK.equals(type)) {
                    query = queryBuilder.bool().addMust(queryBuilder.queryString(keyword).toQuery()).addMustNot(queryBuilder.spanEq("bookInfo.storeState",
                                                                                                                                    BookStoreState.EBOOK.getValue())).toQuery();
                } else {
                    query = queryBuilder.queryString(keyword).toQuery();
                }
                hits = query.hits().detach(skipSize, pageSize).getHits();
                int length = hits.length;
                for (int i = 0; i < length; i++) {
                    results.add((BookInfo) hits[i].data());
                }
                return new BookSearchResult(results, query.hits().getLength());
            }
        });
    }

    public BookSearchResult searchBookByTime(final Date startTime, final Date endTime, final SearchBookType type,
                                             final Integer skipSize, final Integer pageSize) {
        return compassTemplate.execute(new CompassCallback<BookSearchResult>() {

            public BookSearchResult doInCompass(CompassSession session) throws CompassException {
                List<BookInfo> results = new ArrayList<BookInfo>(pageSize);
                CompassQueryBuilder queryBuilder = session.queryBuilder();
                CompassQuery query = null;
                CompassHit[] hits = null;
                if (SearchBookType.EBOOK.equals(type)) {
                    query = queryBuilder.bool().addMust(queryBuilder.ge("bookInfo.gmtCreate", startTime)).addMust(queryBuilder.le("bookInfo.gmtCreate",
                                                                                                                                  endTime)).addMustNot(queryBuilder.spanEq("bookInfo.storeState",
                                                                                                                                                                           BookStoreState.PAPER_BOOK.getValue())).toQuery();
                } else if (SearchBookType.PAPER_BOOK.equals(type)) {
                    query = queryBuilder.bool().addMust(queryBuilder.ge("bookInfo.gmtCreate", startTime)).addMust(queryBuilder.le("bookInfo.gmtCreate",
                                                                                                                                  endTime)).addMustNot(queryBuilder.spanEq("bookInfo.storeState",
                                                                                                                                                                           BookStoreState.EBOOK.getValue())).toQuery();
                } else {
                    query = queryBuilder.bool().addMust(queryBuilder.ge("bookInfo.gmtCreate", startTime)).addMust(queryBuilder.le("bookInfo.gmtCreate",
                                                                                                                                  endTime)).toQuery();
                }
                hits = query.hits().detach(skipSize, pageSize).getHits();
                int length = hits.length;
                for (int i = 0; i < length; i++) {
                    results.add((BookInfo) hits[i].data());
                }
                return new BookSearchResult(results, query.hits().getLength());
            }
        });
    }

    public BookInfo searchBookByInfoId(final Integer bookInfoId) {
        return compassTemplate.execute(new CompassCallback<BookInfo>() {

            public BookInfo doInCompass(CompassSession session) throws CompassException {
                CompassQueryBuilder queryBuilder = session.queryBuilder();
                CompassQuery query = queryBuilder.term("bookInfo.id", bookInfoId);
                CompassHits hits = query.hits();
                if (hits.length() == 1) {
                    return (BookInfo) hits.data(0);
                } else if (hits.length() == 0) {
                    logger.error("duplicated book info, id: " + bookInfoId);
                } else {
                    logger.warn("bookInfo not exists, id: " + bookInfoId);
                }
                return null;
            }
        });
    }

    public BookSearchResult advancedBookSearch(BookSearchOption option, SearchBookType type, Integer skipSize,
                                               Integer pageSize) {
        // TODO
        throw new RuntimeException("To be implemented");
    }

    public BookSearchResult listAllBook(final SearchBookType type, final Integer skipSize, final Integer pageSize) {
        return compassTemplate.execute(new CompassCallback<BookSearchResult>() {

            public BookSearchResult doInCompass(CompassSession session) throws CompassException {
                Date startTime = new Date(0);
                Date endTime = new Date();
                List<BookInfo> results = new ArrayList<BookInfo>(pageSize);
                CompassQueryBuilder queryBuilder = session.queryBuilder();
                CompassQuery query = null;
                CompassHit[] hits = null;
                if (SearchBookType.EBOOK.equals(type)) {
                    query = queryBuilder.bool().addMust(queryBuilder.ge("bookInfo.gmtCreate", startTime)).addMust(queryBuilder.le("bookInfo.gmtCreate",
                                                                                                                                  endTime)).addMustNot(queryBuilder.spanEq("bookInfo.storeState",
                                                                                                                                                                           BookStoreState.PAPER_BOOK.getValue())).toQuery();
                } else if (SearchBookType.PAPER_BOOK.equals(type)) {
                    query = queryBuilder.bool().addMust(queryBuilder.ge("bookInfo.gmtCreate", startTime)).addMust(queryBuilder.le("bookInfo.gmtCreate",
                                                                                                                                  endTime)).addMustNot(queryBuilder.spanEq("bookInfo.storeState",
                                                                                                                                                                           BookStoreState.EBOOK.getValue())).toQuery();
                } else {
                    query = queryBuilder.bool().addMust(queryBuilder.ge("bookInfo.gmtCreate", startTime)).addMust(queryBuilder.le("bookInfo.gmtCreate",
                                                                                                                                  endTime)).toQuery();
                }
                query.addSort("bookInfo.gmtCreate", SortDirection.REVERSE);
                hits = query.hits().detach(skipSize, pageSize).getHits();
                int length = hits.length;
                for (int i = 0; i < length; i++) {
                    results.add((BookInfo) hits[i].data());
                }
                return new BookSearchResult(results, query.hits().getLength());
            }
        });
    }

    public BookSearchResult searchBookByInfoIds(final List<Integer> infoIdlist) {
        return compassTemplate.execute(new CompassCallback<BookSearchResult>() {

            public BookSearchResult doInCompass(CompassSession session) throws CompassException {
                List<BookInfo> results = new ArrayList<BookInfo>(infoIdlist.size());
                CompassQueryBuilder queryBuilder = session.queryBuilder();
                CompassBooleanQueryBuilder booleanQuery = queryBuilder.bool();
                for (Integer bookInfoId : infoIdlist) {
                    booleanQuery.addShould(queryBuilder.term("bookInfo.id", bookInfoId));
                }
                CompassQuery query = booleanQuery.toQuery();
                CompassHits hits = query.hits();
                int length = hits.length();
                for (int i = 0; i < length; i++) {
                    results.add((BookInfo) hits.data(i));
                }
                return new BookSearchResult(results, length);
            }
        });
    }

    public BookSearchResult searchBookByOwnersAndKeyword(String loginId, String keyword, Integer skipSize,
                                                         Integer pageSize) {
        // TODO
        throw new RuntimeException("To be implemented");
    }

    public void setCompassTemplate(CompassTemplate compassTemplate) {
        this.compassTemplate = compassTemplate;
    }

    public CompassTemplate getCompassTemplate() {
        return compassTemplate;
    }

}
