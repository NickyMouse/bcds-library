package com.alibaba.intl.bcds.goldroom.search.commons.service;

import java.util.Date;
import java.util.List;

import com.alibaba.intl.bcds.goldroom.search.commons.constrans.SearchBookType;
import com.alibaba.intl.bcds.goldroom.search.commons.dataobject.BookSearch;
import com.alibaba.intl.bcds.goldroom.search.commons.queryobject.BookSearchOption;
import com.alibaba.intl.bcds.goldroom.search.commons.queryobject.BookSearchQueryObject;

public interface BookSearchService {

    public BookSearchQueryObject searchBookByCategoryId(Integer catId, SearchBookType type, Integer skipResult,
                                                        Integer number);

    public BookSearchQueryObject searchBookByKeyword(String keyword, SearchBookType type, Integer skipResult,
                                                     Integer number);

    public BookSearchQueryObject searchBookByTime(Date startTime, Date endTime, SearchBookType type,
                                                  Integer skipResult, Integer number);

    public BookSearch searchBookByInfoId(Integer bookInfoId);

    public BookSearchQueryObject advancedBookSearch(BookSearchOption option, SearchBookType type, Integer skipResult,
                                                    Integer number);

    public BookSearchQueryObject listAllBook(SearchBookType type, Integer skipResult, Integer number);

    public BookSearchQueryObject searchBookByInfoIds(List<Integer> infoIdlist);

    public BookSearchQueryObject searchBookByOwnersAndKeyword(String loginId, String keyword, Integer skipResult,
                                                              Integer number);
}
