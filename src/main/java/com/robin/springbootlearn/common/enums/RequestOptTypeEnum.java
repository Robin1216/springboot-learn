package com.robin.springbootlearn.common.enums;

/**
 * @author robin
 * @version v0.0.1
 * @depiction 请求操作类型枚举值
 * @create 2019-11-27 23:33
 **/
public enum RequestOptTypeEnum {

    CREATE("CREATE", "添加"),
    READ("READ", "查询"),
    UPDATE("UPDATE", "更新"),
    DELETE("DELETE", "删除");


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

    RequestOptTypeEnum(String code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    private RequestOptTypeEnum getByCode(String code) {
        for (RequestOptTypeEnum typeEnum : RequestOptTypeEnum.values()) {
            if (typeEnum.code.equals(code)) {
                return typeEnum;
            }
        }
        return null;
    }
}
