/*
 Navicat Premium Data Transfer

 Source Server         : localhost
 Source Server Type    : MySQL
 Source Server Version : 50722
 Source Host           : localhost:3306
 Source Schema         : rentalroom

 Target Server Type    : MySQL
 Target Server Version : 50722
 File Encoding         : 65001

 Date: 17/01/2020 17:11:27
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for order
-- ----------------------------
DROP TABLE IF EXISTS `order`;
CREATE TABLE `order`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `userId` int(11) NULL DEFAULT NULL,
  `houseId` int(11) NULL DEFAULT NULL,
  `time` datetime(0) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for t_house
-- ----------------------------
DROP TABLE IF EXISTS `t_house`;
CREATE TABLE `t_house`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '标题',
  `title_img` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '房屋标题图片路径',
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '房屋名称',
  `type` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '房屋类型',
  `address` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '详细地址',
  `rent_way` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '出租方式',
  `city` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '城市',
  `sex_limit` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '性别限制',
  `area` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '房屋面积',
  `storey` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '所在楼层',
  `storey_sum` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '楼层总数',
  `building_id` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '楼栋号',
  `cell_id` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '单元号',
  `room_id` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '房间号',
  `price` int(11) NULL DEFAULT NULL COMMENT '租金',
  `text` text CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL COMMENT '描述',
  `text_img` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '房屋描述图片路径',
  `contacts` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '联系人',
  `phone` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '联系电话',
  `userId` int(11) NOT NULL COMMENT '房主ID',
  `status` tinyint(4) NOT NULL COMMENT '审核状态',
  PRIMARY KEY (`id`, `userId`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for t_permission
-- ----------------------------
DROP TABLE IF EXISTS `t_permission`;
CREATE TABLE `t_permission`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `parent_id` int(11) NOT NULL,
  `types` int(11) NULL DEFAULT NULL,
  `i_frame` int(11) NULL DEFAULT NULL COMMENT '是否外链',
  `url` varchar(150) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `levels` int(11) NULL DEFAULT NULL,
  `state` int(11) NULL DEFAULT NULL,
  `sorts` int(11) NULL DEFAULT NULL,
  `description` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `component_name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `component_path` varchar(150) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `icon` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '图标',
  `cache` int(11) NULL DEFAULT NULL,
  `hidden` int(11) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 70 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_permission
-- ----------------------------
INSERT INTO `t_permission` VALUES (4, '外链', 0, 1, 1, 'https://github.com/252956/vue-link-admin', NULL, NULL, 202, NULL, NULL, NULL, 'link', 0, 0);
INSERT INTO `t_permission` VALUES (5, '错误页面', 0, 0, 0, '/error', NULL, NULL, 199, NULL, '', '', '404', 0, 0);
INSERT INTO `t_permission` VALUES (6, '401', 5, 1, 0, '/error/401', NULL, NULL, 30, NULL, 'Page401', '/error-page/401', NULL, 0, 0);
INSERT INTO `t_permission` VALUES (7, '404', 5, 1, 0, '/error/404', NULL, NULL, 31, NULL, 'Page404', '/error-page/404', NULL, 0, 0);
INSERT INTO `t_permission` VALUES (8, '系统权限', 0, 0, 0, '/permission', NULL, NULL, 100, NULL, '', '', 'lock', 0, 0);
INSERT INTO `t_permission` VALUES (9, '用户管理', 8, 1, 0, '/permission/user', NULL, NULL, 1, NULL, 'User', '/permission/user', '', 0, 0);
INSERT INTO `t_permission` VALUES (10, '角色管理', 8, 1, 0, '/permission/role', NULL, NULL, 2, NULL, 'Role', '/permission/role', NULL, 0, 0);
INSERT INTO `t_permission` VALUES (11, '权限管理', 8, 1, 0, '/permission/permission', NULL, NULL, 3, NULL, 'Permission', '/permission/permission', NULL, 0, 0);
INSERT INTO `t_permission` VALUES (13, '部门管理', 8, 1, 0, '/permission/dept', NULL, NULL, 4, NULL, 'Department', '/permission/department', NULL, 0, 0);
INSERT INTO `t_permission` VALUES (14, '图标', 0, 1, 0, '/icon', NULL, NULL, 201, NULL, 'Icons', '/icons/index', 'icon', 0, 0);
INSERT INTO `t_permission` VALUES (16, '查询用户', 9, 2, 0, '/rest/user/list', NULL, NULL, 1, NULL, '', '', NULL, 0, 0);
INSERT INTO `t_permission` VALUES (17, '新增用户', 9, 2, NULL, '/rest/user/add', NULL, NULL, 201, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `t_permission` VALUES (18, '修改用户', 9, 2, NULL, '/rest/user/update', NULL, NULL, 202, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `t_permission` VALUES (19, '删除用户', 9, 2, NULL, '/rest/user/delete', NULL, NULL, 203, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `t_permission` VALUES (20, '查询角色', 10, 2, NULL, '/rest/role/list', NULL, NULL, 210, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `t_permission` VALUES (21, '新增角色', 10, 2, NULL, '/rest/role/add', NULL, NULL, 211, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `t_permission` VALUES (22, '修改角色', 10, 2, NULL, '/rest/role/update', NULL, NULL, 212, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `t_permission` VALUES (23, '删除角色', 10, 2, NULL, '/rest/role/delete', NULL, NULL, 213, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `t_permission` VALUES (24, '查询权限', 11, 2, NULL, '/rest/permission/all', NULL, NULL, 220, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `t_permission` VALUES (25, '新增权限', 11, 2, NULL, '/rest/permission/add', NULL, NULL, 221, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `t_permission` VALUES (26, '修改权限', 11, 2, NULL, '/rest/permission/update', NULL, NULL, 222, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `t_permission` VALUES (27, '删除权限', 11, 2, NULL, '/rest/permission/delete', NULL, NULL, 223, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `t_permission` VALUES (28, '查询部门', 13, 2, NULL, '/rest/department/all', NULL, NULL, 240, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `t_permission` VALUES (29, '新增部门', 13, 2, NULL, '/rest/department/add', NULL, NULL, 241, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `t_permission` VALUES (30, '修改部门', 13, 2, NULL, '/rest/department/update', NULL, NULL, 242, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `t_permission` VALUES (31, '删除部门', 13, 2, NULL, '/rest/department/delete', NULL, NULL, 243, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `t_permission` VALUES (32, '系统监控', 0, 0, 0, '/monitor', NULL, NULL, 101, NULL, '', '', 'monitor', 0, 0);
INSERT INTO `t_permission` VALUES (33, '错误日志', 32, 1, 0, '/monitor/error-log', NULL, NULL, 40, NULL, 'ErrorLog', '/monitor/error-log', NULL, 0, 0);
INSERT INTO `t_permission` VALUES (34, '业务日志', 32, 1, 0, '/monitor/blog', NULL, NULL, 41, NULL, 'Blog', '/monitor/blog', NULL, 0, 0);
INSERT INTO `t_permission` VALUES (41, '数据字典', 8, 1, 0, '/permission/dict', NULL, NULL, 6, NULL, 'Dict', '/permission/dict', NULL, 0, 0);
INSERT INTO `t_permission` VALUES (43, '数据权限', 10, 2, NULL, '/rest/role/saveDataScope', NULL, NULL, 1, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `t_permission` VALUES (44, '新增字典', 41, 2, NULL, '/rest/dict/add', NULL, NULL, 1, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `t_permission` VALUES (45, '修改字典', 41, 2, NULL, '/rest/dict/update', NULL, NULL, 2, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `t_permission` VALUES (46, '删除字典', 41, 2, NULL, '/rest/dict/delete', NULL, NULL, 3, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `t_permission` VALUES (48, '查询日志', 34, 2, 0, '/rest/logs/blog/list', NULL, NULL, 1, NULL, '', '', '', 0, 0);
INSERT INTO `t_permission` VALUES (49, '岗位管理', 8, 1, 0, '/permission/job', NULL, NULL, 5, NULL, 'Job', '/permission/job', '', 0, 0);
INSERT INTO `t_permission` VALUES (50, '添加岗位', 49, 2, 0, '/rest/job/add', NULL, NULL, 1, NULL, '', '', '', 0, 0);
INSERT INTO `t_permission` VALUES (51, '修改岗位', 49, 2, 0, '/rest/job/update', NULL, NULL, 2, NULL, '', '', '', 0, 0);
INSERT INTO `t_permission` VALUES (52, '删除岗位', 49, 2, 0, '/rest/job/delete', NULL, NULL, 3, NULL, '', '', '', 0, 0);
INSERT INTO `t_permission` VALUES (54, '组件', 0, 0, 0, '/component', NULL, NULL, 103, NULL, '', '', 'component', 0, 0);
INSERT INTO `t_permission` VALUES (55, 'pdf', 54, 1, 0, '/component/pdf', NULL, NULL, 6, NULL, 'Pdf', '/component/pdf', '', 0, 0);
INSERT INTO `t_permission` VALUES (56, 'excel', 54, 0, 0, '/excel', NULL, NULL, 7, NULL, '', '', '', 0, 0);
INSERT INTO `t_permission` VALUES (57, 'zip', 54, 1, 0, '/component/zip', NULL, NULL, 8, NULL, 'Zip', '/component/zip', '', 0, 0);
INSERT INTO `t_permission` VALUES (58, '打赏', 0, 1, 1, 'https://252956.github.io/pages/donate.html', NULL, NULL, 203, NULL, '', '', 'donate', 0, 0);
INSERT INTO `t_permission` VALUES (59, 'upload', 54, 1, 0, '/component/upload', NULL, NULL, 4, NULL, 'Upload', '/component/upload', '', 0, 0);
INSERT INTO `t_permission` VALUES (62, 'Markdown', 54, 1, 0, '/component/markdown', NULL, NULL, 2, NULL, 'MarkdownDemo', '/component/markdown', '', 0, 0);
INSERT INTO `t_permission` VALUES (63, 'JSON 编辑器', 54, 1, 0, '/component/json-editor', NULL, NULL, 3, NULL, 'JsonEditorDemo', '/component/json-editor', '', 0, 0);
INSERT INTO `t_permission` VALUES (64, '键盘图表', 54, 1, 0, '/component/keyboard', NULL, NULL, 11, NULL, 'KeyboardChart', '/component/keyboard', '', 0, 0);
INSERT INTO `t_permission` VALUES (65, '折线图', 54, 1, 0, '/component/line', NULL, NULL, 12, NULL, 'LineChart', '/component/line', '', 0, 0);
INSERT INTO `t_permission` VALUES (66, '混合图表', 54, 1, 0, '/component/mix-chart', NULL, NULL, 13, NULL, 'MixChart', '/component/mix-chart', '', 0, 0);
INSERT INTO `t_permission` VALUES (67, '导出 Excel', 56, 1, 0, '/component/excel/export-excel', NULL, NULL, 1, NULL, 'ExportExcel', '/component/excel/export-excel', '', 0, 0);
INSERT INTO `t_permission` VALUES (68, '导出 已选择项', 56, 1, 0, '/component/excel/select-excel', NULL, NULL, 2, NULL, 'SelectExcel', '/component/excel/select-excel', '', 0, 0);
INSERT INTO `t_permission` VALUES (69, '导出 多级表头', 56, 1, 0, '/component/excel/merge-header', NULL, NULL, 3, NULL, 'MergeHeader', '/component/excel/merge-header', '', 0, 0);

-- ----------------------------
-- Table structure for t_role
-- ----------------------------
DROP TABLE IF EXISTS `t_role`;
CREATE TABLE `t_role`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `description` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 13 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_role
-- ----------------------------
INSERT INTO `t_role` VALUES (1, 'admin', '超级管理员');
INSERT INTO `t_role` VALUES (2, 'user', '用户');
INSERT INTO `t_role` VALUES (11, 'test', '测试角色');

-- ----------------------------
-- Table structure for t_role_permission
-- ----------------------------
DROP TABLE IF EXISTS `t_role_permission`;
CREATE TABLE `t_role_permission`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `role_id` int(11) NOT NULL,
  `perm_id` int(11) NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2027 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_role_permission
-- ----------------------------
INSERT INTO `t_role_permission` VALUES (1921, 1, 8);
INSERT INTO `t_role_permission` VALUES (1922, 1, 9);
INSERT INTO `t_role_permission` VALUES (1923, 1, 16);
INSERT INTO `t_role_permission` VALUES (1924, 1, 17);
INSERT INTO `t_role_permission` VALUES (1925, 1, 18);
INSERT INTO `t_role_permission` VALUES (1926, 1, 19);
INSERT INTO `t_role_permission` VALUES (1927, 1, 10);
INSERT INTO `t_role_permission` VALUES (1928, 1, 43);
INSERT INTO `t_role_permission` VALUES (1929, 1, 20);
INSERT INTO `t_role_permission` VALUES (1930, 1, 21);
INSERT INTO `t_role_permission` VALUES (1931, 1, 22);
INSERT INTO `t_role_permission` VALUES (1932, 1, 23);
INSERT INTO `t_role_permission` VALUES (1933, 1, 11);
INSERT INTO `t_role_permission` VALUES (1934, 1, 24);
INSERT INTO `t_role_permission` VALUES (1935, 1, 25);
INSERT INTO `t_role_permission` VALUES (1936, 1, 26);
INSERT INTO `t_role_permission` VALUES (1937, 1, 27);
INSERT INTO `t_role_permission` VALUES (1938, 1, 13);
INSERT INTO `t_role_permission` VALUES (1939, 1, 28);
INSERT INTO `t_role_permission` VALUES (1940, 1, 29);
INSERT INTO `t_role_permission` VALUES (1941, 1, 30);
INSERT INTO `t_role_permission` VALUES (1942, 1, 31);
INSERT INTO `t_role_permission` VALUES (1943, 1, 49);
INSERT INTO `t_role_permission` VALUES (1944, 1, 50);
INSERT INTO `t_role_permission` VALUES (1945, 1, 51);
INSERT INTO `t_role_permission` VALUES (1946, 1, 52);
INSERT INTO `t_role_permission` VALUES (1947, 1, 41);
INSERT INTO `t_role_permission` VALUES (1948, 1, 44);
INSERT INTO `t_role_permission` VALUES (1949, 1, 45);
INSERT INTO `t_role_permission` VALUES (1950, 1, 46);
INSERT INTO `t_role_permission` VALUES (1951, 1, 32);
INSERT INTO `t_role_permission` VALUES (1952, 1, 33);
INSERT INTO `t_role_permission` VALUES (1953, 1, 34);
INSERT INTO `t_role_permission` VALUES (1954, 1, 48);
INSERT INTO `t_role_permission` VALUES (1955, 1, 54);
INSERT INTO `t_role_permission` VALUES (1956, 1, 62);
INSERT INTO `t_role_permission` VALUES (1957, 1, 63);
INSERT INTO `t_role_permission` VALUES (1958, 1, 59);
INSERT INTO `t_role_permission` VALUES (1959, 1, 55);
INSERT INTO `t_role_permission` VALUES (1960, 1, 56);
INSERT INTO `t_role_permission` VALUES (1961, 1, 67);
INSERT INTO `t_role_permission` VALUES (1962, 1, 68);
INSERT INTO `t_role_permission` VALUES (1963, 1, 69);
INSERT INTO `t_role_permission` VALUES (1964, 1, 57);
INSERT INTO `t_role_permission` VALUES (1965, 1, 64);
INSERT INTO `t_role_permission` VALUES (1966, 1, 65);
INSERT INTO `t_role_permission` VALUES (1967, 1, 66);
INSERT INTO `t_role_permission` VALUES (1968, 1, 5);
INSERT INTO `t_role_permission` VALUES (1969, 1, 6);
INSERT INTO `t_role_permission` VALUES (1970, 1, 7);
INSERT INTO `t_role_permission` VALUES (1972, 1, 14);
INSERT INTO `t_role_permission` VALUES (1973, 1, 4);
INSERT INTO `t_role_permission` VALUES (1974, 1, 58);
INSERT INTO `t_role_permission` VALUES (2018, 2, 32);
INSERT INTO `t_role_permission` VALUES (2019, 2, 33);
INSERT INTO `t_role_permission` VALUES (2020, 2, 5);
INSERT INTO `t_role_permission` VALUES (2021, 2, 6);
INSERT INTO `t_role_permission` VALUES (2022, 2, 7);
INSERT INTO `t_role_permission` VALUES (2024, 2, 14);
INSERT INTO `t_role_permission` VALUES (2025, 2, 4);
INSERT INTO `t_role_permission` VALUES (2026, 2, 58);

-- ----------------------------
-- Table structure for t_user
-- ----------------------------
DROP TABLE IF EXISTS `t_user`;
CREATE TABLE `t_user`  (
  `id` int(11) UNSIGNED NOT NULL AUTO_INCREMENT,
  `account` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `username` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `password` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `realname` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `city` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `email` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `status` tinyint(4) NOT NULL DEFAULT 0 COMMENT '0:未激活 1:已激活 2:已删除',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 14 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_user
-- ----------------------------
INSERT INTO `t_user` VALUES (1, 'zs', '张三', '123456', NULL, NULL, NULL, 1);
INSERT INTO `t_user` VALUES (10, 'ls', '李四', '123456', 'lisi', '广州', '112233@qq.com', 1);
INSERT INTO `t_user` VALUES (11, 'ww', '王五', '123456', 'wangwu', '北京', '112233@qq.com', 1);
INSERT INTO `t_user` VALUES (12, 'xm', '小明', '123456', 'xiaoming', '上海', '112233@qq.com', 1);
INSERT INTO `t_user` VALUES (13, 'asdf', 'adsf', '123456', NULL, 'asdf', 'asdf', 1);

-- ----------------------------
-- Table structure for t_user_role
-- ----------------------------
DROP TABLE IF EXISTS `t_user_role`;
CREATE TABLE `t_user_role`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) NOT NULL,
  `role_id` int(11) NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

SET FOREIGN_KEY_CHECKS = 1;
