package com.alibaba.intl.bcds.goldroom.dataobject;

import java.util.Date;

import org.apache.commons.lang.builder.ToStringBuilder;

public class BookItem {

    /** 空闲 */
    public static final String STATE_IDLE        = "idle";
    /** 不可用--下架 */
    public static final String STATE_UNAVAILABLE = "unavailable";
    /** 已被借 */
    public static final String STATE_LENDED      = "lended";
    /** 已被预约 */
    public static final String STATE_RESERVATED  = "reservated";

    private Integer            id;
    private String             state;
    private String             loginId;
    private Date               addTime;
    private Date               removeTime;
    private Integer            bookInfoId;
    private Date               firstAddTime;
    private Date               gmtCreate;
    private Date               gmtModified;
    private BookInfo           bookInfo;
    private String             tags;
    private Lending            lending;
    private Reservation        reservation;
    private String             remark;

    /**
     * @return the lending
     */
    public Lending getLending() {
        return lending;
    }

    /**
     * @param lending the lending to set
     */
    public void setLending(Lending lending) {
        this.lending = lending;
    }

    /**
     * @return the reservation
     */
    public Reservation getReservation() {
        return reservation;
    }

    /**
     * @param reservation the reservation to set
     */
    public void setReservation(Reservation reservation) {
        this.reservation = reservation;
    }

    /**
     * @return the bookInfo
     */
    public BookInfo getBookInfo() {
        return bookInfo;
    }

    /**
     * @param bookInfo the bookInfo to set
     */
    public void setBookInfo(BookInfo bookInfo) {
        this.bookInfo = bookInfo;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public Date getAddTime() {
        return addTime;
    }

    public void setAddTime(Date addTime) {
        this.addTime = addTime;
    }

    public Date getRemoveTime() {
        return removeTime;
    }

    public void setRemoveTime(Date removeTime) {
        this.removeTime = removeTime;
    }

    public Integer getBookInfoId() {
        return bookInfoId;
    }

    public void setBookInfoId(Integer bookInfoId) {
        this.bookInfoId = bookInfoId;
    }

    public Date getFirstAddTime() {
        return firstAddTime;
    }

    public void setFirstAddTime(Date firstAddTime) {
        this.firstAddTime = firstAddTime;
    }

    public Date getGmtCreate() {
        return gmtCreate;
    }

    public void setGmtCreate(Date gmtCreate) {
        this.gmtCreate = gmtCreate;
    }

    public Date getGmtModified() {
        return gmtModified;
    }

    public void setGmtModified(Date gmtModified) {
        this.gmtModified = gmtModified;
    }

    public String getTags() {
        return tags;
    }

    public void setTags(String tags) {
        this.tags = tags;
    }

    public void setLoginId(String loginId) {
        this.loginId = loginId;
    }

    public String getLoginId() {
        return loginId;
    }

    /**
     * @param remark the remark to set
     */
    public void setRemark(String remark) {
        this.remark = remark;
    }

    /**
     * @return the remark
     */
    public String getRemark() {
        return remark;
    }

    /*
     * (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }
}
