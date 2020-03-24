package com.gxust.edu.rental_room.service.impl;

import com.gxust.edu.rental_room.domain.User;
import com.gxust.edu.rental_room.mapper.RoleMapper;
import com.gxust.edu.rental_room.mapper.UserMapper;
import com.gxust.edu.rental_room.query.UserQuery;
import com.gxust.edu.rental_room.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserServiceImpl extends BaseServiceImpl<User, UserQuery> implements UserService {

    @Autowired
    public void setUserMapper(UserMapper userMapper) {
        this.baseMapper = userMapper;
    }

    @Autowired
    RoleMapper roleMapper;

    @Override
    public User findByLoginName(String loginName) {
        return ((UserMapper)baseMapper).findByLoginName(loginName);
    }

    @Override
    public int findCountByLoginName(String loginName, Integer id) {
        return ((UserMapper) baseMapper).findCountByLoginName(loginName, id);
    }

    @Override
    public boolean updateStatus(Boolean status, Integer id) {
        Integer sta = status ? 1 : 0;
        return ((UserMapper) baseMapper).updateStatus(sta, id) == 1;
    }

    @Override
    public boolean setRole(Integer userId, Integer roleId, boolean isNew) {
        boolean result;
        if (isNew) {
            result = ((UserMapper) baseMapper).bind(userId, roleId) == 1;
        } else {
            result = ((UserMapper) baseMapper).updateRole(userId, roleId) == 1;
        }
        return result;
    }

    @Transactional
    @Override
    public boolean addUser(User user, Integer roleId) {
        user.setPassword("123456");
        user.setStatus(true);
        boolean addResult = baseMapper.add(user) == 1;
        boolean bindResult = ((UserMapper) baseMapper).bind(user.getId(), roleId)==1;
        return addResult && bindResult;
    }

}
