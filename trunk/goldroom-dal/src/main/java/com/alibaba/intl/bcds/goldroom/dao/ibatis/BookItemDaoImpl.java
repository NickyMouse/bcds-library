package com.alibaba.intl.bcds.goldroom.dao.ibatis;

import java.util.List;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import com.alibaba.intl.bcds.goldroom.dao.BookItemDao;
import com.alibaba.intl.bcds.goldroom.dataobject.BookItemDO;

public class BookItemDaoImpl extends SqlMapClientDaoSupport implements
		BookItemDao {

	public int deleteById(Integer id) {
		return getSqlMapClientTemplate().delete("BOOK_ITEM.deleteById", id);
	}

	public BookItemDO findById(Integer id) {
		return (BookItemDO) getSqlMapClientTemplate().queryForObject(
				"BOOK_ITEM.findById", id);
	}

	public Integer insert(BookItemDO bookItemDO) {
		return (Integer) getSqlMapClientTemplate().insert("BOOK_ITEM.insert", bookItemDO);
	}

	public List<BookItemDao> listAll() {
		return getSqlMapClientTemplate().queryForList("BOOK_ITEM.listAll");
	}

	public int updateById(BookItemDO bookItemDO) {
		return getSqlMapClientTemplate().update("BOOK_ITEM.updateById", bookItemDO);
	}

}
