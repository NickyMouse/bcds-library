package com.alibaba.intl.bcds.goldroom.dataobject;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name = "WANT_BOOK")
@NamedQueries({
               @NamedQuery(name = "deleteLendingById", query = "DELETE FROM Lending WHERE id = :id"),
               @NamedQuery(name = "listLendingByLoginId", query = "SELECT l FROM Lending l WHERE l.subscriber.loginId = :loginId ORDER BY gmtModified DESC"),
               @NamedQuery(name = "countLendingByLoginId", query = "SELECT COUNT(l) FROM Lending l WHERE l.subscriber.loginId = :loginId"),
               @NamedQuery(name = "listLendingByBookItemId", query = "SELECT l FROM Lending l WHERE l.bookItem.id= :bookItemId ORDER BY gmtModified DESC"),
               @NamedQuery(name = "countLendingByBookItemId", query = "SELECT COUNT(l) FROM Lending l WHERE l.bookItem.id= :bookItemId")
})
public class WantBook {

    @Id
    @GeneratedValue
    private Integer  id;

    @ManyToOne
    @JoinColumn(name = "BOOK_INFO_ID")
    private BookInfo bookInfo;

    @ManyToOne
    @JoinColumn(name = "LOGIN_ID")
    private Member   member;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public BookInfo getBookInfo() {
        return bookInfo;
    }

    public void setBookInfo(BookInfo bookInfo) {
        this.bookInfo = bookInfo;
    }

    public Member getMember() {
        return member;
    }

    public void setMember(Member member) {
        this.member = member;
    }
}
