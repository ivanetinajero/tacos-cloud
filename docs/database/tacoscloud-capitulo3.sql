-- MySQL dump 10.13  Distrib 8.0.30, for Linux (x86_64)
--
-- Host: localhost    Database: tacoscloud
-- ------------------------------------------------------
-- Server version	8.0.30

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `Ingredientes`
--

DROP TABLE IF EXISTS `Ingredientes`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `Ingredientes` (
  `id` varchar(255) NOT NULL,
  `nombre` varchar(255) DEFAULT NULL,
  `tipo` enum('ENVOLTURA','PROTEINA','QUESO','SALSA','VEGETAL') DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Ingredientes`
--

LOCK TABLES `Ingredientes` WRITE;
/*!40000 ALTER TABLE `Ingredientes` DISABLE KEYS */;
INSERT INTO `Ingredientes` VALUES ('CARN','Carnitas','PROTEINA'),('CHED','Cheddar','QUESO'),('COTO','Corn Tortilla','ENVOLTURA'),('FLTO','Flour Tortilla','ENVOLTURA'),('GRBF','Ground Beef','PROTEINA'),('JACK','Monterrey Jack','QUESO'),('LETC','Lettuce','VEGETAL'),('SLSA','Salsa','SALSA'),('SRCR','Sour Cream','SALSA'),('TMTO','Diced Tomatoes','VEGETAL');
/*!40000 ALTER TABLE `Ingredientes` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `OrdenesTacos`
--

DROP TABLE IF EXISTS `OrdenesTacos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `OrdenesTacos` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `calleEntrega` varchar(255) DEFAULT NULL,
  `ciudadEntrega` varchar(255) DEFAULT NULL,
  `cpEntrega` varchar(255) DEFAULT NULL,
  `cvvTarjeta` varchar(255) DEFAULT NULL,
  `estadoEntrega` varchar(255) DEFAULT NULL,
  `expiracionTarjeta` varchar(255) DEFAULT NULL,
  `fechaRegistro` datetime(6) DEFAULT NULL,
  `nombreEntrega` varchar(255) DEFAULT NULL,
  `numeroTarjeta` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `OrdenesTacos`
--

LOCK TABLES `OrdenesTacos` WRITE;
/*!40000 ALTER TABLE `OrdenesTacos` DISABLE KEYS */;
INSERT INTO `OrdenesTacos` VALUES (1,'C. Mariano Matamoros #505','Calera','98500','562','Zacatecas','12/23','2023-05-31 11:36:33.758000','Ivan Eliseo Tinajero Díaz','5555555555554444');
/*!40000 ALTER TABLE `OrdenesTacos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `OrdenesTacos_Tacos`
--

DROP TABLE IF EXISTS `OrdenesTacos_Tacos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `OrdenesTacos_Tacos` (
  `idOrdenTaco` bigint NOT NULL,
  `idTaco` bigint NOT NULL,
  UNIQUE KEY `UK_ld7bpn9ocpoca273ti9x99flr` (`idTaco`),
  KEY `FKodu9oh82kn7i4a5hn7kcg55kd` (`idOrdenTaco`),
  CONSTRAINT `FKc9cxk71378dbv10899h0pgd49` FOREIGN KEY (`idTaco`) REFERENCES `Tacos` (`id`),
  CONSTRAINT `FKodu9oh82kn7i4a5hn7kcg55kd` FOREIGN KEY (`idOrdenTaco`) REFERENCES `OrdenesTacos` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `OrdenesTacos_Tacos`
--

LOCK TABLES `OrdenesTacos_Tacos` WRITE;
/*!40000 ALTER TABLE `OrdenesTacos_Tacos` DISABLE KEYS */;
INSERT INTO `OrdenesTacos_Tacos` VALUES (1,1),(1,2);
/*!40000 ALTER TABLE `OrdenesTacos_Tacos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Tacos`
--

DROP TABLE IF EXISTS `Tacos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `Tacos` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `fechaCreacion` datetime(6) DEFAULT NULL,
  `nombre` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Tacos`
--

LOCK TABLES `Tacos` WRITE;
/*!40000 ALTER TABLE `Tacos` DISABLE KEYS */;
INSERT INTO `Tacos` VALUES (1,'2023-05-31 11:36:58.971000','Taco de carnitas, cheddar y tomatoe'),(2,'2023-05-31 11:37:26.614000','quesadilla de carne molida, queso monterrey y lechuga');
/*!40000 ALTER TABLE `Tacos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `TacosIngredientes`
--

DROP TABLE IF EXISTS `TacosIngredientes`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `TacosIngredientes` (
  `idTaco` bigint NOT NULL,
  `idIngrediente` varchar(255) NOT NULL,
  KEY `FK7og8nm8cbjqf7sy29j3xt7v0e` (`idIngrediente`),
  KEY `FK8xmxw2y4hokuv0grrm7fth3g9` (`idTaco`),
  CONSTRAINT `FK7og8nm8cbjqf7sy29j3xt7v0e` FOREIGN KEY (`idIngrediente`) REFERENCES `Ingredientes` (`id`),
  CONSTRAINT `FK8xmxw2y4hokuv0grrm7fth3g9` FOREIGN KEY (`idTaco`) REFERENCES `Tacos` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `TacosIngredientes`
--

LOCK TABLES `TacosIngredientes` WRITE;
/*!40000 ALTER TABLE `TacosIngredientes` DISABLE KEYS */;
INSERT INTO `TacosIngredientes` VALUES (1,'COTO'),(1,'CARN'),(1,'CHED'),(1,'TMTO'),(2,'FLTO'),(2,'GRBF'),(2,'JACK'),(2,'LETC');
/*!40000 ALTER TABLE `TacosIngredientes` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-05-31 10:40:43
