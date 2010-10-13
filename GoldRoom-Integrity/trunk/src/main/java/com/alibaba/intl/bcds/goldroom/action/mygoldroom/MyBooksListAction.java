package com.alibaba.intl.bcds.goldroom.action.mygoldroom;

import org.apache.commons.lang.StringUtils;

import com.alibaba.intl.bcds.goldroom.action.base.BaseAction;
import com.alibaba.intl.bcds.goldroom.constaints.BookItemStateEnum;
import com.alibaba.intl.bcds.goldroom.result.BookItemResult;
import com.alibaba.intl.bcds.goldroom.service.BookItemService;

public class MyBooksListAction extends BaseAction {

	/**
	 *
	 */
	private static final long serialVersionUID = -4469003624699130274L;
	private BookItemService bookItemService;

	private String state;

	// FIXME LOGIN ID 要换成真正的loginId 不是表单传过来的
	private String loginId;
	private int page;
	private int pageSize;
	private BookItemResult bookItemResult;

	public BookItemService getBookItemService() {
		return bookItemService;
	}

	public void setBookItemService(BookItemService bookItemService) {
		this.bookItemService = bookItemService;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

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
		if (StringUtils.isBlank(state)
				|| !BookItemStateEnum.isValidState(state)) {
			state = "all";
		}
		setBookItemResult(bookItemService.listBookItemsByLoginIdAndState(
				loginId, state, page, pageSize));
		return SUCCESS;
	}

	public void setBookItemResult(BookItemResult bookItemResult) {
		this.bookItemResult = bookItemResult;
	}

	public BookItemResult getBookItemResult() {
		return bookItemResult;
	}
}