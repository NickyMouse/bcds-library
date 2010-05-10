package com.alibaba.intl.goldroom.util;

import junit.framework.TestCase;

import org.junit.Test;

public class MD5Test extends TestCase{

    @Test
    public void testMD5() {
        String md5Str = MD5.getMD5("hello1234");
        String str = "9a1996efc97181f0aee18321aa3b3b12";
        assertEquals(md5Str, str);
    }
}
