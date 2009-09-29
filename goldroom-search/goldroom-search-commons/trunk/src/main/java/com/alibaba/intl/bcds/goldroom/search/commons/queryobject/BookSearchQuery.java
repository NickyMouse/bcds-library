package com.alibaba.intl.bcds.goldroom.search.commons.queryobject;

import java.util.ArrayList;
import java.util.List;

public class BookSearchQuery extends BaseQuery{
	private int n;
	private String primarySortFiled;
	
	private boolean decrease;

	protected BookSearchQuery() {
		statement = new ArrayList<String>();
	}

	public static BookSearchQuery getInstance() {
		return new BookSearchQuery();
	}

	public BookSearchQuery add(String st) {
		statement.add(st);
		return this;
	}

	public int getN() {
		return n;
	}

	public BookSearchQuery setN(int n) {
		this.n = n;
		return this;
	}

	public String getPrimarySortFiled() {
		return primarySortFiled;
	}

	public BookSearchQuery setPrimarySortFiled(String primarySortFiled) {
		this.primarySortFiled = primarySortFiled;
		return this;
	}

	public List<String> getStatement() {
		return statement;
	}

	public void setStatement(List<String> statement) {
		this.statement = statement;
	}

	public BookSearchQuery setDecrease(boolean decrease) {
		this.decrease = decrease;
		return this;
	}

	public boolean isDecrease() {
		return decrease;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("primarySortFiled=").append(primarySortFiled)
			.append(",n=").append(n)
			.append(",decrease=").append(decrease);
		for (String st : statement) {
			sb.append(",").append(st);
		}
		return sb.toString();
	}

}
