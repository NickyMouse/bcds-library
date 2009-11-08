package com.alibaba.intl.bcds.goldroom.dao.ibatis;

import java.util.List;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import com.alibaba.intl.bcds.goldroom.dao.BookItemDao;
import com.alibaba.intl.bcds.goldroom.dao.util.ParameterMap;
import com.alibaba.intl.bcds.goldroom.dataobject.BookItem;
import com.ibatis.sqlmap.client.event.RowHandler;

@SuppressWarnings("unchecked")
public class BookItemDaoImpl extends SqlMapClientDaoSupport implements BookItemDao {

    public int deleteById(Integer id) {
        return getSqlMapClientTemplate().delete("BOOK_ITEM.deleteById", id);
    }

    public BookItem findById(Integer id) {
        return (BookItem) getSqlMapClientTemplate().queryForObject("BOOK_ITEM.findById", id);
    }

    public Integer insert(BookItem bookItemDO) {
        return (Integer) getSqlMapClientTemplate().insert("BOOK_ITEM.insert", bookItemDO);
    }

    public List<BookItemDao> listAll() {
        return getSqlMapClientTemplate().queryForList("BOOK_ITEM.listAll");
    }

    public int updateById(BookItem bookItemDO) {
        return getSqlMapClientTemplate().update("BOOK_ITEM.updateById", bookItemDO);
    }

    /*
     * (non-Javadoc)
     * @see
     * com.alibaba.intl.bcds.goldroom.dao.BookItemDao#addBookItem(java.lang.
     * String, java.lang.String)
     */
    @Override
    public void addBookItem(final String loginId, final String isbn) {
        getSqlMapClientTemplate().insert(
                "BOOK_ITEM.addBookItemWithLoginIdAndIsbn",
                new ParameterMap<String, String>().addParameter("loginId", loginId).addParameter(
                        "isbn", isbn));
    }

    /*
     * (non-Javadoc)
     * @see
     * com.alibaba.intl.bcds.goldroom.dao.BookItemDao#listBookItemsByLoginId
     * (java.lang.String)
     */
    @Override
    public List<BookItem> listBookItemsByLoginId(String loginId) {
        return getSqlMapClientTemplate().queryForList("listBookItemsByLoginId", loginId);

    }

    /*
     * (non-Javadoc)
     * @see
     * com.alibaba.intl.bcds.goldroom.dao.BookItemDao#listBookItemsByLoginIdAndState
     * (java.lang.String, java.lang.String)
     */
    @Override
    public List<BookItem> listBookItemsByLoginIdAndState(String loginId, String state, int page,
                                                         int pagesize) {
        return getSqlMapClientTemplate().queryForList(
                "BOOK_ITEM.listBookItemsByLoginIdAndState",
                new ParameterMap<String, Object>().addParameter("loginId", loginId).addParameter(
                        "state", state).addParameter("skipRows", (page - 1) * pagesize)
                        .addParameter("pageSize", pagesize));
    }

    /*
     * (non-Javadoc)
     * @see
     * com.alibaba.intl.bcds.goldroom.dao.BookItemDao#getBookItemWithInfoById
     * (int)
     */
    @Override
    public BookItem getBookItemWithInfoById(int id) {
        return (BookItem) getSqlMapClientTemplate().queryForObject(
                "BOOK_ITEM.getBookItemWithInfoById", id);

    }

    /*
     * (non-Javadoc)
     * @see
     * com.alibaba.intl.bcds.goldroom.dao.BookItemDao#listBookItemByBookInfoId
     * (int)
     */
    @Override
    public List<BookItem> listBookItemByBookInfoId(int bookInfoId) {
        return getSqlMapClientTemplate().queryForList("BOOK_ITEM.listBookItemByBookInfoId",
                bookInfoId);
    }

    /*
     * (non-Javadoc)
     * @see
     * com.alibaba.intl.bcds.goldroom.dao.BookItemDao#listBookItemBySubscriber
     * (java.lang.String)
     */
    @Override
    public List<BookItem> listLendedBookItemBySubscriber(String subscriber, int page, int pagesize) {
        return getSqlMapClientTemplate().queryForList(
                "BOOK_ITEM.listLendedBookItemBySubscriber",
                new ParameterMap<String, Object>().addParameter("subscriber", subscriber)
                        .addParameter("skipRows", (page - 1) * pagesize).addParameter("pageSize",
                                pagesize));
    }

    /*
     * (non-Javadoc)
     * @seecom.alibaba.intl.bcds.goldroom.dao.BookItemDao#
     * listReservatedBooksBySubscriber(java.lang.String)
     */
    @Override
    public List<BookItem> listReservatedBooksBySubscriber(String subscriber, int page, int pagesize) {
        return getSqlMapClientTemplate().queryForList(
                "BOOK_ITEM.listReservatedBooksBySubscriber",
                new ParameterMap<String, Object>().addParameter("subscriber", subscriber)
                        .addParameter("skipRows", (page - 1) * pagesize).addParameter("pageSize",
                                pagesize));
    }

    /*
     * (non-Javadoc)
     * @see
     * com.alibaba.intl.bcds.goldroom.dao.BookItemDao#getBookItemByReservationId
     * (int)
     */
    @Override
    public BookItem getBookItemByReservationId(int reservationId) {
        return (BookItem) getSqlMapClientTemplate().queryForObject(
                "BOOK_ITEM.getBookItemByReservationId", reservationId);
    }

    /*
     * (non-Javadoc)
     * @see com.alibaba.intl.bcds.goldroom.dao.BookItemDao#changeItemState(int,
     * java.lang.String)
     */
    @Override
    public void changeItemState(BookItem bookItem) {
        getSqlMapClientTemplate().update("BOOK_ITEM.changeItemState", bookItem);

    }

    /*
     * (non-Javadoc)
     * @seecom.alibaba.intl.bcds.goldroom.dao.BookItemDao#
     * countBookItemsByLoginIdAndState(java.lang.String, java.lang.String)
     */
    @Override
    public int countBookItemsByLoginIdAndState(String owner, String state) {
        return (Integer) getSqlMapClientTemplate().queryForObject(
                "BOOK_ITEM.countBookItemsByLoginIdAndState",
                new ParameterMap<String, String>().addParameter("loginId", owner).addParameter(
                        "state", state));
    }

    /*
     * (non-Javadoc)
     * @seecom.alibaba.intl.bcds.goldroom.dao.BookItemDao#
     * countLendedBookItemBySubscriber(java.lang.String)
     */
    @Override
    public int countLendedBookItemBySubscriber(String subscriber) {
        return (Integer) getSqlMapClientTemplate().queryForObject(
                "BOOK_ITEM.countLendedBookItemBySubscriber", subscriber);
    }

    /*
     * (non-Javadoc)
     * @seecom.alibaba.intl.bcds.goldroom.dao.BookItemDao#
     * countReservatedBooksBySubscriber(java.lang.String)
     */
    @Override
    public int countReservatedBooksBySubscriber(String subscriber) {
        return (Integer) getSqlMapClientTemplate().queryForObject(
                "BOOK_ITEM.countReservatedBooksBySubscriber", subscriber);
    }

    /*
     * (non-Javadoc)
     * @see
     * com.alibaba.intl.bcds.goldroom.dao.BookItemDao#getBookItemWithAllInfo
     * (int)
     */
    @Override
    public BookItem getBookItemWithAllInfo(int bookItemId) {
        return (BookItem) getSqlMapClientTemplate().queryForObject(
                "BOOK_ITEM.getBookItemWithAllInfo", bookItemId);
    }
}
