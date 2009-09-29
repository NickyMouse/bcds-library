package com.alibaba.intl.bcds.goldroom.search.commons.service.impl;

import junit.framework.TestCase;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.alibaba.intl.bcds.goldroom.search.commons.service.BookSearchService;

public class BookSearchServiceTest extends TestCase{
	BookSearchService bookSearchService;
	@Override
	protected void setUp() throws Exception {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("goldroom-search-commons.xml");
		bookSearchService = (BookSearchService) context.getBean("bookSearchService");
	}
	
	@Test
	public void testSearchBookByCategoryId() {
		bookSearchService.searchBookByCategoryId(2,10);
	}

	@Test
	public void testSearchBookByKeyword() {
		fail("Not yet implemented");
	}

	@Test
	public void testSearchBookByTime() {
		fail("Not yet implemented");
	}

}
