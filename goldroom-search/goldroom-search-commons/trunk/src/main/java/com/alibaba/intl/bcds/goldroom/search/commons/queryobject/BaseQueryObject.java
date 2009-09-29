package com.alibaba.intl.bcds.goldroom.search.commons.queryobject;

import org.apache.lucene.search.Query;

public abstract class BaseQueryObject {
	public abstract Query getQuery();
}
