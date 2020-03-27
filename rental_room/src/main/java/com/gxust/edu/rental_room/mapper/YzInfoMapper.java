package com.gxust.edu.rental_room.mapper;

import com.gxust.edu.rental_room.domain.YzInfo;
import com.gxust.edu.rental_room.query.YzInfoQuery;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface YzInfoMapper extends BaseMapper<YzInfo, YzInfoQuery> {

    int insertSelective(YzInfo record);

    YzInfo selectByPrimaryKey(Integer id);

    int updateByPrimaryKey(YzInfo record);
}