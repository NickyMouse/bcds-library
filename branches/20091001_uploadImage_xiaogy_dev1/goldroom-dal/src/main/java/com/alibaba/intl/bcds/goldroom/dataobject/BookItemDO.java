package com.alibaba.intl.bcds.goldroom.dataobject;

import java.util.Date;

public class BookItemDO {
	private Integer id;
	private Integer state;
	private Integer ownerId;
	private Date addTime;
	private Date removeTime;
	private Integer bookInfoId;
	private Date firstAddTime;
	private Date gmtCreate;
	private Date gmtModified;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getState() {
		return state;
	}
	public void setState(Integer state) {
		this.state = state;
	}
	public Integer getOwnerId() {
		return ownerId;
	}
	public void setOwnerId(Integer ownerId) {
		this.ownerId = ownerId;
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
	public Integer getBookInfoId() {
		return bookInfoId;
	}
	public void setBookInfoId(Integer bookInfoId) {
		this.bookInfoId = bookInfoId;
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
	private String tags;
}
