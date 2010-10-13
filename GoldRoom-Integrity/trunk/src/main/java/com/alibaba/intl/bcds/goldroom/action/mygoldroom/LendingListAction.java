package com.alibaba.intl.bcds.goldroom.action.mygoldroom;

import com.alibaba.intl.bcds.goldroom.action.base.BaseAction;
import com.alibaba.intl.bcds.goldroom.result.LendingResult;
import com.alibaba.intl.bcds.goldroom.service.LendService;

public class LendingListAction extends BaseAction {

	/**
	 *
	 */
	private static final long serialVersionUID = -5561310147654805011L;
	private LendService lendService;

	// FIXME LOGIN ID 要换成真正的loginId 不是表单传过来的
	private String loginId;
	private int page;
	private int pageSize;
	private LendingResult lendingResult;

	public String getLoginId() {
		return loginId;
	}

	public void setLoginId(String loginId) {
		this.loginId = loginId;
	}

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
		if (page <= 0) {
			page = 1;
		}
		setLendingResult(getLendService().listLendedBookItemBySubscriber(
				loginId, page, pageSize));
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
