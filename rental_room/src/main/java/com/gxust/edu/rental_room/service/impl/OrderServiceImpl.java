package com.gxust.edu.rental_room.service.impl;

import com.gxust.edu.rental_room.mapper.PermissionMapper;
import com.gxust.edu.rental_room.query.OrderQuery;
import com.gxust.edu.rental_room.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.gxust.edu.rental_room.mapper.OrderMapper;
import com.gxust.edu.rental_room.domain.Order;

@Service
public class OrderServiceImpl extends BaseServiceImpl<Order, OrderQuery> implements OrderService {

    @Autowired
    public void setPermissionMapper(OrderMapper OrderMapper) {
        this.baseMapper = OrderMapper;
    }

    @Override
    public int updateByPrimaryKey(Order record) {
        return ((OrderMapper)baseMapper).updateByPrimaryKey(record);
    }

}
