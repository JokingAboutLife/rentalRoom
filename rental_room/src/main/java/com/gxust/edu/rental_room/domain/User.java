package com.gxust.edu.rental_room.domain;

import lombok.Getter;
import lombok.Setter;
import org.crazycake.shiro.AuthCachePrincipal;

import javax.validation.constraints.*;
import java.io.Serializable;

@Getter
@Setter
public class User extends BaseDomain implements Serializable, AuthCachePrincipal {

    private static final long serialVersionUID = 507680604309224348L;

    @NotNull
    @NotBlank(message = "账号不能为空")
    private String loginName;   //账号

    private String username;    //用户名

    @NotNull
    @NotBlank(message = "密码不能为空")
    @Pattern(regexp = "^[a-zA-Z]\\w{5,17}$",message = "密码以字母开头，长度在6~18之间，只能包含字符、数字和下划线")
    private String password;    //密码

    @NotNull
    @NotBlank(message = "真实姓名不能为空")
    @Pattern(regexp = "^[\\u4e00-\\u9fa5]{0,}$",message = "真实姓名只能输入汉字")
    private String realName;    //真实姓名

    @NotNull
    @NotBlank(message = "身份证号不能为空")
    @Pattern(regexp = "^\\d{15}|\\d{18}$",message = "身份证号格式错误")
    private String idcard;      //身份证号

//    @Pattern(regexp = "/^[1]([3-9])[0-9]{9}$/",message = "手机号格式错误")
    private String phone;       //手机号

    @Email(message = "邮箱格式错误")
    private String email;       //邮箱

    private boolean status;     //激活状态

    @Override
    public String getAuthCacheKey() {
        return null;
    }
}
