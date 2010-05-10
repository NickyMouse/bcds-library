package com.alibaba.intl.bcds.goldroom.dataobject;

/**
 * IntegralQuery 积分参数对象
 * 
 * @author Larry Su
 */
public class IntegralQuery extends Integral {

	public final String ASC = "asc";

	public final String DESC = "desc";

	// 需要修改的积分值
	private long alterValue = 0;

	// 查询起始记录数，分页查询时使用
	private Integer offset = 0;

	// 查询记录数，分页查询时使用
	private Integer psize = 100;

	// 排序字段，如果不需要排序请保持为空
	private String orderBy;

	// 正序还是倒序排列，默认为倒序排列
	private String ascOrDesc = this.DESC;

	public IntegralQuery() {
	}

	public IntegralQuery(String loginId) {
		if (null != loginId) {
			super.setLoginId(loginId);
		}
	}

	public IntegralQuery(Integer id) {
		if (null != id) {
			super.setId(id);
		}
	}

	public IntegralQuery(String loginId, long value) {
		if (null != loginId) {
			super.setLoginId(loginId);
			super.setValue(value);
		}
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
		if (this.ascOrDesc.equalsIgnoreCase(this.DESC)) {
			return true;
		} else {
			return false;
		}
	}

	public void setIsDesc(boolean isDesc) {
		if (isDesc) {
			this.ascOrDesc = this.DESC;
		} else {
			this.ascOrDesc = this.ASC;
		}
	}

	public String getAscOrDesc() {
		return this.ascOrDesc;
	}
}
