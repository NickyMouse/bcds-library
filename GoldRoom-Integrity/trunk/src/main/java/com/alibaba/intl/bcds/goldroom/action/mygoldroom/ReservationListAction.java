package com.alibaba.intl.bcds.goldroom.action.mygoldroom;

import org.apache.commons.lang.StringUtils;

import com.alibaba.intl.bcds.goldroom.action.base.BaseAction;
import com.alibaba.intl.bcds.goldroom.constaints.ReservationStateEnum;
import com.alibaba.intl.bcds.goldroom.dataobject.UserDTO;
import com.alibaba.intl.bcds.goldroom.result.ReservationResult;
import com.alibaba.intl.bcds.goldroom.service.ReservationService;

public class ReservationListAction extends BaseAction {

    /**
	 *
	 */
    private static final long  serialVersionUID = 1847800305090183936L;

    private ReservationService reservationService;

    // FIXME LOGIN ID 要换成真正的loginId 不是表单传过来的
    private int                page;
    private int                pageSize;
    private ReservationResult  reservationResult;
    private String             state;

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public String execute() throws Exception {
        UserDTO user = this.getUserDTO();
        if (user == null) {
            return ERROR;
        }
        if (page <= 0) {
            page = 1;
        }
        if (StringUtils.isBlank(state) || !ReservationStateEnum.isValidState(state)) {
            reservationResult = reservationService.listReservatedBooksBySubscriber(user.getLoginId(), page, pageSize);
        } else {
            reservationResult = reservationService.listReservatedBooksBySubscriberAndState(user.getLoginId(), state,
                                                                                           page, pageSize);
        }
        return SUCCESS;
    }

    public void setReservationResult(ReservationResult reservationResult) {
        this.reservationResult = reservationResult;
    }

    public ReservationResult getReservationResult() {
        return reservationResult;
    }

    public void setReservationService(ReservationService reservationService) {
        this.reservationService = reservationService;
    }

    public ReservationService getReservationService() {
        return reservationService;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getState() {
        return state;
    }

}
