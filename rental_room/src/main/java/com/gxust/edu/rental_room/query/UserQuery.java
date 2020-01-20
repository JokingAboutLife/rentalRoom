package com.gxust.edu.rental_room.query;

public class UserQuery extends BaseQuery {
    private String loginName;
    private String username;

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
