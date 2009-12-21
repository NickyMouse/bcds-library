package com.alibaba.intl.bcds.goldroom.dataobject;

import java.util.Date;

/**
 * 
 * @author Larry Su
 */
public class Integral {
	
	// ID
	private Integer id;
	
	// 创建记录时间
	private Date gmtCreate;
	
	// 修改记录时间
	private Date gmtModified;
	
	// 用户登录ID
	private String loginId;
	
	// 积分值
	private long value;
	
    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }
	
    public Date getGmtCreate() {
        return this.gmtCreate;
    }
    
    public void setGmtCreate(Date gmtCreate) {
        this.gmtCreate = gmtCreate;
    }
    
    public Date getGmtModified() {
        return this.gmtModified;
    }
    
    public void setGmtModified(Date gmtModified) {
        this.gmtModified = gmtModified;
    }
    
    public String getLoginId() {
        return this.loginId;
    }
    
    public void setLoginId(String loginId) {
        this.loginId = loginId;
    }
    
    public long getValue() {
        return this.value;
    }
    
    public void setValue(long value) {
        this.value = value;
    }
    
}
