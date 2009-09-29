package com.alibaba.intl.bcds.goldroom.search.commons.queryobject;

import java.util.List;

import org.apache.log4j.Logger;
import org.apache.lucene.index.Term;
import org.apache.lucene.search.MultiPhraseQuery;

public class BaseQuery {
	private static Logger logger = Logger.getLogger(BaseQuery.class);
	
	protected List<String> statement;

	public MultiPhraseQuery getMultiPhraseQuery() {
		MultiPhraseQuery mpQuery = new MultiPhraseQuery();
		for (String st : statement) {
			mpQuery.add(getTerm(st));
		}
		return mpQuery;
	}

	private Term getTerm(String st) {
		if (st == null) {
			logger.warn("BaseQuery.getTerm  st is null",
					new NullPointerException("BaseQuery.getTerm  st is null"));
			return null;
		}
		String[] strArray = st.split("=");
		if (strArray.length != 2) {
			logger.warn("BaseQuery.getTerm st format ERROR",
					new IllegalArgumentException("BaseQuery.getTerm st format ERROR, except filed=value"));
			return null;
		}
		Term term = new Term(strArray[0], strArray[1]);
		return term;
	}
}
