package com.alibaba.intl.goldroom.dataobject;

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
@Table(name = "COMMENT")
@NamedQueries({
               @NamedQuery(name = "listAllComment", query = "SELECT c FROM Comment c ORDER BY gmtCreate DESC"),
               @NamedQuery(name = "listCommentByTargetTypeAndTargetId", query = "SELECT c FROM Comment c WHERE targetType=:targetType AND targetId = :targetId ORDER BY gmtCreate DESC"),
               @NamedQuery(name = "listCommentByLoginId", query = "SELECT c FROM Comment c WHERE c.member.loginId = :loginId ORDER BY gmtCreate DESC"),
               @NamedQuery(name = "deleteCommentByLoginId", query = "DELETE FROM Comment c WHERE c.member.loginId = :loginId"),
               @NamedQuery(name = "deleteCommentByTargetTypeAndTargetId", query = "DELETE FROM Comment c WHERE targetType=:targetType AND targetId = :targetId"),
               @NamedQuery(name = "deleteCommentById", query = "DELETE FROM Comment c WHERE id=:id")

})
public class Comment {

    @Id
    @GeneratedValue
    private Integer id;

    @Column(name = "TARGET_TYPE")
    private String  targetType;

    @Column(name = "TARGET_ID")
    private Integer targetId;

    @Column(name = "GMT_CREATE")
    private Date    gmtCreate;

    @Column(name = "GMT_MODIFIED")
    private Date    gmtModified;

    @ManyToOne
    @JoinColumn(name = "LOGIN_ID")
    private Member  member;

    @Column(name = "REPLY_ID")
    private Integer replyId;

    @Column(name = "CONTENT")
    private String  content;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTargetType() {
        return targetType;
    }

    public void setTargetType(String targetType) {
        this.targetType = targetType;
    }

    public Integer getTargetId() {
        return targetId;
    }

    public void setTargetId(Integer targetId) {
        this.targetId = targetId;
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

    public Integer getReplyId() {
        return replyId;
    }

    public void setReplyId(Integer replyId) {
        this.replyId = replyId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Member getMember() {
        return member;
    }

    public void setMember(Member member) {
        this.member = member;
    }

}
