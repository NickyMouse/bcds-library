package com.alibaba.intl.bcds.goldroom.dao.ibatis;

import java.util.List;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import com.alibaba.intl.bcds.goldroom.dao.BookItemDao;
import com.alibaba.intl.bcds.goldroom.dao.util.ParameterMap;
import com.alibaba.intl.bcds.goldroom.dataobject.BookItem;

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
    public List<BookItem> listBookItemsByLoginIdAndState(String loginId, String state) {
        return getSqlMapClientTemplate().queryForList(
                "BOOK_ITEM.listBookItemsByLoginIdAndState",
                new ParameterMap<String, String>().addParameter("loginId", loginId).addParameter(
                        "state", state));
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
    public List<BookItem> listLendedBookItemBySubscriber(String ownerLoginID) {
        return getSqlMapClientTemplate().queryForList("BOOK_ITEM.listLendedBookItemBySubscriber",
                ownerLoginID);
    }

    /*
     * (non-Javadoc)
     * @seecom.alibaba.intl.bcds.goldroom.dao.BookItemDao#
     * listReservatedBooksBySubscriber(java.lang.String)
     */
    @Override
    public List<BookItem> listReservatedBooksBySubscriber(String loginId) {
        return getSqlMapClientTemplate().queryForList("BOOK_ITEM.listReservatedBooksBySubscriber",
                loginId);
    }

}
