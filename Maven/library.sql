/*
 Navicat Premium Data Transfer

 Source Server         : 120.26.46.103
 Source Server Type    : MySQL
 Source Server Version : 80024 (8.0.24)
 Source Host           : 120.26.46.103:3306
 Source Schema         : library

 Target Server Type    : MySQL
 Target Server Version : 80024 (8.0.24)
 File Encoding         : 65001

 Date: 04/06/2024 13:17:10
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for t_author
-- ----------------------------
DROP TABLE IF EXISTS `t_author`;
CREATE TABLE `t_author`  (
  `author_id` bigint NOT NULL AUTO_INCREMENT,
  `author` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  PRIMARY KEY (`author_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 28 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of t_author
-- ----------------------------
INSERT INTO `t_author` VALUES (1, '莫言');
INSERT INTO `t_author` VALUES (2, '李昊');
INSERT INTO `t_author` VALUES (3, '余华');
INSERT INTO `t_author` VALUES (4, '刘慈欣');
INSERT INTO `t_author` VALUES (5, '唐家三少');
INSERT INTO `t_author` VALUES (6, '天蚕土豆');
INSERT INTO `t_author` VALUES (7, '路遥');
INSERT INTO `t_author` VALUES (8, '霍达');
INSERT INTO `t_author` VALUES (9, '村上春树');
INSERT INTO `t_author` VALUES (10, '马里奥-普佐');
INSERT INTO `t_author` VALUES (11, '乔斯坦-贾德');
INSERT INTO `t_author` VALUES (12, '塞林格');
INSERT INTO `t_author` VALUES (13, '陈忠实');
INSERT INTO `t_author` VALUES (14, '卡达莱');
INSERT INTO `t_author` VALUES (15, '黄仁宇');
INSERT INTO `t_author` VALUES (16, '李泽厚');
INSERT INTO `t_author` VALUES (17, '钱钟书');
INSERT INTO `t_author` VALUES (18, '斯托夫人');
INSERT INTO `t_author` VALUES (19, '阿来');
INSERT INTO `t_author` VALUES (20, '亚力克-黑尔');
INSERT INTO `t_author` VALUES (21, '春曼');
INSERT INTO `t_author` VALUES (22, '伏尼契');
INSERT INTO `t_author` VALUES (23, '艾米丽-勃朗特');
INSERT INTO `t_author` VALUES (24, '刘乐土');
INSERT INTO `t_author` VALUES (25, '曹禺');
INSERT INTO `t_author` VALUES (26, 'author');
INSERT INTO `t_author` VALUES (27, '同济大学');

-- ----------------------------
-- Table structure for t_book
-- ----------------------------
DROP TABLE IF EXISTS `t_book`;
CREATE TABLE `t_book`  (
  `book_id` bigint NOT NULL AUTO_INCREMENT,
  `author_id` bigint NULL DEFAULT NULL,
  `category_id` bigint NULL DEFAULT NULL,
  `press_id` bigint NULL DEFAULT NULL,
  `book` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `book_photo` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `books` bigint NOT NULL,
  `book_user_num` bigint NOT NULL,
  `book_money` decimal(10, 2) NOT NULL,
  `bookshelf` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `is_delete` tinyint(1) NOT NULL DEFAULT 0,
  PRIMARY KEY (`book_id`) USING BTREE,
  INDEX `FK_Reference_4`(`author_id` ASC) USING BTREE,
  INDEX `FK_Reference_5`(`category_id` ASC) USING BTREE,
  INDEX `FK_Reference_6`(`press_id` ASC) USING BTREE,
  CONSTRAINT `FK_Reference_4` FOREIGN KEY (`author_id`) REFERENCES `t_author` (`author_id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `FK_Reference_5` FOREIGN KEY (`category_id`) REFERENCES `t_category` (`category_id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `FK_Reference_6` FOREIGN KEY (`press_id`) REFERENCES `t_press` (`press_id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 38 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of t_book
-- ----------------------------
INSERT INTO `t_book` VALUES (1, 7, 1, 1, '平凡的世界', 'http://120.26.46.103:8080/library/static/bookImage/1.jpg', 55, 46, 1.00, '2#1', 0);
INSERT INTO `t_book` VALUES (2, 8, 2, 2, '穆斯林的葬礼', 'http://120.26.46.103:8080/library/static/bookImage/2.jpg', 84, 18, 2.00, '1#2', 0);
INSERT INTO `t_book` VALUES (3, 3, 3, 3, '活着', 'http://120.26.46.103:8080/library/static/bookImage/3.jpg', 89, 14, 3.00, '1#1', 0);
INSERT INTO `t_book` VALUES (4, 9, 4, 1, '挪威的森林', 'http://120.26.46.103:8080/library/static/bookImage/4.jpg', 97, 3, 4.00, '1#1', 0);
INSERT INTO `t_book` VALUES (5, 10, 5, 2, '教父', 'http://120.26.46.103:8080/library/static/bookImage/5.jpg', 96, 4, 5.00, '1#1', 0);
INSERT INTO `t_book` VALUES (6, 11, 6, 3, '苏菲的世界', 'http://120.26.46.103:8080/library/static/bookImage/6.jpg', 97, 3, 6.00, '1#1', 0);
INSERT INTO `t_book` VALUES (7, 12, 1, 1, '麦田里的守望者', 'http://120.26.46.103:8080/library/static/bookImage/7.jpg', 95, 5, 7.00, '1#1', 1);
INSERT INTO `t_book` VALUES (8, 13, 2, 2, '白鹿原', 'http://120.26.46.103:8080/library/static/bookImage/8.jpg', 350, 0, 8.00, '1#1', 1);
INSERT INTO `t_book` VALUES (9, 14, 3, 3, '破碎的四月', 'http://120.26.46.103:8080/library/static/bookImage/9.jpg', 99, 1, 9.00, '1#1', 1);
INSERT INTO `t_book` VALUES (10, 15, 4, 1, '万历十五年', 'http://120.26.46.103:8080/library/static/bookImage/10.jpg', 100, 0, 10.00, '1#1', 1);
INSERT INTO `t_book` VALUES (11, 16, 5, 2, '美的历程', 'http://120.26.46.103:8080/library/static/bookImage/11.jpg', 96, 4, 11.00, '1#1', 0);
INSERT INTO `t_book` VALUES (12, 17, 1, 3, '围城', 'http://120.26.46.103:8080/library/static/bookImage/12.jpg', 98, 1, 12.00, '1#1', 0);
INSERT INTO `t_book` VALUES (13, 18, 1, 1, '汤姆叔叔的小屋', 'http://120.26.46.103:8080/library/static/bookImage/13.jpg', 97, 3, 13.00, '1#1', 0);
INSERT INTO `t_book` VALUES (14, 19, 2, 2, '尘埃落定', 'http://120.26.46.103:8080/library/static/bookImage/14.jpg', 99, 1, 14.00, '1#1', 0);
INSERT INTO `t_book` VALUES (15, 7, 3, 3, '人生', 'http://120.26.46.103:8080/library/static/bookImage/15.jpg', 97, 3, 15.00, '1#1', 0);
INSERT INTO `t_book` VALUES (16, 4, 6, 11, '三体《第一部》', 'http://120.26.46.103:8080/library/static/bookImage/16.jpg', 92, 8, 30.00, '3#3', 0);
INSERT INTO `t_book` VALUES (17, 4, 6, 11, '三体《第二部》', 'http://120.26.46.103:8080/library/static/bookImage/17.jpg', 100, 0, 30.00, '3#3', 0);
INSERT INTO `t_book` VALUES (18, 4, 6, 11, '三体《第三部》', 'http://120.26.46.103:8080/library/static/bookImage/18.jpg', 100, 0, 30.00, '3#3', 0);
INSERT INTO `t_book` VALUES (19, 21, 4, 12, '生命从明天开始', 'http://120.26.46.103:8080/library/static/bookImage/19.jpg', 100, 0, 30.00, '3#3', 0);
INSERT INTO `t_book` VALUES (20, 3, 4, 12, '许三观卖血记', 'http://120.26.46.103:8080/library/static/bookImage/20.jpg', 100, 0, 30.00, '3#3', 0);
INSERT INTO `t_book` VALUES (21, 5, 4, 12, '斗罗大陆3龙王传说', 'http://120.26.46.103:8080/library/static/bookImage/21.jpg', 50, 0, 30.00, '3#3', 0);
INSERT INTO `t_book` VALUES (22, 2, 1, 12, '测试01', 'http://120.26.46.103:8080/library/static/bookImage/ee2620d8-9486-414e-a7a4-9fb9bac38015.jpg', 49, 1, 30.00, '3#3', 1);
INSERT INTO `t_book` VALUES (23, 22, 1, 12, '牛虻', 'http://120.26.46.103:8080/library/static/bookImage/23.jpg', 50, 0, 30.00, '3#3', 0);
INSERT INTO `t_book` VALUES (24, 23, 4, 12, '呼啸山庄', 'http://120.26.46.103:8080/library/static/bookImage/24.jpg', 50, 0, 30.00, '3#3', 0);
INSERT INTO `t_book` VALUES (25, 24, 4, 12, '拿破仑全传', 'http://120.26.46.103:8080/library/static/bookImage/25.jpg', 50, 0, 30.00, '3#3', 0);
INSERT INTO `t_book` VALUES (26, 25, 2, 2, '曹禺剧本选', 'http://120.26.46.103:8080/library/static/bookImage/26.jpg', 150, 0, 40.00, '3#3', 0);
INSERT INTO `t_book` VALUES (27, 26, 1, 13, 'book', 'http://120.26.46.103:8080/library/static/bookImage/1c273031-9b85-4f8d-bc82-90a72b40a68d.png', 110, 0, 44.00, 'bookshelf', 1);
INSERT INTO `t_book` VALUES (28, 27, 1, 14, '高等数学', 'http://120.26.46.103:8080/library/static/bookImage/169ba5fb-c97c-4993-8b4f-a4f575c540c4.png', 22, 0, 100.00, '1#1', 1);
INSERT INTO `t_book` VALUES (29, 27, 6, 14, '高等数学2', 'http://120.26.46.103:8080/library/static/bookImage/ca92bc4f-e1d1-41d0-b732-316272ea8206.png', 22, 0, 44.00, '2#4', 1);
INSERT INTO `t_book` VALUES (30, 27, 1, 14, '高等数学3', 'http://120.26.46.103:8080/library/static/bookImage/4d6ef75e-8cec-406c-b014-c75a234b0a4a.png', 22, 0, 44.00, '2#4', 1);
INSERT INTO `t_book` VALUES (31, 27, 1, 14, '高等数学4', 'http://120.26.46.103:8080/library/static/bookImage/5948fbe4-ecd8-4637-9ea5-0035e375e54d.png', 22, 0, 44.00, '2#4', 1);
INSERT INTO `t_book` VALUES (32, 27, 1, 14, '高等数学5', 'http://120.26.46.103:8080/library/static/bookImage/130b5364-5283-449b-b815-989e0415b589.png', 44, 0, 44.00, '2#4', 1);
INSERT INTO `t_book` VALUES (33, 27, 1, 14, '高等数学7', 'http://120.26.46.103:8080/library/static/bookImage/14fb0994-6dad-4767-851b-d0dc460c5adc.png', 22, 0, 44.00, '2#4', 1);
INSERT INTO `t_book` VALUES (34, 27, 1, 14, '高等数学7', 'http://120.26.46.103:8080/library/static/bookImage/6c796c7c-d19b-41b1-aa7b-78eb911602d9.png', 22, 0, 44.00, '2#4', 1);
INSERT INTO `t_book` VALUES (35, 27, 1, 14, '高等数学8', 'http://120.26.46.103:8080/library/static/bookImage/a7afd37c-b460-45db-84c8-8ccb84283bd0.png', 22, 0, 44.00, '2#4', 1);
INSERT INTO `t_book` VALUES (36, 27, 1, 14, '高等数学', 'http://120.26.46.103:8080/library/static/bookImage/0d0d8071-87ed-4211-ad82-7349a88294d3.png', 20, 0, 35.00, '2#4', 0);
INSERT INTO `t_book` VALUES (37, 27, 6, 14, '高等数学2', 'http://120.26.46.103:8080/library/static/bookImage/d46d8744-81cd-409a-9dc6-6a5ba99a7867.png', 11, 0, 30.00, '2#4', 1);

-- ----------------------------
-- Table structure for t_book_state
-- ----------------------------
DROP TABLE IF EXISTS `t_book_state`;
CREATE TABLE `t_book_state`  (
  `book_state_id` bigint NOT NULL,
  `book_state` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  PRIMARY KEY (`book_state_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of t_book_state
-- ----------------------------
INSERT INTO `t_book_state` VALUES (1, '无');
INSERT INTO `t_book_state` VALUES (2, '借阅中');
INSERT INTO `t_book_state` VALUES (3, '超时');
INSERT INTO `t_book_state` VALUES (4, '丢失');
INSERT INTO `t_book_state` VALUES (5, '还书中');

-- ----------------------------
-- Table structure for t_borrow
-- ----------------------------
DROP TABLE IF EXISTS `t_borrow`;
CREATE TABLE `t_borrow`  (
  `borrow_id` bigint NOT NULL AUTO_INCREMENT,
  `borrow_date` datetime NOT NULL,
  `borrow_final_date` datetime NOT NULL,
  `book_id` bigint NULL DEFAULT NULL,
  `user_category_id` bigint NULL DEFAULT NULL,
  `user_id` bigint NULL DEFAULT NULL,
  `book_state_id` bigint NULL DEFAULT NULL,
  `book_return_date` datetime NULL DEFAULT NULL,
  `book_return_photo` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `return_state_id` bigint NULL DEFAULT NULL,
  PRIMARY KEY (`borrow_id`) USING BTREE,
  INDEX `FK_Reference_12`(`user_category_id` ASC) USING BTREE,
  INDEX `FK_Reference_13`(`return_state_id` ASC) USING BTREE,
  INDEX `FK_Reference_8`(`book_state_id` ASC) USING BTREE,
  INDEX `FK_Reference_9`(`book_id` ASC) USING BTREE,
  INDEX `user_id`(`user_id` ASC) USING BTREE,
  CONSTRAINT `FK_Reference_10` FOREIGN KEY (`user_id`) REFERENCES `t_user` (`user_id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `FK_Reference_12` FOREIGN KEY (`user_category_id`) REFERENCES `t_user_category` (`user_category_id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `FK_Reference_13` FOREIGN KEY (`return_state_id`) REFERENCES `t_return_state` (`return_state_id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `FK_Reference_8` FOREIGN KEY (`book_state_id`) REFERENCES `t_book_state` (`book_state_id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `FK_Reference_9` FOREIGN KEY (`book_id`) REFERENCES `t_book` (`book_id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `t_borrow_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `t_user` (`user_id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 138 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of t_borrow
-- ----------------------------
INSERT INTO `t_borrow` VALUES (100, '2024-05-18 16:04:43', '2024-06-17 16:04:43', 16, 1, 1, 1, NULL, NULL, NULL);
INSERT INTO `t_borrow` VALUES (101, '2024-05-19 18:41:04', '2024-07-16 18:41:04', 16, 1, 1, 1, NULL, NULL, NULL);
INSERT INTO `t_borrow` VALUES (102, '2024-05-23 19:53:01', '2024-07-06 19:53:01', 16, 1, 1, 1, NULL, NULL, NULL);
INSERT INTO `t_borrow` VALUES (103, '2024-05-23 19:53:08', '2024-06-22 19:53:08', 16, 1, 1, 1, NULL, NULL, NULL);
INSERT INTO `t_borrow` VALUES (104, '2024-05-23 19:57:17', '2024-06-22 19:57:17', 22, 1, 1, 1, NULL, NULL, NULL);
INSERT INTO `t_borrow` VALUES (105, '2024-05-24 16:40:04', '2024-06-30 16:40:04', 1, 1, 1, 1, NULL, NULL, NULL);
INSERT INTO `t_borrow` VALUES (106, '2024-05-24 16:45:59', '2024-07-21 16:45:59', 5, 1, 1, 1, NULL, NULL, NULL);
INSERT INTO `t_borrow` VALUES (107, '2024-05-24 17:08:39', '2024-07-14 17:08:39', 1, 1, 1, 1, NULL, NULL, NULL);
INSERT INTO `t_borrow` VALUES (108, '2024-05-27 17:09:23', '2024-06-26 17:09:23', 1, 1, 1, 1, NULL, NULL, 2);
INSERT INTO `t_borrow` VALUES (109, '2024-05-27 17:09:26', '2024-06-26 17:09:26', 2, 1, 1, 1, NULL, NULL, 2);
INSERT INTO `t_borrow` VALUES (110, '2024-05-27 17:09:29', '2024-06-26 17:09:29', 3, 1, 1, 1, NULL, NULL, 2);
INSERT INTO `t_borrow` VALUES (111, '2024-05-27 17:09:30', '2024-06-26 17:09:30', 4, 1, 1, 1, NULL, NULL, 2);
INSERT INTO `t_borrow` VALUES (112, '2024-05-27 17:09:41', '2024-06-26 17:09:41', 5, 1, 1, 1, NULL, NULL, 2);
INSERT INTO `t_borrow` VALUES (113, '2024-05-27 17:21:54', '2024-06-26 17:21:54', 1, 1, 1, 1, NULL, NULL, NULL);
INSERT INTO `t_borrow` VALUES (114, '2024-05-27 17:21:57', '2024-07-03 17:21:57', 4, 1, 1, 1, NULL, NULL, NULL);
INSERT INTO `t_borrow` VALUES (115, '2024-05-27 17:21:59', '2024-06-26 17:21:59', 11, 1, 1, 1, NULL, NULL, NULL);
INSERT INTO `t_borrow` VALUES (116, '2024-05-27 17:22:01', '2024-06-26 17:22:01', 2, 1, 1, 1, NULL, NULL, 2);
INSERT INTO `t_borrow` VALUES (117, '2024-05-27 17:25:54', '2024-07-03 17:25:54', 1, 1, 1, 1, NULL, NULL, 2);
INSERT INTO `t_borrow` VALUES (118, '2024-05-27 17:27:13', '2024-06-26 17:27:13', 1, 1, 1, 1, NULL, NULL, 2);
INSERT INTO `t_borrow` VALUES (119, '2024-05-27 17:28:53', '2024-07-10 17:28:53', 1, 1, 1, 1, NULL, NULL, NULL);
INSERT INTO `t_borrow` VALUES (120, '2024-05-27 17:40:25', '2024-06-26 17:40:25', 1, 1, 1, 1, NULL, NULL, 2);
INSERT INTO `t_borrow` VALUES (121, '2024-05-27 17:40:33', '2024-06-26 17:40:33', 16, 1, 1, 1, NULL, NULL, 2);
INSERT INTO `t_borrow` VALUES (122, '2024-05-27 17:40:34', '2024-06-26 17:40:34', 16, 1, 1, 1, '2024-05-28 17:50:46', NULL, 4);
INSERT INTO `t_borrow` VALUES (123, '2024-05-27 18:11:41', '2024-06-26 18:11:41', 16, 1, 1, 1, '2024-05-28 17:50:49', NULL, 3);
INSERT INTO `t_borrow` VALUES (124, '2024-05-27 18:40:06', '2024-06-26 18:40:06', 1, 1, 1, 1, NULL, NULL, NULL);
INSERT INTO `t_borrow` VALUES (125, '2024-05-27 18:40:44', '2024-06-26 18:40:44', 11, 1, 1, 1, '2024-05-29 15:06:18', NULL, 4);
INSERT INTO `t_borrow` VALUES (126, '2024-05-27 18:41:18', '2024-06-26 18:41:18', 2, 1, 1, 1, '2024-05-28 19:24:43', NULL, 3);
INSERT INTO `t_borrow` VALUES (127, '2024-05-27 18:44:03', '2024-06-26 18:44:03', 16, 1, 1, 1, NULL, NULL, 2);
INSERT INTO `t_borrow` VALUES (128, '2024-05-27 18:44:15', '2024-06-26 18:44:15', 11, 1, 1, 1, NULL, NULL, NULL);
INSERT INTO `t_borrow` VALUES (129, '2024-05-27 18:44:17', '2024-07-10 18:44:17', 12, 1, 1, 5, NULL, NULL, 2);
INSERT INTO `t_borrow` VALUES (130, '2024-05-27 18:44:20', '2024-06-26 18:44:20', 13, 1, 1, 5, NULL, NULL, 2);
INSERT INTO `t_borrow` VALUES (131, '2024-05-27 18:46:34', '2024-06-26 18:46:34', 1, 1, 1, 1, NULL, NULL, NULL);
INSERT INTO `t_borrow` VALUES (132, '2024-05-27 18:46:37', '2024-07-10 18:46:37', 2, 1, 1, 2, NULL, NULL, NULL);
INSERT INTO `t_borrow` VALUES (133, '2024-05-27 18:46:39', '2024-06-26 18:46:39', 3, 1, 1, 1, '2024-05-28 19:25:26', NULL, 3);
INSERT INTO `t_borrow` VALUES (134, '2024-05-27 18:49:01', '2024-06-26 18:49:01', 5, 1, 1, 2, NULL, NULL, NULL);
INSERT INTO `t_borrow` VALUES (135, '2024-05-28 19:21:36', '2024-06-27 19:21:36', 3, 1, 1, 2, NULL, NULL, NULL);
INSERT INTO `t_borrow` VALUES (136, '2024-05-29 16:26:30', '2024-06-28 16:26:30', 13, 1, 1, 2, NULL, NULL, NULL);
INSERT INTO `t_borrow` VALUES (137, '2024-06-04 12:54:54', '2024-07-04 12:54:54', 1, 1, 1, 2, NULL, NULL, NULL);

-- ----------------------------
-- Table structure for t_category
-- ----------------------------
DROP TABLE IF EXISTS `t_category`;
CREATE TABLE `t_category`  (
  `category_id` bigint NOT NULL,
  `category` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  PRIMARY KEY (`category_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of t_category
-- ----------------------------
INSERT INTO `t_category` VALUES (1, '政治');
INSERT INTO `t_category` VALUES (2, '历史');
INSERT INTO `t_category` VALUES (3, '哲学');
INSERT INTO `t_category` VALUES (4, '小说');
INSERT INTO `t_category` VALUES (5, '艺术');
INSERT INTO `t_category` VALUES (6, '科学');

-- ----------------------------
-- Table structure for t_content
-- ----------------------------
DROP TABLE IF EXISTS `t_content`;
CREATE TABLE `t_content`  (
  `content_id` bigint NOT NULL AUTO_INCREMENT,
  `content` text CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `publish_date` datetime NOT NULL,
  `like_num` bigint NOT NULL,
  `user_category_id` bigint NOT NULL,
  `user_id` bigint NULL DEFAULT NULL,
  PRIMARY KEY (`content_id`) USING BTREE,
  INDEX `FK_Reference_15`(`user_category_id` ASC) USING BTREE,
  INDEX `FK_Reference_16`(`user_id` ASC) USING BTREE,
  CONSTRAINT `FK_Reference_15` FOREIGN KEY (`user_category_id`) REFERENCES `t_user_category` (`user_category_id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `FK_Reference_16` FOREIGN KEY (`user_id`) REFERENCES `t_user` (`user_id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 60 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of t_content
-- ----------------------------
INSERT INTO `t_content` VALUES (33, '123', '2024-05-21 18:52:37', 78, 1, 1);
INSERT INTO `t_content` VALUES (34, '123', '2024-05-21 18:55:30', 6, 1, 1);
INSERT INTO `t_content` VALUES (35, '123', '2024-05-21 18:55:46', 1, 1, 1);
INSERT INTO `t_content` VALUES (36, '123', '2024-05-21 18:55:47', 1, 1, 1);
INSERT INTO `t_content` VALUES (37, '12', '2024-05-21 18:56:32', 1, 1, 1);
INSERT INTO `t_content` VALUES (38, '123', '2024-05-21 18:56:38', 1, 1, 1);
INSERT INTO `t_content` VALUES (39, '123', '2024-05-21 18:56:40', 0, 1, 1);
INSERT INTO `t_content` VALUES (40, '123', '2024-05-21 18:57:38', 0, 1, 1);
INSERT INTO `t_content` VALUES (41, '123', '2024-05-21 18:59:48', 0, 1, 1);
INSERT INTO `t_content` VALUES (42, '测试', '2024-05-21 19:01:24', 0, 1, 1);
INSERT INTO `t_content` VALUES (43, '测试', '2024-05-21 19:01:37', 0, 1, 1);
INSERT INTO `t_content` VALUES (44, '123', '2024-05-21 19:01:41', 0, 1, 1);
INSERT INTO `t_content` VALUES (45, '测试', '2024-05-21 19:02:06', 0, 1, 1);
INSERT INTO `t_content` VALUES (46, '再次测试', '2024-05-21 19:03:00', 0, 1, 1);
INSERT INTO `t_content` VALUES (47, '0001', '2024-05-21 19:03:26', 0, 1, 1);
INSERT INTO `t_content` VALUES (48, '0002', '2024-05-21 19:03:31', 0, 1, 1);
INSERT INTO `t_content` VALUES (49, '0003', '2024-05-21 19:03:36', 0, 1, 1);
INSERT INTO `t_content` VALUES (50, '0004', '2024-05-21 19:03:40', 0, 1, 1);
INSERT INTO `t_content` VALUES (51, '0005', '2024-05-21 19:03:46', 1, 1, 1);
INSERT INTO `t_content` VALUES (52, '123', '2024-05-21 19:07:52', 0, 1, 1);
INSERT INTO `t_content` VALUES (53, '333', '2024-05-21 19:08:29', 0, 1, 1);
INSERT INTO `t_content` VALUES (54, '111111', '2024-05-21 20:14:29', 0, 1, 1);
INSERT INTO `t_content` VALUES (55, 'erttttt', '2024-05-21 23:12:59', 0, 1, 1);
INSERT INTO `t_content` VALUES (56, '11111', '2024-05-22 00:43:36', 0, 1, 1);
INSERT INTO `t_content` VALUES (57, '123', '2024-05-25 14:38:52', 0, 1, 1);
INSERT INTO `t_content` VALUES (58, '0525测试', '2024-05-25 14:55:00', 0, 1, 1);
INSERT INTO `t_content` VALUES (59, '123', '2024-06-04 12:53:25', 0, 1, 1);

-- ----------------------------
-- Table structure for t_fee
-- ----------------------------
DROP TABLE IF EXISTS `t_fee`;
CREATE TABLE `t_fee`  (
  `fee_id` bigint NOT NULL AUTO_INCREMENT,
  `fee_category_id` bigint NOT NULL,
  `fee_state_id` bigint NOT NULL,
  `user_id` bigint NOT NULL,
  `fee_num` decimal(10, 2) NULL DEFAULT NULL,
  `book` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '书籍名称',
  PRIMARY KEY (`fee_id`) USING BTREE,
  INDEX `FK_Reference_17`(`fee_state_id` ASC) USING BTREE,
  INDEX `FK_Reference_18`(`user_id` ASC) USING BTREE,
  INDEX `FK_Reference_19`(`fee_category_id` ASC) USING BTREE,
  CONSTRAINT `FK_Reference_17` FOREIGN KEY (`fee_state_id`) REFERENCES `t_fee_state` (`fee_state_id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `FK_Reference_18` FOREIGN KEY (`user_id`) REFERENCES `t_user` (`user_id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `FK_Reference_19` FOREIGN KEY (`fee_category_id`) REFERENCES `t_fee_category` (`fee_category_id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 46 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of t_fee
-- ----------------------------
INSERT INTO `t_fee` VALUES (1, 1, 2, 1, 47.00, '测试01');
INSERT INTO `t_fee` VALUES (2, 1, 2, 1, 47.00, '测试02');
INSERT INTO `t_fee` VALUES (3, 1, 2, 1, 47.00, '测试03');
INSERT INTO `t_fee` VALUES (4, 1, 2, 1, 47.00, '测试04');
INSERT INTO `t_fee` VALUES (5, 1, 2, 1, 48.00, '测试05');
INSERT INTO `t_fee` VALUES (6, 1, 2, 1, 48.00, '测试06');
INSERT INTO `t_fee` VALUES (8, 1, 2, 1, 24.00, '测试07');
INSERT INTO `t_fee` VALUES (9, 1, 2, 1, 24.00, '测试08');
INSERT INTO `t_fee` VALUES (10, 1, 2, 1, 24.00, '测试09');
INSERT INTO `t_fee` VALUES (11, 1, 2, 1, 24.00, '测试10');
INSERT INTO `t_fee` VALUES (12, 2, 2, 1, 2.00, '测试11');
INSERT INTO `t_fee` VALUES (13, 2, 2, 1, 1.00, '测试12');
INSERT INTO `t_fee` VALUES (14, 2, 2, 1, 2.00, '测试13');
INSERT INTO `t_fee` VALUES (15, 2, 2, 1, 1.00, '测试14');
INSERT INTO `t_fee` VALUES (16, 2, 2, 1, 2.00, '测试15');
INSERT INTO `t_fee` VALUES (17, 2, 2, 1, 1.00, '测试16');
INSERT INTO `t_fee` VALUES (18, 2, 2, 1, 1.00, '测试17');
INSERT INTO `t_fee` VALUES (19, 3, 2, 1, 1.00, '测试18');
INSERT INTO `t_fee` VALUES (20, 2, 2, 1, 30.00, '测试01');
INSERT INTO `t_fee` VALUES (21, 2, 2, 1, 30.00, '测试01');
INSERT INTO `t_fee` VALUES (22, 2, 2, 1, 30.00, '测试01');
INSERT INTO `t_fee` VALUES (23, 2, 2, 1, 30.00, '测试01');
INSERT INTO `t_fee` VALUES (24, 2, 2, 1, 30.00, '测试01');
INSERT INTO `t_fee` VALUES (25, 2, 1, 1, 30.00, '测试01');
INSERT INTO `t_fee` VALUES (26, 2, 1, 1, 30.00, '测试01');
INSERT INTO `t_fee` VALUES (27, 2, 1, 1, 1.00, '测试01');
INSERT INTO `t_fee` VALUES (28, 2, 1, 1, 5.00, '测试01');
INSERT INTO `t_fee` VALUES (29, 2, 1, 1, 5.00, '测试01');
INSERT INTO `t_fee` VALUES (30, 2, 2, 1, 5.00, '测试01');
INSERT INTO `t_fee` VALUES (31, 2, 3, 1, 1.00, '测试01');
INSERT INTO `t_fee` VALUES (32, 2, 3, 1, 1.00, '测试01');
INSERT INTO `t_fee` VALUES (33, 2, 3, 1, 1.00, '测试01');
INSERT INTO `t_fee` VALUES (34, 2, 3, 1, 11.00, '测试01');
INSERT INTO `t_fee` VALUES (35, 2, 3, 1, 4.00, '测试01');
INSERT INTO `t_fee` VALUES (36, 2, 3, 1, 2.00, '测试01');
INSERT INTO `t_fee` VALUES (37, 2, 3, 1, 1.00, '测试01');
INSERT INTO `t_fee` VALUES (38, 2, 1, 1, 1.00, '测试01');
INSERT INTO `t_fee` VALUES (39, 2, 3, 1, 1.00, '测试01');
INSERT INTO `t_fee` VALUES (40, 2, 3, 1, 30.00, '测试01');
INSERT INTO `t_fee` VALUES (41, 2, 3, 1, 11.00, '测试01');
INSERT INTO `t_fee` VALUES (42, 2, 3, 1, 1.00, '测试01');
INSERT INTO `t_fee` VALUES (43, 3, 3, 1, 30.00, '测试01');
INSERT INTO `t_fee` VALUES (44, 3, 3, 1, 2.00, '测试01');
INSERT INTO `t_fee` VALUES (45, 3, 3, 1, 3.00, '测试01');

-- ----------------------------
-- Table structure for t_fee_category
-- ----------------------------
DROP TABLE IF EXISTS `t_fee_category`;
CREATE TABLE `t_fee_category`  (
  `fee_category_id` bigint NOT NULL,
  `fee_category` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  PRIMARY KEY (`fee_category_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of t_fee_category
-- ----------------------------
INSERT INTO `t_fee_category` VALUES (1, '超时费');
INSERT INTO `t_fee_category` VALUES (2, '丢失费');
INSERT INTO `t_fee_category` VALUES (3, '定损费');

-- ----------------------------
-- Table structure for t_fee_state
-- ----------------------------
DROP TABLE IF EXISTS `t_fee_state`;
CREATE TABLE `t_fee_state`  (
  `fee_state_id` bigint NOT NULL,
  `fee_state` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  PRIMARY KEY (`fee_state_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of t_fee_state
-- ----------------------------
INSERT INTO `t_fee_state` VALUES (1, '无');
INSERT INTO `t_fee_state` VALUES (2, '已支付');
INSERT INTO `t_fee_state` VALUES (3, '未支付');

-- ----------------------------
-- Table structure for t_manager
-- ----------------------------
DROP TABLE IF EXISTS `t_manager`;
CREATE TABLE `t_manager`  (
  `manager_id` bigint NOT NULL AUTO_INCREMENT,
  `gender` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `telephone_num` bigint NOT NULL,
  `email` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `photo` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `account_num` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `password` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `permissions` tinyint(1) NOT NULL DEFAULT 1,
  `isdelete` tinyint(1) NOT NULL DEFAULT 0,
  PRIMARY KEY (`manager_id`) USING BTREE,
  INDEX `FK_Reference_3`(`gender` ASC) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 9 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of t_manager
-- ----------------------------
INSERT INTO `t_manager` VALUES (1, '男', '李昊', 19817115293, '805459342@qq.com', 'http://120.26.46.103:8080/library/static/bookImage/ee2620d8-9486-414e-a7a4-9fb9bac38015.jpg', 'admin', '123456', 1, 0);
INSERT INTO `t_manager` VALUES (2, '男', '张三', 123456, '1679642126@qq.com', 'http://120.26.46.103:8080/library/static/bookImage/ee2620d8-9486-414e-a7a4-9fb9bac38015.jpg', 'aaaaaa', '123456', 1, 0);
INSERT INTO `t_manager` VALUES (3, '男', '测试账号01', 123456, 'test01@qq.com', 'http://120.26.46.103:8080/library/static/bookImage/ee2620d8-9486-414e-a7a4-9fb9bac38015.jpg', 'test01', '123456', 1, 0);
INSERT INTO `t_manager` VALUES (4, '男', '李天行', 13888888889, 's805459342', 'http://120.26.46.103:8080/library/static/managerImage/d8a71930-b507-47a9-b438-e82cd78d1b9f.png', 'lth', '123456', 1, 0);
INSERT INTO `t_manager` VALUES (5, '男', '李天行', 13888888889, 's805459342', 'http://120.26.46.103:8080/library/static/managerImage/10b150e9-f890-4988-96a6-4b7e556a9f21.png', 'lth', '123456', 1, 0);
INSERT INTO `t_manager` VALUES (6, '男', '李天行', 13888888889, 's805459342', 'http://120.26.46.103:8080/library/static/managerImage/179f7f88-77dd-476b-b036-bddd7859c974.png', 'lth', '123456', 1, 0);
INSERT INTO `t_manager` VALUES (7, '男', '李天行', 13888888889, 's805459342', 'http://120.26.46.103:8080/library/static/managerImage/c7b909a1-3b4f-4cbc-be8b-7710307f2831.png', 'lth', '123456', 1, 0);
INSERT INTO `t_manager` VALUES (8, '男', '李天行', 13888888889, 's805459342', 'http://120.26.46.103:8080/library/static/managerImage/791feada-fb65-478d-b0fb-b87af95c7393.png', 'lth', '123456', 1, 0);

-- ----------------------------
-- Table structure for t_notice
-- ----------------------------
DROP TABLE IF EXISTS `t_notice`;
CREATE TABLE `t_notice`  (
  `notice_id` bigint NOT NULL AUTO_INCREMENT,
  `notice_content` text CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL,
  `notice_date` datetime NOT NULL,
  `manager_id` bigint NOT NULL,
  `effective` tinyint(1) NOT NULL,
  PRIMARY KEY (`notice_id`) USING BTREE,
  INDEX `FK_Reference_14`(`manager_id` ASC) USING BTREE,
  CONSTRAINT `FK_Reference_14` FOREIGN KEY (`manager_id`) REFERENCES `t_manager` (`manager_id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of t_notice
-- ----------------------------
INSERT INTO `t_notice` VALUES (1, '请注意，4月1日当天借书可获得10万元奖励奖！只有这一天！希望大家能积极参与！培养良好的阅读氛围！', '2024-04-02 16:14:52', 1, 1);

-- ----------------------------
-- Table structure for t_press
-- ----------------------------
DROP TABLE IF EXISTS `t_press`;
CREATE TABLE `t_press`  (
  `press_id` bigint NOT NULL AUTO_INCREMENT,
  `press` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  PRIMARY KEY (`press_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 15 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of t_press
-- ----------------------------
INSERT INTO `t_press` VALUES (1, '人民出版社');
INSERT INTO `t_press` VALUES (2, '人民文学出版社');
INSERT INTO `t_press` VALUES (3, '商务印书馆');
INSERT INTO `t_press` VALUES (4, '中华书局');
INSERT INTO `t_press` VALUES (5, '上海译文出版社');
INSERT INTO `t_press` VALUES (11, '重庆出版社');
INSERT INTO `t_press` VALUES (12, '起点出版社');
INSERT INTO `t_press` VALUES (13, 'press');
INSERT INTO `t_press` VALUES (14, '高等教育出版社');

-- ----------------------------
-- Table structure for t_return_state
-- ----------------------------
DROP TABLE IF EXISTS `t_return_state`;
CREATE TABLE `t_return_state`  (
  `return_state_id` bigint NOT NULL,
  `return_state` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  PRIMARY KEY (`return_state_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of t_return_state
-- ----------------------------
INSERT INTO `t_return_state` VALUES (1, '无');
INSERT INTO `t_return_state` VALUES (2, '处理中');
INSERT INTO `t_return_state` VALUES (3, '书籍定损');
INSERT INTO `t_return_state` VALUES (4, '无损通过');

-- ----------------------------
-- Table structure for t_user
-- ----------------------------
DROP TABLE IF EXISTS `t_user`;
CREATE TABLE `t_user`  (
  `user_id` bigint NOT NULL AUTO_INCREMENT,
  `gender` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `user_num` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `telephone_num` bigint NOT NULL,
  `user_photo` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `email` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `user_category_id` bigint NOT NULL,
  `user_account_num` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `fee_all` float NOT NULL,
  `blacklist` tinyint(1) NOT NULL,
  `password` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `is_delete` tinyint(1) NOT NULL DEFAULT 0,
  PRIMARY KEY (`user_id`) USING BTREE,
  UNIQUE INDEX `user_num`(`user_num` ASC) USING BTREE,
  INDEX `FK_Reference_1`(`gender` ASC) USING BTREE,
  INDEX `FK_Reference_11`(`user_category_id` ASC) USING BTREE,
  CONSTRAINT `FK_Reference_11` FOREIGN KEY (`user_category_id`) REFERENCES `t_user_category` (`user_category_id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 13 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of t_user
-- ----------------------------
INSERT INTO `t_user` VALUES (1, '男', '李昊', '123456', 19817115293, 'http://120.26.46.103:8080/library/static/bookImage/ee2620d8-9486-414e-a7a4-9fb9bac38015.jpg', '805459342@qq.com', 1, 's805459342', 99, 0, '123456', 0);
INSERT INTO `t_user` VALUES (2, '女', '吕红', '20240312', 12345678, 'http://120.26.46.103:8080/library/static/bookImage/ee2620d8-9486-414e-a7a4-9fb9bac38015.jpg', '805459342@qq.com', 2, 't805459342', 0, 0, '123123', 0);
INSERT INTO `t_user` VALUES (3, '男', '王冲', '225701120', 19817115293, 'http://120.26.46.103:8080/library/static/bookImage/ee2620d8-9486-414e-a7a4-9fb9bac38015.jpg', '805459342@qq.com', 1, 's123456', 0, 0, '123456', 1);
INSERT INTO `t_user` VALUES (4, '男', '王冲儿', '225701121', 19855823027, 'http://120.26.46.103:8080/library/static/bookImage/ee2620d8-9486-414e-a7a4-9fb9bac38015.jpg', '805459342@qq.com', 1, 's111111', 0, 0, '123456', 1);
INSERT INTO `t_user` VALUES (5, '男', '林丹', '225701122', 13034062843, 'http://120.26.46.103:8080/library/static/bookImage/ee2620d8-9486-414e-a7a4-9fb9bac38015.jpg', '805459342@qq.com', 1, 's111112', 0, 0, '123456', 0);
INSERT INTO `t_user` VALUES (6, '男', '孙完虎', '225701124', 13034062888, 'http://120.26.46.103:8080/library/static/bookImage/ee2620d8-9486-414e-a7a4-9fb9bac38015.jpg', '805459342@qq.com', 2, 't111113', 0, 0, '123456', 0);
INSERT INTO `t_user` VALUES (7, '男', '孙俊', '225701123', 13034062999, 'http://120.26.46.103:8080/library/static/bookImage/ee2620d8-9486-414e-a7a4-9fb9bac38015.jpg', '805459342@qq.com', 2, 't111114', 0, 0, '123456', 0);
INSERT INTO `t_user` VALUES (9, '男', '李永波', '225701125', 13034062000, 'http://120.26.46.103:8080/library/static/bookImage/ee2620d8-9486-414e-a7a4-9fb9bac38015.jpg', '805459342@qq.com', 2, 't111115', 0, 0, '123456', 0);
INSERT INTO `t_user` VALUES (10, '男', '测试学生01', 'test01', 123456, 'http://120.26.46.103:8080/library/static/bookImage/ee2620d8-9486-414e-a7a4-9fb9bac38015.jpg', 'test01@qq.com', 1, 'stest01', 0, 0, '123456', 1);
INSERT INTO `t_user` VALUES (11, '男', '测试教师02', 'test02', 123456, 'http://120.26.46.103:8080/library/static/bookImage/ee2620d8-9486-414e-a7a4-9fb9bac38015.jpg', 'test@qq.com', 2, 't123456', 0, 0, '123456', 1);
INSERT INTO `t_user` VALUES (12, '男', '李天行', 's15151515', 13888888889, 'http://120.26.46.103:8080/library/static/studentImage/4f95af59-c371-4e50-b39a-123517ed771e.png', '16666666@qq.com', 1, 's15151515', 0, 0, '123123', 0);

-- ----------------------------
-- Table structure for t_user_category
-- ----------------------------
DROP TABLE IF EXISTS `t_user_category`;
CREATE TABLE `t_user_category`  (
  `user_category_id` bigint NOT NULL,
  `user_category` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  PRIMARY KEY (`user_category_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of t_user_category
-- ----------------------------
INSERT INTO `t_user_category` VALUES (1, '学生');
INSERT INTO `t_user_category` VALUES (2, '教师');

SET FOREIGN_KEY_CHECKS = 1;
