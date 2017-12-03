package com.td.truck.service.impl;

import com.td.truck.model.Content;
import com.td.truck.dao.ContentDao;
import com.td.truck.service.ContentService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author King
 * @since 2017-12-03
 */
@Service
public class ContentServiceImpl extends ServiceImpl<ContentDao, Content> implements ContentService {
	
}
