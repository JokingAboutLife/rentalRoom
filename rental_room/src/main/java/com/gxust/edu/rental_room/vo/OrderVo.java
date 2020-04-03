package com.gxust.edu.rental_room.vo;

import com.gxust.edu.rental_room.domain.House;
import com.gxust.edu.rental_room.domain.User;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OrderVo {
    private House house;
    private User lessor;
    private User user;
}
