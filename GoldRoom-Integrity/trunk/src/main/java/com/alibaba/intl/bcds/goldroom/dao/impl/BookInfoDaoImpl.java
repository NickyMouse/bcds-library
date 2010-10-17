package com.alibaba.intl.bcds.goldroom.dao.impl;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.BeanUtils;

import com.alibaba.intl.bcds.goldroom.dao.BookInfoDao;
import com.alibaba.intl.bcds.goldroom.dataobject.BookInfo;

@SuppressWarnings("unchecked")
public class BookInfoDaoImpl implements BookInfoDao {

	@PersistenceContext(unitName = "goldroomPU")
	private EntityManager em;

	public List<BookInfo> listAll() {
		return em.createQuery("SELECT b FROM BookInfo b").getResultList();
	}

	public BookInfo save(BookInfo bookInfoDO) {
		bookInfoDO.setId(null);
		Date now = new Date();
		bookInfoDO.setGmtCreate(now);
		bookInfoDO.setGmtModified(now);
		em.persist(bookInfoDO);
		return bookInfoDO;
	}

	public boolean updateById(BookInfo bookInfoDO) {
		BookInfo b = em.find(BookInfo.class, bookInfoDO.getId());
		if (b == null) {
			return false;
		}
		BeanUtils.copyProperties(bookInfoDO, b);
		b.setGmtModified(new Date());
		em.merge(b);
		return true;
	}

	public boolean deleteById(Integer id) {
		Query q = em.createNamedQuery("deleteBookInfoById");
		int resultCount = q.setParameter("id", id).executeUpdate();
		return (resultCount > 0 ? true : false);
	}

	public BookInfo findById(Integer id) {
		return em.find(BookInfo.class, id);
	}

	public BookInfo findBookInfoByIsbn(String isbn) {
		if (StringUtils.isEmpty(isbn)) {
			return null;
		}
		Query q = em.createNamedQuery("findBookInfoByIsbn");
		q.setParameter("isbn", isbn);
		List<BookInfo> resultList = q.getResultList();
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
		Query q = em.createNamedQuery("listBookInfoByIds");
		q.setParameter("bookInfoIds", bookInfoIds);
		return q.getResultList();
	}
}
