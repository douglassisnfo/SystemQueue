-- MySQL dump 10.13  Distrib 8.0.18, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: system-test
-- ------------------------------------------------------
-- Server version	8.0.17

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

DROP TABLE IF EXISTS `address`;
DROP TABLE IF EXISTS `client`;


--
-- Table structure for table `client`
--


/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `client` (
  `id` binary(16) NOT NULL,
  `email` varchar(255) DEFAULT NULL,
  `lastUpdate` date DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `register` date DEFAULT NULL,
  `status` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `client`
--

LOCK TABLES `client` WRITE;
/*!40000 ALTER TABLE `client` DISABLE KEYS */;
INSERT INTO `client` VALUES (_binary 'cT¾$ô\å\éŸ\Ó\ä¹zx~x','douglas@gmail','2010-11-10','DOUGLAS SANTOS MARQUES ','96999626073','2010-11-10',1);
/*!40000 ALTER TABLE `client` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;

-- Table structure for table `address`
--
CREATE TABLE `address` (
  `id` binary(16) NOT NULL,
  `city` varchar(255) DEFAULT NULL,
  `complement` varchar(255) DEFAULT NULL,
  `neighborhood` varchar(255) DEFAULT NULL,
  `number` int(11) NOT NULL,
  `state` varchar(255) DEFAULT NULL,
  `status` int(11) DEFAULT NULL,
  `street` varchar(255) DEFAULT NULL,
  `zipcode` varchar(255) DEFAULT NULL,
  `clientId` binary(16) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKdx0bl6bl5xsoxkc7b67t048oa` (`clientId`),
  CONSTRAINT `FKamv9ey97a0ubq8t40bd1n18wl` FOREIGN KEY (`clientId`) REFERENCES `client` (`id`),
  CONSTRAINT `FKdx0bl6bl5xsoxkc7b67t048oa` FOREIGN KEY (`clientId`) REFERENCES `client` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `address`
--

LOCK TABLES `address` WRITE;
/*!40000 ALTER TABLE `address` DISABLE KEYS */;
INSERT INTO `address` VALUES (_binary '\Æ84ô\å\éŸ\Ó\ä¹zx~x','SUZANO','APTO 13 TORE E','VILA 1',36,'SÃƒO PAULO',1,'RUA ISADORA','08685478',_binary 'cT¾$ô\å\éŸ\Ó\ä¹zx~x'),(_binary '\Ì\æÿÁô\å\éŸ\Ó\ä¹zx~x','SÃƒO PAULO',NULL,'VILA 2',36,'SÃƒO PAULO',1,'RUA ISADORA','08685478',_binary 'cT¾$ô\å\éŸ\Ó\ä¹zx~x');
/*!40000 ALTER TABLE `address` ENABLE KEYS */;
UNLOCK TABLES;



-- Dump completed on 2019-10-22 13:09:13


--
-- DOUGLAS MARQUES
-- 2019-07
--

-- CLEAR DATA BASE
--drop table company IF EXISTS;
--drop table client IF EXISTS;
--drop table address IF EXISTS;
--drop table creditCard IF EXISTS;
--drop table typePayment IF EXISTS;
--drop table clientCreditCard IF EXISTS;
--drop table user IF EXISTS;
--drop table profile IF EXISTS;
--drop table userProfile IF EXISTS;

-- CREATE TABLES

--CREATE TABLE typePayment (
--id MEDIUMINT NOT NULL AUTO_INCREMENT,
--description VARCHAR(150),
--PRIMARY KEY (id));
--
--CREATE TABLE company (
--id MEDIUMINT NOT NULL AUTO_INCREMENT,
--document VARCHAR(15),
--socialName VARCHAR(100),
--register DATE,
--active BOOLEAN default TRUE ,
--merchantId VARCHAR(100),
--merchantKey VARCHAR(100),
--email VARCHAR(100),
--street VARCHAR(100),
--zipcode VARCHAR(100),
--uf VARCHAR(100),
--number INTEGER,
--complement VARCHAR(100),
--PRIMARY KEY (id));
--
--CREATE TABLE client (
--id MEDIUMINT NOT NULL AUTO_INCREMENT,
--document VARCHAR(15),
--name VARCHAR(100),
--register DATE,
--idCompany INTEGER,
----idClientCreditCard INTEGER,
--street VARCHAR(100),
--zipcode VARCHAR(100),
--uf VARCHAR(100),
--number INTEGER,
--complement VARCHAR(100),
--PRIMARY KEY (id),
--foreign key (idCompany) references company(id));
--
--CREATE TABLE creditCard (
--id MEDIUMINT NOT NULL AUTO_INCREMENT,
--name VARCHAR(100),
--criptValue VARCHAR(32),
--maskValue VARCHAR(32),
--brand VARCHAR(100),
--fgActive BOOLEAN default TRUE ,
--validate DATE,
--register DATE,
----idClientCreditCard INTEGER,
--PRIMARY KEY (id));
--
--
--CREATE TABLE clientCreditCard (
--id MEDIUMINT NOT NULL AUTO_INCREMENT,
--idClient INTEGER,
--idCredtCard INTEGER,
--register DATE,
--foreign key (idClient) references client(id),
--foreign key (idCredtCard) references creditCard(id),
--PRIMARY KEY (id));
--
-- foreign key (idClientCreditCard) references clientCreditCard(id)
--ALTER TABLE PUBLIC.client
--ADD FOREIGN KEY (idClientCreditCard) 
--REFERENCES clientCreditCard(id)

--foreign key (idClientCreditCard) references clientCreditCard(id)
--ALTER TABLE PUBLIC.creditCard
--ADD FOREIGN KEY (idClientCreditCard) 
--REFERENCES clientCreditCard(id)

			
--CREATE TABLE orders (
--id MEDIUMINT NOT NULL AUTO_INCREMENT,
--name VARCHAR(100),
--value LONG,
--times INTEGER,
--fgActive BOOLEAN default TRUE ,
--register DATE,
--idclientCreditCard INTEGER,
--PRIMARY KEY (id),
--foreign key (idclientCreditCard) references clientCreditCard(id));
--
--
--CREATE TABLE user (
--id MEDIUMINT NOT NULL AUTO_INCREMENT,
--name VARCHAR(100),
--email VARCHAR(100),
--password VARCHAR(100),
--fgActive BOOLEAN default TRUE ,
--register DATE,
--idCompany INTEGER,
--PRIMARY KEY (id),
--foreign key (idCompany) references company(id));
--
--
--CREATE TABLE profile (
--id MEDIUMINT NOT NULL AUTO_INCREMENT,
--name VARCHAR(100),
--PRIMARY KEY (id)
--);
--
--
--CREATE TABLE userProfile (
--id MEDIUMINT NOT NULL AUTO_INCREMENT,
--idUser INTEGER,
--idProfile INTEGER,
--foreign key (idUser) references user(id),
--foreign key (idProfile) references profile(id),
--PRIMARY KEY (id));
--
--
---- INSERT DATA company
--insert into company(document, socialName, register, active, merchantId, merchantKey, 
--email, street, zipcode, uf, number) 
--values ('12268900088','DOUGLAS CAMPANY','2010-11-07','TRUE',' 033bd94b1168d7e4f0d644c3c95e35bf','261d684f6b7d9af996a5691e7106075e', 
--'douglas@gmail.com','RUA ISADORA', '08685478', 'SP', 36 ); 
--
--insert into company(document, socialName, register, active, merchantId, merchantKey, 
--email, street, zipcode, uf, number, complement) 
--values ('60925563080','TEST CAMPANY','2010-07-07','TRUE',' 033bd94b1168d7e4f0d666c3c95e35bf','261d684f6b7d9af996a5691e7106665e', 
--'douglas@gmail.com','RUA ISADORA', '08685478', 'SP', 36, 'APTO 13 TORE E' ); 
--


-- INSERT DATA creditCard
--insert into creditCard(name, password, email, status, register, lastUpdate)
--values ('FIRSTCARD','a01785c7681dfae5ad384c3148eb01cc','402400******6688','VISA','TRUE','2023-11-01','2017-11-10'); 
--
--insert into creditCard(name, criptValue, maskValue, brand, fgActive, validate, register)
--values ('SECONDCARD','261d684f6b7d9af996a5691e7106075e','527179******2874','MASTER','TRUE','2021-11-01','2018-11-10'); 
--
--insert into creditCard(name, criptValue, maskValue, brand, fgActive, validate, register)
--values ('PRINCIPALCARD','c48e387dea4808fa3f35382e71cb1996','453273******3213','VISA','TRUE','2022-11-01','2019-11-10');
--
--
--
-- INSERT DATA client
--insert into client(id, name, password, email, status, register, lastUpdate)  
--values (uuid(),'DOUGLAS SANTOS MARQUES ','96999626073','douglas@gmail',1,'2010-11-10','2010-11-10'); 
--
--insert into client(document, name, register, idCompany,
--street, zipcode, uf, number)
--values ('48215581064','DOUGLAS SANTOS MARQUES 2','2010-11-11',2,
--'RUA ISADORA', '08685478', 'SP', 36); 
--
--insert into client(document, name, register, idCompany ) 
--values ('70042886090','DOUGLAS SANTOS MARQUES 3','2010-11-12',1);
--
--

-- INSERT DATA address
--insert into address(id, zipcode, street, neighborhood, city, uf, number, status)  
--values (uuid(),'08685478', 'RUA ISADORA', 'VILA 2', 'SÃO PAULO', 'SP', 36, 1); 

-- INSERT DATA address
--insert into address(id, zipcode, street, neighborhood, city, uf, number, complement , status)  
--values (uuid(),'08685478', 'RUA ISADORA', 'VILA 1', 'SUZANO', 'SP', 36, 'APTO 13 TORE E', 1 ); 


---- INSERT DATA clientCreditCard
--insert into clientCreditCard(idClient, idCredtCard)
--values(1,1);
--
--insert into clientCreditCard(idClient, idCredtCard)
--values(1,2);
--
--insert into clientCreditCard(idClient, idCredtCard)
--values(2,3);
--
--insert into clientCreditCard(idClient, idCredtCard)
--values(3,3);
--
--
--
---- INSERT DATA pedido
--insert into orders(name, value, times, fgActive, register, idclientCreditCard)
--values ('CELULAR',150000,10,'TRUE','2010-11-10', 1); 
--
--insert into orders(name, value, times, fgActive, register, idclientCreditCard)
--values ('TV',100000,1,'TRUE','2019-11-10', 2); 
--
--insert into orders(name, value, times, fgActive, register, idclientCreditCard)
--values ('NOTEBOOK',250000,5,'TRUE','2018-11-10', 3); 
--
--insert into orders(name, value, times, fgActive, register, idclientCreditCard)
--values ('MONITOR',50000,12,'TRUE','2017-11-10', 4); 
--
--
--
---- INSERT DATA user
--insert into user(name, email, password, fgActive, register)
--values ('TEST','teste@test.com','$2a$10$bSnff9A/ymitjVpORg238.PwkLT2jZdQGG9ny8WDJer10spYZzdDm','TRUE', '2019-07-10'); 
--
--insert into user(name, email, password, fgActive, register, idCompany)
--values ('TEST2','teste2@test.com','$2a$10$ARppQC0FRWaGP4pnZqYbpuVyYOWIp4q1r2ViT3PGYK6BafD5PXFiS','TRUE', '2019-07-10', 1); 
--
--insert into user(name, email, password, fgActive, register, idCompany)
--values ('TEST3','teste3@test.com','$2a$10$ARppQC0FRWaGP4pnZqYbpuVyYOWIp4q1r2ViT3PGYK6BafD5PXFiS','TRUE', '2019-07-10', 2); 
--
--
--
---- INSERT DATA profile
--insert into profile(name) values ('admin');
--
--insert into profile(name) values ('AdminCompany'); 
--
--insert into profile(name) values ('userCompany'); 
--
--
--
---- INSERT DATA userProfile
--insert into userProfile(idUser, idProfile)
--values(1,1);
--
--insert into userProfile(idUser, idProfile)
--values(2,2);
--
--insert into userProfile(idUser, idProfile)
--values(3,3);