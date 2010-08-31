package com.alibaba.intl.bcds.goldroom.search.builder.utils;

import java.lang.reflect.Method;
import java.util.List;
import java.util.Map;

import org.apache.lucene.document.Document;


public interface ConvertObjectHandler {
	Document handle(Object obj, List<Method> methods);
	void setRules(Map<String,Rule> rules);
	Map<String,Rule> getRules();
}
