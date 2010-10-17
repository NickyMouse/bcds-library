package com.alibaba.intl.bcds.goldroom.constaints;

public enum ReservationStateEnum {
	/** 空闲 */
	REJECT("reject"),
	/** 不可借-下架 */
	TO_BE_CONFIRM("toBeConfirm");

	private String state;

	ReservationStateEnum(String state) {
		this.state = state;
	}

	public String getValue() {
		return state;
	}

	public boolean equalsState(String state) {
		return this.getValue().equals(state);
	}

	public static boolean isValidState(String state) {
		if (REJECT.getValue().equals(state)
				|| TO_BE_CONFIRM.getValue().equals(state)) {
			return true;
		} else {
			return false;
		}
	}
}
