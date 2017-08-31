-- MySQL dump 10.13  Distrib 5.7.17, for osx10.11 (x86_64)
--
-- Host: localhost    Database: beosbank-mt
-- ------------------------------------------------------
-- Server version	5.7.17
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO,POSTGRESQL' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table "T_CUSTOMER"
--
SET standard_conforming_strings = 'off';
SET backslash_quote = 'on';

DROP TABLE IF EXISTS EU_CUSTOMER;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE EU_CUSTOMER (
  ID bigint NOT NULL,
  CITY varchar  DEFAULT NULL,
  COUNTRY varchar  DEFAULT NULL,
  STREET varchar  DEFAULT NULL,
  ZIP varchar   DEFAULT NULL,
  BIRTHDATE date DEFAULT NULL,
  FIRSTNAME varchar  DEFAULT NULL,
  LASTNAME varchar  DEFAULT NULL,
  PRIMARY KEY (ID)
);
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table "EU_CUSTOMER"
--

/*!40000 ALTER TABLE "EU_CUSTOMER" DISABLE KEYS */;
INSERT INTO EU_CUSTOMER VALUES 
  (1,'Berlin','Germany','brand burgStrasse', 10115,'1985-06-20','Yanick','Modjo'),
  (2,'Bologna','Italy','place Venice', 40100,'1984-11-21','Mirabeau','Luc'),
  (3,'Paris','France','Bld DeGaule',75001,'2000-02-07','Noe','Nono'),
  (4,'Chatillon','France','Avenue JFK',55,'1984-02-19','Landry','Kouam'),
  (5,'Douala','Cameroon','bld Liberte',1020,'1996-04-21','Ghislain','Kamga'),
  (6,'Yaounde','Cameroon','Hypodrome',1400,'1983-11-18','Nathan','Brice'),
  (7,'Bruxelles','Belgium','rue Van Gogh',1000,'1980-09-06','Yohan','Pieter'),
  (8,'London','UK','street Lavoisier', 208,'1990-01-01','John','Doe'),
  (9,'Bamako','Mali','Rue Modibo Keita',30,'1979-05-17','Mohamed','Diallo'),
  (10,'Cracovie','Pologne','Avenue Vienne',434,'1983-05-17','Souleymann','Njifenjou'),
  (11,'Chennai','India','Gandhi street',600001,'1990-02-13','Anusha','Mandalapu'),
  (12,'Sao Polo','Brasil','samba bld',69400,'1994-02-13','Adriana','Pinto');



/*!40000 ALTER TABLE "EU_CUSTOMER" ENABLE KEYS */;

--
-- Table structure for table "EU_MONEYTRANSFER"
--

DROP TABLE IF EXISTS EU_MONEYTRANSFER;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE EU_MONEYTRANSFER (
  ID bigint NOT NULL,
  AMOUNT_HF_SENDER_CUR decimal(19,2) DEFAULT NULL,
  AMOUNT_HF_RECEIVER_CUR decimal(19,2) DEFAULT NULL,
  AMOUNT_TFC decimal(19,2) DEFAULT NULL,
  CREDITCARD varchar DEFAULT NULL,
  FEES decimal(19,2) DEFAULT NULL,
  KEYCODE varchar UNIQUE NOT NULL,
  RECEIVER_CURRENCY varchar DEFAULT NULL,
  SENDER_CURRENCY varchar DEFAULT NULL,
  SENDING_DATE date DEFAULT NULL,
  status varchar DEFAULT NULL,
  TOTAL_HT decimal(19,2) DEFAULT NULL,
  TOTAL_TTC decimal(19,2) DEFAULT NULL,
  VAT decimal(19,2) DEFAULT NULL,
  WITHDRAWAL_GDATE date DEFAULT NULL,
  SENDER_ID bigint DEFAULT NULL,
  RECEIVER_ID bigint DEFAULT NULL,  
PRIMARY KEY (ID),
   FOREIGN KEY (RECEIVER_ID) REFERENCES EU_CUSTOMER (ID),
   FOREIGN KEY (SENDER_ID) REFERENCES EU_CUSTOMER (ID)
);
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table "EU_MONEYTRANSFER"
--

/*!40000 ALTER TABLE "EU_MONEYTRANSFER" DISABLE KEYS */;
INSERT INTO EU_MONEYTRANSFER VALUES 
(1,200.00,NULL,NULL,'0039-0000-0000-0001',NULL,'DEIT001','EUR','EUR','2017-03-01','DRAFT',NULL,NULL,NULL,NULL,1,2),
(2,500.00,NULL,NULL,'0033-000-000-0001',NULL,'FRCM001','XAF','EUR','2016-12-12','DRAFT',NULL,NULL,NULL,NULL,3,6),
(3,200.00,NULL,NULL,'0033-000-000-0002',NULL,'FRCM002','XAF','EUR','2017-05-01','DRAFT',NULL,NULL,NULL,NULL,4,5),
(4,150.00,NULL,NULL,'0032-1111-1111-0001',NULL,'BEUK001','GBP','EUR','2015-07-03','DRAFT',NULL,NULL,NULL,NULL,7,8),
(5,110.00,NULL,NULL,'0044-2344-4444-4401',NULL,'UKCM001','XAF','GBP','2017-04-15','DRAFT',NULL,NULL,NULL,NULL,8,5),
(6,230.00,NULL,NULL,'0048-0000-0000-0001',NULL,'POLML001','XAF','PLN','2017-04-16','DRAFT',NULL,NULL,NULL,NULL,10,9),
(7,100.00,NULL,NULL,'0032-1111-1111-0001',NULL,'BEIN001','INR','EUR','2017-05-08','DRAFT',NULL,NULL,NULL,NULL,7,11),
(8,100.00,NULL,NULL,'0032-1111-1111-0001',NULL,'BEBR002','BRL','EUR','2017-05-10','DRAFT',NULL,NULL,NULL,NULL,7,12),
(9,400.00,NULL,NULL,'0033-000-000-0001',NULL,'FRCM003','XAF','EUR','2017-03-20','DRAFT',NULL,NULL,NULL,NULL,3,6);

/*!40000 ALTER TABLE "EU_MONEYTRANSFER" ENABLE KEYS */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-05-10 18:03:10
