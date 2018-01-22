package com.td.truck.service.impl;

import com.td.truck.model.Comment;
import com.td.truck.dao.CommentDao;
import com.td.truck.service.CommentService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author King
 * @since 2017-12-14
 */
@Service
public class CommentServiceImpl extends ServiceImpl<CommentDao, Comment> implements CommentService {

}
