package com.alibaba.intl.bcds.goldroom.action.books.dto;

import java.util.List;

import com.alibaba.intl.bcds.goldroom.dataobject.BookInfo;
import com.alibaba.intl.bcds.goldroom.dataobject.BookItem;

/**
 * 此对象是个大对象，包括了搜索引擎的搜索结果、书籍信息、拥有信息
 * 
 * @author chaosen.lincs@alibaba-inc.com
 */
public class BookBigObject {

    public BookInfo       info;

    public List<BookItem> item;

    public BookBigObject(BookInfo info, List<BookItem> item) {
        this.info = info;
        this.item = item;
    }

    public BookInfo getInfo() {
        return info;
    }

    public List<BookItem> getItem() {
        return item;
    }
}
