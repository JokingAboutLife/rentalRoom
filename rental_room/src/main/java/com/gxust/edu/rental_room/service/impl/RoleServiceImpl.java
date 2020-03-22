package com.gxust.edu.rental_room.service.impl;

import com.gxust.edu.rental_room.domain.Role;
import com.gxust.edu.rental_room.mapper.RoleMapper;
import com.gxust.edu.rental_room.query.RoleQuery;
import com.gxust.edu.rental_room.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class RoleServiceImpl extends BaseServiceImpl<Role, RoleQuery> implements RoleService {

    @Autowired
    public void setUserMapper(RoleMapper roleMapper) {
        this.baseMapper = roleMapper;
    }


    public List<Role> findRoleByUserId(Integer userId) {
        return ((RoleMapper)baseMapper).findRoleByUserId(userId);
    }


    @Transactional
    @Override
    public void setPermissions(int roleId, String permissionIdsStr) {
        if("".equals(permissionIdsStr.trim())){
            ((RoleMapper)baseMapper).delPermissionsByRoleId(roleId);
            return;
        }
        String[] permissionIds = permissionIdsStr.split(",");
        int[] ids = new int[permissionIds.length];
        for (int i = 0; i < ids.length; i++) {
            ids[i] = Integer.parseInt(permissionIds[i]);
        }
        ((RoleMapper)baseMapper).delPermissionsByRoleId(roleId);
        for (int i = 0; i < ids.length; i++) {
            ((RoleMapper) baseMapper).bind(roleId, ids[i]);
        }
    }
}
