package com.gxust.edu.rental_room.mapper;

import com.gxust.edu.rental_room.domain.Role;
import com.gxust.edu.rental_room.query.RoleQuery;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface RoleMapper extends BaseMapper<Role, RoleQuery> {

    int bind(@Param("roleId") int roleId, @Param("permissionId") int permissionId);

    int unBind(@Param("roleId") int roleId, @Param("permissionId") int permissionId);

    void delPermissionsByRoleId(int roleId);

    List<Role> findRoleByUserId(Integer userId);
}
