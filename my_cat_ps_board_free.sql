-- MySQL dump 10.13  Distrib 8.0.32, for Win64 (x86_64)
--
-- Host: localhost    Database: my_cat
-- ------------------------------------------------------
-- Server version	8.0.32

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
-- Table structure for table `ps_board_free`
--

DROP TABLE IF EXISTS `ps_board_free`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `ps_board_free` (
  `B_NO` int NOT NULL AUTO_INCREMENT,
  `B_TITLE` char(100) NOT NULL DEFAULT '',
  `B_ID` char(50) NOT NULL,
  `B_DATETIME` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `B_HIT` int NOT NULL DEFAULT '0',
  `B_TEXT` text NOT NULL,
  `B_REPLY_COUNT` int NOT NULL DEFAULT '0',
  `B_REPLY_ORI` int NOT NULL DEFAULT '-1',
  PRIMARY KEY (`B_NO`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ps_board_free`
--

LOCK TABLES `ps_board_free` WRITE;
/*!40000 ALTER TABLE `ps_board_free` DISABLE KEYS */;
INSERT INTO `ps_board_free` VALUES (1,'야옹','cat','2024-09-27 12:03:26',0,'aaa',0,-1),(3,'수정','수저','2024-09-27 12:04:10',0,'수정글',0,-1),(4,'ㅁㅇㄻ','ㅁㅇㄴㄹ','2024-09-27 12:03:54',0,'ㅁㅇㄻ',0,-1),(5,'글','글','2024-09-27 16:51:36',0,'글',0,-1);
/*!40000 ALTER TABLE `ps_board_free` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-09-27 17:49:03
