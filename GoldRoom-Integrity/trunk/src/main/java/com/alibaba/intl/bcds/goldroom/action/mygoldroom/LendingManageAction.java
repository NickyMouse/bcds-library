package com.alibaba.intl.bcds.goldroom.action.mygoldroom;

import com.alibaba.intl.bcds.goldroom.action.base.BaseAction;
import com.alibaba.intl.bcds.goldroom.dataobject.UserDTO;
import com.alibaba.intl.bcds.goldroom.service.LendService;

public class LendingManageAction extends BaseAction {

    /**
     *
     */
    private static final long serialVersionUID = 2081030252643156126L;
    private LendService       lendService;
    private String            type;
    private Integer           reservationId;
    private String            result;
    private Integer           lendId;

    public String execute() throws Exception {
        UserDTO userDTO = this.getUserDTO();
        if (userDTO == null) {
            return ERROR;
        }
        if ("agreeLend".equals(getType())) {
            if (reservationId == null) {
                return ERROR;
            }
            if (lendService.lend(reservationId, userDTO.getLoginId())) {
                result = SUCCESS;
            } else {
                result = ERROR;
            }

        } else if ("rejectLend".equals(getType())) {
            if (reservationId == null) {
                return ERROR;
            }
            if (lendService.rejectLend(reservationId, userDTO.getLoginId())) {
                result = SUCCESS;
            } else {
                result = ERROR;
            }

        } else if ("returnBook".equals(getType())) {
            if (lendId == null) {
                return ERROR;
            }

            if (lendService.returnBook(lendId, userDTO.getLoginId())) {
                result = SUCCESS;
            } else {
                result = ERROR;
            }

        }
        return result;
    }

    public void setLendService(LendService lendService) {
        this.lendService = lendService;
    }

    public LendService getLendService() {
        return lendService;
    }

    public void setReservationId(Integer reservationId) {
        this.reservationId = reservationId;
    }

    public Integer getReservationId() {
        return reservationId;
    }

    public void setLendId(Integer lendId) {
        this.lendId = lendId;
    }

    public Integer getLendId() {
        return lendId;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public String getResult() {
        return result;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }
}
