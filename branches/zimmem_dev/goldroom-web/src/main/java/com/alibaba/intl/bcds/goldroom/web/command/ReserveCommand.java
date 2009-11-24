/**
 * Project: goldroom-web
 * 
 * File Created at 2009-10-31
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
 * TODO Comment of ReserveCommand
 * @author Zimmem
 *
 */
public class ReserveCommand {
    private int bookItemId;
    private Date lendTime;
    public Date getLendTime() {
		return lendTime;
	}

	public void setLendTime(Date lendTime) {
		this.lendTime = lendTime;
	}

	public Date getReturnTime() {
		return returnTime;
	}

	public void setReturnTime(Date returnTime) {
		this.returnTime = returnTime;
	}

	private Date returnTime;
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

 
}
