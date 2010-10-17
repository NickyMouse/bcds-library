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

import org.apache.commons.lang.builder.ToStringBuilder;

@Entity
@Table(name = "BOOK_ITEM")
@NamedQueries({
               @NamedQuery(name = "deleteBookItemById", query = "DELETE FROM BookItem WHERE id = :id"),
               @NamedQuery(name = "listBookItemsByLoginId", query = "SELECT i FROM BookItem i WHERE i.owner.loginId = :loginId ORDER BY i.gmtCreate DESC"),
               @NamedQuery(name = "countBookItemsByLoginIdAndState", query = "SELECT COUNT(i) FROM BookItem i WHERE i.owner.loginId = :loginId AND state = :state"),
               @NamedQuery(name = "listBookItemsByLoginIdAndState", query = "SELECT i FROM BookItem i WHERE i.owner.loginId = :loginId AND state = :state ORDER BY i.gmtCreate DESC"),
               @NamedQuery(name = "countBookItemsByLoginId", query = "SELECT COUNT(i) FROM BookItem i WHERE i.owner.loginId = :loginId"),
               @NamedQuery(name = "listBookItemByBookInfoId", query = "SELECT i FROM BookItem i WHERE i.bookInfo.id = :bookInfoId ORDER BY i.gmtCreate DESC"),
               @NamedQuery(name = "listBookItemsByLoginIdAndStateAndBookInfoIds", query = "SELECT i FROM BookItem i WHERE i.bookInfo.id in (:bookInfoIds) AND i.owner.loginId = :loginId AND state = :state"),
               @NamedQuery(name = "listBookItemsByLoginIdsAndBookInfoId", query = "SELECT i FROM BookItem i WHERE i.bookInfo.id = :bookInfoId AND i.owner.loginId in (:loginIds)")

})
public class BookItem {

    @Id
    @GeneratedValue
    private Integer  id;

    @Column(name = "STATE")
    private String   state;

    @ManyToOne
    // (fetch=FetchType.LAZY)
    @JoinColumn(name = "LOGIN_ID", nullable = false)
    private Member   owner;

    @Column(name = "ADD_TIME")
    private Date     addTime;

    @Column(name = "REMOVE_TIME")
    private Date     removeTime;

    @Column(name = "FIRST_ADD_TIME")
    private Date     firstAddTime;

    @Column(name = "GMT_CREATE")
    private Date     gmtCreate;

    @Column(name = "GMT_MODIFIED")
    private Date     gmtModified;

    @Column(name = "TAGS")
    private String   tags;

    @Column(name = "REMARK")
    private String   remark;

    @ManyToOne
    @JoinColumn(name = "BOOK_INFO_ID")
    private BookInfo bookInfo;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public Date getAddTime() {
        return addTime;
    }

    public void setAddTime(Date addTime) {
        this.addTime = addTime;
    }

    public Date getRemoveTime() {
        return removeTime;
    }

    public void setRemoveTime(Date removeTime) {
        this.removeTime = removeTime;
    }

    public Date getFirstAddTime() {
        return firstAddTime;
    }

    public void setFirstAddTime(Date firstAddTime) {
        this.firstAddTime = firstAddTime;
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

    public String getTags() {
        return tags;
    }

    public void setTags(String tags) {
        this.tags = tags;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getRemark() {
        return remark;
    }

    public BookInfo getBookInfo() {
        return bookInfo;
    }

    public void setBookInfo(BookInfo bookInfo) {
        this.bookInfo = bookInfo;
    }

    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    public Member getOwner() {
        return owner;
    }

    public void setOwner(Member owner) {
        this.owner = owner;
    }

}
