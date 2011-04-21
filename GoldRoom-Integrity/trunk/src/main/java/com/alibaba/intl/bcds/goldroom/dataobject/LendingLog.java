package com.alibaba.intl.bcds.goldroom.dataobject;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name = "LENDING_LOG")
@NamedQueries({
               @NamedQuery(name = "countLendingLogByLoginIds", query = "SELECT count(i) FROM LendingLog i WHERE i.member.loginId in (:loginIds)"),
               @NamedQuery(name = "listLendingLogByLoginIds", query = "SELECT i FROM LendingLog i WHERE i.member.loginId in (:loginIds) ORDER BY i.gmtCreate DESC"),
               @NamedQuery(name = "countLendingLogByBookInfoId", query = "SELECT count(i) FROM LendingLog i WHERE i.bookInfo.id = :bookInfoId"),
               @NamedQuery(name = "listLendingLogByBookInfoId", query = "SELECT i FROM LendingLog i WHERE i.bookInfo.id = :bookInfoId ORDER BY i.gmtCreate DESC") })
public class LendingLog {

    @Id
    @GeneratedValue
    private Integer  id;

    @ManyToOne
    @JoinColumn(name = "BOOK_INFO_ID")
    private BookInfo bookInfo;

    @ManyToOne
    @JoinColumn(name = "LOGIN_ID", nullable = false)
    private Member   member;

    @Column(name = "GMT_CREATE")
    private Date     gmtCreate;

    @Column(name = "GMT_MODIFIED")
    private Date     gmtModified;

    @Column(name = "LENDING_TIME")
    private Date     lendTime;

    @Column(name = "RETURN_TIME")
    private Date     returnTime;

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

    public Date getGmtCreate() {
        return gmtCreate;
    }

    public void setGmtCreate(Date gmtCreate) {
        this.gmtCreate = gmtCreate;
    }

    public Date getGmtModified() {
        return gmtModified;
    }

    public void setGmtModified(Date gmtModified) {
        this.gmtModified = gmtModified;
    }

    public Date getLendTime() {
        return lendTime;
    }

    public void setLendTime(Date lendTime) {
        this.lendTime = lendTime;
    }

    public Date getReturnTime() {
        return returnTime;
    }

    public void setReturnTime(Date returnTime) {
        this.returnTime = returnTime;
    }

}
