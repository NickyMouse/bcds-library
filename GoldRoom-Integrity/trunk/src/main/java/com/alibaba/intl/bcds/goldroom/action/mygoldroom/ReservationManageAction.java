package com.alibaba.intl.bcds.goldroom.action.mygoldroom;

import java.util.Date;

import org.apache.commons.lang.time.DateUtils;

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
    private String             lendTime;
    private String             returnTime;
    private String             result;
    private static String      DATE_FORMAT      = "yyyy-MM-dd";

    public String execute() throws Exception {
        UserDTO userDTO = this.getUserDTO();
        if (userDTO == null || lendTime == null || returnTime == null || bookItemId == null) {
            return ERROR;
        }

        Date lendTimeDate = null;
        Date returnTimeDate = null;
        try {
            lendTimeDate = DateUtils.parseDate(lendTime, new String[] { DATE_FORMAT });
            returnTimeDate = DateUtils.parseDate(returnTime, new String[] { DATE_FORMAT });
        } catch (Exception e) {
            result = ERROR;
            return result;
        }
        if (reservationService.reserve(userDTO.getLoginId(), bookItemId, lendTimeDate, returnTimeDate)) {
            result = SUCCESS;
        } else {
            result = ERROR;
        }
        return result;
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

    public void setLendTime(String lendTime) {
        this.lendTime = lendTime;
    }

    public String getLendTime() {
        return lendTime;
    }

    public void setReturnTime(String returnTime) {
        this.returnTime = returnTime;
    }

    public String getReturnTime() {
        return returnTime;
    }

}
