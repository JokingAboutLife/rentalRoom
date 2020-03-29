package com.gxust.edu.rental_room.service.impl;

import com.gxust.edu.rental_room.query.SysDictQuery;
import com.gxust.edu.rental_room.service.SysDictService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.gxust.edu.rental_room.mapper.SysDictMapper;
import com.gxust.edu.rental_room.domain.SysDict;

@Service
public class SysDictServiceImpl extends BaseServiceImpl<SysDict, SysDictQuery> implements SysDictService {


    @Autowired
    public void setUserMapper(SysDictMapper sysDictMapper) {
        this.baseMapper = sysDictMapper;
    }


    @Override
    public int insertSelective(SysDict record) {
        return ((SysDictMapper)baseMapper).insertSelective(record);
    }

    @Override
    public SysDict selectByPrimaryKey(Integer id) {
        return ((SysDictMapper)baseMapper).selectByPrimaryKey(id);
    }


    @Override
    public int updateByPrimaryKey(SysDict record) {
        return ((SysDictMapper)baseMapper).updateByPrimaryKey(record);
    }

}