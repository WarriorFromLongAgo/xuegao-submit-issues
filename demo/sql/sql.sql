create database if not exists xue_gao_write_and_use;
use xue_gao_write_and_use;

create table user_info_test
(
    id          int auto_increment,
    username    varchar(128)                         null,
    password    varchar(128)                         null,
    del_flag    tinyint(1) default 1                 null comment '0已删除，1默认值，未删除',
    create_by   varchar(32)                          null,
    create_time datetime   default CURRENT_TIMESTAMP null,
    update_by   varchar(32)                          null,
    update_time datetime   default CURRENT_TIMESTAMP null,
    trace_id    varchar(32)                          null,
    primary key (id)
) engine = InnoDB;