# ************************************************************
# Sequel Pro SQL dump
# Version 4541
#
# http://www.sequelpro.com/
# https://github.com/sequelpro/sequelpro
#
# Host: 127.0.0.1 (MySQL 5.6.17)
# Database: ordering
# Generation Time: 2018-11-24 21:42:46 +0000
# ************************************************************


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

# create user
CREATE USER 'orderinguser'@'%' IDENTIFIED BY 'orderorder';

;
GRANT ALL PRIVILEGES ON ordering.* TO 'orderinguser'@'%';
;
FLUSH PRIVILEGES
;


DROP TABLE IF EXISTS `addresses`;

CREATE TABLE `addresses` (
  `id` bigint(255) NOT NULL AUTO_INCREMENT,
  `city` varchar(10) NOT NULL,
  `postalCode` varchar(10) NOT NULL,
  `country` varchar(200) DEFAULT NULL,
  `addressLine1` varchar(200) DEFAULT NULL,
  `addressLine2` varchar(200) DEFAULT NULL,
  `province` varchar(60) DEFAULT NULL,
  UNIQUE KEY `unique_id` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

LOCK TABLES `addresses` WRITE;
/*!40000 ALTER TABLE `addresses` DISABLE KEYS */;

INSERT INTO `addresses` (`id`, `city`, `postalCode`, `country`, `addressLine1`, `addressLine2`, `province`)
VALUES
	(1,'Montreal','H2F3Z7','Canada','2343 Rue Guy',NULL,'QC'),
	(2,'Montreal','H2F3Z7','Canada','2346 Rue Guy',NULL,'QC');

/*!40000 ALTER TABLE `addresses` ENABLE KEYS */;
UNLOCK TABLES;


# Dump of table order_items
# ------------------------------------------------------------

DROP TABLE IF EXISTS `order_items`;

CREATE TABLE `order_items` (
  `id` bigint(255) NOT NULL AUTO_INCREMENT,
  `orderId` bigint(255) NOT NULL,
  `productId` bigint(255) NOT NULL,
  `quantity` int(255) NOT NULL,
  `price` decimal(10,2) NOT NULL,
  `productName` varchar(255) NOT NULL,
  UNIQUE KEY `unique_id` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

LOCK TABLES `order_items` WRITE;
/*!40000 ALTER TABLE `order_items` DISABLE KEYS */;

INSERT INTO `order_items` (`id`, `orderId`, `productId`, `quantity`, `price`, `productName`)
VALUES
	(1,1,1,2,4.00,''),
	(2,1,2,3,5.23,''),
	(3,12,1,2,4.00,'0'),
	(4,13,1,2,4.00,'Sony Play Station'),
	(5,14,1,2,4.00,'Sony TV'),
	(6,15,1,2,4.00,'Sony TV'),
	(7,16,1,2,4.00,'Sony TV'),
	(9,18,1,2,4.00,'Sony TV'),
	(10,19,1,2,4.00,'Sony TV');

/*!40000 ALTER TABLE `order_items` ENABLE KEYS */;
UNLOCK TABLES;


# Dump of table orders
# ------------------------------------------------------------

DROP TABLE IF EXISTS `orders`;

CREATE TABLE `orders` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `total` decimal(10,2) NOT NULL,
  `description` varchar(255) NOT NULL,
  `subtotal` decimal(10,2) NOT NULL,
  `status` varchar(40) DEFAULT NULL,
  `date` date DEFAULT NULL,
  `customerId` int(11) DEFAULT NULL,
  `customerName` varchar(100) DEFAULT NULL,
  `addressId` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `unique_id` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

LOCK TABLES `orders` WRITE;
/*!40000 ALTER TABLE `orders` DISABLE KEYS */;

INSERT INTO `orders` (`id`, `total`, `description`, `subtotal`, `status`, `date`, `customerId`, `customerName`, `addressId`)
VALUES
	(1,0.00,'This is my order',0.00,'cancelled',NULL,1,'John Doe',1),
	(2,0.00,'This is my order',0.00,'cancelled',NULL,2,'John Doe',1),
	(3,0.00,'This is my order',0.00,'cancelled',NULL,2,'John Doe',1),
	(4,0.00,'This is my order',0.00,'cancelled',NULL,2,'John Doe',1),
	(5,0.00,'This is my order',0.00,'cancelled',NULL,2,'John Doe',1),
	(12,0.00,'This is my order',0.00,'cancelled',NULL,2,'John Doe',1),
	(13,0.00,'This is my order',0.00,'cancelled','2018-11-19',2,'John Doe',1),
	(14,0.00,'This is my order',0.00,'cancelled','2018-11-25',2,'Bony Nony',1),
	(15,8.00,'This is my order',0.00,'created','2018-11-25',2,'Bony Nony',1),
	(18,8.00,'This is my order',0.00,'cancelled','2018-11-25',2,'Bony Nony',1),
	(19,8.00,'This is my order',0.00,'created','2018-11-25',2,'Bony Nony',2);

/*!40000 ALTER TABLE `orders` ENABLE KEYS */;
UNLOCK TABLES;



/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
