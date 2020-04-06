package com.robin.springbootlearn.common.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.robin.springbootlearn.common.entity.SuperEntity;

/**
 * 公共服务，使用 mybatis-plus 代码生成工具
 *
 * @author robin
 * @version v0.0.1
 * @create 2020-04-06 17:25
 */
public interface SuperService<T extends SuperEntity> extends IService<T> {
}