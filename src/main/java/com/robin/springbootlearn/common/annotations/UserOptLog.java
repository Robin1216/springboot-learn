package com.robin.springbootlearn.common.annotations;

import java.lang.annotation.*;

/**
 * 用户操作日志注解
 *
 * @author robin
 * @version v0.0.1
 * @create 2020-03-03 08:51
 */
@Documented
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public  @interface UserOptLog {

    String remark() default "";
}