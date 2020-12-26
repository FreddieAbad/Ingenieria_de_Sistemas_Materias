-- MySQL dump 10.13  Distrib 5.7.12, for Win64 (x86_64)
--
-- Host: localhost    Database: cubo
-- ------------------------------------------------------
-- Server version	5.7.15-log

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
-- Table structure for table `estacion`
--

DROP TABLE IF EXISTS `estacion`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `estacion` (
  `idestacion` int(11) NOT NULL AUTO_INCREMENT,
  `nombreEstacion` varchar(45) NOT NULL,
  `estado` varchar(45) NOT NULL,
  `pais` varchar(45) NOT NULL,
  PRIMARY KEY (`idestacion`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `estacion`
--

LOCK TABLES `estacion` WRITE;
/*!40000 ALTER TABLE `estacion` DISABLE KEYS */;
INSERT INTO `estacion` VALUES (1,'Mraz and Sons','Texas','United States'),(2,'Tremblay-Farrell','Texas','United States'),(3,'Smith, Hackett and Raynor','Texas','United States'),(4,'Kiehn and Sons','California','United States'),(5,'Wiza and Sons','Texas','United States'),(6,'Schimmel, Jakubowski and Gusikowski','California','United States'),(7,'Thompson, Konopelski and West','Texas','United States'),(8,'O\"Hara-Monahan','California','United States'),(9,'Greenfelder, Kreiger and Ankunding','Florida','United States'),(10,'Kreiger-Kirlin','Florida','United States'),(11,'Jenkins and Sons','California','United States'),(12,'Schuster LLC','Texas','United States'),(13,'Bechtelar Inc','Texas','United States'),(14,'Rempel-Hintz','Florida','United States'),(15,'Hagenes LLC','Florida','United States'),(16,'Bradtke, Ratke and Cummerata','California','United States'),(17,'Hintz-Cormier','Florida','United States'),(18,'Jacobi, Bahringer and Gulgowski','California','United States'),(19,'Waters LLC','California','United States'),(20,'Swift, Mosciski and Brekke','California','United States');
/*!40000 ALTER TABLE `estacion` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `medicion`
--

DROP TABLE IF EXISTS `medicion`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `medicion` (
  `idmedicion` int(11) NOT NULL AUTO_INCREMENT,
  `temperaturaCelsius` int(11) NOT NULL,
  `radiacionUV` int(11) NOT NULL,
  `humedadRelativa` int(11) NOT NULL,
  `viento` int(11) NOT NULL,
  `idestacion` int(11) NOT NULL,
  `idresponsable` int(11) NOT NULL,
  `idtipoestacion` int(11) NOT NULL,
  `idtiempo` int(11) NOT NULL,
  PRIMARY KEY (`idmedicion`),
  KEY `fk_medicion_estacion_idx` (`idestacion`),
  KEY `fk_medicion_responsable1_idx` (`idresponsable`),
  KEY `fk_medicion_tipoEstacion1_idx` (`idtipoestacion`),
  KEY `fk_medicion_tiempo1_idx` (`idtiempo`),
  CONSTRAINT `fk_medicion_estacion` FOREIGN KEY (`idestacion`) REFERENCES `estacion` (`idestacion`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_medicion_responsable1` FOREIGN KEY (`idresponsable`) REFERENCES `responsable` (`idresponsable`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_medicion_tiempo1` FOREIGN KEY (`idtiempo`) REFERENCES `tiempo` (`idtiempo`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_medicion_tipoEstacion1` FOREIGN KEY (`idtipoestacion`) REFERENCES `tipoestacion` (`idtipoEstacion`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=101 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `medicion`
--

LOCK TABLES `medicion` WRITE;
/*!40000 ALTER TABLE `medicion` DISABLE KEYS */;
INSERT INTO `medicion` VALUES (1,30,7,79,4,15,20,1,1),(2,22,7,83,10,20,4,1,2),(3,32,12,81,1,20,9,2,3),(4,22,15,62,8,14,16,1,4),(5,29,18,62,7,7,9,1,5),(6,20,6,68,1,11,3,4,6),(7,27,10,72,8,3,14,4,7),(8,35,16,84,9,15,5,2,8),(9,34,13,80,8,6,14,3,9),(10,29,17,60,10,12,12,3,10),(11,30,9,64,3,5,13,4,11),(12,35,7,64,10,17,4,3,12),(13,26,18,85,9,16,4,2,13),(14,25,13,77,8,7,6,2,14),(15,32,18,68,7,19,5,1,15),(16,28,6,70,2,5,2,3,16),(17,34,17,76,8,1,8,2,17),(18,29,18,74,5,14,2,1,18),(19,32,6,69,4,9,14,1,19),(20,28,15,77,4,18,12,4,20),(21,29,16,81,8,2,11,4,21),(22,32,7,72,5,7,9,3,22),(23,22,6,70,6,3,16,2,23),(24,30,17,74,9,20,7,4,24),(25,26,6,65,1,15,17,1,25),(26,20,10,81,6,20,3,3,26),(27,33,15,72,9,1,20,1,27),(28,30,10,81,2,16,1,4,28),(29,28,16,81,6,18,12,3,29),(30,24,12,83,1,6,11,4,30),(31,25,13,72,7,8,5,1,31),(32,21,20,78,3,17,11,3,32),(33,22,5,80,1,14,17,3,33),(34,26,10,79,5,13,18,4,34),(35,27,19,77,7,4,20,1,35),(36,35,5,82,7,6,19,2,36),(37,25,17,83,3,1,16,4,37),(38,26,17,61,2,5,19,4,38),(39,30,9,82,3,9,15,1,39),(40,34,13,60,1,18,20,4,40),(41,27,13,76,1,20,17,2,41),(42,29,18,81,6,1,10,2,42),(43,27,20,62,1,2,4,3,43),(44,28,7,73,6,9,17,3,44),(45,28,20,65,4,16,13,4,45),(46,25,14,69,1,13,4,3,46),(47,27,9,70,6,14,8,1,47),(48,24,16,76,2,14,4,4,48),(49,27,12,70,6,7,13,3,49),(50,27,10,69,3,10,1,2,50),(51,33,9,64,8,4,12,4,51),(52,27,10,72,7,3,8,3,52),(53,24,17,84,7,9,7,1,53),(54,31,14,78,1,1,16,2,54),(55,31,11,75,8,10,14,2,55),(56,21,12,68,3,2,1,1,56),(57,25,8,64,4,12,9,1,57),(58,35,19,65,8,5,13,3,58),(59,21,11,80,9,13,20,1,59),(60,29,10,61,2,14,2,1,60),(61,29,8,83,1,11,5,2,61),(62,30,19,82,9,7,7,4,62),(63,21,17,80,8,5,7,2,63),(64,29,5,79,1,3,19,1,64),(65,30,19,72,9,7,1,3,65),(66,31,15,84,9,15,15,2,66),(67,22,14,69,4,12,4,2,67),(68,22,19,76,2,20,13,2,68),(69,22,7,67,10,8,2,1,69),(70,26,17,60,9,6,2,3,70),(71,26,15,65,3,15,12,3,71),(72,28,10,75,4,7,20,4,72),(73,34,8,73,8,13,2,2,73),(74,21,6,78,5,11,9,1,74),(75,25,8,79,4,5,12,1,75),(76,34,16,75,1,7,20,1,76),(77,31,10,61,5,7,9,1,77),(78,33,5,69,7,19,13,3,78),(79,25,8,73,9,11,6,2,79),(80,32,5,71,8,15,14,3,80),(81,27,7,75,3,10,16,3,81),(82,30,17,60,1,9,10,3,82),(83,27,19,70,5,11,9,1,83),(84,30,16,73,2,12,2,4,84),(85,25,12,65,2,4,14,4,85),(86,21,6,84,10,14,16,3,86),(87,34,10,71,9,17,16,4,87),(88,22,8,68,8,8,18,4,88),(89,26,10,60,8,13,7,1,89),(90,33,11,79,6,16,9,4,90),(91,34,16,65,3,18,17,1,91),(92,20,9,73,4,13,12,2,92),(93,34,9,76,2,16,16,4,93),(94,21,16,66,2,14,8,3,94),(95,30,11,72,6,19,14,1,95),(96,21,8,77,5,16,1,4,96),(97,20,9,83,2,15,10,2,97),(98,22,17,60,7,13,3,4,98),(99,33,18,64,8,13,20,4,99),(100,20,7,65,2,14,20,1,100);
/*!40000 ALTER TABLE `medicion` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `responsable`
--

DROP TABLE IF EXISTS `responsable`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `responsable` (
  `idresponsable` int(11) NOT NULL AUTO_INCREMENT,
  `nombreResponsable` varchar(45) NOT NULL,
  PRIMARY KEY (`idresponsable`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `responsable`
--

LOCK TABLES `responsable` WRITE;
/*!40000 ALTER TABLE `responsable` DISABLE KEYS */;
INSERT INTO `responsable` VALUES (1,'Lise Franz'),(2,'Miguel Whimper'),(3,'Katina Blare'),(4,'Janot Dicks'),(5,'Ingra Berriball'),(6,'Katey Blune'),(7,'Corrianne Pottle'),(8,'Walt Wawer'),(9,'Robenia Delouch'),(10,'Yard Rist'),(11,'Agnella MacComiskey'),(12,'Phillida Han'),(13,'Randa Freschini'),(14,'Thornton Chartres'),(15,'Thomasina Sutty'),(16,'Hailee Ewing'),(17,'Tuesday Willetts'),(18,'Alys Mackriell'),(19,'Dacey Letchford'),(20,'Nicole Sallis');
/*!40000 ALTER TABLE `responsable` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tiempo`
--

DROP TABLE IF EXISTS `tiempo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tiempo` (
  `idtiempo` int(11) NOT NULL AUTO_INCREMENT,
  `mes` varchar(45) NOT NULL,
  `anio` varchar(45) NOT NULL,
  PRIMARY KEY (`idtiempo`)
) ENGINE=InnoDB AUTO_INCREMENT=101 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tiempo`
--

LOCK TABLES `tiempo` WRITE;
/*!40000 ALTER TABLE `tiempo` DISABLE KEYS */;
INSERT INTO `tiempo` VALUES (1,'Apr','2019'),(2,'Sep','2019'),(3,'Sep','2019'),(4,'Jan','2020'),(5,'May','2019'),(6,'May','2019'),(7,'Jul','2019'),(8,'Sep','2019'),(9,'Mar','2020'),(10,'May','2019'),(11,'Mar','2020'),(12,'Dec','2019'),(13,'Oct','2019'),(14,'Jun','2019'),(15,'Aug','2019'),(16,'Aug','2019'),(17,'Sep','2019'),(18,'Dec','2019'),(19,'Oct','2019'),(20,'Aug','2019'),(21,'Nov','2019'),(22,'Jun','2019'),(23,'Apr','2020'),(24,'Jul','2019'),(25,'Feb','2020'),(26,'Jan','2020'),(27,'Jun','2019'),(28,'Oct','2019'),(29,'Feb','2020'),(30,'Apr','2019'),(31,'Dec','2019'),(32,'Sep','2019'),(33,'Jan','2020'),(34,'Sep','2019'),(35,'Feb','2020'),(36,'May','2019'),(37,'Dec','2019'),(38,'Jul','2019'),(39,'Apr','2020'),(40,'Jan','2020'),(41,'Sep','2019'),(42,'Jun','2019'),(43,'Jul','2019'),(44,'May','2019'),(45,'Jan','2020'),(46,'Apr','2020'),(47,'Jan','2020'),(48,'Aug','2019'),(49,'Aug','2019'),(50,'Jun','2019'),(51,'Jan','2020'),(52,'Nov','2019'),(53,'Oct','2019'),(54,'Jul','2019'),(55,'May','2019'),(56,'Nov','2019'),(57,'Jul','2019'),(58,'Nov','2019'),(59,'Dec','2019'),(60,'Jul','2019'),(61,'Jul','2019'),(62,'Aug','2019'),(63,'Aug','2019'),(64,'Aug','2019'),(65,'Aug','2019'),(66,'Jan','2020'),(67,'Sep','2019'),(68,'Jun','2019'),(69,'Feb','2020'),(70,'Feb','2020'),(71,'Aug','2019'),(72,'Jul','2019'),(73,'Feb','2020'),(74,'Feb','2020'),(75,'Aug','2019'),(76,'Jan','2020'),(77,'Jul','2019'),(78,'Dec','2019'),(79,'Dec','2019'),(80,'May','2019'),(81,'Apr','2020'),(82,'Apr','2019'),(83,'Aug','2019'),(84,'Aug','2019'),(85,'May','2019'),(86,'Jan','2020'),(87,'Mar','2020'),(88,'Oct','2019'),(89,'Aug','2019'),(90,'Aug','2019'),(91,'Nov','2019'),(92,'Nov','2019'),(93,'Feb','2020'),(94,'Oct','2019'),(95,'Nov','2019'),(96,'Aug','2019'),(97,'Jan','2020'),(98,'Jun','2019'),(99,'Mar','2020'),(100,'Sep','2019');
/*!40000 ALTER TABLE `tiempo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tipoestacion`
--

DROP TABLE IF EXISTS `tipoestacion`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tipoestacion` (
  `idtipoEstacion` int(11) NOT NULL AUTO_INCREMENT,
  `tipoEstacion` varchar(45) NOT NULL,
  PRIMARY KEY (`idtipoEstacion`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tipoestacion`
--

LOCK TABLES `tipoestacion` WRITE;
/*!40000 ALTER TABLE `tipoestacion` DISABLE KEYS */;
INSERT INTO `tipoestacion` VALUES (1,'Digital'),(2,'Analógico'),(3,'Profesional'),(4,'Portatil');
/*!40000 ALTER TABLE `tipoestacion` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-04-23 13:56:33
