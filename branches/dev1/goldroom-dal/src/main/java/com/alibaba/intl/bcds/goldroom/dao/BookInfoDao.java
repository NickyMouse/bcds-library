package com.alibaba.intl.bcds.goldroom.dao;

import java.util.List;

import com.alibaba.intl.bcds.goldroom.dataobject.BookInfo;

public interface BookInfoDao {
    List<BookInfo> listAll();

    Integer insert(BookInfo bookInfoDO);

    int updateById(BookInfo bookInfoDO);

    int deleteById(Integer id);

    BookInfo findById(Integer id);

    /**
     * 通过isbn查询书的信息
     * 
     * @param isbn
     */
    BookInfo findBookInfoByIsbn(String isbn);

}
