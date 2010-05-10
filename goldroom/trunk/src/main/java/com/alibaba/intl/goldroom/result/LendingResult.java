package com.alibaba.intl.goldroom.result;

import java.util.List;

import com.alibaba.intl.goldroom.dataobject.Lending;

public class LendingResult extends Result {

    private List<Lending> lendingList;

    public LendingResult(List<Lending> lendingList, int totalCount) {
        this.totalCount = totalCount;
        this.lendingList = lendingList;
    }

    public void setLendingList(List<Lending> lendingList) {
        this.lendingList = lendingList;
    }

    public List<Lending> getLendingList() {
        return lendingList;
    }

}
