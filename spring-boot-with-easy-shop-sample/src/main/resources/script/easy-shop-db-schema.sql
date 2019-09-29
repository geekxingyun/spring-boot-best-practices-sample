drop table if exists T_PRODUCT;
drop table if exists T_PRODUCT_COMMENT;
drop table if exists T_USER;

-- 商品表
create table T_PRODUCT
(
   ID                   bigint(20) unsigned not null auto_increment comment '主键',
   NAME                 varchar(100) comment '商品名称',
   COVER_IMAGE          varchar(100) comment '商品封面图片',
   PRICE                int not null default 0 comment '商品价格(分)',
   primary key (ID)
);
-- 商品评论表
create table T_PRODUCT_COMMENT
(
   ID                   bigint(20) unsigned not null auto_increment comment '主键',
   PRODUCT_ID           bigint(20) unsigned comment '所属商品',
   AUTHOR_ID            bigint(20) unsigned comment '作者Id',
   CONTENT              varchar(200) comment '评论内容',
   CREATED              TIMESTAMP comment '创建时间',
   primary key (ID)
);
-- 用户表
create table T_USER
(
   ID                   bigint(20) unsigned not null auto_increment comment '主键',
   NICK_NAME            varchar(50) comment '用户昵称',
   AVATAR               varchar(255) comment '用户头像',
   primary key (ID)
);