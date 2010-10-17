package com.alibaba.intl.bcds.goldroom.action.mygoldroom;

import org.apache.commons.lang.xwork.StringUtils;

import com.alibaba.intl.bcds.goldroom.action.base.BaseAction;

public class UploadPaperBookAction extends BaseAction {

	/**
	 *
	 */
	private static final long serialVersionUID = 8866434764023038616L;

	private String isbn;

	public String execute() throws Exception {
		if (StringUtils.isBlank(isbn)) {
			return "showForm";
		}
		return "showForm";
//		return SUCCESS;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public String getIsbn() {
		return isbn;
	}
}
