-- --------------------------------------------------------
-- Host:                         127.0.0.1
-- Server version:               10.4.8-MariaDB - mariadb.org binary distribution
-- Server OS:                    Win64
-- HeidiSQL Version:             10.2.0.5599
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


-- Dumping database structure for casestudy
CREATE DATABASE IF NOT EXISTS `casestudy` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `casestudy`;

-- Dumping structure for table casestudy.orgs
CREATE TABLE IF NOT EXISTS `orgs` (
  `org_id` varchar(100) NOT NULL,
  `mission_id` varchar(100) DEFAULT NULL,
  `org_name` varchar(100) DEFAULT NULL,
  `email` varchar(100) DEFAULT NULL,
  `address` varchar(100) DEFAULT NULL,
  `user_id` int(11) NOT NULL,
  PRIMARY KEY (`org_id`),
  KEY `orgs_user_fk` (`user_id`),
  CONSTRAINT `orgs_user_fk` FOREIGN KEY (`user_id`) REFERENCES `users` (`user_id`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Data exporting was unselected.

-- Dumping structure for table casestudy.projects
CREATE TABLE IF NOT EXISTS `projects` (
  `project_id` int(11) NOT NULL,
  `org_name` varchar(100) DEFAULT NULL,
  `city` varchar(100) DEFAULT NULL,
  `country` varchar(100) DEFAULT NULL,
  `startDate` date DEFAULT NULL,
  `endDate` date DEFAULT NULL,
  `skill_id` varchar(100) DEFAULT NULL,
  `address` varchar(100) DEFAULT NULL,
  `org_id` varchar(100) NOT NULL,
  PRIMARY KEY (`project_id`),
  KEY `projectOrg_fk` (`org_id`),
  CONSTRAINT `projectOrg_fk` FOREIGN KEY (`org_id`) REFERENCES `orgs` (`org_id`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Data exporting was unselected.

-- Dumping structure for table casestudy.project_member
CREATE TABLE IF NOT EXISTS `project_member` (
  `project_id` varchar(100) NOT NULL,
  `org_id` varchar(100) NOT NULL,
  `skill_id` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`project_id`,`org_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Data exporting was unselected.

-- Dumping structure for table casestudy.skills
CREATE TABLE IF NOT EXISTS `skills` (
  `skill_id` varchar(100) NOT NULL,
  `skill_name` varchar(100) DEFAULT NULL,
  `description` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`skill_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Data exporting was unselected.

-- Dumping structure for table casestudy.users
CREATE TABLE IF NOT EXISTS `users` (
  `user_id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(20) DEFAULT NULL,
  `password` varchar(20) DEFAULT NULL,
  `prime_contact` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

-- Data exporting was unselected.

-- Dumping structure for table casestudy.volunteers
CREATE TABLE IF NOT EXISTS `volunteers` (
  `volunteer_id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) NOT NULL,
  `volunteer_name` varchar(100) DEFAULT NULL,
  `email` varchar(100) DEFAULT NULL,
  `address` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`volunteer_id`),
  KEY `volunteer_user_fk` (`user_id`),
  CONSTRAINT `volunteer_user_fk` FOREIGN KEY (`user_id`) REFERENCES `users` (`user_id`) ON DELETE CASCADE,
  CONSTRAINT `volunteers_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `users` (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

-- Data exporting was unselected.

-- Dumping structure for table casestudy.volunteer_skills
CREATE TABLE IF NOT EXISTS `volunteer_skills` (
  `project_id` varchar(100) DEFAULT NULL,
  `volunteer_id` varchar(100) DEFAULT NULL,
  `skill_id` varchar(100) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Data exporting was unselected.

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
