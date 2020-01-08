package com.gxust.edu.rental_room.dao;

import com.gxust.edu.rental_room.domain.User;
import com.gxust.edu.rental_room.query.UserQuery;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface UserMapper {
    User login(@Param("account") String account,@Param("password") String password);

    int add(User user);

    int deleteById(Integer id);

    int deleteByIds(int[] id);

    int update(User user);

    User findById(Integer id);

    List<User> findByQuery(UserQuery userquery);

    List<User> query();
}
