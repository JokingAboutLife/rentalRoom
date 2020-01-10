package com.gxust.edu.rental_room.service;

import com.github.pagehelper.PageInfo;
import com.gxust.edu.rental_room.domain.BaseDomain;
import com.gxust.edu.rental_room.query.BaseQuery;

public interface BaseService<T extends BaseDomain, Q extends BaseQuery> {
    T findById(int id);

    PageInfo<T> findByQuery(Q q);

    boolean add(T t);

    boolean update(T t);

    boolean deleteById(int id);

    boolean deleteByIds(int[] ids);
}
