package com.alibaba.intl.bcds.goldroom.dao.ibatis;

import static org.junit.Assert.*;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.alibaba.intl.bcds.goldroom.dao.BookItemDao;
import com.alibaba.intl.bcds.goldroom.dao.test.BaseTest;
import com.alibaba.intl.bcds.goldroom.dataobject.BookItem;

public class BookItemDaoTest extends BaseTest {

    @Autowired
    private BookItemDao bookItemDao;

    /**
     * @throws java.lang.Exception
     */
    /**
     * @throws Exception
     */
    @Before
    public void setUp() throws Exception {
    }

    /**
     * @throws java.lang.Exception
     */
    @After
    public void tearDown() throws Exception {
    }

    //@Test
    public void testDeleteById() {
        //fail("Not yet implemented");
    }

    @Test
    public void testFindById() {
        assertNotNull(bookItemDao.findById(1));
    }

    //@Test
    public void testInsert() {
        //fail("Not yet implemented");
    }

    //@Test
    public void testListAll() {
        //fail("Not yet implemented");
    }

    //@Test
    public void testUpdateById() {
        //fail("Not yet implemented");
    }

    //@Test
    public void testListReservatedBooksBySubscriber() {
        List<BookItem> list = bookItemDao.listReservatedBooksBySubscriber("zhaowen.zhuangzw");
        assertTrue(list.size() > 0);
        assertNotNull(list.get(0).getBookInfo());
        assertNotNull(list.get(0).getReservation());
    }

    //@Test
    public void testListLendedBookItemBySubscriber() {
        List<BookItem> list = bookItemDao.listLendedBookItemBySubscriber("zhaowen.zhuangzw");
        assertTrue(list.size() > 0);
        assertNotNull(list.get(0).getLending());
    }

    //@Test
    public void testGetBookItemByReservationId() {
        BookItem bookItem = bookItemDao.getBookItemByReservationId(1);
        assertNotNull(bookItem);
        assertTrue(bookItem.getId() == 16);
    }

}
