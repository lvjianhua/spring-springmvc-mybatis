/*
SQLyog Ultimate v12.09 (64 bit)
MySQL - 5.7.20-log : Database - problem
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`problem` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `problem`;

/*Table structure for table `answers` */

DROP TABLE IF EXISTS `answers`;

CREATE TABLE `answers` (
  `id` int(10) NOT NULL AUTO_INCREMENT COMMENT '答案id',
  `ansContent` varchar(200) NOT NULL COMMENT '答案内容',
  `ansDate` date NOT NULL COMMENT '回答时间',
  `qid` int(10) NOT NULL COMMENT '问题id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

/*Data for the table `answers` */

insert  into `answers`(`id`,`ansContent`,`ansDate`,`qid`) values (1,'我','2018-05-31',1);
insert  into `answers`(`id`,`ansContent`,`ansDate`,`qid`) values (2,'撒气','2018-05-05',1);
insert  into `answers`(`id`,`ansContent`,`ansDate`,`qid`) values (3,'五千万','2018-05-05',1);
insert  into `answers`(`id`,`ansContent`,`ansDate`,`qid`) values (4,'一种编程语言','2018-09-24',6);

/*Table structure for table `questions` */

DROP TABLE IF EXISTS `questions`;

CREATE TABLE `questions` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '问题id',
  `title` varchar(100) NOT NULL COMMENT '问题名',
  `etailDesc` varchar(300) DEFAULT NULL COMMENT '问题描述',
  `ansCount` int(10) NOT NULL DEFAULT '0' COMMENT '回答次数',
  `lastModified` date NOT NULL COMMENT '最后修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

/*Data for the table `questions` */

insert  into `questions`(`id`,`title`,`etailDesc`,`ansCount`,`lastModified`) values (1,'423','3424',43,'2018-06-09');
insert  into `questions`(`id`,`title`,`etailDesc`,`ansCount`,`lastModified`) values (2,'3日','让',0,'2018-05-05');
insert  into `questions`(`id`,`title`,`etailDesc`,`ansCount`,`lastModified`) values (3,'3日','让',0,'2018-05-05');
insert  into `questions`(`id`,`title`,`etailDesc`,`ansCount`,`lastModified`) values (4,'32','32',0,'2018-05-05');
insert  into `questions`(`id`,`title`,`etailDesc`,`ansCount`,`lastModified`) values (5,'323','32',0,'2018-09-24');
insert  into `questions`(`id`,`title`,`etailDesc`,`ansCount`,`lastModified`) values (6,'Java','Java是什么',0,'2018-09-24');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
