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

/**
 * 预约类，完成图书预约的信息记录
 */

@Entity
@Table(name = "RESERVATION")
@NamedQueries({
               @NamedQuery(name = "deleteReservationById", query = "DELETE FROM Reservation WHERE id = :id"),
               @NamedQuery(name = "listReservationByLoginId", query = "SELECT r FROM Reservation r WHERE r.subscriber.loginId = :loginId ORDER BY gmtModified DESC"),
               @NamedQuery(name = "findReservationByBookItemId", query = "SELECT r FROM Reservation r WHERE r.bookItem.id = :bookItemId"),
               @NamedQuery(name = "countReservationByLoginId", query = "SELECT COUNT(r) FROM Reservation r WHERE r.subscriber.loginId = :loginId"),
               @NamedQuery(name = "listReservationByBookItemId", query = "SELECT r FROM Reservation r WHERE r.bookItem.id = :bookItemId ORDER BY gmtModified DESC"),
               @NamedQuery(name = "countReservationByBookItemId", query = "SELECT COUNT(r) FROM Reservation r WHERE r.bookItem.id = :bookItemId")

})
public class Reservation {

    public static String STATE_REJECT        = "reject";
    public static String STATE_TO_BE_COMFIRM = "toBeConfirm";

    @Id
    @GeneratedValue
    private Integer      id;

    @ManyToOne
    @JoinColumn(name = "SUBSCRIBER")
    private Member       subscriber;

    @Column(name = "LEND_TIME")
    private Date         lendTime;

    @Column(name = "RETURN_TIME")
    private Date         returnTime;

    @Column(name = "STATE")
    private String       state;

    @Column(name = "GMT_CREATE")
    private Date gmtCreate;
    
    @Column(name = "GMT_MODIFIED")
    private Date gmtModified;

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name = "BOOK_ITEM_ID")
    private BookItem     bookItem;

    public BookItem getBookItem() {
        return bookItem;
    }

    public void setBookItem(BookItem bookItem) {
        this.bookItem = bookItem;
    }


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
}
