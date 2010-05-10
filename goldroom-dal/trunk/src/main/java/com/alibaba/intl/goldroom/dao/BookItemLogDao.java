package com.alibaba.intl.goldroom.dao;

import java.util.List;

import com.alibaba.intl.goldroom.dataobject.BookItemLog;

public interface BookItemLogDao {

    List<BookItemLog> listAll();

    BookItemLog save(BookItemLog bookItemLogDO);

    boolean updateById(BookItemLog bookItemLogDO);

    boolean deleteById(Integer id);

    BookItemLog findById(Integer id);
}
