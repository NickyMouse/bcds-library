package com.alibaba.intl.bcds.goldroom.dao.ibatis;

import java.util.Date;
import java.util.List;

import static org.junit.Assert.*;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import com.alibaba.intl.bcds.goldroom.dao.BookInfoDao;
import com.alibaba.intl.bcds.goldroom.dao.test.BaseTest;
import com.alibaba.intl.bcds.goldroom.dataobject.BookInfo;

@Transactional()
@TransactionConfiguration(defaultRollback = false)
public class BookInfoDaoTest extends BaseTest {

    @Autowired
    BookInfoDao bookInfoDao;

    //@Test
    public void testDeleteById() {
        bookInfoDao.deleteById(0);
    }

    @Test
    public void testInsert() {
        BookInfo bookInfoDO = new BookInfo();
        bookInfoDO.setAuthor("中文");
        bookInfoDO.setCategoryId(1);
        bookInfoDO.setCategoryName("Tec");
        bookInfoDO.setPublishTime(new Date());
        bookInfoDO.setIsbn("1222-5431-2123-2321");
        int id = bookInfoDao.insert(bookInfoDO);
        System.out.println(id);
        System.out.println(bookInfoDO.getId());
        assertTrue(id > 0);
    }

    // @Test
    public void testListAll() {
        List<BookInfo> list = bookInfoDao.listAll();
        for (BookInfo bookInfo : list) {
            System.out.println(bookInfo.getAuthor());
        }
        //assertEquals(bookInfoDao.listAll().get(3).getAuthor(), "中文");
    }

    //@Test
    public void testUpdateById() {
        //fail("Not yet implemented");
    }

    //@Test
    public void testFindById() {
        //fail("Not yet implemented");
    }

}
