package com.alibaba.intl.bcds.goldroom.dao;

import java.util.List;

import com.alibaba.intl.bcds.goldroom.dataobject.BookInfo;


public interface BookInfoDao {

    List<BookInfo> listAll();

    BookInfo save(BookInfo bookInfoDO);

    boolean updateById(BookInfo bookInfoDO);

    boolean deleteById(Integer id);

    BookInfo findById(Integer id);

    BookInfo findBookInfoByIsbn(String isbn);

}
