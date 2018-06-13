/*
SQLyog Ultimate v12.3.1 (64 bit)
MySQL - 8.0.11 : Database - epms
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`epms` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `epms`;

/*Table structure for table `attendance` */

DROP TABLE IF EXISTS `attendance`;

CREATE TABLE `attendance` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `eid` bigint(20) DEFAULT NULL,
  `month` int(11) DEFAULT NULL,
  `absenteeism` int(11) DEFAULT NULL COMMENT '缺勤',
  `leave` int(11) DEFAULT NULL COMMENT '请假',
  `prin_day` int(11) DEFAULT NULL COMMENT '应到天数',
  `overtime` int(11) DEFAULT NULL COMMENT '加班时间以小时来算',
  `onduty_day` int(11) DEFAULT NULL COMMENT '实际上班天数',
  `year` year(4) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `eid` (`eid`),
  CONSTRAINT `attendance_ibfk_1` FOREIGN KEY (`eid`) REFERENCES `employeeinfo` (`eid`)
) ENGINE=InnoDB AUTO_INCREMENT=75 DEFAULT CHARSET=utf8;

/*Data for the table `attendance` */

insert  into `attendance`(`id`,`eid`,`month`,`absenteeism`,`leave`,`prin_day`,`overtime`,`onduty_day`,`year`) values 
(1,1,1,1,1,31,10,29,2017),
(2,1,2,1,0,28,12,27,2017),
(3,1,3,1,2,31,11,30,2017),
(4,1,4,0,1,30,10,29,2017),
(5,1,5,2,2,31,10,27,2017),
(6,1,6,1,0,30,8,29,2017),
(7,1,7,1,1,31,12,29,2017),
(8,1,8,1,1,31,14,29,2017),
(9,1,9,1,2,30,15,27,2017),
(10,1,10,1,0,31,16,30,2017),
(11,1,11,1,0,30,13,29,2017),
(12,1,12,0,0,31,14,31,2017),
(13,2,1,0,0,31,15,31,2017),
(14,2,2,0,2,28,15,26,2017),
(15,2,3,1,2,31,20,28,2017),
(16,2,4,1,0,30,14,29,2017),
(17,2,5,0,2,31,12,31,2017),
(18,2,6,0,3,30,15,27,2017),
(19,2,7,0,2,31,21,29,2017),
(20,2,8,0,1,31,17,30,2017),
(21,2,9,0,4,30,16,26,2017),
(22,2,10,0,2,31,12,29,2017),
(23,2,11,1,1,30,10,28,2017),
(24,2,12,0,0,31,9,31,2017),
(25,3,1,1,0,31,12,30,2017),
(26,3,2,1,2,28,14,25,2017),
(27,3,3,2,4,31,21,25,2017),
(28,3,4,1,0,30,13,29,2017),
(29,3,5,0,1,31,11,30,2017),
(30,3,6,0,2,30,24,28,2017),
(31,3,7,0,2,31,12,29,2017),
(32,3,8,0,3,31,24,28,2017),
(33,3,9,0,4,30,12,26,2017),
(34,3,10,0,0,31,9,31,2017),
(35,3,11,0,0,30,11,30,2017),
(36,3,12,1,0,31,11,30,2017),
(37,4,1,0,1,31,12,30,2017),
(38,4,2,0,1,28,12,27,2017),
(39,4,3,0,1,31,21,30,2017),
(40,4,4,0,2,30,21,28,2017),
(41,4,5,0,4,31,16,27,2017),
(42,4,6,1,0,30,16,29,2017),
(43,4,7,0,1,31,12,3,2017),
(44,4,8,1,2,31,21,28,2017),
(45,4,9,0,3,30,15,27,2017),
(46,4,10,0,1,31,12,30,2017),
(47,4,11,0,0,30,16,30,2017),
(48,4,12,1,0,31,17,30,2017),
(49,5,1,0,1,31,12,30,2017),
(50,5,2,0,0,28,25,28,2017),
(51,5,3,0,2,31,11,29,2017),
(52,5,4,0,2,30,10,28,2017),
(53,5,5,1,4,31,11,26,2017),
(54,5,6,0,1,30,6,29,2017),
(55,5,7,0,2,31,9,29,2017),
(56,5,8,0,4,31,10,27,2017),
(57,5,9,0,1,30,11,29,2017),
(58,5,10,1,5,31,22,25,2017),
(59,5,11,0,2,30,11,28,2017),
(60,5,12,0,2,31,21,29,2017),
(61,6,1,1,3,31,14,27,2017),
(62,6,2,2,1,28,15,25,2017),
(63,6,3,1,0,31,16,30,2017),
(64,6,4,1,1,30,14,28,2017),
(65,6,5,1,0,31,13,30,2017),
(66,6,6,1,1,30,13,28,2017),
(67,6,7,0,2,31,16,29,2017),
(68,6,8,0,2,31,16,29,2017),
(69,6,9,0,3,30,6,27,2017),
(70,6,10,1,1,31,9,29,2017),
(71,6,11,0,1,30,11,29,2017),
(72,6,12,0,2,31,12,29,2017);

/*Table structure for table `authority` */

DROP TABLE IF EXISTS `authority`;

CREATE TABLE `authority` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8;

/*Data for the table `authority` */

insert  into `authority`(`id`,`name`) values 
(1,'add_person'),
(2,'delete_person'),
(3,'update_person'),
(4,'view_person'),
(5,'view_attendance'),
(6,'update_attendance'),
(7,'add_delete_salary'),
(8,'update_salary'),
(9,'view_salary'),
(10,'person_management'),
(11,'salary_management'),
(12,'attendance_managemen'),
(13,'authority_management'),
(14,'add_account'),
(15,'logout_account'),
(16,'sys_preserve');

/*Table structure for table `depart_job` */

DROP TABLE IF EXISTS `depart_job`;

CREATE TABLE `depart_job` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `jid` int(11) NOT NULL COMMENT '岗位id',
  `did` int(11) NOT NULL COMMENT '部门id',
  PRIMARY KEY (`id`),
  KEY `jid` (`jid`),
  KEY `did` (`did`),
  CONSTRAINT `depart_job_ibfk_1` FOREIGN KEY (`jid`) REFERENCES `job` (`id`),
  CONSTRAINT `depart_job_ibfk_2` FOREIGN KEY (`did`) REFERENCES `department` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

/*Data for the table `depart_job` */

insert  into `depart_job`(`id`,`jid`,`did`) values 
(1,1,1),
(2,1,2),
(3,1,3),
(4,2,1),
(5,2,2),
(6,2,3),
(7,3,1),
(8,3,2),
(9,3,3);

/*Table structure for table `department` */

DROP TABLE IF EXISTS `department`;

CREATE TABLE `department` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `dname` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

/*Data for the table `department` */

insert  into `department`(`id`,`dname`) values 
(1,'人事部'),
(2,'财务部'),
(3,'技术部');

/*Table structure for table `employeeinfo` */

DROP TABLE IF EXISTS `employeeinfo`;

CREATE TABLE `employeeinfo` (
  `eid` bigint(20) NOT NULL,
  `name` varchar(255) NOT NULL,
  `age` int(10) DEFAULT NULL,
  `sex` varchar(255) NOT NULL,
  `department` int(11) DEFAULT NULL,
  `job` int(11) DEFAULT NULL,
  `time` int(10) DEFAULT NULL,
  PRIMARY KEY (`eid`),
  KEY `department` (`department`),
  KEY `job` (`job`),
  CONSTRAINT `employeeinfo_ibfk_1` FOREIGN KEY (`department`) REFERENCES `department` (`id`),
  CONSTRAINT `employeeinfo_ibfk_2` FOREIGN KEY (`job`) REFERENCES `job` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `employeeinfo` */

insert  into `employeeinfo`(`eid`,`name`,`age`,`sex`,`department`,`job`,`time`) values 
(1,'张三',29,'男',1,1,1),
(2,'李四',20,'男',1,2,1),
(3,'王五',22,'男',2,3,2),
(4,'刘六',22,'男',1,1,2),
(5,'李明',23,'男',3,3,3),
(6,'小张',23,'男',3,1,2);

/*Table structure for table `job` */

DROP TABLE IF EXISTS `job`;

CREATE TABLE `job` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `jname` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

/*Data for the table `job` */

insert  into `job`(`id`,`jname`) values 
(1,'总经理'),
(2,'总监'),
(3,'普通员工');

/*Table structure for table `jobdetail` */

DROP TABLE IF EXISTS `jobdetail`;

CREATE TABLE `jobdetail` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `did` int(11) DEFAULT NULL,
  `jid` int(11) DEFAULT NULL,
  `authority` varchar(20) DEFAULT NULL,
  `auth_state` char(1) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `did` (`did`),
  KEY `jid` (`jid`),
  CONSTRAINT `jobdetail_ibfk_1` FOREIGN KEY (`did`) REFERENCES `department` (`id`),
  CONSTRAINT `jobdetail_ibfk_2` FOREIGN KEY (`jid`) REFERENCES `job` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=145 DEFAULT CHARSET=utf8;

/*Data for the table `jobdetail` */

insert  into `jobdetail`(`id`,`did`,`jid`,`authority`,`auth_state`) values 
(1,1,1,'add_person','1'),
(2,1,1,'delete_person','1'),
(3,1,1,'update_person','1'),
(4,1,1,'view_person','1'),
(5,1,1,'view_attendance','1'),
(6,1,1,'update_attendance','1'),
(7,1,1,'add_delete_salary','1'),
(8,1,1,'update_salary','1'),
(9,1,1,'view_salary','1'),
(10,1,1,'person_management','0'),
(11,1,1,'salary_management','0'),
(12,1,1,'attendance_managemen','0'),
(13,1,1,'authority_management','0'),
(14,1,1,'add_account','0'),
(15,1,1,'logout_account','0'),
(16,1,1,'sys_preserve','0'),
(17,1,2,'add_person','1'),
(18,1,2,'delete_person','1'),
(19,1,2,'update_person','1'),
(20,1,2,'view_person','1'),
(21,1,2,'view_attendance','1'),
(22,1,2,'update_attendance','1'),
(23,1,2,'add_delete_salary','1'),
(24,1,2,'update_salary','1'),
(25,1,2,'view_salary','1'),
(26,1,2,'person_management','1'),
(27,1,2,'salary_management','1'),
(28,1,2,'attendance_managemen','1'),
(29,1,2,'authority_management','1'),
(30,1,2,'add_account','1'),
(31,1,2,'logout_account','1'),
(32,1,2,'sys_preserve','1'),
(33,1,3,'add_person','1'),
(34,1,3,'delete_person','1'),
(35,1,3,'update_person','1'),
(36,1,3,'view_person','1'),
(37,1,3,'view_attendance','1'),
(38,1,3,'update_attendance','1'),
(39,1,3,'add_delete_salary','1'),
(40,1,3,'update_salary','1'),
(41,1,3,'view_salary','1'),
(42,1,3,'person_management','1'),
(43,1,3,'salary_management','1'),
(44,1,3,'attendance_managemen','1'),
(45,1,3,'authority_management','1'),
(46,1,3,'add_account','1'),
(47,1,3,'logout_account','1'),
(48,1,3,'sys_preserve','1'),
(49,2,1,'add_person','1'),
(50,2,1,'delete_person','1'),
(51,2,1,'update_person','1'),
(52,2,1,'view_person','1'),
(53,2,1,'view_attendance','1'),
(54,2,1,'update_attendance','1'),
(55,2,1,'add_delete_salary','1'),
(56,2,1,'update_salary','1'),
(57,2,1,'view_salary','1'),
(58,2,1,'person_management','1'),
(59,2,1,'salary_management','1'),
(60,2,1,'attendance_managemen','1'),
(61,2,1,'authority_management','1'),
(62,2,1,'add_account','1'),
(63,2,1,'logout_account','1'),
(64,2,1,'sys_preserve','1'),
(65,2,2,'add_person','1'),
(66,2,2,'delete_person','1'),
(67,2,2,'update_person','1'),
(68,2,2,'view_person','1'),
(69,2,2,'view_attendance','1'),
(70,2,2,'update_attendance','1'),
(71,2,2,'add_delete_salary','1'),
(72,2,2,'update_salary','1'),
(73,2,2,'view_salary','1'),
(74,2,2,'person_management','1'),
(75,2,2,'salary_management','1'),
(76,2,2,'attendance_managemen','1'),
(77,2,2,'authority_management','1'),
(78,2,2,'add_account','1'),
(79,2,2,'logout_account','1'),
(80,2,2,'sys_preserve','1'),
(81,2,3,'add_person','1'),
(82,2,3,'delete_person','1'),
(83,2,3,'update_person','1'),
(84,2,3,'view_person','1'),
(85,2,3,'view_attendance','1'),
(86,2,3,'update_attendance','1'),
(87,2,3,'add_delete_salary','1'),
(88,2,3,'update_salary','1'),
(89,2,3,'view_salary','1'),
(90,2,3,'person_management','1'),
(91,2,3,'salary_management','1'),
(92,2,3,'attendance_managemen','1'),
(93,2,3,'authority_management','1'),
(94,2,3,'add_account','1'),
(95,2,3,'logout_account','1'),
(96,2,3,'sys_preserve','1'),
(97,3,1,'add_person','1'),
(98,3,1,'delete_person','1'),
(99,3,1,'update_person','1'),
(100,3,1,'view_person','1'),
(101,3,1,'view_attendance','1'),
(102,3,1,'update_attendance','1'),
(103,3,1,'add_delete_salary','1'),
(104,3,1,'update_salary','1'),
(105,3,1,'view_salary','1'),
(106,3,1,'person_management','1'),
(107,3,1,'salary_management','1'),
(108,3,1,'attendance_managemen','1'),
(109,3,1,'authority_management','1'),
(110,3,1,'add_account','1'),
(111,3,1,'logout_account','1'),
(112,3,1,'sys_preserve','1'),
(113,3,2,'add_person','1'),
(114,3,2,'delete_person','1'),
(115,3,2,'update_person','1'),
(116,3,2,'view_person','1'),
(117,3,2,'view_attendance','1'),
(118,3,2,'update_attendance','1'),
(119,3,2,'add_delete_salary','1'),
(120,3,2,'update_salary','1'),
(121,3,2,'view_salary','1'),
(122,3,2,'person_management','1'),
(123,3,2,'salary_management','1'),
(124,3,2,'attendance_managemen','1'),
(125,3,2,'authority_management','1'),
(126,3,2,'add_account','1'),
(127,3,2,'logout_account','1'),
(128,3,2,'sys_preserve','1'),
(129,3,3,'add_person','1'),
(130,3,3,'delete_person','1'),
(131,3,3,'update_person','1'),
(132,3,3,'view_person','1'),
(133,3,3,'view_attendance','1'),
(134,3,3,'update_attendance','1'),
(135,3,3,'add_delete_salary','1'),
(136,3,3,'update_salary','1'),
(137,3,3,'view_salary','1'),
(138,3,3,'person_management','1'),
(139,3,3,'salary_management','1'),
(140,3,3,'attendance_managemen','1'),
(141,3,3,'authority_management','1'),
(142,3,3,'add_account','1'),
(143,3,3,'logout_account','1'),
(144,3,3,'sys_preserve','1');

/*Table structure for table `personalsalary` */

DROP TABLE IF EXISTS `personalsalary`;

CREATE TABLE `personalsalary` (
  `pid` bigint(20) DEFAULT NULL,
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `basicsalary` int(255) NOT NULL COMMENT '基本工资',
  `otsalary` int(255) NOT NULL COMMENT '加班费',
  `allowance` int(255) NOT NULL COMMENT '津贴',
  `total` int(255) NOT NULL COMMENT '总工资',
  `year` year(4) DEFAULT NULL,
  `month` int(4) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `pid` (`pid`),
  CONSTRAINT `epid` FOREIGN KEY (`pid`) REFERENCES `employeeinfo` (`eid`),
  CONSTRAINT `personalsalary_ibfk_1` FOREIGN KEY (`pid`) REFERENCES `employeeinfo` (`eid`)
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=utf8;

/*Data for the table `personalsalary` */

insert  into `personalsalary`(`pid`,`id`,`basicsalary`,`otsalary`,`allowance`,`total`,`year`,`month`) values 
(1,1,8000,2000,1000,11000,2017,4),
(1,2,7202,1000,901,9103,2017,5),
(1,3,7734,500,967,9201,2017,6),
(1,4,6404,3500,802,10706,2017,7),
(1,5,8000,3000,1000,12000,2017,8),
(1,6,7734,1500,967,10201,2017,9),
(1,7,6404,2500,802,9706,2017,10),
(2,8,6767,4400,870,12037,2017,12),
(3,9,3800,6900,514,11214,2017,12),
(4,10,5800,6300,774,12874,2017,11),
(4,11,6000,6900,800,13700,2017,12),
(5,12,4336,2200,608,7144,2017,10),
(5,13,4170,2400,585,7155,2017,11),
(5,14,8000,500,1000,9500,2017,12),
(6,19,9000,1200,300,10500,2018,6);

/*Table structure for table `user` */

DROP TABLE IF EXISTS `user`;

CREATE TABLE `user` (
  `number` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `password` varchar(20) NOT NULL,
  PRIMARY KEY (`number`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `user` */

insert  into `user`(`number`,`password`) values 
('1','1'),
('2','2'),
('3','3'),
('4','4');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
