package com.alibaba.intl.bcds.goldroom.mail.dataobject;

import com.alibaba.intl.bcds.goldroom.dataobject.BookInfo;
import com.alibaba.intl.bcds.goldroom.dataobject.Lending;
import com.alibaba.intl.bcds.goldroom.dataobject.Member;
import com.alibaba.intl.bcds.goldroom.mail.enumeration.ServiceType;

public class ReturnBookEmailInfo extends BaseEmailInfo {
	Member owner;
	Member borrower;
	BookInfo bookInfo;
	Lending lending;

	public Member getOwner() {
		return owner;
	}

	public void setOwner(Member owner) {
		this.owner = owner;
	}

	public Member getBorrower() {
		return borrower;
	}

	public void setBorrower(Member borrower) {
		this.borrower = borrower;
	}

	public BookInfo getBookInfo() {
		return bookInfo;
	}

	public void setBookInfo(BookInfo bookInfo) {
		this.bookInfo = bookInfo;
	}

	public Lending getLending() {
		return lending;
	}

	public void setLending(Lending lending) {
		this.lending = lending;
	}

	public ReturnBookEmailInfo() {
		this.setServiceType(ServiceType.NOTIFY_RETURN_BOOK);
	}
}
