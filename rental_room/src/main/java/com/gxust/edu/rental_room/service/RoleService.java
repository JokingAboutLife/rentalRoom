package com.gxust.edu.rental_room.service;

import com.gxust.edu.rental_room.domain.Role;
import com.gxust.edu.rental_room.query.RoleQuery;

import java.util.List;

public interface RoleService extends BaseService<Role, RoleQuery> {
    List<Role> findRoleByUserId(Integer userId);

    void setPermissions(int roleId,String permissionIdsStr);

    List<String> findStringRolesByUserId(Integer userId);
}
