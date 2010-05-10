package com.alibaba.intl.goldroom.constaints;

import java.util.HashMap;
import java.util.Map;

public enum RoleEnum {
    ROLE_ADMIN("ROLE_ADMIN", "ROLE_ADMIN", 1), ROLE_USER("ROLE_USER", "ROLE_USER", 2);

    private String                        name;

    private String                        description;

    private Integer                       id;

    private static Map<Integer, RoleEnum> map;

    private RoleEnum(String name, String description, Integer id) {
        this.name = name;
        this.description = description;
        this.id = id;
    }

    static {
        init();
    }

    public String getName() {
        return this.name;
    }

    private static void init() {
        map = new HashMap<Integer, RoleEnum>();
        for (RoleEnum role : RoleEnum.values()) {
            map.put(role.getId(), role);
        }
    }

    public String getDescription() {
        return this.description;
    }

    public Integer getId() {
        return this.id;
    }

    public static RoleEnum getRoleById(Integer id) {
        return map.get(id);
    }
}
