-- MySQL dump 10.13  Distrib 5.7.12, for Win64 (x86_64)
--
-- Host: localhost    Database: webstoredb
-- ------------------------------------------------------
-- Server version	5.7.17-log

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `product`
--

DROP TABLE IF EXISTS `product`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `product` (
  `PRODUCTID` int(11) NOT NULL AUTO_INCREMENT,
  `BRIEF_INFORMATION` varchar(100) DEFAULT NULL,
  `DETAIL_INFORMATION` varchar(300) DEFAULT NULL,
  `BRAND` varchar(50) DEFAULT NULL,
  `PRICE` double DEFAULT NULL,
  `FIRST_IMAGE` varchar(50) DEFAULT NULL,
  `SECOND_IMAGE` varchar(50) DEFAULT NULL,
  `COUNT` int(11) DEFAULT NULL,
  PRIMARY KEY (`PRODUCTID`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `product`
--

LOCK TABLES `product` WRITE;
/*!40000 ALTER TABLE `product` DISABLE KEYS */;
INSERT INTO `product` VALUES (10,'Choose versatile smartphones for every purpose','Choose versatile smartphones for every purpose','Iphone',689,'product1.png','product1_.png',1),(11,'Choose versatile smartphones for every purpose','Choose versatile smartphones for every purpose','Iphone',32,'product2.png','product2_.png',1),(12,'Choose versatile smartphones for every purpose','Choose versatile smartphones for every purpose','SamSung',64,'product3.png','product3_.png',1),(13,'Choose versatile smartphones for every purpose!','Choose versatile smartphones for every purpose!','Iphone',64,'product4.png','product4_.png',1),(14,'Choose versatile smartphones for every purpose!','Choose versatile smartphones for every purpose!','Asus',40,'product5.png','product5_.png',1),(15,'Choose versatile smartphones for every purpose!','Choose versatile smartphones for every purpose!','Iphone',24,'product6.png','product6_.png',2);
/*!40000 ALTER TABLE `product` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user` (
  `USERID` int(11) NOT NULL AUTO_INCREMENT,
  `USERNAME` varchar(50) NOT NULL,
  `PASSWORD` varchar(50) NOT NULL,
  `FULLNAME` varchar(50) NOT NULL,
  `GENDER` varchar(10) NOT NULL,
  `STATE` varchar(50) NOT NULL,
  `CITY` varchar(50) NOT NULL,
  `STREET` varchar(50) NOT NULL,
  `ZIPCODE` int(11) NOT NULL,
  `BIRTHDATE` date NOT NULL,
  `EMAIL` varchar(50) NOT NULL,
  `ROLE` varchar(10) NOT NULL,
  PRIMARY KEY (`USERID`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (1,'vu_leenguyen','Vuhandsome123','Nguyen Hoan Vu Le','Male','Iowa','FairField','4th 1000 North',52775,'1992-12-20','vuleenguyen.92@gmail.com','manager');
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping events for database 'webstoredb'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-04-25 12:36:36
