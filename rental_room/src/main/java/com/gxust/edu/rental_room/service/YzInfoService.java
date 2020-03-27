package com.gxust.edu.rental_room.service;

import com.gxust.edu.rental_room.domain.YzInfo;
import com.gxust.edu.rental_room.query.YzInfoQuery;


public interface YzInfoService extends BaseService<YzInfo, YzInfoQuery> {
    int insertSelective(YzInfo record);

    YzInfo selectByPrimaryKey(Integer id);

    int updateByPrimaryKey(YzInfo record);
}
