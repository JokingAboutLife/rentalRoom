package com.gxust.edu.rental_room.service.impl;

import com.gxust.edu.rental_room.mapper.HouseMapper;
import com.gxust.edu.rental_room.domain.House;
import com.gxust.edu.rental_room.query.HouseQuery;
import com.gxust.edu.rental_room.service.HouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HouseServiceImpl extends BaseServiceImpl<House, HouseQuery> implements HouseService {

    @Autowired
    public void setHouseMapper(HouseMapper houseMapper) {
        this.baseMapper = houseMapper;
    }

}
