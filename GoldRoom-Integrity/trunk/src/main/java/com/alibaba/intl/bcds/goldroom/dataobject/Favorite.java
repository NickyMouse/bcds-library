package com.alibaba.intl.bcds.goldroom.dataobject;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name = "FAVORITE")
@NamedQueries({
               @NamedQuery(name = "listFavoriteByLoginId", query = "SELECT i FROM Favorite i WHERE i.member.loginId = :loginId ORDER BY i.gmtCreate DESC"),
               @NamedQuery(name = "countFavoriteByLoginId", query = "SELECT COUNT(i) FROM Favorite i WHERE i.member.loginId = :loginId"),
               @NamedQuery(name = "listFavoriteByBookInfoId", query = "SELECT i FROM Favorite i WHERE i.bookInfo.id = :bookInfoId ORDER BY i.gmtCreate DESC"),
               @NamedQuery(name = "countFavoriteByBookInfoId", query = "SELECT COUNT(i) FROM Favorite i WHERE i.bookInfo.id = :bookInfoId"),
               @NamedQuery(name = "listFavoriteByBookInfoIdAndLoginId", query = "SELECT i FROM Favorite i WHERE i.member.loginId = :loginId AND i.bookInfo.id = :bookInfoId"),
               @NamedQuery(name = "deleteFavoriteById", query = "DELETE FROM Favorite WHERE id = :id") })
public class Favorite {

    @Id
    @GeneratedValue
    private Integer  id;

    @Column(name = "GMT_CREATE")
    private Date     gmtCreate;

    @Column(name = "GMT_MODIFIED")
    private Date     gmtModified;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "LOGIN_ID", nullable = false)
    private Member   member;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "BOOK_INFO_ID", nullable = false)
    private BookInfo bookInfo;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public Member getMember() {
        return member;
    }

    public void setMember(Member member) {
        this.member = member;
    }

    public BookInfo getBookInfo() {
        return bookInfo;
    }

    public void setBookInfo(BookInfo bookInfo) {
        this.bookInfo = bookInfo;
    }
}
