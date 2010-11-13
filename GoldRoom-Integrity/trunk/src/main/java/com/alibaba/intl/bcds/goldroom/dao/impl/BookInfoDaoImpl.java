package com.alibaba.intl.bcds.goldroom.dao.impl;

import java.util.Date;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.hibernate.Query;
import org.springframework.beans.BeanUtils;

import com.alibaba.intl.bcds.goldroom.dao.BaseDao;
import com.alibaba.intl.bcds.goldroom.dao.BookInfoDao;
import com.alibaba.intl.bcds.goldroom.dataobject.BookInfo;

@SuppressWarnings("unchecked")
public class BookInfoDaoImpl extends BaseDao implements BookInfoDao {

	public List<BookInfo> listAll() {
		return this.createQuery("SELECT b FROM BookInfo b").list();
	}

	public BookInfo save(BookInfo bookInfoDO) {
		bookInfoDO.setId(null);
		Date now = new Date();
		bookInfoDO.setGmtCreate(now);
		bookInfoDO.setGmtModified(now);
		super.save(bookInfoDO);
		return bookInfoDO;
	}

	public boolean updateById(BookInfo bookInfoDO) {
		BookInfo b = this.get(BookInfo.class, bookInfoDO.getId());
		if (b == null) {
			return false;
		}
		BeanUtils.copyProperties(bookInfoDO, b);
		b.setGmtModified(new Date());
		this.update(b);
		return true;
	}

	public boolean deleteById(Integer id) {
		Query q = this.createNamedQuery("deleteBookInfoById");
		int resultCount = q.setParameter("id", id).executeUpdate();
		return (resultCount > 0 ? true : false);
	}

	public BookInfo findById(Integer id) {
		return this.get(BookInfo.class, id);
	}

	public BookInfo findBookInfoByIsbn(String isbn) {
		if (StringUtils.isEmpty(isbn)) {
			return null;
		}
		Query q = this.createNamedQuery("findBookInfoByIsbn");
		q.setParameter("isbn", isbn);
		List<BookInfo> resultList = q.list();
		if (resultList != null && resultList.size() > 0) {
			return resultList.get(0);
		} else {
			return null;
		}
	}

	public List<BookInfo> listBookInfoByIds(List<Integer> bookInfoIds) {
		if (bookInfoIds == null || bookInfoIds.isEmpty()) {
			return null;
		}
		Query q = this.createNamedQuery("listBookInfoByIds");
		q.setParameter("bookInfoIds", bookInfoIds);
		return q.list();
	}
}
