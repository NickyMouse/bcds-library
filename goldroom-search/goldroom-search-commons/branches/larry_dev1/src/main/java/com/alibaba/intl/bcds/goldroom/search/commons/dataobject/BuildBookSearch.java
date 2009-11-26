package com.alibaba.intl.bcds.goldroom.search.commons.dataobject;

import java.util.Date;

public class BuildBookSearch {
	
	private Date itemAddTime;
	private Date itemFirstAddTime;
	private String bookTags;
	private Integer bookInfoId;
	private String bookAuthor;
	private String bookName;
	private String bookPublisher;
	private Date bookPublishTime;
	private String bookIsbn;
	private Integer bookCategoryId;
	private String bookImgUrl;
	private String bookDescription;
	private String bookEdition;

	public Date getItemAddTime() {
		return itemAddTime;
	}

	public void setItemAddTime(Date itemAddTime) {
		this.itemAddTime = itemAddTime;
	}

	public Date getItemFirstAddTime() {
		return itemFirstAddTime;
	}

	public void setItemFirstAddTime(Date itemFirstAddTime) {
		this.itemFirstAddTime = itemFirstAddTime;
	}

	public Integer getBookInfoId() {
		return bookInfoId;
	}

	public void setBookInfoId(Integer bookInfoId) {
		this.bookInfoId = bookInfoId;
	}

	public String getBookAuthor() {
		return bookAuthor;
	}

	public void setBookAuthor(String bookAuthor) {
		this.bookAuthor = bookAuthor;
	}

	public String getBookName() {
		return bookName;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	public String getBookPublisher() {
		return bookPublisher;
	}

	public void setBookPublisher(String bookPublisher) {
		this.bookPublisher = bookPublisher;
	}

	public Date getBookPublishTime() {
		return bookPublishTime;
	}

	public void setBookPublishTime(Date bookPublishTime) {
		this.bookPublishTime = bookPublishTime;
	}

	public String getBookIsbn() {
		return bookIsbn;
	}

	public void setBookIsbn(String bookIsbn) {
		this.bookIsbn = bookIsbn;
	}

	public Integer getBookCategoryId() {
		return bookCategoryId;
	}

	public void setBookCategoryId(Integer bookCategoryId) {
		this.bookCategoryId = bookCategoryId;
	}

	public String getBookImgUrl() {
		return bookImgUrl;
	}

	public void setBookImgUrl(String bookImgUrl) {
		this.bookImgUrl = bookImgUrl;
	}

	public String getBookDescription() {
		return bookDescription;
	}

	public void setBookDescription(String bookDescription) {
		this.bookDescription = bookDescription;
	}

	public String getBookEdition() {
		return bookEdition;
	}

	public void setBookEdition(String bookEdition) {
		this.bookEdition = bookEdition;
	}

	public void setBookTags(String bookTags) {
		this.bookTags = bookTags;
	}

	public String getBookTags() {
		return bookTags;
	}
}