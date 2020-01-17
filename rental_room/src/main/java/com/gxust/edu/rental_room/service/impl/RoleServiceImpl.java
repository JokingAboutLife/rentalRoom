package com.gxust.edu.rental_room.service.impl;

import com.gxust.edu.rental_room.domain.Role;
import com.gxust.edu.rental_room.mapper.RoleMapper;
import com.gxust.edu.rental_room.query.RoleQuery;
import com.gxust.edu.rental_room.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleServiceImpl extends BaseServiceImpl<Role, RoleQuery> implements RoleService {

    @Autowired
    public void setUserMapper(RoleMapper roleMapper) {
        this.baseMapper = roleMapper;
    }

}
