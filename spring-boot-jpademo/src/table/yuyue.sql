/*
 Navicat Premium Data Transfer

 Source Server         : s01
 Source Server Type    : MySQL
 Source Server Version : 50725
 Source Host           : localhost:3306
 Source Schema         : db_hysyy

 Target Server Type    : MySQL
 Target Server Version : 50725
 File Encoding         : 65001

 Date: 28/03/2019 10:02:51
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for yuyue
-- ----------------------------
DROP TABLE IF EXISTS `yuyue`;
CREATE TABLE `yuyue`  (
  `id` int(10) UNSIGNED ZEROFILL NOT NULL AUTO_INCREMENT,
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  `room` int(10) NULL DEFAULT NULL,
  `neirong` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  `datetime` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 9 CHARACTER SET = utf8 COLLATE = utf8_bin ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of yuyue
-- ----------------------------
INSERT INTO `yuyue` VALUES (0000000001, '申兴龙', 1523, '1', '2019050108');
INSERT INTO `yuyue` VALUES (0000000002, '温厚', 1021, '2', '2019050208');
INSERT INTO `yuyue` VALUES (0000000003, '申兴龙', 1513, '3', '2019050208');
INSERT INTO `yuyue` VALUES (0000000004, '温厚', 1523, '4', '2019040208');
INSERT INTO `yuyue` VALUES (0000000006, '温厚', 1019, '6', '2019060208');
INSERT INTO `yuyue` VALUES (0000000007, '申兴龙', 1513, '999', '2019032911');
INSERT INTO `yuyue` VALUES (0000000008, '申兴龙', 1513, 'qqqqq', '2019050110');

SET FOREIGN_KEY_CHECKS = 1;
