package com.robin.springbootlearn.app.service.impl;

import com.robin.springbootlearn.app.entity.UserEntity;
import com.robin.springbootlearn.app.mapper.UserMapper;
import com.robin.springbootlearn.app.service.UserService;
import com.robin.springbootlearn.common.service.SuperServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 通过导入的用户表格 服务实现类
 * </p>
 *
 * @author robin
 * @since 2020-04-06
 */
@Service
public class UserServiceImpl extends SuperServiceImpl<UserMapper, UserEntity> implements UserService {

}
