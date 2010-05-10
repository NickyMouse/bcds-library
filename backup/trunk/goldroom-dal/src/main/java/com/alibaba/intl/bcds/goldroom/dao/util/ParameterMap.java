/**
 * Project: goldroom-dal
 * 
 * File Created at 2009-10-17
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
package com.alibaba.intl.bcds.goldroom.dao.util;

import java.util.HashMap;

/**
 * 使通过map向sqlmap传递参数更方便
 * 
 * @author Zimmem
 */
public class ParameterMap<K, V> extends HashMap<K, V> {


    private static final long serialVersionUID = 1300781521627856327L;

    public ParameterMap<K, V> addParameter(K key, V value) {
        put(key, value);
        return this;
    }
}
