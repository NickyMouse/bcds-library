package com.alibaba.intl.bcds.goldroom.search.builder.utils;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import org.apache.lucene.document.Document;

public class DocumentFactory {
	protected List<Method> methodList = new ArrayList<Method>();
	protected Class c;
	protected ConvertObjectHandler handler;

	protected DocumentFactory(Class c, ConvertObjectHandler handler) {
		this.c = c;
		this.handler = handler;
		Method[] methods = c.getMethods();
		for (Method m : methods) {
			if (isWanted(m)) {
				methodList.add(m);
			}
		}
	}

	public static DocumentFactory getInstance(Class c,
			ConvertObjectHandler handler) {
		if (c == null || handler == null) {
			return null;
		}
		return new DocumentFactory(c, handler);
	}

	protected boolean isWanted(Method method) {
		if (method.getName().startsWith("get")) {
			return true;
		} else {
			return false;
		}
	}

	public Document convert(Object obj) {
		if (!obj.getClass().equals(this.c)) {
			return null;
		}
		return handler.handle(obj, methodList);
	}

	public List<Document> convertList(Object obj) {
		List<Document> docList = new LinkedList<Document>();
		Document doc = null;
		List<Object> objList = (List<Object>) obj;
		for (Object object : objList) {
			doc = convert(object);
			if(doc == null){
				continue;
			}
			else{
				docList.add(doc);
			}
		}
		return docList;
	}
}
