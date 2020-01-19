package com.gxust.edu.rental_room.mapper;

import com.gxust.edu.rental_room.domain.Permission;
import com.gxust.edu.rental_room.query.PermissionQuery;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface PermissionMapper extends BaseMapper<Permission, PermissionQuery> {

    List<Permission> findLevelMenu();

    int bind(@Param("roleId") int roleId,@Param("permissionId") int permissionId);

    int unBind(@Param("roleId") int roleId,@Param("permissionId") int permissionId);
}
