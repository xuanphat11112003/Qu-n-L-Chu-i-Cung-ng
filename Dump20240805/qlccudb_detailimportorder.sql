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
-- Table structure for table `detailimportorder`
--

DROP TABLE IF EXISTS `detailimportorder`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `detailimportorder` (
  `id` int NOT NULL AUTO_INCREMENT,
  `quantity` int NOT NULL,
  `total_amount` decimal(10,0) DEFAULT NULL,
  `ImportOder_ID` int NOT NULL,
  `Material_ID` int NOT NULL,
  PRIMARY KEY (`id`),
  KEY `ImpID_idx` (`ImportOder_ID`),
  KEY `materialID_idx` (`Material_ID`),
  CONSTRAINT `ImpID` FOREIGN KEY (`ImportOder_ID`) REFERENCES `importorder` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `materialID` FOREIGN KEY (`Material_ID`) REFERENCES `material` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=28 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `detailimportorder`
--

LOCK TABLES `detailimportorder` WRITE;
/*!40000 ALTER TABLE `detailimportorder` DISABLE KEYS */;
INSERT INTO `detailimportorder` VALUES (16,12,1200,26,1),(17,4,400,27,1),(18,1,100,28,1),(19,12,1200,29,1),(20,12,600,30,2),(21,3,60,30,3),(22,5,250,31,2),(23,2,40,31,3),(24,12,1200,32,4),(25,3,300,32,1),(26,12,1200,33,4),(27,3,300,33,1);
/*!40000 ALTER TABLE `detailimportorder` ENABLE KEYS */;
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
