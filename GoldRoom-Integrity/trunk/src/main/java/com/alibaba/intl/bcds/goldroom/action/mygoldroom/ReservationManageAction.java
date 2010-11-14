package com.alibaba.intl.bcds.goldroom.action.mygoldroom;

import java.util.Date;

import com.alibaba.intl.bcds.goldroom.action.base.BaseAction;
import com.alibaba.intl.bcds.goldroom.dataobject.UserDTO;
import com.alibaba.intl.bcds.goldroom.service.ReservationService;

public class ReservationManageAction extends BaseAction {

    /**
     *
     */
    private static final long  serialVersionUID = 9111490067845452605L;

    private ReservationService reservationService;

    private Integer            bookItemId;
    private Date               lendTime;
    private Date               returnTime;
    private String             result;

    public String execute() throws Exception {
        UserDTO userDTO = this.getUserDTO();
        if (userDTO == null) {
            return ERROR;
        }
        if (reservationService.reserve(userDTO.getLoginId(), bookItemId, lendTime, returnTime)) {
            setResult(SUCCESS);
        } else {
            setResult(ERROR);
        }
        return getResult();
    }

    public void setReservationService(ReservationService reservationService) {
        this.reservationService = reservationService;
    }

    public ReservationService getReservationService() {
        return reservationService;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public String getResult() {
        return result;
    }

    public void setBookItemId(Integer bookItemId) {
        this.bookItemId = bookItemId;
    }

    public Integer getBookItemId() {
        return bookItemId;
    }

    public void setLendTime(Date lendTime) {
        this.lendTime = lendTime;
    }

    public Date getLendTime() {
        return lendTime;
    }

    public void setReturnTime(Date returnTime) {
        this.returnTime = returnTime;
    }

    public Date getReturnTime() {
        return returnTime;
    }

}
