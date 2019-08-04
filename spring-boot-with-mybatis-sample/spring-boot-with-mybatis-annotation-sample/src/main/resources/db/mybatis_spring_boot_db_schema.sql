/*
 Navicat Premium Data Transfer

 Source Server         : localhost_mysql
 Source Server Type    : MySQL
 Source Server Version : 80016
 Source Host           : localhost:3306
 Source Schema         : mybatis_spring_boot_db

 Target Server Type    : MySQL
 Target Server Version : 80016
 File Encoding         : 65001

 Date: 03/08/2019 20:52:04
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for t_user_info
-- ----------------------------
DROP TABLE IF EXISTS `t_user_info`;
CREATE TABLE `t_user_info`  (
  `USER_INFO_ID` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '用户信息主键',
  `USER_INFO_ACCOUNT` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '用户信息账号',
  `USER_INFO_PASSWORD` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '用户信息密码',
  `USER_INFO_AGE` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '用户信息年龄',
  `USER_INFO_SEX` tinyint(1) NULL DEFAULT NULL COMMENT '用户信息性别1 为男 0 为女',
  PRIMARY KEY (`USER_INFO_ID`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci ROW_FORMAT = Dynamic;

SET FOREIGN_KEY_CHECKS = 1;
