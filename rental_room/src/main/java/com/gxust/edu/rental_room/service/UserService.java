package com.gxust.edu.rental_room.service;

import com.gxust.edu.rental_room.domain.User;
import com.gxust.edu.rental_room.query.UserQuery;

import java.util.List;

public interface UserService extends BaseService<User, UserQuery> {
    User findByLoginName(String loginName);

    boolean addUser(User user,Integer roleId);

    int findCountByLoginName(String loginName,Integer id);

    boolean updateStatus(Boolean status, Integer id);

    boolean setRole(Integer userId,Integer roleId,boolean isNew);

    List<User> findUsersByLessorId(Integer lessorId,Integer houseId);
}
