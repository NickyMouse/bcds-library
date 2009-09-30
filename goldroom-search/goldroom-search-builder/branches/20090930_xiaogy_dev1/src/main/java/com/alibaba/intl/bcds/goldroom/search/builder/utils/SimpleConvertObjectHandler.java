package com.alibaba.intl.bcds.goldroom.search.builder.utils;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field;
import org.springframework.context.ApplicationContext;

public class SimpleConvertObjectHandler implements ConvertObjectHandler {

	private Map<String, Rule> rules;

	public Document handle(Object obj, List<Method> methods) {
		if (rules == null) {
			return null;
		}

		try {
			Document doc = new Document();
			for (Method m : methods) {
				String fieldName = getFieldName(m);
				Rule rule = rules.get(fieldName);
				if (rule == null) {
					continue;
				}

				Object value = m.invoke(obj, new Object[] {});

				if (m.getReturnType().equals(java.util.Date.class)) {
					String dateValue = "";
					if (value != null) {
						dateValue = String.valueOf(((Date) value).getTime());
					}
					doc.add(new Field(fieldName, dateValue, rule.getStore(),
							rule.getIndex()));
				} else {
					if (value == null) {
						value = "";
					}
					doc.add(new Field(fieldName, value.toString(), rule
							.getStore(), rule.getIndex()));
				}
			}
			return doc;
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
		return null;
	}

	protected String getFieldName(Method m) {
		String methodName = m.getName();
		if (methodName.length() < 4) {
			return methodName;
		}
		return Character.toLowerCase(methodName.charAt(3))
				+ methodName.substring(4, methodName.length());
	}

	public void setRules(Map<String, Rule> rules) {
		this.rules = rules;
	}

	public Map<String, Rule> getRules() {
		return this.rules;
	}

	public static void main(String[] args) {
		ApplicationContext context = SearchApplicationContext
				.getConvertObjectHandlerContext();
		ConvertObjectHandler convertor = (ConvertObjectHandler) context
				.getBean("convertObjectHandler");
		Map<String, Rule> a = convertor.getRules();
		System.out.println(a);
	}
}
