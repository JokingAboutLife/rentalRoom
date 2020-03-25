package com.gxust.edu.rental_room.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.gxust.edu.rental_room.mapper.HouseMapper;
import com.gxust.edu.rental_room.domain.House;
import com.gxust.edu.rental_room.query.BaseQuery;
import com.gxust.edu.rental_room.query.HouseQuery;
import com.gxust.edu.rental_room.service.HouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HouseServiceImpl extends BaseServiceImpl<House, HouseQuery> implements HouseService {

    @Autowired
    public void setHouseMapper(HouseMapper houseMapper) {
        this.baseMapper = houseMapper;
    }

    public PageInfo<House> findAllRental(HouseQuery q) {
        PageInfo<House> pageInfo = null;
        if (q.isPaging()) {
            PageHelper.startPage(q.getCurrentPage(), q.getPageSize());
            Page<House> page = (Page<House>) ((HouseMapper)baseMapper).findAllRental(q);
            pageInfo = page.toPageInfo();
        } else {
            List<House> data = ((HouseMapper)baseMapper).findAllRental(q);
            pageInfo = new PageInfo<>();
            pageInfo.setList(data);
        }
        return pageInfo;
    }
}
