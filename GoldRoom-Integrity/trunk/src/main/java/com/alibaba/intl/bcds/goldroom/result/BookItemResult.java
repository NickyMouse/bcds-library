package com.alibaba.intl.bcds.goldroom.result;

import java.util.List;

import com.alibaba.intl.bcds.goldroom.dataobject.BookItem;

public class BookItemResult extends Result {

    List<BookItem> itemList;

    public BookItemResult(List<BookItem> itemList, int totalCount) {
        this.totalCount = totalCount;
        this.itemList = itemList;
    }

    public List<BookItem> getItemList() {
        return itemList;
    }

    public void setItemList(List<BookItem> itemList) {
        this.itemList = itemList;
    }

}
