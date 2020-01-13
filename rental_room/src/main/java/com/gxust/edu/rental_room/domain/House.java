package com.gxust.edu.rental_room.domain;

import java.io.Serializable;

/**
 * @author tools.49db.cn
 * @version 1.0
 * @date 2020-01-13
 */
public class House extends BaseDomain implements Serializable {
    /**
     * 标题
     */
    private String title;

    /**
     * 房屋标题图片路径
     */
    private String titleImg;

    /**
     * 房屋名称
     */
    private String name;

    /**
     * 房屋类型
     */
    private String type;

    /**
     * 详细地址
     */
    private String address;

    /**
     * 出租方式
     */
    private String rentWay;

    /**
     * 城市
     */
    private String city;

    /**
     * 性别限制
     */
    private String sexLimit;

    /**
     * 房屋面积
     */
    private String area;

    /**
     * 所在楼层
     */
    private String storey;

    /**
     * 楼层总数
     */
    private String storeySum;

    /**
     * 楼栋号
     */
    private String buildingId;

    /**
     * 单元号
     */
    private String cellId;

    /**
     * 房间号
     */
    private String roomId;

    /**
     * 租金
     */
    private Integer price;

    /**
     * 房屋描述图片路径
     */
    private String textImg;

    /**
     * 联系人
     */
    private String contacts;

    /**
     * 联系电话
     */
    private String phone;

    /**
     * 房主ID
     */
    private Integer userId;

    /**
     * 审核状态
     */
    private Byte status;

    /**
     * 描述
     */
    private String text;

    private static final long serialVersionUID = 1L;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitleImg() {
        return titleImg;
    }

    public void setTitleImg(String titleImg) {
        this.titleImg = titleImg;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getRentWay() {
        return rentWay;
    }

    public void setRentWay(String rentWay) {
        this.rentWay = rentWay;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getSexLimit() {
        return sexLimit;
    }

    public void setSexLimit(String sexLimit) {
        this.sexLimit = sexLimit;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getStorey() {
        return storey;
    }

    public void setStorey(String storey) {
        this.storey = storey;
    }

    public String getStoreySum() {
        return storeySum;
    }

    public void setStoreySum(String storeySum) {
        this.storeySum = storeySum;
    }

    public String getBuildingId() {
        return buildingId;
    }

    public void setBuildingId(String buildingId) {
        this.buildingId = buildingId;
    }

    public String getCellId() {
        return cellId;
    }

    public void setCellId(String cellId) {
        this.cellId = cellId;
    }

    public String getRoomId() {
        return roomId;
    }

    public void setRoomId(String roomId) {
        this.roomId = roomId;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public String getTextImg() {
        return textImg;
    }

    public void setTextImg(String textImg) {
        this.textImg = textImg;
    }

    public String getContacts() {
        return contacts;
    }

    public void setContacts(String contacts) {
        this.contacts = contacts;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Byte getStatus() {
        return status;
    }

    public void setStatus(Byte status) {
        this.status = status;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}