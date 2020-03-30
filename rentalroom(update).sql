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

 Date: 30/03/2020 21:49:57
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for t_house
-- ----------------------------
DROP TABLE IF EXISTS `t_house`;
CREATE TABLE `t_house`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '标题 = 城市+租赁方式+房屋类型+房屋朝向',
  `title_img` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '房屋标题图片路径',
  `city` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '城市',
  `type` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '房屋类型',
  `rent_way` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '租赁方式',
  `orientation` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '房屋朝向',
  `address` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '详细地址',
  `sex_limit` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '性别限制',
  `area` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '房屋面积',
  `price` int(11) NULL DEFAULT NULL COMMENT '租金',
  `desc` text CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL COMMENT '描述',
  `desc_img` text CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL COMMENT '房屋描述图片路径',
  `contacts` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '联系人',
  `phone` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '联系电话',
  `userId` int(11) NOT NULL COMMENT '房主ID',
  `rental_status` tinyint(4) NULL DEFAULT NULL COMMENT '租赁状态（0:待租 1:已租）',
  `status` tinyint(4) NOT NULL COMMENT '审核状态（0:未通过 1:已通过）',
  `release_time` datetime(0) NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '房屋发布时间',
  PRIMARY KEY (`id`, `userId`) USING BTREE,
  INDEX `id`(`id`) USING BTREE,
  INDEX `userId`(`userId`) USING BTREE,
  CONSTRAINT `t_house_ibfk_1` FOREIGN KEY (`userId`) REFERENCES `t_user` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 11 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_house
-- ----------------------------
INSERT INTO `t_house` VALUES (1, '北京 整租 一居室 东', 'https://cube.elemecdn.com/6/94/4d3ea53c084bad6931a56d5158a48jpeg.jpeg', '北京', '一居室', '合租', '合租', '北京', '男', '100', 1000, '这是详细描述', 'https://cube.elemecdn.com/6/94/4d3ea53c084bad6931a56d5158a48jpeg.jpeg,https://ss0.bdstatic.com/94oJfD_bAAcT8t7mm9GUKT-xh_/timg?image&quality=100&size=b4000_4000&sec=1584887799&di=096bada498282909429a8c590521b837&src=http://img.zx123.cn/Resources/zx123cn/uploadfile/2015/0604/7487d262c1c4f06478c95cdd3e9da1d2.jpg,https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1584897885171&di=17a496a8562380ba1077eeb77641ff04&imgtype=0&src=http%3A%2F%2Fimg3.duitang.com%2Fuploads%2Fitem%2F201504%2F01%2F20150401H5753_vLVGs.jpeg,https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1584897885169&di=a8258e4790889ddacef195b762135a8b&imgtype=0&src=http%3A%2F%2Fimg.taopic.com%2Fuploads%2Fallimg%2F121006%2F219049-12100615405138.jpg,https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1584901103701&di=f759ee8c7357dacf08c5d32eb0e47643&imgtype=0&src=http%3A%2F%2Fwww.szsmack.com%2Fuploadfile%2F2018%2F0904%2F20180904063417341.jpg', '张三', '12345678901', 1, 1, 1, '2020-03-28 13:44:05');
INSERT INTO `t_house` VALUES (2, '广州 整租 两居室 南', 'https://ss0.bdstatic.com/94oJfD_bAAcT8t7mm9GUKT-xh_/timg?image&quality=100&size=b4000_4000&sec=1584887799&di=096bada498282909429a8c590521b837&src=http://img.zx123.cn/Resources/zx123cn/uploadfile/2015/0604/7487d262c1c4f06478c95cdd3e9da1d2.jpg', '广州', '两居室', '整租', '南', '广州', '女', '120', 2000, '这是详细描述', 'https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1584900956431&di=3ae92d2a1b1385a10e67352bff4ea498&imgtype=0&src=http%3A%2F%2Ficweiliimg1.pstatp.com%2Fweili%2Fbl%2F238506801108353271.jpg,https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1584901049237&di=34b88860bec9f8d0ee7d3458dd826483&imgtype=0&src=http%3A%2F%2F5b0988e595225.cdn.sohucs.com%2Fimages%2F20171124%2F6d98d95dc82747f99caba9e1ef75bc32.jpeg', '李四', '135240236547', 1, 1, 1, '2020-03-13 00:00:00');
INSERT INTO `t_house` VALUES (3, '上海 整租 三居室 西', 'https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1584897885171&di=17a496a8562380ba1077eeb77641ff04&imgtype=0&src=http%3A%2F%2Fimg3.duitang.com%2Fuploads%2Fitem%2F201504%2F01%2F20150401H5753_vLVGs.jpeg', '上海', '三居室', '整租', '西', '上海', '男', '110', 1500, '这是详细描述', 'https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1584900956425&di=9c25df30c23f116490986f4ed05e4016&imgtype=0&src=http%3A%2F%2Fdpic.tiankong.com%2F8c%2Fcp%2FQJ6221831393.jpg%3Fx-oss-process%3Dstyle%2Fshows', '王五', '15234702356', 10, 0, 1, '2020-03-30 21:46:59');
INSERT INTO `t_house` VALUES (4, '上海 整租 两房一厅 北', 'https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1584897885169&di=a8258e4790889ddacef195b762135a8b&imgtype=0&src=http%3A%2F%2Fimg.taopic.com%2Fuploads%2Fallimg%2F121006%2F219049-12100615405138.jpg', '上海', '两房一厅', '整租', '北', '上海', NULL, '80', 800, '这是详细描述', 'https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1584900956423&di=85afee865cabaa985be29cd95c061324&imgtype=0&src=http%3A%2F%2Fxtf.szzj.cn%2Fimages%2FSell%2Fin%2F2018829%2F201882995056.jpg', '燕小六', '13427854412', 10, 1, 1, '2020-03-21 00:00:00');
INSERT INTO `t_house` VALUES (7, '南京 整租 一居室 东', 'https://cube.elemecdn.com/6/94/4d3ea53c084bad6931a56d5158a48jpeg.jpeg', '南京', '一居室', '合租', '合租', '北京', '男', '100', 1000, '这是详细描述', 'https://cube.elemecdn.com/6/94/4d3ea53c084bad6931a56d5158a48jpeg.jpeg,https://ss0.bdstatic.com/94oJfD_bAAcT8t7mm9GUKT-xh_/timg?image&quality=100&size=b4000_4000&sec=1584887799&di=096bada498282909429a8c590521b837&src=http://img.zx123.cn/Resources/zx123cn/uploadfile/2015/0604/7487d262c1c4f06478c95cdd3e9da1d2.jpg,https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1584897885171&di=17a496a8562380ba1077eeb77641ff04&imgtype=0&src=http%3A%2F%2Fimg3.duitang.com%2Fuploads%2Fitem%2F201504%2F01%2F20150401H5753_vLVGs.jpeg,https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1584897885169&di=a8258e4790889ddacef195b762135a8b&imgtype=0&src=http%3A%2F%2Fimg.taopic.com%2Fuploads%2Fallimg%2F121006%2F219049-12100615405138.jpg,https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1584901103701&di=f759ee8c7357dacf08c5d32eb0e47643&imgtype=0&src=http%3A%2F%2Fwww.szsmack.com%2Fuploadfile%2F2018%2F0904%2F20180904063417341.jpg', '张三', '12345678901', 1, 1, 1, '2020-03-28 18:15:55');
INSERT INTO `t_house` VALUES (8, '广西 整租 两居室 南', 'https://ss0.bdstatic.com/94oJfD_bAAcT8t7mm9GUKT-xh_/timg?image&quality=100&size=b4000_4000&sec=1584887799&di=096bada498282909429a8c590521b837&src=http://img.zx123.cn/Resources/zx123cn/uploadfile/2015/0604/7487d262c1c4f06478c95cdd3e9da1d2.jpg', '广西', '两居室', '整租', '南', '广州', '女', '120', 2000, '这是详细描述', 'https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1584900956431&di=3ae92d2a1b1385a10e67352bff4ea498&imgtype=0&src=http%3A%2F%2Ficweiliimg1.pstatp.com%2Fweili%2Fbl%2F238506801108353271.jpg,https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1584901049237&di=34b88860bec9f8d0ee7d3458dd826483&imgtype=0&src=http%3A%2F%2F5b0988e595225.cdn.sohucs.com%2Fimages%2F20171124%2F6d98d95dc82747f99caba9e1ef75bc32.jpeg', '李四', '135240236547', 1, 1, 1, '2020-03-28 18:16:00');
INSERT INTO `t_house` VALUES (9, '湖南 整租 三居室 西', 'https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1584897885171&di=17a496a8562380ba1077eeb77641ff04&imgtype=0&src=http%3A%2F%2Fimg3.duitang.com%2Fuploads%2Fitem%2F201504%2F01%2F20150401H5753_vLVGs.jpeg', '湖南', '三居室', '整租', '西', '上海', '男', '110', 1500, '这是详细描述', 'https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1584900956425&di=9c25df30c23f116490986f4ed05e4016&imgtype=0&src=http%3A%2F%2Fdpic.tiankong.com%2F8c%2Fcp%2FQJ6221831393.jpg%3Fx-oss-process%3Dstyle%2Fshows', '王五', '15234702356', 10, 0, 1, '2020-03-28 18:16:03');
INSERT INTO `t_house` VALUES (10, '武汉 整租 两房一厅 北', 'https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1584897885169&di=a8258e4790889ddacef195b762135a8b&imgtype=0&src=http%3A%2F%2Fimg.taopic.com%2Fuploads%2Fallimg%2F121006%2F219049-12100615405138.jpg', '武汉', '两房一厅', '整租', '北', '上海', NULL, '80', 800, '这是详细描述', 'https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1584900956423&di=85afee865cabaa985be29cd95c061324&imgtype=0&src=http%3A%2F%2Fxtf.szzj.cn%2Fimages%2FSell%2Fin%2F2018829%2F201882995056.jpg', '燕小六', '13427854412', 10, 1, 1, '2020-03-30 21:47:33');

-- ----------------------------
-- Table structure for t_order
-- ----------------------------
DROP TABLE IF EXISTS `t_order`;
CREATE TABLE `t_order`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `userId` int(11) NOT NULL COMMENT '租客id',
  `lessorId` int(11) NOT NULL COMMENT '房主id',
  `houseId` int(11) NOT NULL COMMENT '房屋id',
  `time` datetime(0) NULL DEFAULT NULL COMMENT '签订时间',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `userId`(`userId`) USING BTREE,
  INDEX `lessorId`(`lessorId`) USING BTREE,
  INDEX `houseId`(`houseId`) USING BTREE,
  CONSTRAINT `t_order_ibfk_1` FOREIGN KEY (`userId`) REFERENCES `t_user` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `t_order_ibfk_3` FOREIGN KEY (`houseId`) REFERENCES `t_house` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for t_permission
-- ----------------------------
DROP TABLE IF EXISTS `t_permission`;
CREATE TABLE `t_permission`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '权限名称',
  `parent_id` int(11) NOT NULL COMMENT '父级ID',
  `types` int(11) NULL DEFAULT NULL COMMENT '类型',
  `url` varchar(150) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT 'url地址',
  `sorts` int(11) NULL DEFAULT NULL COMMENT '排序',
  `description` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '描述',
  `perms` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '操作权限标识',
  `component_path` varchar(150) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '组件路径',
  `icon` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '图标',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 71 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_permission
-- ----------------------------
INSERT INTO `t_permission` VALUES (4, '外链', 0, 0, 'https://github.com/252956/vue-link-admin', 202, NULL, '', '/link', 'el-icon-s-promotion');
INSERT INTO `t_permission` VALUES (5, '错误页面', 0, 0, ' ', 199, NULL, '', '/error', 'el-icon-warning');
INSERT INTO `t_permission` VALUES (6, '401', 5, 1, '/error/401', 30, NULL, 'Page401', '/error-page/401', NULL);
INSERT INTO `t_permission` VALUES (7, '404', 5, 1, '/error/404', 31, NULL, 'Page404', '/error-page/404', NULL);
INSERT INTO `t_permission` VALUES (8, '系统权限', 0, 0, '/permission', 100, NULL, '', '', 'el-icon-s-tools');
INSERT INTO `t_permission` VALUES (9, '用户管理', 8, 1, '/permission/user', 1, NULL, 'User', '/permission/user', 'el-icon-user-solid');
INSERT INTO `t_permission` VALUES (10, '角色管理', 8, 1, '/permission/role', 2, NULL, 'Role', '/permission/role', 'el-icon-s-custom');
INSERT INTO `t_permission` VALUES (11, '权限管理', 8, 1, '/permission/permission', 3, NULL, 'Permission', '/permission/permission', 'el-icon-s-help');
INSERT INTO `t_permission` VALUES (13, '房屋管理', 8, 1, '/permission/house', 4, NULL, 'Department', '/permission/house', 'el-icon-s-home');
INSERT INTO `t_permission` VALUES (14, '图标', 0, 0, '/icon', 201, NULL, 'Icons', '/icons/index', 'el-icon-s-flag');
INSERT INTO `t_permission` VALUES (16, '查询用户', 9, 2, '/rest/user/list', 1, NULL, 'user:find', '', NULL);
INSERT INTO `t_permission` VALUES (17, '新增用户', 9, 2, '/rest/user/add', 201, NULL, 'user:add', NULL, NULL);
INSERT INTO `t_permission` VALUES (18, '修改用户', 9, 2, '/rest/user/update', 202, NULL, 'user:update', NULL, NULL);
INSERT INTO `t_permission` VALUES (19, '删除用户', 9, 2, '/rest/user/delete', 203, NULL, 'user:delete', NULL, NULL);
INSERT INTO `t_permission` VALUES (20, '查询角色', 10, 2, '/rest/role/list', 210, NULL, 'role:find', NULL, NULL);
INSERT INTO `t_permission` VALUES (21, '新增角色', 10, 2, '/rest/role/add', 211, NULL, 'role:add', NULL, NULL);
INSERT INTO `t_permission` VALUES (22, '修改角色', 10, 2, '/rest/role/update', 212, NULL, 'role:update', NULL, NULL);
INSERT INTO `t_permission` VALUES (23, '删除角色', 10, 2, '/rest/role/delete', 213, NULL, 'role:delete', NULL, NULL);
INSERT INTO `t_permission` VALUES (24, '查询权限', 11, 2, '/rest/permission/all', 220, NULL, 'permission:find', NULL, NULL);
INSERT INTO `t_permission` VALUES (25, '新增权限', 11, 2, '/rest/permission/add', 221, NULL, 'permission:add', NULL, NULL);
INSERT INTO `t_permission` VALUES (26, '修改权限', 11, 2, '/rest/permission/update', 222, NULL, 'permission:update', NULL, NULL);
INSERT INTO `t_permission` VALUES (27, '删除权限', 11, 2, '/rest/permission/delete', 223, NULL, 'permission:delete', NULL, NULL);
INSERT INTO `t_permission` VALUES (28, '查询部门', 13, 2, '/rest/department/all', 240, NULL, NULL, NULL, NULL);
INSERT INTO `t_permission` VALUES (29, '新增部门', 13, 2, '/rest/department/add', 241, NULL, NULL, NULL, NULL);
INSERT INTO `t_permission` VALUES (30, '修改部门', 13, 2, '/rest/department/update', 242, NULL, NULL, NULL, NULL);
INSERT INTO `t_permission` VALUES (31, '删除部门', 13, 2, '/rest/department/delete', 243, NULL, NULL, NULL, NULL);
INSERT INTO `t_permission` VALUES (32, '我的房屋', 0, 0, ' ', 101, NULL, '', '/myhouse', 'el-icon-s-management');
INSERT INTO `t_permission` VALUES (33, '预租信息', 32, 1, ' ', 40, NULL, 'ErrorLog', '/myhouse/yz', NULL);
INSERT INTO `t_permission` VALUES (34, '预租审核', 32, 1, ' ', 41, NULL, 'Blog', '/myhouse/check', NULL);
INSERT INTO `t_permission` VALUES (41, '数据字典', 8, 1, '/permission/dict', 6, NULL, 'Dict', '/permission/dict', NULL);
INSERT INTO `t_permission` VALUES (43, '数据权限', 10, 2, '/rest/role/saveDataScope', 1, NULL, NULL, NULL, NULL);
INSERT INTO `t_permission` VALUES (44, '新增字典', 41, 2, '/rest/dict/add', 1, NULL, NULL, NULL, NULL);
INSERT INTO `t_permission` VALUES (45, '修改字典', 41, 2, '/rest/dict/update', 2, NULL, NULL, NULL, NULL);
INSERT INTO `t_permission` VALUES (46, '删除字典', 41, 2, '/rest/dict/delete', 3, NULL, NULL, NULL, NULL);
INSERT INTO `t_permission` VALUES (48, '查询日志', 34, 2, '/rest/logs/blog/list', 1, NULL, '', '', '');
INSERT INTO `t_permission` VALUES (49, '合同管理', 8, 1, '/permission/order', 5, NULL, 'Job', '/permission/order', 'el-icon-s-order');
INSERT INTO `t_permission` VALUES (50, '添加岗位', 49, 2, '/rest/job/add', 1, NULL, '', '', '');
INSERT INTO `t_permission` VALUES (51, '修改岗位', 49, 2, '/rest/job/update', 2, NULL, '', '', '');
INSERT INTO `t_permission` VALUES (52, '删除岗位', 49, 2, '/rest/job/delete', 3, NULL, '', '', '');
INSERT INTO `t_permission` VALUES (54, '组件', 0, 0, '/component', 103, NULL, '', '', 'el-icon-s-grid');
INSERT INTO `t_permission` VALUES (55, 'pdf', 54, 1, '/component/pdf', 6, NULL, 'Pdf', '/component/pdf', '');
INSERT INTO `t_permission` VALUES (56, 'excel', 54, 0, '/excel', 7, NULL, '', '', '');
INSERT INTO `t_permission` VALUES (57, 'zip', 54, 1, '/component/zip', 8, NULL, 'Zip', '/component/zip', '');
INSERT INTO `t_permission` VALUES (58, '打赏', 0, 0, 'https://252956.github.io/pages/donate.html', 203, NULL, '', '/donate', 'el-icon-s-shop');
INSERT INTO `t_permission` VALUES (59, 'upload', 54, 1, '/component/upload', 4, NULL, 'Upload', '/component/upload', '');
INSERT INTO `t_permission` VALUES (62, 'Markdown', 54, 1, '/component/markdown', 2, NULL, 'MarkdownDemo', '/component/markdown', '');
INSERT INTO `t_permission` VALUES (63, 'JSON 编辑器', 54, 1, '/component/json-editor', 3, NULL, 'JsonEditorDemo', '/component/json-editor', '');
INSERT INTO `t_permission` VALUES (64, '键盘图表', 54, 1, '/component/keyboard', 11, NULL, 'KeyboardChart', '/component/keyboard', '');
INSERT INTO `t_permission` VALUES (65, '折线图', 54, 1, '/component/line', 12, NULL, 'LineChart', '/component/line', '');
INSERT INTO `t_permission` VALUES (66, '混合图表', 54, 1, '/component/mix-chart', 13, NULL, 'MixChart', '/component/mix-chart', '');
INSERT INTO `t_permission` VALUES (67, '导出 Excel', 56, 1, '/component/excel/export-excel', 1, NULL, 'ExportExcel', '/component/excel/export-excel', '');
INSERT INTO `t_permission` VALUES (68, '导出 已选择项', 56, 1, '/component/excel/select-excel', 2, NULL, 'SelectExcel', '/component/excel/select-excel', '');
INSERT INTO `t_permission` VALUES (69, '导出 多级表头', 56, 1, '/component/excel/merge-header', 3, NULL, 'MergeHeader', '/component/excel/merge-header', '');
INSERT INTO `t_permission` VALUES (70, '首页', 0, 0, '', 1, '', NULL, '/index', 'el-icon-s-home');

-- ----------------------------
-- Table structure for t_role
-- ----------------------------
DROP TABLE IF EXISTS `t_role`;
CREATE TABLE `t_role`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `description` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 20 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_role
-- ----------------------------
INSERT INTO `t_role` VALUES (1, 'admin', '超级管理员');
INSERT INTO `t_role` VALUES (2, 'user', '用户');
INSERT INTO `t_role` VALUES (3, 'visitor', '游客');
INSERT INTO `t_role` VALUES (14, 'test1', '测试1');
INSERT INTO `t_role` VALUES (15, 'test2', '测试2');
INSERT INTO `t_role` VALUES (17, 'customer', '游客');
INSERT INTO `t_role` VALUES (18, 'test3', '测试3');
INSERT INTO `t_role` VALUES (19, 'superVIP', '超级管理员');

-- ----------------------------
-- Table structure for t_role_permission
-- ----------------------------
DROP TABLE IF EXISTS `t_role_permission`;
CREATE TABLE `t_role_permission`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `role_id` int(11) NOT NULL,
  `perm_id` int(11) NOT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `perm_id`(`perm_id`) USING BTREE,
  INDEX `role_id`(`role_id`) USING BTREE,
  CONSTRAINT `t_role_permission_ibfk_1` FOREIGN KEY (`perm_id`) REFERENCES `t_permission` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `t_role_permission_ibfk_2` FOREIGN KEY (`role_id`) REFERENCES `t_role` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 2404 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_role_permission
-- ----------------------------
INSERT INTO `t_role_permission` VALUES (2322, 1, 70);
INSERT INTO `t_role_permission` VALUES (2323, 1, 8);
INSERT INTO `t_role_permission` VALUES (2324, 1, 9);
INSERT INTO `t_role_permission` VALUES (2325, 1, 16);
INSERT INTO `t_role_permission` VALUES (2326, 1, 17);
INSERT INTO `t_role_permission` VALUES (2327, 1, 18);
INSERT INTO `t_role_permission` VALUES (2328, 1, 19);
INSERT INTO `t_role_permission` VALUES (2329, 1, 10);
INSERT INTO `t_role_permission` VALUES (2330, 1, 43);
INSERT INTO `t_role_permission` VALUES (2331, 1, 20);
INSERT INTO `t_role_permission` VALUES (2332, 1, 21);
INSERT INTO `t_role_permission` VALUES (2333, 1, 22);
INSERT INTO `t_role_permission` VALUES (2334, 1, 23);
INSERT INTO `t_role_permission` VALUES (2335, 1, 11);
INSERT INTO `t_role_permission` VALUES (2336, 1, 24);
INSERT INTO `t_role_permission` VALUES (2337, 1, 25);
INSERT INTO `t_role_permission` VALUES (2338, 1, 26);
INSERT INTO `t_role_permission` VALUES (2339, 1, 27);
INSERT INTO `t_role_permission` VALUES (2340, 1, 13);
INSERT INTO `t_role_permission` VALUES (2341, 1, 28);
INSERT INTO `t_role_permission` VALUES (2342, 1, 29);
INSERT INTO `t_role_permission` VALUES (2343, 1, 30);
INSERT INTO `t_role_permission` VALUES (2344, 1, 31);
INSERT INTO `t_role_permission` VALUES (2345, 1, 49);
INSERT INTO `t_role_permission` VALUES (2346, 1, 50);
INSERT INTO `t_role_permission` VALUES (2347, 1, 51);
INSERT INTO `t_role_permission` VALUES (2348, 1, 52);
INSERT INTO `t_role_permission` VALUES (2349, 1, 41);
INSERT INTO `t_role_permission` VALUES (2350, 1, 44);
INSERT INTO `t_role_permission` VALUES (2351, 1, 45);
INSERT INTO `t_role_permission` VALUES (2352, 1, 46);
INSERT INTO `t_role_permission` VALUES (2353, 1, 32);
INSERT INTO `t_role_permission` VALUES (2354, 1, 33);
INSERT INTO `t_role_permission` VALUES (2355, 1, 34);
INSERT INTO `t_role_permission` VALUES (2356, 1, 48);
INSERT INTO `t_role_permission` VALUES (2357, 1, 54);
INSERT INTO `t_role_permission` VALUES (2358, 1, 62);
INSERT INTO `t_role_permission` VALUES (2359, 1, 63);
INSERT INTO `t_role_permission` VALUES (2360, 1, 59);
INSERT INTO `t_role_permission` VALUES (2361, 1, 55);
INSERT INTO `t_role_permission` VALUES (2362, 1, 56);
INSERT INTO `t_role_permission` VALUES (2363, 1, 67);
INSERT INTO `t_role_permission` VALUES (2364, 1, 68);
INSERT INTO `t_role_permission` VALUES (2365, 1, 69);
INSERT INTO `t_role_permission` VALUES (2366, 1, 57);
INSERT INTO `t_role_permission` VALUES (2367, 1, 64);
INSERT INTO `t_role_permission` VALUES (2368, 1, 65);
INSERT INTO `t_role_permission` VALUES (2369, 1, 66);
INSERT INTO `t_role_permission` VALUES (2370, 1, 5);
INSERT INTO `t_role_permission` VALUES (2371, 1, 6);
INSERT INTO `t_role_permission` VALUES (2372, 1, 7);
INSERT INTO `t_role_permission` VALUES (2373, 1, 14);
INSERT INTO `t_role_permission` VALUES (2374, 1, 4);
INSERT INTO `t_role_permission` VALUES (2375, 1, 58);
INSERT INTO `t_role_permission` VALUES (2379, 15, 70);
INSERT INTO `t_role_permission` VALUES (2380, 17, 70);
INSERT INTO `t_role_permission` VALUES (2381, 18, 70);
INSERT INTO `t_role_permission` VALUES (2382, 19, 70);
INSERT INTO `t_role_permission` VALUES (2383, 19, 9);
INSERT INTO `t_role_permission` VALUES (2384, 19, 16);
INSERT INTO `t_role_permission` VALUES (2385, 19, 17);
INSERT INTO `t_role_permission` VALUES (2386, 19, 18);
INSERT INTO `t_role_permission` VALUES (2387, 19, 19);
INSERT INTO `t_role_permission` VALUES (2388, 19, 6);
INSERT INTO `t_role_permission` VALUES (2389, 19, 14);
INSERT INTO `t_role_permission` VALUES (2390, 19, 8);
INSERT INTO `t_role_permission` VALUES (2391, 19, 5);
INSERT INTO `t_role_permission` VALUES (2392, 2, 70);
INSERT INTO `t_role_permission` VALUES (2393, 2, 32);
INSERT INTO `t_role_permission` VALUES (2394, 2, 33);
INSERT INTO `t_role_permission` VALUES (2395, 2, 34);
INSERT INTO `t_role_permission` VALUES (2396, 2, 48);
INSERT INTO `t_role_permission` VALUES (2397, 2, 5);
INSERT INTO `t_role_permission` VALUES (2398, 2, 6);
INSERT INTO `t_role_permission` VALUES (2399, 2, 7);
INSERT INTO `t_role_permission` VALUES (2400, 2, 14);
INSERT INTO `t_role_permission` VALUES (2401, 2, 4);
INSERT INTO `t_role_permission` VALUES (2402, 2, 58);

-- ----------------------------
-- Table structure for t_sys_dict
-- ----------------------------
DROP TABLE IF EXISTS `t_sys_dict`;
CREATE TABLE `t_sys_dict`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '字典编号',
  `type` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '字典类型',
  `code` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '字典代码',
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '字典代码对应名称',
  `xy_bj` tinyint(4) NOT NULL DEFAULT 1 COMMENT '选用标志 (0:未选用 1:选用 )',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for t_user
-- ----------------------------
DROP TABLE IF EXISTS `t_user`;
CREATE TABLE `t_user`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `loginName` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '账号',
  `username` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '用户名',
  `password` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '密码',
  `realName` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '真实姓名',
  `phone` varchar(11) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '手机号码',
  `email` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '邮箱',
  `status` tinyint(1) NOT NULL DEFAULT 0 COMMENT '0:已冻结 1:已激活',
  `idcard` varchar(18) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '身份证',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 13 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_user
-- ----------------------------
INSERT INTO `t_user` VALUES (1, 'admin', 'admin', '9aa75c4d70930277f59d117ce19188b0', '管理员', '12345678901', 'admin@163.com', 1, '12451236687485985');
INSERT INTO `t_user` VALUES (10, 'lisi', 'lisi', '16f807d62105b4896034552ee5caeb8a', 'lisi', '110', '112233@qq.com', 1, NULL);
INSERT INTO `t_user` VALUES (11, 'ww', 'ww', '123456', 'wangwu', NULL, '112233@qq.com', 1, NULL);
INSERT INTO `t_user` VALUES (12, 'xm', 'xm', '123456', 'xiaoming', NULL, '112233@qq.com', 1, NULL);

-- ----------------------------
-- Table structure for t_user_role
-- ----------------------------
DROP TABLE IF EXISTS `t_user_role`;
CREATE TABLE `t_user_role`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) NOT NULL,
  `role_id` int(11) NOT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `user_id`(`user_id`) USING BTREE,
  INDEX `role_id`(`role_id`) USING BTREE,
  CONSTRAINT `t_user_role_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `t_user` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `t_user_role_ibfk_2` FOREIGN KEY (`role_id`) REFERENCES `t_role` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 16 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_user_role
-- ----------------------------
INSERT INTO `t_user_role` VALUES (1, 1, 1);
INSERT INTO `t_user_role` VALUES (2, 10, 2);
INSERT INTO `t_user_role` VALUES (11, 11, 2);

-- ----------------------------
-- Table structure for t_yzinfo
-- ----------------------------
DROP TABLE IF EXISTS `t_yzinfo`;
CREATE TABLE `t_yzinfo`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `userId` int(11) NOT NULL COMMENT '租客id',
  `lessorId` int(11) NOT NULL COMMENT '房主id',
  `houseId` int(11) NOT NULL COMMENT '房屋id',
  `period` int(11) NULL DEFAULT NULL COMMENT '租期',
  `yztime` datetime(0) NULL DEFAULT NULL COMMENT '预租日期',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `user_lessor_house`(`userId`, `lessorId`, `houseId`) USING BTREE,
  INDEX `houseId`(`houseId`) USING BTREE,
  INDEX `lessorId`(`lessorId`) USING BTREE,
  CONSTRAINT `t_yzinfo_ibfk_1` FOREIGN KEY (`houseId`) REFERENCES `t_house` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `t_yzinfo_ibfk_2` FOREIGN KEY (`userId`) REFERENCES `t_user` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 31 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

SET FOREIGN_KEY_CHECKS = 1;
