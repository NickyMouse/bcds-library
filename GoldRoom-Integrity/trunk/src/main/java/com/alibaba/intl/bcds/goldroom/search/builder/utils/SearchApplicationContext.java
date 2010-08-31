package com.alibaba.intl.bcds.goldroom.search.builder.utils;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SearchApplicationContext {
	private static ClassPathXmlApplicationContext convertObjectHandlerContext = new ClassPathXmlApplicationContext(
			"spring/convert-object-handler.xml");

	private static ClassPathXmlApplicationContext configContext = new ClassPathXmlApplicationContext(
			"spring/search-config.xml");

	public static ApplicationContext getConvertObjectHandlerContext() {
		return convertObjectHandlerContext;
	}
	
	public static ApplicationContext getConfigContext(){
		return configContext;
	}

}
