/**
 * 
 */
package com.alibaba.intl.bcds.goldroom.dao;

import java.util.List;

import com.alibaba.intl.bcds.goldroom.dataobject.BookItem;

/**
 * @author Giraffe
 */

public interface BookItemDao {

    BookItem save(BookItem bookItemDO);

    boolean updateById(BookItem bookItemDO);

    boolean deleteById(Integer id);

    BookItem findById(Integer id);

  
    /**
     * 通过用户loginId及状态查询书籍
     * 
     * @param loginId
     * @param state
     * @return
     */
    List<BookItem> listBookItemsByLoginIdAndState(String loginId, String state, int page, int pagesize);

    /**
     * @param bookInfoId
     */
    List<BookItem> listBookItemByBookInfoId(int bookInfoId);

    /**
     * 通过book_item_id获取带有bookInfo属性的bookItem对象
     * 
     * @param id
     * @return
     */
    // BookItem getBookItemWithInfoById(int id);

    // List<BookItem> listLendedBookItemBySubscriber(String ownerLoginID, int page, int pagesize);

    /**
     * @param loginId
     * @return
     */
    // List<BookItem> listReservatedBooksBySubscriber(String loginId, int page, int pagesize);

    /**
     * @param reservationId
     * @return
     */
    // BookItem getBookItemByReservationId(int reservationId);

    /**
     * @param bookItemId
     * @param stateIdle
     */
    boolean updateBookItemState(BookItem bookItem);

    /**
     * @param subscriber
     * @return
     */
    // int countLendedBookItemBySubscriber(String subscriber);

    /**
     * @param subscriber
     * @return
     */
    // int countReservatedBooksBySubscriber(String subscriber);

    /**
     * @param owner
     * @param state
     * @return
     */
    int countBookItemsByLoginIdAndState(String owner, String state);

    List<BookItem> listBookItemsByLoginIdAndStateAndBookInfoIds(String loginId, String state, List<Integer> bookInfoIds);
    
    int countBookItemsByLoginId(String loginId);

    List<BookItem> listBookItemsByLoginId(String loginId, int page, int pagesize);
    
    List<BookItem> listBookItemsByLoginIdsAndBookInfoId(List<String> loginIds, Integer bookInfoId);

}
