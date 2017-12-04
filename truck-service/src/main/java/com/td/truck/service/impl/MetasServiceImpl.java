package com.td.truck.service.impl;

import com.td.truck.model.Metas;
import com.td.truck.dao.MetasDao;
import com.td.truck.service.MetasService;
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
public class MetasServiceImpl extends ServiceImpl<MetasDao, Metas> implements MetasService {

    @Override
    public List<Metas> findByType(String type) {
        return null;
    }

    @Override
    public Metas findByNameAndType(String name, String type) {
        return null;
    }
}
