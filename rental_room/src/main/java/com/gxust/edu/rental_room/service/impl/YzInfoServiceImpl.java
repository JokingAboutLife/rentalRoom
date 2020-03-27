package com.gxust.edu.rental_room.service.impl;

import com.gxust.edu.rental_room.query.YzInfoQuery;
import com.gxust.edu.rental_room.service.YzInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.gxust.edu.rental_room.mapper.YzInfoMapper;
import com.gxust.edu.rental_room.domain.YzInfo;

@Service
public class YzInfoServiceImpl extends BaseServiceImpl<YzInfo, YzInfoQuery> implements YzInfoService {

    @Autowired
    public void setUserMapper(YzInfoMapper tYzInfoMapper) {
        this.baseMapper = tYzInfoMapper;
    }

    public int insertSelective(YzInfo record) {
        return ((YzInfoMapper)baseMapper).insertSelective(record);
    }
    
    public YzInfo selectByPrimaryKey(Integer id) {
        return ((YzInfoMapper)baseMapper).selectByPrimaryKey(id);
    }

    
    public int updateByPrimaryKey(YzInfo record) {
        return ((YzInfoMapper)baseMapper).updateByPrimaryKey(record);
    }

}
