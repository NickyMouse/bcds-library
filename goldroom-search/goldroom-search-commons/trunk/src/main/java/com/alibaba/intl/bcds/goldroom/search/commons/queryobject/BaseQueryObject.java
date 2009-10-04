package com.alibaba.intl.bcds.goldroom.search.commons.queryobject;

import java.util.List;

import org.apache.lucene.search.Query;

@SuppressWarnings("unchecked")
public abstract class BaseQueryObject {
	public abstract Query getQuery();

	public abstract List getResultList();

	public abstract int getTotalCount();
}
