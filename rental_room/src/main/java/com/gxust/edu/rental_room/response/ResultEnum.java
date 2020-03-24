package com.gxust.edu.rental_room.response;


public enum ResultEnum {
    //这里是可以自己定义的，方便与前端交互即可
    UNKNOWN_ERROR(-1,"未知错误"),
    SUCCESS(2000,"成功"),

    //角色模块

    //权限模块
    PERMISSION_ADD_ERRO(4001,"权限添加失败"),
    PERMISSION_DELETE_ERRO(4002,"权限删除失败"),
    PERMISSION_UPDATE_ERRO(4003,"权限更新失败"),
    PERMISSION_NOT_FIND(4004,"查询不到该权限"),
    PERMISSION_IS_NULL(4004,"权限查询失败"),
    PERMISSION_NOT_FIND_BY_ROLE(4005,"根据角色ID查找权限树失败"),
    MENU_FIND_IS_NULL(4005,"菜单查询失败"),


    //用户模块
    USER_NOT_EXIST(1001,"用户不存在"),
    USER_IS_EXISTS(1002,"用户已存在"),
    PASSWORD_IS_ERRO(1003,"密码错误"),
    ACCOUNT_IS_FREEZE(1099,"账号已冻结"),

    //房屋模块
    HOUSE_ADD_ERRO(3001,"房屋添加失败"),
    HOUSE_DELETE_ERRO(3002,"房屋删除失败"),
    HOUSE_UPDATE_ERRO(3003,"房屋更新失败"),
    HOUSE_FIND_IS_NULL(3004,"查询不到房屋"),

    //租赁信息模块


    DATA_IS_NULL(3,"数据为空"),
    ;
    private Integer code;
    private String msg;

    ResultEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public Integer getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}
