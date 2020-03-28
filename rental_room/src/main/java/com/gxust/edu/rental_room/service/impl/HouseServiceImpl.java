package com.gxust.edu.rental_room.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.gxust.edu.rental_room.domain.User;
import com.gxust.edu.rental_room.domain.YzInfo;
import com.gxust.edu.rental_room.mapper.HouseMapper;
import com.gxust.edu.rental_room.domain.House;
import com.gxust.edu.rental_room.mapper.UserMapper;
import com.gxust.edu.rental_room.mapper.YzInfoMapper;
import com.gxust.edu.rental_room.query.BaseQuery;
import com.gxust.edu.rental_room.query.HouseQuery;
import com.gxust.edu.rental_room.service.HouseService;
import com.gxust.edu.rental_room.vo.CheckedHouseVo;
import net.sf.jsqlparser.expression.operators.arithmetic.BitwiseOr;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class HouseServiceImpl extends BaseServiceImpl<House, HouseQuery> implements HouseService {

    @Autowired
    public void setHouseMapper(HouseMapper houseMapper) {
        this.baseMapper = houseMapper;
    }

    @Autowired
    YzInfoMapper yzInfoMapper;

    @Autowired
    UserMapper userMapper;

    @Override
    public PageInfo<House> findAllRental(HouseQuery q) {
        PageInfo<House> pageInfo = null;
        if (q.isPaging()) {
            PageHelper.startPage(q.getCurrentPage(), q.getPageSize());
            Page<House> page = (Page<House>) ((HouseMapper) baseMapper).findAllRental(q);
            pageInfo = page.toPageInfo();
        } else {
            List<House> data = ((HouseMapper) baseMapper).findAllRental(q);
            pageInfo = new PageInfo<>();
            pageInfo.setList(data);
        }
        return pageInfo;
    }

    @Override
    public PageInfo<House> findByQuery(HouseQuery houseQuery) {
        return super.findByQuery(houseQuery);
    }

    @Override
    public boolean updateStatus(Integer id, Boolean status) {
        int sta = status ? 1 : 0;
        return ((HouseMapper) baseMapper).updateStatus(id, sta) == 1;
    }

    @Override
    public boolean yzhouse(YzInfo yzInfo) {
        return yzInfoMapper.add(yzInfo) == 1;
    }

    @Override
    public List<House> findYzHouse(Integer userId) {
        return ((HouseMapper) baseMapper).findYzHouse(userId);
    }

    @Override
    public boolean cancelYzHouse(Integer userId, Integer houseId) {
        return yzInfoMapper.cancelYzHouse(userId, houseId) == 1;
    }

    @Override
    public List<House> findsuccessRentHouse(Integer userId) {
        return ((HouseMapper) baseMapper).findsuccessRentHouse(userId);
    }

    @Override
    public List<CheckedHouseVo> findCheckedHouse(Integer userId) {
        List<CheckedHouseVo> checkedHouse = new ArrayList<>();
        List<House> houses = ((HouseMapper) baseMapper).findCheckedHouse(userId);
        if (houses != null && houses.size() > 0) {
            for (House house : houses) {
                CheckedHouseVo checkedHouseVo = new CheckedHouseVo();
                Integer houseId = house.getId();
                List<User> users = userMapper.findUsersByLessorId(userId, houseId);
                checkedHouseVo.setHouse(house);
                checkedHouseVo.setUsers(users);
                checkedHouse.add(checkedHouseVo);
            }
        }
        return checkedHouse;
    }

}
