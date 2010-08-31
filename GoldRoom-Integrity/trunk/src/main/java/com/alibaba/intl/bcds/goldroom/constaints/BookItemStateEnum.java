package com.alibaba.intl.bcds.goldroom.constaints;

public enum BookItemStateEnum {
    /** 空闲 */
    IDLE("idle"),
    /** 不可�?-下架 */
    UNAVAILABLE("unavailable"),

    /** 已被�?*/
    LENDED("lended"),

    /** 已被预约 */
    RESERVATED("reservated");

    private String state;

    BookItemStateEnum(String state) {
        this.state = state;
    }

    public String getValue() {
        return state;
    }

    public boolean equalsState(String state) {
        return this.getValue().equals(state);
    }

}
