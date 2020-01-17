package com.gxust.edu.rental_room.mapper;

import com.gxust.edu.rental_room.domain.Permission;
import com.gxust.edu.rental_room.query.PermissionQuery;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface PermissionMapper extends BaseMapper<Permission, PermissionQuery> {
}
