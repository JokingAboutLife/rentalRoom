package com.gxust.edu.rental_room.service;

import com.gxust.edu.rental_room.domain.Permission;
import com.gxust.edu.rental_room.query.PermissionQuery;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface PermissionService extends BaseService<Permission, PermissionQuery> {

    List<Permission> findAllPermission(Integer userId, Integer roleId);

    List<Permission> selectFirstMenuByUserIdOrRoleId(@Param("roleId") Integer roleId, @Param("userId") Integer userId);

    List<Permission> selectLeafByUserIdOrRoleId(@Param("roleId") Integer roleId,@Param("userId") Integer userId);

    List<String> findStringPermsByUserId(Integer userId);
}
