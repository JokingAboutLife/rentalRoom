package com.gxust.edu.rental_room.mapper;

import com.gxust.edu.rental_room.domain.House;
import com.gxust.edu.rental_room.query.HouseQuery;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

@Mapper
public interface HouseMapper extends BaseMapper<House, HouseQuery> {
    List<House> findAllRental(HouseQuery qo);

    int updateStatus(@Param("id") int id,@Param("status") boolean status,@Param("releaseTime") Date releaseTime);

    int updateRentalStatus(@Param("id") int id,@Param("rentalStatus") int rentalStatus);

    List<House> findYzHouse(Integer userId);

    List<House> findsuccessRentHouse(Integer userId);

    List<House> findCheckedHouse(Integer userId);

    List<House> findMyHouse(Integer userId);
}
