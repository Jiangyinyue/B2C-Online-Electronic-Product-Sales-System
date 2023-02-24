/*
SQLyog Community Edition- MySQL GUI v5.22a
Host - 6.0.11-alpha-community : Database - dianzi
*********************************************************************
Server version : 6.0.11-alpha-community
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

create database if not exists `dianzi`;

USE `dianzi`;

/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;

/*Table structure for table `goods` */

DROP TABLE IF EXISTS `goods`;

CREATE TABLE `goods` (
  `fid` int(11) NOT NULL AUTO_INCREMENT,
  `sellername` varchar(50) DEFAULT NULL,
  `goodsname` varchar(50) DEFAULT NULL,
  `price` float DEFAULT NULL,
  `amount` int(11) DEFAULT NULL,
  `introduce` varchar(500) DEFAULT NULL,
  `photo` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`fid`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

/*Data for the table `goods` */

insert  into `goods`(`fid`,`sellername`,`goodsname`,`price`,`amount`,`introduce`,`photo`) values (1,'罗技旗舰店','罗技K780键盘',399,1,'多设备 无线蓝牙键盘 超薄质感键盘 平板IPAD键盘','g1'),(2,'罗技旗舰店','罗技K380键盘',189,0,'平板IPAD键盘 时尚便携 超薄巧克力按键','g2'),(3,'罗技旗舰店','罗技K480键盘',179,0,'手机键盘 时尚键盘男生版','g3'),(4,'雷柏旗舰店','雷柏基础套装',129,0,'9000M 多模式无线键盘鼠标套装','g4'),(5,'雷柏旗舰店','雷柏V700RGB合金版',279,1,'108键幻彩背光游戏机械键盘 游戏键盘','g5'),(6,'IKBC旗舰店','ikbc C87',328,0,'樱桃轴机械键盘 87键 游戏键盘','g6'),(7,'IKBC旗舰店','ikbc时光机',699,3,'108键','g7');

/*Table structure for table `takecar` */

DROP TABLE IF EXISTS `takecar`;

CREATE TABLE `takecar` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `goodsname` varchar(50) DEFAULT NULL,
  `sellername` varchar(50) DEFAULT NULL,
  `username` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

/*Data for the table `takecar` */

insert  into `takecar`(`id`,`goodsname`,`sellername`,`username`) values (3,'罗技K480键盘','罗技旗舰店','zhang'),(4,'罗技K380键盘','罗技旗舰店','zhang'),(6,'ikbc C87','IKBC旗舰店','zhang');

/*Table structure for table `takeorder` */

DROP TABLE IF EXISTS `takeorder`;

CREATE TABLE `takeorder` (
  `oid` int(11) NOT NULL AUTO_INCREMENT,
  `sellername` varchar(50) DEFAULT NULL,
  `username` varchar(50) DEFAULT NULL,
  `goodsname` varchar(50) DEFAULT NULL,
  `flag` varchar(50) DEFAULT NULL,
  `price` float DEFAULT NULL,
  `total` float DEFAULT NULL,
  `amount` int(11) DEFAULT NULL,
  `address` varchar(50) DEFAULT NULL,
  `tel` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`oid`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

/*Data for the table `takeorder` */

insert  into `takeorder`(`oid`,`sellername`,`username`,`goodsname`,`flag`,`price`,`total`,`amount`,`address`,`tel`) values (1,'IKBC旗舰店','zhang','ikbc时光机','买家确认收货',699,714,1,'江苏省南京市','13878546354'),(2,'IKBC旗舰店','li','ikbc时光机','商家已接单，派送中',699,1413,2,'江苏省宿迁市','13878546354'),(3,'罗技旗舰店','zhang','罗技K780键盘','买家确认收货',399,414,1,'江苏省南京市','13878546354'),(4,'雷柏旗舰店','zhang','雷柏V700RGB合金版','买家确认收货',279,294,1,'江苏省南京市','13878546354');

/*Table structure for table `takeseller` */

DROP TABLE IF EXISTS `takeseller`;

CREATE TABLE `takeseller` (
  `sid` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) DEFAULT NULL,
  `pass` varchar(50) DEFAULT NULL,
  `sellername` varchar(50) DEFAULT NULL,
  `address` varchar(50) DEFAULT NULL,
  `peisong` int(11) DEFAULT NULL,
  `photo` varchar(50) DEFAULT NULL,
  `xiaoliang` int(11) DEFAULT NULL,
  PRIMARY KEY (`sid`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

/*Data for the table `takeseller` */

insert  into `takeseller`(`sid`,`name`,`pass`,`sellername`,`address`,`peisong`,`photo`,`xiaoliang`) values (1,'luoji','123','罗技旗舰店','江苏',15,'s1',1),(2,'leibo','123','雷柏旗舰店','北京',15,'s2',1),(3,'ikbc','123','IKBC旗舰店','江苏',15,'s3',2);

/*Table structure for table `takeuser` */

DROP TABLE IF EXISTS `takeuser`;

CREATE TABLE `takeuser` (
  `username` varchar(50) NOT NULL,
  `userpass` varchar(50) DEFAULT NULL,
  `address` varchar(500) DEFAULT NULL,
  `truename` varchar(50) DEFAULT NULL,
  `tel` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `takeuser` */

insert  into `takeuser`(`username`,`userpass`,`address`,`truename`,`tel`) values ('li','123','江苏省宿迁市','李四','15904512365'),('zhang','123','江苏省南京市','张三','13878546354');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
