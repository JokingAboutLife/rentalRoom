package com.gxust.edu.rental_room.service;

import com.gxust.edu.rental_room.domain.Role;
import com.gxust.edu.rental_room.query.RoleQuery;

public interface RoleService extends BaseService<Role, RoleQuery> {

    int bind(int roleId,int permissionId);

    int unBind(int roleId,int permissionId);
}
