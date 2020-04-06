package com.robin.springbootlearn.common.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.robin.springbootlearn.common.entity.SuperEntity;
import com.robin.springbootlearn.common.mapper.SuperMapper;

/**
 * 公共服务实现，使用 mybatis-plus 代码生成工具
 *
 * @author robin
 * @version v0.0.1
 * @since 2020-04-06 17:26
 */
public class SuperServiceImpl<P extends SuperMapper<T>, T extends SuperEntity> extends ServiceImpl<P, T> {
}