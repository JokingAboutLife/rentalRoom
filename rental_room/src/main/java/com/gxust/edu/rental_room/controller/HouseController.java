package com.gxust.edu.rental_room.controller;

import com.github.pagehelper.PageInfo;
import com.gxust.edu.rental_room.domain.House;
import com.gxust.edu.rental_room.query.HouseQuery;
import com.gxust.edu.rental_room.response.ResultEnum;
import com.gxust.edu.rental_room.service.impl.HouseServiceImpl;
import com.gxust.edu.rental_room.response.Result;
import com.gxust.edu.rental_room.utils.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.swing.*;
import java.util.List;

@Controller
@RequestMapping("/house")
public class HouseController {

    @Autowired
    HouseServiceImpl houseService;

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    @ResponseBody
    public Result addHouse(House house) {
        boolean result = houseService.add(house);
        if (!result) {
            return ResultUtil.error(ResultEnum.HOUSE_ADD_ERRO.getCode(), ResultEnum.HOUSE_ADD_ERRO.getMsg());
        }
        return ResultUtil.success();
    }

    @RequestMapping(value = "/delete", method = RequestMethod.GET)
    @ResponseBody
    public Result deleteHouse(String id) {
        String[] idsStr = id.split(",");
        int[] ids = new int[idsStr.length];
        for (int i = 0; i < idsStr.length; i++) {
            ids[i] = Integer.parseInt(idsStr[i]);
        }
        boolean result = houseService.deleteByIds(ids);
        if (!result) {
            return ResultUtil.error(ResultEnum.HOUSE_DELETE_ERRO.getCode(), ResultEnum.HOUSE_DELETE_ERRO.getMsg());
        }
        return ResultUtil.success();
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    @ResponseBody
    public Result update(House house) {
        boolean result = houseService.update(house);
        if (!result) {
            return ResultUtil.error(ResultEnum.HOUSE_UPDATE_ERRO.getCode(), ResultEnum.HOUSE_UPDATE_ERRO.getMsg());
        }
        return ResultUtil.success();
    }

    @RequestMapping(value = "/findById", method = RequestMethod.GET)
    @ResponseBody
    public Result findById(Integer id) {
        House house = houseService.findById(id);
        if (house == null) {
            return ResultUtil.error(ResultEnum.HOUSE_FIND_IS_NULL.getCode(), ResultEnum.HOUSE_FIND_IS_NULL.getMsg());
        }
        return ResultUtil.success(house);
    }

    @RequestMapping(value = "/findByQuery", method = RequestMethod.GET)
    @ResponseBody
    public Result findByQuery(HouseQuery houseQuery) {
        PageInfo<House> pageInfo = houseService.findByQuery(houseQuery);
        List<House> houseList = pageInfo.getList();
        if (houseList == null && houseList.size() <= 0) {
            return ResultUtil.error(ResultEnum.HOUSE_FIND_IS_NULL.getCode(), ResultEnum.HOUSE_FIND_IS_NULL.getMsg());
        }
        return ResultUtil.success(houseList);
    }
}
