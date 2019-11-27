package com.robin.springbootlearn.common.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.stereotype.Component;

/**
 * @author robin
 * @depiction 系統日志切面，切入点和切入处理
 * @version v0.0.1
 * @create 2019-11-26 23:11
 **/
@Aspect
@Component
@EnableAsync
public class SysLogAspect {

//    @Autowired
//    private SysLogService sysLogService;

    /**
     * 日志切入点
     */
    @Pointcut("@annotation(com.robin.springbootlearn.common.annotations.SysLog)")
    public void logPointCut() {
    }


    @AfterReturning(pointcut = "logPointCut()")
    public void doAfter(JoinPoint joinPoint){

    }
}
