package com.gxust.edu.rental_room.service;

import com.gxust.edu.rental_room.domain.Permission;
import com.gxust.edu.rental_room.query.PermissionQuery;

import java.util.List;

public interface PermissionService extends BaseService<Permission, PermissionQuery> {

    List<Permission> findLevelMenu(int userId);

    int bind(int roleId,int permissionId);

    int unBind(int roleId,int permissionId);
}
