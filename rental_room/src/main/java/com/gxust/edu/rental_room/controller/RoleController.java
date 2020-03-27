package com.gxust.edu.rental_room.controller;

import com.github.pagehelper.PageInfo;
import com.gxust.edu.rental_room.domain.Role;
import com.gxust.edu.rental_room.query.RoleQuery;
import com.gxust.edu.rental_room.response.Result;
import com.gxust.edu.rental_room.response.ResultEnum;
import com.gxust.edu.rental_room.service.RoleService;
import com.gxust.edu.rental_room.service.impl.RoleServiceImpl;
import com.gxust.edu.rental_room.utils.ResultUtil;
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
    RoleService roleService;

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    @ResponseBody
    public Result addRole(Role role) {
        boolean result = roleService.add(role);
        if (!result) {
            return ResultUtil.error(ResultEnum.ROLE_ADD_ERRO.getCode(),ResultEnum.ROLE_ADD_ERRO.getMsg());
        }
        return ResultUtil.success();
    }

    @RequestMapping(value = "/delete", method = RequestMethod.GET)
    @ResponseBody
    public Result deleteRole(String id) {
        String[] idsStr = id.split(",");
        int[] ids = new int[idsStr.length];
        for (int i = 0; i < idsStr.length; i++) {
            ids[i] = Integer.parseInt(idsStr[i]);
        }
        boolean result = roleService.deleteByIds(ids);
        if (!result) {
           return ResultUtil.error(ResultEnum.ROLE_DELETE_ERRO.getCode(),ResultEnum.ROLE_DELETE_ERRO.getMsg());
        }
        return ResultUtil.success();
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    @ResponseBody
    public Result update(Role role) {
        boolean result = roleService.update(role);
        if (!result) {
            return ResultUtil.error(ResultEnum.ROLE_UPDATE_ERRO.getCode(),ResultEnum.ROLE_UPDATE_ERRO.getMsg());
        }
        return ResultUtil.success();
    }

    @RequestMapping(value = "/findById", method = RequestMethod.GET)
    @ResponseBody
    public Result findById(Integer id) {
        Role role = roleService.findById(id);
        if (role == null) {
            return ResultUtil.error(ResultEnum.ROLE_NOT_FIND.getCode(),ResultEnum.ROLE_NOT_FIND.getMsg());
        }
        return ResultUtil.success(role);
    }

    @RequestMapping(value = "/findByQuery", method = RequestMethod.GET)
    @ResponseBody
    public Result findByQuery(RoleQuery roleQuery) {
        PageInfo<Role> pageInfo = roleService.findByQuery(roleQuery);
        List<Role> roleList = pageInfo.getList();
        if (roleList == null || roleList.size() < 0) {
            return ResultUtil.error(ResultEnum.ROLE_IS_NULL.getCode(),ResultEnum.ROLE_IS_NULL.getMsg());
        }
        return ResultUtil.success(pageInfo);
    }

    @RequestMapping(value = "/findRoleByUserId", method = RequestMethod.GET)
    @ResponseBody
    public Result findRoleByUserId(Integer userId) {
        List<Role> roleList = roleService.findRoleByUserId(userId);
        if (roleList == null && roleList.size() < 0) {
            return ResultUtil.error(ResultEnum.ROLE_FIND_FAIL.getCode(),ResultEnum.ROLE_FIND_FAIL.getMsg());
        }
        return ResultUtil.success(roleList);
    }

    @RequestMapping(value = "/setPermissions",method = RequestMethod.POST)
    @ResponseBody
    public Result setPermission(Integer roleId, String permissionIdsStr) {
        try {
            roleService.setPermissions(roleId, permissionIdsStr);
            return ResultUtil.success();
        } catch (Exception e) {
            return ResultUtil.error(ResultEnum.ROLE_SET_PERMISSION_FAIL.getCode(),ResultEnum.ROLE_SET_PERMISSION_FAIL.getMsg());
        }
    }
}
