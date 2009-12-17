package com.alibaba.intl.bcds.goldroom.dao.ibatis;

import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import com.alibaba.intl.bcds.goldroom.dao.BookInfoDao;
import com.alibaba.intl.bcds.goldroom.dataobject.BookInfo;

public class BookInfoDaoImpl extends SqlMapClientDaoSupport implements
		BookInfoDao {

	public int deleteById(Integer id) {
		return getSqlMapClientTemplate().delete("BOOK_INFO.deleteById", id);
	}

	public Integer insert(BookInfo BookInfo) {
		return (Integer) getSqlMapClientTemplate().insert("BOOK_INFO.insert",
				BookInfo);
	}

	public List<BookInfo> listAll() {
		return getSqlMapClientTemplate().queryForList("BOOK_INFO.listAll");
	}

	public int updateById(BookInfo BookInfo) {
		return getSqlMapClientTemplate().update("BOOK_INFO.updateById",
				BookInfo);
	}

	@Override
	public BookInfo findById(Integer id) {
		return (BookInfo) getSqlMapClientTemplate().queryForObject(
				"BOOK_INFO.findById", id);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.alibaba.intl.bcds.goldroom.dao.BookInfoDao#selectBookInfoByIsbn(java
	 * .lang.String)
	 */
	@Override
	public BookInfo findBookInfoByIsbn(String isbn) {
		if (StringUtils.isEmpty(isbn)) {
			return null;
		}
		return (BookInfo) getSqlMapClientTemplate().queryForObject(
				"BOOK_INFO.findBookInfoByIsbn", isbn);
	}
}
