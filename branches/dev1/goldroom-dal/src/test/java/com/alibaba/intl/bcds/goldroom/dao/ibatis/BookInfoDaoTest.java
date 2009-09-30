package com.alibaba.intl.bcds.goldroom.dao.ibatis;

import java.util.Date;

import junit.framework.TestCase;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.alibaba.intl.bcds.goldroom.dao.BookInfoDao;
import com.alibaba.intl.bcds.goldroom.dataobject.BookInfoDO;

public class BookInfoDaoTest extends TestCase{

	BookInfoDao bookInfoDao;
	@Override
	protected void setUp() throws Exception {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("goldroom-dal.xml");
		bookInfoDao = (BookInfoDao) context.getBean("bookInfoDao");
	}
	
	@Test
	public void testDeleteById() {
		bookInfoDao.deleteById(0);
	}

	@Test
	public void testInsert() {
		BookInfoDO bookInfoDO = new BookInfoDO();
		bookInfoDO.setAuthor("Author");
		bookInfoDO.setCategoryId(1);
		bookInfoDO.setCategoryName("Tec");
		bookInfoDO.setPublishTime(new Date());
		bookInfoDO.setIsbn("1222-5431-2123-2321");
		bookInfoDao.insert(bookInfoDO);
	}
	
	@Test
	public void testListAll() {
		bookInfoDao.listAll();
	}

	@Test
	public void testUpdateById() {
		//fail("Not yet implemented");
	}

	@Test
	public void testFindById() {
		//fail("Not yet implemented");
	}

}
