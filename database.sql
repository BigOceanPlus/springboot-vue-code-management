/*
 Navicat Premium Data Transfer

 Source Server         : localhost_3306
 Source Server Type    : MySQL
 Source Server Version : 80028
 Source Host           : localhost:3306
 Source Schema         : manage_db

 Target Server Type    : MySQL
 Target Server Version : 80028
 File Encoding         : 65001

 Date: 28/02/2023 15:11:49
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for tb_carrier
-- ----------------------------
DROP TABLE IF EXISTS `tb_carrier`;
CREATE TABLE `tb_carrier`  (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `code` char(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `name` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of tb_carrier
-- ----------------------------
INSERT INTO `tb_carrier` VALUES (1, '0', '文字');
INSERT INTO `tb_carrier` VALUES (2, '1', '图像');
INSERT INTO `tb_carrier` VALUES (3, '2', '音频');
INSERT INTO `tb_carrier` VALUES (4, '3', '视频');
INSERT INTO `tb_carrier` VALUES (5, '4', '其他');

-- ----------------------------
-- Table structure for tb_disaster_class
-- ----------------------------
DROP TABLE IF EXISTS `tb_disaster_class`;
CREATE TABLE `tb_disaster_class`  (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `class_code` char(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `subclass_code` char(2) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `class_name` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `subclass_name` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 23 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of tb_disaster_class
-- ----------------------------
INSERT INTO `tb_disaster_class` VALUES (1, '1', '01', '震情', '震情信息');
INSERT INTO `tb_disaster_class` VALUES (2, '2', '01', '人员伤亡及失踪', '死亡');
INSERT INTO `tb_disaster_class` VALUES (3, '2', '02', '人员伤亡及失踪', '受伤');
INSERT INTO `tb_disaster_class` VALUES (4, '2', '03', '人员伤亡及失踪', '失踪');
INSERT INTO `tb_disaster_class` VALUES (5, '3', '01', '房屋破坏', '土木');
INSERT INTO `tb_disaster_class` VALUES (6, '3', '02', '房屋破坏', '砖木');
INSERT INTO `tb_disaster_class` VALUES (7, '3', '03', '房屋破坏', '砖混');
INSERT INTO `tb_disaster_class` VALUES (8, '3', '04', '房屋破坏', '框架');
INSERT INTO `tb_disaster_class` VALUES (9, '3', '05', '房屋破坏', '其他');
INSERT INTO `tb_disaster_class` VALUES (10, '4', '01', '生命线工程灾情', '交通');
INSERT INTO `tb_disaster_class` VALUES (11, '4', '02', '生命线工程灾情', '供水');
INSERT INTO `tb_disaster_class` VALUES (12, '4', '03', '生命线工程灾情', '输油');
INSERT INTO `tb_disaster_class` VALUES (13, '4', '04', '生命线工程灾情', '燃气');
INSERT INTO `tb_disaster_class` VALUES (14, '4', '05', '生命线工程灾情', '电力');
INSERT INTO `tb_disaster_class` VALUES (15, '4', '06', '生命线工程灾情', '通信');
INSERT INTO `tb_disaster_class` VALUES (16, '4', '07', '生命线工程灾情', '水利');
INSERT INTO `tb_disaster_class` VALUES (17, '5', '01', '次生灾害', '崩塌');
INSERT INTO `tb_disaster_class` VALUES (18, '5', '02', '次生灾害', '滑坡');
INSERT INTO `tb_disaster_class` VALUES (19, '5', '03', '次生灾害', '泥石流');
INSERT INTO `tb_disaster_class` VALUES (20, '5', '04', '次生灾害', '岩溶塌陷 ');
INSERT INTO `tb_disaster_class` VALUES (21, '5', '05', '次生灾害', '地裂缝');
INSERT INTO `tb_disaster_class` VALUES (22, '5', '06', '次生灾害', '地面沉降');
INSERT INTO `tb_disaster_class` VALUES (23, '5', '07', '次生灾害', '其他\r');

-- ----------------------------
-- Table structure for tb_disaster_quota
-- ----------------------------
DROP TABLE IF EXISTS `tb_disaster_quota`;
CREATE TABLE `tb_disaster_quota`  (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `class_code` char(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `quota_code` char(3) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `class_name` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `quota_name` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 16 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of tb_disaster_quota
-- ----------------------------
INSERT INTO `tb_disaster_quota` VALUES (1, '1', '001', '地震事件信息', '地理位置');
INSERT INTO `tb_disaster_quota` VALUES (2, '1', '002', '地震事件信息', '时间');
INSERT INTO `tb_disaster_quota` VALUES (3, '1', '003', '地震事件信息', '震级');
INSERT INTO `tb_disaster_quota` VALUES (4, '1', '004', '地震事件信息', '震源深度');
INSERT INTO `tb_disaster_quota` VALUES (5, '1', '005', '地震事件信息', '烈度');
INSERT INTO `tb_disaster_quota` VALUES (6, '2', '001', '人员伤亡及失踪信息', '受灾人数');
INSERT INTO `tb_disaster_quota` VALUES (7, '2', '002', '人员伤亡及失踪信息', '受灾程度');
INSERT INTO `tb_disaster_quota` VALUES (8, '3', '001', '房屋破坏信息', '一般损坏面积');
INSERT INTO `tb_disaster_quota` VALUES (9, '3', '002', '房屋破坏信息', '严重损坏面积');
INSERT INTO `tb_disaster_quota` VALUES (10, '3', '003', '房屋破坏信息', '受灾程度');
INSERT INTO `tb_disaster_quota` VALUES (11, '4', '001', '生命线工程灾情信息', '受灾设施数');
INSERT INTO `tb_disaster_quota` VALUES (12, '4', '002', '生命线工程灾情信息', '受灾范围');
INSERT INTO `tb_disaster_quota` VALUES (13, '4', '003', '生命线工程灾情信息', '受灾程度');
INSERT INTO `tb_disaster_quota` VALUES (14, '5', '001', '次生灾害信息', '灾害损失');
INSERT INTO `tb_disaster_quota` VALUES (15, '5', '002', '次生灾害信息', '灾害范围');
INSERT INTO `tb_disaster_quota` VALUES (16, '5', '003', '次生灾害信息', '受灾程度');

-- ----------------------------
-- Table structure for tb_geographic
-- ----------------------------
DROP TABLE IF EXISTS `tb_geographic`;
CREATE TABLE `tb_geographic`  (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `province_code` char(2) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `prefecture_code` char(2) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `county_code` char(2) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `street_code` char(3) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `community_code` char(3) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `province_name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `prefecture_name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `county_name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `street_name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `community_name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `idx_code`(`province_code` ASC, `prefecture_code` ASC, `county_code` ASC, `street_code` ASC, `community_code` ASC) USING BTREE,
  INDEX `idx_name`(`province_name`(4) ASC, `prefecture_name`(4) ASC, `county_name`(4) ASC, `street_name`(4) ASC, `community_name`(4) ASC) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 20 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of tb_geographic
-- ----------------------------
INSERT INTO `tb_geographic` VALUES (1, '11', '01', '01', '001', '001', '北京市', '市辖区', '东城区', '东华门街道办事处', '多福巷社区居委会');
INSERT INTO `tb_geographic` VALUES (2, '11', '01', '01', '001', '002', '北京市', '市辖区', '东城区', '东华门街道办事处', '银闸社区居委会');
INSERT INTO `tb_geographic` VALUES (3, '11', '01', '01', '001', '005', '北京市', '市辖区', '东城区', '东华门街道办事处', '东厂社区居委会');
INSERT INTO `tb_geographic` VALUES (4, '11', '01', '01', '001', '006', '北京市', '市辖区', '东城区', '东华门街道办事处', '智德社区居委会');
INSERT INTO `tb_geographic` VALUES (5, '11', '01', '01', '001', '007', '北京市', '市辖区', '东城区', '东华门街道办事处', '\r\n南池子社区居委会');
INSERT INTO `tb_geographic` VALUES (6, '11', '01', '01', '001', '008', '北京市', '市辖区', '东城区', '东华门街道办事处', '黄图岗社区居委会');
INSERT INTO `tb_geographic` VALUES (7, '11', '01', '01', '001', '009', '北京市', '市辖区', '东城区', '东华门街道办事处', '灯市口社区居委会');
INSERT INTO `tb_geographic` VALUES (8, '11', '01', '01', '001', '010', '北京市', '市辖区', '东城区', '东华门街道办事处', '正义路社区居委会');
INSERT INTO `tb_geographic` VALUES (9, '11', '01', '01', '001', '011', '北京市', '市辖区', '东城区', '东华门街道办事处', '甘雨社区居委会');
INSERT INTO `tb_geographic` VALUES (10, '11', '01', '01', '001', '013', '北京市', '市辖区', '东城区', '东华门街道办事处', '台基厂社区居委会');
INSERT INTO `tb_geographic` VALUES (11, '11', '01', '01', '001', '014', '北京市', '市辖区', '东城区', '东华门街道办事处', '韶九社区居委会');
INSERT INTO `tb_geographic` VALUES (12, '11', '01', '01', '001', '015', '北京市', '市辖区', '东城区', '东华门街道办事处', '王府井社区居委会');
INSERT INTO `tb_geographic` VALUES (13, '11', '01', '01', '002', '001', '北京市', '市辖区', '东城区', '景山街道办事处', '隆福寺社区居委会');
INSERT INTO `tb_geographic` VALUES (14, '11', '01', '01', '002', '002', '北京市', '市辖区', '东城区', '景山街道办事处', '吉祥社区居委会');
INSERT INTO `tb_geographic` VALUES (15, '11', '01', '01', '002', '003', '北京市', '市辖区', '东城区', '景山街道办事处', '黄化门社区居委会');
INSERT INTO `tb_geographic` VALUES (16, '11', '01', '01', '002', '004', '北京市', '市辖区', '东城区', '景山街道办事处', '钟鼓社区居委会');
INSERT INTO `tb_geographic` VALUES (17, '11', '01', '01', '002', '005', '北京市', '市辖区', '东城区', '景山街道办事处', '魏家社区居委会');
INSERT INTO `tb_geographic` VALUES (18, '11', '01', '01', '002', '006', '北京市', '市辖区', '东城区', '景山街道办事处', '汪芝麻社区居委会');
INSERT INTO `tb_geographic` VALUES (19, '11', '01', '01', '002', '008', '北京市', '市辖区', '东城区', '景山街道办事处', '景山东街社区居委会');
INSERT INTO `tb_geographic` VALUES (20, '11', '01', '01', '002', '009', '北京市', '市辖区', '东城区', '景山街道办事处', '皇城根北街社区居委会');

-- ----------------------------
-- Table structure for tb_item
-- ----------------------------
DROP TABLE IF EXISTS `tb_item`;
CREATE TABLE `tb_item`  (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `code` char(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `geographic` varchar(250) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `data_time` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `source` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `carrier` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `disaster` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `remark` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `url` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 19 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tb_item
-- ----------------------------
INSERT INTO `tb_item` VALUES (1, '110101001001202105220204003000101002', '北京市市辖区东城区东华门街道办事处多福巷社区居委会', '2021年05月22日-02时04分00秒', '其他数据-其他', '文字', '震情-震情信息-时间', '', 'http://localhost:9090/file/ca0e0ba9-deb5-4730-adb1-5bccfd18a69d.jpg');
INSERT INTO `tb_item` VALUES (3, '110101001001202211291153001000201001', '北京市市辖区东城区东华门街道办事处多福巷社区居委会', '2022年11月29日-11时53分00秒', '业务报送数据-前方地震应急指挥部', '文字', '人员伤亡及失踪-死亡-受灾人数', '400人', 'http://localhost:9090/file/c74f7454-ec82-478e-95f5-2531f00556fa.TXT');
INSERT INTO `tb_item` VALUES (5, '110101001001202405220204003000101002', '北京市市辖区东城区东华门街道办事处多福巷社区居委会', '2024年05月22日-02时04分00秒', '其他数据-其他', '文字', '震情-震情信息-时间', '', 'http://localhost:9090/file/50ba2688-bd17-4d40-8416-19e50dd53bb8.pdf');
INSERT INTO `tb_item` VALUES (6, '110101001001201105220204003000101002', '北京市市辖区东城区东华门街道办事处多福巷社区居委会', '2011年05月22日-02时04分00秒', '其他数据-其他', '文字', '震情-震情信息-时间', '', 'http://localhost:9090/file/5a1bb9c0-dae7-4d2e-9c67-b3b501424e3b.docx');
INSERT INTO `tb_item` VALUES (7, '110101001001201105220204003000101002', '北京市市辖区东城区东华门街道办事处多福巷社区居委会', '2011年05月22日-02时04分00秒', '其他数据-其他', '文字', '震情-震情信息-时间', '', 'http://localhost:9090/file/101ce2ca-ded7-480c-b44b-6b34dd4c9c72.txt');
INSERT INTO `tb_item` VALUES (8, '110101001001203105220204003000101002', '北京市市辖区东城区东华门街道办事处多福巷社区居委会', '2031年05月22日-02时04分00秒', '其他数据-其他', '文字', '震情-震情信息-时间', '', 'http://localhost:9090/file/4b414995-6ff4-471b-973f-07769253a112.pdf');
INSERT INTO `tb_item` VALUES (9, '110101001001201305220204003000101002', '北京市市辖区东城区东华门街道办事处多福巷社区居委会', '2013年05月22日-02时04分00秒', '其他数据-其他', '文字', '震情-震情信息-时间', '', 'http://localhost:9090/file/119ea438-ca95-423b-8af0-0fc612b30bf2.mp3');
INSERT INTO `tb_item` VALUES (10, '110101001001201105220204003000101002', '北京市市辖区东城区东华门街道办事处多福巷社区居委会', '2011年05月22日-02时04分00秒', '其他数据-其他', '文字', '震情-震情信息-时间', '', 'http://localhost:9090/file/d6256ff9-9b35-4566-93c1-57c25ab09c3f.mp3');
INSERT INTO `tb_item` VALUES (11, '110101001001201105220204003000101002', '北京市市辖区东城区东华门街道办事处多福巷社区居委会', '2011年05月22日-02时04分00秒', '其他数据-其他', '文字', '震情-震情信息-时间', '', NULL);
INSERT INTO `tb_item` VALUES (12, '110101001001201305220204003000101002', '北京市市辖区东城区东华门街道办事处多福巷社区居委会', '2013年05月22日-02时04分00秒', '其他数据-其他', '文字', '震情-震情信息-时间', '', 'http://localhost:9090/file/14d14e1b-0ea7-40de-82ab-4f451cc28b80.mp4');
INSERT INTO `tb_item` VALUES (13, '110101001001207105220204003000101002', '北京市市辖区东城区东华门街道办事处多福巷社区居委会', '2071年05月22日-02时04分00秒', '其他数据-其他', '文字', '震情-震情信息-时间', '', NULL);
INSERT INTO `tb_item` VALUES (14, '110101001001202105220204003002101002', '北京市市辖区东城区东华门街道办事处多福巷社区居委会', '2021年05月22日-02时04分00秒', '其他数据-其他', '音频', '震情-震情信息-时间', '', NULL);
INSERT INTO `tb_item` VALUES (15, '110101001001201105220204003000101002', '北京市市辖区东城区东华门街道办事处多福巷社区居委会', '2011年05月22日-02时04分00秒', '其他数据-其他', '文字', '震情-震情信息-时间', '', 'http://localhost:9090/file/3781ea2c-4702-40bd-b5e5-ce750736dbe3.txt');
INSERT INTO `tb_item` VALUES (16, '110101002001202212010626081014302001', '北京市市辖区东城区景山街道办事处隆福寺社区居委会', '2022年12月01日-06时26分08秒', '业务报送数据-后方地震应急指挥部', '其他', '房屋破坏-砖木-一般损坏面积', 'test', NULL);
INSERT INTO `tb_item` VALUES (17, '110101001001202105220204003000101002', '北京市市辖区东城区东华门街道办事处多福巷社区居委会', '2021年05月22日-02时04分00秒', '其他数据-其他', '文字', '震情-震情信息-时间', '', NULL);
INSERT INTO `tb_item` VALUES (18, '110101001001201105220204003000101002', '北京市市辖区东城区东华门街道办事处多福巷社区居委会', '2011年05月22日-02时04分00秒', '其他数据-其他', '文字', '震情-震情信息-时间', '', 'http://localhost:9090/file/5d650b13-3ce1-4bc9-90c5-256ba6c05bde.txt');
INSERT INTO `tb_item` VALUES (19, '110101001001201305220204003000101002', '北京市市辖区东城区东华门街道办事处多福巷社区居委会', '2013年05月22日-02时04分00秒', '其他数据-其他', '文字', '震情-震情信息-时间', '', 'http://localhost:9090/file/b4eefd13-6673-47b6-b51d-00a418fc6a5b.mp4');

-- ----------------------------
-- Table structure for tb_source
-- ----------------------------
DROP TABLE IF EXISTS `tb_source`;
CREATE TABLE `tb_source`  (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `class_code` char(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `subclass_code` char(2) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `class_name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `subclass_name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 17 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of tb_source
-- ----------------------------
INSERT INTO `tb_source` VALUES (1, '1', '00', '业务报送数据', '前方地震应急指挥部');
INSERT INTO `tb_source` VALUES (2, '1', '01', '业务报送数据', '后方地震应急指挥部');
INSERT INTO `tb_source` VALUES (3, '1', '20', '业务报送数据', '应急指挥技术系统');
INSERT INTO `tb_source` VALUES (4, '1', '21', '业务报送数据', '社会服务工程应急救援系统');
INSERT INTO `tb_source` VALUES (5, '1', '40', '业务报送数据', '危险区预评估工作组');
INSERT INTO `tb_source` VALUES (6, '1', '41', '业务报送数据', '地震应急指挥技术协调组');
INSERT INTO `tb_source` VALUES (7, '1', '42', '业务报送数据', '震后政府信息支持工作项目组');
INSERT INTO `tb_source` VALUES (8, '1', '80', '业务报送数据', '灾情快速上报接收处理系统');
INSERT INTO `tb_source` VALUES (9, '1', '81', '业务报送数据', '地方地震局应急信息服务相关技术系统');
INSERT INTO `tb_source` VALUES (10, '1', '99', '业务报送数据', '其他');
INSERT INTO `tb_source` VALUES (11, '2', '00', '泛在感知数据', '互联网感知');
INSERT INTO `tb_source` VALUES (12, '2', '01', '泛在感知数据', '通信网感知');
INSERT INTO `tb_source` VALUES (13, '2', '02', '泛在感知数据', '舆情网感知');
INSERT INTO `tb_source` VALUES (14, '2', '03', '泛在感知数据', '电力系统感知');
INSERT INTO `tb_source` VALUES (15, '2', '04', '泛在感知数据', '交通系统感知');
INSERT INTO `tb_source` VALUES (16, '2', '05', '泛在感知数据', '其他');
INSERT INTO `tb_source` VALUES (17, '3', '00', '其他数据', '其他');

-- ----------------------------
-- Table structure for tb_user
-- ----------------------------
DROP TABLE IF EXISTS `tb_user`;
CREATE TABLE `tb_user`  (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `username` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `password` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `remark` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `idx_username`(`username`(6) ASC) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 7 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tb_user
-- ----------------------------
INSERT INTO `tb_user` VALUES (1, 'root', 'myroot', '最高管理员');
INSERT INTO `tb_user` VALUES (5, 'admin', '123456', 'test');
INSERT INTO `tb_user` VALUES (6, 'kali', '888888', 'hacker');

-- ----------------------------
-- View structure for test
-- ----------------------------
DROP VIEW IF EXISTS `test`;
CREATE ALGORITHM = UNDEFINED SQL SECURITY DEFINER VIEW `test` AS select `tb_geographic`.`province_name` AS `province_name` from `tb_geographic` where (`tb_geographic`.`province_code` = '11');

SET FOREIGN_KEY_CHECKS = 1;
