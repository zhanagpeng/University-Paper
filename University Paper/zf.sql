/*
 Navicat Premium Data Transfer

 Source Server         : local
 Source Server Type    : MySQL
 Source Server Version : 50725 (5.7.25)
 Source Host           : localhost:3306
 Source Schema         : zf

 Target Server Type    : MySQL
 Target Server Version : 50725 (5.7.25)
 File Encoding         : 65001

 Date: 18/03/2022 17:01:12
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for log_info
-- ----------------------------
DROP TABLE IF EXISTS `log_info`;
CREATE TABLE `log_info`  (
  `id` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `action` varchar(5) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '事件',
  `create_time` datetime NULL DEFAULT NULL,
  `create_user` varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `update_time` datetime NULL DEFAULT NULL,
  `update_user` varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of log_info
-- ----------------------------
INSERT INTO `log_info` VALUES ('1c34bb1d8cf668b2f6354e858a213f96', '登录', '2023-05-18 10:54:48', '798fddc17f2211eb973d6100d940b6cf', NULL, NULL);
INSERT INTO `log_info` VALUES ('fdbe88d437a334c1fbe7efcc3a3efcd8', '登录日志', '2023-05-18 10:55:02', '798fddc17f2211eb973d6100d940b6cf', NULL, NULL);
INSERT INTO `log_info` VALUES ('245016a255a68b594acec2f8f5ef3b50', '角色管理', '2023-05-18 10:55:08', '798fddc17f2211eb973d6100d940b6cf', NULL, NULL);
INSERT INTO `log_info` VALUES ('363b547b8488d90aacf5edc48b4f51f7', '功能日志', '2023-05-18 10:55:09', '798fddc17f2211eb973d6100d940b6cf', NULL, NULL);
INSERT INTO `log_info` VALUES ('fbf960abafe54383837ca4eebd1015a0', '用户管理', '2023-05-18 10:55:14', '798fddc17f2211eb973d6100d940b6cf', NULL, NULL);
INSERT INTO `log_info` VALUES ('603d9559f1e11edd8c9897a353bc263e', '用户管理', '2023-05-18 10:55:14', '798fddc17f2211eb973d6100d940b6cf', NULL, NULL);
INSERT INTO `log_info` VALUES ('0715143a1c07035e5b30bafc2ca774c1', '角色管理', '2023-05-18 10:55:14', '798fddc17f2211eb973d6100d940b6cf', NULL, NULL);
INSERT INTO `log_info` VALUES ('93515f581f2f9f5fe7adfcc81eeb3ceb', '登录', '2023-05-18 10:58:14', '798fddc17f2211eb973d6100d940b6cf', NULL, NULL);
INSERT INTO `log_info` VALUES ('d6663cd29954bca87f2179cfe1885f10', '登录日志', '2023-05-18 10:58:18', '798fddc17f2211eb973d6100d940b6cf', NULL, NULL);
INSERT INTO `log_info` VALUES ('2f3829ccb9975a210abbc4c2b7cebfdd', '功能日志', '2023-05-18 10:58:20', '798fddc17f2211eb973d6100d940b6cf', NULL, NULL);
INSERT INTO `log_info` VALUES ('442ae4465d159a782ebd17194b57a265', '角色管理', '2023-05-18 10:58:23', '798fddc17f2211eb973d6100d940b6cf', NULL, NULL);
INSERT INTO `log_info` VALUES ('8ad751616fadea96a76f9517dd9d4343', '用户管理', '2023-05-18 10:58:41', '798fddc17f2211eb973d6100d940b6cf', NULL, NULL);
INSERT INTO `log_info` VALUES ('0c045e9adeb8298cbe0c2429b3e24e8f', '用户管理', '2023-05-18 10:58:41', '798fddc17f2211eb973d6100d940b6cf', NULL, NULL);
INSERT INTO `log_info` VALUES ('599974cfe851319086a7784b803375c8', '角色管理', '2023-05-18 10:58:41', '798fddc17f2211eb973d6100d940b6cf', NULL, NULL);
INSERT INTO `log_info` VALUES ('e9fdf5370e39b66d228d00585cb4856a', '注销', '2023-05-18 10:59:04', '798fddc17f2211eb973d6100d940b6cf', NULL, NULL);
INSERT INTO `log_info` VALUES ('0a39652b42c2a59c6e09c61f140aadb9', '登录', '2023-05-18 10:59:06', '798fddc17f2211eb973d6100d940b6cf', NULL, NULL);
INSERT INTO `log_info` VALUES ('a882ced902f3f031f243e07da0ebbbf2', '登录日志', '2023-05-18 10:59:08', '798fddc17f2211eb973d6100d940b6cf', NULL, NULL);
INSERT INTO `log_info` VALUES ('77f3b263a364fe7a6f3a574c43814218', '角色管理', '2023-05-18 10:59:25', '798fddc17f2211eb973d6100d940b6cf', NULL, NULL);
INSERT INTO `log_info` VALUES ('ee0f2f2e75060517852bd1ec8389aae3', '功能日志', '2023-05-18 10:59:44', '798fddc17f2211eb973d6100d940b6cf', NULL, NULL);
INSERT INTO `log_info` VALUES ('d8fa1d24779dce641fbabf95b5632f1a', '用户管理', '2023-05-18 10:59:50', '798fddc17f2211eb973d6100d940b6cf', NULL, NULL);
INSERT INTO `log_info` VALUES ('ee6dfec982022488f455da4598e022ba', '用户管理', '2023-05-18 10:59:50', '798fddc17f2211eb973d6100d940b6cf', NULL, NULL);
INSERT INTO `log_info` VALUES ('a2ac82988cd56d641975980ee1d2f535', '角色管理', '2023-05-18 10:59:50', '798fddc17f2211eb973d6100d940b6cf', NULL, NULL);
INSERT INTO `log_info` VALUES ('56676873b73bced63d0bbfcb7c52001a', '用户管理', '2023-05-18 11:00:05', '798fddc17f2211eb973d6100d940b6cf', NULL, NULL);
INSERT INTO `log_info` VALUES ('89fc52f3300f481884776d87d7de64b8', '用户管理', '2023-05-18 11:01:56', '798fddc17f2211eb973d6100d940b6cf', NULL, NULL);
INSERT INTO `log_info` VALUES ('7ae21d88b5551632b614d318edd4b547', '用户管理', '2023-05-18 11:01:56', '798fddc17f2211eb973d6100d940b6cf', NULL, NULL);
INSERT INTO `log_info` VALUES ('9f27533780882ff526adb64606c0ee63', '角色管理', '2023-05-18 11:01:56', '798fddc17f2211eb973d6100d940b6cf', NULL, NULL);
INSERT INTO `log_info` VALUES ('31ed7c5e8329926e9814ec952584770a', '用户管理', '2023-05-18 11:01:58', '798fddc17f2211eb973d6100d940b6cf', NULL, NULL);
INSERT INTO `log_info` VALUES ('9795aa704de37356e134c0834283d428', '角色管理', '2023-05-18 11:01:58', '798fddc17f2211eb973d6100d940b6cf', NULL, NULL);
INSERT INTO `log_info` VALUES ('480b5c87cc8d0e692307ae755d8ed8f3', '用户管理', '2023-05-18 11:01:58', '798fddc17f2211eb973d6100d940b6cf', NULL, NULL);
INSERT INTO `log_info` VALUES ('866554f557dd35e1691e4fcdd58a1fdc', '用户管理', '2023-05-18 11:02:03', '798fddc17f2211eb973d6100d940b6cf', NULL, NULL);
INSERT INTO `log_info` VALUES ('19ff5b6c451673c3c164b544690c5ad1', '登录日志', '2023-05-18 11:02:15', '798fddc17f2211eb973d6100d940b6cf', NULL, NULL);
INSERT INTO `log_info` VALUES ('70a27d3cc17929cb865b442a0e609a81', '角色管理', '2023-05-18 11:02:17', '798fddc17f2211eb973d6100d940b6cf', NULL, NULL);
INSERT INTO `log_info` VALUES ('5cd991c8c1d46ef33cd6f814dec91391', '用户管理', '2023-05-18 11:02:38', '798fddc17f2211eb973d6100d940b6cf', NULL, NULL);
INSERT INTO `log_info` VALUES ('93f1f783122cfc17e813a090d6f1b7d2', '功能日志', '2023-05-18 11:03:02', '798fddc17f2211eb973d6100d940b6cf', NULL, NULL);
INSERT INTO `log_info` VALUES ('da19601dd85d8b95008a0ec7f904a21d', '菜单管理', '2023-05-18 11:03:14', '798fddc17f2211eb973d6100d940b6cf', NULL, NULL);
INSERT INTO `log_info` VALUES ('69db63c6ee9861a84bc676041d39d63a', '菜单管理', '2023-05-18 11:03:14', '798fddc17f2211eb973d6100d940b6cf', NULL, NULL);
INSERT INTO `log_info` VALUES ('c4a92e3a04d9f242deb9612f50747748', '菜单管理', '2023-05-18 11:03:31', '798fddc17f2211eb973d6100d940b6cf', NULL, NULL);
INSERT INTO `log_info` VALUES ('d23b4675695a18725758bb127db3e33a', '菜单管理', '2023-05-18 11:03:31', '798fddc17f2211eb973d6100d940b6cf', NULL, NULL);
INSERT INTO `log_info` VALUES ('573f03f97e2f478a74064c2c888b993c', '商品管理', '2023-05-18 11:03:39', '798fddc17f2211eb973d6100d940b6cf', NULL, NULL);
INSERT INTO `log_info` VALUES ('f73fd98bc345645f4be945ae8394ca3c', '菜单管理', '2023-05-18 11:03:44', '798fddc17f2211eb973d6100d940b6cf', NULL, NULL);
INSERT INTO `log_info` VALUES ('c36996156bf9ac8bdf4cb6a263c25fb2', '菜单管理', '2023-05-18 11:03:44', '798fddc17f2211eb973d6100d940b6cf', NULL, NULL);
INSERT INTO `log_info` VALUES ('10870d9a2d3b3146bd4a6513a85b3b63', '登录', '2023-05-18 11:22:04', '798fddc17f2211eb973d6100d940b6cf', NULL, NULL);
INSERT INTO `log_info` VALUES ('dfb0682a5f15efb65bf94b85a43cc95f', '登录', '2023-05-18 13:38:44', '798fddc17f2211eb973d6100d940b6cf', NULL, NULL);
INSERT INTO `log_info` VALUES ('176689bb4016906c528dd1c75109bbff', '登录日志', '2023-05-18 14:26:31', '798fddc17f2211eb973d6100d940b6cf', NULL, NULL);
INSERT INTO `log_info` VALUES ('79ec2ad727f8dc3316e8c9d834a00808', '角色管理', '2023-05-18 14:28:46', '798fddc17f2211eb973d6100d940b6cf', NULL, NULL);
INSERT INTO `log_info` VALUES ('06c266aa430576bdc1d945c4fd9958af', '功能日志', '2023-05-18 14:28:47', '798fddc17f2211eb973d6100d940b6cf', NULL, NULL);
INSERT INTO `log_info` VALUES ('a04dfebef46a7596b9be4cfa1bab7332', '用户管理', '2023-05-18 14:28:49', '798fddc17f2211eb973d6100d940b6cf', NULL, NULL);
INSERT INTO `log_info` VALUES ('3de7c1072ae62ad38abf9b23a7f16ba3', '用户管理', '2023-05-18 14:28:49', '798fddc17f2211eb973d6100d940b6cf', NULL, NULL);
INSERT INTO `log_info` VALUES ('c794ff66eb4b2f830b0b58eefc5e9911', '角色管理', '2023-05-18 14:28:49', '798fddc17f2211eb973d6100d940b6cf', NULL, NULL);
INSERT INTO `log_info` VALUES ('999ba5b3afa7e1e3a5e5acf548b0bb23', '菜单管理', '2023-05-18 14:33:40', '798fddc17f2211eb973d6100d940b6cf', NULL, NULL);
INSERT INTO `log_info` VALUES ('5da4e43cbbe9d244ba6ebc77d67204f5', '菜单管理', '2023-05-18 14:33:40', '798fddc17f2211eb973d6100d940b6cf', NULL, NULL);
INSERT INTO `log_info` VALUES ('de975a58a848325d77251eb766398546', '菜单管理', '2023-05-18 14:33:50', '798fddc17f2211eb973d6100d940b6cf', NULL, NULL);
INSERT INTO `log_info` VALUES ('43e06ca3dc0bf142066dbc3b2be607e7', '菜单管理', '2023-05-18 14:34:20', '798fddc17f2211eb973d6100d940b6cf', NULL, NULL);
INSERT INTO `log_info` VALUES ('a9fb8fbcb4fb2df9f578ed4df4de21fe', '菜单管理', '2023-05-18 14:34:38', '798fddc17f2211eb973d6100d940b6cf', NULL, NULL);
INSERT INTO `log_info` VALUES ('82026e260f846b21bb997ff54e5235e3', '菜单管理', '2023-05-18 14:34:38', '798fddc17f2211eb973d6100d940b6cf', NULL, NULL);
INSERT INTO `log_info` VALUES ('00289bf88d659e4450f28bd045e1e659', '菜单管理', '2023-05-18 14:34:44', '798fddc17f2211eb973d6100d940b6cf', NULL, NULL);
INSERT INTO `log_info` VALUES ('c4cfb789b546d8557f384104cc6b12b1', '菜单管理', '2023-05-18 14:35:07', '798fddc17f2211eb973d6100d940b6cf', NULL, NULL);
INSERT INTO `log_info` VALUES ('a1ce3066f887cbe5ac08d85b87837e7d', '菜单管理', '2023-05-18 14:35:13', '798fddc17f2211eb973d6100d940b6cf', NULL, NULL);
INSERT INTO `log_info` VALUES ('c59437c4a19ab684502f685ddd8320da', '菜单管理', '2023-05-18 14:35:13', '798fddc17f2211eb973d6100d940b6cf', NULL, NULL);
INSERT INTO `log_info` VALUES ('97e71bf8b3ab969e975cb709357722a1', '菜单管理', '2023-05-18 14:35:17', '798fddc17f2211eb973d6100d940b6cf', NULL, NULL);
INSERT INTO `log_info` VALUES ('4769bc695d984aca842a0629097e1a08', '菜单管理', '2023-05-18 14:35:17', '798fddc17f2211eb973d6100d940b6cf', NULL, NULL);
INSERT INTO `log_info` VALUES ('5e45b56f2bf0537015fcb971c179ab16', '菜单管理', '2023-05-18 14:35:28', '798fddc17f2211eb973d6100d940b6cf', NULL, NULL);
INSERT INTO `log_info` VALUES ('756f604898c220d07d62ea3a72021998', '菜单管理', '2023-05-18 14:35:28', '798fddc17f2211eb973d6100d940b6cf', NULL, NULL);
INSERT INTO `log_info` VALUES ('9157c04d53675a70283434a8cd6a3b08', '登录', '2023-05-18 14:50:13', '798fddc17f2211eb973d6100d940b6cf', NULL, NULL);
INSERT INTO `log_info` VALUES ('1ce347705368e2c5990c000a439d6b86', '菜单管理', '2023-05-18 14:50:22', '798fddc17f2211eb973d6100d940b6cf', NULL, NULL);
INSERT INTO `log_info` VALUES ('15b832fbd02305dd5eb3da0d641b851f', '菜单管理', '2023-05-18 14:50:22', '798fddc17f2211eb973d6100d940b6cf', NULL, NULL);
INSERT INTO `log_info` VALUES ('759a701443f10de640733342ee02bad7', '菜单管理', '2023-05-18 14:50:33', '798fddc17f2211eb973d6100d940b6cf', NULL, NULL);
INSERT INTO `log_info` VALUES ('c4ad4349fe279239b788dbeef2c02493', '菜单管理', '2023-05-18 14:51:13', '798fddc17f2211eb973d6100d940b6cf', NULL, NULL);
INSERT INTO `log_info` VALUES ('956c97cd4680f4e4b90335a92a32260c', '菜单管理', '2023-05-18 14:51:15', '798fddc17f2211eb973d6100d940b6cf', NULL, NULL);
INSERT INTO `log_info` VALUES ('0a7c7c2fb138de637cc848e7c2017944', '菜单管理', '2023-05-18 14:51:15', '798fddc17f2211eb973d6100d940b6cf', NULL, NULL);
INSERT INTO `log_info` VALUES ('430c401c13877fe511db6b89c812ac08', '菜单管理', '2023-05-18 14:51:35', '798fddc17f2211eb973d6100d940b6cf', NULL, NULL);
INSERT INTO `log_info` VALUES ('427eea579203956828d17742fe257d15', '菜单管理', '2023-05-18 14:51:42', '798fddc17f2211eb973d6100d940b6cf', NULL, NULL);
INSERT INTO `log_info` VALUES ('3b30b7ff3ee94c79de6ac0507b5ca4c9', '菜单管理', '2023-05-18 14:51:46', '798fddc17f2211eb973d6100d940b6cf', NULL, NULL);
INSERT INTO `log_info` VALUES ('f68de22deeaf02281a83f5557b734679', '菜单管理', '2023-05-18 14:51:46', '798fddc17f2211eb973d6100d940b6cf', NULL, NULL);
INSERT INTO `log_info` VALUES ('a32941f0ba248b2dbd170d357b1442f0', '角色管理', '2023-05-18 14:51:53', '798fddc17f2211eb973d6100d940b6cf', NULL, NULL);
INSERT INTO `log_info` VALUES ('bc5b4d3135dc31d6e13cee87a448a7d0', '角色管理', '2023-05-18 14:52:05', '798fddc17f2211eb973d6100d940b6cf', NULL, NULL);
INSERT INTO `log_info` VALUES ('544a8127fa95ec28cda59302c06dfaa5', '菜单管理', '2023-05-18 14:52:12', '798fddc17f2211eb973d6100d940b6cf', NULL, NULL);
INSERT INTO `log_info` VALUES ('381dca6a06837db9992c2c0de9ba582e', '菜单管理', '2023-05-18 14:52:12', '798fddc17f2211eb973d6100d940b6cf', NULL, NULL);
INSERT INTO `log_info` VALUES ('04daade3e143e1141c6df64be2f7fcff', '角色管理', '2023-05-18 15:05:31', '798fddc17f2211eb973d6100d940b6cf', NULL, NULL);
INSERT INTO `log_info` VALUES ('c36decf225c67621a41747094cca6e36', '角色管理', '2023-05-18 15:06:49', '798fddc17f2211eb973d6100d940b6cf', NULL, NULL);
INSERT INTO `log_info` VALUES ('59ac624c99d113aba329958d2b2dede5', '菜单管理', '2023-05-18 15:07:59', '798fddc17f2211eb973d6100d940b6cf', NULL, NULL);
INSERT INTO `log_info` VALUES ('6ae72056f6b3b0d280f63dc2c73025cd', '菜单管理', '2023-05-18 15:07:59', '798fddc17f2211eb973d6100d940b6cf', NULL, NULL);
INSERT INTO `log_info` VALUES ('e71161cf777d836ea7a9d0816bec5ee1', '登录日志', '2023-05-18 15:08:03', '798fddc17f2211eb973d6100d940b6cf', NULL, NULL);
INSERT INTO `log_info` VALUES ('714cbe801cb0a25d50b565ae6f546c56', '用户管理', '2023-05-18 15:08:24', '798fddc17f2211eb973d6100d940b6cf', NULL, NULL);
INSERT INTO `log_info` VALUES ('61ea642e26fc1843b407d1cbee719431', '角色管理', '2023-05-18 15:08:24', '798fddc17f2211eb973d6100d940b6cf', NULL, NULL);
INSERT INTO `log_info` VALUES ('ed3204f8a99501adb72b9d771d0175ad', '用户管理', '2023-05-18 15:08:24', '798fddc17f2211eb973d6100d940b6cf', NULL, NULL);
INSERT INTO `log_info` VALUES ('a3df2479d68d3af0e6627e9ba45513b9', '用户管理', '2023-05-18 15:09:18', '798fddc17f2211eb973d6100d940b6cf', NULL, NULL);
INSERT INTO `log_info` VALUES ('5f6c5efc63740423fa1a31b6d96136a9', '角色管理', '2023-05-18 15:09:18', '798fddc17f2211eb973d6100d940b6cf', NULL, NULL);
INSERT INTO `log_info` VALUES ('309690312ea43b053734140b3ec6711d', '用户管理', '2023-05-18 15:09:18', '798fddc17f2211eb973d6100d940b6cf', NULL, NULL);
INSERT INTO `log_info` VALUES ('893ef6c79ef306bb9bcd0a1a3b2770d8', '登录日志', '2023-05-18 15:15:45', '798fddc17f2211eb973d6100d940b6cf', NULL, NULL);
INSERT INTO `log_info` VALUES ('cb36a3e5406d795f827ca02a7a1bbea9', '登录日志', '2023-05-18 15:19:53', '798fddc17f2211eb973d6100d940b6cf', NULL, NULL);
INSERT INTO `log_info` VALUES ('a55e45a65986ae4188f4c0530967d057', '菜单管理', '2023-05-18 15:19:57', '798fddc17f2211eb973d6100d940b6cf', NULL, NULL);
INSERT INTO `log_info` VALUES ('fdb06bc3a0231ba840a85bd122a98028', '菜单管理', '2023-05-18 15:19:57', '798fddc17f2211eb973d6100d940b6cf', NULL, NULL);
INSERT INTO `log_info` VALUES ('e0e336ed0f5d7e5dd8babd4e0f2613c1', '菜单管理', '2023-05-18 16:01:08', '798fddc17f2211eb973d6100d940b6cf', NULL, NULL);
INSERT INTO `log_info` VALUES ('c2fb57dc3b4270d8fd9f31cb1f8a5125', '菜单管理', '2023-05-18 16:01:08', '798fddc17f2211eb973d6100d940b6cf', NULL, NULL);
INSERT INTO `log_info` VALUES ('3d43a0e7db612d4ef8f4b470c2542402', '菜单管理', '2023-05-18 16:01:22', '798fddc17f2211eb973d6100d940b6cf', NULL, NULL);
INSERT INTO `log_info` VALUES ('602f9d6f29cd4bc1a00d83f5b40d50d5', '菜单管理', '2023-05-18 16:01:25', '798fddc17f2211eb973d6100d940b6cf', NULL, NULL);
INSERT INTO `log_info` VALUES ('4c986ef611a13718e700c639f4bfaf70', '菜单管理', '2023-05-18 16:01:25', '798fddc17f2211eb973d6100d940b6cf', NULL, NULL);
INSERT INTO `log_info` VALUES ('d0161a8ff0fa4c63354a42f0af6b6fe1', '注销', '2023-05-18 16:57:22', '798fddc17f2211eb973d6100d940b6cf', NULL, NULL);
INSERT INTO `log_info` VALUES ('7d660be2a61a50bdf40cc383e16566ce', '登录', '2023-05-18 16:57:31', '798fddc17f2211eb973d6100d940b6cf', NULL, NULL);

-- ----------------------------
-- Table structure for order_item
-- ----------------------------
DROP TABLE IF EXISTS `order_item`;
CREATE TABLE `order_item`  (
  `order_item_id` varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `order_id` varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '订单ID',
  `product_id` varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '商品ID',
  `warehouse_id` varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '仓库ID',
  `num` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '购买数量',
  `delivery_num` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '发货数量',
  `order_item_amount` varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '细单总金额',
  `create_time` datetime NULL DEFAULT NULL,
  `create_user` varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `update_time` datetime NULL DEFAULT NULL,
  `update_user` varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`order_item_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of order_item
-- ----------------------------

-- ----------------------------
-- Table structure for product_warehouse_rel
-- ----------------------------
DROP TABLE IF EXISTS `product_warehouse_rel`;
CREATE TABLE `product_warehouse_rel`  (
  `product_warehouse_id` varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `product_id` varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '商品id',
  `warehouse_id` varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '仓库id（区分库存）',
  `stock` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '库存数',
  `status` varchar(1) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '0禁用，1启用',
  `create_time` datetime NULL DEFAULT NULL,
  `create_user` varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `update_time` datetime NULL DEFAULT NULL,
  `update_user` varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`product_warehouse_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of product_warehouse_rel
-- ----------------------------

-- ----------------------------
-- Table structure for t_email
-- ----------------------------
DROP TABLE IF EXISTS `t_email`;
CREATE TABLE `t_email`  (
  `e_id` varchar(40) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  `e_topic` varchar(100) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT '标题',
  `file_json` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '附件存放下载地址',
  `e_content` varchar(500) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '内容',
  `create_time` datetime NULL DEFAULT NULL,
  `create_user` varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `update_time` datetime NULL DEFAULT NULL,
  `update_user` varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`e_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_bin ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of t_email
-- ----------------------------
INSERT INTO `t_email` VALUES ('623d00a14d664707983874b32e1a3fa3', '1', NULL, '', NULL, NULL, NULL, NULL);

-- ----------------------------
-- Table structure for t_hongsibao
-- ----------------------------

-- ----------------------------
-- Table structure for t_menu
-- ----------------------------
DROP TABLE IF EXISTS `t_menu`;
CREATE TABLE `t_menu`  (
  `m_id` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '菜单id',
  `m_name` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '菜单功能名',
  `p_menu` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '上级功能编号',
  `is_navigation` varchar(1) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '0' COMMENT '是否用于导航（0：是 1：否）',
  `m_url` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '菜单URL',
  `m_icon` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '菜单图标',
  `m_sort` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '菜单顺序',
  `m_desc` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '菜单描述',
  `create_user` varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '创建人',
  `create_time` datetime NULL DEFAULT NULL COMMENT '创建时间',
  `update_user` varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '修改人',
  `update_time` datetime NULL DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`m_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of t_menu
-- ----------------------------
INSERT INTO `t_menu` VALUES ('0', '根节点', NULL, '0', '', '0', '1', NULL, NULL, NULL, NULL, NULL);
INSERT INTO `t_menu` VALUES ('04f5cbbec92711eba9ff144f8a625b6e', '图表管理', '0', '0', '1', '2', '33', '', '张鹏', NULL, '798fddc17f2211eb973d6100d940b6cf', '2023-05-18 14:50:33');
INSERT INTO `t_menu` VALUES ('0ea6f1cf4152ab9b2078ec6e1b969c29', '红寺堡自评等级图表', '04f5cbbec92711eba9ff144f8a625b6e', '0', '/showScoreChars.html', NULL, '1', '红寺堡评分图表', '798fddc17f2211eb973d6100d940b6cf', '2023-05-18 14:51:35', '798fddc17f2211eb973d6100d940b6cf', '2023-05-18 16:01:22');
INSERT INTO `t_menu` VALUES ('1', '基础功能', '0', '0', '', '2', '2', '1', '1', NULL, '张鹏', NULL);
INSERT INTO `t_menu` VALUES ('2ca02705bb0911eb8357144f8a625b6e', '登录日志管理', '1', '0', '/LogController/hello.html', '3', '1', '登录日志管理', '张鹏', NULL, '798fddc17f2211eb973d6100d940b6cf', '2023-05-17 14:43:42');
INSERT INTO `t_menu` VALUES ('4', '角色管理', '1', '0', '/RoleController/role_native.html', '5', '3', '', NULL, NULL, '张鹏', NULL);
INSERT INTO `t_menu` VALUES ('5', '权限管理', '0', '0', '2', '1', '3', '', NULL, NULL, '798fddc17f2211eb973d6100d940b6cf', '2023-05-17 15:56:49');
INSERT INTO `t_menu` VALUES ('6', '菜单管理', '5', '0', '/menuController/showindex.html', '4', '5', '', NULL, NULL, '张', NULL);
INSERT INTO `t_menu` VALUES ('65768529a6f411edb9ce0242ac110002', '首页', '1', '0', '/showSYpage.html', '3', '1', '', '张小白', NULL, '张小白', NULL);
INSERT INTO `t_menu` VALUES ('8c014bdff1d54e9eb3aca4844fb4f741', '功能日志管理', '1', '0', '/LogController/functionLog.html', '3', '4', '功能日志管理', '798fddc17f2211eb973d6100d940b6cf', '2023-05-17 14:44:09', NULL, NULL);
INSERT INTO `t_menu` VALUES ('9792c39aa6f411edb9ce0242ac110002', '站内信', '1', '0', '/NoticeController/showIndex.html', '3', '11', '', '张小白', NULL, '张小白', NULL);
INSERT INTO `t_menu` VALUES ('9f4e519dc92811eba9ff144f8a625b6e', '红寺堡主类图表', '04f5cbbec92711eba9ff144f8a625b6e', '0', '/showMainClassChars.html', '4', '2', '', '张鹏', NULL, '798fddc17f2211eb973d6100d940b6cf', '2023-05-18 14:51:42');
INSERT INTO `t_menu` VALUES ('cb91070fbb0a11eb8357144f8a625b6e', '用户管理', '1', '0', '/userlist.html', '6', '999', '', '张鹏', NULL, '张鹏', NULL);

-- ----------------------------
-- Table structure for t_notice
-- ----------------------------
DROP TABLE IF EXISTS `t_notice`;
CREATE TABLE `t_notice`  (
  `n_id` varchar(40) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  `send_man` varchar(40) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT '发送人id',
  `receive_man` varchar(40) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT '收件人id',
  `e_id` varchar(40) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT '信件id',
  `have_read` varchar(1) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT '是否已读（0未读，1已读）',
  `create_time` varchar(40) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  PRIMARY KEY (`n_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_bin ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of t_notice
-- ----------------------------

-- ----------------------------
-- Table structure for t_order
-- ----------------------------
DROP TABLE IF EXISTS `t_order`;
CREATE TABLE `t_order`  (
  `order_id` varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `order_num` varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '订单号',
  `order_amount` varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '订单总金额',
  `status` varchar(1) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '订单状态 0：待支付、1：待发货 2：已发货 3：已完成',
  `create_user` varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '创建人',
  `create_time` datetime NULL DEFAULT NULL COMMENT '创建时间',
  `update_user` varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '修改人',
  `update_time` datetime NULL DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`order_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_order
-- ----------------------------

-- ----------------------------
-- Table structure for t_product
-- ----------------------------
DROP TABLE IF EXISTS `t_product`;
CREATE TABLE `t_product`  (
  `product_id` varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `product_code` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '商品编码',
  `product_name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '商品名称',
  `product_money` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '商品价格（元）',
  `stock` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '库存总数',
  `speck` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '单位',
  `product_url` varchar(150) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '商品图片链接',
  `status` varchar(1) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '是否启用0禁用，1启用',
  `create_user` varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '创建人',
  `create_time` datetime NULL DEFAULT NULL COMMENT '创建时间',
  `update_user` varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '修改人',
  `update_time` datetime NULL DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`product_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_product
-- ----------------------------

-- ----------------------------
-- Table structure for t_role
-- ----------------------------
DROP TABLE IF EXISTS `t_role`;
CREATE TABLE `t_role`  (
  `r_id` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `r_name` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '角色名称',
  `r_desc` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '角色描述',
  `create_user` varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '创建人',
  `create_time` datetime NULL DEFAULT NULL COMMENT '创建时间',
  `update_user` varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '修改人',
  `update_time` datetime NULL DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`r_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of t_role
-- ----------------------------
INSERT INTO `t_role` VALUES ('62f55eb97f2211eb973d6100d940b6cf', '游客2', '1', NULL, NULL, NULL, '2023-05-18 10:58:30');
INSERT INTO `t_role` VALUES ('64720b5d7f2011eb973d6100d940b6cf', '超级管理员', '最大权限用户', NULL, NULL, NULL, '2023-05-18 10:58:33');
INSERT INTO `t_role` VALUES ('8f5efb837f2011eb973d6100d940b6cf', '游客', '无系统性菜单权限', NULL, NULL, NULL, '2023-05-18 10:58:35');
INSERT INTO `t_role` VALUES ('90861c3fc14111eba9ff144f8a625b6e', '数据管理员', '数据管理员', NULL, NULL, NULL, '2023-05-18 10:58:36');

-- ----------------------------
-- Table structure for t_sale
-- ----------------------------
DROP TABLE IF EXISTS `t_sale`;
CREATE TABLE `t_sale`  (
  `s_id` varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `jan_sale_num` varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `feb_sale_num` varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `mar_sale_num` varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `apr_sale_num` varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `may_sale_num` varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `jun_sale_num` varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `jul_sale_num` varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `aug_sale_num` varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `sep_sale_num` varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `oct_sale_num` varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `nov_sale_num` varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `dec_sale_num` varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`s_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of t_sale
-- ----------------------------
INSERT INTO `t_sale` VALUES ('1', '29803', '39803', '29873', '67905', '69823', '99803', '29803', '29803', '29803', '29803', '1', '29803');
INSERT INTO `t_sale` VALUES ('2', '32158', '39803', '29873', '67905', '69823', '99803', '29803', '29803', '29803', '29803', '1', '29803');

-- ----------------------------
-- Table structure for t_user
-- ----------------------------
DROP TABLE IF EXISTS `t_user`;
CREATE TABLE `t_user`  (
  `u_id` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `u_name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '用户名称',
  `password` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '用户密码',
  `r_id` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '角色ID',
  `sex` varchar(1) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '性别',
  `phone` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '手机号',
  `email` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '邮箱',
  `status` varchar(1) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '用户状态,0:正常 1:注销',
  `create_user` varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '创建人',
  `create_time` datetime NULL DEFAULT NULL COMMENT '创建时间',
  `update_user` varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '修改人',
  `update_time` datetime NULL DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`u_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of t_user
-- ----------------------------
INSERT INTO `t_user` VALUES ('1de072b1c35c11ebbd12c85b76b7b678', 'admin', 'lueSGJZetyySpUndWjMBEg==', '8f5efb837f2011eb973d6100d940b6cf', '1', '', '', '0', NULL, NULL, NULL, '2023-05-18 11:02:03');
INSERT INTO `t_user` VALUES ('4b6cce897f2211eb973d6100d940b6cf', '小张', 'lueSGJZetyySpUndWjMBEg==', '64720b5d7f2011eb973d6100d940b6cf', '0', '', '', '1', NULL, NULL, NULL, '2023-05-18 11:02:38');
INSERT INTO `t_user` VALUES ('798fddc17f2211eb973d6100d940b6cf', '张小白', 'lueSGJZetyySpUndWjMBEg==', '64720b5d7f2011eb973d6100d940b6cf', '1', '', '', '0', NULL, NULL, NULL, NULL);

-- ----------------------------
-- Table structure for t_user_role
-- ----------------------------
DROP TABLE IF EXISTS `t_user_role`;
CREATE TABLE `t_user_role`  (
  `rm_id` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `r_id` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `m_id` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `create_user` varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '创建人',
  `create_time` datetime NULL DEFAULT NULL COMMENT '创建时间',
  `update_user` varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '修改人',
  `update_time` datetime NULL DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`rm_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of t_user_role
-- ----------------------------
INSERT INTO `t_user_role` VALUES ('6117e865c14011eba9ff144f8a625b6e', '62f55eb97f2211eb973d6100d940b6cf', '0', NULL, NULL, NULL, NULL);
INSERT INTO `t_user_role` VALUES ('6118be77c14011eba9ff144f8a625b6e', '62f55eb97f2211eb973d6100d940b6cf', '5', NULL, NULL, NULL, NULL);
INSERT INTO `t_user_role` VALUES ('61198776c14011eba9ff144f8a625b6e', '62f55eb97f2211eb973d6100d940b6cf', '6', NULL, NULL, NULL, NULL);
INSERT INTO `t_user_role` VALUES ('611a5fc5c14011eba9ff144f8a625b6e', '62f55eb97f2211eb973d6100d940b6cf', '1', NULL, NULL, NULL, NULL);
INSERT INTO `t_user_role` VALUES ('611b9c93c14011eba9ff144f8a625b6e', '62f55eb97f2211eb973d6100d940b6cf', '2ca02705bb0911eb8357144f8a625b6e', NULL, NULL, NULL, NULL);
INSERT INTO `t_user_role` VALUES ('611c9fd3c14011eba9ff144f8a625b6e', '62f55eb97f2211eb973d6100d940b6cf', '4', NULL, NULL, NULL, NULL);
INSERT INTO `t_user_role` VALUES ('8da96f4af54a11ed9fb16c3c8c19098a', '64720b5d7f2011eb973d6100d940b6cf', '0', NULL, NULL, NULL, NULL);
INSERT INTO `t_user_role` VALUES ('8daa43ddf54a11ed9fb16c3c8c19098a', '64720b5d7f2011eb973d6100d940b6cf', '1', NULL, NULL, NULL, NULL);
INSERT INTO `t_user_role` VALUES ('8daaaed4f54a11ed9fb16c3c8c19098a', '64720b5d7f2011eb973d6100d940b6cf', '65768529a6f411edb9ce0242ac110002', NULL, NULL, NULL, NULL);
INSERT INTO `t_user_role` VALUES ('8dab3273f54a11ed9fb16c3c8c19098a', '64720b5d7f2011eb973d6100d940b6cf', '2ca02705bb0911eb8357144f8a625b6e', NULL, NULL, NULL, NULL);
INSERT INTO `t_user_role` VALUES ('8dabbbfff54a11ed9fb16c3c8c19098a', '64720b5d7f2011eb973d6100d940b6cf', '9792c39aa6f411edb9ce0242ac110002', NULL, NULL, NULL, NULL);
INSERT INTO `t_user_role` VALUES ('8dac5410f54a11ed9fb16c3c8c19098a', '64720b5d7f2011eb973d6100d940b6cf', '4', NULL, NULL, NULL, NULL);
INSERT INTO `t_user_role` VALUES ('8dacc603f54a11ed9fb16c3c8c19098a', '64720b5d7f2011eb973d6100d940b6cf', '8c014bdff1d54e9eb3aca4844fb4f741', NULL, NULL, NULL, NULL);
INSERT INTO `t_user_role` VALUES ('8dad4b55f54a11ed9fb16c3c8c19098a', '64720b5d7f2011eb973d6100d940b6cf', 'cb91070fbb0a11eb8357144f8a625b6e', NULL, NULL, NULL, NULL);
INSERT INTO `t_user_role` VALUES ('8dae0ce5f54a11ed9fb16c3c8c19098a', '64720b5d7f2011eb973d6100d940b6cf', '5', NULL, NULL, NULL, NULL);
INSERT INTO `t_user_role` VALUES ('8daedbccf54a11ed9fb16c3c8c19098a', '64720b5d7f2011eb973d6100d940b6cf', '6', NULL, NULL, NULL, NULL);
INSERT INTO `t_user_role` VALUES ('8daf6595f54a11ed9fb16c3c8c19098a', '64720b5d7f2011eb973d6100d940b6cf', '04f5cbbec92711eba9ff144f8a625b6e', NULL, NULL, NULL, NULL);
INSERT INTO `t_user_role` VALUES ('8dafbc9ef54a11ed9fb16c3c8c19098a', '64720b5d7f2011eb973d6100d940b6cf', '0ea6f1cf4152ab9b2078ec6e1b969c29', NULL, NULL, NULL, NULL);
INSERT INTO `t_user_role` VALUES ('8db00e6ef54a11ed9fb16c3c8c19098a', '64720b5d7f2011eb973d6100d940b6cf', '9f4e519dc92811eba9ff144f8a625b6e', NULL, NULL, NULL, NULL);
INSERT INTO `t_user_role` VALUES ('9f2b47f2c14111eba9ff144f8a625b6e', '90861c3fc14111eba9ff144f8a625b6e', '0', NULL, NULL, NULL, NULL);
INSERT INTO `t_user_role` VALUES ('9f2bc5e3c14111eba9ff144f8a625b6e', '90861c3fc14111eba9ff144f8a625b6e', '1', NULL, NULL, NULL, NULL);
INSERT INTO `t_user_role` VALUES ('9f2c402ec14111eba9ff144f8a625b6e', '90861c3fc14111eba9ff144f8a625b6e', '2ca02705bb0911eb8357144f8a625b6e', NULL, NULL, NULL, NULL);
INSERT INTO `t_user_role` VALUES ('effae473c35b11ebbd12c85b76b7b678', '8f5efb837f2011eb973d6100d940b6cf', '0', NULL, NULL, NULL, NULL);
INSERT INTO `t_user_role` VALUES ('f0026058c35b11ebbd12c85b76b7b678', '8f5efb837f2011eb973d6100d940b6cf', '1', NULL, NULL, NULL, NULL);
INSERT INTO `t_user_role` VALUES ('f00a2d8cc35b11ebbd12c85b76b7b678', '8f5efb837f2011eb973d6100d940b6cf', '2ca02705bb0911eb8357144f8a625b6e', NULL, NULL, NULL, NULL);

-- ----------------------------
-- Table structure for t_warehouse
-- ----------------------------
DROP TABLE IF EXISTS `t_warehouse`;
CREATE TABLE `t_warehouse`  (
  `warehouse_id` varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `warehouse_name` varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '仓库名称',
  `warehouseCode` varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '仓库号（区分库存）',
  `create_user` varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '创建人',
  `create_time` datetime NULL DEFAULT NULL COMMENT '创建时间',
  `update_user` varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '修改人',
  `update_time` datetime NULL DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`warehouse_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_warehouse
-- ----------------------------

SET FOREIGN_KEY_CHECKS = 1;
