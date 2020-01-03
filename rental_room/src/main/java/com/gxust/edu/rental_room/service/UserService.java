package com.gxust.edu.rental_room.service;

import com.gxust.edu.rental_room.domain.User;

public interface UserService {
    User login(String loginName,String password);
}
