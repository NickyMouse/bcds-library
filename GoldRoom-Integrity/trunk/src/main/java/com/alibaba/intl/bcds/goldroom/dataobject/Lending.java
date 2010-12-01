package com.alibaba.intl.bcds.goldroom.dataobject;

import java.text.ParseException;
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
import javax.persistence.Transient;

import com.alibaba.intl.bcds.goldroom.util.DateUtil;

/**
 * 图书借阅信息
 * 
 * @author Zimmem
 */
@Entity
@Table(name = "LENDING")
@NamedQueries( {
		@NamedQuery(name = "deleteLendingById", query = "DELETE FROM Lending WHERE id = :id"),
		@NamedQuery(name = "listLendingByLoginId", query = "SELECT l FROM Lending l WHERE l.subscriber.loginId = :loginId ORDER BY gmtModified DESC"),
		@NamedQuery(name = "countLendingByLoginId", query = "SELECT COUNT(l) FROM Lending l WHERE l.subscriber.loginId = :loginId"),
		@NamedQuery(name = "listLendingByBookItemId", query = "SELECT l FROM Lending l WHERE l.bookItem.id= :bookItemId ORDER BY gmtModified DESC"),
		@NamedQuery(name = "countLendingByBookItemId", query = "SELECT COUNT(l) FROM Lending l WHERE l.bookItem.id= :bookItemId")

})
public class Lending {

	@Id
	@GeneratedValue
	private Integer id;

	@ManyToOne
	@JoinColumn(name = "SUBSCRIBER")
	private Member subscriber;

	@Column(name = "LEND_TIME")
	private Date lendTime;

	@Column(name = "RETURN_TIME")
	private Date returnTime;

	@Column(name = "STATE")
	private String state;

	@ManyToOne
	@JoinColumn(name = "BOOK_ITEM_ID")
	private BookItem bookItem;

	@Transient
	private boolean hasExpire; // 是否过期
	
	public boolean isHasExpire() {
		return hasExpire;
	}

	public void setHasExpire(boolean hasExpire) {
		this.hasExpire = hasExpire;
	}

	@Transient
	private long ExpireDays; // 距还书时间差

	public BookItem getBookItem() {
		return bookItem;
	}

	public void setBookItem(BookItem bookItem) {
		this.bookItem = bookItem;
	}

	@Column(name = "REAL_RETURN_TIME")
	private Date realReturnTime;

	@Column(name = "GMT_CREATE")
	private Date gmtCreate;

	@Column(name = "GMT_MODIFIED")
	private Date gmtModified;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Member getSubscriber() {
		return subscriber;
	}

	public void setSubscriber(Member subscriber) {
		this.subscriber = subscriber;
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

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public Date getRealReturnTime() {
		return realReturnTime;
	}

	public void setRealReturnTime(Date realReturnTime) {
		this.realReturnTime = realReturnTime;
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

	

	public long getExpireDays() {
		try {
			return DateUtil.getDistDates(DateUtil.FormatDate(this.returnTime),
					DateUtil.currentDate());
		} catch (ParseException e) {

			e.printStackTrace();
			return 0;
		}
	}
}
