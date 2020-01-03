package com.gxust.edu.rental_room.dao;

import com.gxust.edu.rental_room.domain.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface UserMapper {
    User login(@Param("loginName") String loginName,@Param("password") String password);
}
