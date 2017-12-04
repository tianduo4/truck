package com.td.truck.service;

import com.td.truck.model.Metas;
import com.baomidou.mybatisplus.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author King
 * @since 2017-12-03
 */
public interface MetasService extends IService<Metas> {
    List<Metas> findByType(String type);

    Metas findByNameAndType(String name,String type);
}
