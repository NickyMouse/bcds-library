package com.alibaba.intl.bcds.goldroom.search.commons.queryobject;

import jeasy.analysis.MMAnalyzer;

import org.apache.log4j.Logger;
import org.apache.lucene.queryParser.ParseException;
import org.apache.lucene.queryParser.QueryParser;
import org.apache.lucene.search.Query;

import com.alibaba.intl.bcds.goldroom.search.commons.utils.SearchConditionBuilder;

public class BookSearchQueryObject extends BaseQueryObject {
	private static Logger logger = Logger
			.getLogger(BookSearchQueryObject.class);

	private SearchConditionBuilder searchConditionBuilder;
	private int n;
	private String primarySortFiled;

	private boolean decrease;

	protected BookSearchQueryObject(SearchConditionBuilder builder) {
		this.searchConditionBuilder = builder;
	}

	public static BookSearchQueryObject getInstance(SearchConditionBuilder builder) {
		return new BookSearchQueryObject(builder);
	}

	public int getN() {
		return n;
	}

	public BookSearchQueryObject setN(int n) {
		this.n = n;
		return this;
	}

	public String getPrimarySortFiled() {
		return primarySortFiled;
	}

	public BookSearchQueryObject setPrimarySortFiled(String primarySortFiled) {
		this.primarySortFiled = primarySortFiled;
		return this;
	}

	public BookSearchQueryObject setDecrease(boolean decrease) {
		this.decrease = decrease;
		return this;
	}

	public boolean isDecrease() {
		return decrease;
	}

	public void setSearchConditionBuilder(SearchConditionBuilder builder) {
		this.searchConditionBuilder = builder;
	}

	public SearchConditionBuilder getSearchConditionBuilder() {
		return searchConditionBuilder;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("primarySortFiled=").append(primarySortFiled).append(",n=")
				.append(n).append(",decrease=").append(decrease).append(
						",condition=").append(searchConditionBuilder.buildConditions());
		return sb.toString();
	}

	@Override
	public Query getQuery() {
		if (getSearchConditionBuilder() == null) {
			logger.error("BookSearchQueryObject.getQuery:helper is invalid",
					new IllegalArgumentException());
			return null;
		}
		QueryParser parser = new QueryParser("", new MMAnalyzer());
		logger.info("[Search Condition]" + this.toString());
		try {
			return parser.parse(getSearchConditionBuilder().buildConditions());
		} catch (ParseException e) {
			logger.error(e);
			return null;
		}
	}

}
