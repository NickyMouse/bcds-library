/**
 * Project: goldroom-web
 * 
 * File Created at 2009-10-25
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
package com.alibaba.intl.bcds.goldroom.web.command;

import java.util.Date;

/**
 * TODO Comment of ConfirmLending
 * 
 * @author Zimmem
 */
public class ConfirmLending {
    
    private  int reservationId;
    private Date lendTime;
    private Date returnTime;
    /**
     * @return the reservationId
     */
    public int getReservationId() {
        return reservationId;
    }
    /**
     * @param reservationId the reservationId to set
     */
    public void setReservationId(int reservationId) {
        this.reservationId = reservationId;
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

}
