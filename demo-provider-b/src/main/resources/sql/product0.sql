/*
 Navicat Premium Data Transfer

 Source Server         : localhost
 Source Server Type    : MySQL
 Source Server Version : 50732
 Source Host           : localhost:3306
 Source Schema         : product0

 Target Server Type    : MySQL
 Target Server Version : 50732
 File Encoding         : 65001

 Date: 30/12/2020 12:37:19
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for product0
-- ----------------------------
DROP TABLE IF EXISTS `product0`;
CREATE TABLE `product0` (
  `id` int(11) NOT NULL,
  `price` decimal(10,2) DEFAULT NULL,
  `stock` int(10) DEFAULT NULL,
  `last_update_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of product0
-- ----------------------------
BEGIN;
INSERT INTO `product0` VALUES (2, 100.00, 9995, '2020-12-26 21:31:57');
COMMIT;

-- ----------------------------
-- Table structure for product1
-- ----------------------------
DROP TABLE IF EXISTS `product1`;
CREATE TABLE `product1` (
  `id` int(11) NOT NULL,
  `price` decimal(10,2) DEFAULT NULL,
  `stock` int(10) DEFAULT NULL,
  `last_update_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of product1
-- ----------------------------
BEGIN;
INSERT INTO `product1` VALUES (3, 100.00, 9995, '2020-12-26 21:31:57');
COMMIT;

-- ----------------------------
-- Table structure for undo_log
-- ----------------------------
DROP TABLE IF EXISTS `undo_log`;
CREATE TABLE `undo_log` (
  `branch_id` bigint(20) NOT NULL COMMENT 'branch transaction id',
  `xid` varchar(100) NOT NULL COMMENT 'global transaction id',
  `context` varchar(128) NOT NULL COMMENT 'undo_log context,such as serialization',
  `rollback_info` longblob NOT NULL COMMENT 'rollback info',
  `log_status` int(11) NOT NULL COMMENT '0:normal status,1:defense status',
  `log_created` datetime(6) NOT NULL COMMENT 'create datetime',
  `log_modified` datetime(6) NOT NULL COMMENT 'modify datetime',
  UNIQUE KEY `ux_undo_log` (`xid`,`branch_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='AT transaction mode undo table';

-- ----------------------------
-- Records of undo_log
-- ----------------------------
BEGIN;
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;
