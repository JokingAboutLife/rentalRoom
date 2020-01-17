package com.gxust.edu.rental_room.mapper;

import com.gxust.edu.rental_room.domain.Role;
import com.gxust.edu.rental_room.query.RoleQuery;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface RoleMapper extends BaseMapper<Role, RoleQuery> {
}
