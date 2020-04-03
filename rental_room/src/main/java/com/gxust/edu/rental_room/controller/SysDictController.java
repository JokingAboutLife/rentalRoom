package com.gxust.edu.rental_room.controller;

import com.github.pagehelper.IPage;
import com.github.pagehelper.PageInfo;
import com.gxust.edu.rental_room.domain.SysDict;
import com.gxust.edu.rental_room.query.SysDictQuery;
import com.gxust.edu.rental_room.response.Result;
import com.gxust.edu.rental_room.response.ResultEnum;
import com.gxust.edu.rental_room.service.SysDictService;
import com.gxust.edu.rental_room.utils.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping(value = "/sysDict")
public class SysDictController {

    @Autowired
    SysDictService sysDictService;

    @RequestMapping(value = "/all",method = RequestMethod.GET)
    @ResponseBody
    public Result getAll(){
        List<SysDict> sysDicts = sysDictService.findSysDict();
        return ResultUtil.success(sysDicts);
    }

    @RequestMapping(value = "/findById",method = RequestMethod.GET)
    @ResponseBody
    public Result findById(String type){
        List<SysDict> sysDicts = sysDictService.findByTypename(type);
        if (sysDicts == null || sysDicts.size() < 0) {
            return ResultUtil.error(ResultEnum.DICT_FIND_FAIL);
        }
        return ResultUtil.success(sysDicts);
    }

    @RequestMapping(value = "/add",method = RequestMethod.POST)
    @ResponseBody
    public Result addDict(SysDict sysDict){
       boolean result = sysDictService.add(sysDict);
       if(!result){
           return ResultUtil.error(ResultEnum.DICT_ADD_ERROR);
       }
        return ResultUtil.success();
    }

    @RequestMapping(value = "/delete",method = RequestMethod.GET)
    @ResponseBody
    public Result deleteDict(Integer id){
        boolean result = sysDictService.deleteById(id);
        if(!result){
            return ResultUtil.error(ResultEnum.DICT_DELETE_FAIL);
        }
        return ResultUtil.success();
    }

    @RequestMapping(value = "/update",method = RequestMethod.POST)
    @ResponseBody
    public Result updateDict(SysDict sysDict){
        boolean result = sysDictService.update(sysDict);
        if(!result){
            return ResultUtil.error(ResultEnum.DICT_UPDATE_FAIL);
        }
        return ResultUtil.success();
    }

}
