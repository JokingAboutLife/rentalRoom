package com.gxust.edu.rental_room.vo;


import com.gxust.edu.rental_room.domain.House;
import com.gxust.edu.rental_room.domain.User;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class CheckedHouseVo {
    private House house;
    private List<User> users;
}
