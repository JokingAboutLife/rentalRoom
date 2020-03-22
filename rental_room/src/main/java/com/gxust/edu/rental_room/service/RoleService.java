package com.gxust.edu.rental_room.service;

import com.gxust.edu.rental_room.domain.Role;
import com.gxust.edu.rental_room.query.RoleQuery;

public interface RoleService extends BaseService<Role, RoleQuery> {

    void setPermissions(int roleId,String permissionIdsStr);

}
