package com.gxust.edu.rental_room.service.impl;

import com.gxust.edu.rental_room.dao.UserMapper;
import com.gxust.edu.rental_room.domain.User;
import com.gxust.edu.rental_room.query.UserQuery;
import com.gxust.edu.rental_room.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserMapper userMapper;

    @Override
    public User login(String loginName, String password) {
        return userMapper.login(loginName,password);
    }

    @Override
    public boolean add(User user) {
        user.setPassword("123456");
        user.setStatus(new Byte("1"));
        int result = userMapper.add(user);
        return result == 1;
    }

    @Override
    public boolean deleteById(Integer id) {
        int result = userMapper.deleteById(id);
        return result == 1;
    }

    @Override
    public boolean deleteByIds(int[] id) {
        int result = userMapper.deleteByIds(id);
        return result > 0;
    }

    @Override
    public boolean update(User user) {
        int result = userMapper.update(user);
        return result == 1;
    }

    @Override
    public User findById(Integer id) {
        return userMapper.findById(id);
    }

    @Override
    public List<User> findByQuery(UserQuery userQuery) {
        return userMapper.findByQuery(userQuery);
    }

    @Override
    public List<User> query() {
        return userMapper.query();
    }
}
