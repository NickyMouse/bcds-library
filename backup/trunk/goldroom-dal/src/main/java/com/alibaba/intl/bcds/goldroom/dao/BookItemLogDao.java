package com.alibaba.intl.bcds.goldroom.dao;

import java.util.List;

import com.alibaba.intl.bcds.goldroom.dataobject.BookItemLog;

public interface BookItemLogDao {
	List<BookItemLog> listAll();
	Integer insert(BookItemLog bookItemLogDO);
	int updateById(BookItemLog bookItemLogDO);
	int deleteById(Integer id);
	BookItemLog findById(Integer id);
}
