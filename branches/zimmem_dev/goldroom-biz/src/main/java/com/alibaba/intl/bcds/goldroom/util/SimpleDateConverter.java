/**
 * Project: goldroom-biz
 * 
 * File Created at 2009-12-26
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
package com.alibaba.intl.bcds.goldroom.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * TODO Comment of SimpleDateConverter
 * 
 * @author Zimmem
 */
public class SimpleDateConverter implements DateConverter {

    /*
     * (non-Javadoc)
     * @see
     * com.alibaba.intl.bcds.goldroom.util.DateConverter#conver(java.lang.String
     * )
     */
    @Override
    public Date conver(String string) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd");
        try {
            return sdf.parse(string);
        } catch (ParseException e) {
            return null;
        }
    }

}
