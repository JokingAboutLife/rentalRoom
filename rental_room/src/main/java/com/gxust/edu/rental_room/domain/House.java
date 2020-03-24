package com.gxust.edu.rental_room.domain;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class House extends BaseDomain implements Serializable {

    private static final long serialVersionUID = 6876101360261469456L;

    private String title;           //标题
    private String titleImg;        //标题图片
    private String name;            //名字
    private String type;            //类型
    private String address;         //详细地址
    private String rentWay;         //出租方式
    private String city;            //城市
    private String sexLimit;        //性别限制
    private String area;            //面积
    private Integer price;          //价格
    private String descImg;         //详情图片
    private String contacts;        //联系人
    private String phone;           //手机号
    private Byte rentalStatus;      //发布状态
    private Byte status;            //审核状态
    private String desc;            //描述
    private Date releaseTime;       //发布时间

}