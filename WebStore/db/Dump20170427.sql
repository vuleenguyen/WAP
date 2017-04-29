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
-- Table structure for table `orderhistory`
--

DROP TABLE IF EXISTS `orderhistory`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `orderhistory` (
  `ORDERID` int(11) NOT NULL AUTO_INCREMENT,
  `USERID` int(11) NOT NULL,
  `DATE_OF_ORDER` date NOT NULL,
  `CART_NUMBER` varchar(20) NOT NULL,
  `STATE` varchar(50) NOT NULL,
  `CITY` varchar(50) NOT NULL,
  `STREET` varchar(50) NOT NULL,
  `ZIPCODE` varchar(50) NOT NULL,
  `TOTAL_AMOUNT` int(11) NOT NULL,
  `PHONE` varchar(50) NOT NULL,
  `EMAIL` varchar(50) NOT NULL,
  PRIMARY KEY (`ORDERID`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `orderhistory`
--

LOCK TABLES `orderhistory` WRITE;
/*!40000 ALTER TABLE `orderhistory` DISABLE KEYS */;
INSERT INTO `orderhistory` VALUES (1,2,'2017-04-26','123-453-432','Iowa','FairField','4th 1000','52666',108,'0914101276','vuleenguyen.92@gmail.com'),(3,2,'2017-04-26','123455','TOA','FairField','4th 1000','52666',32,'123213','vuleenguyen@gmail.com'),(8,3,'2017-04-27','fdgfdgfdg','fdsfsdfsd','sdfsdfsd','dsfsdf','fsdfsd',24,'fsdfds','vuleenguyen@gmail.com'),(9,2,'2017-04-27','1234567','Iowa','FairField','qwee','5322',96,'2334566','anas@gmail.com');
/*!40000 ALTER TABLE `orderhistory` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `orderhistory_product`
--

DROP TABLE IF EXISTS `orderhistory_product`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `orderhistory_product` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `ORDERID` int(11) NOT NULL,
  `PRODUCTID` int(11) NOT NULL,
  PRIMARY KEY (`ID`),
  KEY `ORDERID` (`ORDERID`),
  KEY `PRODUCTID` (`PRODUCTID`),
  CONSTRAINT `orderhistory_product_ibfk_1` FOREIGN KEY (`ORDERID`) REFERENCES `orderhistory` (`ORDERID`),
  CONSTRAINT `orderhistory_product_ibfk_2` FOREIGN KEY (`PRODUCTID`) REFERENCES `product` (`PRODUCTID`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `orderhistory_product`
--

LOCK TABLES `orderhistory_product` WRITE;
/*!40000 ALTER TABLE `orderhistory_product` DISABLE KEYS */;
INSERT INTO `orderhistory_product` VALUES (1,1,16),(2,1,17),(3,1,18),(4,3,17),(5,8,21),(6,9,17),(7,9,19);
/*!40000 ALTER TABLE `orderhistory_product` ENABLE KEYS */;
UNLOCK TABLES;

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
  `PRODUCT_NAME` varchar(50) NOT NULL,
  PRIMARY KEY (`PRODUCTID`)
) ENGINE=InnoDB AUTO_INCREMENT=30 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `product`
--

LOCK TABLES `product` WRITE;
/*!40000 ALTER TABLE `product` DISABLE KEYS */;
INSERT INTO `product` VALUES (16,'Choose versatile smartphones for 12 every purpose','Choose versatile smartphones for every purpose','Iphone',12,'product1.png','product1_.png',0,'Elephone1 G5LS 5.5 inch Android'),(17,'Choose versatile smartphones for every purpose! Our friendly ','Choose versatile smartphones for every purpose! Our friendly ','Iphone',32,'product2.png','product2_.png',1,'BLU Studio 5.0 C HD Smartphone'),(18,'Choose versatile smartphones for every purpo','Choose versatile smartphones for every purpo','Iphone',64,'product3.png','product3_.png',1,'Alcatel One Fierce Prepaid Phone'),(19,'Choose versatile smartphones for every purpo','Choose versatile smartphones for every purpo','Iphone',64,'product4.png','product4_.png',1,'ASUS ZENFONE 6 A601CG'),(20,'Choose versatile smartphones for every purpo','Choose versatile smartphones for every purpo','LG',40,'product5.png','product5_.png',2,'Samsung Galaxy S4 SGH-M919'),(21,'Choose versatile smartphones for every purpo','Choose versatile smartphones for every purpo','Asus',24,'product6.png','product6_.png',1,'Samsung Galaxy S III');
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
  `GENDER` varchar(10) DEFAULT NULL,
  `STATE` varchar(50) DEFAULT NULL,
  `CITY` varchar(50) DEFAULT NULL,
  `STREET` varchar(50) DEFAULT NULL,
  `ZIPCODE` varchar(50) DEFAULT NULL,
  `BIRTHDATE` date NOT NULL,
  `EMAIL` varchar(50) NOT NULL,
  `ROLE` varchar(10) NOT NULL,
  PRIMARY KEY (`USERID`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (1,'vu_leenguyen','Vuhandsome123','Nguyen Hoan Vu Le 1','Male','Iowa','FairField','4th 1000 North','52775','0020-01-13','vuleenguyen.92@gmail.com','manager'),(2,'anas','Anas123','Anas',NULL,NULL,NULL,NULL,'0','0024-01-05','anas@gmail.com','guest'),(3,'Frehiwot','Frutye2002','Tadese',NULL,NULL,NULL,NULL,'0','0019-01-05','frutye@gmil.com','guest'),(5,'qnq','Vu1234','rtr',NULL,NULL,NULL,NULL,'0','0004-01-05','vuabc@gmail.com','guest');
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

-- Dump completed on 2017-04-27 11:09:26
