package com.gxust.edu.rental_room.mapper;

import com.gxust.edu.rental_room.domain.BaseDomain;
import com.gxust.edu.rental_room.query.BaseQuery;

import java.util.List;

public interface BaseMapper<T extends BaseDomain, Q extends BaseQuery> {
    T findById(int id);

    List<T> findByQuery(Q q);

    int add(T t);

    int update(T t);

    int deleteById(int id);

    int deleteByIds(int[] ids);
}
