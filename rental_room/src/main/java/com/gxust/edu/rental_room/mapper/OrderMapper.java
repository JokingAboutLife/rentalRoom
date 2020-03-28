package com.gxust.edu.rental_room.mapper;

import com.gxust.edu.rental_room.domain.Order;
import com.gxust.edu.rental_room.query.OrderQuery;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface OrderMapper extends BaseMapper<Order, OrderQuery> {

    int updateByPrimaryKey(Order record);
}