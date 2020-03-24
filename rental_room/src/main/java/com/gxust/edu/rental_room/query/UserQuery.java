package com.gxust.edu.rental_room.query;

import lombok.Data;

@Data
public class UserQuery extends BaseQuery {
    private String loginName;
    private String username;
}
