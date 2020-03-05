package com.robin.springbootlearn.common.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * @author silkNets
 * @program springboot-learn
 * @descrition 全局异常处理
 * @createDate 2020-02-27 22:26
 */
@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public Object globalExceptionHandler(HttpServletRequest request,Exception e) throws Exception{

        return "全局异常处理";
    }
}