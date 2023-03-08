/*
 Navicat Premium Data Transfer

 Source Server         : test
 Source Server Type    : MySQL
 Source Server Version : 50538 (5.5.38)
 Source Host           : localhost:3306
 Source Schema         : dijia

 Target Server Type    : MySQL
 Target Server Version : 50538 (5.5.38)
 File Encoding         : 65001

 Date: 07/03/2023 20:37:51
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for kufang_guishu
-- ----------------------------
DROP TABLE IF EXISTS `kufang_guishu`;
CREATE TABLE `kufang_guishu`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '库房归属id',
  `kuqu_code` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '库区编码',
  `kufang_code` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '库房编码',
  `status` int(2) NULL DEFAULT NULL COMMENT '库房归属状态',
  `legalPerson_code` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '法人编码',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of kufang_guishu
-- ----------------------------

-- ----------------------------
-- Table structure for kufangshezhi
-- ----------------------------
DROP TABLE IF EXISTS `kufangshezhi`;
CREATE TABLE `kufangshezhi`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '库房id',
  `code` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '库房编码',
  `name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '库房名称',
  `remark` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '库房描述',
  `status` int(2) NULL DEFAULT NULL COMMENT '库房状态',
  `create_time` date NULL DEFAULT NULL COMMENT '创建时间',
  `create_pre` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '创建人',
  `update_time` date NULL DEFAULT NULL COMMENT '修改时间',
  `update_pre` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '修改人',
  `version` int(10) NOT NULL DEFAULT 0 COMMENT '版本号',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of kufangshezhi
-- ----------------------------

-- ----------------------------
-- Table structure for kuqu
-- ----------------------------
DROP TABLE IF EXISTS `kuqu`;
CREATE TABLE `kuqu`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '库区id',
  `code` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '库区编码',
  `name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '库区名称',
  `remark` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '库区描述',
  `status` int(2) NULL DEFAULT NULL COMMENT '库区状态',
  `create_time` date NULL DEFAULT NULL COMMENT '创建时间',
  `create_pre` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '创建人',
  `update_time` date NULL DEFAULT NULL COMMENT '修改时间',
  `update_pre` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '修改人',
  `version` int(10) NOT NULL DEFAULT 0 COMMENT '版本号',
  `kufang_code` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '库房编码',
  `guanli` int(2) NULL DEFAULT NULL COMMENT '实行库位管理',
  `wms` int(2) NULL DEFAULT NULL COMMENT '与WMS集成',
  `vip` int(2) NULL DEFAULT NULL COMMENT 'VIP库区',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of kuqu
-- ----------------------------

-- ----------------------------
-- Table structure for kuqu_kuqushuxing
-- ----------------------------
DROP TABLE IF EXISTS `kuqu_kuqushuxing`;
CREATE TABLE `kuqu_kuqushuxing`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '库区和库区属性中间表',
  `kuqu_code` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '库区编码',
  `kuqushuxing_code` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '库区属性编码',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of kuqu_kuqushuxing
-- ----------------------------

-- ----------------------------
-- Table structure for kuqushuxing
-- ----------------------------
DROP TABLE IF EXISTS `kuqushuxing`;
CREATE TABLE `kuqushuxing`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '库区属性id',
  `code` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '库区属性编码',
  `name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '库区属性名称',
  `remark` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '库区属性描述',
  `status` int(2) NULL DEFAULT NULL COMMENT '库区属性状态',
  `create_time` date NULL DEFAULT NULL COMMENT '创建时间',
  `create_pre` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '创建人',
  `update_time` date NULL DEFAULT NULL COMMENT '修改时间',
  `update_pre` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '修改人',
  `version` int(10) NOT NULL DEFAULT 0 COMMENT '版本号',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of kuqushuxing
-- ----------------------------

-- ----------------------------
-- Table structure for kuwei
-- ----------------------------
DROP TABLE IF EXISTS `kuwei`;
CREATE TABLE `kuwei`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '库位id',
  `code` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '库位编码',
  `name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '库位名称',
  `status` int(2) NULL DEFAULT NULL COMMENT '库位状态',
  `create_time` date NULL DEFAULT NULL COMMENT '创建时间',
  `create_pre` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '创建人',
  `update_time` date NULL DEFAULT NULL COMMENT '修改时间',
  `update_pre` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '修改人',
  `version` int(10) NOT NULL DEFAULT 0 COMMENT '版本号',
  `legalPerson_id` int(11) NULL DEFAULT NULL COMMENT '法人id',
  `kuqu_code` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '库区编码',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of kuwei
-- ----------------------------

-- ----------------------------
-- Table structure for legalperson
-- ----------------------------
DROP TABLE IF EXISTS `legalperson`;
CREATE TABLE `legalperson`  (
  `id` int(5) NOT NULL AUTO_INCREMENT COMMENT '法人id',
  `code` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '法人编码',
  `name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '法人名称',
  `createDate` datetime NULL DEFAULT NULL COMMENT '创建时间',
  `createPre` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '创建人',
  `updateDate` datetime NULL DEFAULT NULL COMMENT '修改时间',
  `updatePre` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '修改人',
  `version` int(10) NOT NULL DEFAULT 0 COMMENT '版本号',
  `user_id` int(10) NULL DEFAULT NULL COMMENT '用户id',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '法人表' ROW_FORMAT = Compact;

-- ----------------------------
-- Records of legalperson
-- ----------------------------
INSERT INTO `legalperson` VALUES (1, '001', '联想（北京）有限公司', '2023-01-30 13:53:23', NULL, '2023-02-12 13:53:31', NULL, 0, 1);
INSERT INTO `legalperson` VALUES (2, '003', '嗨嗨嗨', '2023-02-12 13:53:26', NULL, '2023-02-12 13:53:33', NULL, 0, 1);
INSERT INTO `legalperson` VALUES (3, '002', '哈哈哈', '2023-02-12 13:53:28', NULL, '2023-02-12 13:53:35', NULL, 0, 1);

SET FOREIGN_KEY_CHECKS = 1;
