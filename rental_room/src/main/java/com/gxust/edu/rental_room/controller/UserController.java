package com.gxust.edu.rental_room.controller;

import com.github.pagehelper.PageInfo;
import com.github.pagehelper.util.StringUtil;
import com.gxust.edu.rental_room.domain.User;
import com.gxust.edu.rental_room.query.UserQuery;
import com.gxust.edu.rental_room.service.impl.UserServiceImpl;
import com.gxust.edu.rental_room.utils.JsonModel;
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

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    @ResponseBody
    public JsonModel login(String loginName, String password) {
        JsonModel jsonModel = new JsonModel();
        User user = userService.findByLoginName(loginName);
        if (user == null) {
            jsonModel.setSuccess(false);
            jsonModel.setMsg("用户不存在，请输入正确的账号密码！");
            return jsonModel;
        }
        if (!password.equals(user.getPassword())) {
            jsonModel.setSuccess(false);
            jsonModel.setMsg("密码错误！请输入正确密码！");
            return jsonModel;
        }
        boolean status = user.isStatus();
        if (status) {
            jsonModel.setSuccess(true);
            jsonModel.setMsg("登陆成功！");
            jsonModel.setData(user);
        } else {
            jsonModel.setSuccess(false);
            jsonModel.setMsg("该账号已冻结，请联系管理员");
        }
        return jsonModel;
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    @ResponseBody
    public JsonModel addUser(User user, Integer roleId) {
        JsonModel jsonModel = new JsonModel();
        boolean result = userService.addUser(user, roleId);
        if (result) {
            jsonModel.setMsg("添加成功");
            jsonModel.setSuccess(true);
        } else {
            jsonModel.setMsg("添加失败");
            jsonModel.setSuccess(false);
        }
        return jsonModel;
    }

    @RequestMapping(value = "/delete", method = RequestMethod.GET)
    @ResponseBody
    public JsonModel deleteUser(String id) {
        JsonModel jsonModel = new JsonModel();
        String[] idsStr = id.split(",");
        int[] ids = new int[idsStr.length];
        for (int i = 0; i < idsStr.length; i++) {
            ids[i] = Integer.parseInt(idsStr[i]);
        }
        boolean result = userService.deleteByIds(ids);
        if (result) {
            jsonModel.setMsg("删除成功");
            jsonModel.setSuccess(true);
        } else {
            jsonModel.setMsg("删除失败");
            jsonModel.setSuccess(false);
        }
        return jsonModel;
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    @ResponseBody
    public JsonModel update(User user) {
        JsonModel jsonModel = new JsonModel();
        boolean result = userService.update(user);
        if (result) {
            jsonModel.setMsg("更新成功");
            jsonModel.setSuccess(true);
        } else {
            jsonModel.setMsg("更新失败");
            jsonModel.setSuccess(false);
        }
        return jsonModel;
    }

    @RequestMapping(value = "/update/status", method = RequestMethod.POST)
    @ResponseBody
    public JsonModel updateStatus(Boolean status, Integer id) {
        JsonModel jsonModel = new JsonModel();
        boolean result = userService.updateStatus(status, id);
        if (result) {
            jsonModel.setMsg("更新用户状态成功");
            jsonModel.setSuccess(true);
        } else {
            jsonModel.setMsg("更新用户状态失败");
            jsonModel.setSuccess(false);
        }
        return jsonModel;
    }

    @RequestMapping(value = "/findById", method = RequestMethod.GET)
    @ResponseBody
    public JsonModel findById(Integer id) {
        JsonModel jsonModel = new JsonModel();
        User user = userService.findById(id);
        if (user != null) {
            jsonModel.setMsg("查找ID成功");
            jsonModel.setSuccess(true);
            jsonModel.setData(user);
        } else {
            jsonModel.setMsg("查找ID失败");
            jsonModel.setSuccess(false);
        }
        return jsonModel;
    }

    @RequestMapping(value = "/findByQuery", method = RequestMethod.GET)
    @ResponseBody
    public JsonModel findByQuery(UserQuery userQuery) {
//        throw new KPException(ExceptionKind.PARAM_E,"参数错误");
        JsonModel jsonModel = new JsonModel();
        PageInfo<User> pageInfo = userService.findByQuery(userQuery);
        List<User> userList = pageInfo.getList();
        if (userList != null && userList.size() > 0) {
            jsonModel.setMsg("查找成功");
            jsonModel.setSuccess(true);
            jsonModel.setData(pageInfo);
        } else {
            jsonModel.setMsg("查找失败");
            jsonModel.setSuccess(false);
        }
        return jsonModel;
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
    public JsonModel setRole(Integer userId, Integer roleId, boolean isNew) {
        JsonModel jsonModel = new JsonModel();
        boolean result = userService.setRole(userId, roleId, isNew);
        if (result) {
            jsonModel.setMsg("设置角色成功");
            jsonModel.setSuccess(true);
        } else {
            jsonModel.setMsg("设置角色失败");
            jsonModel.setSuccess(false);
        }
        return jsonModel;
    }


}
