package com.alibaba.intl.bcds.goldroom.mail.dataobject;

import java.util.ArrayList;
import java.util.List;

import com.alibaba.intl.bcds.goldroom.mail.enumeration.ServiceType;
import com.alibaba.intl.goldroom.dataobject.BookInfo;
import com.alibaba.intl.goldroom.dataobject.Lending;
import com.alibaba.intl.goldroom.dataobject.Member;
import com.alibaba.intl.goldroom.dataobject.Reservation;

public class EmailInfo {

    protected List<String> receiverEmails = new ArrayList<String>();
    private ServiceType    serviceType;
    private String         subject;
    private Member         owner;
    private Member         borrower;
    private BookInfo       bookInfo;
    private Lending        lending;
    private Reservation    reservation;

    public EmailInfo(ServiceType serviceType) {
        this.serviceType = serviceType;
        if (serviceType != null) {
            this.subject = serviceType.getSubject();
        }
    }

    public List<String> getReceiverEmails() {
        return receiverEmails;
    }

    public void addReceiverEmail(String receiverEmail) {
        this.receiverEmails.add(receiverEmail);
    }

    public ServiceType getServiceType() {
        return serviceType;
    }

    public void setServiceType(ServiceType serviceType) {
        this.serviceType = serviceType;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getSubject() {
        return subject;
    }

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

    public Reservation getReservation() {
        return reservation;
    }

    public void setReservation(Reservation reservation) {
        this.reservation = reservation;
    }

    public void setReceiverEmails(List<String> receiverEmails) {
        this.receiverEmails = receiverEmails;
    }

}
