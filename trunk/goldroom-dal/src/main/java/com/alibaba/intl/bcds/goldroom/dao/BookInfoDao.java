package com.alibaba.intl.bcds.goldroom.dao;

import java.util.List;

import com.alibaba.intl.bcds.goldroom.dataobject.BookInfoDO;

public interface BookInfoDao {
	List<BookInfoDO> listAll();
	Integer insert(BookInfoDO bookInfoDO);
	int updateById(BookInfoDO bookInfoDO);
	int deleteById(Integer id);
	BookInfoDO findById(Integer id);
}
