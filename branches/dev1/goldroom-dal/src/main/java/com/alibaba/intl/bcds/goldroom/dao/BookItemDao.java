/**
 * 
 */
package com.alibaba.intl.bcds.goldroom.dao;

import java.util.List;

import com.alibaba.intl.bcds.goldroom.dataobject.BookItem;

/**
 * @author Giraffe
 *
 */
public interface BookItemDao {
	List<BookItemDao> listAll();
	Integer insert(BookItem bookItemDO);
	int updateById(BookItem bookItemDO);
	int deleteById(Integer id);
	BookItem findById(Integer id);
    /**
     * @param loginId
     * @param isbn
     */
    void addBookItem(String loginId, String isbn);
    /**
     * @param loginId
     */
    List<BookItem> listBookItemsByLoginId(String loginId);
}
