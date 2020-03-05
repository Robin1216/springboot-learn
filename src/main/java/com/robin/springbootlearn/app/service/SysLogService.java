package com.robin.springbootlearn.app.service;

import com.robin.springbootlearn.app.entity.UserOptLog;

/**
 * @author silkNets
 * @program springboot-learn
 * @description 系统日志服务接口
 * @createDate 2020-03-03 08:21
 */
public interface SysLogService {

    boolean saveLog(UserOptLog userOptLog);
}