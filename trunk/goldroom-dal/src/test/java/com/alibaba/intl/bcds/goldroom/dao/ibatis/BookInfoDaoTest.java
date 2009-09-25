package com.alibaba.intl.bcds.goldroom.dao.ibatis;

import junit.framework.TestCase;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.alibaba.intl.bcds.goldroom.dao.BookInfoDao;

public class BookInfoDaoTest extends TestCase{

	BookInfoDao bookInfoDao;
	@Override
	protected void setUp() throws Exception {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("goldroom-dal.xml");
		bookInfoDao = (BookInfoDao) context.getBean("bookInfoDao");
	}
	
	@Test
	public void testDeleteById() {
		fail("Not yet implemented");
	}

	@Test
	public void testInsert() {
		fail("Not yet implemented");
	}

	@Test
	public void testListAll() {
		bookInfoDao.listAll();
	}

	@Test
	public void testUpdateById() {
		fail("Not yet implemented");
	}

	@Test
	public void testFindById() {
		fail("Not yet implemented");
	}

}
