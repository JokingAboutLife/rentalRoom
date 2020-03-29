package com.gxust.edu.rental_room.controller;

import com.gxust.edu.rental_room.domain.Permission;
import com.gxust.edu.rental_room.domain.User;
import com.gxust.edu.rental_room.response.Result;
import com.gxust.edu.rental_room.response.ResultEnum;
import com.gxust.edu.rental_room.service.PermissionService;
import com.gxust.edu.rental_room.service.UserService;
import com.gxust.edu.rental_room.service.impl.UserServiceImpl;
import com.gxust.edu.rental_room.utils.ResultUtil;
import com.gxust.edu.rental_room.utils.TreeUtil;
import com.sun.org.apache.regexp.internal.REUtil;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import sun.java2d.pipe.ValidatePipe;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class LoginController {
    @Autowired
    UserService userService;
    @Autowired
    PermissionService permissionService;

    //用户登录
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    @ResponseBody
    public Result login(String loginName, String password) {
        //构造登录令牌
        password = new Md5Hash(password, loginName, 3).toString();
        UsernamePasswordToken upToken = new UsernamePasswordToken(loginName, password);
        //1.获取subject
        Subject subject = SecurityUtils.getSubject();
        //获取session
        String sid = (String) subject.getSession().getId();
        //2.调用subject进行登录
        subject.login(upToken);
        User user = (User) subject.getPrincipals().getPrimaryPrincipal();
        Map<String, Object> map = new HashMap<>();
        map.put("user", user);
        map.put("token", sid);
        return ResultUtil.success(map);
    }

    @RequestMapping(value = "/visitorLogin",method = RequestMethod.POST)
    @ResponseBody
    public Result visitorLogin() {
        return ResultUtil.success();
    }

    @RequestMapping(value = "/findLevelMenu", method = RequestMethod.GET)
    @ResponseBody
    public Result findLevelMenu(Integer userId) {
        List<Permission> FirstMenus = permissionService.selectFirstMenuByUserIdOrRoleId(null, userId);
        List<Permission> permissionList = permissionService.selectLeafByUserIdOrRoleId(null, userId);
        List<Permission> levelMenuTree = TreeUtil.getMenuTree(FirstMenus, permissionList);
        if (levelMenuTree == null && levelMenuTree.size() < 0) {
            return ResultUtil.error(ResultEnum.MENU_FIND_IS_NULL);
        }
        return ResultUtil.success(levelMenuTree);
    }

    @RequestMapping(value = "/visitor/findLevelMenu", method = RequestMethod.POST)
    @ResponseBody
    public Result visitorLevelMenu() {
        List<Permission> FirstMenus = permissionService.selectFirstMenuByUserIdOrRoleId(0,null);
        List<Permission> permissionList = permissionService.selectLeafByUserIdOrRoleId(0,null);
        List<Permission> levelMenuTree = TreeUtil.getMenuTree(FirstMenus, permissionList);
        if (levelMenuTree == null && levelMenuTree.size() < 0) {
            return ResultUtil.error(ResultEnum.MENU_FIND_IS_NULL);
        }
        return ResultUtil.success(levelMenuTree);
    }

    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    @ResponseBody
    public Result logout() {
        Subject subject = SecurityUtils.getSubject();
        subject.logout();
        System.out.println("退出登陆响应数据");
        return ResultUtil.success("退出登陆");
    }

    @RequestMapping(value = "/unauth", method = RequestMethod.GET)
    @ResponseBody
    public Result unauth(int code) {
        System.out.println("未授权响应数据");
        return code == 1? ResultUtil.error(ResultEnum.UNAUTHENTICATED):ResultUtil.error(ResultEnum.UNAUTHORIZED);
    }
}
