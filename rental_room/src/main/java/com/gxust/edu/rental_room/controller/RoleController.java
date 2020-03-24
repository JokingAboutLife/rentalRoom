package com.gxust.edu.rental_room.controller;

import com.github.pagehelper.PageInfo;
import com.gxust.edu.rental_room.domain.Role;
import com.gxust.edu.rental_room.query.RoleQuery;
import com.gxust.edu.rental_room.service.impl.RoleServiceImpl;
import com.gxust.edu.rental_room.response.Result;
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
    public Result addRole(Role role) {
        Result jsonModel = new Result();
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
    public Result deleteRole(String id) {
        Result jsonModel = new Result();
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
    public Result update(Role role) {
        Result jsonModel = new Result();
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
    public Result findById(Integer id) {
        Result result = new Result();
        Role role = roleService.findById(id);
        if (role != null) {
            result.setMsg("查找ID成功");
            result.setSuccess(true);
            result.setData(role);
        } else {
            result.setMsg("查找ID失败");
            result.setSuccess(false);
        }
        return result;
    }

    @RequestMapping(value = "/findByQuery", method = RequestMethod.GET)
    @ResponseBody
    public Result findByQuery(RoleQuery roleQuery) {
        Result result = new Result();
        PageInfo<Role> pageInfo = roleService.findByQuery(roleQuery);
        List<Role> roleList = pageInfo.getList();
        if (roleList != null && roleList.size() >= 0) {
            result.setMsg("查找成功");
            result.setSuccess(true);
            result.setData(pageInfo);
        } else {
            result.setMsg("查找失败");
            result.setSuccess(false);
        }
        return result;
    }

    @RequestMapping(value = "/findRoleByUserId", method = RequestMethod.GET)
    @ResponseBody
    public Result findRoleByUserId(Integer userId) {
        Result result = new Result();
        List<Role> roleList = roleService.findRoleByUserId(userId);
        if (roleList != null && roleList.size() >= 0) {
            result.setMsg("查找角色成功");
            result.setSuccess(true);
            result.setData(roleList);
        } else {
            result.setMsg("查找角色失败");
            result.setSuccess(false);
        }
        return result;
    }

    @RequestMapping(value = "/setPermissions",method = RequestMethod.POST)
    @ResponseBody
    public Result setPermission(Integer roleId, String permissionIdsStr) {
        Result result = new Result();
        try {
            roleService.setPermissions(roleId, permissionIdsStr);
            result.setSuccess(true);
            result.setMsg("分配权限成功！");
        } catch (Exception e) {
            result.setSuccess(false);
            result.setMsg("分配角色失败！");
        }
        return result;
    }
}
