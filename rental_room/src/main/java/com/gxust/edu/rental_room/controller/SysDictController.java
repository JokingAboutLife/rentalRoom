package com.gxust.edu.rental_room.controller;

import com.github.pagehelper.IPage;
import com.github.pagehelper.PageInfo;
import com.gxust.edu.rental_room.domain.SysDict;
import com.gxust.edu.rental_room.query.SysDictQuery;
import com.gxust.edu.rental_room.response.Result;
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
}
