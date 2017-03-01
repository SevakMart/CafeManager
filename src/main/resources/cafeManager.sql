/*
SQLyog Enterprise v12.09 (32 bit)
MySQL - 5.5.27 : Database - cafe_manager
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`cafe_manager` /*!40100 DEFAULT CHARACTER SET latin1 */;

USE `cafe_manager`;

/*Table structure for table `orders` */

DROP TABLE IF EXISTS `orders`;

CREATE TABLE `orders` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `tables_id` int(11) NOT NULL,
  `orders_status` enum('OPEN','CANCELLED','CLOSED') NOT NULL DEFAULT 'OPEN',
  PRIMARY KEY (`id`),
  KEY `tables_id` (`tables_id`),
  CONSTRAINT `orders_ibfk_1` FOREIGN KEY (`tables_id`) REFERENCES `tables` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;

/*Data for the table `orders` */

insert  into `orders`(`id`,`tables_id`,`orders_status`) values (1,1,'CLOSED'),(2,1,'OPEN'),(3,1,'CANCELLED'),(4,2,'OPEN');

/*Table structure for table `product_in_orders` */

DROP TABLE IF EXISTS `product_in_orders`;

CREATE TABLE `product_in_orders` (
  `orders_id` int(11) NOT NULL,
  `product_id` int(11) NOT NULL,
  `amount` int(3) NOT NULL,
  PRIMARY KEY (`orders_id`,`product_id`),
  KEY `product_id` (`product_id`),
  CONSTRAINT `product_in_orders_ibfk_1` FOREIGN KEY (`orders_id`) REFERENCES `orders` (`id`),
  CONSTRAINT `product_in_orders_ibfk_2` FOREIGN KEY (`product_id`) REFERENCES `products` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `product_in_orders` */

insert  into `product_in_orders`(`orders_id`,`product_id`,`amount`) values (2,1,2),(4,1,5);

/*Table structure for table `products` */

DROP TABLE IF EXISTS `products`;

CREATE TABLE `products` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(255) NOT NULL,
  `price` double NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

/*Data for the table `products` */

insert  into `products`(`id`,`title`,`price`) values (1,'product',5);

/*Table structure for table `tables` */

DROP TABLE IF EXISTS `tables`;

CREATE TABLE `tables` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `tables_number` int(3) NOT NULL,
  `user_id` int(11) DEFAULT NULL,
  `tables_status` enum('FREE','OCCUPIED') NOT NULL DEFAULT 'FREE',
  PRIMARY KEY (`id`),
  KEY `user_id` (`user_id`),
  CONSTRAINT `tables_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

/*Data for the table `tables` */

insert  into `tables`(`id`,`tables_number`,`user_id`,`tables_status`) values (1,1,2,'OCCUPIED'),(2,2,2,'OCCUPIED'),(3,3,NULL,'FREE');

/*Table structure for table `users` */

DROP TABLE IF EXISTS `users`;

CREATE TABLE `users` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  `role` enum('MANAGER','WAITER') NOT NULL DEFAULT 'WAITER',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

/*Data for the table `users` */

insert  into `users`(`id`,`username`,`password`,`role`) values (1,'manager','1','MANAGER'),(2,'sevak','1111','WAITER'),(3,'Levon','2222','WAITER');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
