package com.gxust.edu.rental_room.service.impl;

import com.gxust.edu.rental_room.dao.UserMapper;
import com.gxust.edu.rental_room.domain.User;
import com.gxust.edu.rental_room.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserMapper userMapper;

    @Override
    public User login(String loginName, String password) {
        return userMapper.login(loginName,password);
    }
}
