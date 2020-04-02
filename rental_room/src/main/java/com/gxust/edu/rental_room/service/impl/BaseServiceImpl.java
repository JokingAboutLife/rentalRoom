package com.gxust.edu.rental_room.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.gxust.edu.rental_room.mapper.BaseMapper;
import com.gxust.edu.rental_room.domain.BaseDomain;
import com.gxust.edu.rental_room.exception.ExceptionKind;
import com.gxust.edu.rental_room.exception.KPException;
import com.gxust.edu.rental_room.mapper.PermissionMapper;
import com.gxust.edu.rental_room.query.BaseQuery;
import com.gxust.edu.rental_room.service.BaseService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class BaseServiceImpl<T extends BaseDomain, Q extends BaseQuery> implements BaseService<T, Q> {

    protected BaseMapper<T, Q> baseMapper;

    @Override
    public T findById(int id) {
        return baseMapper.findById(id);
    }

    @Override
    public PageInfo<T> findByQuery(Q q) {
        PageInfo<T> pageInfo = null;
        if (q.isPaging()) {
            PageHelper.startPage(q.getCurrentPage(), q.getPageSize());
            Page<T> page = (Page<T>) baseMapper.findByQuery(q);
            pageInfo = page.toPageInfo();
        } else {
            List<T> data = baseMapper.findByQuery(q);
            pageInfo = new PageInfo<>();
            pageInfo.setList(data);
        }
        return pageInfo;
    }

    @Override
    public boolean add(T t) {
        return baseMapper.add(t) == 1;
    }

    @Override
    public boolean update(T t) {
        return baseMapper.update(t) == 1;
    }

    @Transactional
    @Override
    public boolean deleteById(int id) {
        ((PermissionMapper)baseMapper).deleteRolePermById(id);
        boolean result = baseMapper.deleteById(id) == 1;
        return result;
    }

    @Override
    public boolean deleteByIds(int[] ids) {
        int realCount = baseMapper.deleteByIds(ids);
        if (realCount != ids.length) {
            throw new KPException(ExceptionKind.PARAM_E);
        }
        return true;
    }
}
