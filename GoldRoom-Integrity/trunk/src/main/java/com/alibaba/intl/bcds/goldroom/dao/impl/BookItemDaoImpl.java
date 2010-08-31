package com.alibaba.intl.bcds.goldroom.dao.impl;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.beans.BeanUtils;

import com.alibaba.intl.bcds.goldroom.dao.BookItemDao;
import com.alibaba.intl.bcds.goldroom.dataobject.BookItem;

@SuppressWarnings("unchecked")
public class BookItemDaoImpl implements BookItemDao {

    @PersistenceContext(unitName = "goldroomPU")
    private EntityManager em;

    public BookItem save(BookItem bookItem) {
        bookItem.setId(null);
        Date now = new Date();
        bookItem.setGmtCreate(now);
        bookItem.setGmtModified(now);
        em.persist(bookItem);
        return bookItem;
    }

    public boolean updateById(BookItem bookItem) {
        BookItem item = em.find(BookItem.class, bookItem.getId());
        if (item == null) {
            return false;
        }
        BeanUtils.copyProperties(bookItem, item);
        item.setGmtModified(new Date());
        em.merge(item);
        return true;
    }

    public boolean deleteById(Integer id) {
        Query q = em.createNamedQuery("deleteBookItemById");
        q.setParameter("id", id);
        int resultCount = q.executeUpdate();
        return resultCount > 0 ? true : false;
    }

    public BookItem findById(Integer id) {
        return em.find(BookItem.class, id);
    }


    public List<BookItem> listBookItemsByLoginIdAndState(String loginId, String state, int page, int pagesize) {
        Query q = em.createNamedQuery("listBookItemsByLoginIdAndState");
        q.setParameter("loginId", loginId);
        q.setParameter("state", state);
        return q.setFirstResult((page - 1) * pagesize).setMaxResults(pagesize).getResultList();
    }
    
    public List<BookItem> listBookItemsByLoginId(String loginId, int page, int pagesize) {
        Query q = em.createNamedQuery("listBookItemsByLoginId");
        q.setParameter("loginId", loginId);
        return q.setFirstResult((page - 1) * pagesize).setMaxResults(pagesize).getResultList();
    }
    
    public int countBookItemsByLoginId(String loginId) {
        Query q = em.createNamedQuery("countBookItemsByLoginId");
        q.setParameter("loginId", loginId);
        return ((Long) (q.getSingleResult())).intValue();
    }

    public int countBookItemsByLoginIdAndState(String loginId, String state) {
        Query q = em.createNamedQuery("countBookItemsByLoginIdAndState");
        q.setParameter("loginId", loginId);
        q.setParameter("state", state);
        return ((Long) (q.getSingleResult())).intValue();
    }

    public List<BookItem> listBookItemByBookInfoId(int bookInfoId) {
        Query q = em.createNamedQuery("listBookItemByBookInfoId");
        q.setParameter("bookInfoId", bookInfoId);
        return q.getResultList();
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
        BookItem item = em.find(BookItem.class, bookItem.getId());
        if (item == null) {
            return false;
        }
        item.setState(bookItem.getState());
        item.setGmtModified(new Date());
        em.merge(item);
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
        Query q = em.createNamedQuery("listBookItemsByLoginIdAndStateAndBookInfoIds");
        q.setParameter("bookInfoIds", bookInfoIds);
        q.setParameter("loginId", loginId);
        q.setParameter("state", state);
        return q.getResultList();
    }

    public List<BookItem> listBookItemsByLoginIdsAndBookInfoId(List<String> loginIds, Integer bookInfoId) {
        Query q = em.createNamedQuery("listBookItemsByLoginIdsAndBookInfoId");
        q.setParameter("bookInfoId", bookInfoId);
        q.setParameter("loginIds", loginIds);
        return q.getResultList();
    }

}
