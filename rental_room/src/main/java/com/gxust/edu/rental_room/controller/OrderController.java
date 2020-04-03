package com.gxust.edu.rental_room.controller;

import com.github.pagehelper.PageInfo;
import com.gxust.edu.rental_room.domain.Order;
import com.gxust.edu.rental_room.domain.User;
import com.gxust.edu.rental_room.query.OrderQuery;
import com.gxust.edu.rental_room.response.Result;
import com.gxust.edu.rental_room.response.ResultEnum;
import com.gxust.edu.rental_room.service.HouseService;
import com.gxust.edu.rental_room.service.OrderService;
import com.gxust.edu.rental_room.service.UserService;
import com.gxust.edu.rental_room.utils.ResultUtil;
import com.gxust.edu.rental_room.vo.OrderVo;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping(value = "/order")
public class OrderController {

    @Autowired
    OrderService orderService;

    @Autowired
    HouseService houseService;

    @Autowired
    UserService userService;

    @RequestMapping(value = "/findMyHouse", method = RequestMethod.GET)
    @ResponseBody
    public Result getOrder(Integer lessorId) {
        List<Order> orderList = orderService.findMyOrder(lessorId);
        if (orderList.size() < 0 || orderList == null) {
            return ResultUtil.error(ResultEnum.ORDER_FIND_FAIL);
        }
        List<OrderVo> orderVoList = new ArrayList<>();
        for (Order order : orderList) {
            OrderVo orderVo = new OrderVo();
            orderVo.setLessor((User) SecurityUtils.getSubject().getPrincipal());
            orderVo.setHouse(houseService.findById(order.getHouseid()));
            orderVo.setUser(userService.findById(order.getUserid()));
            orderVoList.add(orderVo);
        }
        return ResultUtil.success(orderVoList);
    }
}
