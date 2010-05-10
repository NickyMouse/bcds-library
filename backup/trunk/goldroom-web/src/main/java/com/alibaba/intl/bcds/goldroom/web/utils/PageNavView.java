package com.alibaba.intl.bcds.goldroom.web.utils;

public class PageNavView {
	int pageSize;
	int currentPage;

	int totalPage;
	int totalCount;
	private String currentUrl;

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public int getNextPage() {
		if (currentPage >= this.getTotalPage()) {
			return 0;
		} else {
			return currentPage + 1;
		}
	}

	public int getPrePage() {
		if (currentPage <= 1) {
			return 0;
		} else {
			return currentPage - 1;
		}
	}

	public int getTotalPage() {
		if (pageSize == 0) {
			pageSize = 5;
		}
		return (int) Math.ceil(totalCount / (double) pageSize);
	}

	public int getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}

	public void setCurrentUrl(String currentUrl) {
		this.currentUrl = currentUrl;
	}

	public String getCurrentUrl() {
		return currentUrl;
	}
}
