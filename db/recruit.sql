/*
 Navicat Premium Data Transfer

 Source Server         : 本机
 Source Server Type    : MySQL
 Source Server Version : 80031 (8.0.31)
 Source Host           : localhost:3306
 Source Schema         : recruit

 Target Server Type    : MySQL
 Target Server Version : 80031 (8.0.31)
 File Encoding         : 65001

 Date: 21/04/2023 14:35:26
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for administrator
-- ----------------------------
DROP TABLE IF EXISTS `administrator`;
CREATE TABLE `administrator`  (
  `id` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `username` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `phone` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `password` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of administrator
-- ----------------------------
INSERT INTO `administrator` VALUES ('0390590296', '苏岚', '163-6798-3024', '6nnWlNhiSg');
INSERT INTO `administrator` VALUES ('0427323108', '金子异', '10-6214-5244', '7Oqcy7bQfx');
INSERT INTO `administrator` VALUES ('17550356278', 'qks', '17550356278', '$2a$10$AssIVX5jKHyKkHNzQfq6men6.vFjeNfh9seJ9kmcR2lIVNQejugba');
INSERT INTO `administrator` VALUES ('2474354110', '杨晓明', '28-4555-8643', 'XrU5DPxnqg');
INSERT INTO `administrator` VALUES ('4809074096', '李嘉伦', '198-9312-7195', 'Jy45mvwzgy');
INSERT INTO `administrator` VALUES ('6294642076', '贾秀英', '180-7890-6134', 'Qadq1EcAYh');
INSERT INTO `administrator` VALUES ('6714679947', '邓宇宁', '28-461-4064', 'UgT0q1gdTH');
INSERT INTO `administrator` VALUES ('7462438702', '孟璐', '189-5166-1960', 'KsANlLqybn');
INSERT INTO `administrator` VALUES ('8114053144', '石云熙', '10-7754-7784', '4RgPYC5GDe');
INSERT INTO `administrator` VALUES ('9076304024', '周詩涵', '154-9886-3133', 'CTYVIKiBEk');
INSERT INTO `administrator` VALUES ('9328189169', '唐震南', '760-7312-7147', 'AGqMRykHMH');

-- ----------------------------
-- Table structure for role
-- ----------------------------
DROP TABLE IF EXISTS `role`;
CREATE TABLE `role`  (
  `role_id` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `role_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `remark` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  PRIMARY KEY (`role_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of role
-- ----------------------------
INSERT INTO `role` VALUES ('1', 'root', '超级管理员');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `id` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `username` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `phone` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `password` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('0129986820', '任致远', '163-6798-3024', 'nS9SDWy2NG');
INSERT INTO `user` VALUES ('0801032646', '彭子异', '10-6214-5244', 'Wc3kXOXLtd');
INSERT INTO `user` VALUES ('17550356278', 'qks', '17550356278', '$2a$10$AssIVX5jKHyKkHNzQfq6men6.vFjeNfh9seJ9kmcR2lIVNQejugba');
INSERT INTO `user` VALUES ('2329268743', '石詩涵', '28-4555-8643', '6t8TLI0hDG');
INSERT INTO `user` VALUES ('2943875000', '崔秀英', '198-9312-7195', 'czCybtyzgd');
INSERT INTO `user` VALUES ('5294182442', '周璐', '180-7890-6134', '8RbGNo9Vu1');
INSERT INTO `user` VALUES ('5521031605', '莫致远', '28-461-4064', '5qPaZZDWrg');
INSERT INTO `user` VALUES ('6271443830', '廖岚', '189-5166-1960', 'ey7HIBOhLe');
INSERT INTO `user` VALUES ('7791494288', '梁杰宏', '10-7754-7784', 'pTwe7dfYZh');
INSERT INTO `user` VALUES ('8061041060', '莫嘉伦', '154-9886-3133', 'i5oNjjP90I');
INSERT INTO `user` VALUES ('8734034245', '胡岚', '760-7312-7147', 'P24hDpIO24');

-- ----------------------------
-- Table structure for user_role
-- ----------------------------
DROP TABLE IF EXISTS `user_role`;
CREATE TABLE `user_role`  (
  `id` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `user_id` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `role_id` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user_role
-- ----------------------------
INSERT INTO `user_role` VALUES ('0390590299', '0390590296', '1');
INSERT INTO `user_role` VALUES ('0390590384', '0390590296', '2');

SET FOREIGN_KEY_CHECKS = 1;
