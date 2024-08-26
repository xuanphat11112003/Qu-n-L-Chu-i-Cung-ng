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
-- Table structure for table `product`
--

DROP TABLE IF EXISTS `product`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `product` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `price` decimal(10,2) NOT NULL,
  `detail` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=23 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `product`
--

LOCK TABLES `product` WRITE;
/*!40000 ALTER TABLE `product` DISABLE KEYS */;
INSERT INTO `product` VALUES (2,'Cafe Arabica',30000.00,'Cafe nguyên chất'),(3,'Cafe Robusta',25000.00,'Cafe mạnh mẽ'),(4,'Cafe Espresso',35000.00,'Cafe espresso nguyên chất'),(5,'Cafe Latte',40000.00,'Cafe latte với sữa'),(6,'Cafe Cappuccino',45000.00,'Cafe cappuccino với bọt sữa'),(7,'Cafe Mocha',50000.00,'Cafe mocha với sô-cô-la'),(8,'Cafe Americano',30000.00,'Cafe americano pha loãng'),(9,'Trà Sữa Truyền Thống',35000.00,'Trà sữa truyền thống với hương vị đặc trưng'),(10,'Trà Sữa Matcha',38000.00,'Trà sữa với bột matcha xanh mát'),(11,'Trà Sữa Hồng Trà',36000.00,'Trà sữa với hồng trà thơm ngon'),(12,'Trà Sữa Trân Châu Đen',40000.00,'Trà sữa với trân châu đen mềm mại'),(13,'Trà Sữa Caramel',42000.00,'Trà sữa với hương caramel ngọt ngào'),(14,'Trà Sữa Đá Xay Truyền Thống',36000.00,'Trà sữa đá xay với hương vị truyền thống'),(15,'Trà Sữa Đá Xay Matcha',39000.00,'Trà sữa đá xay với bột matcha'),(16,'Trà Sữa Đá Xay Hồng Trà',37000.00,'Trà sữa đá xay với hồng trà'),(17,'Trà Sữa Đá Xay Trân Châu Đen',42000.00,'Trà sữa đá xay với trân châu đen'),(18,'Trà Sữa Đá Xay Caramel',44000.00,'Trà sữa đá xay với caramel'),(22,'Sữa tươi trân châu đường đen',200000.00,'sữa tươi với đường đen');
/*!40000 ALTER TABLE `product` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-08-27  1:49:19
