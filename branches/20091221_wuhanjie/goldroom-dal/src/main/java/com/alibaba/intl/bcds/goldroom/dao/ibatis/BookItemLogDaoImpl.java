package com.alibaba.intl.bcds.goldroom.dao.ibatis;

import java.util.List;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import com.alibaba.intl.bcds.goldroom.dao.BookItemLogDao;
import com.alibaba.intl.bcds.goldroom.dataobject.BookItemLog;

public class BookItemLogDaoImpl extends SqlMapClientDaoSupport implements
		BookItemLogDao {

	public int deleteById(Integer id) {
		return getSqlMapClientTemplate().delete("BOOK_ITEM_LOG.deleteById", id);
	}

	public BookItemLog findById(Integer id) {
		return (BookItemLog) getSqlMapClientTemplate().queryForObject(
				"BOOK_ITEM_LOG.findById", id);
	}

	public Integer insert(BookItemLog bookItemLogDO) {
		return (Integer) getSqlMapClientTemplate().insert("BOOK_ITEM_LOG.insert",
				bookItemLogDO);
	}

	public List<BookItemLog> listAll() {
		return getSqlMapClientTemplate().queryForList("BOOK_ITEM_LOG.listAll");
	}

	public int updateById(BookItemLog bookItemLogDO) {
		return getSqlMapClientTemplate().update("BOOK_ITEM_LOG.updateById", bookItemLogDO);
	}

}
