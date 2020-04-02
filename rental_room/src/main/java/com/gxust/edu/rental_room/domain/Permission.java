package com.gxust.edu.rental_room.domain;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class Permission extends BaseDomain implements Serializable {

    private static final long serialVersionUID = 3156033048658263359L;

    @NotNull
    @NotBlank(message = "权限名称不能为空")
    private String name;                //权限名

    private Integer parentId;           //父类权限id
    private String url;                 //路由地址
    private Integer sorts;              //排序序号
    private String description;         //描述
    private String perms;               //权限标识
    private String componentPath;       //组件路由
    private String icon;                //图标

    @NotNull
    @NotBlank(message = "权限类别不能为空")
    private Integer types;              //类型

    private List<Permission> children = new ArrayList<>();      //子类

}
