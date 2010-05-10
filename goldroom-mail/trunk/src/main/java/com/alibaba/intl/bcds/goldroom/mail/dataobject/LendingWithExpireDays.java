package com.alibaba.intl.bcds.goldroom.mail.dataobject;

import com.alibaba.intl.goldroom.dataobject.Lending;


public class LendingWithExpireDays extends Lending {
    private int    expireDays;
    private int    bookInfoId;
    private String owner;

    public int getExpireDays() {
        return expireDays;
    }

    public void setExpireDays(int expireDays) {
        this.expireDays = expireDays;
    }

    public void setBookInfoId(int bookInfoId) {
        this.bookInfoId = bookInfoId;
    }

    public int getBookInfoId() {
        return bookInfoId;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public String getOwner() {
        return owner;
    }
}
