drop table T_PRODUCT if exists;
drop table T_PRODUCT_COMMENT if exists;
drop table T_USER_INFO if exists;
drop sequence if exists HIBERNATE_SEQUENCE;
create sequence HIBERNATE_SEQUENCE start with 1 increment by 1;
-- 商品表
create table T_PRODUCT (ID bigint not null, COVER_IMAGE varchar(255), PRODUCT_NAME varchar(255), PRODUCT_PRICE integer not null, primary key (ID));
-- 商品评论表
create table T_PRODUCT_COMMENT (ID bigint not null, AUTHOR_ID bigint, CONTENT varchar(255), CREATED timestamp, PRODUCT_ID bigint, primary key (ID));
-- 用户表
create table T_USER_INFO (ID bigint not null, AVATAR varchar(255), NICK_NAME varchar(255), primary key (ID));