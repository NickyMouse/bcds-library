package com.alibaba.intl.bcds.goldroom.action.mygoldroom;

import org.apache.commons.lang.xwork.StringUtils;

import com.alibaba.intl.bcds.goldroom.action.base.BaseAction;

public class UploadEBookAction extends BaseAction {

	/**
	 *
	 */
	private static final long serialVersionUID = 7530161161996114402L;

	private String isbn;

	public String execute() throws Exception {
		if (StringUtils.isBlank(isbn)) {

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
