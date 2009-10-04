package com.alibaba.intl.bcds.goldroom.web.utils;

public class PageUtils {

	public static int getPage(String pageStr) {
		try {
			return Integer.valueOf(pageStr);
		} catch (Exception e) {
			return 1;
		}
	}

	public static int getSkipResult(String pageStr) {
		int page = getPage(pageStr);
		return (page - 1) * PAGE_SIZE;
	}

	public static int PAGE_SIZE = 15;
}
