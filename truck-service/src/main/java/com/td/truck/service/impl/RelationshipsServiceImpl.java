package com.td.truck.service.impl;

import com.td.truck.model.Relationships;
import com.td.truck.dao.RelationshipsDao;
import com.td.truck.service.RelationshipsService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author King
 * @since 2017-12-03
 */
@Service
public class RelationshipsServiceImpl extends ServiceImpl<RelationshipsDao, Relationships> implements RelationshipsService {

    @Override
    public List<Relationships> findAllByCid(Long cid) {
        return null;
    }

    @Override
    public List<Relationships> findAllByMid(Long mid) {
        return null;
    }

    @Override
    public void deleteByCidAndType(Long cid, String type) {

    }

    @Override
    public void deleteByCid(Long cid) {

    }
}
