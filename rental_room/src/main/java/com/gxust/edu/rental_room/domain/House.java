package com.gxust.edu.rental_room.domain;

import java.io.Serializable;
import java.util.Date;

public class House extends BaseDomain implements Serializable {
    private String title;
    private String titleImg;
    private String name;
    private String type;
    private String address;
    private String rentWay;
    private String city;
    private String sexLimit;
    private String area;
    private Integer price;
    private String descImg;
    private String contacts;
    private String phone;
    private Integer userId;
    private Byte rentalStatus;
    private Byte status;
    private String desc;
    private Date releaseTime;

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

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public String getDescImg() {
        return descImg;
    }

    public void setDescImg(String descImg) {
        this.descImg = descImg;
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

    public Byte getRentalStatus() {
        return rentalStatus;
    }

    public void setRentalStatus(Byte rentalStatus) {
        this.rentalStatus = rentalStatus;
    }

    public Byte getStatus() {
        return status;
    }

    public void setStatus(Byte status) {
        this.status = status;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public Date getReleaseTime() {
        return releaseTime;
    }

    public void setReleaseTime(Date releaseTime) {
        this.releaseTime = releaseTime;
    }
}