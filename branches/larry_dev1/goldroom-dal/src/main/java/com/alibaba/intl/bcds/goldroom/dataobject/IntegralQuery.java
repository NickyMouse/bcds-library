package com.alibaba.intl.bcds.goldroom.dataobject;

public class IntegralQuery extends Integral {

	private long alterValue = 0;
	
	public IntegralQuery() {
	}
	
	public IntegralQuery(Integral integral) {
		if(null != integral) {
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
}
