package com.robin.springbootlearn.app.entity;

import com.robin.springbootlearn.common.entity.SuperEntity;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.Version;
import java.time.LocalDateTime;
import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 通过导入的用户表格
 * </p>
 *
 * @author robin
 * @since 2020-04-06
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@TableName("t_user")
public class UserEntity extends SuperEntity {

    private static final long serialVersionUID = 1L;

    @TableField("f_mobile")
    private String mobile;

    @TableField("f_user_name")
    private String userName;

    @TableField("f_nickname")
    private String nickname;

    @TableField("f_icon_url")
    private String iconUrl;

    @TableField("f_password")
    private String password;

    @TableField("f_country_code")
    private String countryCode;

    @TableField("f_email")
    private String email;

    @TableField("f_platform")
    private String platform;

    @TableField("f_equipment_id")
    private String equipmentId;

    @TableField("f_enable")
    private Boolean enable;

    @TableField("f_ctime")
    private LocalDateTime ctime;

    @TableField("f_utime")
    private LocalDateTime utime;

    @TableField("f_old_user_id")
    private String oldUserId;

    @TableField("f_source")
    private String source;

    @TableField("f_gender")
    private String gender;

    @TableField("f_birthday")
    private LocalDateTime birthday;

    @TableField("f_inviter_id")
    private String inviterId;

    @TableField("f_activity_flag")
    private String activityFlag;

    @TableField("f_migrated")
    private Boolean migrated;

    /**
     * 是否为初始化状态，默认为 true，更新后则变为false
     */
    @TableField("f_init")
    private Boolean init;

    /**
     * 备注
     */
    @TableField("f_remark")
    private String remark;


    public static final String F_MOBILE = "f_mobile";

    public static final String F_USER_NAME = "f_user_name";

    public static final String F_NICKNAME = "f_nickname";

    public static final String F_ICON_URL = "f_icon_url";

    public static final String F_PASSWORD = "f_password";

    public static final String F_COUNTRY_CODE = "f_country_code";

    public static final String F_EMAIL = "f_email";

    public static final String F_PLATFORM = "f_platform";

    public static final String F_EQUIPMENT_ID = "f_equipment_id";

    public static final String F_ENABLE = "f_enable";

    public static final String F_CTIME = "f_ctime";

    public static final String F_UTIME = "f_utime";

    public static final String F_OLD_USER_ID = "f_old_user_id";

    public static final String F_SOURCE = "f_source";

    public static final String F_GENDER = "f_gender";

    public static final String F_BIRTHDAY = "f_birthday";

    public static final String F_INVITER_ID = "f_inviter_id";

    public static final String F_ACTIVITY_FLAG = "f_activity_flag";

    public static final String F_MIGRATED = "f_migrated";

    public static final String F_INIT = "f_init";

    public static final String F_REMARK = "f_remark";

}
