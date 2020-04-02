package com.gxust.edu.rental_room.mapper;

import com.gxust.edu.rental_room.domain.Permission;
import com.gxust.edu.rental_room.query.PermissionQuery;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface PermissionMapper extends BaseMapper<Permission, PermissionQuery> {

    List<Permission> findAllPermission(@Param("userId") Integer userId, @Param("roleId") Integer roleId);

    /**
     * 根据用户id或角色id查询子类菜单
     */
    List<Permission> selectFirstMenuByUserIdOrRoleId(@Param("roleId") Integer roleId,@Param("userId") Integer userId);

    /**
     * 根据用户id或角色id查询除了一级菜单以外的菜单
     */
    List<Permission> selectLeafByUserIdOrRoleId(@Param("roleId") Integer roleId,@Param("userId") Integer userId);

    List<String> findStringPermsByUserId(@Param("userId") Integer userId);

    List<Permission> findMenu();

    List<Permission> findByParentId(Integer parentId);

    void deleteRolePermById(Integer permissionId);
}
