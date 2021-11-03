/*
 Navicat Premium Data Transfer

 Source Server         : test
 Source Server Type    : MySQL
 Source Server Version : 80021
 Source Host           : localhost:3306
 Source Schema         : mcj010

 Target Server Type    : MySQL
 Target Server Version : 80021
 File Encoding         : 65001

 Date: 03/11/2021 21:17:00
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for dept
-- ----------------------------
DROP TABLE IF EXISTS `dept`;
CREATE TABLE `dept`  (
  `deptno` int(0) NOT NULL,
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `loc` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`deptno`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of dept
-- ----------------------------
INSERT INTO `dept` VALUES (1, 'hsbc', 'gz');
INSERT INTO `dept` VALUES (2, 'wealth', 'gz');

-- ----------------------------
-- Table structure for emp
-- ----------------------------
DROP TABLE IF EXISTS `emp`;
CREATE TABLE `emp`  (
  `EMPNO` int(0) NOT NULL,
  `ENAME` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `JOB` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `MGR` int(0) NULL DEFAULT NULL,
  `HIREDATE` datetime(0) NULL DEFAULT NULL,
  `SAL` int(0) NULL DEFAULT NULL,
  `COMM` int(0) NULL DEFAULT NULL,
  `DEPTNO` int(0) NULL DEFAULT NULL,
  PRIMARY KEY (`EMPNO`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of emp
-- ----------------------------
INSERT INTO `emp` VALUES (1, 'suzan', 'tech lead', NULL, '2021-09-17 16:31:28', 1000, NULL, 1);
INSERT INTO `emp` VALUES (2, 'jack', 'front end', 1, '2021-09-17 00:00:00', 1000, 500, 2);

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `id` int(0) NOT NULL,
  `user_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (1, 'zen');
INSERT INTO `user` VALUES (2, 'jack');
INSERT INTO `user` VALUES (3, 'ken');

SET FOREIGN_KEY_CHECKS = 1;
