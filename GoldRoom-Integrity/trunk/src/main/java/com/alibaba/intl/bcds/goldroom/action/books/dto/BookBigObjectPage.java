package com.alibaba.intl.bcds.goldroom.action.books.dto;

import java.util.ArrayList;
import java.util.List;

import com.alibaba.intl.bcds.goldroom.result.Result;

public class BookBigObjectPage extends Result{

    private List<BookBigObject> bigObjects       = new ArrayList<BookBigObject>();
    
    private int totalCount;

    public BookBigObjectPage(List<BookBigObject> bigObjects, int totalCount){
        this.bigObjects = bigObjects;
        this.totalCount = totalCount;
    }
    
    public List<BookBigObject> getBigObjects() {
        return bigObjects;
    }
    
    public int getTotalCount() {
        return totalCount;
    }

}
