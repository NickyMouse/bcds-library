package com.alibaba.intl.bcds.goldroom.search.builder.utils;

import org.apache.lucene.document.Field.Index;
import org.apache.lucene.document.Field.Store;

public class Rule {
	private String fieldName;
	private Store store;
	private Index index;

	public Rule(String fieldName, String storeStr,String indexStr) {
		this.fieldName = fieldName;
		this.store = storeMap(storeStr);
		this.index = indexMap(indexStr);
	}

	public String getFieldName() {
		return fieldName;
	}

	public void setFieldName(String fieldName) {
		this.fieldName = fieldName;
	}

	public Store getStore() {
		return store;
	}

	public void setStore(Store store) {
		this.store = store;
	}

	public Index getIndex() {
		return index;
	}

	public void setIndex(Index index) {
		this.index = index;
	}
	
	private Store storeMap(String str) {
		if ("YES".equals(str)) {
			return Store.YES;
		} else if ("COMPRESS".equals(str)) {
			return Store.COMPRESS;
		} else {
			return Store.NO;
		}
	}

	private Index indexMap(String str) {
		if ("ANALYZED".equals(str)) {
			return Index.ANALYZED;
		} else if ("NOT_ANALYZED".equals(str)) {
			return Index.NOT_ANALYZED;
		} else if ("NO".equals(str)) {
			return Index.NO;
		} else if ("ANALYZED_NO_NORMS".equals(str)) {
			return Index.ANALYZED_NO_NORMS;
		} else {
			return Index.ANALYZED_NO_NORMS;
		}
	}
}
