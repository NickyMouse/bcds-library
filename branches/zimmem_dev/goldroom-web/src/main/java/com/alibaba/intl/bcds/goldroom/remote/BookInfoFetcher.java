/**
 * Project: goldroom-web
 * 
 * File Created at 2009-12-6
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
package com.alibaba.intl.bcds.goldroom.remote;

import com.alibaba.intl.bcds.goldroom.dataobject.BookInfo;

/**
 * TODO Comment of BookInfoFetcher
 * 
 * @author Zimmem
 */
public interface BookInfoFetcher {

    BookInfo fetch(String isbn);
}
