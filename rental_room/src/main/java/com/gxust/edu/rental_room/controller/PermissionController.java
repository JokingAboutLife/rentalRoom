package com.gxust.edu.rental_room.controller;

import com.github.pagehelper.PageInfo;
import com.gxust.edu.rental_room.domain.Permission;
import com.gxust.edu.rental_room.query.PermissionQuery;
import com.gxust.edu.rental_room.service.impl.PermissionServiceImpl;
import com.gxust.edu.rental_room.utils.JsonModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/permission")
public class PermissionController {

    @Autowired
    PermissionServiceImpl permissionService;

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    @ResponseBody
    public JsonModel addPermission(Permission permission) {
        JsonModel jsonModel = new JsonModel();
        boolean result = permissionService.add(permission);
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
    public JsonModel deletePermission(String id) {
        JsonModel jsonModel = new JsonModel();
        String[] idsStr = id.split(",");
        int[] ids = new int[idsStr.length];
        for (int i = 0; i < idsStr.length; i++) {
            ids[i] = Integer.parseInt(idsStr[i]);
        }
        boolean result = permissionService.deleteByIds(ids);
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
    public JsonModel update(Permission permission) {
        JsonModel jsonModel = new JsonModel();
        boolean result = permissionService.update(permission);
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
        Permission permission = permissionService.findById(id);
        if (permission != null) {
            jsonModel.setMsg("根据ID查找成功");
            jsonModel.setSuccess(true);
            jsonModel.setData(permission);
        } else {
            jsonModel.setMsg("根据ID查找失败");
            jsonModel.setSuccess(false);
        }
        return jsonModel;
    }

    @RequestMapping(value = "/findByQuery", method = RequestMethod.GET)
    @ResponseBody
    public JsonModel findByQuery(PermissionQuery permissionQuery) {
        JsonModel jsonModel = new JsonModel();
        PageInfo<Permission> pageInfo = permissionService.findByQuery(permissionQuery);
        List<Permission> permissionList = pageInfo.getList();
        if (permissionList != null && permissionList.size() >= 0) {
            jsonModel.setMsg("查找成功");
            jsonModel.setSuccess(true);
            jsonModel.setData(permissionList);
        } else {
            jsonModel.setMsg("查找失败");
            jsonModel.setSuccess(false);
        }
        return jsonModel;
    }

    @RequestMapping(value = "/findLevelMenu", method = RequestMethod.GET)
    @ResponseBody
    public JsonModel findLevelMenu(Integer userId) {
        JsonModel jsonModel = new JsonModel();
        List<Permission> levelMenu = permissionService.findAllPermission(userId,null);
        if (levelMenu != null && levelMenu.size() >= 0) {
            jsonModel.setSuccess(true);
            jsonModel.setMsg("菜单查询成功");
            jsonModel.setData(levelMenu);
        } else {
            jsonModel.setSuccess(false);
            jsonModel.setMsg("菜单查询失败");
        }
        return jsonModel;
    }

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    @ResponseBody
    public JsonModel findAllPermission() {
        JsonModel jsonModel = new JsonModel();
        List<Permission> allPermission = permissionService.findAllPermission(null,null);
        if (allPermission != null && allPermission.size() >= 0) {
            jsonModel.setSuccess(true);
            jsonModel.setMsg("权限查找成功！");
            jsonModel.setData(allPermission);
        } else {
            jsonModel.setSuccess(false);
            jsonModel.setMsg("权限查询失败！");
        }
        return jsonModel;
    }

    @RequestMapping(value = "/findByRole",method = RequestMethod.GET)
    @ResponseBody
    public JsonModel findPermissionByRoleId(Integer roleId){
        JsonModel jsonModel = new JsonModel();
        List<Permission> roleOfPermission = permissionService.findAllPermission(null, roleId);
        if(roleOfPermission != null && roleOfPermission.size() >= 0){
            jsonModel.setSuccess(true);
            jsonModel.setMsg("根据角色查找权限成功！");
            jsonModel.setData(roleOfPermission);
        }else {
            jsonModel.setSuccess(false);
            jsonModel.setMsg("根据角色查找权限失败！");
        }
        return jsonModel;
    }
}
