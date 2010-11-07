package com.alibaba.intl.bcds.goldroom.constaints;

public enum BookItemStateEnum {
    /** 空闲 */
    IDLE("idle"),
    /** 不可借-下架 */
    UNAVAILABLE("unavailable"),

    /** 已被借 */
    LENDED("lended"),

    /** 已被预约 */
    RESERVATED("reservated"),

    /** 电子书 */
    EBOOK("ebook");

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

    public static boolean isValidState(String state) {
        if (IDLE.getValue().equals(state) || UNAVAILABLE.getValue().equals(state) || LENDED.getValue().equals(state)
            || RESERVATED.getValue().equals(state)) {
            return true;
        } else {
            return false;
        }

    }
}
