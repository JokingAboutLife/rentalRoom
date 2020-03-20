package com.gxust.edu.rental_room.mapper;

import com.gxust.edu.rental_room.domain.Role;
import com.gxust.edu.rental_room.query.RoleQuery;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface RoleMapper extends BaseMapper<Role, RoleQuery> {

    int bind(@Param("userId") int userId, @Param("roleId") int roleId);

    int unBind(@Param("userId") int userId, @Param("roleId") int roleId);

    List<Role> findRoleByUserId(Integer userId);
}
