package com.gxust.edu.rental_room.service;

import com.gxust.edu.rental_room.domain.User;
import com.gxust.edu.rental_room.query.UserQuery;

import java.util.List;

public interface UserService {
    User login(String loginName,String password);

    boolean add(User user);

    boolean deleteById(Integer id);

    boolean deleteByIds(int[] id);

    boolean update(User user);

    User findById(Integer id);

    List<User> findByQuery(UserQuery userQuery);

    List<User> query();
}
