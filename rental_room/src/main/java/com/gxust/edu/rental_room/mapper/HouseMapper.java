package com.gxust.edu.rental_room.mapper;

import com.gxust.edu.rental_room.domain.House;
import com.gxust.edu.rental_room.query.HouseQuery;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface HouseMapper extends BaseMapper<House, HouseQuery> {
}
