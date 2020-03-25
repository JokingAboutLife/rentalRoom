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

 Date: 26/03/2020 01:25:39
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
  `release_time` datetime(0) NULL DEFAULT NULL COMMENT '房屋发布时间',
  PRIMARY KEY (`id`, `userId`) USING BTREE,
  INDEX `id`(`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 6 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_house
-- ----------------------------
INSERT INTO `t_house` VALUES (1, '四合院', 'https://cube.elemecdn.com/6/94/4d3ea53c084bad6931a56d5158a48jpeg.jpeg', '北京', '一居室', NULL, NULL, '北京', '男', '100', 1000, '这是详细描述', 'https://cube.elemecdn.com/6/94/4d3ea53c084bad6931a56d5158a48jpeg.jpeg,https://ss0.bdstatic.com/94oJfD_bAAcT8t7mm9GUKT-xh_/timg?image&quality=100&size=b4000_4000&sec=1584887799&di=096bada498282909429a8c590521b837&src=http://img.zx123.cn/Resources/zx123cn/uploadfile/2015/0604/7487d262c1c4f06478c95cdd3e9da1d2.jpg,https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1584897885171&di=17a496a8562380ba1077eeb77641ff04&imgtype=0&src=http%3A%2F%2Fimg3.duitang.com%2Fuploads%2Fitem%2F201504%2F01%2F20150401H5753_vLVGs.jpeg,https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1584897885169&di=a8258e4790889ddacef195b762135a8b&imgtype=0&src=http%3A%2F%2Fimg.taopic.com%2Fuploads%2Fallimg%2F121006%2F219049-12100615405138.jpg,https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1584901103701&di=f759ee8c7357dacf08c5d32eb0e47643&imgtype=0&src=http%3A%2F%2Fwww.szsmack.com%2Fuploadfile%2F2018%2F0904%2F20180904063417341.jpg', '张三', '12345678901', 1, 1, 0, '2020-03-04 22:40:22');
INSERT INTO `t_house` VALUES (2, '海景房', 'https://ss0.bdstatic.com/94oJfD_bAAcT8t7mm9GUKT-xh_/timg?image&quality=100&size=b4000_4000&sec=1584887799&di=096bada498282909429a8c590521b837&src=http://img.zx123.cn/Resources/zx123cn/uploadfile/2015/0604/7487d262c1c4f06478c95cdd3e9da1d2.jpg', '广州', '两居室', NULL, NULL, '广州', '女', '120', 2000, '这是详细描述', 'https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1584900956431&di=3ae92d2a1b1385a10e67352bff4ea498&imgtype=0&src=http%3A%2F%2Ficweiliimg1.pstatp.com%2Fweili%2Fbl%2F238506801108353271.jpg,https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1584901049237&di=34b88860bec9f8d0ee7d3458dd826483&imgtype=0&src=http%3A%2F%2F5b0988e595225.cdn.sohucs.com%2Fimages%2F20171124%2F6d98d95dc82747f99caba9e1ef75bc32.jpeg', '李四', '135240236547', 1, 1, 1, '2020-03-13 05:40:29');
INSERT INTO `t_house` VALUES (3, '别墅', 'https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1584897885171&di=17a496a8562380ba1077eeb77641ff04&imgtype=0&src=http%3A%2F%2Fimg3.duitang.com%2Fuploads%2Fitem%2F201504%2F01%2F20150401H5753_vLVGs.jpeg', '上海', '三居室', NULL, NULL, '上海', '男', '110', 1500, '这是详细描述', 'https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1584900956425&di=9c25df30c23f116490986f4ed05e4016&imgtype=0&src=http%3A%2F%2Fdpic.tiankong.com%2F8c%2Fcp%2FQJ6221831393.jpg%3Fx-oss-process%3Dstyle%2Fshows', '王五', '15234702356', 10, 1, 1, '2020-03-10 17:40:37');
INSERT INTO `t_house` VALUES (4, '民宿', 'https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1584897885169&di=a8258e4790889ddacef195b762135a8b&imgtype=0&src=http%3A%2F%2Fimg.taopic.com%2Fuploads%2Fallimg%2F121006%2F219049-12100615405138.jpg', '上海', '两房一厅', NULL, NULL, '上海', NULL, '80', 800, '这是详细描述', 'https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1584900956423&di=85afee865cabaa985be29cd95c061324&imgtype=0&src=http%3A%2F%2Fxtf.szzj.cn%2Fimages%2FSell%2Fin%2F2018829%2F201882995056.jpg', '燕小六', '13427854412', 10, 1, 1, '2020-03-21 11:40:46');
INSERT INTO `t_house` VALUES (5, '经济房', 'https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1584897885169&di=a8258e4790889ddacef195b762135a8b&imgtype=0&src=http%3A%2F%2Fimg.taopic.com%2Fuploads%2Fallimg%2F121006%2F219049-12100615405138.jpg', '杭州', '一房一厅', NULL, NULL, '杭州', NULL, '50', 500, '这是详细描述', 'https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1584900956423&di=85afee865cabaa985be29cd95c061324&imgtype=0&src=http%3A%2F%2Fxtf.szzj.cn%2Fimages%2FSell%2Fin%2F2018829%2F201882995056.jpg', '小明', '18236547586', 2, 1, 1, '2020-03-25 19:40:53');

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
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_order
-- ----------------------------

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
  `levels` int(11) NULL DEFAULT NULL,
  `state` int(11) NULL DEFAULT NULL,
  `sorts` int(11) NULL DEFAULT NULL COMMENT '排序',
  `description` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '描述',
  `component_name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '组件名称',
  `component_path` varchar(150) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '组件路径',
  `icon` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '图标',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 75 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_permission
-- ----------------------------
INSERT INTO `t_permission` VALUES (4, '外链', 0, 0, 'https://github.com/252956/vue-link-admin', NULL, NULL, 202, NULL, '', '', 'link');
INSERT INTO `t_permission` VALUES (5, '错误页面', 0, 0, '/error', NULL, NULL, 199, NULL, '', '', 'el-icon-warning');
INSERT INTO `t_permission` VALUES (6, '401', 5, 1, '/error/401', NULL, NULL, 30, NULL, 'Page401', '/error-page/401', NULL);
INSERT INTO `t_permission` VALUES (7, '404', 5, 1, '/error/404', NULL, NULL, 31, NULL, 'Page404', '/error-page/404', NULL);
INSERT INTO `t_permission` VALUES (8, '系统权限', 0, 0, '/permission', NULL, NULL, 100, NULL, '', '', 'el-icon-s-tools');
INSERT INTO `t_permission` VALUES (9, '用户管理', 8, 1, '/permission/user', NULL, NULL, 1, NULL, 'User', '/permission/user', 'el-icon-user-solid');
INSERT INTO `t_permission` VALUES (10, '角色管理', 8, 1, '/permission/role', NULL, NULL, 2, NULL, 'Role', '/permission/role', 'el-icon-s-custom');
INSERT INTO `t_permission` VALUES (11, '权限管理', 8, 1, '/permission/permission', NULL, NULL, 3, NULL, 'Permission', '/permission/permission', 'el-icon-s-help');
INSERT INTO `t_permission` VALUES (13, '房屋管理', 8, 1, '/permission/house', NULL, NULL, 4, NULL, 'Department', '/permission/department', 'el-icon-s-home');
INSERT INTO `t_permission` VALUES (14, '图标', 0, 0, '/icon', NULL, NULL, 201, NULL, 'Icons', '/icons/index', 'icon');
INSERT INTO `t_permission` VALUES (16, '查询用户', 9, 2, '/rest/user/list', NULL, NULL, 1, NULL, '', '', NULL);
INSERT INTO `t_permission` VALUES (17, '新增用户', 9, 2, '/rest/user/add', NULL, NULL, 201, NULL, NULL, NULL, NULL);
INSERT INTO `t_permission` VALUES (18, '修改用户', 9, 2, '/rest/user/update', NULL, NULL, 202, NULL, NULL, NULL, NULL);
INSERT INTO `t_permission` VALUES (19, '删除用户', 9, 2, '/rest/user/delete', NULL, NULL, 203, NULL, NULL, NULL, NULL);
INSERT INTO `t_permission` VALUES (20, '查询角色', 10, 2, '/rest/role/list', NULL, NULL, 210, NULL, NULL, NULL, NULL);
INSERT INTO `t_permission` VALUES (21, '新增角色', 10, 2, '/rest/role/add', NULL, NULL, 211, NULL, NULL, NULL, NULL);
INSERT INTO `t_permission` VALUES (22, '修改角色', 10, 2, '/rest/role/update', NULL, NULL, 212, NULL, NULL, NULL, NULL);
INSERT INTO `t_permission` VALUES (23, '删除角色', 10, 2, '/rest/role/delete', NULL, NULL, 213, NULL, NULL, NULL, NULL);
INSERT INTO `t_permission` VALUES (24, '查询权限', 11, 2, '/rest/permission/all', NULL, NULL, 220, NULL, NULL, NULL, NULL);
INSERT INTO `t_permission` VALUES (25, '新增权限', 11, 2, '/rest/permission/add', NULL, NULL, 221, NULL, NULL, NULL, NULL);
INSERT INTO `t_permission` VALUES (26, '修改权限', 11, 2, '/rest/permission/update', NULL, NULL, 222, NULL, NULL, NULL, NULL);
INSERT INTO `t_permission` VALUES (27, '删除权限', 11, 2, '/rest/permission/delete', NULL, NULL, 223, NULL, NULL, NULL, NULL);
INSERT INTO `t_permission` VALUES (28, '查询部门', 13, 2, '/rest/department/all', NULL, NULL, 240, NULL, NULL, NULL, NULL);
INSERT INTO `t_permission` VALUES (29, '新增部门', 13, 2, '/rest/department/add', NULL, NULL, 241, NULL, NULL, NULL, NULL);
INSERT INTO `t_permission` VALUES (30, '修改部门', 13, 2, '/rest/department/update', NULL, NULL, 242, NULL, NULL, NULL, NULL);
INSERT INTO `t_permission` VALUES (31, '删除部门', 13, 2, '/rest/department/delete', NULL, NULL, 243, NULL, NULL, NULL, NULL);
INSERT INTO `t_permission` VALUES (32, '系统监控', 0, 0, '/monitor', NULL, NULL, 101, NULL, '', '', 'monitor');
INSERT INTO `t_permission` VALUES (33, '错误日志', 32, 1, '/monitor/error-log', NULL, NULL, 40, NULL, 'ErrorLog', '/monitor/error-log', NULL);
INSERT INTO `t_permission` VALUES (34, '业务日志', 32, 1, '/monitor/blog', NULL, NULL, 41, NULL, 'Blog', '/monitor/blog', NULL);
INSERT INTO `t_permission` VALUES (41, '数据字典', 8, 1, '/permission/dict', NULL, NULL, 6, NULL, 'Dict', '/permission/dict', NULL);
INSERT INTO `t_permission` VALUES (43, '数据权限', 10, 2, '/rest/role/saveDataScope', NULL, NULL, 1, NULL, NULL, NULL, NULL);
INSERT INTO `t_permission` VALUES (44, '新增字典', 41, 2, '/rest/dict/add', NULL, NULL, 1, NULL, NULL, NULL, NULL);
INSERT INTO `t_permission` VALUES (45, '修改字典', 41, 2, '/rest/dict/update', NULL, NULL, 2, NULL, NULL, NULL, NULL);
INSERT INTO `t_permission` VALUES (46, '删除字典', 41, 2, '/rest/dict/delete', NULL, NULL, 3, NULL, NULL, NULL, NULL);
INSERT INTO `t_permission` VALUES (48, '查询日志', 34, 2, '/rest/logs/blog/list', NULL, NULL, 1, NULL, '', '', '');
INSERT INTO `t_permission` VALUES (49, '合同管理', 8, 1, '/permission/order', NULL, NULL, 5, NULL, 'Job', '/permission/job', '');
INSERT INTO `t_permission` VALUES (50, '添加岗位', 49, 2, '/rest/job/add', NULL, NULL, 1, NULL, '', '', '');
INSERT INTO `t_permission` VALUES (51, '修改岗位', 49, 2, '/rest/job/update', NULL, NULL, 2, NULL, '', '', '');
INSERT INTO `t_permission` VALUES (52, '删除岗位', 49, 2, '/rest/job/delete', NULL, NULL, 3, NULL, '', '', '');
INSERT INTO `t_permission` VALUES (54, '组件', 0, 0, '/component', NULL, NULL, 103, NULL, '', '', 'component');
INSERT INTO `t_permission` VALUES (55, 'pdf', 54, 1, '/component/pdf', NULL, NULL, 6, NULL, 'Pdf', '/component/pdf', '');
INSERT INTO `t_permission` VALUES (56, 'excel', 54, 0, '/excel', NULL, NULL, 7, NULL, '', '', '');
INSERT INTO `t_permission` VALUES (57, 'zip', 54, 1, '/component/zip', NULL, NULL, 8, NULL, 'Zip', '/component/zip', '');
INSERT INTO `t_permission` VALUES (58, '打赏', 0, 0, 'https://252956.github.io/pages/donate.html', NULL, NULL, 203, NULL, '', '', 'donate');
INSERT INTO `t_permission` VALUES (59, 'upload', 54, 1, '/component/upload', NULL, NULL, 4, NULL, 'Upload', '/component/upload', '');
INSERT INTO `t_permission` VALUES (62, 'Markdown', 54, 1, '/component/markdown', NULL, NULL, 2, NULL, 'MarkdownDemo', '/component/markdown', '');
INSERT INTO `t_permission` VALUES (63, 'JSON 编辑器', 54, 1, '/component/json-editor', NULL, NULL, 3, NULL, 'JsonEditorDemo', '/component/json-editor', '');
INSERT INTO `t_permission` VALUES (64, '键盘图表', 54, 1, '/component/keyboard', NULL, NULL, 11, NULL, 'KeyboardChart', '/component/keyboard', '');
INSERT INTO `t_permission` VALUES (65, '折线图', 54, 1, '/component/line', NULL, NULL, 12, NULL, 'LineChart', '/component/line', '');
INSERT INTO `t_permission` VALUES (66, '混合图表', 54, 1, '/component/mix-chart', NULL, NULL, 13, NULL, 'MixChart', '/component/mix-chart', '');
INSERT INTO `t_permission` VALUES (67, '导出 Excel', 56, 1, '/component/excel/export-excel', NULL, NULL, 1, NULL, 'ExportExcel', '/component/excel/export-excel', '');
INSERT INTO `t_permission` VALUES (68, '导出 已选择项', 56, 1, '/component/excel/select-excel', NULL, NULL, 2, NULL, 'SelectExcel', '/component/excel/select-excel', '');
INSERT INTO `t_permission` VALUES (69, '导出 多级表头', 56, 1, '/component/excel/merge-header', NULL, NULL, 3, NULL, 'MergeHeader', '/component/excel/merge-header', '');

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
INSERT INTO `t_role` VALUES (11, 'test', '测试角色');
INSERT INTO `t_role` VALUES (14, 'test1', '测试1');
INSERT INTO `t_role` VALUES (15, 'test2', '测试2');
INSERT INTO `t_role` VALUES (17, 'customer', '游客');
INSERT INTO `t_role` VALUES (18, 'test3', '测试3');
INSERT INTO `t_role` VALUES (19, '超级管理员', '描述');

-- ----------------------------
-- Table structure for t_role_permission
-- ----------------------------
DROP TABLE IF EXISTS `t_role_permission`;
CREATE TABLE `t_role_permission`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `role_id` int(11) NOT NULL,
  `perm_id` int(11) NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2126 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

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
INSERT INTO `t_role_permission` VALUES (2109, 19, 9);
INSERT INTO `t_role_permission` VALUES (2110, 19, 16);
INSERT INTO `t_role_permission` VALUES (2111, 19, 17);
INSERT INTO `t_role_permission` VALUES (2112, 19, 18);
INSERT INTO `t_role_permission` VALUES (2113, 19, 19);
INSERT INTO `t_role_permission` VALUES (2114, 19, 6);
INSERT INTO `t_role_permission` VALUES (2115, 19, 14);
INSERT INTO `t_role_permission` VALUES (2116, 19, 8);
INSERT INTO `t_role_permission` VALUES (2117, 19, 5);
INSERT INTO `t_role_permission` VALUES (2118, 11, 7);
INSERT INTO `t_role_permission` VALUES (2119, 11, 5);
INSERT INTO `t_role_permission` VALUES (2120, 2, 5);
INSERT INTO `t_role_permission` VALUES (2121, 2, 6);
INSERT INTO `t_role_permission` VALUES (2122, 2, 7);
INSERT INTO `t_role_permission` VALUES (2123, 2, 14);
INSERT INTO `t_role_permission` VALUES (2124, 2, 4);
INSERT INTO `t_role_permission` VALUES (2125, 2, 58);

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
-- Records of t_sys_dict
-- ----------------------------

-- ----------------------------
-- Table structure for t_user
-- ----------------------------
DROP TABLE IF EXISTS `t_user`;
CREATE TABLE `t_user`  (
  `id` int(11) UNSIGNED NOT NULL AUTO_INCREMENT,
  `loginName` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '账号',
  `username` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '用户名',
  `password` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '密码',
  `realName` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '真实姓名',
  `phone` varchar(11) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '手机号码',
  `email` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '邮箱',
  `status` tinyint(1) NOT NULL DEFAULT 0 COMMENT '0:已冻结 1:已激活',
  `idcard` varchar(18) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '身份证',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 36 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_user
-- ----------------------------
INSERT INTO `t_user` VALUES (1, 'admin', 'admin', '123456', NULL, NULL, NULL, 0, NULL);
INSERT INTO `t_user` VALUES (10, 'lisi', 'lisi', '123456', 'lisi', '110', '112233@qq.com', 0, NULL);
INSERT INTO `t_user` VALUES (11, 'ww', 'ww', '123456', 'wangwu', NULL, '112233@qq.com', 1, NULL);
INSERT INTO `t_user` VALUES (12, 'xm', 'xm', '123456', 'xiaoming', NULL, '112233@qq.com', 1, NULL);
INSERT INTO `t_user` VALUES (16, '测试111', '测试111', '123456', '测试用户', NULL, '111@qq.com', 1, NULL);
INSERT INTO `t_user` VALUES (35, '222', '啊啊啊', '123456', '山东省地方', 'sadf', 'sadf', 1, 'sdf');

-- ----------------------------
-- Table structure for t_user_role
-- ----------------------------
DROP TABLE IF EXISTS `t_user_role`;
CREATE TABLE `t_user_role`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) NOT NULL,
  `role_id` int(11) NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 14 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_user_role
-- ----------------------------
INSERT INTO `t_user_role` VALUES (1, 1, 1);
INSERT INTO `t_user_role` VALUES (2, 10, 2);
INSERT INTO `t_user_role` VALUES (3, 29, 2);
INSERT INTO `t_user_role` VALUES (4, 30, 2);
INSERT INTO `t_user_role` VALUES (5, 31, 2);
INSERT INTO `t_user_role` VALUES (6, 32, 14);
INSERT INTO `t_user_role` VALUES (7, 33, 17);
INSERT INTO `t_user_role` VALUES (8, 34, 14);
INSERT INTO `t_user_role` VALUES (9, 35, 2);
INSERT INTO `t_user_role` VALUES (10, 36, 2);
INSERT INTO `t_user_role` VALUES (11, 11, 2);
INSERT INTO `t_user_role` VALUES (12, 12, 2);
INSERT INTO `t_user_role` VALUES (13, 16, 2);

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
  `yztime` datetime(0) NULL DEFAULT NULL COMMENT '欲租日期',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `houseId`(`houseId`) USING BTREE,
  CONSTRAINT `t_yzinfo_ibfk_1` FOREIGN KEY (`houseId`) REFERENCES `t_house` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_yzinfo
-- ----------------------------

SET FOREIGN_KEY_CHECKS = 1;
