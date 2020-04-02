package com.gxust.edu.rental_room.controller;

import com.github.pagehelper.PageInfo;
import com.gxust.edu.rental_room.domain.Permission;
import com.gxust.edu.rental_room.query.PermissionQuery;
import com.gxust.edu.rental_room.response.ResultEnum;
import com.gxust.edu.rental_room.service.impl.PermissionServiceImpl;
import com.gxust.edu.rental_room.response.Result;
import com.gxust.edu.rental_room.utils.ResultUtil;
import com.gxust.edu.rental_room.utils.TreeUtil;
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
    public Result addPermission(Permission permission) {
        boolean result = permissionService.add(permission);
        if (!result) {
            return ResultUtil.error(ResultEnum.PERMISSION_ADD_ERRO);
        }
        return ResultUtil.success();
    }

    @RequestMapping(value = "/delete", method = RequestMethod.GET)
    @ResponseBody
    public Result deletePermission(Integer id) {
        /*String[] idsStr = id.split(",");
        int[] ids = new int[idsStr.length];
        for (int i = 0; i < idsStr.length; i++) {
            ids[i] = Integer.parseInt(idsStr[i]);
        }*/
        boolean result = permissionService.deleteById(id);
        if (!result) {
            return ResultUtil.error(ResultEnum.PERMISSION_DELETE_ERRO);
        }
        return ResultUtil.success();
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    @ResponseBody
    public Result update(Permission permission) {
        boolean result = permissionService.update(permission);
        if (!result) {
            return ResultUtil.error(ResultEnum.PERMISSION_UPDATE_ERRO);
        }
        return ResultUtil.success();
    }

    @RequestMapping(value = "/findById", method = RequestMethod.GET)
    @ResponseBody
    public Result findById(Integer id) {
        Permission permission = permissionService.findById(id);
        if (permission == null) {
            return ResultUtil.error(ResultEnum.PERMISSION_NOT_FIND);
        }
        return ResultUtil.success(permission);
    }

    @RequestMapping(value = "/findByQuery", method = RequestMethod.GET)
    @ResponseBody
    public Result findByQuery(PermissionQuery permissionQuery) {
        PageInfo<Permission> pageInfo = permissionService.findByQuery(permissionQuery);
        List<Permission> permissionList = pageInfo.getList();
        if (permissionList == null && permissionList.size() < 0) {
            return ResultUtil.error(ResultEnum.PERMISSION_NOT_FIND);
        }
        return ResultUtil.success(permissionList);
    }

    @RequestMapping(value = "/findMenu", method = RequestMethod.GET)
    @ResponseBody
    public Result findLevelMenu() {
        List<Permission> menus = permissionService.findMenu();
        if (menus == null && menus.size() < 0) {
            return ResultUtil.error(ResultEnum.MENU_FIND_IS_NULL.getCode(),ResultEnum.MENU_FIND_IS_NULL.getMsg());
        }
        return ResultUtil.success(menus);
    }

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    @ResponseBody
    public Result findAllPermission(String type) {
        //请求list结构的权限列表
        if ("list".equals(type)) {
            PermissionQuery qo = new PermissionQuery();
            qo.setPaging(false);
            List<Permission> list = permissionService.findByQuery(qo).getList();
            if (list == null && list.size() < 0) {
                return ResultUtil.error(ResultEnum.PERMISSION_IS_NULL);
            }
            return ResultUtil.success(list);
        }
        //请求tree结构的权限列表
        List<Permission> allPermission = permissionService.findAllPermission(null, null);
        if (allPermission == null && allPermission.size() < 0) {
            return ResultUtil.error(ResultEnum.PERMISSION_IS_NULL);
        }
        return ResultUtil.success(allPermission);
    }


    @RequestMapping(value = "/findByRole", method = RequestMethod.GET)
    @ResponseBody
    public Result findPermissionByRoleId(Integer roleId) {
        List<Permission> FirstMenus = permissionService.selectFirstMenuByUserIdOrRoleId(roleId, null);
        List<Permission> permissionList = permissionService.selectLeafByUserIdOrRoleId(roleId, null);
        List<Permission> roleOfPermission = TreeUtil.getMenuTree(FirstMenus, permissionList);
        if (roleOfPermission == null && roleOfPermission.size() < 0) {
            return ResultUtil.error(ResultEnum.PERMISSION_NOT_FIND_BY_ROLE);
        }
        return ResultUtil.success(roleOfPermission);
    }

    @RequestMapping(value = "/findByParentId",method = RequestMethod.GET)
    @ResponseBody
    public Result findByParentId(Integer parentId){
        List<Permission> list = permissionService.findByParentId(parentId);
        return ResultUtil.success(list);
    }

}
