/**
 * 
 */
package com.alibaba.intl.bcds.goldroom.dao;

import java.util.List;

import com.alibaba.intl.bcds.goldroom.dataobject.BookItemDO;

/**
 * @author Giraffe
 *
 */
public interface BookItemDao {
	List<BookItemDao> listAll();
	Integer insert(BookItemDO bookItemDO);
	int updateById(BookItemDO bookItemDO);
	int deleteById(Integer id);
	BookItemDO findById(Integer id);
}
