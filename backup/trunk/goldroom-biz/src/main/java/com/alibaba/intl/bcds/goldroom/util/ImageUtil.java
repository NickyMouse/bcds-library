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

/**
 * TODO Comment of ImageUtil
 * 
 * @author Zimmem
 */
public interface ImageUtil {

    /**
     * 保存图片并返回保存的路径
     * 
     * @param isbn
     * @param body
     * @return
     */
    String save(String isbn, String suffix, byte[] body);

}
