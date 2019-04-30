/*
SQLyog Ultimate v11.24 (32 bit)
MySQL - 5.1.62-community : Database - cloud_note
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`cloud_note` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `cloud_note`;

/*Table structure for table `cn_activity` */

DROP TABLE IF EXISTS `cn_activity`;

CREATE TABLE `cn_activity` (
  `cn_activity_id` varchar(100) NOT NULL COMMENT '活动ID',
  `cn_activity_title` varchar(500) DEFAULT NULL COMMENT '活动标题',
  `cn_activity_body` text COMMENT '活动介绍(html片段)',
  `cn_activity_end_time` bigint(20) DEFAULT NULL COMMENT '活动结束时间',
  PRIMARY KEY (`cn_activity_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `cn_activity` */

insert  into `cn_activity`(`cn_activity_id`,`cn_activity_title`,`cn_activity_body`,`cn_activity_end_time`) values ('1','Java','Java技术征文',NULL),('10','测试','测试技术征文',NULL),('11','大数据','大数据技术征文',NULL),('2','.net','.net技术征文',NULL),('3','C++','C++技术征文',NULL),('4','IOS','IOS技术征文',NULL),('5','Andriod','Android技术征文',NULL),('6','网络营销','网络营销技术征文',NULL),('7','嵌入式','嵌入式技术征文',NULL),('8','PHP','PHP技术征文',NULL),('9','UID','UID技术征文',NULL);

/*Table structure for table `cn_activity_status` */

DROP TABLE IF EXISTS `cn_activity_status`;

CREATE TABLE `cn_activity_status` (
  `cn_activity_status_id` varchar(100) NOT NULL COMMENT '活动状态ID',
  `cn_activity_id` varchar(100) DEFAULT NULL COMMENT '活动ID',
  `cn_activity_status_code` varchar(500) DEFAULT NULL COMMENT '活动状态Code',
  `cn_activity_status_name` varchar(500) DEFAULT NULL COMMENT '活动状态名称',
  PRIMARY KEY (`cn_activity_status_id`),
  KEY `FK_Reference_9` (`cn_activity_id`),
  CONSTRAINT `FK_Reference_9` FOREIGN KEY (`cn_activity_id`) REFERENCES `cn_activity` (`cn_activity_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `cn_activity_status` */

insert  into `cn_activity_status`(`cn_activity_status_id`,`cn_activity_id`,`cn_activity_status_code`,`cn_activity_status_name`) values ('1','1','normal','normal');

/*Table structure for table `cn_emp` */

DROP TABLE IF EXISTS `cn_emp`;

CREATE TABLE `cn_emp` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(20) DEFAULT NULL,
  `age` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

/*Data for the table `cn_emp` */

insert  into `cn_emp`(`id`,`name`,`age`) values (1,'tom',20),(2,'scott',18),(3,'spring',21);

/*Table structure for table `cn_note` */

DROP TABLE IF EXISTS `cn_note`;

CREATE TABLE `cn_note` (
  `cn_note_id` varchar(100) NOT NULL COMMENT '笔记ID',
  `cn_notebook_id` varchar(100) DEFAULT NULL COMMENT '笔记本ID',
  `cn_user_id` varchar(100) DEFAULT NULL COMMENT '用户ID',
  `cn_note_status_id` varchar(100) DEFAULT NULL COMMENT '笔记状态ID:备用',
  `cn_note_type_id` varchar(100) DEFAULT NULL COMMENT '笔记本类型ID：备用',
  `cn_note_title` varchar(500) DEFAULT NULL COMMENT '笔记标题',
  `cn_note_body` text COMMENT '笔记内容',
  `cn_note_create_time` bigint(20) DEFAULT NULL COMMENT '笔记创建时间',
  `cn_note_last_modify_time` bigint(20) DEFAULT NULL COMMENT '笔记最近修改时间',
  PRIMARY KEY (`cn_note_id`),
  KEY `FK_Reference_2` (`cn_notebook_id`),
  KEY `FK_Reference_3` (`cn_user_id`),
  KEY `FK_Reference_7` (`cn_note_status_id`),
  KEY `FK_Reference_8` (`cn_note_type_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `cn_note` */

insert  into `cn_note`(`cn_note_id`,`cn_notebook_id`,`cn_user_id`,`cn_note_status_id`,`cn_note_type_id`,`cn_note_title`,`cn_note_body`,`cn_note_create_time`,`cn_note_last_modify_time`) values ('1673e537-a48d-488f-ae01-977cf306a411','302a6417-83fd-4aca-bce6-bb427f38e5da','48595f52-b22c-4485-9244-f4004255b972','2','1','b','<p>asfsdag<br/></p>',1556099431026,1556533717767),('1b04a6ff-6626-4262-98fa-d3d57cd1f79e','302a6417-83fd-4aca-bce6-bb427f38e5da','48595f52-b22c-4485-9244-f4004255b972','2','1','c','',1556099435034,NULL),('44bd6035-f936-493c-aec9-044097f560a0','44c06e08-4420-44ad-8750-79473fc240a0','48595f52-b22c-4485-9244-f4004255b972','2','1','SdXZ','',1555661155405,NULL),('49e23f48-0829-4d5e-a979-2881cf50bbc9','44c06e08-4420-44ad-8750-79473fc240a0','48595f52-b22c-4485-9244-f4004255b972','2','1','2','<p>123<br/></p>',1555655378798,1555655385662),('4f2a7249-c41a-4b40-b61d-3a9a7e2392ee','58fc71aa-b9f9-4ee4-b8b9-654ab26cdba2','48595f52-b22c-4485-9244-f4004255b972','1','1','第一天搭建环境','<p>ADSfdsgfh<br/></p>',1555041351020,1556533703383),('547e5821-ef16-4799-9951-1144a6140332','44c06e08-4420-44ad-8750-79473fc240a0','48595f52-b22c-4485-9244-f4004255b972','2','1','1','<p>123<br/></p>',1555655354641,1555655373325),('5f0c11f3-e4af-482c-b98a-3eee97ebf44d','44c06e08-4420-44ad-8750-79473fc240a0','48595f52-b22c-4485-9244-f4004255b972','2','1','1e234ew3','',1555660958416,NULL),('6c0a7cdc-a13e-47c0-9965-4b9ce5c3c6d1','44c06e08-4420-44ad-8750-79473fc240a0','48595f52-b22c-4485-9244-f4004255b972','2','1','qqq','',1555663412562,NULL),('721dc7ca-6e3b-49d1-b287-6a995220bccc','302a6417-83fd-4aca-bce6-bb427f38e5da','48595f52-b22c-4485-9244-f4004255b972','1','1','a','',1556099426464,NULL),('8c60df10-93d4-4eb5-8843-fd8525f66fa0','44c06e08-4420-44ad-8750-79473fc240a0','48595f52-b22c-4485-9244-f4004255b972','2','1','111','',1555660935224,NULL),('8d2cbfc8-ae74-42b5-b275-5094fb8cbfda','44c06e08-4420-44ad-8750-79473fc240a0','48595f52-b22c-4485-9244-f4004255b972','2','1','12243432','<p>qASDEAD<br/></p>',1555660338854,1555660342630),('8d5af94e-0d6f-49d2-86f3-dc3ebed24393','44c06e08-4420-44ad-8750-79473fc240a0','48595f52-b22c-4485-9244-f4004255b972','2','1','2','',1555655595506,NULL),('98cfdc6d-b69b-4510-9e75-af73603f5f07','44c06e08-4420-44ad-8750-79473fc240a0','48595f52-b22c-4485-9244-f4004255b972','2','1','1234122321','<p>1234123233</p><p>\n										</p>',1555151308049,1555165924522),('a24a2d73-c33b-4d25-ae4c-791145dd410d','b9844bfbe5704048bbd9be8354a2a00d','48595f52-b22c-4485-9244-f4004255b972','1','1','spring Ioc day01','',1555041295899,NULL),('ae7d5175-3f75-4296-b36c-12ba02c7f933','b9844bfbe5704048bbd9be8354a2a00d','48595f52-b22c-4485-9244-f4004255b972','1','1','spring day01','',1555041249616,NULL),('b04ca9c6-a12a-4073-97db-2aef5f4d06b5','44c06e08-4420-44ad-8750-79473fc240a0','48595f52-b22c-4485-9244-f4004255b972','2','1','111','',1555659909203,NULL),('b09895b8-54b5-4556-9281-afe1ddd57b0b','44c06e08-4420-44ad-8750-79473fc240a0','48595f52-b22c-4485-9244-f4004255b972','2','1','123467889xcuci vc','Czxfhggfvn<p>\n										</p>',1555053237564,1555153470113),('b2d587cd-6f79-4e4f-a00a-f383e9963239','44c06e08-4420-44ad-8750-79473fc240a0','48595f52-b22c-4485-9244-f4004255b972','2','1','EQWEREWR','',1555661628315,NULL),('b4c64cc5-228c-4ed5-9419-aa5bba39d78d','44c06e08-4420-44ad-8750-79473fc240a0','48595f52-b22c-4485-9244-f4004255b972','1','1','qszaSC','',1555663923004,NULL),('bcd73c66-6293-4a09-ac2c-25f37bd030cf','44c06e08-4420-44ad-8750-79473fc240a0','48595f52-b22c-4485-9244-f4004255b972','2','1','1','',1555655585106,NULL),('be9e854b-c247-48d5-b64a-6e5d61163f12','58fc71aa-b9f9-4ee4-b8b9-654ab26cdba2','48595f52-b22c-4485-9244-f4004255b972','1','1','第二天实现登陆','<p>11314345<br/></p>',1555041369940,1556533698069),('bf4fe62f-3c67-4d73-9c40-8c9c1cf40a74','44c06e08-4420-44ad-8750-79473fc240a0','48595f52-b22c-4485-9244-f4004255b972','2','1','1111','<p>fDSGFHGN<br/></p>',1555151316930,1555207716744),('d1fa6bbc-601d-429d-85ef-6a2dfe0b7d68','44c06e08-4420-44ad-8750-79473fc240a0','48595f52-b22c-4485-9244-f4004255b972','2','1','cZX','',1555661583065,NULL),('fc9e8203-7a91-45c0-a9f4-be52041032ac','5de5673d-288c-4038-8596-d4303f02ee59','48595f52-b22c-4485-9244-f4004255b972','1','1','1111','<h1>afsdfgdfg</h1><div><ul><li>awdasfsdagdf<br/></li></ul></div>',1555056406384,1555062037515);

/*Table structure for table `cn_note_activity` */

DROP TABLE IF EXISTS `cn_note_activity`;

CREATE TABLE `cn_note_activity` (
  `cn_note_activity_id` varchar(100) NOT NULL COMMENT '投稿ID',
  `cn_activity_id` varchar(100) DEFAULT NULL COMMENT '活动ID',
  `cn_note_id` varchar(100) DEFAULT NULL COMMENT '笔记ID',
  `cn_note_activity_up` int(11) DEFAULT NULL COMMENT '投稿赞:增加数',
  `cn_note_activity_down` int(11) DEFAULT NULL COMMENT '投稿踩:增加数',
  `cn_note_activity_title` varchar(500) DEFAULT NULL,
  `cn_note_activity_body` text,
  PRIMARY KEY (`cn_note_activity_id`),
  KEY `FK_Reference_4` (`cn_activity_id`),
  KEY `FK_Reference_5` (`cn_note_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `cn_note_activity` */

/*Table structure for table `cn_note_status` */

DROP TABLE IF EXISTS `cn_note_status`;

CREATE TABLE `cn_note_status` (
  `cn_note_status_id` varchar(100) NOT NULL COMMENT '笔记状态ID',
  `cn_note_status_code` varchar(100) DEFAULT NULL COMMENT '笔记状态Code',
  `cn_note_status_name` varchar(500) DEFAULT NULL COMMENT '笔记状态名字',
  PRIMARY KEY (`cn_note_status_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `cn_note_status` */

insert  into `cn_note_status`(`cn_note_status_id`,`cn_note_status_code`,`cn_note_status_name`) values ('1','normal','normal'),('2','delete','delete');

/*Table structure for table `cn_note_type` */

DROP TABLE IF EXISTS `cn_note_type`;

CREATE TABLE `cn_note_type` (
  `cn_note_type_id` varchar(100) NOT NULL COMMENT '笔记本类型ID',
  `cn_note_type_code` varchar(100) DEFAULT NULL COMMENT '笔记本类型Code',
  `cn_note_type_name` varchar(500) DEFAULT NULL COMMENT '笔记本类型名称',
  `cn_note_type_desc` text COMMENT '笔记本类型说明',
  PRIMARY KEY (`cn_note_type_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `cn_note_type` */

insert  into `cn_note_type`(`cn_note_type_id`,`cn_note_type_code`,`cn_note_type_name`,`cn_note_type_desc`) values ('1','normal','normal',NULL);

/*Table structure for table `cn_notebook` */

DROP TABLE IF EXISTS `cn_notebook`;

CREATE TABLE `cn_notebook` (
  `cn_notebook_id` varchar(100) NOT NULL COMMENT '笔记本ID',
  `cn_user_id` varchar(100) DEFAULT NULL COMMENT '用户ID',
  `cn_notebook_type_id` varchar(100) DEFAULT NULL COMMENT '笔记本类型ID',
  `cn_notebook_name` varchar(500) DEFAULT NULL COMMENT '笔记本名',
  `cn_notebook_desc` text COMMENT '笔记本说明',
  `cn_notebook_createtime` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00' ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`cn_notebook_id`),
  KEY `FK_Note_User_Reference` (`cn_user_id`),
  KEY `FK_Reference_6` (`cn_notebook_type_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `cn_notebook` */

insert  into `cn_notebook`(`cn_notebook_id`,`cn_user_id`,`cn_notebook_type_id`,`cn_notebook_name`,`cn_notebook_desc`,`cn_notebook_createtime`) values ('302a6417-83fd-4aca-bce6-bb427f38e5da','48595f52-b22c-4485-9244-f4004255b972','5','aaa',NULL,'2019-04-24 17:50:20'),('44c06e08-4420-44ad-8750-79473fc240a0','48595f52-b22c-4485-9244-f4004255b972','5','acsd',NULL,'2019-04-12 15:13:50'),('58fc71aa-b9f9-4ee4-b8b9-654ab26cdba2','48595f52-b22c-4485-9244-f4004255b972','5','云笔记项目',NULL,'2019-04-12 11:55:22'),('5de5673d-288c-4038-8596-d4303f02ee59','48595f52-b22c-4485-9244-f4004255b972','5','linux基本命令',NULL,'2019-04-12 10:00:33'),('623c1074d04641f78a04afc4ed64e684','48595f52-b22c-4485-9244-f4004255b972','1','java基础知识',NULL,'2019-04-12 10:02:41'),('b9844bfbe5704048bbd9be8354a2a00d','48595f52-b22c-4485-9244-f4004255b972','1','java框架',NULL,'2019-04-12 10:02:53');

/*Table structure for table `cn_notebook_type` */

DROP TABLE IF EXISTS `cn_notebook_type`;

CREATE TABLE `cn_notebook_type` (
  `cn_notebook_type_id` varchar(100) NOT NULL COMMENT '笔记本类型ID',
  `cn_notebook_type_code` varchar(100) DEFAULT NULL COMMENT '笔记本类型Code',
  `cn_notebook_type_name` varchar(500) DEFAULT NULL COMMENT '笔记本类型名称',
  `cn_notebook_type_desc` text COMMENT '笔记本类型说明',
  PRIMARY KEY (`cn_notebook_type_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `cn_notebook_type` */

insert  into `cn_notebook_type`(`cn_notebook_type_id`,`cn_notebook_type_code`,`cn_notebook_type_name`,`cn_notebook_type_desc`) values ('1','favorites','favorites','收藏'),('2','recycle','recycle','回收站'),('3','action','action','活动'),('4','push','push','推送'),('5','normal','normal','正常');

/*Table structure for table `cn_share` */

DROP TABLE IF EXISTS `cn_share`;

CREATE TABLE `cn_share` (
  `cn_share_id` varchar(100) NOT NULL COMMENT '共享ID',
  `cn_share_title` varchar(500) DEFAULT NULL COMMENT '共享标题',
  `cn_share_body` text COMMENT '共享内容',
  `cn_note_id` varchar(100) DEFAULT NULL COMMENT '笔记id',
  PRIMARY KEY (`cn_share_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `cn_share` */

insert  into `cn_share`(`cn_share_id`,`cn_share_title`,`cn_share_body`,`cn_note_id`) values ('054222e0-afe1-4dae-8cb9-a7eaf7c8d5f0','qszaSC',NULL,'b4c64cc5-228c-4ed5-9419-aa5bba39d78d'),('4d25bb57-37fe-4f83-a2f9-9f3bbefd072c','1',NULL,'bcd73c66-6293-4a09-ac2c-25f37bd030cf'),('5474c9da-4538-4137-9bc5-42f421a19db4','c',NULL,'1b04a6ff-6626-4262-98fa-d3d57cd1f79e'),('6c55813d-5b6f-4e22-8dc7-6bfd4933c555','1234122321',NULL,'98cfdc6d-b69b-4510-9e75-af73603f5f07'),('9128e01e-09f4-4716-8ee0-4d8ab8b8819c','a',NULL,'721dc7ca-6e3b-49d1-b287-6a995220bccc'),('aa4895d4-8cc4-447f-8f08-d52dca689d78','第二天实现登陆',NULL,'be9e854b-c247-48d5-b64a-6e5d61163f12'),('b07f500a-344d-4375-be74-f9e7def91e9a','1111',NULL,'bf4fe62f-3c67-4d73-9c40-8c9c1cf40a74'),('b09fa6064e3a4cf3a144d1279f8717aa','测试建立的笔记','','0e086e15000e4d3385afef193c18bb89');

/*Table structure for table `cn_user` */

DROP TABLE IF EXISTS `cn_user`;

CREATE TABLE `cn_user` (
  `cn_user_id` varchar(100) NOT NULL COMMENT '用户ID',
  `cn_user_name` varchar(100) DEFAULT NULL COMMENT '用户名',
  `cn_user_password` varchar(100) DEFAULT NULL COMMENT '密码',
  `cn_user_token` varchar(100) DEFAULT NULL COMMENT '令牌',
  `cn_user_nick` varchar(100) DEFAULT NULL COMMENT '说明',
  PRIMARY KEY (`cn_user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `cn_user` */

insert  into `cn_user`(`cn_user_id`,`cn_user_name`,`cn_user_password`,`cn_user_token`,`cn_user_nick`) values ('003c5f87-ab1e-424c-90d3-1c3cbe8cf33d','1','lueSGJZetyySpUndWjMBEg==',NULL,'1'),('0d9568f9-2c65-4441-9de9-058d60ce60b3','demo2','/OqSD3QStdp74M9CuMk3WQ==',NULL,'demo2'),('12a2cb90-e001-48f0-9493-cbdd8b9f7bda','demo1','gdyb21LQTcIANtvYMT7QVQ==',NULL,'demo1'),('474f9124-2270-4bd7-9b48-227f31642bed','demo4','4QrcOUm6Wau+VuBX8g+IPg==',NULL,'demo4'),('48595f52-b22c-4485-9244-f4004255b972','demo','gdyb21LQTcIANtvYMT7QVQ==',NULL,NULL),('a2cb7a29-512b-4117-95df-8dd3857981a4','demo3','4QrcOUm6Wau+VuBX8g+IPg==',NULL,'demo3');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
