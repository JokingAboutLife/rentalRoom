package com.gxust.edu.rental_room.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.gxust.edu.rental_room.query.OrderQuery;
import com.gxust.edu.rental_room.response.ResultEnum;
import com.gxust.edu.rental_room.service.OrderService;
import com.gxust.edu.rental_room.utils.ResultUtil;
import com.gxust.edu.rental_room.vo.OrderVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.gxust.edu.rental_room.mapper.OrderMapper;
import com.gxust.edu.rental_room.domain.Order;

import java.util.ArrayList;
import java.util.List;

@Service
public class OrderServiceImpl extends BaseServiceImpl<Order, OrderQuery> implements OrderService {

    @Autowired
    public void setOrderMapper(OrderMapper OrderMapper) {
        this.baseMapper = OrderMapper;
    }

    @Override
    public int updateByPrimaryKey(Order record) {
        return ((OrderMapper)baseMapper).updateByPrimaryKey(record);
    }

    @Override
    public List<Order> findMyOrder(Integer lessorId) {
        return ((OrderMapper) baseMapper).findMyOrder(lessorId);
    }


}
