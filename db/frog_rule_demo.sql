/*
Navicat MySQL Data Transfer

Source Server         : DB
Source Server Version : 50528
Source Host           : localhost:3306
Source Database       : demo

Target Server Type    : MYSQL
Target Server Version : 50528
File Encoding         : 65001

Date: 2018-11-05 00:50:54
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for field_config_rule
-- ----------------------------
DROP TABLE IF EXISTS `field_config_rule`;
CREATE TABLE `field_config_rule` (
  `id` int(16) NOT NULL AUTO_INCREMENT,
  `field_key` varchar(128) DEFAULT NULL,
  `source_type` varchar(10) DEFAULT NULL,
  `params` varchar(255) DEFAULT NULL,
  `priority` varchar(10) DEFAULT NULL,
  `required` int(1) DEFAULT NULL,
  `source_name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of field_config_rule
-- ----------------------------
INSERT INTO `field_config_rule` VALUES ('1', 'A', '1', 'b,tr,r,sadf,as,xc,qwe', '1', '0', 'com.tf.rule.strategy.impl.AtestProcess');
INSERT INTO `field_config_rule` VALUES ('2', 'B', '2', '3,5,9,2,0,12,32,22,11', '1', '0', 'com.tf.rule.strategy.impl.BtestProcess');
