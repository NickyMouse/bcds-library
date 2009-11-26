package com.alibaba.intl.bcds.goldroom.search.commons.queryobject;

public class BookSearchOption {
	String bookName;
	String publisher;
	String isbn;
	String description;
	String daysBefore;

	public String getBookName() {
		return bookName;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getDaysBefore() {
		return daysBefore;
	}

	public void setDaysBefore(String daysBefore) {
		this.daysBefore = daysBefore;
	}

}
