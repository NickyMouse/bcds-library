package com.alibaba.intl.goldroom.constaints;


public enum AdminConfigTypeEnum {
    ANNOUNCEMENT("announce");

    private String value;

    private AdminConfigTypeEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return this.value;
    }

}
