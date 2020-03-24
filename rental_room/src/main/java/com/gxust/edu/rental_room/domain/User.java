package com.gxust.edu.rental_room.domain;

import lombok.Data;

import java.io.Serializable;

@Data
public class User extends BaseDomain implements Serializable {

    private static final long serialVersionUID = 507680604309224348L;

    private String loginName;   //账号
    private String username;    //用户名
    private String password;    //密码
    private String realName;    //真实姓名
    private String idcard;      //身份证号
    private String phone;       //手机号
    private String email;       //邮箱
    private boolean status;     //激活状态
}
