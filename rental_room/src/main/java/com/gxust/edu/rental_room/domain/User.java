package com.gxust.edu.rental_room.domain;

import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;

@Data
public class User extends BaseDomain implements Serializable {

    private static final long serialVersionUID = 507680604309224348L;

    @NotNull
    @NotBlank(message = "账号不能为空")
    private String loginName;   //账号

    private String username;    //用户名

    @NotNull
    @NotBlank(message = "密码不能为空")
    @Size(min = 6,max = 15,message = "密码最少6位，最多15位")
    private String password;    //密码

    @NotNull
    @NotBlank(message = "真实姓名不能为空")
    private String realName;    //真实姓名

    @NotNull
    @NotBlank(message = "身份证号不能为空")
    private String idcard;      //身份证号

    private String phone;       //手机号

    @Email(message = "邮箱格式错误")
    private String email;       //邮箱

    private boolean status;     //激活状态
}
