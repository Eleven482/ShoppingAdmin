/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50724
Source Host           : localhost:3306
Source Database       : mystore

Target Server Type    : MYSQL
Target Server Version : 50724
File Encoding         : 65001

Date: 2019-03-09 15:08:32
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `admin`
-- ----------------------------
DROP TABLE IF EXISTS `admin`;
CREATE TABLE `admin` (
  `id` varchar(255) NOT NULL,
  `username` varchar(50) DEFAULT NULL,
  `password` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of admin
-- ----------------------------
INSERT INTO `admin` VALUES ('1', 'admin', '123456');

-- ----------------------------
-- Table structure for `buy`
-- ----------------------------
DROP TABLE IF EXISTS `buy`;
CREATE TABLE `buy` (
  `id` int(32) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  `price` decimal(10,2) NOT NULL,
  `image` varchar(50) NOT NULL,
  `gdesc` varchar(255) NOT NULL,
  `is_hot` int(1) NOT NULL,
  `cid` int(50) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `cid` (`cid`),
  CONSTRAINT `buy_ibfk_1` FOREIGN KEY (`cid`) REFERENCES `category` (`cid`)
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of buy
-- ----------------------------
INSERT INTO `buy` VALUES ('3', '梵希蔓短袖雪纺衬衫短款2018夏季新款女装韩\r\n', '176.00', 'goods_003.png', '', '0', '2');
INSERT INTO `buy` VALUES ('4', '2018夏季新款雪纺衬衫女上衣职业OL短袖衬衣韩版修身休闲', '159.00', 'goods_004.png', '', '0', '2');
INSERT INTO `buy` VALUES ('5', '电脑椅家用电竞椅 人体工学椅子座椅网布转椅可躺老板椅办公椅', '269.00', 'goods_005.png', '', '0', '3');
INSERT INTO `buy` VALUES ('6', '电脑椅家用座椅办公椅主播椅子游戏椅网吧电竞椅可躺午休', '699.00', 'goods_006.png', '', '0', '3');
INSERT INTO `buy` VALUES ('7', '百图 立领条纹衬衫女套头短袖百搭雪纺衫上\r\n', '179.00', 'goods_007.png', '', '0', '4');
INSERT INTO `buy` VALUES ('8', '不锈钢卫浴室柜组合小户型挂墙式洗手洗脸盆池卫生间厕所洗漱台盆', '305.00', 'goods_008.png', '', '0', '4');
INSERT INTO `buy` VALUES ('9', '北欧双盆浴室柜组合简约卫浴柜镜柜卫生间洗手盆洗脸盆洗漱台盆柜', '900.00', 'goods_009.png', '', '0', '2');
INSERT INTO `buy` VALUES ('10', '简约现代浴室柜洗手盆柜组合洗脸卫生间小户型厕所洗漱台卫浴吊柜', '948.00', 'goods_10.png', '', '0', '5');
INSERT INTO `buy` VALUES ('11', '三只鸟旅行箱拉杆箱女铝框20寸行李箱万向轮24寸学生密码箱登机箱', '268.00', 'goods_11.png', '', '0', '5');
INSERT INTO `buy` VALUES ('12', '全铝镁铝合金拉杆箱金属旅行箱子男女万向轮行李箱商务学生登机箱', '375.00', 'goods_12.png', '', '0', '4');
INSERT INTO `buy` VALUES ('13', '床上双人电脑桌 台式电脑桌家用笔记本电脑桌 ', '89.00', 'goods_13.png', '', '0', '1');
INSERT INTO `buy` VALUES ('14', '男童鞋儿童运动鞋2018春秋新款夏季网面休闲透气小白网鞋女童鞋子', '79.00', 'goods_14.png', '', '0', '1');
INSERT INTO `buy` VALUES ('16', '添加', '111.11', 'goods_10.png', 'test01', '1', '2');
INSERT INTO `buy` VALUES ('18', 'add02', '11.00', 'goods_11.png', 'add02', '0', '1');
INSERT INTO `buy` VALUES ('19', '测试', '45.00', 'goods_11.png', '测试', '0', '1');

-- ----------------------------
-- Table structure for `car`
-- ----------------------------
DROP TABLE IF EXISTS `car`;
CREATE TABLE `car` (
  `id` int(32) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  `price` decimal(10,2) NOT NULL,
  `image` varchar(50) NOT NULL,
  `gdesc` varchar(255) NOT NULL,
  `is_hot` int(1) NOT NULL,
  `cid` int(50) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `cid` (`cid`),
  CONSTRAINT `car_ibfk_1` FOREIGN KEY (`cid`) REFERENCES `category` (`cid`)
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of car
-- ----------------------------
INSERT INTO `car` VALUES ('3', '梵希蔓短袖雪纺衬衫短款2018夏季新款女装韩\r\n', '176.00', 'goods_003.png', '', '0', '2');
INSERT INTO `car` VALUES ('4', '2018夏季新款雪纺衬衫女上衣职业OL短袖衬衣韩版修身休闲', '159.00', 'goods_004.png', '', '0', '2');
INSERT INTO `car` VALUES ('5', '电脑椅家用电竞椅 人体工学椅子座椅网布转椅可躺老板椅办公椅', '269.00', 'goods_005.png', '', '0', '3');
INSERT INTO `car` VALUES ('6', '电脑椅家用座椅办公椅主播椅子游戏椅网吧电竞椅可躺午休', '699.00', 'goods_006.png', '', '0', '3');
INSERT INTO `car` VALUES ('7', '百图 立领条纹衬衫女套头短袖百搭雪纺衫上\r\n', '179.00', 'goods_007.png', '', '0', '4');
INSERT INTO `car` VALUES ('8', '不锈钢卫浴室柜组合小户型挂墙式洗手洗脸盆池卫生间厕所洗漱台盆', '305.00', 'goods_008.png', '', '0', '4');
INSERT INTO `car` VALUES ('9', '北欧双盆浴室柜组合简约卫浴柜镜柜卫生间洗手盆洗脸盆洗漱台盆柜', '900.00', 'goods_009.png', '', '0', '2');
INSERT INTO `car` VALUES ('10', '简约现代浴室柜洗手盆柜组合洗脸卫生间小户型厕所洗漱台卫浴吊柜', '948.00', 'goods_10.png', '', '0', '5');
INSERT INTO `car` VALUES ('11', '三只鸟旅行箱拉杆箱女铝框20寸行李箱万向轮24寸学生密码箱登机箱', '268.00', 'goods_11.png', '', '0', '5');
INSERT INTO `car` VALUES ('12', '全铝镁铝合金拉杆箱金属旅行箱子男女万向轮行李箱商务学生登机箱', '375.00', 'goods_12.png', '', '0', '4');
INSERT INTO `car` VALUES ('13', '床上双人电脑桌 台式电脑桌家用笔记本电脑桌 ', '89.00', 'goods_13.png', '', '0', '1');
INSERT INTO `car` VALUES ('14', '男童鞋儿童运动鞋2018春秋新款夏季网面休闲透气小白网鞋女童鞋子', '79.00', 'goods_14.png', '', '0', '1');
INSERT INTO `car` VALUES ('16', '添加', '111.11', 'goods_10.png', 'test01', '1', '2');
INSERT INTO `car` VALUES ('18', 'add02', '11.00', 'goods_11.png', 'add02', '0', '1');
INSERT INTO `car` VALUES ('19', '测试', '45.00', 'goods_11.png', '测试', '0', '1');

-- ----------------------------
-- Table structure for `category`
-- ----------------------------
DROP TABLE IF EXISTS `category`;
CREATE TABLE `category` (
  `cid` int(50) NOT NULL AUTO_INCREMENT,
  `cname` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`cid`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of category
-- ----------------------------
INSERT INTO `category` VALUES ('1', '电脑办公');
INSERT INTO `category` VALUES ('2', '手机通信');
INSERT INTO `category` VALUES ('3', '智能设备');
INSERT INTO `category` VALUES ('4', '摄影影像');
INSERT INTO `category` VALUES ('5', '电子教育');

-- ----------------------------
-- Table structure for `goods`
-- ----------------------------
DROP TABLE IF EXISTS `goods`;
CREATE TABLE `goods` (
  `id` int(32) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  `price` decimal(10,2) NOT NULL,
  `image` varchar(50) NOT NULL,
  `gdesc` varchar(255) NOT NULL,
  `is_hot` int(1) NOT NULL,
  `cid` int(50) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `cid` (`cid`),
  CONSTRAINT `cid` FOREIGN KEY (`cid`) REFERENCES `category` (`cid`)
) ENGINE=InnoDB AUTO_INCREMENT=23 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of goods
-- ----------------------------
INSERT INTO `goods` VALUES ('4', '2018夏季新款雪纺衬衫女上衣职业OL短袖衬衣韩版修身休闲', '1.00', 'goods_010.png', '', '0', '2');
INSERT INTO `goods` VALUES ('5', '电脑椅家用电竞椅 人体工学椅子座椅网布转椅可躺老板椅办公椅', '269.00', 'goods_005.png', '', '0', '3');
INSERT INTO `goods` VALUES ('6', '电脑椅家用座椅办公椅主播椅子游戏椅网吧电竞椅可躺午休', '699.00', 'goods_006.png', '', '0', '3');
INSERT INTO `goods` VALUES ('7', '百图 立领条纹衬衫女套头短袖百搭雪纺衫上\r\n', '179.00', 'goods_007.png', '', '0', '4');
INSERT INTO `goods` VALUES ('8', '不锈钢卫浴室柜组合小户型挂墙式洗手洗脸盆池卫生间厕所洗漱台盆', '311.00', 'goods_010.png', '啊啊啊', '0', '4');
INSERT INTO `goods` VALUES ('9', '北欧双盆浴室柜组合简约卫浴柜镜柜卫生间洗手盆洗脸盆洗漱台盆柜', '900.00', 'goods_009.png', '', '0', '2');
INSERT INTO `goods` VALUES ('10', '简约现代浴室柜洗手盆柜组合洗脸卫生间小户型厕所洗漱台卫浴吊柜', '948.00', 'goods_010.png', '', '0', '5');
INSERT INTO `goods` VALUES ('11', '三只鸟旅行箱拉杆箱女铝框20寸行李箱万向轮24寸学生密码箱登机箱', '268.00', 'goods_011.png', '', '0', '5');
INSERT INTO `goods` VALUES ('12', '全铝镁铝合金拉杆箱金属旅行箱子男女万向轮行李箱商务学生登机箱', '375.00', 'goods_012.png', '', '0', '4');
INSERT INTO `goods` VALUES ('13', '床上双人电脑桌 台式电脑桌家用笔记本电脑桌 ', '89.00', 'goods_013.png', '', '0', '1');
INSERT INTO `goods` VALUES ('14', '男童鞋儿童运动鞋2018春秋新款夏季网面休闲透气小白网鞋女童鞋子', '79.00', 'goods_014.png', '', '0', '1');
INSERT INTO `goods` VALUES ('16', '添加', '111.11', 'goods_010.png', 'test01', '1', '2');
INSERT INTO `goods` VALUES ('18', 'add02', '11.00', 'goods_011.png', 'add02', '0', '1');
INSERT INTO `goods` VALUES ('19', '测试', '45.00', 'goods_011.png', '测试', '0', '1');
INSERT INTO `goods` VALUES ('20', 'add03', '456.00', 'goods_011.png', '123', '1', '3');
INSERT INTO `goods` VALUES ('21', '美容院1', '4980.00', 'goods_011.png', 'sad as ', '0', '2');
INSERT INTO `goods` VALUES ('22', 'add000', '444.00', 'goods_011.png', '1111', '1', '1');

-- ----------------------------
-- Table structure for `user`
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `uid` varchar(200) NOT NULL,
  `username` varchar(200) DEFAULT NULL,
  `password` varchar(200) DEFAULT NULL,
  `phone` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`uid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', 'test', '123', '1234');
