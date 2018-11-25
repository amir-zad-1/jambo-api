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


# Dump of table addresses
# ------------------------------------------------------------

DROP TABLE IF EXISTS `addresses`;

CREATE TABLE `addresses` (
  `id` bigint(255) NOT NULL AUTO_INCREMENT,
  `city` varchar(10) NOT NULL,
  `postalCode` varchar(10) NOT NULL,
  UNIQUE KEY `unique_id` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;



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
	(4,13,1,2,4.00,'0');

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
  PRIMARY KEY (`id`),
  UNIQUE KEY `unique_id` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

LOCK TABLES `orders` WRITE;
/*!40000 ALTER TABLE `orders` DISABLE KEYS */;

INSERT INTO `orders` (`id`, `total`, `description`, `subtotal`, `status`, `date`)
VALUES
	(1,0.00,'This is my order',0.00,'cancelled',NULL),
	(2,0.00,'This is my order',0.00,'cancelled',NULL),
	(3,0.00,'This is my order',0.00,'cancelled',NULL),
	(4,0.00,'This is my order',0.00,'cancelled',NULL),
	(5,0.00,'This is my order',0.00,'cancelled',NULL),
	(12,0.00,'This is my order',0.00,'cancelled',NULL),
	(13,0.00,'This is my order',0.00,'cancelled','2018-11-19');

/*!40000 ALTER TABLE `orders` ENABLE KEYS */;
UNLOCK TABLES;



/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
