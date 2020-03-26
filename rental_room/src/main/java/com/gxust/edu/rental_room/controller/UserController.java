package com.gxust.edu.rental_room.controller;

import com.github.pagehelper.PageInfo;
import com.github.pagehelper.util.StringUtil;
import com.gxust.edu.rental_room.domain.User;
import com.gxust.edu.rental_room.query.UserQuery;
import com.gxust.edu.rental_room.response.Result;
import com.gxust.edu.rental_room.response.ResultEnum;
import com.gxust.edu.rental_room.service.impl.UserServiceImpl;
import com.gxust.edu.rental_room.utils.ResultUtil;
import com.gxust.edu.rental_room.vo.AuthInfo;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.apache.shiro.subject.Subject;
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
    UserServiceImpl userService;

   /* //用户登录
    @RequestMapping(value="/login",method = RequestMethod.POST)
    @ResponseBody
    public Result login(String loginName,String password) {
        //构造登录令牌
        try {
            password = new Md5Hash(password,loginName,3).toString();
            UsernamePasswordToken upToken = new UsernamePasswordToken(loginName,password);
            //1.获取subject
            Subject subject = SecurityUtils.getSubject();
            //获取session
            String sid = (String) subject.getSession().getId();
            //2.调用subject进行登录
            subject.login(upToken);
            User user = (User) subject.getPrincipals().getPrimaryPrincipal();
            AuthInfo authInfo = new AuthInfo();
            authInfo.setUser(user);
            authInfo.setToken(sid);
            return ResultUtil.success(authInfo);
        }catch (Exception e) {
            return ResultUtil.error(ResultEnum.USER_NOT_EXIST.getCode(),ResultEnum.USER_NOT_EXIST.getMsg());
        }
    }*/

    @RequestMapping(value = "/login", method = RequestMethod.POST)
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
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    @ResponseBody
    public Result addUser(User user, Integer roleId) {
        boolean result = userService.addUser(user, roleId);
        if (!result) {
            return ResultUtil.error(ResultEnum.USER_ADD_ERRO.getCode(), ResultEnum.USER_ADD_ERRO.getMsg());
        }
        return ResultUtil.success();
    }

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
            return ResultUtil.error(ResultEnum.USER_DELETE_ERRO.getCode(), ResultEnum.USER_DELETE_ERRO.getMsg());
        }
        return ResultUtil.success();
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    @ResponseBody
    public Result update(User user) {
        boolean result = userService.update(user);
        if (!result) {
            return ResultUtil.error(ResultEnum.USER_UPDATE_ERRO.getCode(), ResultEnum.USER_UPDATE_ERRO.getMsg());
        }
        return ResultUtil.success();
    }

    @RequestMapping(value = "/update/status", method = RequestMethod.POST)
    @ResponseBody
    public Result updateStatus(Boolean status, Integer id) {
        boolean result = userService.updateStatus(status, id);
        if (!result) {
            return ResultUtil.error(ResultEnum.USER_STATUS_UPDATE_FAIL.getCode(), ResultEnum.USER_STATUS_UPDATE_FAIL.getMsg());
        }
        return ResultUtil.success();
    }

    @RequestMapping(value = "/findById", method = RequestMethod.GET)
    @ResponseBody
    public Result findById(Integer id) {
        User user = userService.findById(id);
        if (user == null) {
            return ResultUtil.error(ResultEnum.USER_NOT_FIND.getCode(), ResultEnum.USER_NOT_FIND.getMsg());
        }
        return ResultUtil.success(user);
    }

    @RequestMapping(value = "/findByQuery", method = RequestMethod.GET)
    @ResponseBody
    public Result findByQuery(UserQuery userQuery) {
        PageInfo<User> pageInfo = userService.findByQuery(userQuery);
        List<User> userList = pageInfo.getList();
        if (userList == null) {
            return ResultUtil.error(ResultEnum.USER_IS_NULL.getCode(), ResultEnum.USER_IS_NULL.getMsg());
        }
        return ResultUtil.success(pageInfo);
    }

    @RequestMapping(value = "/check/loginName", method = RequestMethod.GET)
    @ResponseBody
    public Map<String, Boolean> checkLoginName(String loginName, Integer id) {
        Map<String, Boolean> result = new HashMap<>();
        if (StringUtil.isEmpty(loginName)) {
            result.put("valid", false);
            return result;
        }
        int count = userService.findCountByLoginName(loginName, id);
        if (count > 0) {
            result.put("valid", false);
        } else {
            result.put("valid", true);
        }
        return result;
    }

    @RequestMapping(value = "/setRole", method = RequestMethod.POST)
    @ResponseBody
    public Result setRole(Integer userId, Integer roleId, boolean isNew) {
        boolean result = userService.setRole(userId, roleId, isNew);
        if (!result) {
            return ResultUtil.error(ResultEnum.USER_SET_ROLE_FAIL.getCode(), ResultEnum.USER_SET_ROLE_FAIL.getMsg());
        }
        return ResultUtil.success();
    }


}
