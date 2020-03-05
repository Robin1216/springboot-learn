package com.robin.springbootlearn.common.aspect;

import com.robin.springbootlearn.app.service.UserOptLogService;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.PostConstruct;

/**
 * @author robin
 * @version v0.0.1
 * @depiction 用户操作日志切面
 * @create 2019-11-27 23:22
 **/
public class UserOptLogAspect {

    @Autowired
    private UserOptLogService userOptLogService;

    private static UserOptLogAspect userOptLogAspect;

    @PostConstruct
    public void init() {
        userOptLogAspect = this;
        userOptLogAspect.userOptLogService = this.userOptLogService;
    }



}
