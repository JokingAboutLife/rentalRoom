package com.gxust.edu.rental_room.service;

import com.github.pagehelper.PageInfo;
import com.gxust.edu.rental_room.domain.House;
import com.gxust.edu.rental_room.domain.YzInfo;
import com.gxust.edu.rental_room.query.HouseQuery;
import com.gxust.edu.rental_room.vo.CheckedHouseVo;

import java.util.List;

public interface HouseService extends BaseService<House, HouseQuery> {
    PageInfo<House> findAllRental(HouseQuery q);

    boolean updateStatus(Integer id,Boolean status);

    boolean yzhouse(YzInfo yzInfo);

    List<House> findYzHouse(Integer userId);

    boolean cancelYzHouse(Integer userId, Integer houseId);

    List<House> findsuccessRentHouse(Integer userId);

    List<CheckedHouseVo> findCheckedHouse(Integer userId);
}
