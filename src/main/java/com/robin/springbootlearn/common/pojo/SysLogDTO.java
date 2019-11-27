package com.robin.springbootlearn.common.pojo;

import com.robin.springbootlearn.common.enums.RequestOptTypeEnum;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author robin
 * @depiction 系统操作日志
 * @version v0.0.1
 * @create 2019-11-27 23:48
 **/
@Data
public class SysLogDTO implements Serializable {

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
