package com.alibaba.intl.bcds.goldroom.search.commons.service.impl;

import java.util.List;

import junit.framework.TestCase;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.alibaba.intl.bcds.goldroom.search.commons.dataobject.BookSearchDO;
import com.alibaba.intl.bcds.goldroom.search.commons.queryobject.BookSearchQueryObject;
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

	public void testSearchBookByCategoryId() {
//		System.out.println("testSearchBookByCategoryId");
//		List<BookSearchDO> list = bookSearchService.searchBookByCategoryId(2,
//				0, 10);
//		for (BookSearchDO aDO : list) {
//			System.out.println(aDO.getBookName());
//		}
//		assertNotNull(list);
	}

	public void testSearchBookByKeyword() {
//		System.out.println("testSearchBookByKeyword");
//		BookSearchQueryObject obj = bookSearchService.searchBookByKeyword(
//				"马达加斯加 测试", 0, 20);
//		List<BookSearchDO> list = obj.getResultList();
//		System.out.println(obj.getTotalCount());
//		for (BookSearchDO aDO : list) {
//			System.out.println(aDO.getBookName()+",   " + aDO.getBookDescription());
//		}
//
//		assertNotNull(list);
	}

	public void testSearchBookByTime() {
//		System.out.println("testSearchBookByTime");
//		List<BookSearchDO> list = bookSearchService.searchBookByTime(
//				new Date(1), new Date(), 0, 10);
//		for (BookSearchDO aDO : list) {
//			System.out.println(aDO.getBookName());
//		}
//		assertNotNull(list);
	}

}
