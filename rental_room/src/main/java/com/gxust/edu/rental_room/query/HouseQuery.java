package com.gxust.edu.rental_room.query;

import lombok.Data;

@Data
public class HouseQuery extends BaseQuery {
    private String title;
    private String name;
    private String type;
    private String city;

}
