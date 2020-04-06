DROP TABLE if EXISTS t_user;
CREATE TABLE `t_user` (
  `f_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `f_name` varchar(64) DEFAULT NULL COMMENT '用户名',
  `f_password` varchar(256) DEFAULT NULL COMMENT '密码',
  `f_nickname` varchar(64) DEFAULT NULL COMMENT '用户昵称',
  `f_head_portrait` varchar(256) DEFAULT NULL COMMENT '用户头像',
  `f_country_code` varchar(64) DEFAULT NULL COMMENT '国家编码',
  `f_mobile` varchar(16) NOT NULL COMMENT '用户手机号',
  `f_email` varchar(64) DEFAULT NULL COMMENT '邮箱',
  `f_platform` varchar(32) DEFAULT NULL COMMENT '平台',
  `f_equipment_id` varchar(64) DEFAULT NULL COMMENT '设备id',
  `f_enable` tinyint(1) NOT NULL COMMENT '是否可用',
  `f_gender` varchar(32) DEFAULT NULL COMMENT '性别',
  `f_birthday` datetime DEFAULT NULL COMMENT '生日',
  `f_created_by_name` varchar(36) DEFAULT NULL COMMENT '创建人名称',
  `f_created_by_id` varchar(36) DEFAULT NULL COMMENT '创建人id',
  `f_created_at` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `f_last_updated_by_name` varchar(36) DEFAULT NULL COMMENT '最后更新人名称',
  `f_last_updated_by_id` varchar(36) DEFAULT NULL COMMENT '最后更新人id',
  `f_last_updated_at` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '最后更新时间',
  `f_remark` varchar(255) DEFAULT NULL COMMENT '备注',
  `f_deleted` int(11) NOT NULL DEFAULT '0' COMMENT '删除标记',
  `f_version` int(11) NOT NULL DEFAULT '0' COMMENT '版本',
  PRIMARY KEY (`f_id`),
  UNIQUE KEY `AK_key_country_code_mobile` (`f_mobile`,`f_country_code`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='用户信息表';


DROP TABLE if EXISTS t_role;
CREATE TABLE `t_role` (
  `f_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `f_name` varchar(64) DEFAULT NULL COMMENT '角色名',
  `f_created_by_name` varchar(36) DEFAULT NULL COMMENT '创建人名称',
  `f_created_by_id` varchar(36) DEFAULT NULL COMMENT '创建人id',
  `f_created_at` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `f_last_updated_by_name` varchar(36) DEFAULT NULL COMMENT '最后更新人名称',
  `f_last_updated_by_id` varchar(36) DEFAULT NULL COMMENT '最后更新人id',
  `f_last_updated_at` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '最后更新时间',
  `f_remark` varchar(255) DEFAULT NULL COMMENT '备注',
  `f_deleted` int(11) NOT NULL DEFAULT '0' COMMENT '删除标记',
  `f_version` int(11) NOT NULL DEFAULT '0' COMMENT '版本',
  PRIMARY KEY (`f_id`),
  UNIQUE KEY `AK_key_name` (`f_name`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='角色表';



DROP TABLE if EXISTS t_user_role;
CREATE TABLE `t_user_role` (
  `f_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `f_user_id` bigint(20) NOT NULL COMMENT '用户id',
  `f_role_id` bigint(20) NOT NULL  COMMENT '角色id',
  `f_created_by_name` varchar(36) DEFAULT NULL COMMENT '创建人名称',
  `f_created_by_id` varchar(36) DEFAULT NULL COMMENT '创建人id',
  `f_created_at` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `f_last_updated_by_name` varchar(36) DEFAULT NULL COMMENT '最后更新人名称',
  `f_last_updated_by_id` varchar(36) DEFAULT NULL COMMENT '最后更新人id',
  `f_last_updated_at` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '最后更新时间',
  `f_remark` varchar(255) DEFAULT NULL COMMENT '备注',
  `f_deleted` int(11) NOT NULL DEFAULT '0' COMMENT '删除标记',
  `f_version` int(11) NOT NULL DEFAULT '0' COMMENT '版本',
  PRIMARY KEY (`f_id`),
  UNIQUE KEY `AK_key_user_role_id` (`f_user_id`,`f_role_id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='用户角色映射表';

-- 外键约束
ALTER TABLE `t_user_role` ADD CONSTRAINT Fk_Reference_1 FOREIGN KEY ("f_role_id") REFERENCES `t_role` (`f_id`)
ON DELETE RESTRICT ON UPDATE RESTRICT ;

ALTER TABLE `t_user_role` ADD CONSTRAINT FK_Reference_2 FOREIGN KEY ("f_user_id") REFERENCES `t_user`(`f_id`)
ON DELETE RESTRICT ON UPDATE RESTRICT ;
