package com.alibaba.intl.bcds.goldroom.action.mygoldroom;

import java.util.ArrayList;
import java.util.List;

import com.alibaba.intl.bcds.goldroom.action.base.BaseAction;
import com.alibaba.intl.bcds.goldroom.dataobject.LendingLog;
import com.alibaba.intl.bcds.goldroom.dataobject.UserDTO;
import com.alibaba.intl.bcds.goldroom.service.LendService;

public class MyLendRecords extends BaseAction {

    /**
     *
     */
    private static final long serialVersionUID = 8435831286390500286L;

    /**
     *
     */
    private LendService       lendService;

    private List<LendingLog>  lendingLogList;
    private int               totalCount;
    private int               page;
    private int               pageSize;

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
        lendingLogList = this.lendService.listLendingLogByLoginId(user.getLoginId(), page, pageSize);
        totalCount = this.lendService.countLendingLogByLoginId(user.getLoginId());
        return SUCCESS;
    }

    public void setLendService(LendService lendService) {
        this.lendService = lendService;
    }

    public LendService getLendService() {
        return lendService;
    }

    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }

    public int getTotalCount() {
        return totalCount;
    }

    public void setLendingLogList(List<LendingLog> lendingLogList) {
        this.lendingLogList = lendingLogList;
    }

    public List<LendingLog> getLendingLogList() {
        return lendingLogList;
    }

}
