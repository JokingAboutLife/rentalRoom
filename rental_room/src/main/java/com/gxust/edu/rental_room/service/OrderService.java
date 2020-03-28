package com.gxust.edu.rental_room.service;


import com.gxust.edu.rental_room.domain.Order;
import com.gxust.edu.rental_room.query.OrderQuery;

public interface OrderService extends BaseService<Order, OrderQuery> {
    int updateByPrimaryKey(Order record);
}
