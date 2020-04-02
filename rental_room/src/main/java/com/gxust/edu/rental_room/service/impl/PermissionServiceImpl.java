package com.gxust.edu.rental_room.service.impl;

import com.gxust.edu.rental_room.domain.Permission;
import com.gxust.edu.rental_room.mapper.PermissionMapper;
import com.gxust.edu.rental_room.query.PermissionQuery;
import com.gxust.edu.rental_room.service.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class PermissionServiceImpl extends BaseServiceImpl<Permission, PermissionQuery> implements PermissionService {

    @Autowired
    public void setPermissionMapper(PermissionMapper permissionMapper) {
        this.baseMapper = permissionMapper;
    }

    @Override
    public boolean add(Permission permission) {
        if (permission.getParentId() == null) {
            permission.setParentId(0);
        }
        return super.add(permission);
    }

    @Override
    public List<Permission> findAllPermission(Integer userId, Integer roleId) {
        return ((PermissionMapper) baseMapper).findAllPermission(userId, roleId);
    }

    @Override
    public List<Permission> selectFirstMenuByUserIdOrRoleId(Integer roleId, Integer userId) {
        return ((PermissionMapper) baseMapper).selectFirstMenuByUserIdOrRoleId(roleId, userId);
    }

    @Override
    public List<Permission> selectLeafByUserIdOrRoleId(Integer roleId, Integer userId) {
        return ((PermissionMapper) baseMapper).selectLeafByUserIdOrRoleId(roleId, userId);
    }

    @Override
    public List<String> findStringPermsByUserId(Integer userId) {
        List<String> stringPermsByUserId = ((PermissionMapper) baseMapper).findStringPermsByUserId(userId);
        Set<String> set = new HashSet<>();
        for (String s : stringPermsByUserId) {
            if (s != null && !"".equals(s)) {
                set.add(s);
            }
        }
        List<String> perms = new ArrayList<>();
        perms.addAll(set);
        return perms;
    }

    public List<Permission> findMenu() {
        return ((PermissionMapper)baseMapper).findMenu();
    }

    public List<Permission> findByParentId(Integer parentId) {
        return ((PermissionMapper)baseMapper).findByParentId(parentId);
    }
}
