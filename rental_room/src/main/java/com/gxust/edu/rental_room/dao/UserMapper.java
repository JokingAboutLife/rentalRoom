package com.gxust.edu.rental_room.dao;

import com.gxust.edu.rental_room.domain.User;
import com.gxust.edu.rental_room.query.UserQuery;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface UserMapper extends BaseMapper<User, UserQuery> {
    User login(@Param("account") String account, @Param("password") String password);
}
