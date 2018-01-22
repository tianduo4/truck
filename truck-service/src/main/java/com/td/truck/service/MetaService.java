package com.td.truck.service;

import com.td.truck.model.Meta;
import com.baomidou.mybatisplus.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author King
 * @since 2017-12-14
 */
public interface MetaService extends IService<Meta> {

    /**
     * 根据类型查询项目列表
     *
     * @param type 类型，tag or category
     */
    List<Meta> getMetas(String type);

}
