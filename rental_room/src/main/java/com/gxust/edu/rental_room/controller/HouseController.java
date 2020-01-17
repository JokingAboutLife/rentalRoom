package com.gxust.edu.rental_room.controller;

import com.github.pagehelper.PageInfo;
import com.gxust.edu.rental_room.domain.House;
import com.gxust.edu.rental_room.query.HouseQuery;
import com.gxust.edu.rental_room.service.impl.HouseServiceImpl;
import com.gxust.edu.rental_room.utils.JsonModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/house")
public class HouseController {

    @Autowired
    HouseServiceImpl houseService;

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    @ResponseBody
    public JsonModel addHouse(House house) {
        JsonModel jsonModel = new JsonModel();
        boolean result = houseService.add(house);
        if (result) {
            jsonModel.setMsg("添加成功");
            jsonModel.setSuccess(true);
        } else {
            jsonModel.setMsg("添加失败");
            jsonModel.setSuccess(false);
        }
        return jsonModel;
    }

    @RequestMapping(value = "/delete", method = RequestMethod.GET)
    @ResponseBody
    public JsonModel deleteHouse(String id) {
        JsonModel jsonModel = new JsonModel();
        String[] idsStr = id.split(",");
        int[] ids = new int[idsStr.length];
        for (int i = 0; i < idsStr.length; i++) {
            ids[i] = Integer.parseInt(idsStr[i]);
        }
        boolean result = houseService.deleteByIds(ids);
        if (result) {
            jsonModel.setMsg("删除成功");
            jsonModel.setSuccess(true);
        } else {
            jsonModel.setMsg("删除失败");
            jsonModel.setSuccess(false);
        }
        return jsonModel;
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    @ResponseBody
    public JsonModel update(House house) {
        JsonModel jsonModel = new JsonModel();
        boolean result = houseService.update(house);
        if (result) {
            jsonModel.setMsg("更新成功");
            jsonModel.setSuccess(true);
        } else {
            jsonModel.setMsg("更新失败");
            jsonModel.setSuccess(false);
        }
        return jsonModel;
    }

    @RequestMapping(value = "/findById", method = RequestMethod.GET)
    @ResponseBody
    public JsonModel findById(Integer id) {
        JsonModel jsonModel = new JsonModel();
        House house = houseService.findById(id);
        if (house != null) {
            jsonModel.setMsg("查找ID成功");
            jsonModel.setSuccess(true);
            jsonModel.setData(house);
        } else {
            jsonModel.setMsg("查找ID失败");
            jsonModel.setSuccess(false);
        }
        return jsonModel;
    }

    @RequestMapping(value = "/findByQuery", method = RequestMethod.GET)
    @ResponseBody
    public JsonModel findByQuery(HouseQuery houseQuery) {
        JsonModel jsonModel = new JsonModel();
        PageInfo<House> pageInfo = houseService.findByQuery(houseQuery);
        List<House> houseList = pageInfo.getList();
        if (houseList != null && houseList.size() >= 0) {
            jsonModel.setMsg("查找成功");
            jsonModel.setSuccess(true);
            jsonModel.setData(houseList);
        } else {
            jsonModel.setMsg("查找失败");
            jsonModel.setSuccess(false);
        }
        return jsonModel;
    }
}