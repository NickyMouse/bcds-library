package com.alibaba.intl.bcds.goldroom.search.commons.queryobject;

import java.util.ArrayList;
import java.util.List;

import jeasy.analysis.MMAnalyzer;

import org.apache.log4j.Logger;
import org.apache.lucene.queryParser.ParseException;
import org.apache.lucene.queryParser.QueryParser;
import org.apache.lucene.search.Query;

import com.alibaba.intl.bcds.goldroom.search.commons.utils.SearchConditionBuilder;

@SuppressWarnings("unchecked")
public class BookSearchQueryObject extends BaseQueryObject {
	public static BookSearchQueryObject EMPTY_RESULT = new BookSearchQueryObject();

	private static Logger logger = Logger
			.getLogger(BookSearchQueryObject.class);

	private SearchConditionBuilder searchConditionBuilder;
	private int n;
	private String primarySortFiled = "";
	private int skipResult = 0;
	private boolean reverse = false;
	private List bookSearchDoList;
	private int totalCount;
	private boolean isHighlight = false;

	protected BookSearchQueryObject() {
		bookSearchDoList = new ArrayList();
		totalCount = 0;
	}

	public boolean isHighlight() {
		return isHighlight;
	}

	public BookSearchQueryObject setHighlight(boolean isHighlight) {
		this.isHighlight = isHighlight;
		return this;
	}

	public int getSkipResult() {
		return skipResult;
	}

	public BookSearchQueryObject setSkipResult(int skipResult) {
		this.skipResult = skipResult;
		return this;
	}

	protected BookSearchQueryObject(SearchConditionBuilder builder) {
		this.searchConditionBuilder = builder;
	}

	public static BookSearchQueryObject getInstance(
			SearchConditionBuilder builder) {
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

	public BookSearchQueryObject setReverse(boolean reverse) {
		this.reverse = reverse;
		return this;
	}

	public boolean isReverse() {
		return reverse;
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
				.append(n).append(",decrease=").append(reverse).append(
						",condition=").append(
						searchConditionBuilder.buildConditions());
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

	@Override
	public List getResultList() {
		return bookSearchDoList;
	}

	public void setResultList(List list) {
		this.bookSearchDoList = list;
	}

	@Override
	public int getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}

}
