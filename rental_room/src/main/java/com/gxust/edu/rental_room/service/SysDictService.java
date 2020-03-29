package com.gxust.edu.rental_room.service;

import com.gxust.edu.rental_room.domain.SysDict;
import com.gxust.edu.rental_room.query.SysDictQuery;


public interface SysDictService extends BaseService<SysDict, SysDictQuery> {
    int insertSelective(SysDict record);

    SysDict selectByPrimaryKey(Integer id);

    int updateByPrimaryKey(SysDict record);
}