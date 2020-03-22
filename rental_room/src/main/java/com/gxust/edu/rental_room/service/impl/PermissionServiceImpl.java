package com.gxust.edu.rental_room.service.impl;

import com.gxust.edu.rental_room.domain.Permission;
import com.gxust.edu.rental_room.mapper.PermissionMapper;
import com.gxust.edu.rental_room.query.PermissionQuery;
import com.gxust.edu.rental_room.service.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PermissionServiceImpl extends BaseServiceImpl<Permission, PermissionQuery> implements PermissionService {

    @Autowired
    public void setPermissionMapper(PermissionMapper permissionMapper) {
        this.baseMapper = permissionMapper;
    }

    @Override
    public boolean add(Permission permission) {
        if(permission.getParentId()==null){
            permission.setParentId(0);
        }
        return super.add(permission);
    }

    @Override
    public List<Permission> findAllPermission(Integer userId,Integer roleId) {
        return ((PermissionMapper)baseMapper).findAllPermission(userId, roleId);
    }

    @Override
    public List<Permission> selectFirstMenuByUserIdOrRoleId(Integer roleId, Integer userId) {
        return ((PermissionMapper)baseMapper).selectFirstMenuByUserIdOrRoleId(roleId,userId);
    }

    @Override
    public List<Permission> selectLeafByUserIdOrRoleId(Integer roleId, Integer userId) {
        return ((PermissionMapper)baseMapper).selectLeafByUserIdOrRoleId(roleId,userId);
    }
}
