/**
 * 
 */
package com.alibaba.intl.bcds.goldroom.dataobject;

import java.io.Serializable;

/**
 * 公司内部的员工信息
 * 
 * @author Harrison
 *
 */
public class AlibabaStaffDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6604691391723198383L;
	
	
	private String staffId; // 工号
	private String nick; // 昵称，可做loginId
	private String name; // 姓名
	private String gendear; // 性别
	private String department; // 部门
	private String title; // 岗位
	private String extPhone; // 分机
	private String mobile; // 手机
	private String email; 
	private String aliTalkId; // 旺旺
	/**
	 * @return the staffId
	 */
	public String getStaffId() {
		return staffId;
	}
	/**
	 * @param staffId the staffId to set
	 */
	public void setStaffId(String staffId) {
		this.staffId = staffId;
	}
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the gendear
	 */
	public String getGendear() {
		return gendear;
	}
	/**
	 * @param gendear the gendear to set
	 */
	public void setGendear(String gendear) {
		this.gendear = gendear;
	}
	/**
	 * @return the department
	 */
	public String getDepartment() {
		return department;
	}
	/**
	 * @param department the department to set
	 */
	public void setDepartment(String department) {
		this.department = department;
	}
	/**
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}
	/**
	 * @param title the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}
	/**
	 * @return the extPhone
	 */
	public String getExtPhone() {
		return extPhone;
	}
	/**
	 * @param extPhone the extPhone to set
	 */
	public void setExtPhone(String extPhone) {
		this.extPhone = extPhone;
	}
	/**
	 * @return the mobile
	 */
	public String getMobile() {
		return mobile;
	}
	/**
	 * @param mobile the mobile to set
	 */
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}
	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	/**
	 * @return the aliTalkId
	 */
	public String getAliTalkId() {
		return aliTalkId;
	}
	/**
	 * @param aliTalkId the aliTalkId to set
	 */
	public void setAliTalkId(String aliTalkId) {
		this.aliTalkId = aliTalkId;
	}
	/**
	 * @return the nick
	 */
	public String getNick() {
		return nick;
	}
	/**
	 * @param nick the nick to set
	 */
	public void setNick(String nick) {
		this.nick = nick;
	}

}
