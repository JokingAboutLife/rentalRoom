package com.gxust.edu.rental_room.service.impl;

import com.gxust.edu.rental_room.domain.Permission;
import com.gxust.edu.rental_room.mapper.PermissionMapper;
import com.gxust.edu.rental_room.query.PermissionQuery;
import com.gxust.edu.rental_room.service.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
