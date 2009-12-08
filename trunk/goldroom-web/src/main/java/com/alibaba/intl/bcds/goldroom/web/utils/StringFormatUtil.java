package com.alibaba.intl.bcds.goldroom.web.utils;

import org.apache.commons.lang.StringUtils;

public class StringFormatUtil {
	private static int HOME_BOOK_NAME_MAX_LENGTH = 12;

	public static String homeBookNameFormat(String bookName) {
		if(StringUtils.isEmpty(bookName)){
			return bookName;
		}
		int len = 0;
		for (int i = 0; i < bookName.length(); i++) {
			char c = bookName.charAt(i);
			if (isDoubleByte(c)) {
				len += 2;
			} else {
				len += 1;
			}

			if (len >= HOME_BOOK_NAME_MAX_LENGTH) {
				return bookName.substring(0, i) + "...";
			}
		}
		return bookName;
	}

	public static boolean isDoubleByte(char c) {
		return !((c >>> 8) == 0);
	}
}
