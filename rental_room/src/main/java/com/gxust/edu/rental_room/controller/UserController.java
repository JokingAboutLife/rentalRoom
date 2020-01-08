package com.gxust.edu.rental_room.controller;

import com.gxust.edu.rental_room.domain.User;
import com.gxust.edu.rental_room.query.UserQuery;
import com.gxust.edu.rental_room.service.impl.UserServiceImpl;
import com.gxust.edu.rental_room.utils.JsonModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserServiceImpl userService;

    @RequestMapping(value = "/login",method = RequestMethod.POST)
    @ResponseBody
    public JsonModel login(String loginName,String password){
        JsonModel jsonModel = new JsonModel();
        User user = userService.login(loginName, password);
        if (user != null){
            jsonModel.setSuccess(true);
            jsonModel.setMsg("登陆成功！");
            jsonModel.setData(user);
        }else {
            jsonModel.setSuccess(false);
            jsonModel.setMsg("登陆失败，请输入正确的账号密码！");
        }
        return jsonModel;
    }

    @RequestMapping(value = "/add",method = RequestMethod.POST)
    @ResponseBody
    public JsonModel addUser(User user){
        JsonModel jsonModel = new JsonModel();
        boolean result = userService.add(user);
        if(result){
            jsonModel.setMsg("添加成功");
            jsonModel.setSuccess(true);
        }else {
            jsonModel.setMsg("添加失败");
            jsonModel.setSuccess(false);
        }
        return jsonModel;
    }

    @RequestMapping(value = "/delete",method = RequestMethod.GET)
    @ResponseBody
    public JsonModel deleteUser(String id){
        JsonModel jsonModel = new JsonModel();
        String[] idsStr = id.split(",");
        int[] ids = new int[idsStr.length];
        for (int i = 0; i < idsStr.length; i++) {
            ids[i] = Integer.parseInt(idsStr[i]);
        }
        boolean result = userService.deleteByIds(ids);
        if(result){
            jsonModel.setMsg("删除成功");
            jsonModel.setSuccess(true);
        }else {
            jsonModel.setMsg("删除失败");
            jsonModel.setSuccess(false);
        }
        return jsonModel;
    }

    @RequestMapping(value = "/update",method = RequestMethod.POST)
    @ResponseBody
    public JsonModel update(User user){
        JsonModel jsonModel = new JsonModel();
        boolean result = userService.update(user);
        if(result){
            jsonModel.setMsg("更新成功");
            jsonModel.setSuccess(true);
        }else {
            jsonModel.setMsg("更新失败");
            jsonModel.setSuccess(false);
        }
        return jsonModel;
    }

    @RequestMapping(value = "/findById",method = RequestMethod.GET)
    @ResponseBody
    public JsonModel findById(Integer id){
        JsonModel jsonModel = new JsonModel();
        User user = userService.findById(id);
        if(user != null){
            jsonModel.setMsg("根据ID查找成功");
            jsonModel.setSuccess(true);
            jsonModel.setData(user);
        }else {
            jsonModel.setMsg("根据ID查找失败");
            jsonModel.setSuccess(false);
        }
        return jsonModel;
    }

    @RequestMapping(value = "/findByQuery",method = RequestMethod.GET)
    @ResponseBody
    public JsonModel findByQuery(UserQuery userQuery){
        JsonModel jsonModel = new JsonModel();
        List<User> userList = userService.findByQuery(userQuery);
        if(userList != null && userList.size() > 0){
            jsonModel.setMsg("根据ID查找成功");
            jsonModel.setSuccess(true);
            jsonModel.setData(userList);
        }else {
            jsonModel.setMsg("根据ID查找失败");
            jsonModel.setSuccess(false);
        }
        return jsonModel;
    }
}
