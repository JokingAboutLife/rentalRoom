package com.gxust.edu.rental_room.controller;

import com.github.pagehelper.PageInfo;
import com.gxust.edu.rental_room.domain.Role;
import com.gxust.edu.rental_room.query.RoleQuery;
import com.gxust.edu.rental_room.service.impl.RoleServiceImpl;
import com.gxust.edu.rental_room.utils.JsonModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/roles")
public class RoleController {

    @Autowired
    RoleServiceImpl roleService;

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    @ResponseBody
    public JsonModel addRole(Role role) {
        JsonModel jsonModel = new JsonModel();
        boolean result = roleService.add(role);
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
    public JsonModel deleteRole(String id) {
        JsonModel jsonModel = new JsonModel();
        String[] idsStr = id.split(",");
        int[] ids = new int[idsStr.length];
        for (int i = 0; i < idsStr.length; i++) {
            ids[i] = Integer.parseInt(idsStr[i]);
        }
        boolean result = roleService.deleteByIds(ids);
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
    public JsonModel update(Role role) {
        JsonModel jsonModel = new JsonModel();
        boolean result = roleService.update(role);
        if (result) {
            jsonModel.setMsg("更新成功");
            jsonModel.setSuccess(true);
        } else {
            jsonModel.setMsg("更新失败");
            jsonModel.setSuccess(false);
        }
        return jsonModel;
    }

    @RequestMapping(value = "/findById", method = RequestMethod.GET)
    @ResponseBody
    public JsonModel findById(Integer id) {
        JsonModel jsonModel = new JsonModel();
        Role role = roleService.findById(id);
        if (role != null) {
            jsonModel.setMsg("查找ID成功");
            jsonModel.setSuccess(true);
            jsonModel.setData(role);
        } else {
            jsonModel.setMsg("查找ID失败");
            jsonModel.setSuccess(false);
        }
        return jsonModel;
    }

    @RequestMapping(value = "/findByQuery", method = RequestMethod.GET)
    @ResponseBody
    public JsonModel findByQuery(RoleQuery roleQuery) {
        JsonModel jsonModel = new JsonModel();
        PageInfo<Role> pageInfo = roleService.findByQuery(roleQuery);
        List<Role> roleList = pageInfo.getList();
        if (roleList != null && roleList.size() >= 0) {
            jsonModel.setMsg("查找成功");
            jsonModel.setSuccess(true);
            jsonModel.setData(roleList);
        } else {
            jsonModel.setMsg("查找失败");
            jsonModel.setSuccess(false);
        }
        return jsonModel;
    }
}
