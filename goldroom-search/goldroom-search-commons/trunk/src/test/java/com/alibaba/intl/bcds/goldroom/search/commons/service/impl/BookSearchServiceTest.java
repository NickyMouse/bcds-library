package com.alibaba.intl.bcds.goldroom.search.commons.service.impl;

import java.util.Date;
import java.util.List;

import junit.framework.TestCase;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.alibaba.intl.bcds.goldroom.search.commons.constrans.SearchBookType;
import com.alibaba.intl.bcds.goldroom.search.commons.dataobject.BookSearch;
import com.alibaba.intl.bcds.goldroom.search.commons.queryobject.BookSearchQueryObject;
import com.alibaba.intl.bcds.goldroom.search.commons.service.BookSearchService;

@SuppressWarnings("unchecked")
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
//		List<BookSearch> list = bookSearchService.searchBookByCategoryId(2,
//				0, 10).getResultList();
//		for (BookSearch aDO : list) {
//			System.out.println(aDO.getBookName());
//		}
//		assertNotNull(list);
	}
	
	public void testSearchBookByInfoId(){
	    System.out.println("testSearchBookByInfoId");
	    BookSearch aDO = bookSearchService.searchBookByInfoId(279);
	    
	    assertNotNull(aDO);
	    System.out.println(aDO.getBookName()+",   "+aDO.getBookImgUrl());
	}
/*
	
    public void testSearchBookByKeyword() {
		System.out.println("testSearchBookByKeyword");
		BookSearchQueryObject obj = bookSearchService.searchBookByKeyword(
				"action",SearchBookType.getSearchBookType("all"), 0, 30);
		List<BookSearch> list = obj.getResultList();
		System.out.println(obj.getTotalCount());
		for (BookSearch aDO : list) {
			System.out.println(aDO.getBookName()+",   "+aDO.getBookImgUrl());
		}

		assertNotNull(list);
	}

	public void testSearchBookByTime() {
		System.out.println("testSearchBookByTime");
		List<BookSearch> list = bookSearchService.searchBookByTime(
				new Date(1), new Date(), 0, 10).getResultList();
		for (BookSearch aDO : list) {
			System.out.println(aDO.getBookName());
		}
		assertNotNull(list);
	}

	public void testSearchBookByOwnersAndKeyword() {
		System.out.println("testSearchBookByTime");
		List<BookSearch> list = bookSearchService.searchBookByOwnersAndKeyword("zzz", "test", 0, 10).getResultList();
		for (BookSearch aDO : list) {
			System.out.println(aDO.getBookName()+ ":"+aDO.getBookOwners());
		}
		assertNotNull(list);
	}*/
	
	
	
	
}
