package com.alibaba.intl.bcds.goldroom.search.commons.service;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BookSearchServiceLocator {
	private static ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
			"goldroom-search-commons.xml");;

	public static BookSearchService getBookSearchService() {
		return (BookSearchService) context.getBean("bookSearchService");
	}

	public static BuildBookSearchService getBuildBookSearchService() {
		return (BuildBookSearchService) context
				.getBean("buildBookSearchService");
	}
}
