package com.gxust.edu.rental_room.domain;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class Permission extends BaseDomain implements Serializable {

    private static final long serialVersionUID = 3156033048658263359L;

    private String name;                //权限名
    private Integer parentId;           //父类权限id
    private String url;                 //路由地址
    private Integer levels;             //
    private Integer state;              //
    private Integer sorts;              //排序序号
    private String description;         //描述
    private String componentName;       //组件名称
    private String componentPath;       //组件路由
    private String icon;                //图标
    private Integer types;              //类型

    private List<Permission> children = new ArrayList<>();      //子类

}
