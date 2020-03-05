package com.robin.springbootlearn.common.enums;

/**
 * @author robin
 * @version v0.0.1
 * @Description 系统平台枚举值
 * @create 2020-03-03 08:33
 */
public enum SysPlatformEnum {

    PC("10001", "PC"),
    app_android("20001", "app安卓"),
    app_IOS("20002", "appIOS"),
    app_windows("20003", "appWindows"),
    applet_WeChat("30001", "微信小程序"),
    applet_Alipay("30002", "支付宝小程序"),
    applet_Baidu("30003", "百度小程序");


    /**
     * 英文 code
     */
    private String code;

    /**
     * 中文 描述
     */
    private String desc;

    public String getCode() {
        return code;
    }

    public String getDesc() {
        return desc;
    }

    SysPlatformEnum(String code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    private SysPlatformEnum getByCode(String code) {
        for (SysPlatformEnum typeEnum : SysPlatformEnum.values()) {
            if (typeEnum.code.equals(code)) {
                return typeEnum;
            }
        }
        return null;
    }
}