/*
SQLyog v10.2 
MySQL - 8.0.31 : Database - driverschooldb
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`driverschooldb` /*!40100 DEFAULT CHARACTER SET utf8mb3 */ /*!80016 DEFAULT ENCRYPTION='N' */;

USE `driverschooldb`;

/*Table structure for table `t_car_coach` */

DROP TABLE IF EXISTS `t_car_coach`;

CREATE TABLE `t_car_coach` (
  `coach_id` int NOT NULL AUTO_INCREMENT,
  `coach_name` varchar(50) DEFAULT NULL,
  `coach_phone` varchar(12) DEFAULT NULL,
  `coach_gander` varchar(10) DEFAULT NULL,
  `coach_experience` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`coach_id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb3;

/*Data for the table `t_car_coach` */

insert  into `t_car_coach`(`coach_id`,`coach_name`,`coach_phone`,`coach_gander`,`coach_experience`) values (1,'张教练','13833881234','male','15年公交驾龄，从事驾校教练工作12年'),(2,'李教练','13833881122','female','A1驾照10年，零事故，有耐心，教授学员8年'),(3,'王教练','13833883344','male','城市公交驾龄25年，持A3驾照，从事驾校教练工作5年');

/*Table structure for table `t_coachcar` */

DROP TABLE IF EXISTS `t_coachcar`;

CREATE TABLE `t_coachcar` (
  `car_id` int NOT NULL AUTO_INCREMENT,
  `car_brand` varchar(20) DEFAULT NULL,
  `car_number` varchar(10) DEFAULT NULL,
  `car_type` varchar(10) DEFAULT NULL,
  `car_desc` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`car_id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb3;

/*Data for the table `t_coachcar` */

insert  into `t_coachcar`(`car_id`,`car_brand`,`car_number`,`car_type`,`car_desc`) values (1,'长城','黑A54321','小型轿车','适用于C1、C2学员'),(2,'吉利','黑A11223','小型轿车','适用于C1、C2学员'),(3,'长安','黑A12345','小型轿车','适用于C1、C2学员');

/*Table structure for table `t_coachcar_stu` */

DROP TABLE IF EXISTS `t_coachcar_stu`;

CREATE TABLE `t_coachcar_stu` (
  `coachcar_stu_id` int NOT NULL AUTO_INCREMENT,
  `car_id` int DEFAULT NULL,
  `stu_id` int DEFAULT NULL,
  PRIMARY KEY (`coachcar_stu_id`),
  KEY `fk_coachcar` (`car_id`),
  KEY `fk_stu` (`stu_id`),
  CONSTRAINT `fk_coachcar` FOREIGN KEY (`car_id`) REFERENCES `t_coachcar` (`car_id`),
  CONSTRAINT `fk_stu` FOREIGN KEY (`stu_id`) REFERENCES `t_student` (`stu_id`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8mb3;

/*Data for the table `t_coachcar_stu` */

insert  into `t_coachcar_stu`(`coachcar_stu_id`,`car_id`,`stu_id`) values (2,1,101),(3,1,102),(4,2,102),(5,2,103),(6,3,102),(14,2,101),(15,1,120),(16,2,120);

/*Table structure for table `t_role` */

DROP TABLE IF EXISTS `t_role`;

CREATE TABLE `t_role` (
  `role_id` int NOT NULL AUTO_INCREMENT COMMENT '角色id',
  `role_name` varchar(256) DEFAULT NULL COMMENT '角色名称',
  `role_code` varchar(256) DEFAULT NULL COMMENT '角色代码,用于权限校验',
  PRIMARY KEY (`role_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb3;

/*Data for the table `t_role` */

insert  into `t_role`(`role_id`,`role_name`,`role_code`) values (1,'管理员','11'),(2,'教练','01');

/*Table structure for table `t_stu_carcard` */

DROP TABLE IF EXISTS `t_stu_carcard`;

CREATE TABLE `t_stu_carcard` (
  `card_id` int NOT NULL AUTO_INCREMENT,
  `card_name` varchar(20) DEFAULT NULL,
  `card_number` varchar(20) DEFAULT NULL,
  `card_cosume` double DEFAULT NULL,
  `stu_id` int DEFAULT NULL,
  `card_state` char(1) DEFAULT NULL,
  PRIMARY KEY (`card_id`),
  UNIQUE KEY `stu_id` (`stu_id`),
  CONSTRAINT `t_stu_carcard_ibfk_1` FOREIGN KEY (`stu_id`) REFERENCES `t_student` (`stu_id`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8mb3;

/*Data for the table `t_stu_carcard` */

insert  into `t_stu_carcard`(`card_id`,`card_name`,`card_number`,`card_cosume`,`stu_id`,`card_state`) values (2,'2023年第28批学员-周末班-学员2','2023100280201002',32,101,'0'),(3,'2023年第28批学员-周末班-学员3','2023100280201003',24,102,'0'),(14,'这是练车卡名称','1683959395361',124,120,'0');

/*Table structure for table `t_student` */

DROP TABLE IF EXISTS `t_student`;

CREATE TABLE `t_student` (
  `stu_id` int NOT NULL AUTO_INCREMENT,
  `stu_name` varchar(20) DEFAULT NULL,
  `age` int DEFAULT NULL,
  `sex` char(6) DEFAULT NULL,
  `email` varchar(50) DEFAULT NULL,
  `stu_coach_id` int DEFAULT NULL,
  PRIMARY KEY (`stu_id`),
  KEY `fk_stu_coach` (`stu_coach_id`),
  CONSTRAINT `fk_stu_coach` FOREIGN KEY (`stu_coach_id`) REFERENCES `t_car_coach` (`coach_id`)
) ENGINE=InnoDB AUTO_INCREMENT=122 DEFAULT CHARSET=utf8mb3;

/*Data for the table `t_student` */

insert  into `t_student`(`stu_id`,`stu_name`,`age`,`sex`,`email`,`stu_coach_id`) values (101,'Jack',22,'male','123@163.com',1),(102,'Lily',22,'female','123@126.com',1),(103,'Candy',20,'female','620@qq.com',2),(104,'James',19,'male','719@qq.com',2),(120,'周周',23,'m','1543462@qq.com',2);

/*Table structure for table `t_user` */

DROP TABLE IF EXISTS `t_user`;

CREATE TABLE `t_user` (
  `user_id` int NOT NULL AUTO_INCREMENT COMMENT ' 用户id',
  `username` varchar(256) NOT NULL COMMENT '用户名',
  `password` varchar(256) NOT NULL COMMENT '密码',
  `role_id` int DEFAULT NULL COMMENT '用户角色',
  `create_time` varchar(256) DEFAULT NULL COMMENT '创建时间',
  `auth_user_id` int DEFAULT NULL COMMENT '授权人id',
  PRIMARY KEY (`user_id`),
  KEY `role_id` (`role_id`),
  CONSTRAINT `t_user_ibfk_1` FOREIGN KEY (`role_id`) REFERENCES `t_role` (`role_id`) ON DELETE SET NULL ON UPDATE SET NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;

/*Data for the table `t_user` */

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
