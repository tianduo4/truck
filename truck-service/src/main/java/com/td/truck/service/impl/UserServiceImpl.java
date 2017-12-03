package com.td.truck.service.impl;

import com.td.truck.model.User;
import com.td.truck.dao.UserDao;
import com.td.truck.service.UserService;
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
public class UserServiceImpl extends ServiceImpl<UserDao, User> implements UserService {
	
}
