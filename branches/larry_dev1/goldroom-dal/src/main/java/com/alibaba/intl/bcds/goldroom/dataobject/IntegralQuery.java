package com.alibaba.intl.bcds.goldroom.dataobject;

public class IntegralQuery extends Integral {

	private long alterValue = 0;

	private Integer offset = 0;

	private Integer psize = 10;

	private String orderBy;

	private String ascOrDesc = "desc";

	public IntegralQuery() {
	}

	public IntegralQuery(Integral integral) {
		if (null != integral) {
			super.setId(integral.getId());
			super.setLoginId(integral.getLoginId());
			super.setValue(integral.getValue());
		}
	}

	public long getAlterValue() {
		return this.alterValue;
	}

	public void setAlterValue(long alterValue) {
		this.alterValue = alterValue;
	}

	public Integer getOffset() {
		return this.offset;
	}

	public void setOffset(Integer offset) {
		this.offset = offset;
	}

	public Integer getPsize() {
		return this.psize;
	}

	public void setPsize(Integer psize) {
		this.psize = psize;
	}

	public String getOrderBy() {
		return this.orderBy;
	}

	public void setOrderBy(String orderBy) {
		this.orderBy = orderBy;
	}

	public boolean getIsDesc() {
		if (this.ascOrDesc.equalsIgnoreCase("desc")) {
			return true;
		} else {
			return false;
		}
	}

	public void setIsDesc(boolean isDesc) {
		if (isDesc) {
			this.ascOrDesc = "desc";
		} else {
			this.ascOrDesc = "asc";
		}
	}

	public String getAscOrDesc() {
		return this.ascOrDesc;
	}
}
