package com.alibaba.intl.bcds.goldroom.action.mygoldroom;

import com.alibaba.intl.bcds.goldroom.action.base.BaseAction;
import com.alibaba.intl.bcds.goldroom.result.ReservationResult;
import com.alibaba.intl.bcds.goldroom.service.ReservationService;

public class ReservationListAction extends BaseAction {

	/**
	 *
	 */
	private static final long serialVersionUID = 1847800305090183936L;

	private ReservationService reservationService;

	// FIXME LOGIN ID 要换成真正的loginId 不是表单传过来的
	private String loginId;
	private int page;
	private int pageSize;
	private ReservationResult reservationResult;

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
		setReservationResult(getReservationService()
				.listReservatedBooksBySubscriber(loginId, page, pageSize));
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

}
