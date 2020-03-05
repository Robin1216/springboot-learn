package com.robin.springbootlearn.app.entity;

import com.robin.springbootlearn.common.enums.RequestOptTypeEnum;
import com.robin.springbootlearn.common.enums.SysPlatformEnum;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;

/**
 * @author robin
 * @description 系统日志实体类
 * @createDate 2020-03-03 08:22
 */
@Data
@Table(name = "user_opt_log")
public class SysLog {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 用户id
     */
    @Column(name = "user_id")
    private String userId;

    /**
     * 用户手机号
     */
    @Column(name = "mobile")
    private String mobile;

    /**
     * 用户昵称
     */
    @Column(name = "nickname")
    private String nickname;

    /**
     * 操作类型
     *
     * @see RequestOptTypeEnum
     */
    @Column(name = "opt_Type")
    private String optType;

    /**
     * 操作平台
     *
     * @see SysPlatformEnum
     */
    @Column(name = "opt_platform")
    private String optPlatform;

    /**
     * 客户端IP
     */
    @Column(name = "client_ip")
    private String clientIp;

    /**
     * 手机系统
     */
    @Column(name = "phone_system")
    private String phoneSystem;

    /**
     * 手机类型
     */
    @Column(name = "phone_model")
    private String phoneModel;

    /**
     * 调用的方法名
     */
    @Column(name = "method")
    private String method;

    /**
     * 结果：true 成功，false 失败
     */
    @Column(name = "result")
    private Boolean result;

    /**
     * 详情
     */
    @Column(name = "detail")
    private String detail;

    /**
     * 备注
     */
    @Column(name = "remark")
    private String remark;

    /**
     * 创建时间
     */
    @Column(name = "opt_time")
    private Date optTime;
}