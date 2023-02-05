-- MySQL dump 10.13  Distrib 8.0.30, for Win64 (x86_64)
--
-- Host: localhost    Database: inventario_basico_1
-- ------------------------------------------------------
-- Server version	8.0.30

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
-- Table structure for table `t_categoria`
--

DROP TABLE IF EXISTS `t_categoria`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `t_categoria` (
  `idCategoria` int NOT NULL AUTO_INCREMENT,
  `nombre` varchar(80) NOT NULL,
  `descripcion` varchar(80) DEFAULT NULL,
  PRIMARY KEY (`idCategoria`)
) ENGINE=InnoDB AUTO_INCREMENT=82 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_categoria`
--

LOCK TABLES `t_categoria` WRITE;
/*!40000 ALTER TABLE `t_categoria` DISABLE KEYS */;
INSERT INTO `t_categoria` VALUES (1,'Mica','Para hombre y mujer.'),(38,'zarate','solo azul 2'),(39,'Acuario','.'),(40,'acr','...'),(41,'tauro',''),(42,'prueba 1',''),(43,'prueba 2',''),(44,'prueba 3',''),(45,'prueba 4',''),(46,'prueba 5',''),(47,'prueba 6',''),(48,'prueba 7',''),(49,'prueba 8',''),(50,'prueba 9',''),(55,'prueba 14',''),(57,'prueba 16',''),(58,'prueba 17',''),(59,'prueba 18',''),(60,'prueba 19',''),(61,'prueba 20',''),(62,'prueba 21',''),(63,'a 13',''),(64,'celular',''),(65,'celular 2',''),(67,'new category',''),(68,'yh',''),(69,'a2',''),(71,'wewe',''),(72,'re',''),(73,'45',''),(74,'gtg',''),(75,'aqa',''),(76,'op',''),(77,'ki',''),(78,'opio',''),(79,'opop',''),(80,'AXX',''),(81,'la lola','abuelit');
/*!40000 ALTER TABLE `t_categoria` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_producto`
--

DROP TABLE IF EXISTS `t_producto`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `t_producto` (
  `idProducto` int NOT NULL AUTO_INCREMENT,
  `FkcategoriaId` int NOT NULL,
  `nombre` varchar(80) NOT NULL,
  `descripcion` varchar(80) DEFAULT NULL,
  `precio` float NOT NULL,
  `stock` int NOT NULL,
  `ruta_image` varchar(180) DEFAULT NULL,
  PRIMARY KEY (`idProducto`),
  KEY `FkcategoriaId` (`FkcategoriaId`),
  CONSTRAINT `t_producto_ibfk_1` FOREIGN KEY (`FkcategoriaId`) REFERENCES `t_categoria` (`idCategoria`)
) ENGINE=InnoDB AUTO_INCREMENT=39 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_producto`
--

LOCK TABLES `t_producto` WRITE;
/*!40000 ALTER TABLE `t_producto` DISABLE KEYS */;
INSERT INTO `t_producto` VALUES (1,81,'Mica Completa','Mica Completa Generica',28,4,'cd:/base/image.png'),(10,1,'Telefono iphone','Prueba descripcion',200.56,100,'cd:/base/image.png'),(11,1,'Telefono samsung','Prueba descripcion angeles',800,60,''),(12,1,'Telefono Motorola','Prueba descripcion',1060,120,'cd:/base/image.png'),(13,1,'carcasa brillantina mujer','Prueba descripcion',60,5000,'cd:/base/image.png'),(14,1,'carcasa rudo hombre','Prueba descripcion',1500,178,'cd:/base/image.png'),(15,1,'Cargador romax','Prueba descripcion',789,56,'cd:/base/image.png'),(16,1,'Cargador UltraX','Carga rapida',300,21,'cd:/base/image.png'),(17,1,'Cell Phone Goku Ultra','',160,10,'cd:/base/image.png'),(19,1,'Tablet LG Ultima gama','2.57',16.5,10,'cd:/base/image.png'),(20,1,'Tablet LG Ultima gama 2','gama 2 act',26.8,80,''),(21,40,'Cable brillante Azul','brilla en la oscuridad',15,10,''),(24,1,'Mica A13 Super Blue V2.4','',28,5,''),(25,1,'cargador Pro master','',18,6,''),(27,41,'mica dinosaurio','',45,9,''),(34,63,'Prueba 63','',2,2,''),(35,67,'juniorcito pro','',1,12,''),(36,63,'cargador romaz','',1,2,''),(37,73,'asd','',1,0,''),(38,63,'treinta y dos coma dos','',32.02,1,'');
/*!40000 ALTER TABLE `t_producto` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_usuario`
--

DROP TABLE IF EXISTS `t_usuario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `t_usuario` (
  `idUsuario` int NOT NULL AUTO_INCREMENT,
  `nombre` varchar(50) NOT NULL,
  `apellido` varchar(50) NOT NULL,
  `usuario` varchar(50) NOT NULL,
  `perfil` int NOT NULL,
  `contrasena` varchar(120) NOT NULL,
  PRIMARY KEY (`idUsuario`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_usuario`
--

LOCK TABLES `t_usuario` WRITE;
/*!40000 ALTER TABLE `t_usuario` DISABLE KEYS */;
INSERT INTO `t_usuario` VALUES (1,'Jose','Cerron Vicente','Junior',1,'$2a$10$2XelJj6QYQIPwoz3qgF/3.EutpZGARqyhLiVo9SJM01VKAagMydpW'),(2,'Angeles','Quispe Casas','Angeles',1,'$2a$10$cKF2ZFqiiQgzPUwJulASoONsJ86mmHVyKzr649Xkw5EdZDjeJowUS'),(4,'Juan','Quispe Casas','Angeles3',2,'$2a$10$lFmZPKF1weHhHTe0zAxME.fTUG4pbjiaI7reRSLz7ZKiOgvD1AabO'),(9,'Josimar','Quispe Casas','Josi',2,'$2a$10$/eIDhqH1WaCX.5TPG3g/weePAmmXtIPb7za.zEUzSpt.t/ohcpdee'),(10,'Javi 2','Quispe Casas','Josi3',2,'$2a$10$3kLR2QQ0K/SakwePsqYc2e9yT9JxMJaBINy0pC4p2Wy4jNSNHlGUW'),(11,'Miguel Angel','Quispe Casas','miguel',2,'$2a$10$CBlaKJLjamZSJseM9dAi2eNwYaZUTRxffcNwxtmlcLw/MBckcdG3e'),(12,'Victor huguito','Campos Vivar','VictoH',2,'$2a$10$3J/G.KSzb.ub0g5HOmvKbOCHBcW10Hs/Tj4Oc74wDAzc/C95tdW.C'),(14,'admin','admin','admin',1,'$2a$10$atEchm/.OJkMmTcR9kxq.uo9OIa/YIQj9BK273fqsa3Yy1hKBVFq6'),(19,'bsic','bas','asd',2,'$2a$10$w6wNllafsCvg8txesh1ecOdO52uUmhODU.1GSsstyj.7xATzwmt4K'),(20,'wer','wer','wer',2,'$2a$10$IpxGgzv2t84/DhDqYSAKxet1DCICvwUzkheAu3V92LjmOGBwUtI..');
/*!40000 ALTER TABLE `t_usuario` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_venta_detalle`
--

DROP TABLE IF EXISTS `t_venta_detalle`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `t_venta_detalle` (
  `idVentaDetalle` int NOT NULL AUTO_INCREMENT,
  `FkidVenta` int NOT NULL,
  `FkidProducto` int NOT NULL,
  `cantidad` int NOT NULL,
  `total` float NOT NULL,
  PRIMARY KEY (`idVentaDetalle`),
  KEY `FkidVenta` (`FkidVenta`),
  KEY `FkidProducto` (`FkidProducto`),
  CONSTRAINT `t_venta_detalle_ibfk_1` FOREIGN KEY (`FkidVenta`) REFERENCES `t_ventas` (`idVentas`),
  CONSTRAINT `t_venta_detalle_ibfk_2` FOREIGN KEY (`FkidProducto`) REFERENCES `t_producto` (`idProducto`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_venta_detalle`
--

LOCK TABLES `t_venta_detalle` WRITE;
/*!40000 ALTER TABLE `t_venta_detalle` DISABLE KEYS */;
/*!40000 ALTER TABLE `t_venta_detalle` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_ventas`
--

DROP TABLE IF EXISTS `t_ventas`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `t_ventas` (
  `idVentas` int NOT NULL AUTO_INCREMENT,
  `FkidUsuario` int NOT NULL,
  `fecha_venta` varchar(16) NOT NULL,
  `descuento` float DEFAULT NULL,
  `total` float NOT NULL,
  PRIMARY KEY (`idVentas`),
  KEY `FkidUsuario` (`FkidUsuario`),
  CONSTRAINT `t_ventas_ibfk_1` FOREIGN KEY (`FkidUsuario`) REFERENCES `t_usuario` (`idUsuario`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_ventas`
--

LOCK TABLES `t_ventas` WRITE;
/*!40000 ALTER TABLE `t_ventas` DISABLE KEYS */;
/*!40000 ALTER TABLE `t_ventas` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping routines for database 'inventario_basico_1'
--
/*!50003 DROP PROCEDURE IF EXISTS `sp_categoria_actualizar` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_categoria_actualizar`(
in idCategoria int,
in nombre varchar(80),
in descripcion varchar(80)
)
begin

	update t_categoria cat
	set cat.nombre = nombre, cat.descripcion = descripcion
    where cat.idCategoria = idCategoria;

end ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `sp_categoria_crear` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_categoria_crear`(
in nombre varchar(80),
in descripcion varchar(80)
)
begin

	insert into t_categoria(nombre, descripcion)
	values(nombre, descripcion); 
    
end ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `sp_categoria_eliminar` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_categoria_eliminar`(
in idCategoria int
)
begin
	
	delete from t_categoria cat where cat.idCategoria = idCategoria;
	
end ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `sp_categoria_listar` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_categoria_listar`()
begin
	select * from t_categoria ORDER BY nombre ASC; 
end ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `sp_producto_actualizar` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_producto_actualizar`(
in idProducto int,
in FkcategoriaId int,
in nombre varchar(80),
in descripcion varchar(80),
in precio float,
in stock int,
in ruta_image varchar(180)
)
begin

	update t_producto prod
	set prod.FkcategoriaId = FkcategoriaId,
    prod.nombre = nombre,
    prod.descripcion = descripcion,
    prod.precio = precio,
    prod.stock = stock,
    prod.ruta_image = ruta_image
    where prod.idProducto = idProducto;

end ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `sp_producto_crear` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_producto_crear`(
in FkcategoriaId int,
in nombre varchar(80),
in descripcion varchar(80),
in precio float,
in stock int,
in ruta_image varchar(180)
)
begin

	insert into t_producto(FkcategoriaId, nombre, descripcion, precio, stock, ruta_image)
	values(FkcategoriaId, nombre, descripcion, precio, stock, ruta_image); 
    
end ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `sp_producto_eliminar` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_producto_eliminar`(
in idProducto int
)
begin

	delete from t_producto prod where prod.idProducto = idProducto;

end ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `sp_producto_listar` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_producto_listar`()
begin
	select * from t_producto ORDER BY nombre ASC; 
end ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `sp_usuario_actualizar` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_usuario_actualizar`(
in idUsuario int,
in nombre varchar(50),
in apellido varchar(50),
in usuario varchar(50),
in perfil int,
in contrasena varchar(120)
)
begin

	update t_usuario us
	set us.nombre = nombre,
    us.apellido = apellido,
    us.usuario = usuario,
    us.perfil = perfil,
    us.contrasena = contrasena
    
    where us.idUsuario = idUsuario;

end ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `sp_usuario_actualizar_sin_password` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_usuario_actualizar_sin_password`(
in idUsuario int,
in nombre varchar(50),
in apellido varchar(50),
in usuario varchar(50),
in perfil int
)
begin

	update t_usuario us
	set us.nombre = nombre,
    us.apellido = apellido,
    us.usuario = usuario,
    us.perfil = perfil
    
    where us.idUsuario = idUsuario;

end ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `sp_usuario_crear` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_usuario_crear`(
in nombre varchar(50),
in apellido varchar(50),
in usuario varchar(50),
in perfil int,
in contrasena varchar(120) 
)
begin

	insert into t_usuario(nombre, apellido, usuario, perfil, contrasena)
	values(nombre, apellido, usuario, perfil, contrasena); 
    
	 select * from t_usuario where idUsuario = (select LAST_INSERT_ID());

end ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `sp_usuario_eliminar` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_usuario_eliminar`(
in idUsuario int
)
begin

	delete from t_usuario us where us.idUsuario = idUsuario;

end ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `sp_usuario_listar` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_usuario_listar`()
begin
	select * from t_usuario ORDER BY perfil ASC; 
end ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-02-03 19:24:13
