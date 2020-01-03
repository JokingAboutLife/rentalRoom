package com.gxust.edu.rental_room.controller;

import com.gxust.edu.rental_room.domain.User;
import com.gxust.edu.rental_room.service.UserService;
import com.gxust.edu.rental_room.service.impl.UserServiceImpl;
import com.gxust.edu.rental_room.utils.JsonModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

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

}
