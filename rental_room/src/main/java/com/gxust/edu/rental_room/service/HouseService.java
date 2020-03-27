package com.gxust.edu.rental_room.service;

import com.github.pagehelper.PageInfo;
import com.gxust.edu.rental_room.domain.House;
import com.gxust.edu.rental_room.domain.YzInfo;
import com.gxust.edu.rental_room.query.HouseQuery;

public interface HouseService extends BaseService<House, HouseQuery> {
    PageInfo<House> findAllRental(HouseQuery q);
    boolean updateStatus(Integer id,Boolean status);

    boolean rental(YzInfo yzInfo);
}
