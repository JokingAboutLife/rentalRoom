package com.gxust.edu.rental_room.mapper;

import com.gxust.edu.rental_room.domain.Order;
import com.gxust.edu.rental_room.query.OrderQuery;
import com.gxust.edu.rental_room.vo.OrderVo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface OrderMapper extends BaseMapper<Order, OrderQuery> {

    int updateByPrimaryKey(Order record);

    List<Order> findMyOrder(Integer lessorId);
}