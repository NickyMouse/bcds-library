package com.alibaba.intl.bcds.goldroom.dataobject;

import java.util.Date;

public class BookItemLogDO {
	private Integer id;
	private Date gmtCreate;
	private Date gmtModified;
	private Integer logType;
	private String logMsg;
	
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
	public Integer getLogType() {
		return logType;
	}
	public void setLogType(Integer logType) {
		this.logType = logType;
	}
	public String getLogMsg() {
		return logMsg;
	}
	public void setLogMsg(String logMsg) {
		this.logMsg = logMsg;
	}
	public Integer getBookItemId() {
		return bookItemId;
	}
	public void setBookItemId(Integer bookItemId) {
		this.bookItemId = bookItemId;
	}
	private Integer bookItemId;
}
