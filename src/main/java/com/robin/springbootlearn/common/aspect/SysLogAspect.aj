package com.robin.springbootlearn.common.aspect;

import com.alibaba.fastjson.JSON;
import com.robin.springbootlearn.app.service.SysLogService;
import com.robin.springbootlearn.common.annotations.SysLog;
import com.robin.springbootlearn.common.pojo.SysLogDTO;
import com.robin.springbootlearn.utils.IPUtil;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.lang.reflect.Method;
import java.util.Date;

/**
 * @author robin
 * @depiction 系統日志切面，切入点和切入处理
 * @version v0.0.1
 * @create 2019-11-26 23:11
 **/
@Slf4j
@Aspect
@Component
@EnableAsync
public class SysLogAspect {

    @Autowired
    private SysLogService sysLogService;

    private static SysLogAspect sysLogAspect;

    // 启动时 sysLogService 可能没有被实例化，显示进行实例化
    @PostConstruct
    public void init() {
        sysLogAspect = this;
        sysLogAspect.sysLogService = this.sysLogService;
    }


    // 日志切入点，在注解的位置切入代码
    @Pointcut("@annotation(com.robin.springbootlearn.common.annotations.SysLog)")
    public void sysLogPointCut() {
    }

    // 切面，配置通知
    @Around("@annotation(com.robin.springbootlearn.common.annotations.SysLog)")
    public void doAfter(ProceedingJoinPoint pjp) {
        log.error("请求结束");
    }

    // 后置通知
    @AfterReturning("sysLogPointCut()")
    public void sysNotic(JoinPoint pjp) {
        log.info("切面 sysLogDTO");

        // 从切面织入点处通过反射机制获取织入点处的方法
        Signature signature = pjp.getSignature();
        if (!(signature instanceof MethodSignature)) {
            throw new IllegalArgumentException("SysLog 注解只能用于方法");
        }

        // 获取切入点所在的方法
        MethodSignature methodSignature = (MethodSignature) signature;
        Method method = methodSignature.getMethod();

        // 获取注解的内容
        SysLog sysLog = method.getAnnotation(SysLog.class);
        if (sysLog != null) {
            SysLogDTO sysLogDTO = new SysLogDTO();

            sysLogDTO.setOptType(sysLog.optType());
            sysLogDTO.setOptName(sysLog.optName());
            sysLogDTO.setModuleName(sysLog.moduleName());
            sysLogDTO.setDetail(sysLog.detail());
            sysLogDTO.setResult(true);

            String ip = IPUtil.getIpAddress();
            sysLogDTO.setIp(ip);

            sysLogDTO.setCreateDate(new Date());

            log.info("切面 sysLogDTO --> {}", JSON.toJSONString(sysLogDTO));

            // 获取请求的类名
            String className = pjp.getTarget().getClass().getName();
            // 获取请求的方法名
            String methodName = method.getName();

            // 请求的参数,将参数所在的数组转换成json
            Object[] args = pjp.getArgs();
            String params = JSON.toJSONString(args);


            // 调用service保存SysLog实体类到数据库
            // sysLogService.save(sysLog);
        }
//        return "success";
    }

    // 记录异常时的日志，便于后期分析
    @AfterThrowing(value = "sysLogPointCut()", throwing = "e")
    private void afterThrowing(JoinPoint jp, Throwable e) {
        try {
            String detail = e.getMessage();
            saveNewLogRecord(jp, false, detail);
        } catch (Throwable exception) {
            log.error("保存请求异常后的用户操作日志失败", exception);
        }
    }


    private void saveNewLogRecord(JoinPoint jp, boolean result, String detail) {
        // 从切面织入点处通过反射机制获取织入点处的方法
        Signature signature = jp.getSignature();
        if (!(signature instanceof MethodSignature)) {
            throw new IllegalArgumentException("UserOptLogHandler 注解只能用于方法");
        }

        // 获取注解的内容
        MethodSignature methodSignature = (MethodSignature) signature;
        Method method = methodSignature.getMethod();
        SysLog optLogHandler = method.getAnnotation(SysLog.class);
        if (optLogHandler != null) {

            String methodName = method.getName();
            // 请求的参数,将参数所在的数组转换成json

        }
    }
}
