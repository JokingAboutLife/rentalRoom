package com.gxust.edu.rental_room.domain;

import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.Pattern;
import java.io.Serializable;
import java.util.Date;

@Getter
@Setter
public class House extends BaseDomain implements Serializable {

    private static final long serialVersionUID = 6876101360261469456L;

    private Integer userId;         //房主id
    private String title;           //标题
    private String titleImg;        //标题图片
    private String city;            //城市
    private String type;            //类型
    private String orientation;     //房屋朝向
    private String address;         //详细地址
    private String rentWay;         //租赁方式
    private String sexLimit;        //性别限制
    private String area;            //面积
    private Integer price;          //价格
    private String descImg;         //详情图片
    private String contacts;        //联系人

    @Pattern(regexp = "/^[1]([3-9])[0-9]{9}$/",message = "手机号格式错误")
    private String phone;           //手机号
    private Boolean rentalStatus;      //发布状态
    private Boolean status;            //审核状态
    private String desc;            //描述

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date releaseTime;       //发布时间

}