package com.alibaba.intl.bcds.goldroom.dao.ibatis;

import java.util.List;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import com.alibaba.intl.bcds.goldroom.dao.BookInfoDao;
import com.alibaba.intl.bcds.goldroom.dataobject.BookInfoDO;

public class BookInfoDaoImpl extends SqlMapClientDaoSupport implements
		BookInfoDao {

	public int deleteById(Integer id) {
		return getSqlMapClientTemplate().delete("BOOK_INFO.deleteById", id);
	}

	public Integer insert(BookInfoDO bookInfoDO) {
		return (Integer) getSqlMapClientTemplate().insert("BOOK_INFO.insert", bookInfoDO);
	}

	public List<BookInfoDO> listAll() {
		return getSqlMapClientTemplate().queryForList("BOOK_INFO.listAll");
	}

	public int updateById(BookInfoDO bookInfoDO) {
		return getSqlMapClientTemplate().update("BOOK_INFO.updateById", bookInfoDO);
	}

	@Override
	public BookInfoDO findById(Integer id) {
		return (BookInfoDO) getSqlMapClientTemplate().queryForObject(
				"BOOK_INFO.findById", id);
	}
}
