package com.gxust.edu.rental_room.mapper;

import com.gxust.edu.rental_room.domain.SysDict;
import com.gxust.edu.rental_room.query.SysDictQuery;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface SysDictMapper extends BaseMapper<SysDict, SysDictQuery> {

    int insertSelective(SysDict record);

    SysDict selectByPrimaryKey(Integer id);

    int updateByPrimaryKey(SysDict record);

    List<SysDict> findSysDict();

    List<SysDict> findByTypename(String type);
}