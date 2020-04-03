package com.gxust.edu.rental_room.response;


public enum ResultEnum {
    //这里是可以自己定义的，方便与前端交互即可
    UNKNOWN_ERROR(-10,"未知错误"),
    COMMENT_ERROR(-20,"普通错误"),
    SERVE_ERROR(-30,"抱歉，系统繁忙,请稍后重试！"),
    UNAUTHENTICATED(-40,"您还未登录"),
    UNAUTHORIZED(-50,"权限不足"),
    PARAM_ERROR(-60,"参数错误"),
    TYPE_TRANSFORM_ERROR(-70,"类型转换错误"),
    DATA_IS_NULL(-80,"数据为空"),
    SUCCESS(2000,"成功"),

    //角色模块
    ROLE_ADD_ERRO(5001,"角色添加失败"),
    ROLE_DELETE_ERRO(5002,"角色删除失败"),
    ROLE_UPDATE_ERRO(5003,"角色更新失败"),
    ROLE_NOT_FIND(5004,"查询不到该角色"),
    ROLE_IS_NULL(5005,"角色查询失败"),
    ROLE_FIND_FAIL(5006,"找不到角色"),
    ROLE_SET_PERMISSION_FAIL(5007,"角色设置权限失败"),
    ROLE_NOT_DELETE(5008,"该角色不能删除"),


    //菜单权限模块
    PERMISSION_ADD_ERRO(4001,"权限添加失败"),
    PERMISSION_DELETE_ERRO(4002,"权限删除失败"),
    PERMISSION_UPDATE_ERRO(4003,"权限更新失败"),
    PERMISSION_NOT_FIND(4004,"查询不到该权限"),
    PERMISSION_IS_NULL(4004,"权限查询失败"),
    PERMISSION_NOT_FIND_BY_ROLE(4005,"根据角色ID查找权限树失败"),
    MENU_FIND_IS_NULL(4006,"菜单查询失败"),
    PERMISSION_NOT_ALLOW(4007,"未授权不允许访问"),


    //用户模块
    USER_NOT_EXIST(1001,"用户不存在"),
    ACCOUNT_IS_EXISTS(1002,"账号已存在"),
    ACCOUNT_NOT_NULL(1012,"账号不能为空"),
    PASSWORD_IS_ERRO(1003,"密码错误"),
    ACCOUNT_IS_FREEZE(1004,"账号已冻结，请联系管理员"),
    USER_ADD_ERRO(1005,"用户添加失败"),
    USER_REGISTER_ERRO(1012,"用户注册失败"),
    USER_DELETE_ERRO(1006,"用户删除失败"),
    USER_UPDATE_ERRO(1007,"用户更新失败"),
    USER_NOT_FIND(1008,"查询不到该用户"),
    USER_IS_NULL(1009,"查询不到用户"),
    USER_STATUS_UPDATE_FAIL(1010,"用户状态更新失败"),
    USER_SET_ROLE_FAIL(1011,"分配用户角色失败"),


    //房屋模块
    HOUSE_ADD_ERRO(3001,"房屋添加失败"),
    HOUSE_DELETE_ERRO(3002,"房屋删除失败"),
    HOUSE_UPDATE_ERRO(3003,"房屋更新失败"),
    HOUSE_FIND_IS_NULL(3004,"查询不到房屋"),
    HOUSE_RENTAL_IS_NULL(3005,"查询不到正在出租的房屋"),
    HOUSE_UPDATE_STATUS_FAIL(3006,"房屋审核状态修改失败"),
    HOUSE_RENTAL_YZ_FAIL(3007,"预租房屋失败"),
    HOUSE_RENTAL_YZ_EXISTS(3008,"您已经预租该房屋"),
    HOUSE_CANCEL_YZ_EXISTS(3009,"取消预租房屋失败"),
    HOUSE_NOT_RENT_SELF(3010,"您不能租赁自己的房屋"),
    HOUSE_YZ_TIME_IS_NULL(3011,"房屋预租日期不能为空"),
    HOUSE_RENTAL_FAIL(3012,"房屋租赁失败"),


    //字典模块
    DICT_FIND_FAIL(4001,"查询字典失败"),
    DICT_ADD_ERROR(4002,"字典添加失败"),
    DICT_DELETE_FAIL(4003,"字典删除失败"),
    DICT_UPDATE_FAIL(4004,"字典更新失败"),


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
