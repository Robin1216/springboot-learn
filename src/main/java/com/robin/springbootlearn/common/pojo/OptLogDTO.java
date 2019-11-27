package com.robin.springbootlearn.common.pojo;

import com.robin.springbootlearn.common.enums.RequestOptTypeEnum;

import java.io.Serializable;
import java.util.Date;

/**
 * @author robin
 * @version v0.0.1
 * @depiction 用户操作日志
 * @create 2019-11-28 0:04
 **/
public class OptLogDTO implements Serializable {

    /**
     * 记录 id
     */
    private Long id;

    /**
     * 操作类型
     */
    private RequestOptTypeEnum optType;

    /**
     * 操作名
     */
    private String optName;

    /**
     * 模块名
     */
    private String moduleName;

    /**
     * 用户ID
     */
    private String userId;

    /**
     * 用户名
     */
    private String userName;

    /**
     * 明细
     */
    private String detail;

    /**
     * 操作结果 true 成功、false 失败
     */
    private Boolean result;

    /**
     * 操作时间
     */
    private Date createDate;
}
