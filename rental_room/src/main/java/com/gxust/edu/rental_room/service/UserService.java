package com.gxust.edu.rental_room.service;

import com.gxust.edu.rental_room.domain.User;
import com.gxust.edu.rental_room.query.UserQuery;

public interface UserService extends BaseService<User, UserQuery> {
    User login(String loginName, String password);
}
