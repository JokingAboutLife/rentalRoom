package com.gxust.edu.rental_room.domain;

import lombok.Data;

import java.io.Serializable;

@Data
public class Role extends BaseDomain implements Serializable {

    private static final long serialVersionUID = 8713989055652702826L;

    private String name;            //角色名称
    private String description;     //角色描述
}
