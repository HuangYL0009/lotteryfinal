create schema students;
USE `students`;


DROP TABLE IF EXISTS `studentData`;

CREATE TABLE `studentData` (
                               `id` bigint(50) auto_increment COMMENT 'id',
                               `sno` varchar(36) DEFAULT NULL COMMENT '学号',
                               `name` varchar(45) DEFAULT NULL COMMENT '姓名',
                               `sex` varchar(11) DEFAULT NULL COMMENT '性别',
                               PRIMARY KEY (`id`)
);
insert  into `studentData`(sno,name,sex) values ('123456','admin','male'),('123456','test','female');