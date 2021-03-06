package com.alibaba.intl.bcds.goldroom.dataobject;

import java.util.Date;

public class Reservation {
	public static String STATE_REJECT = "reject";
	public static String STATE_TO_BE_COMFIRM = "toBeConfirm";
	/**
	 * This field was generated by Apache iBATIS ibator. This field corresponds
	 * to the database column RESERVATION.ID
	 * 
	 * @ibatorgenerated Tue Sep 29 19:05:09 CST 2009
	 */
	private Integer id;

	/**
	 * This field was generated by Apache iBATIS ibator. This field corresponds
	 * to the database column RESERVATION.OWNER_ID
	 * 
	 * @ibatorgenerated Tue Sep 29 19:05:09 CST 2009
	 */
	private String ownerId;

	/**
	 * This field was generated by Apache iBATIS ibator. This field corresponds
	 * to the database column RESERVATION.SUBSCRIBER_ID
	 * 
	 * @ibatorgenerated Tue Sep 29 19:05:09 CST 2009
	 */
	private String subscriber;

	/**
	 * This field was generated by Apache iBATIS ibator. This field corresponds
	 * to the database column RESERVATION.LEND_TIME
	 * 
	 * @ibatorgenerated Tue Sep 29 19:05:09 CST 2009
	 */
	private Date lendTime;

	/**
	 * This field was generated by Apache iBATIS ibator. This field corresponds
	 * to the database column RESERVATION.RETURN_TIME
	 * 
	 * @ibatorgenerated Tue Sep 29 19:05:09 CST 2009
	 */
	private Date returnTime;

	/**
	 * This field was generated by Apache iBATIS ibator. This field corresponds
	 * to the database column RESERVATION.STATE
	 * 
	 * @ibatorgenerated Tue Sep 29 19:05:09 CST 2009
	 */
	private String state;

	/**
	 * This field was generated by Apache iBATIS ibator. This field corresponds
	 * to the database column RESERVATION.BOOK_ITEM_ID
	 * 
	 * @ibatorgenerated Tue Sep 29 19:05:09 CST 2009
	 */
	private Integer bookItemId;

	/**
	 * This field was generated by Apache iBATIS ibator. This field corresponds
	 * to the database column RESERVATION.GMT_CREATE
	 * 
	 * @ibatorgenerated Tue Sep 29 19:05:09 CST 2009
	 */
	private Date gmtCreate;

	/**
	 * This field was generated by Apache iBATIS ibator. This field corresponds
	 * to the database column RESERVATION.GMT_MODIFIED
	 * 
	 * @ibatorgenerated Tue Sep 29 19:05:09 CST 2009
	 */
	private Date gmtModified;

	/**
	 * This method was generated by Apache iBATIS ibator. This method returns
	 * the value of the database column RESERVATION.ID
	 * 
	 * @return the value of RESERVATION.ID
	 * @ibatorgenerated Tue Sep 29 19:05:09 CST 2009
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * This method was generated by Apache iBATIS ibator. This method sets the
	 * value of the database column RESERVATION.ID
	 * 
	 * @param id
	 *            the value for RESERVATION.ID
	 * @ibatorgenerated Tue Sep 29 19:05:09 CST 2009
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * This method was generated by Apache iBATIS ibator. This method returns
	 * the value of the database column RESERVATION.OWNER_ID
	 * 
	 * @return the value of RESERVATION.OWNER_ID
	 * @ibatorgenerated Tue Sep 29 19:05:09 CST 2009
	 */
	public String getOwnerId() {
		return ownerId;
	}

	/**
	 * This method was generated by Apache iBATIS ibator. This method sets the
	 * value of the database column RESERVATION.OWNER_ID
	 * 
	 * @param ownerId
	 *            the value for RESERVATION.OWNER_ID
	 * @ibatorgenerated Tue Sep 29 19:05:09 CST 2009
	 */
	public void setOwnerId(String ownerId) {
		this.ownerId = ownerId;
	}

	/**
	 * This method was generated by Apache iBATIS ibator. This method returns
	 * the value of the database column RESERVATION.SUBSCRIBER_ID
	 * 
	 * @return the value of RESERVATION.SUBSCRIBER_ID
	 * @ibatorgenerated Tue Sep 29 19:05:09 CST 2009
	 */
	public String getSubscriber() {
		return subscriber;
	}

	/**
	 * This method was generated by Apache iBATIS ibator. This method sets the
	 * value of the database column RESERVATION.SUBSCRIBER_ID
	 * 
	 * @param subscriberId
	 *            the value for RESERVATION.SUBSCRIBER_ID
	 * @ibatorgenerated Tue Sep 29 19:05:09 CST 2009
	 */
	public void setSubscriber(String subscriber) {
		this.subscriber = subscriber;
	}

	/**
	 * This method was generated by Apache iBATIS ibator. This method returns
	 * the value of the database column RESERVATION.LEND_TIME
	 * 
	 * @return the value of RESERVATION.LEND_TIME
	 * @ibatorgenerated Tue Sep 29 19:05:09 CST 2009
	 */
	public Date getLendTime() {
		return lendTime;
	}

	/**
	 * This method was generated by Apache iBATIS ibator. This method sets the
	 * value of the database column RESERVATION.LEND_TIME
	 * 
	 * @param lendTime
	 *            the value for RESERVATION.LEND_TIME
	 * @ibatorgenerated Tue Sep 29 19:05:09 CST 2009
	 */
	public void setLendTime(Date lendTime) {
		this.lendTime = lendTime;
	}

	/**
	 * This method was generated by Apache iBATIS ibator. This method returns
	 * the value of the database column RESERVATION.RETURN_TIME
	 * 
	 * @return the value of RESERVATION.RETURN_TIME
	 * @ibatorgenerated Tue Sep 29 19:05:09 CST 2009
	 */
	public Date getReturnTime() {
		return returnTime;
	}

	/**
	 * This method was generated by Apache iBATIS ibator. This method sets the
	 * value of the database column RESERVATION.RETURN_TIME
	 * 
	 * @param returnTime
	 *            the value for RESERVATION.RETURN_TIME
	 * @ibatorgenerated Tue Sep 29 19:05:09 CST 2009
	 */
	public void setReturnTime(Date returnTime) {
		this.returnTime = returnTime;
	}

	/**
	 * This method was generated by Apache iBATIS ibator. This method returns
	 * the value of the database column RESERVATION.STATE
	 * 
	 * @return the value of RESERVATION.STATE
	 * @ibatorgenerated Tue Sep 29 19:05:09 CST 2009
	 */
	public String getState() {
		return state;
	}

	/**
	 * This method was generated by Apache iBATIS ibator. This method sets the
	 * value of the database column RESERVATION.STATE
	 * 
	 * @param state
	 *            the value for RESERVATION.STATE
	 * @ibatorgenerated Tue Sep 29 19:05:09 CST 2009
	 */
	public void setState(String state) {
		this.state = state;
	}

	/**
	 * This method was generated by Apache iBATIS ibator. This method returns
	 * the value of the database column RESERVATION.BOOK_ITEM_ID
	 * 
	 * @return the value of RESERVATION.BOOK_ITEM_ID
	 * @ibatorgenerated Tue Sep 29 19:05:09 CST 2009
	 */
	public Integer getBookItemId() {
		return bookItemId;
	}

	/**
	 * This method was generated by Apache iBATIS ibator. This method sets the
	 * value of the database column RESERVATION.BOOK_ITEM_ID
	 * 
	 * @param bookItemId
	 *            the value for RESERVATION.BOOK_ITEM_ID
	 * @ibatorgenerated Tue Sep 29 19:05:09 CST 2009
	 */
	public void setBookItemId(Integer bookItemId) {
		this.bookItemId = bookItemId;
	}

	/**
	 * This method was generated by Apache iBATIS ibator. This method returns
	 * the value of the database column RESERVATION.GMT_CREATE
	 * 
	 * @return the value of RESERVATION.GMT_CREATE
	 * @ibatorgenerated Tue Sep 29 19:05:09 CST 2009
	 */
	public Date getGmtCreate() {
		return gmtCreate;
	}

	/**
	 * This method was generated by Apache iBATIS ibator. This method sets the
	 * value of the database column RESERVATION.GMT_CREATE
	 * 
	 * @param gmtCreate
	 *            the value for RESERVATION.GMT_CREATE
	 * @ibatorgenerated Tue Sep 29 19:05:09 CST 2009
	 */
	public void setGmtCreate(Date gmtCreate) {
		this.gmtCreate = gmtCreate;
	}

	/**
	 * This method was generated by Apache iBATIS ibator. This method returns
	 * the value of the database column RESERVATION.GMT_MODIFIED
	 * 
	 * @return the value of RESERVATION.GMT_MODIFIED
	 * @ibatorgenerated Tue Sep 29 19:05:09 CST 2009
	 */
	public Date getGmtModified() {
		return gmtModified;
	}

	/**
	 * This method was generated by Apache iBATIS ibator. This method sets the
	 * value of the database column RESERVATION.GMT_MODIFIED
	 * 
	 * @param gmtModified
	 *            the value for RESERVATION.GMT_MODIFIED
	 * @ibatorgenerated Tue Sep 29 19:05:09 CST 2009
	 */
	public void setGmtModified(Date gmtModified) {
		this.gmtModified = gmtModified;
	}
}
