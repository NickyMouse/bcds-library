package com.alibaba.intl.bcds.goldroom.search.commons.service.impl;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang.StringUtils;

import com.alibaba.intl.bcds.goldroom.search.commons.constrans.SearchBookType;
import com.alibaba.intl.bcds.goldroom.search.commons.dao.BookSearchDao;
import com.alibaba.intl.bcds.goldroom.search.commons.dataobject.BookSearch;
import com.alibaba.intl.bcds.goldroom.search.commons.dataobject.helper.BookSearchConstrains;
import com.alibaba.intl.bcds.goldroom.search.commons.queryobject.BookSearchOption;
import com.alibaba.intl.bcds.goldroom.search.commons.queryobject.BookSearchQueryObject;
import com.alibaba.intl.bcds.goldroom.search.commons.service.BookSearchService;
import com.alibaba.intl.bcds.goldroom.search.commons.utils.SearchConditionBuilder;

@SuppressWarnings("unchecked")
public class BookSearchServiceImpl implements BookSearchService {

    public static long    MILLISECONDS_OF_DAY = 24 * 60 * 60 * 1000;
    private BookSearchDao bookSearchDao;

    public BookSearchDao getBookSearchDao() {
        return bookSearchDao;
    }

    public void setBookSearchDao(BookSearchDao bookSearchDao) {
        this.bookSearchDao = bookSearchDao;
    }

    public BookSearchQueryObject searchBookByCategoryId(Integer id, SearchBookType type, Integer skipResult,
                                                        Integer number) {
        SearchConditionBuilder builder = SearchConditionBuilder.getInstance().addTerm(
                                                                                      BookSearchConstrains.BOOK_CATEGORY_ID,
                                                                                      id.toString());
        if (SearchBookType.EBOOK.equals(type)) {
            builder.addTerm(BookSearchConstrains.HAS_EBOOK, Boolean.TRUE.toString(), true);
        } else if (SearchBookType.PAPER_BOOK.equals(type)) {
            builder.addTerm(BookSearchConstrains.HAS_EBOOK, Boolean.FALSE.toString(), true);
        }
        BookSearchQueryObject query = BookSearchQueryObject.getInstance(builder).setN(number).setSkipResult(skipResult).setPrimarySortFiled(
                                                                                                                                            "");
        bookSearchDao.searchByQuery(query);
        return query;
    }

    public BookSearchQueryObject searchBookByKeyword(String keyword, SearchBookType type, Integer skipResult,
                                                     Integer number) {
        SearchConditionBuilder builder = SearchConditionBuilder.getInstance().addTerm(BookSearchConstrains.BOOK_NAME,
                                                                                      keyword).addTerm(
                                                                                                       BookSearchConstrains.BOOK_DESCRIPTION,
                                                                                                       keyword).addTerm(
                                                                                                                        BookSearchConstrains.BOOK_TAGS,
                                                                                                                        keyword);
        if (SearchBookType.EBOOK.equals(type)) {
            builder.addTerm(BookSearchConstrains.HAS_EBOOK, Boolean.TRUE.toString(), true);
        } else if (SearchBookType.PAPER_BOOK.equals(type)) {
            builder.addTerm(BookSearchConstrains.HAS_EBOOK, Boolean.FALSE.toString(), true);
        }

        BookSearchQueryObject query = BookSearchQueryObject.getInstance(builder).setN(number).setSkipResult(skipResult).setPrimarySortFiled(
                                                                                                                                            BookSearchConstrains.BOOK_INFO_ID).setHighlight(
                                                                                                                                                                                            false).setReverse(
                                                                                                                                                                                                              true);
        bookSearchDao.searchByQuery(query);
        return query;
    }

    public BookSearchQueryObject searchBookByTime(Date startTime, Date endTime, SearchBookType type,
                                                  Integer skipResult, Integer number) {
        SearchConditionBuilder builder = SearchConditionBuilder.getInstance().addDateRange(
                                                                                           BookSearchConstrains.ITEM_FIRST_ADD_TIME,
                                                                                           startTime, endTime);
        if (SearchBookType.EBOOK.equals(type)) {
            builder.addTerm(BookSearchConstrains.HAS_EBOOK, Boolean.TRUE.toString(), true);
        } else if (SearchBookType.PAPER_BOOK.equals(type)) {
            builder.addTerm(BookSearchConstrains.HAS_EBOOK, Boolean.FALSE.toString(), true);
        }
        BookSearchQueryObject query = BookSearchQueryObject.getInstance(builder).setN(number).setSkipResult(skipResult).setPrimarySortFiled(
                                                                                                                                            BookSearchConstrains.ITEM_FIRST_ADD_TIME).setReverse(
                                                                                                                                                                                                 true);
        bookSearchDao.searchByQuery(query);
        return query;
    }

    public BookSearch searchBookByInfoId(Integer bookInfoId) {
        SearchConditionBuilder builder = SearchConditionBuilder.getInstance().addTerm(
                                                                                      BookSearchConstrains.BOOK_INFO_ID,
                                                                                      bookInfoId.toString());
        BookSearchQueryObject query = BookSearchQueryObject.getInstance(builder).setN(1).setSkipResult(0);
        bookSearchDao.searchByQuery(query);
        List<BookSearch> resultList = query.getResultList();
        if (resultList == null || resultList.size() == 0) {
            return null;
        }
        return resultList.get(0);
    }

    public BookSearchQueryObject advancedBookSearch(BookSearchOption option, SearchBookType type, Integer skipResult,
                                                    Integer number) {
        SearchConditionBuilder builder = SearchConditionBuilder.getInstance();
        if (StringUtils.isNotEmpty(option.getBookName())) {
            builder.addTerm(BookSearchConstrains.BOOK_NAME, option.getBookName(), true);
        }
        if (StringUtils.isNotEmpty(option.getDescription())) {
            builder.addTerm(BookSearchConstrains.BOOK_DESCRIPTION, option.getDescription(), true);
        }
        if (StringUtils.isNotEmpty(option.getIsbn())) {
            builder.addTerm(BookSearchConstrains.BOOK_ISBN, option.getIsbn(), true);
        }
        if (StringUtils.isNotEmpty(option.getPublisher())) {
            builder.addTerm(BookSearchConstrains.BOOK_PUBLISHER, option.getPublisher(), true);
        }
        if (option.getDaysBefore() != null) {
            int daysBefore = 0;
            if (StringUtils.isNumeric(option.getDaysBefore())) {
                daysBefore = Integer.valueOf(option.getDaysBefore());
            }

            Date today = Calendar.getInstance().getTime();
            if (daysBefore == 3) {
                builder.addDateRange(BookSearchConstrains.ITEM_FIRST_ADD_TIME, getDateFromNow(3), today, true);
            } else if (daysBefore == 10) {
                builder.addDateRange(BookSearchConstrains.ITEM_FIRST_ADD_TIME, getDateFromNow(10), today, true);
            } else if (daysBefore == 30) {
                builder.addDateRange(BookSearchConstrains.ITEM_FIRST_ADD_TIME, getDateFromNow(30), today, true);
            } else if (daysBefore > 30) {
                builder.addDateRange(BookSearchConstrains.ITEM_FIRST_ADD_TIME, new Date(0), getDateFromNow(30), true);
            }
        }
        if (SearchBookType.EBOOK.equals(type)) {
            builder.addTerm(BookSearchConstrains.HAS_EBOOK, Boolean.TRUE.toString(), true);
        } else if (SearchBookType.PAPER_BOOK.equals(type)) {
            builder.addTerm(BookSearchConstrains.HAS_EBOOK, Boolean.FALSE.toString(), true);
        }
        BookSearchQueryObject query = BookSearchQueryObject.getInstance(builder).setN(number).setSkipResult(skipResult).setPrimarySortFiled(
                                                                                                                                            BookSearchConstrains.ITEM_FIRST_ADD_TIME).setReverse(
                                                                                                                                                                                                 true);
        bookSearchDao.searchByQuery(query);
        return query;
    }

    private Date getDateFromNow(int days) {
        Calendar calendar = Calendar.getInstance();
        long time = calendar.getTime().getTime() - 3 * MILLISECONDS_OF_DAY;
        calendar.setTimeInMillis(time);
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        return calendar.getTime();
    }

    public BookSearchQueryObject listAllBook(SearchBookType type, Integer skipResult, Integer number) {
        SearchConditionBuilder builder = SearchConditionBuilder.getInstance().addDateRange(
                                                                                           BookSearchConstrains.ITEM_FIRST_ADD_TIME,
                                                                                           new Date(0), new Date());
        if (SearchBookType.EBOOK.equals(type)) {
            builder.addTerm(BookSearchConstrains.HAS_EBOOK, Boolean.TRUE.toString(), true);
        } else if (SearchBookType.PAPER_BOOK.equals(type)) {
            builder.addTerm(BookSearchConstrains.HAS_EBOOK, Boolean.FALSE.toString(), true);
        }

        BookSearchQueryObject query = BookSearchQueryObject.getInstance(builder).setN(number).setSkipResult(skipResult).setPrimarySortFiled(
                                                                                                                                            BookSearchConstrains.ITEM_FIRST_ADD_TIME).setReverse(
                                                                                                                                                                                                 true);
        bookSearchDao.searchByQuery(query);
        return query;
    }

    public BookSearchQueryObject searchBookByInfoIds(List<Integer> infoIdlist) {
        if (infoIdlist == null || infoIdlist.size() == 0) {
            return BookSearchQueryObject.EMPTY_RESULT;
        }

        SearchConditionBuilder builder = SearchConditionBuilder.getInstance();
        for (Integer id : infoIdlist) {
            builder.addTerm(BookSearchConstrains.BOOK_INFO_ID, id.toString());
        }
        BookSearchQueryObject query = BookSearchQueryObject.getInstance(builder).setN(infoIdlist.size()).setSkipResult(
                                                                                                                       0).setPrimarySortFiled(
                                                                                                                                              BookSearchConstrains.ITEM_FIRST_ADD_TIME).setReverse(
                                                                                                                                                                                                   true);
        bookSearchDao.searchByQuery(query);
        return query;
    }

    @Override
    public BookSearchQueryObject searchBookByOwnersAndKeyword(String loginId, String keyword, Integer skipResult,
                                                              Integer number) {
        // 防止分词器把用户的loginid切开了
        loginId = loginId.replace('.', '@');
        SearchConditionBuilder builder = SearchConditionBuilder.getInstance().addTerm(BookSearchConstrains.BOOK_NAME,
                                                                                      keyword, true).addTerm(
                                                                                                             BookSearchConstrains.BOOK_OWNERS,
                                                                                                             loginId,
                                                                                                             true);
        BookSearchQueryObject query = BookSearchQueryObject.getInstance(builder).setN(number).setSkipResult(skipResult).setPrimarySortFiled(
                                                                                                                                            BookSearchConstrains.BOOK_INFO_ID).setHighlight(
                                                                                                                                                                                            true).setReverse(
                                                                                                                                                                                                             true);
        bookSearchDao.searchByQuery(query);
        return query;
    }
}
