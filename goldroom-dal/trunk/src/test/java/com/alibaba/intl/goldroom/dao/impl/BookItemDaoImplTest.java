package com.alibaba.intl.goldroom.dao.impl;

import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;
import org.springframework.test.context.transaction.TransactionConfiguration;

import com.alibaba.intl.goldroom.dataobject.BookItem;

@RunWith(SpringJUnit4ClassRunner.class)
@TestExecutionListeners({ DependencyInjectionTestExecutionListener.class })
@ContextConfiguration(locations = { "classpath:/META-INF/dispatcherServlet-servlet.xml" })
@TransactionConfiguration(transactionManager = "transactionManager", defaultRollback = false)
public class BookItemDaoImplTest {

    @Autowired
    BookItemDaoImpl bookItemDaoImpl;

//    @Test
//    public void listBookItemsByLoginId() {
//        System.out.println("listBookItemsByLoginId");
//        List<BookItem> list = bookItemDaoImpl.listBookItemsByLoginId("gangyi.xiaogy");
//        for (BookItem i : list) {
//            System.out.println(i.getBookInfo().getName());
//        }
//
//        assertNotNull(list);
//    }

    @Test
    public void listBookItemsByLoginIdAndState() {
        System.out.println("listBookItemsByLoginIdAndState");
        List<BookItem> list = bookItemDaoImpl.listBookItemsByLoginIdAndState("gangyi.xiaogy", "idle", 1, 20);
        for (BookItem i : list) {
            System.out.println(i.getBookInfo().getName());
        }
        assertNotNull(list);
    }

    @Test
    public void countBookItemsByLoginIdAndState() {
        System.out.println("countBookItemsByLoginIdAndState");
        int count = bookItemDaoImpl.countBookItemsByLoginIdAndState("gangyi.xiaogy", "idle");
        System.out.println(count);
    }

    @Test
    public void listBookItemByBookInfoId() {
        System.out.println("listBookItemByBookInfoId");
        List<BookItem> list = bookItemDaoImpl.listBookItemByBookInfoId(71);
        for (BookItem i : list) {
            System.out.println(i.getBookInfo().getName());
        }
        assertNotNull(list);
    }
    
}
