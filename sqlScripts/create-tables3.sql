DROP DATABASE IF EXISTS `hb-04-many-to-many-uni`;

CREATE DATABASE `hb-04-many-to-many-uni`;

USE `hb-04-many-to-many-uni`;

DROP TABLE IF EXISTS `instructor_detail`;

CREATE TABLE `instructor_detail`(
	`id` int(11) NOT NULL AUTO_INCREMENT,
    `youtube_channel` VARCHAR(128) DEFAULT NULL,
    `hobby` VARCHAR(45) DEFAULT NULL,
    PRIMARY KEY(`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;

DROP TABLE IF EXISTS `instructor`;

CREATE TABLE `instructor`(
	`id` int(11) NOT NULL AUTO_INCREMENT,
    `first_name` VARCHAR(45) DEFAULT NULL,
    `last_name` VARCHAR(45) DEFAULT NULL,
    `email` VARCHAR(45) DEFAULT NULL,
    `instructor_detail_id` int(11) DEFAULT NULL,
    PRIMARY KEY(`id`),
    KEY `FK_DETAIL_idx` (`instructor_detail_id`), -- with 'KEY' we are telling mysql and the reader that this is a key  --
	CONSTRAINT `FK_DETAIL` FOREIGN KEY(`instructor_detail_id`) REFERENCES `instructor_detail`(`id`) 
     ON DELETE NO ACTION ON UPDATE NO ACTION -- default behavior
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;

DROP TABLE IF EXISTS `course`;

CREATE TABLE `course` (
	`id` int(11) NOT NULL AUTO_INCREMENT,
    `title` varchar(128) DEFAULT NULL,
    `instructor_id` int(11) DEFAULT NULL,
    
    PRIMARY KEY (`id`),
    UNIQUE KEY `TITLE_UNIQUE` (`title`),
    KEY `FK_INSTRUCTOR_idx` (`instructor_id`),
    CONSTRAINT `FK_INSTRUCTOR` FOREIGN KEY (`instructor_id`)
    REFERENCES `instructor` (`id`)
);

DROP TABLE IF EXISTS `review`;

CREATE TABLE `review` (
	`id` int(11) NOT NULL AUTO_INCREMENT,
    `comment` varchar(256) DEFAULT NULL,
    `course_id` int(11) DEFAULT NULL,
    
    PRIMARY KEY (`id`),
    KEY `FK_COURSE_idx` (`course_id`),
    CONSTRAINT `FK_COURSE` FOREIGN KEY (`course_id`) REFERENCES `course` (`id`)
); 



DROP TABLE IF EXISTS `student`;

CREATE TABLE `student` (
	`id` int(11) NOT NULL AUTO_INCREMENT,
    `first_name` varchar(45) DEFAULT NULL,
    `last_name` varchar(45) DEFAULT NULL,
    `email` varchar(45) DEFAULT NULL,
    
    PRIMARY KEY (`id`)
); 

DROP TABLE IF EXISTS `course_student`;

CREATE TABLE `course_student`(
	`course_id` int(11) NOT NULL,
    `student_id` int(11) NOT NULL,
    
    CONSTRAINT `FK_COURSE_01` FOREIGN KEY (`course_id`) REFERENCES `course` (`id`),
    CONSTRAINT `FK_STUDENT` FOREIGN KEY (`student_id`) REFERENCES `student` (`id`)
);


