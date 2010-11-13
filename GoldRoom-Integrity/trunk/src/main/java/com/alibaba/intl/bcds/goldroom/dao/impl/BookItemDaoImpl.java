package com.alibaba.intl.bcds.goldroom.dao.impl;

import java.util.Date;
import java.util.List;

//import javax.persistence.EntityManager;
//import javax.persistence.Query;

import org.hibernate.Query;

import org.springframework.beans.BeanUtils;

import com.alibaba.intl.bcds.goldroom.dao.BaseDao;
import com.alibaba.intl.bcds.goldroom.dao.BookItemDao;
import com.alibaba.intl.bcds.goldroom.dataobject.BookItem;

@SuppressWarnings("unchecked")
public class BookItemDaoImpl extends BaseDao implements BookItemDao {

    public BookItem save(BookItem bookItem) {
        bookItem.setId(null);
        Date now = new Date();
        bookItem.setGmtCreate(now);
        bookItem.setGmtModified(now);
        super.save(bookItem);
        return bookItem;
    }

    public boolean updateById(BookItem bookItem) {
        BookItem item = this.get(BookItem.class, bookItem.getId());
        if (item == null) {
            return false;
        }
        BeanUtils.copyProperties(bookItem, item);
        item.setGmtModified(new Date());
        this.update(item);
//        em.merge(item);
        return true;
    }

    public boolean deleteById(Integer id) {
        Query q = this.createNamedQuery("deleteBookItemById");
        q.setParameter("id", id);
        int resultCount = q.executeUpdate();
        return resultCount > 0 ? true : false;
    }

    public BookItem findById(Integer id) {
        return this.get(BookItem.class, id);
    }


    public List<BookItem> listBookItemsByLoginIdAndState(String loginId, String state, int page, int pagesize) {
        Query q = this.createNamedQuery("listBookItemsByLoginIdAndState");
        q.setParameter("loginId", loginId);
        q.setParameter("state", state);
        return q.setFirstResult((page - 1) * pagesize).setMaxResults(pagesize).list();
    }

    public List<BookItem> listBookItemsByLoginId(String loginId, int page, int pagesize) {
        Query q = this.createNamedQuery("listBookItemsByLoginId");
        q.setParameter("loginId", loginId);
        return q.setFirstResult((page - 1) * pagesize).setMaxResults(pagesize).list();
    }

    public int countBookItemsByLoginId(String loginId) {
        Query q = this.createNamedQuery("countBookItemsByLoginId");
        q.setParameter("loginId", loginId);
        return ((Long) (q.list().get(0))).intValue();
    }

    public int countBookItemsByLoginIdAndState(String loginId, String state) {
        Query q = this.createNamedQuery("countBookItemsByLoginIdAndState");
        q.setParameter("loginId", loginId);
        q.setParameter("state", state);
        return ((Long) (q.list().get(0))).intValue();
    }

    public List<BookItem> listBookItemByBookInfoId(int bookInfoId) {
        Query q = this.createNamedQuery("listBookItemByBookInfoId");
        q.setParameter("bookInfoId", bookInfoId);
        return q.list();
    }

    // public List<BookItem> listLendedBookItemBySubscriber(String loginId, int page, int pagesize) {
    // Query q = em.createNamedQuery("listLendedBookItemBySubscriber");
    // q.setParameter("loginId", loginId);
    // return q.setFirstResult((page - 1) * pagesize).setMaxResults(pagesize).getResultList();
    // }
    //
    // public List<BookItem> listReservatedBooksBySubscriber(String loginId, int page, int pagesize) {
    // // TODO Auto-generated method stub
    // return null;
    // }
    //
    // public BookItem getBookItemByReservationId(int reservationId) {
    // // TODO Auto-generated method stub
    // return null;
    // }

    public boolean updateBookItemState(BookItem bookItem) {
        BookItem item = this.get(BookItem.class, bookItem.getId());
        if (item == null) {
            return false;
        }
        item.setState(bookItem.getState());
        item.setGmtModified(new Date());
        this.update(item);
        return true;
    }

    // public int countLendedBookItemBySubscriber(String subscriber) {
    // // TODO Auto-generated method stub
    // return 0;
    // }
    //
    // public int countReservatedBooksBySubscriber(String subscriber) {
    // // TODO Auto-generated method stub
    // return 0;
    // }

    public List<BookItem> listBookItemsByLoginIdAndStateAndBookInfoIds(String loginId, String state,
                                                                       List<Integer> bookInfoIds) {
        Query q = this.createNamedQuery("listBookItemsByLoginIdAndStateAndBookInfoIds");
        q.setParameter("bookInfoIds", bookInfoIds);
        q.setParameter("loginId", loginId);
        q.setParameter("state", state);
        return q.list();
    }

    public List<BookItem> listBookItemsByLoginIdsAndBookInfoId(List<String> loginIds, Integer bookInfoId) {
        Query q = this.createNamedQuery("listBookItemsByLoginIdsAndBookInfoId");
        q.setParameter("bookInfoId", bookInfoId);
        q.setParameter("loginIds", loginIds);
        return q.list();
    }

	public List<BookItem> getBookItemsByAddtime(int count) {
		Query q = this.createNamedQuery("getBookItemsByAddtime");
		q.setFirstResult(0);
		q.setMaxResults(count);
		return q.list();
	}

}
