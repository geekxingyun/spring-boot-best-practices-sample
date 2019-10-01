drop table T_CUSTOMER if exists;
drop sequence if exists HIBERNATE_SEQUENCE;
create sequence HIBERNATE_SEQUENCE start with 1 increment by 1;
create table T_CUSTOMER (ID bigint not null, FIRST_NAME varchar(255) not null, LAST_NAME varchar(255) not null, primary key (ID));
