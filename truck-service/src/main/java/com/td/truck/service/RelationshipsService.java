package com.td.truck.service;

import com.baomidou.mybatisplus.service.IService;
import com.td.truck.model.Relationships;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author King
 * @since 2017-12-03
 */
public interface RelationshipsService extends IService<Relationships> {
    List<Relationships> findAllByCid(Long cid);

    List<Relationships> findAllByMid(Long mid);

    void deleteByCidAndType(Long cid,String type);

    void deleteByCid(Long cid);
}
