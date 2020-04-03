package com.gxust.edu.rental_room.service;


import com.github.pagehelper.PageInfo;
import com.gxust.edu.rental_room.domain.Order;
import com.gxust.edu.rental_room.query.OrderQuery;
import com.gxust.edu.rental_room.vo.OrderVo;

import java.util.List;

public interface OrderService extends BaseService<Order, OrderQuery> {
    int updateByPrimaryKey(Order record);

    List<Order> findMyOrder(Integer lessorId);
}
