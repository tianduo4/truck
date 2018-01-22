package com.td.truck.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.td.truck.dao.MetaDao;
import com.td.truck.kit.StringKit;
import com.td.truck.model.Meta;
import com.td.truck.service.MetaService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author King
 * @since 2017-12-14
 */
@Service
public class MetaServiceImpl extends ServiceImpl<MetaDao, Meta> implements MetaService {

    @Override
    public List<Meta> getMetas(String type) {
        if (StringKit.isNotBlank(type)) {
            EntityWrapper<Meta> ew=new EntityWrapper<Meta>();
            ew.where("ftype={0}",type)
              .orderBy("fsort",false).orderBy("fid",false);
            return selectList(ew);
        }
        return null;
    }
}
