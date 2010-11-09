package com.alibaba.intl.bcds.goldroom.action.mygoldroom;

import com.alibaba.intl.bcds.goldroom.action.base.BaseAction;
import com.alibaba.intl.bcds.goldroom.dataobject.UserDTO;
import com.alibaba.intl.bcds.goldroom.result.LendingResult;
import com.alibaba.intl.bcds.goldroom.service.LendService;

public class LendingListAction extends BaseAction {

    /**
	 *
	 */
    private static final long serialVersionUID = -5561310147654805011L;
    private LendService       lendService;

    private int               page;
    private int               pageSize;
    private LendingResult     lendingResult;

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
        setLendingResult(getLendService().listLendedBookItemBySubscriber(user.getLoginId(), page, pageSize));
        return SUCCESS;
    }

    public void setLendingResult(LendingResult lendingResult) {
        this.lendingResult = lendingResult;
    }

    public LendingResult getLendingResult() {
        return lendingResult;
    }

    public void setLendService(LendService lendService) {
        this.lendService = lendService;
    }

    public LendService getLendService() {
        return lendService;
    }
}
