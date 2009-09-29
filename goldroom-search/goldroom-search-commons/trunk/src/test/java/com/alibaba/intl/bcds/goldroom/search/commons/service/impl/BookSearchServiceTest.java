package com.alibaba.intl.bcds.goldroom.search.commons.service.impl;

import java.util.List;

import junit.framework.TestCase;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.alibaba.intl.bcds.goldroom.search.commons.dataobject.BookSearchDO;
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
		List<BookSearchDO> list = bookSearchService.searchBookByCategoryId(2,10);
		for(BookSearchDO aDO:list){
			System.out.println(aDO.getBookName());
		}
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
