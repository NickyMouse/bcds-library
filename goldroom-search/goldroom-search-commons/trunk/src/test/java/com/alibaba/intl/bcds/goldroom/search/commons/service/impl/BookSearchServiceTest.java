package com.alibaba.intl.bcds.goldroom.search.commons.service.impl;

import java.util.Date;
import java.util.List;

import junit.framework.TestCase;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.alibaba.intl.bcds.goldroom.search.commons.dataobject.BookSearchDO;
import com.alibaba.intl.bcds.goldroom.search.commons.service.BookSearchService;

public class BookSearchServiceTest extends TestCase {
	BookSearchService bookSearchService;

	@Override
	protected void setUp() throws Exception {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
				"goldroom-search-commons.xml");
		bookSearchService = (BookSearchService) context
				.getBean("bookSearchService");
	}

	@Test
	public void testSearchBookByCategoryId() {
		System.out.println("testSearchBookByCategoryId");
		List<BookSearchDO> list = bookSearchService.searchBookByCategoryId(2,
				0, 10);
		for (BookSearchDO aDO : list) {
			System.out.println(aDO.getBookName());
		}
	}

	@Test
	public void testSearchBookByKeyword() {
		System.out.println("testSearchBookByKeyword");
		List<BookSearchDO> list = bookSearchService.searchBookByKeyword(
				"java3", 0, 10);
		for (BookSearchDO aDO : list) {
			System.out.println(aDO.getBookName());
		}

	}

	@Test
	public void testSearchBookByTime() {
		System.out.println("testSearchBookByTime");
		List<BookSearchDO> list = bookSearchService.searchBookByTime(
				new Date(1), new Date(), 0, 10);
		for (BookSearchDO aDO : list) {
			System.out.println(aDO.getBookName());
		}
	}

}
