package com.alibaba.intl.bcds.goldroom.dao;

import java.util.List;

import com.alibaba.intl.bcds.goldroom.dataobject.BookItemLogDO;

public interface BookItemLogDao {
	List<BookItemLogDO> listAll();
	Integer insert(BookItemLogDO bookItemLogDO);
	int updateById(BookItemLogDO bookItemLogDO);
	int deleteById(Integer id);
	BookItemLogDO findById(Integer id);
}
