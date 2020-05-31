/*
 Navicat Premium Data Transfer

 Source Server         : localdb
 Source Server Type    : MySQL
 Source Server Version : 50718
 Source Host           : localhost:3306
 Source Schema         : alpha1991

 Target Server Type    : MySQL
 Target Server Version : 50718
 File Encoding         : 65001

 Date: 31/05/2020 11:50:34
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for core_dict
-- ----------------------------
DROP TABLE IF EXISTS `core_dict`;
CREATE TABLE `core_dict`  (
  `ID` int(8) NOT NULL AUTO_INCREMENT,
  `VALUE` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `NAME` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `TYPE` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `TYPE_NAME` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `REMARK` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `SORT` int(8) NULL DEFAULT NULL,
  `PARENT` int(8) NULL DEFAULT NULL,
  `CREATE_TIME` datetime(0) NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP(0),
  `DEL_FLAG` int(1) NULL DEFAULT NULL,
  PRIMARY KEY (`ID`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 8 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of core_dict
-- ----------------------------
INSERT INTO `core_dict` VALUES (1, '1', '1', '1', '1', '1', 1, 1, '2020-05-30 08:13:08', 1);
INSERT INTO `core_dict` VALUES (2, '2', '2', '2', '2', '2', 2, 2, '2020-05-30 08:13:41', 1);
INSERT INTO `core_dict` VALUES (3, 'a', 'a', 'a', 'a', 'a', 3, 3, '2020-05-30 08:14:02', 1);
INSERT INTO `core_dict` VALUES (4, 'b', 'b', 'b', 'b', 'b', 4, 4, '2020-05-30 08:14:22', 1);
INSERT INTO `core_dict` VALUES (5, 'c', 'c', 'c', 'c', 'c', 5, 5, '2020-05-30 08:14:32', 1);
INSERT INTO `core_dict` VALUES (6, '3', '3', '3', '3', '3', 3, 3, '2020-05-30 08:14:44', 1);
INSERT INTO `core_dict` VALUES (7, '4', '4', '4', '4', '4', 4, 4, '2020-05-30 08:14:54', 1);

SET FOREIGN_KEY_CHECKS = 1;
