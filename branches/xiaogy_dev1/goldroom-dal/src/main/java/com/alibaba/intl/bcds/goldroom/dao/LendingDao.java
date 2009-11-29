/**
 * Project: goldroom-dal
 * 
 * File Created at 2009-10-22
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
package com.alibaba.intl.bcds.goldroom.dao;

import com.alibaba.intl.bcds.goldroom.dataobject.Lending;

/**
 * TODO Comment of LendingDao
 * 
 * @author Zimmem
 */
public interface LendingDao {

    /**
     * @param lending
     */
    public void insert(Lending lending);

    /**
     * @param lendId
     */
    public void cutLendingToLog(int lendId);

    /**
     * @param lending
     */
    public void cutLendingToLog(Lending lending);

    /**
     * @param lendId
     * @return
     */
    public Lending findById(int lendId);

    /**
     * @param lendingId
     */
    void updateRealReturnTime(int lendingId);

}
