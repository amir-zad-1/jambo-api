-- Valentina Studio --
-- MySQL dump --
-- ---------------------------------------------------------


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
-- ---------------------------------------------------------


-- DROP DATABASE "ordering" --------------------------------
DROP DATABASE IF EXISTS `ordering`;
-- ---------------------------------------------------------


-- CREATE DATABASE "ordering" ------------------------------
CREATE DATABASE `ordering` CHARACTER SET utf8 COLLATE utf8_general_ci;
USE `ordering`;
-- ---------------------------------------------------------


-- CREATE TABLE "addresses" ------------------------------------
CREATE TABLE `addresses` (
	`id` BigInt( 255 ) NOT NULL,
	`city` VarChar( 10 ) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
	`postalCode` VarChar( 10 ) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
	CONSTRAINT `unique_id` UNIQUE( `id` ) )
CHARACTER SET = utf8
COLLATE = utf8_general_ci
ENGINE = InnoDB;
-- -------------------------------------------------------------


-- CREATE TABLE "order_items" ----------------------------------
CREATE TABLE `order_items` (
	`id` BigInt( 255 ) NOT NULL,
	`orderId` BigInt( 255 ) NOT NULL,
	`productId` BigInt( 255 ) NOT NULL,
	`quantity` Int( 255 ) NOT NULL,
	`price` Decimal( 10, 2 ) NOT NULL,
	`productName` VarChar( 255 ) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
	CONSTRAINT `unique_id` UNIQUE( `id` ) )
CHARACTER SET = utf8
COLLATE = utf8_general_ci
ENGINE = InnoDB;
-- -------------------------------------------------------------


-- CREATE TABLE "orders" ---------------------------------------
CREATE TABLE `orders` (
	`id` BigInt( 20 ) NOT NULL,
	`total` Decimal( 10, 2 ) NOT NULL,
	`description` VarChar( 255 ) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
	`subtotal` Decimal( 10, 2 ) NOT NULL,
	CONSTRAINT `unique_id` UNIQUE( `id` ) )
CHARACTER SET = utf8
COLLATE = utf8_general_ci
ENGINE = InnoDB;
-- -------------------------------------------------------------


-- Dump data of "addresses" --------------------------------
-- ---------------------------------------------------------


-- Dump data of "order_items" ------------------------------
LOCK TABLES `order_items` WRITE;

/*!40000 ALTER TABLE `order_items` DISABLE KEYS */

BEGIN;

REPLACE INTO `order_items`(`id`,`orderId`,`productId`,`quantity`,`price`,`productName`) VALUES ( '1', '1', '1', '2', '4.00', '' );
REPLACE INTO `order_items`(`id`,`orderId`,`productId`,`quantity`,`price`,`productName`) VALUES ( '2', '1', '2', '3', '5.23', '' );
COMMIT;
/*!40000 ALTER TABLE `order_items` ENABLE KEYS */

UNLOCK TABLES;

-- ---------------------------------------------------------


-- Dump data of "orders" -----------------------------------
LOCK TABLES `orders` WRITE;

/*!40000 ALTER TABLE `orders` DISABLE KEYS */

BEGIN;

REPLACE INTO `orders`(`id`,`total`,`description`,`subtotal`) VALUES ( '1', '23.20', '', '0.00' );
COMMIT;
/*!40000 ALTER TABLE `orders` ENABLE KEYS */

UNLOCK TABLES;

-- ---------------------------------------------------------


/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
-- ---------------------------------------------------------

