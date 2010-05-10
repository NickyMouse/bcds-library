/**
 * Project: goldroom-dal
 * 
 * File Created at 2009-10-21
 * $Id$
 * 
 * Copyright 2008 Alibaba.com Croporation Limited.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information of
 * Alibaba Company. ("Confidential Information").  You shall not
 * disclose such Confidential Information and shall use it only in
 * accordance with the terms of the license agreement you entered into
 * with Alibaba.com.
 */
package com.alibaba.intl.bcds.goldroom.dataobject;

import java.util.Date;

/**
 * TODO Comment of Lending
 * 
 * @author Zimmem
 */
public class Lending {

    private int    id;
    private String subscriber;
    private Date   lendTime;
    private Date   returnTime;
    private String state;
    private int    bookItemId;
    private Date   realReturnTime;
    private Date   gmtCreate;
    private Date   gmtModified;

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the subscriber
     */
    public String getSubscriber() {
        return subscriber;
    }

    /**
     * @param subscriber the subscriber to set
     */
    public void setSubscriber(String subscriber) {
        this.subscriber = subscriber;
    }

    /**
     * @return the lendTime
     */
    public Date getLendTime() {
        return lendTime;
    }

    /**
     * @param lendTime the lendTime to set
     */
    public void setLendTime(Date lendTime) {
        this.lendTime = lendTime;
    }

    /**
     * @return the returnTime
     */
    public Date getReturnTime() {
        return returnTime;
    }

    /**
     * @param returnTime the returnTime to set
     */
    public void setReturnTime(Date returnTime) {
        this.returnTime = returnTime;
    }

    /**
     * @return the state
     */
    public String getState() {
        return state;
    }

    /**
     * @param state the state to set
     */
    public void setState(String state) {
        this.state = state;
    }

    /**
     * @return the bookItemId
     */
    public int getBookItemId() {
        return bookItemId;
    }

    /**
     * @param bookItemId the bookItemId to set
     */
    public void setBookItemId(int bookItemId) {
        this.bookItemId = bookItemId;
    }

    /**
     * @return the realReturnTime
     */
    public Date getRealReturnTime() {
        return realReturnTime;
    }

    /**
     * @param realReturnTime the realReturnTime to set
     */
    public void setRealReturnTime(Date realReturnTime) {
        this.realReturnTime = realReturnTime;
    }

    /**
     * @return the gmtCreate
     */
    public Date getGmtCreate() {
        return gmtCreate;
    }

    /**
     * @param gmtCreate the gmtCreate to set
     */
    public void setGmtCreate(Date gmtCreate) {
        this.gmtCreate = gmtCreate;
    }

    /**
     * @return the gmtModified
     */
    public Date getGmtModified() {
        return gmtModified;
    }

    /**
     * @param gmtModified the gmtModified to set
     */
    public void setGmtModified(Date gmtModified) {
        this.gmtModified = gmtModified;
    }

}
