package com.alibaba.intl.goldroom.constaints;

public enum MemberEnableEnum {

    NEW(0, "new"), APPROVE(1, "approve"), TBD(2, "tbd");

    private Integer value;

    private String  name;

    private MemberEnableEnum(Integer value, String name) {
        this.value = value;
        this.name = name;
    }

    public Integer getValue() {
        return this.value;
    }

    public String getName() {
        return this.name;
    }
}
