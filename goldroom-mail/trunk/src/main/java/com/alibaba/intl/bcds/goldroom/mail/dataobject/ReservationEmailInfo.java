package com.alibaba.intl.bcds.goldroom.mail.dataobject;

import org.apache.commons.lang.StringUtils;

import com.alibaba.intl.bcds.goldroom.dataobject.BookInfo;
import com.alibaba.intl.bcds.goldroom.dataobject.Member;
import com.alibaba.intl.bcds.goldroom.dataobject.Reservation;
import com.alibaba.intl.bcds.goldroom.mail.enumeration.ServiceType;

public class ReservationEmailInfo extends BaseEmailInfo {
	Member owner;
	Member borrower;
	BookInfo bookInfo;
	Reservation reservation;

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

	public Reservation getReservation() {
		return reservation;
	}

	public void setReservation(Reservation reservation) {
		this.reservation = reservation;
	}

	public ReservationEmailInfo(Member owner, Member borrower,
			BookInfo bookInfo, Reservation reservation) {
		this.setServiceType(ServiceType.NOTIFY_RESERVATION);
		this.owner = owner;
		this.borrower = borrower;
		this.bookInfo = bookInfo;
		this.reservation = reservation;
		if (owner != null && StringUtils.isNotEmpty(owner.getEmail())) {
			this.addReceiverEmail(owner.getEmail());
		}
		this.setSubject("黄金屋 [Gold Room] 系统邮件：您的书籍已被预约。");
	}
}
