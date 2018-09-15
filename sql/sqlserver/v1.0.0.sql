/*
SQLyog 企业版 - MySQL GUI v7.14
MySQL - 5.0.96-community-nt : Database - test4
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;


/*!40014 SE/*!40101 SET SQL_MODE=''*/;
T @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;

CREATE DATABASE /*!32312 IF NOT EXISTS*/`test` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `test`;

/*Table structure for table `t_b_user` */

DROP TABLE IF EXISTS `t_b_user`;

CREATE TABLE `t_b_user` (
  `id` bigint(20) NOT NULL auto_increment,
  `auth` varchar(255) default NULL,
  `isbn` varchar(255) default NULL,
  `name` varchar(255) default NULL,
  `orgid` bigint(20) default NULL,
  `password` varchar(255) default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

/*Data for the table `t_b_user` */

LOCK TABLES `t_b_user` WRITE;

insert  into `t_b_user`(`id`,`auth`,`isbn`,`name`,`orgid`,`password`) values (3,NULL,NULL,'961',NULL,'771665'),(4,NULL,NULL,'419',NULL,'954047'),(5,NULL,NULL,'126',NULL,'984132');

UNLOCK TABLES;
