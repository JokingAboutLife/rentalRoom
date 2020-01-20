package com.gxust.edu.rental_room.mapper;

import com.gxust.edu.rental_room.domain.User;
import com.gxust.edu.rental_room.query.UserQuery;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface UserMapper extends BaseMapper<User, UserQuery> {
    User login(@Param("loginName") String loginName, @Param("password") String password);

    int findCountByLoginName(@Param("loginName") String loginName,@Param("id") Integer id);

}
