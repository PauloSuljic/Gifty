-- MySQL dump 10.13  Distrib 8.0.20, for macos10.15 (x86_64)
--
-- Host: 127.0.0.1    Database: giftyDB
-- ------------------------------------------------------
-- Server version	8.0.22

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
-- Table structure for table `friendships`
--

DROP TABLE IF EXISTS `friendships`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `friendships` (
  `idFriendship` int NOT NULL AUTO_INCREMENT,
  `requestSender` int NOT NULL,
  `requestReceiver` int NOT NULL,
  `statusSender` tinyint NOT NULL DEFAULT '0',
  `statusReceiver` tinyint NOT NULL DEFAULT '0',
  PRIMARY KEY (`idFriendship`)
) ENGINE=InnoDB AUTO_INCREMENT=40 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `friendships`
--

LOCK TABLES `friendships` WRITE;
/*!40000 ALTER TABLE `friendships` DISABLE KEYS */;
INSERT INTO `friendships` VALUES (1,1,2,1,1),(3,1,3,1,1),(4,5,4,1,1),(5,5,2,1,1),(6,1,4,1,1),(7,1,5,1,1),(14,12,1,1,1),(17,5,12,1,1),(21,3,2,1,1),(26,1,13,1,1),(27,18,1,1,1),(28,19,1,1,1),(29,20,1,1,1),(34,21,1,1,1),(36,2,4,1,0),(37,3,4,1,0),(39,12,3,1,0);
/*!40000 ALTER TABLE `friendships` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `users` (
  `idUser` int NOT NULL AUTO_INCREMENT,
  `firstName` varchar(45) NOT NULL,
  `lastName` varchar(45) NOT NULL,
  `email` varchar(45) NOT NULL,
  `username` varchar(45) NOT NULL,
  `password` varchar(45) NOT NULL,
  `dateOfBirth` date DEFAULT NULL,
  PRIMARY KEY (`idUser`)
) ENGINE=InnoDB AUTO_INCREMENT=25 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users`
--

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` VALUES (1,'Paulo','Šuljić','paulo.suljic@gmail.com','paulo','202cb962ac59075b964b07152d234b70','2021-04-20'),(2,'Damir','Dizdarevic','damir.dizdarevic@gmail.com','damir','202cb962ac59075b964b07152d234b70','1998-02-15'),(3,'Leon','Samardzic','leon.samardzic@gmail.com','leon','202cb962ac59075b964b07152d234b70','1998-03-16'),(4,'Petar','Kucjenic','petar.kucjenic@gmail.com','petar','202cb962ac59075b964b07152d234b70','1998-04-17'),(5,'Ivan','Buterin','ivan.buterin@gmail.com','ivan','202cb962ac59075b964b07152d234b70','1998-05-18'),(12,'Leo','Šuljić','leo.suljic@gmail.com','leosuljic','202cb962ac59075b964b07152d234b70','2001-03-09');
/*!40000 ALTER TABLE `users` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `wishlist`
--

DROP TABLE IF EXISTS `wishlist`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `wishlist` (
  `idWishlistItem` int NOT NULL AUTO_INCREMENT,
  `itemName` varchar(45) NOT NULL,
  `itemLink` varchar(200) NOT NULL,
  `itemPrice` int NOT NULL,
  `itemCurrency` varchar(45) NOT NULL,
  `idUser` int NOT NULL,
  PRIMARY KEY (`idWishlistItem`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `wishlist`
--

LOCK TABLES `wishlist` WRITE;
/*!40000 ALTER TABLE `wishlist` DISABLE KEYS */;
INSERT INTO `wishlist` VALUES (2,'tipkovnica','https://www.links.hr/hr/tipkovnica-hyperx-alloy-core-gaming-crna-us-layout-hx-kb5me2-us-usb-101200425',450,'$',3),(5,'Slusalice Pioneer','https://www.audiopro.hr/proizvod/pioneer-hdj-cue1-dj-slusalice?idPro=55488',800,'kn',1),(6,'Jordan Tenisice','https://www.grosbasket.com/hr/air-jordan-dub-zero-gym-red',1000,'kn',1),(7,'Mouse','https://www.links.hr/hr/mis-logitech-gaming-g604-lightspeed-opticki-bezicni-16000dpi-crni-usb-101500373',600,'kn',5),(8,'Dron','https://www.links.hr/hr/dron-dji-air-2s-4k-kamera-3-axis-gimbal-vrijeme-leta-do-31min-upravljanje-daljinskim-upravljacem-420100024',7500,'kn',2),(16,'Rolex','https://www.ebay.com/itm/232563583440',7000,'$',20);
/*!40000 ALTER TABLE `wishlist` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-06-02 23:09:15
