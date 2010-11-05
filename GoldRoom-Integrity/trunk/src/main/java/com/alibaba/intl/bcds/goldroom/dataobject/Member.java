package com.alibaba.intl.bcds.goldroom.dataobject;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "MEMBER")
@NamedQueries({
               @NamedQuery(name = "findByLoginId", query = "SELECT m FROM Member m WHERE loginId = :loginId"),
               @NamedQuery(name = "listMemberByLoginIds", query = "SELECT m from Member m where loginId in (:loginIds)"),
               @NamedQuery(name = "listMemberByStatus", query = "SELECT m from Member m where enable = :status"),
	           @NamedQuery(name = "listMemberByScore", query = "SELECT m from Member m order by m.score desc"),
               @NamedQuery(name = "findMemberByNameAndEmail", query = "SELECT m from Member m where name = :name and email = :email"),
               @NamedQuery(name = "findMemberByEmail", query = "SELECT m FROM Member m WHERE email = :email")


})
public class Member {

    @GeneratedValue
    @Column(name = "ID")
    private Integer id;

    @Column(name = "NAME")
    private String  name;

    @Column(name = "WORK_ID")
    private Integer workId;

    @Id
    @Column(name = "LOGIN_ID")
    private String  loginId;

    @Column(name = "PASSWORD")
    private String  password;

    @Column(name = "EMAIL")
    private String  email;

    @Column(name = "ALI_TALK_ID")
    private String  aliTalkId;

    @Column(name = "GMT_CREATE")
    private Date    gmtCreate;

    @Column(name = "GMT_MODIFIED")
    private Date    gmtModified;

    @Column(name = "ENABLE")
    private Integer enable;

    @Column(name = "LOCATION")
    private String  location;

    @Column(name = "EXT")
    private String  ext;

    @Column(name = "ROLE")
    private String  role;
    
    @Column(name = "score")
    private Integer score; // 会员积分
    
    
    @OneToMany(fetch=FetchType.LAZY, mappedBy="owner")
    private List<BookItem> books; // 会员拥有的书籍实体，关系的维护由BookItem来负责
    

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getWorkId() {
        return workId;
    }

    public void setWorkId(Integer workId) {
        this.workId = workId;
    }

    public String getLoginId() {
        return loginId;
    }

    public void setLoginId(String loginId) {
        this.loginId = loginId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAliTalkId() {
        return aliTalkId;
    }

    public void setAliTalkId(String aliTalkId) {
        this.aliTalkId = aliTalkId;
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

    public Integer getEnable() {
        return enable;
    }

    public void setEnable(Integer enable) {
        this.enable = enable;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getExt() {
        return ext;
    }

    public void setExt(String ext) {
        this.ext = ext;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getRole() {
        return role;
    }

	public Integer getScore() {
		return score;
	}

	public void setScore(Integer score) {
		this.score = score;
	}

	public List<BookItem> getBooks() {
		return books;
	}

	public void setBooks(List<BookItem> books) {
		this.books = books;
	}
}
