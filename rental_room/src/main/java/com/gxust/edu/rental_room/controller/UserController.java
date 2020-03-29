package com.gxust.edu.rental_room.controller;

import com.github.pagehelper.PageInfo;
import com.github.pagehelper.util.StringUtil;
import com.gxust.edu.rental_room.RentalRoomApplication;
import com.gxust.edu.rental_room.domain.User;
import com.gxust.edu.rental_room.query.UserQuery;
import com.gxust.edu.rental_room.response.Result;
import com.gxust.edu.rental_room.response.ResultEnum;
import com.gxust.edu.rental_room.service.UserService;
import com.gxust.edu.rental_room.utils.ResultUtil;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    /*@RequestMapping(value = "/login", method = RequestMethod.POST)
    @ResponseBody
    public Result login(String loginName, String password) {
        User user = userService.findByLoginName(loginName);
        password = new Md5Hash(password,loginName,3).toString();
        if (user == null) {
            return ResultUtil.error(ResultEnum.USER_NOT_EXIST.getCode(), ResultEnum.USER_NOT_EXIST.getMsg());
        }
        if (!password.equals(user.getPassword())) {
            return ResultUtil.error(ResultEnum.PASSWORD_IS_ERRO.getCode(), ResultEnum.PASSWORD_IS_ERRO.getMsg());
        }
        boolean status = user.isStatus();
        if (!status) {
            return ResultUtil.error(ResultEnum.ACCOUNT_IS_FREEZE.getCode(), ResultEnum.ACCOUNT_IS_FREEZE.getMsg());
        }
        return ResultUtil.success(user);
    }*/

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    @ResponseBody
    public Result addUser(User user, Integer roleId) {
        boolean result = userService.addUser(user, roleId);
        if (!result) {
            return ResultUtil.error(ResultEnum.USER_ADD_ERRO);
        }
        return ResultUtil.success();
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    @ResponseBody
    public Result register(User user) {
        boolean result = userService.add(user);
        if (!result) {
            return ResultUtil.error(ResultEnum.USER_REGISTER_ERRO);
        }
        return ResultUtil.success();
    }


    @RequiresPermissions("user:delete")
    @RequestMapping(value = "/delete", method = RequestMethod.GET)
    @ResponseBody
    public Result deleteUser(String id) {
        String[] idsStr = id.split(",");
        int[] ids = new int[idsStr.length];
        for (int i = 0; i < idsStr.length; i++) {
            ids[i] = Integer.parseInt(idsStr[i]);
        }
        boolean result = userService.deleteByIds(ids);
        if (!result) {
            return ResultUtil.error(ResultEnum.USER_DELETE_ERRO);
        }
        return ResultUtil.success();
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    @ResponseBody
    public Result update(User user) {
        boolean result = userService.update(user);
        if (!result) {
            return ResultUtil.error(ResultEnum.USER_UPDATE_ERRO);
        }
        return ResultUtil.success();
    }

    @RequestMapping(value = "/update/status", method = RequestMethod.POST)
    @ResponseBody
    public Result updateStatus(Boolean status, Integer id) {
        boolean result = userService.updateStatus(status, id);
        if (!result) {
            return ResultUtil.error(ResultEnum.USER_STATUS_UPDATE_FAIL);
        }
        return ResultUtil.success();
    }

    @RequestMapping(value = "/findById", method = RequestMethod.GET)
    @ResponseBody
    public Result findById(Integer id) {
        User user = userService.findById(id);
        if (user == null) {
            return ResultUtil.error(ResultEnum.USER_NOT_FIND);
        }
        return ResultUtil.success(user);
    }

    @RequestMapping(value = "/findByQuery", method = RequestMethod.GET)
    @ResponseBody
    public Result findByQuery(UserQuery userQuery) {
        PageInfo<User> pageInfo = userService.findByQuery(userQuery);
        List<User> userList = pageInfo.getList();
        if (userList == null) {
            return ResultUtil.error(ResultEnum.USER_IS_NULL);
        }
        return ResultUtil.success(pageInfo);
    }

    @RequestMapping(value = "/check/loginName", method = RequestMethod.GET)
    @ResponseBody
    public Result checkLoginName(String loginName, Integer id) {
        if (StringUtil.isEmpty(loginName)) {
            return ResultUtil.error(ResultEnum.ACCOUNT_NOT_NULL);
        }
        int count = userService.findCountByLoginName(loginName, id);
        if (count > 0) {
            return ResultUtil.error(ResultEnum.ACCOUNT_IS_EXISTS);
        } else {
            return ResultUtil.success();
        }
    }

    @RequestMapping(value = "/setRole", method = RequestMethod.POST)
    @ResponseBody
    public Result setRole(Integer userId, Integer roleId, boolean isNew) {
        boolean result = userService.setRole(userId, roleId, isNew);
        if (!result) {
            return ResultUtil.error(ResultEnum.USER_SET_ROLE_FAIL);
        }
        return ResultUtil.success();
    }

}
