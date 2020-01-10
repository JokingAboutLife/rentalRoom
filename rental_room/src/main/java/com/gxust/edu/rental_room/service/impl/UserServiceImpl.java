package com.gxust.edu.rental_room.service.impl;

import com.gxust.edu.rental_room.dao.UserMapper;
import com.gxust.edu.rental_room.domain.User;
import com.gxust.edu.rental_room.query.UserQuery;
import com.gxust.edu.rental_room.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl extends BaseServiceImpl<User, UserQuery> implements UserService {

    @Autowired
    public void setBookMapper(UserMapper userMapper) {
        this.baseMapper = userMapper;
    }

    @Override
    public User login(String account, String password) {
        return ((UserMapper) baseMapper).login(account, password);
    }

    @Override
    public boolean add(User user) {
        user.setPassword("123456");
        user.setStatus(new Byte("1"));
        return baseMapper.add(user) == 1;
    }

}
