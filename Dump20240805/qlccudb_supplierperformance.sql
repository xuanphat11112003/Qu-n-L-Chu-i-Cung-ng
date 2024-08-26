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
-- Table structure for table `supplierperformance`
--

DROP TABLE IF EXISTS `supplierperformance`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `supplierperformance` (
  `id` int NOT NULL AUTO_INCREMENT,
  `supplier_id` int NOT NULL,
  `evaluation_date` date NOT NULL,
  `delivery_rating` int NOT NULL,
  `quality_rating` int NOT NULL,
  `price_rating` int NOT NULL,
  `comment` text,
  `order_id` int NOT NULL,
  PRIMARY KEY (`id`),
  KEY `supplierperformance_ibfk_1_idx` (`supplier_id`),
  KEY `order_id_idx` (`order_id`),
  CONSTRAINT `order_id` FOREIGN KEY (`order_id`) REFERENCES `importorder` (`id`),
  CONSTRAINT `supplierperformance_ibfk_1` FOREIGN KEY (`supplier_id`) REFERENCES `supplier` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `supplierperformance`
--

LOCK TABLES `supplierperformance` WRITE;
/*!40000 ALTER TABLE `supplierperformance` DISABLE KEYS */;
INSERT INTO `supplierperformance` VALUES (1,2,'2024-08-25',40,30,50,'Good supplier with timely delivery and competitive prices.',27),(2,2,'2024-09-25',40,30,50,'Good supplier with timely delivery and competitive prices.',27),(3,3,'2024-07-25',40,30,50,'Good supplier with timely delivery and competitive prices.',27),(4,3,'2024-09-25',40,30,50,'Good supplier with timely delivery and competitive prices.',27),(5,5,'2024-05-25',40,30,50,'Good supplier with timely delivery and competitive prices.',27),(6,5,'2024-07-25',62,55,43,'tương đối ổn',27),(7,6,'2024-09-25',59,43,59,'tương đối ổn',27),(8,6,'2024-10-25',54,43,53,'tương đối ổn',27),(9,7,'2024-11-25',54,43,53,'tương đối ổn',27),(10,7,'2024-09-25',54,45,63,'tương đối ổn',27),(11,8,'2024-11-25',59,45,57,'tốt',27),(12,8,'2024-12-25',61,58,58,'tốt',26),(13,2,'2024-11-24',40,40,30,'tệ',33);
/*!40000 ALTER TABLE `supplierperformance` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-08-27  1:49:17
