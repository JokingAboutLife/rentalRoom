package com.gxust.edu.rental_room.mapper;

import com.gxust.edu.rental_room.domain.YzInfo;
import com.gxust.edu.rental_room.query.YzInfoQuery;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface YzInfoMapper extends BaseMapper<YzInfo, YzInfoQuery> {

    int updateByPrimaryKey(YzInfo record);

    int cancelYzHouse(@Param("userId") Integer userId,@Param("houseId") Integer houseId);
}