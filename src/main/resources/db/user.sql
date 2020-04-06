
/*==============================================================*/
/* Table: t_user                                               */
/*==============================================================*/
drop table if exists t_user;
create table t_user
(
   f_id                 bigint not null auto_increment,
   f_mobile             varchar(16) not null,
   f_user_name          varchar(64),
   f_nickname           varchar(64),
   f_icon_url           varchar(256),
   f_password           varchar(256),
   f_country_code       varchar(64),
   f_email              varchar(64),
   f_platform           varchar(32),
   f_equipment_id       varchar(64),
   f_enable             tinyint(1) not null,
   f_ctime              datetime not null,
   f_utime              datetime not null,
   f_old_user_id        varchar(64),
   f_source             varchar(64),
   f_gender             varchar(32),
   f_birthday           datetime,
   f_inviter_id         varchar(64),
   f_activity_flag      varchar(32),
   f_migrated           tinyint(1) not null,
   f_init               tinyint(1) not null default 1 comment '是否为初始化状态，默认为 true，更新后则变为false',
   f_created_by_name    varchar(36) comment '创建人名称',
   f_created_by_id      varchar(36) comment '创建人id',
   f_created_at         timestamp not null default CURRENT_TIMESTAMP comment '创建时间',
   f_last_updated_by_name varchar(36) comment '最后更新人名称',
   f_last_updated_by_id varchar(36) comment '最后更新人id',
   f_last_updated_at    timestamp not null default CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP comment '最后更新时间',
   f_remark             varchar(255) comment '备注',
   f_deleted            int not null default 0 comment '删除标记',
   f_version            int not null default 0 comment '版本',
   primary key (f_id),
   unique key AK_key_country_code_mobile (f_mobile, f_country_code)
)
ENGINE = InnoDB;
alter table t_user comment '通过导入的用户表格';


