-- MySQL dump 10.13  Distrib 8.0.36, for Win64 (x86_64)
--
-- Host: localhost    Database: qlccudb
-- ------------------------------------------------------
-- Server version	8.0.36

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `importorder`
--

DROP TABLE IF EXISTS `importorder`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `importorder` (
  `id` int NOT NULL AUTO_INCREMENT,
  `expect_date` date NOT NULL,
  `delivery_date` date DEFAULT NULL,
  `total_price` decimal(10,0) DEFAULT NULL,
  `active` tinyint(1) NOT NULL DEFAULT '0',
  `Payment` enum('thanh toán ngay lập tức','thanh toán sau 1 ngày nhận hóa đơn','thanh toán sau khi nhận hàng') NOT NULL DEFAULT 'thanh toán ngay lập tức',
  `active_evaluate` tinyint(1) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=34 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `importorder`
--

LOCK TABLES `importorder` WRITE;
/*!40000 ALTER TABLE `importorder` DISABLE KEYS */;
INSERT INTO `importorder` VALUES (26,'2024-08-18','2024-08-17',1200,1,'thanh toán sau 1 ngày nhận hóa đơn',1),(27,'0001-12-02','0001-12-02',400,1,'thanh toán sau khi nhận hàng',0),(28,'2024-08-17','2024-08-18',100,1,'thanh toán sau 1 ngày nhận hóa đơn',0),(29,'2024-08-18','2024-08-14',1200,1,'thanh toán sau 1 ngày nhận hóa đơn',0),(30,'2024-08-20','2024-08-18',660,1,'thanh toán sau 1 ngày nhận hóa đơn',0),(31,'2024-08-21','2024-08-19',290,1,'thanh toán ngay lập tức',0),(32,'2024-08-24','2024-08-21',1500,0,'thanh toán sau 1 ngày nhận hóa đơn',0),(33,'2024-08-24','2024-08-21',1500,0,'thanh toán sau 1 ngày nhận hóa đơn',0);
/*!40000 ALTER TABLE `importorder` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-08-27  1:49:18
