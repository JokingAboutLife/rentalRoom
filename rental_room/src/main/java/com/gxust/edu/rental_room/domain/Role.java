package com.gxust.edu.rental_room.domain;

public class Role extends BaseDomain {
    private String name;            //角色名称
    private String description;     //角色描述

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
