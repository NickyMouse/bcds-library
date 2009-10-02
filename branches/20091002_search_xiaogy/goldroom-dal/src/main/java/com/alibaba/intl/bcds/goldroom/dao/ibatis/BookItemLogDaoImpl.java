package com.alibaba.intl.bcds.goldroom.dao.ibatis;

import java.util.List;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import com.alibaba.intl.bcds.goldroom.dao.BookItemLogDao;
import com.alibaba.intl.bcds.goldroom.dataobject.BookItemDO;
import com.alibaba.intl.bcds.goldroom.dataobject.BookItemLogDO;

public class BookItemLogDaoImpl extends SqlMapClientDaoSupport implements
		BookItemLogDao {

	public int deleteById(Integer id) {
		return getSqlMapClientTemplate().delete("BOOK_ITEM_LOG.deleteById", id);
	}

	public BookItemLogDO findById(Integer id) {
		return (BookItemLogDO) getSqlMapClientTemplate().queryForObject(
				"BOOK_ITEM_LOG.findById", id);
	}

	public Integer insert(BookItemLogDO bookItemLogDO) {
		return (Integer) getSqlMapClientTemplate().insert("BOOK_ITEM_LOG.insert",
				bookItemLogDO);
	}

	public List<BookItemLogDO> listAll() {
		return getSqlMapClientTemplate().queryForList("BOOK_ITEM_LOG.listAll");
	}

	public int updateById(BookItemLogDO bookItemLogDO) {
		return getSqlMapClientTemplate().update("BOOK_ITEM_LOG.updateById", bookItemLogDO);
	}

}
