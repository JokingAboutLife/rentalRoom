package com.gxust.edu.rental_room.controller;

import com.github.pagehelper.PageInfo;
import com.gxust.edu.rental_room.domain.House;
import com.gxust.edu.rental_room.domain.YzInfo;
import com.gxust.edu.rental_room.query.HouseQuery;
import com.gxust.edu.rental_room.response.Result;
import com.gxust.edu.rental_room.response.ResultEnum;
import com.gxust.edu.rental_room.service.HouseService;
import com.gxust.edu.rental_room.utils.ResultUtil;
import com.gxust.edu.rental_room.vo.CheckedHouseVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/house")
public class HouseController {

    @Autowired
    HouseService houseService;

    @RequestMapping(value = "/findRentalHouse", method = RequestMethod.GET)
    @ResponseBody
    public Result allRental(HouseQuery qo) {
        PageInfo<House> pageInfo = houseService.findAllRental(qo);
        if (pageInfo.getList() == null || pageInfo.getList().size() < 0) {
            return ResultUtil.error(ResultEnum.HOUSE_RENTAL_IS_NULL);
        }
        return ResultUtil.success(pageInfo);
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    @ResponseBody
    public Result addHouse(House house) {
        boolean result = houseService.add(house);
        if (!result) {
            return ResultUtil.error(ResultEnum.HOUSE_ADD_ERRO);
        }
        return ResultUtil.success();
    }

    @RequestMapping(value = "/delete", method = RequestMethod.GET)
    @ResponseBody
    public Result deleteHouse(Integer id) {
        /*String[] idsStr = id.split(",");
        int[] ids = new int[idsStr.length];
        for (int i = 0; i < idsStr.length; i++) {
            ids[i] = Integer.parseInt(idsStr[i]);
        }*/
        boolean result = houseService.deleteById(id);
        if (!result) {
            return ResultUtil.error(ResultEnum.HOUSE_DELETE_ERRO);
        }
        return ResultUtil.success();
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    @ResponseBody
    public Result update(House house) {
        boolean result = houseService.update(house);
        if (!result) {
            return ResultUtil.error(ResultEnum.HOUSE_UPDATE_ERRO);
        }
        return ResultUtil.success();
    }

    @RequestMapping(value = "/findById", method = RequestMethod.GET)
    @ResponseBody
    public Result findById(Integer id) {
        House house = houseService.findById(id);
        if (house == null) {
            return ResultUtil.error(ResultEnum.HOUSE_FIND_IS_NULL);
        }
        return ResultUtil.success(house);
    }

    @RequestMapping(value = "/findByQuery", method = RequestMethod.GET)
    @ResponseBody
    public Result findByQuery(HouseQuery houseQuery) {
        PageInfo<House> pageInfo = houseService.findByQuery(houseQuery);
        List<House> houseList = pageInfo.getList();
        if (houseList == null && houseList.size() < 0) {
            return ResultUtil.error(ResultEnum.HOUSE_FIND_IS_NULL);
        }
        return ResultUtil.success(pageInfo);
    }

    @RequestMapping(value = "/update/status", method = RequestMethod.POST)
    @ResponseBody
    public Result updateStatus(Integer id, Boolean status) {
        boolean result;
        if (status) {
            result = houseService.updateStatus(id, true, new Date());
        } else {
            result = houseService.updateStatus(id, false, null);
        }
        if (!result) {
            return ResultUtil.error(ResultEnum.HOUSE_UPDATE_STATUS_FAIL);
        }
        return ResultUtil.success();
    }

    @RequestMapping(value = "/yzhouse", method = RequestMethod.POST)
    @ResponseBody
    public Result yzhouse(YzInfo yzInfo) {
        if (yzInfo.getYztime() == null) {
            return ResultUtil.error(ResultEnum.HOUSE_YZ_TIME_IS_NULL);
        }
        if (yzInfo.getUserid() == yzInfo.getLessorid()) {
            return ResultUtil.error(ResultEnum.HOUSE_NOT_RENT_SELF);
        }
        try {
            boolean result = houseService.yzhouse(yzInfo);
            if (!result) {
                return ResultUtil.error(ResultEnum.HOUSE_RENTAL_YZ_FAIL);
            }
            return ResultUtil.success();
        } catch (Exception e) {
            return ResultUtil.error(ResultEnum.HOUSE_RENTAL_YZ_EXISTS);
        }
    }

    @RequestMapping(value = "/getYzHouse", method = RequestMethod.GET)
    @ResponseBody
    public Result getYzHouse(Integer userId) {
        List<House> yzHouse = houseService.findYzHouse(userId);
        return ResultUtil.success(yzHouse);
    }

    @RequestMapping(value = "/cancelYzHouse", method = RequestMethod.GET)
    @ResponseBody
    public Result cancelYzHouse(Integer userId, Integer houseId) {
        boolean result = houseService.cancelYzHouse(userId, houseId);
        if (!result) {
            return ResultUtil.error(ResultEnum.HOUSE_CANCEL_YZ_EXISTS);
        }
        return ResultUtil.success();
    }

    @RequestMapping(value = "/getSuccessRentHouse", method = RequestMethod.GET)
    @ResponseBody
    public Result getSuccessRentHouse(Integer userId) {
        List<House> list = houseService.findsuccessRentHouse(userId);
        if (list == null || list.size() < 0) {
            return ResultUtil.error(ResultEnum.HOUSE_CANCEL_YZ_EXISTS);
        }
        return ResultUtil.success(list);
    }

    @RequestMapping(value = "/getCheckedHouse", method = RequestMethod.GET)
    @ResponseBody
    public Result getCheckedHouse(Integer userId) {
        List<CheckedHouseVo> list = houseService.findCheckedHouse(userId);
        if (list == null || list.size() < 0) {
            return ResultUtil.error(ResultEnum.HOUSE_CANCEL_YZ_EXISTS);
        }
        return ResultUtil.success(list);
    }

    @RequestMapping(value = "/rentingToUser", method = RequestMethod.POST)
    @ResponseBody
    public Result rentingToUser(Integer userId, Integer houseId, Integer lessorId) {
        try {
            houseService.rentingToUser(userId, houseId, lessorId);
            return ResultUtil.success();
        } catch (Exception e) {
            return ResultUtil.error(ResultEnum.HOUSE_RENTAL_FAIL);
        }
    }

    @RequestMapping(value = "/getMyHouse",method = RequestMethod.GET)
    @ResponseBody
    public Result getMyHouse(Integer userId){
        List<House> myHouse = houseService.findMyHouse(userId);
        return ResultUtil.success(myHouse);
    }


    //TODO 收藏模块
    //TODO 房屋维护模块
    //TODO 退住模块
    //TODO 租金模块
    //TODO 房屋举报模块
}
