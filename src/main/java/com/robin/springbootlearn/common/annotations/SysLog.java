package com.robin.springbootlearn.common.annotations;

import com.robin.springbootlearn.common.enums.RequestOptTypeEnum;

import java.lang.annotation.*;

/**
 * @author robin
 * @version v0.0.1
 * @depiction
 * @create 2019-11-27 23:57
 **/
@Target(ElementType.METHOD)  //注解放置的目标位置,METHOD是可注解在方法级别上
@Retention(RetentionPolicy.RUNTIME)  //注解在哪个阶段执行
@Documented //生成文档
public @interface SysLog {

    /**
     * 操作类型
     */
    RequestOptTypeEnum optType();

    /**
     * 操作名
     */
    String optName();

    /**
     * 明细
     */
    String detail();
}
