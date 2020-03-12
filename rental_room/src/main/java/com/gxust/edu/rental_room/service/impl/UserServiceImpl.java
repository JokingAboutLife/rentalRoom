package com.gxust.edu.rental_room.service.impl;

import com.gxust.edu.rental_room.mapper.UserMapper;
import com.gxust.edu.rental_room.domain.User;
import com.gxust.edu.rental_room.query.UserQuery;
import com.gxust.edu.rental_room.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl extends BaseServiceImpl<User, UserQuery> implements UserService {

    @Autowired
    public void setUserMapper(UserMapper userMapper) {
        this.baseMapper = userMapper;
    }

    @Override
    public User login(String loginName, String password) {
        return ((UserMapper) baseMapper).login(loginName, password);
    }

    @Override
    public int findCountByLoginName(String loginName, Integer id) {
        return ((UserMapper) baseMapper).findCountByLoginName(loginName,id);
    }

    @Override
    public boolean add(User user) {
        user.setPassword("123456");
        user.setStatus(true);
        return baseMapper.add(user) == 1;
    }

}
