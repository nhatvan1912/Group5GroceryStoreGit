-- MySQL dump 10.13  Distrib 8.0.29, for Win64 (x86_64)
--
-- Host: localhost    Database: listaccount
-- ------------------------------------------------------
-- Server version	8.0.29

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
-- Table structure for table `customer`
--

DROP TABLE IF EXISTS `customer`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `customer` (
  `id` int NOT NULL AUTO_INCREMENT,
  `customer_id` int NOT NULL,
  `prod_name` varchar(100) COLLATE utf8mb4_general_ci NOT NULL,
  `quantity` int NOT NULL,
  `price` int NOT NULL,
  `date` date DEFAULT NULL,
  `em_username` varchar(100) COLLATE utf8mb4_general_ci DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=101 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `customer`
--

LOCK TABLES `customer` WRITE;
/*!40000 ALTER TABLE `customer` DISABLE KEYS */;
INSERT INTO `customer` VALUES (1,1,'Carrot',2,20000,'2024-10-26','admin001'),(2,1,'Green Tea',5,50000,'2024-10-26','admin001'),(3,1,'Pizza Mama',2,70000,'2024-10-26','admin001'),(4,1,'Canned Pate',6,180000,'2024-10-26','admin001'),(5,1,'Lipstick',1,100000,'2024-10-26','admin001'),(6,1,'Sour Meat',1,30000,'2024-10-26','admin001'),(7,1,'Tuna',1,30000,'2024-10-26','admin001'),(8,1,'Mat',2,20000,'2024-10-26','admin001'),(9,1,'Dry Seeds',1,50000,'2024-10-26','admin001'),(10,2,'Instant Cake',3,36000,'2024-10-26','admin001'),(11,3,'Saussage Pork',2,40000,'2024-10-26','admin001'),(12,3,'Fish Sauce',1,10000,'2024-10-26','admin001'),(13,3,'Pot',5,50000,'2024-10-26','admin001'),(14,4,'Sanwich',2,20000,'2024-10-26','hoai nam'),(15,4,'Rice Paper',4,60000,'2024-10-26','hoai nam'),(16,4,'Hotpot Balls',1,60000,'2024-10-26','hoai nam'),(17,4,'Sausage Mochi',1,50000,'2024-10-26','hoai nam'),(18,4,'Chopsticks Spoon',1,20000,'2024-10-26','hoai nam'),(19,4,'Knife',1,50000,'2024-10-26','hoai nam'),(20,5,'Pea 1kg',2,50000,'2024-10-26','hoai nam'),(21,5,'Dry Seeds',1,50000,'2024-10-26','hoai nam'),(22,6,'Hotpot Balls',1,60000,'2024-10-26','hoai nam'),(23,6,'Sausage Mochi',1,50000,'2024-10-26','hoai nam'),(24,6,'Fried Dough',1,10000,'2024-10-26','hoai nam'),(25,7,'Instant Cake',2,24000,'2024-10-26','nhatvan'),(26,7,'Gyoza',2,60000,'2024-10-26','nhatvan'),(27,8,'Hamburger',1,30000,'2024-10-26','nhatvan'),(28,9,'Onion',1,10000,'2024-10-26','nhatvan'),(29,10,'Hamburger',2,60000,'2024-10-26','nhatvan'),(30,11,'Green Tea',1,10000,'2024-10-26','admin001'),(31,12,'Pizza Mama',1,35000,'2024-10-26','admin001'),(32,13,'Green Tea',1,10000,'2024-10-26','namancut'),(33,13,'Potato',2,20000,'2024-10-26','namancut'),(34,13,'Hamburger',2,60000,'2024-10-26','namancut'),(35,13,'Spinach',1,10000,'2024-10-26','namancut'),(36,14,'Carrot',1,10000,'2024-10-26','namancut'),(37,14,'Hamburger',1,30000,'2024-10-26','namancut'),(38,14,'Bok choy',1,10000,'2024-10-26','namancut'),(39,14,'Spinach',1,10000,'2024-10-26','namancut'),(40,14,'Onion',1,10000,'2024-10-26','namancut'),(41,14,'Potato',1,10000,'2024-10-26','namancut'),(42,14,'Orange Juice',1,20000,'2024-10-26','namancut'),(43,14,'Green Tea',1,10000,'2024-10-26','namancut'),(44,14,'Pepsi',1,20000,'2024-10-26','namancut'),(45,14,'Coca Cola',1,10000,'2024-10-26','namancut'),(46,14,'Beer Heineken',1,15000,'2024-10-26','namancut'),(47,14,'Sanwich',1,10000,'2024-10-26','namancut'),(48,14,'Pizza Mama',1,35000,'2024-10-26','namancut'),(49,14,'Potato Cake',1,10000,'2024-10-26','namancut'),(50,15,'Orange Juice',1,20000,'2024-10-26','admin001'),(51,15,'Green Tea',1,10000,'2024-10-26','admin001'),(52,15,'Carrot',1,10000,'2024-10-26','admin001'),(53,15,'Beer Heineken',1,15000,'2024-10-26','admin001'),(54,15,'Pizza Mama',1,35000,'2024-10-26','admin001'),(55,15,'Sanwich',1,10000,'2024-10-26','admin001'),(56,15,'Seaweed Snack',1,25000,'2024-10-26','admin001'),(57,15,'Rice Paper',1,15000,'2024-10-26','admin001'),(58,15,'Dried Fruit',1,15000,'2024-10-26','admin001'),(59,15,'Hotpot Balls',1,60000,'2024-10-26','admin001'),(60,15,'Gyoza',1,30000,'2024-10-26','admin001'),(61,15,'Saussage Pork',1,20000,'2024-10-26','admin001'),(62,15,'Crisp Rolls',1,50000,'2024-10-26','admin001'),(63,15,'Sausage Mochi',1,50000,'2024-10-26','admin001'),(64,15,'Fried Dough',1,10000,'2024-10-26','admin001'),(65,15,'Chili Sauce ',1,10000,'2024-10-26','admin001'),(66,15,'Fish Sauce',1,10000,'2024-10-26','admin001'),(67,15,'Sugar',1,20000,'2024-10-26','admin001'),(68,16,'Sausage Mochi',1,50000,'2024-10-26','admin001'),(69,16,'Green Tea',5,50000,'2024-10-26','admin001'),(70,16,'Potato Cake',4,40000,'2024-10-26','admin001'),(71,16,'Seaweed Snack',6,150000,'2024-10-26','admin001'),(72,16,'Dried Fruit',1,15000,'2024-10-26','admin001'),(73,17,'Dry Seeds',1,50000,'2024-10-26','admin001'),(76,18,'Carrot',3,30000,'2024-10-28','admin001'),(77,18,'Spinach',2,20000,'2024-10-28','admin001'),(78,18,'Pizza Mama',1,35000,'2024-10-28','admin001'),(79,18,'Sanwich',5,50000,'2024-10-28','admin001'),(80,18,'Potato Cake',1,10000,'2024-10-28','admin001'),(81,19,'Hotpot Balls',5,300000,'2024-10-28','admin001'),(82,19,'Dried Fruit',5,75000,'2024-10-28','admin001'),(83,19,'Gyoza',2,60000,'2024-10-28','admin001'),(84,19,'Crisp Rolls',4,200000,'2024-10-28','admin001'),(85,19,'Sausage Mochi',1,50000,'2024-10-28','admin001'),(86,20,'Fish Sauce',1,10000,'2024-10-28','admin001'),(87,20,'Fried Dough',1,10000,'2024-10-28','admin001'),(88,20,'Chicken Femoral',1,100000,'2024-10-28','admin001'),(89,21,'Potato',1,10000,'2024-10-28','nhatvan'),(90,21,'Green Tea',2,20000,'2024-10-28','nhatvan'),(91,22,'Green Tea',1,10000,'2024-10-28','nhatvan'),(92,22,'Pepsi',1,20000,'2024-10-28','nhatvan'),(93,23,'Sanwich',1,10000,'2024-10-29','nhatvan'),(94,23,'Pizza Mama',3,105000,'2024-10-29','nhatvan'),(95,23,'Pepsi',2,40000,'2024-10-29','nhatvan'),(96,23,'Green Tea',1,10000,'2024-10-29','nhatvan'),(97,24,'Hotpot Balls',2,120000,'2024-10-29','nhatvan'),(98,24,'Crisp Rolls',5,250000,'2024-10-29','nhatvan'),(99,24,'Sausage Mochi',3,150000,'2024-10-29','nhatvan'),(100,24,'Drag',3,90003,'2024-10-29','nhatvan');
/*!40000 ALTER TABLE `customer` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `delete_log`
--

DROP TABLE IF EXISTS `delete_log`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `delete_log` (
  `id` int NOT NULL AUTO_INCREMENT,
  `username` varchar(100) COLLATE utf8mb4_general_ci NOT NULL,
  `delete_by` varchar(100) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `open_by` varchar(100) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `date` date DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `delete_log`
--

LOCK TABLES `delete_log` WRITE;
/*!40000 ALTER TABLE `delete_log` DISABLE KEYS */;
INSERT INTO `delete_log` VALUES (1,'lanphuong',NULL,'admin001','2024-10-24'),(2,'lanphuong','admin001',NULL,'2024-10-24'),(3,'nhatvan',NULL,'admin001','2024-10-24'),(4,'nhatvan',NULL,'admin001','2024-10-24'),(5,'nhatvan',NULL,'admin001','2024-10-26'),(6,'namancut',NULL,'admin001','2024-10-26'),(7,'namancut','admin001',NULL,'2024-10-26');
/*!40000 ALTER TABLE `delete_log` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `employee`
--

DROP TABLE IF EXISTS `employee`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `employee` (
  `id` int NOT NULL AUTO_INCREMENT,
  `username` varchar(100) COLLATE utf8mb4_general_ci NOT NULL,
  `password` varchar(100) COLLATE utf8mb4_general_ci NOT NULL,
  `question` varchar(100) COLLATE utf8mb4_general_ci NOT NULL,
  `answer` varchar(100) COLLATE utf8mb4_general_ci NOT NULL,
  `date` date DEFAULT NULL,
  `manager` int NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `employee`
--

LOCK TABLES `employee` WRITE;
/*!40000 ALTER TABLE `employee` DISABLE KEYS */;
INSERT INTO `employee` VALUES (1,'admin001','admin001','What is your favorite color?','red','2024-10-23',1),(2,'nhatvan','lanphuong','What is your favorite color?','red','2024-10-23',0),(4,'ducphuc','phucduck4','What is your last 4 numbers of your number?','1234','2024-10-26',0),(5,'hoai nam ','02072004','What is your favourite food?','sheeet','2024-10-26',0);
/*!40000 ALTER TABLE `employee` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `product`
--

DROP TABLE IF EXISTS `product`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `product` (
  `id` int NOT NULL AUTO_INCREMENT,
  `prod_id` varchar(100) COLLATE utf8mb4_general_ci NOT NULL,
  `prod_name` varchar(100) COLLATE utf8mb4_general_ci NOT NULL,
  `type` varchar(100) COLLATE utf8mb4_general_ci NOT NULL,
  `stock` int NOT NULL,
  `price` int NOT NULL,
  `status` varchar(100) COLLATE utf8mb4_general_ci NOT NULL,
  `image` varchar(500) COLLATE utf8mb4_general_ci NOT NULL,
  `date` date DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=65 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `product`
--

LOCK TABLES `product` WRITE;
/*!40000 ALTER TABLE `product` DISABLE KEYS */;
INSERT INTO `product` VALUES (1,'prod_01_ve','Carrot','Vegetable',17,10000,'Available','D:\\\\Group5GroceryStoreGit\\\\src\\\\main\\\\resources\\\\Utils\\\\Product\\\\health-benefits-of-carrots.jpg','2024-10-23'),(2,'prod_02_ff','Hamburger','Fast food',20,30000,'Available','D:\\\\Group5GroceryStoreGit\\\\src\\\\main\\\\resources\\\\Utils\\\\Product\\\\full_v2ah7y94-1274-hamburger-thit-nuong.jpg','2024-10-23'),(3,'prod_03_ve','Bok choy','Vegetable',49,10000,'Available','D:\\\\Group5GroceryStoreGit\\\\src\\\\main\\\\resources\\\\Utils\\\\Product\\\\products-85C1C225-B28B-4E06-B359-94C64DC7B8B0-600x600.jpg','2024-10-23'),(4,'prod_04_ve','Spinach','Vegetable',19,10000,'Available','D:\\\\Group5GroceryStoreGit\\\\src\\\\main\\\\resources\\\\Utils\\\\Product\\\\20190620_071443_522146_rau_muong_max_1800x1800_png_5563dd2c74.png','2024-10-23'),(5,'prod_05_ve','Onion','Vegetable',23,10000,'Available','D:\\\\Group5GroceryStoreGit\\\\src\\\\main\\\\resources\\\\Utils\\\\Product\\\\Hanh-tay.jpg','2024-10-23'),(6,'prod_06_ve','Potato','Vegetable',11,10000,'Available','D:\\\\Group5GroceryStoreGit\\\\src\\\\main\\\\resources\\\\Utils\\\\Product\\\\unnamed (1).jpg','2024-10-23'),(7,'prod_07_be','Pepsi','Beverages',21,20000,'Available','D:\\\\Group5GroceryStoreGit\\\\src\\\\main\\\\resources\\\\Utils\\\\Product\\\\8934588012228 1.jpg','2024-10-23'),(8,'prod_08_be','Green Tea','Beverages',19,10000,'Available','D:\\\\Group5GroceryStoreGit\\\\src\\\\main\\\\resources\\\\Utils\\\\Product\\\\tra-xanh-khong-do-vi-chanh-455ml-202004221747191203.jpg','2024-10-23'),(9,'prod_09_be','Orange Juice','Beverages',23,20000,'Available','D:\\\\Group5GroceryStoreGit\\\\src\\\\main\\\\resources\\\\Utils\\\\Product\\\\orange_juince.jpg','2024-10-23'),(10,'prod_10_be','Coca Cola','Beverages',24,10000,'Available','D:\\\\Group5GroceryStoreGit\\\\src\\\\main\\\\resources\\\\Utils\\\\Product\\\\hqdefault.jpg','2024-10-23'),(11,'prod_11_be','Beer Heineken','Beverages',22,15000,'Available','D:\\\\Group5GroceryStoreGit\\\\src\\\\main\\\\resources\\\\Utils\\\\Product\\\\b904c625422c43d3bb9aeb648743399b.png','2024-10-23'),(12,'prod_12_ff','Instant Cake','Fast food',100,12000,'Available','D:\\\\Group5GroceryStoreGit\\\\src\\\\main\\\\resources\\\\Utils\\\\Product\\\\banh14-1000x1000-493.png','2024-10-23'),(13,'prod_13_ff','Sanwich','Fast food',7,10000,'Available','D:\\\\Group5GroceryStoreGit\\\\src\\\\main\\\\resources\\\\Utils\\\\Product\\\\36394502_staffsandwich110g.png','2024-10-23'),(14,'prod_14_ff','Pizza Mama','Fast food',6,35000,'Available','D:\\\\Group5GroceryStoreGit\\\\src\\\\main\\\\resources\\\\Utils\\\\Product\\\\pizza-manna-pho-mai-ht-food-hop-120g-201909251550253975.jpg','2024-10-23'),(15,'prod_15_ff','Potato Cake','Fast food',14,10000,'Available','D:\\\\Group5GroceryStoreGit\\\\src\\\\main\\\\resources\\\\Utils\\\\Product\\\\S3a99e78e4c1141cbb7688fd2ada298f2d.jpg','2024-10-23'),(16,'prod_16_ff','Seaweed Snack','Fast food',23,25000,'Available','D:\\\\Group5GroceryStoreGit\\\\src\\\\main\\\\resources\\\\Utils\\\\Product\\\\3105-p2-1573003857.jpg','2024-10-23'),(17,'prod_17_ff','Rice Paper','Fast food',25,15000,'Available','D:\\\\Group5GroceryStoreGit\\\\src\\\\main\\\\resources\\\\Utils\\\\Product\\\\banh-trang-tron-dong-goi-san.jpg','2024-10-23'),(18,'prod_18_ff','Dried Fruit','Fast food',8,15000,'Available','D:\\\\Group5GroceryStoreGit\\\\src\\\\main\\\\resources\\\\Utils\\\\Product\\\\dsc01212.jpg','2024-10-23'),(19,'prod_19_se','Saussage Pork','Frozen Food',2,20000,'Available','D:\\\\Group5GroceryStoreGit\\\\src\\\\main\\\\resources\\\\Utils\\\\Product\\\\xuc-xich-heo-dinh-duong-vissan-goi-175g-202306191010225859_300x300 (1).png','2024-10-23'),(20,'prod_20_se','Hotpot Balls','Frozen Food',20,60000,'Available','D:\\\\Group5GroceryStoreGit\\\\src\\\\main\\\\resources\\\\Utils\\\\Product\\\\Chef-aroy-hot-pot-combo-scaled.jpg','2024-10-23'),(21,'prod_21_se','Gyoza','Frozen Food',5,30000,'Available','D:\\\\Group5GroceryStoreGit\\\\src\\\\main\\\\resources\\\\Utils\\\\Product\\\\banh-xep-kieu-nhat-300x300.jpg','2024-10-23'),(22,'prod_22_se','Crisp Rolls','Frozen Food',20,50000,'Available','D:\\\\Group5GroceryStoreGit\\\\src\\\\main\\\\resources\\\\Utils\\\\Product\\\\cha-gio-xop-300x300.jpg','2024-10-23'),(23,'prod_23_se','Sausage Mochi','Frozen Food',2,50000,'Available','D:\\\\Group5GroceryStoreGit\\\\src\\\\main\\\\resources\\\\Utils\\\\Product\\\\xuc-xich-mochi-300x300.jpg','2024-10-23'),(24,'prod_24_me','Fried Dough','Spices',37,10000,'Available','D:\\\\Group5GroceryStoreGit\\\\src\\\\main\\\\resources\\\\Utils\\\\Product\\\\Ajiquick-bot-tam-kho.jpg','2024-10-23'),(25,'prod_25_me','Chili Sauce ','Spices',19,10000,'Available','D:\\\\Group5GroceryStoreGit\\\\src\\\\main\\\\resources\\\\Utils\\\\Product\\\\mockup-tuong-ot-chinsu-500g.png','2024-10-23'),(26,'prod_26_me','Fish Sauce','Spices',17,10000,'Available','D:\\\\Group5GroceryStoreGit\\\\src\\\\main\\\\resources\\\\Utils\\\\Product\\\\nuoc-mam-nam-ngu-phu-quoc-chai-thuy-tinh-1.jpg','2024-10-23'),(27,'prod_28_me','Sugar','Spices',19,20000,'Available','D:\\\\Group5GroceryStoreGit\\\\src\\\\main\\\\resources\\\\Utils\\\\Product\\\\Duong-tinh-luyen.jpg','2024-10-23'),(28,'prod_29_hg','Pan','Household Goods',20,10000,'Available','D:\\\\Group5GroceryStoreGit\\\\src\\\\main\\\\resources\\\\Utils\\\\Product\\\\Anh_chuan-550x550w.jpg','2024-10-23'),(29,'prod_30_hg','Pot','Household Goods',25,10000,'Available','D:\\\\Group5GroceryStoreGit\\\\src\\\\main\\\\resources\\\\Utils\\\\Product\\\\G1354595-0-1000x1000.jpg','2024-10-23'),(30,'prod_31_hg','Drag','Household Goods',27,30001,'Available','D:\\\\Group5GroceryStoreGit\\\\src\\\\main\\\\resources\\\\Utils\\\\Product\\\\61sdRqglnBL.1000x1000.jpg','2024-10-23'),(31,'prod_32_hg','Chopsticks Spoon','Household Goods',29,20000,'Available','D:\\\\Group5GroceryStoreGit\\\\src\\\\main\\\\resources\\\\Utils\\\\Product\\\\unnamed.jpg','2024-10-23'),(32,'prod_33_hg','Knife','Household Goods',29,50000,'Available','D:\\\\Group5GroceryStoreGit\\\\src\\\\main\\\\resources\\\\Utils\\\\Product\\\\cac-loai-dao-nhat-xin.png','2024-10-23'),(33,'prod_34_pc','Romano Shampoo','Personal Care',20,60000,'Available','D:\\\\Group5GroceryStoreGit\\\\src\\\\main\\\\resources\\\\Utils\\\\Product\\\\1598686519601.png','2024-10-23'),(34,'prod_35_pc','Toothbrush','Personal Care',20,10000,'Available','D:\\\\Group5GroceryStoreGit\\\\src\\\\main\\\\resources\\\\Utils\\\\Product\\\\4901080758415-ban-chai-aquafresh.jpg','2024-10-23'),(35,'prod_36_pc','Towel','Personal Care',20,10000,'Available','D:\\\\Group5GroceryStoreGit\\\\src\\\\main\\\\resources\\\\Utils\\\\Product\\\\KMGT-1.jpg','2024-10-23'),(36,'prod_37_pc','Shower Gel','Personal Care',20,50000,'Available','D:\\\\Group5GroceryStoreGit\\\\src\\\\main\\\\resources\\\\Utils\\\\Product\\\\Gel-tam-MediNano-Renew-Premium-Shower-Gel.jpg','2024-10-23'),(37,'prod_38_pc','Shaver','Personal Care',20,75000,'Available','D:\\\\Group5GroceryStoreGit\\\\src\\\\main\\\\resources\\\\Utils\\\\Product\\\\may-cao-rau-yandou-new-usb-type-c-11-new.jpg','2024-10-23'),(38,'prod_39_pc','Canned Pate','Canned Food',10,30000,'Available','D:\\\\Group5GroceryStoreGit\\\\src\\\\main\\\\resources\\\\Utils\\\\Product\\\\images.jpg','2024-10-23'),(39,'prod_40_cp','Canned Pork','Canned Food',20,30000,'Available','D:\\\\Group5GroceryStoreGit\\\\src\\\\main\\\\resources\\\\Utils\\\\Product\\\\heo-ham-vissan-hop-150g-x-72-2-700x467.jpg','2024-10-23'),(40,'prod_41_cp','Sour Meat','Canned Food',19,30000,'Available','D:\\\\Group5GroceryStoreGit\\\\src\\\\main\\\\resources\\\\Utils\\\\Product\\\\190515_xiumai_1.jpg','2024-10-23'),(41,'prod_42_cp','Tuna','Canned Food',19,30000,'Available','D:\\\\Group5GroceryStoreGit\\\\src\\\\main\\\\resources\\\\Utils\\\\Product\\\\ca-ngu-ngam-dau-ha-long-hop-175gr-48-2-org.jpg','2024-10-23'),(42,'prod_43_cp','Canned Chicken','Canned Food',20,30000,'Available','D:\\\\Group5GroceryStoreGit\\\\src\\\\main\\\\resources\\\\Utils\\\\Product\\\\thit-ga-xot-mayonnaise-vissan-hop-85g-202203102224485094.jpg','2024-10-23'),(43,'prod_44_co','Lipstick','Cosmetics',19,100000,'Available','D:\\\\Group5GroceryStoreGit\\\\src\\\\main\\\\resources\\\\Utils\\\\Product\\\\t4-lychee-vacosi-5173-2-7.png','2024-10-23'),(44,'prod_45_co','Mask','Cosmetics',20,10000,'Available','D:\\\\Group5GroceryStoreGit\\\\src\\\\main\\\\resources\\\\Utils\\\\Product\\\\vn-11134207-7qukw-lfi1jwdsmwzoa8.jpg','2024-10-23'),(45,'prod_46_co','Makeup Remover','Cosmetics',20,100000,'Available','D:\\\\Group5GroceryStoreGit\\\\src\\\\main\\\\resources\\\\Utils\\\\Product\\\\3100-gentle-touch-makeup-remover-slide-1-01062020.jpg','2024-10-23'),(46,'prod_47_co','Cleanser','Cosmetics',30,100000,'Available','D:\\\\Group5GroceryStoreGit\\\\src\\\\main\\\\resources\\\\Utils\\\\Product\\\\9190.jpg','2024-10-23'),(47,'prod_48_co','Sunscreen','Cosmetics',30,250000,'Available','D:\\\\Group5GroceryStoreGit\\\\src\\\\main\\\\resources\\\\Utils\\\\Product\\\\SunScreen-Plant-Cell.jpg','2024-10-23'),(48,'prod_49_df','Rice 1kg','Dry Food',20,17000,'Available','D:\\\\Group5GroceryStoreGit\\\\src\\\\main\\\\resources\\\\Utils\\\\Product\\\\gia-lua-gao-hom-nay-195433_472-095802.jpg','2024-10-23'),(49,'prod_50_df','Noodle','Dry Food',20,5000,'Available','D:\\\\Group5GroceryStoreGit\\\\src\\\\main\\\\resources\\\\Utils\\\\Product\\\\8934563138165-5.jpg','2024-10-23'),(50,'prod_51_df','Pea 1kg','Dry Food',18,25000,'Available','D:\\\\Group5GroceryStoreGit\\\\src\\\\main\\\\resources\\\\Utils\\\\Product\\\\dau-xanh.jpg','2024-10-23'),(51,'prod_52_df','Rice Noodle','Dry Food',20,25000,'Available','D:\\\\Group5GroceryStoreGit\\\\src\\\\main\\\\resources\\\\Utils\\\\Product\\\\vn_dc_6.jpg','2024-10-23'),(54,'prod_53_df','Dry Seeds','Dry Food',99,50000,'Available','D:\\\\Group5GroceryStoreGit\\\\src\\\\main\\\\resources\\\\Utils\\\\Product\\\\23b283002f30052470216defd31a8172.png','2024-10-23'),(64,'prod_54_se','Chicken Femoral','Frozen Food',24,100000,'Available','D:\\\\Group5GroceryStoreGit\\\\src\\\\main\\\\resources\\\\Utils\\\\Product\\\\380496ba68f24b51bfd2d75f9f0d8a16.jpg_525x525q80.jpg','2024-10-28');
/*!40000 ALTER TABLE `product` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `receipt`
--

DROP TABLE IF EXISTS `receipt`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `receipt` (
  `id` int NOT NULL AUTO_INCREMENT,
  `customer_id` int NOT NULL,
  `total` int NOT NULL,
  `date` date DEFAULT NULL,
  `em_username` varchar(100) COLLATE utf8mb4_general_ci NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=25 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `receipt`
--

LOCK TABLES `receipt` WRITE;
/*!40000 ALTER TABLE `receipt` DISABLE KEYS */;
INSERT INTO `receipt` VALUES (1,1,550000,'2024-10-26','admin001'),(2,2,36000,'2024-10-26','admin001'),(3,3,100000,'2024-10-26','admin001'),(4,4,260000,'2024-10-26','hoai nam'),(5,5,100000,'2024-10-26','hoai nam'),(6,6,120000,'2024-10-26','hoai nam'),(7,7,84000,'2024-10-26','nhatvan'),(8,8,30000,'2024-10-26','nhatvan'),(9,9,10000,'2024-10-26','nhatvan'),(10,10,60000,'2024-10-26','nhatvan'),(11,11,10000,'2024-10-26','admin001'),(12,12,35000,'2024-10-26','admin001'),(13,13,100000,'2024-10-26','namancut'),(14,14,210000,'2024-10-26','namancut'),(15,15,415000,'2024-10-26','admin001'),(16,16,305000,'2024-10-26','admin001'),(17,17,50000,'2024-10-26','admin001'),(18,18,145000,'2024-10-28','admin001'),(19,19,685000,'2024-10-28','admin001'),(20,20,120000,'2024-10-28','admin001'),(21,21,30000,'2024-10-28','nhatvan'),(22,22,30000,'2024-10-28','nhatvan'),(23,23,165000,'2024-10-29','nhatvan'),(24,24,610003,'2024-10-29','nhatvan');
/*!40000 ALTER TABLE `receipt` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-10-29 22:16:56
