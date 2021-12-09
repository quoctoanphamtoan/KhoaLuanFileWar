CREATE DATABASE  IF NOT EXISTS `khoaluan` /*!40100 DEFAULT CHARACTER SET utf8 */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `khoaluan`;
-- MySQL dump 10.13  Distrib 8.0.25, for Win64 (x86_64)
--
-- Host: localhost    Database: khoaluan
-- ------------------------------------------------------
-- Server version	8.0.25

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
-- Table structure for table `bangdiemtongket`
--

DROP TABLE IF EXISTS `bangdiemtongket`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `bangdiemtongket` (
  `id` int NOT NULL AUTO_INCREMENT,
  `diemTbTL` double DEFAULT NULL,
  `idSinhVien` int NOT NULL,
  PRIMARY KEY (`id`,`idSinhVien`),
  KEY `fk_BangDiemTongKet_sinhvien1` (`idSinhVien`),
  CONSTRAINT `fk_BangDiemTongKet_sinhvien1` FOREIGN KEY (`idSinhVien`) REFERENCES `sinhvien` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `bangdiemtongket`
--

LOCK TABLES `bangdiemtongket` WRITE;
/*!40000 ALTER TABLE `bangdiemtongket` DISABLE KEYS */;
/*!40000 ALTER TABLE `bangdiemtongket` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `canhbao`
--

DROP TABLE IF EXISTS `canhbao`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `canhbao` (
  `id` int NOT NULL AUTO_INCREMENT,
  `tieuDe` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `noiDung` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `ngaySua` date DEFAULT NULL,
  `ngayTao` date DEFAULT NULL,
  `idGiangVien` int NOT NULL,
  `idSinhVien` int NOT NULL,
  `trangThai` tinyint DEFAULT NULL,
  PRIMARY KEY (`id`,`idGiangVien`,`idSinhVien`),
  UNIQUE KEY `id_UNIQUE` (`id`),
  KEY `fk_CanhBao_GiangVien1` (`idGiangVien`),
  KEY `fk_CanhBao_sinhvien1` (`idSinhVien`),
  CONSTRAINT `fk_CanhBao_GiangVien1` FOREIGN KEY (`idGiangVien`) REFERENCES `giangvien` (`id`),
  CONSTRAINT `fk_CanhBao_sinhvien1` FOREIGN KEY (`idSinhVien`) REFERENCES `sinhvien` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `canhbao`
--

LOCK TABLES `canhbao` WRITE;
/*!40000 ALTER TABLE `canhbao` DISABLE KEYS */;
INSERT INTO `canhbao` VALUES (3,'Toan','Nghi Hoc',NULL,NULL,1,2,1),(4,'Toan','Nghi Hoc',NULL,NULL,1,8,1),(5,'SinhVien nghi hoc quá nhìu','nên bị đình chỉ','2021-12-07','2021-12-07',1,2,0),(6,'Tiêu đề cảnh báo','sinh viên nghỉ học nhìu quá','2021-12-07','2021-12-07',1,2,0);
/*!40000 ALTER TABLE `canhbao` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `diem_sinhvien_monhoc`
--

DROP TABLE IF EXISTS `diem_sinhvien_monhoc`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `diem_sinhvien_monhoc` (
  `id` int NOT NULL AUTO_INCREMENT,
  `diemCK` double DEFAULT NULL,
  `diemGK` double DEFAULT NULL,
  `diemTBC` double DEFAULT NULL,
  `diemTK1` double DEFAULT NULL,
  `diemTK2` double DEFAULT NULL,
  `diemTK3` double DEFAULT NULL,
  `idMonHoc` int NOT NULL,
  `idBangDiemTongKet` int NOT NULL,
  PRIMARY KEY (`id`,`idBangDiemTongKet`,`idMonHoc`),
  KEY `fk_Diem_SinhVien_MonHoc_MonHoc1` (`idMonHoc`),
  KEY `fk_Diem_SinhVien_MonHoc_BangDiemTongKet1` (`idBangDiemTongKet`),
  CONSTRAINT `fk_Diem_SinhVien_MonHoc_BangDiemTongKet1` FOREIGN KEY (`idBangDiemTongKet`) REFERENCES `bangdiemtongket` (`id`),
  CONSTRAINT `fk_Diem_SinhVien_MonHoc_MonHoc1` FOREIGN KEY (`idMonHoc`) REFERENCES `monhoc` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `diem_sinhvien_monhoc`
--

LOCK TABLES `diem_sinhvien_monhoc` WRITE;
/*!40000 ALTER TABLE `diem_sinhvien_monhoc` DISABLE KEYS */;
/*!40000 ALTER TABLE `diem_sinhvien_monhoc` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `donxinnghihoc`
--

DROP TABLE IF EXISTS `donxinnghihoc`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `donxinnghihoc` (
  `ngayTao` date DEFAULT NULL,
  `ngaySua` date DEFAULT NULL,
  `noiDung` varchar(1000) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `ngayNghi` date DEFAULT NULL,
  `idLopHocPhan` int NOT NULL,
  `idSinhVien` int NOT NULL,
  `id` int NOT NULL,
  `trangThai` tinyint NOT NULL,
  PRIMARY KEY (`idSinhVien`,`idLopHocPhan`),
  KEY `fk_DonXinNghiHoc_LopHocPhan1` (`idLopHocPhan`),
  CONSTRAINT `fk_DonXinNghiHoc_LopHocPhan1` FOREIGN KEY (`idLopHocPhan`) REFERENCES `lophocphan` (`id`),
  CONSTRAINT `fk_DonXinNghiHoc_sinhvien1` FOREIGN KEY (`idSinhVien`) REFERENCES `sinhvien` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `donxinnghihoc`
--

LOCK TABLES `donxinnghihoc` WRITE;
/*!40000 ALTER TABLE `donxinnghihoc` DISABLE KEYS */;
/*!40000 ALTER TABLE `donxinnghihoc` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `giangvien`
--

DROP TABLE IF EXISTS `giangvien`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `giangvien` (
  `id` int NOT NULL AUTO_INCREMENT,
  `maGiangVien` varchar(10) NOT NULL,
  `hoTen` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `diaChi` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `gioiTinh` tinyint DEFAULT NULL,
  `soDienThoai` varchar(15) DEFAULT NULL,
  `email` varchar(50) DEFAULT NULL,
  `chuyenNganh` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `ngaySua` date DEFAULT NULL,
  `ngayTao` date DEFAULT NULL,
  `idTaiKhoan` int NOT NULL,
  `trangThai` varchar(255) DEFAULT NULL,
  `imgUrl` varchar(1000) DEFAULT NULL,
  PRIMARY KEY (`id`,`idTaiKhoan`),
  UNIQUE KEY `id_UNIQUE` (`id`),
  UNIQUE KEY `maGiangVien_UNIQUE` (`maGiangVien`),
  UNIQUE KEY `taikhoan_id_UNIQUE` (`idTaiKhoan`),
  UNIQUE KEY `email_UNIQUE` (`email`),
  CONSTRAINT `fk_GiangVien_taikhoan1` FOREIGN KEY (`idTaiKhoan`) REFERENCES `taikhoan` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `giangvien`
--

LOCK TABLES `giangvien` WRITE;
/*!40000 ALTER TABLE `giangvien` DISABLE KEYS */;
INSERT INTO `giangvien` VALUES (1,'gv5e02','Dang thu ha','nguyen thai binh',1,'+84252525252','phamtoan@gmail.com',NULL,'2021-11-28','2021-11-28',3,'CONG_TAC',NULL);
/*!40000 ALTER TABLE `giangvien` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `lop`
--

DROP TABLE IF EXISTS `lop`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `lop` (
  `id` int NOT NULL AUTO_INCREMENT,
  `tenLop` varchar(45) DEFAULT NULL,
  `chuyenNganh` varchar(45) DEFAULT NULL,
  `idGiangVien` int NOT NULL,
  `khoaHoc` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`,`idGiangVien`),
  UNIQUE KEY `id_UNIQUE` (`id`),
  KEY `fk_Lop_GiangVien1` (`idGiangVien`),
  CONSTRAINT `fk_Lop_GiangVien1` FOREIGN KEY (`idGiangVien`) REFERENCES `giangvien` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `lop`
--

LOCK TABLES `lop` WRITE;
/*!40000 ALTER TABLE `lop` DISABLE KEYS */;
INSERT INTO `lop` VALUES (1,'DHKTPM13a','CNTT',1,'2021-2027'),(2,'DHKTPM13B','CNTT',1,'2021-2027'),(3,'DHKTPM13c','CNTT',1,'2021-2027'),(4,'DHKTPM13d','CNTT',1,'2021-2027'),(5,'DHKTPM13e','CNTT',1,'2021-2027'),(6,'DHKTPM13f','CNTT',1,'2021-2027'),(7,'DHKTPM13g','CNTT',1,'2021-2027'),(8,'DHKTPM13h','CNTT',1,'2021-2027'),(9,'DHKTPM13j','CNTT',1,'2021-2027'),(10,'DHKTPM13k','CNTT',1,'2021-2027'),(11,'DHKTPM13l','CNTT',1,'2021-2027'),(12,'DHKTPM13z','CNTT',1,'2021-2027'),(13,'DHKTPM13x','CNTT',1,'2021-2027'),(14,'DHKTPM13c','CNTT',1,'2021-2027'),(15,'DHKTPM13b','CNTT',1,'2021-2027'),(16,'DHKTPM13n','CNTT',1,'2021-2027'),(17,'DHKTPM13m','CNTT',1,'2021-2027'),(18,'DHKTPM13www','CNTT',1,'2021-2027');
/*!40000 ALTER TABLE `lop` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `lophocphan`
--

DROP TABLE IF EXISTS `lophocphan`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `lophocphan` (
  `id` int NOT NULL AUTO_INCREMENT,
  `tenLopHocPhan` varchar(45) DEFAULT NULL,
  `idMonHoc` int NOT NULL,
  `idGiangVien` int NOT NULL,
  `thu` varchar(45) DEFAULT NULL,
  `tiet` varchar(45) DEFAULT NULL,
  `hocki` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`,`idMonHoc`,`idGiangVien`),
  KEY `fk_LopHocPhan_MonHoc1` (`idMonHoc`),
  KEY `fk_LopHocPhan_GiangVien1` (`idGiangVien`),
  CONSTRAINT `fk_LopHocPhan_GiangVien1` FOREIGN KEY (`idGiangVien`) REFERENCES `giangvien` (`id`),
  CONSTRAINT `fk_LopHocPhan_MonHoc1` FOREIGN KEY (`idMonHoc`) REFERENCES `monhoc` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `lophocphan`
--

LOCK TABLES `lophocphan` WRITE;
/*!40000 ALTER TABLE `lophocphan` DISABLE KEYS */;
INSERT INTO `lophocphan` VALUES (1,'CNTT',1,1,'2','3','1');
/*!40000 ALTER TABLE `lophocphan` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `monhoc`
--

DROP TABLE IF EXISTS `monhoc`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `monhoc` (
  `id` int NOT NULL AUTO_INCREMENT,
  `tenMonHoc` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `tenChuyenNganh` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `monhoc`
--

LOCK TABLES `monhoc` WRITE;
/*!40000 ALTER TABLE `monhoc` DISABLE KEYS */;
INSERT INTO `monhoc` VALUES (1,'Toan','CNTT');
/*!40000 ALTER TABLE `monhoc` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ngaynghihoc`
--

DROP TABLE IF EXISTS `ngaynghihoc`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `ngaynghihoc` (
  `id` int NOT NULL AUTO_INCREMENT,
  `ngayNghi` date DEFAULT NULL,
  `coPhep` tinyint DEFAULT NULL,
  `idSinhVien_LopHocPhan` int NOT NULL,
  PRIMARY KEY (`id`,`idSinhVien_LopHocPhan`),
  KEY `fk_NgayNghiHoc_SinhVien_LopHocPhan1` (`idSinhVien_LopHocPhan`),
  CONSTRAINT `fk_NgayNghiHoc_SinhVien_LopHocPhan1` FOREIGN KEY (`idSinhVien_LopHocPhan`) REFERENCES `sinhvien_lophocphan` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ngaynghihoc`
--

LOCK TABLES `ngaynghihoc` WRITE;
/*!40000 ALTER TABLE `ngaynghihoc` DISABLE KEYS */;
/*!40000 ALTER TABLE `ngaynghihoc` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `phuhuynh`
--

DROP TABLE IF EXISTS `phuhuynh`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `phuhuynh` (
  `id` int NOT NULL AUTO_INCREMENT,
  `hoTen` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `diaChi` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `gioiTinh` tinyint DEFAULT NULL,
  `soDienThoai` varchar(15) NOT NULL,
  `email` varchar(50) DEFAULT NULL,
  `idTaiKhoan` int NOT NULL,
  `ngaySua` datetime DEFAULT NULL,
  `ngayTao` datetime DEFAULT NULL,
  `trangThai` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`,`idTaiKhoan`),
  UNIQUE KEY `id_UNIQUE` (`id`),
  UNIQUE KEY `soDienThoai_UNIQUE` (`soDienThoai`),
  UNIQUE KEY `idTaiKhoan_UNIQUE` (`idTaiKhoan`),
  UNIQUE KEY `email_UNIQUE` (`email`),
  CONSTRAINT `fk_phuhuynh_taikhoan1` FOREIGN KEY (`idTaiKhoan`) REFERENCES `taikhoan` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `phuhuynh`
--

LOCK TABLES `phuhuynh` WRITE;
/*!40000 ALTER TABLE `phuhuynh` DISABLE KEYS */;
INSERT INTO `phuhuynh` VALUES (2,'string','string',1,'+840393264509','string',22,'2021-12-07 10:59:40','2021-12-07 10:59:40','HOAT_DONG');
/*!40000 ALTER TABLE `phuhuynh` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sinhvien`
--

DROP TABLE IF EXISTS `sinhvien`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `sinhvien` (
  `id` int NOT NULL AUTO_INCREMENT,
  `maSinhVien` varchar(10) NOT NULL,
  `hoTen` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `diaChi` varchar(100) DEFAULT NULL,
  `gioiTinh` tinyint NOT NULL,
  `soDienThoai` varchar(15) NOT NULL,
  `email` varchar(100) NOT NULL,
  `idLop` int DEFAULT NULL,
  `chuyenNganh` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `ngaySua` date DEFAULT NULL,
  `ngayTao` date DEFAULT NULL,
  `idPhuHuynh` int DEFAULT NULL,
  `idTaiKhoan` int NOT NULL,
  `trangThai` varchar(255) DEFAULT NULL,
  `imgUrl` varchar(1000) DEFAULT NULL,
  PRIMARY KEY (`id`,`idTaiKhoan`),
  UNIQUE KEY `id_UNIQUE` (`id`),
  UNIQUE KEY `taikhoan_id_UNIQUE` (`idTaiKhoan`),
  UNIQUE KEY `soDienThoai_UNIQUE` (`soDienThoai`),
  UNIQUE KEY `email_UNIQUE` (`email`),
  KEY `fk_SinhVien_PhuHuynh1` (`idPhuHuynh`),
  KEY `FK3b7wr08416aalvr51xnfoemhj` (`idLop`),
  CONSTRAINT `FK3b7wr08416aalvr51xnfoemhj` FOREIGN KEY (`idLop`) REFERENCES `lop` (`id`),
  CONSTRAINT `fk_SinhVien_PhuHuynh1` FOREIGN KEY (`idPhuHuynh`) REFERENCES `phuhuynh` (`id`),
  CONSTRAINT `fk_sinhvien_taikhoan1` FOREIGN KEY (`idTaiKhoan`) REFERENCES `taikhoan` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sinhvien`
--

LOCK TABLES `sinhvien` WRITE;
/*!40000 ALTER TABLE `sinhvien` DISABLE KEYS */;
INSERT INTO `sinhvien` VALUES (2,'sv68a0','Pham Quoc Toan','Trường sa',1,'+840364583782','phamvuthuytrang08032000@gmail.com',1,'CNTT','2021-12-09','2021-11-28',2,2,'DANG_HOC','https://s3.ap-southeast-1.amazonaws.com/khoaluantotnghiep/1638983650768-22688618_116276765803450_1334844269139916723_n.jpg'),(3,'svd157','Pham Quoc Toan','Hoang Hoa Tham',1,'0123456789','phamquoctoan1@gmail.com',1,NULL,'2021-12-05','2021-12-05',NULL,4,'DANG_HOC','https://khoaluantotnghiep.s3.ap-southeast-1.amazonaws.com/avatar.jpg'),(4,'sv9ba1','Pham Quoc Toan2','Hoang Hoa Tham2',1,'0123456782','phamquoctoan2@gmail.com',1,NULL,'2021-12-05','2021-12-05',NULL,5,'DANG_HOC','https://khoaluantotnghiep.s3.ap-southeast-1.amazonaws.com/avatar.jpg'),(5,'sv64be','Pham Quoc Toan3','Hoang Hoa Tham3',1,'0123456784','phamquoctoan3@gmail.com',1,NULL,'2021-12-05','2021-12-05',NULL,6,'DANG_HOC','https://khoaluantotnghiep.s3.ap-southeast-1.amazonaws.com/avatar.jpg'),(6,'sv02de','Pham Quoc Toan4','Hoang Hoa Tham4',1,'0123456785','phamquoctoan4@gmail.com',1,NULL,'2021-12-05','2021-12-05',NULL,7,'DANG_HOC','https://khoaluantotnghiep.s3.ap-southeast-1.amazonaws.com/avatar.jpg'),(8,'sv7e27','Pham Quoc Toan6','Hoang Hoa Tham6',1,'0123456786','phamquoctoan6@gmail.com',1,NULL,'2021-12-05','2021-12-05',NULL,9,'DANG_HOC','https://khoaluantotnghiep.s3.ap-southeast-1.amazonaws.com/avatar.jpg'),(12,'sv5c7a','Pham Quoc Toan11','Hoang Hoa Tham1',1,'01234567811','phamquoctoan11gmail.com',1,NULL,'2021-12-05','2021-12-05',NULL,13,'DANG_HOC','https://khoaluantotnghiep.s3.ap-southeast-1.amazonaws.com/avatar.jpg'),(13,'sv168d','Pham Quoc Toanss','Hoang Hoa Thamss',1,'012345678ss','phamquoctoanssgmail.com',1,NULL,'2021-12-05','2021-12-05',NULL,14,'DANG_HOC','https://khoaluantotnghiep.s3.ap-southeast-1.amazonaws.com/avatar.jpg'),(17,'sv29a0','Pham Quoc Toanss','Hoang Hoa Thamss',1,'012345678qq','phamquoctoanqqgmail.com',1,NULL,'2021-12-05','2021-12-05',NULL,18,'DANG_HOC','https://khoaluantotnghiep.s3.ap-southeast-1.amazonaws.com/avatar.jpg'),(18,'svfcb0','Pham Quoc Toanss','Hoang Hoa Thamss',1,'012345678xx','phamquoctoanxxgmail.com',1,NULL,'2021-12-05','2021-12-05',NULL,19,'DANG_HOC','https://khoaluantotnghiep.s3.ap-southeast-1.amazonaws.com/avatar.jpg');
/*!40000 ALTER TABLE `sinhvien` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sinhvien_lophocphan`
--

DROP TABLE IF EXISTS `sinhvien_lophocphan`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `sinhvien_lophocphan` (
  `id` int NOT NULL AUTO_INCREMENT,
  `trangThai` tinyint DEFAULT NULL,
  `idSinhVien` int NOT NULL,
  `idLopHocPhan` int NOT NULL,
  PRIMARY KEY (`id`,`idSinhVien`,`idLopHocPhan`),
  KEY `fk_SinhVien_LopHocPhan_sinhvien1` (`idSinhVien`),
  KEY `fk_SinhVien_LopHocPhan_LopHocPhan1` (`idLopHocPhan`),
  CONSTRAINT `fk_SinhVien_LopHocPhan_LopHocPhan1` FOREIGN KEY (`idLopHocPhan`) REFERENCES `lophocphan` (`id`),
  CONSTRAINT `fk_SinhVien_LopHocPhan_sinhvien1` FOREIGN KEY (`idSinhVien`) REFERENCES `sinhvien` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sinhvien_lophocphan`
--

LOCK TABLES `sinhvien_lophocphan` WRITE;
/*!40000 ALTER TABLE `sinhvien_lophocphan` DISABLE KEYS */;
INSERT INTO `sinhvien_lophocphan` VALUES (2,1,2,1);
/*!40000 ALTER TABLE `sinhvien_lophocphan` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `taikhoan`
--

DROP TABLE IF EXISTS `taikhoan`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `taikhoan` (
  `id` int NOT NULL AUTO_INCREMENT,
  `tenDangNhap` varchar(45) NOT NULL,
  `matKhau` varchar(150) NOT NULL,
  `role` varchar(10) NOT NULL,
  `ngayTao` date NOT NULL,
  `ngaySua` date NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`),
  UNIQUE KEY `tenDangNhap_UNIQUE` (`tenDangNhap`)
) ENGINE=InnoDB AUTO_INCREMENT=23 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `taikhoan`
--

LOCK TABLES `taikhoan` WRITE;
/*!40000 ALTER TABLE `taikhoan` DISABLE KEYS */;
INSERT INTO `taikhoan` VALUES (2,'sv68a0','$2a$10$x3ZcaGC1tH.JenEJBFj3tu71I1B/QL2KHbgN9D2nfpfs/clKJIGVa','SINH_VIEN','2021-11-28','2021-12-08'),(3,'gv5e02','$2a$10$NMtQiufQp1sqZOV4JR3ua.2hMGqIYcwRbXEXA5Xgf4paB1Jb0ImcG','GIANG_VIEN','2021-11-28','2021-11-28'),(4,'svd157','$2a$10$ix9JAAnngv1nnu/KB7089.QjFdG7i0m./Wa4F.sEJO0Uik8wECAum','SINH_VIEN','2021-12-05','2021-12-05'),(5,'sv9ba1','$2a$10$YzL.PhhW8QNanjRz4orO7eaz/yYKUHGhJgDpXFgx0qSmumZfp7F22','SINH_VIEN','2021-12-05','2021-12-05'),(6,'sv64be','$2a$10$G.rUJT73If19GkB3h7W/iumGSyMUWoX1JXiBOvnKDeZDcrx6So0Di','SINH_VIEN','2021-12-05','2021-12-05'),(7,'sv02de','$2a$10$NEzmWJp/Aiw5xun0oLijeuQzLyfHGHE8zbbqHBnx5v8XTWGzlJmw.','SINH_VIEN','2021-12-05','2021-12-05'),(9,'sv7e27','$2a$10$etp70PmJHhfW08VPVmW70OpPv1YHqRn6golKVIQszNGRgTl5a7nfq','SINH_VIEN','2021-12-05','2021-12-05'),(13,'sv5c7a','$2a$10$.WI5nIWjLog4LZS97bnqaumfuDrViASZym6iiF2ivsrk0b6H62cui','SINH_VIEN','2021-12-05','2021-12-05'),(14,'sv168d','$2a$10$8dobYGEtgw1DgIU79WhYM.SVqlremUQWERHFuqpVGq5bzxhMT1qbG','SINH_VIEN','2021-12-05','2021-12-05'),(18,'sv29a0','$2a$10$bOTBk2b9M0b/l3AHhQ5pIOCXj7A1jWQkHfg/nVvs7j5VDk0ejf93a','SINH_VIEN','2021-12-05','2021-12-05'),(19,'svfcb0','$2a$10$NDJXcuDZkGAAS3/AbavtBe3IYdpf9U6GdJ6SqX8QYX2mXlmcExRri','SINH_VIEN','2021-12-05','2021-12-05'),(22,'+840393264509','$2a$10$kTI4Yl7gh2SpAaeUEf07Vuv4.yypY8iG7awIzqXrz5PdHZHQGr7Cm','PHU_HUYNH','2021-12-07','2021-12-07');
/*!40000 ALTER TABLE `taikhoan` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `thongbao`
--

DROP TABLE IF EXISTS `thongbao`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `thongbao` (
  `id` int NOT NULL AUTO_INCREMENT,
  `ngayTao` date DEFAULT NULL,
  `noiDung` varchar(1000) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `tieuDe` varchar(1000) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `idGiangVien` int NOT NULL,
  `trangThai` tinyint DEFAULT NULL,
  `ngaySua` date DEFAULT NULL,
  `hienThi` tinyint DEFAULT NULL,
  PRIMARY KEY (`id`,`idGiangVien`),
  UNIQUE KEY `id_UNIQUE` (`id`),
  KEY `fk_ThongBao_GiangVien1` (`idGiangVien`),
  CONSTRAINT `fk_ThongBao_GiangVien1` FOREIGN KEY (`idGiangVien`) REFERENCES `giangvien` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `thongbao`
--

LOCK TABLES `thongbao` WRITE;
/*!40000 ALTER TABLE `thongbao` DISABLE KEYS */;
INSERT INTO `thongbao` VALUES (1,'2020-01-02','Thông báo V/v tiếp tục nghỉ học đối với học viên và sinh viên để phòng, chống dịch bệnh viêm đường hô hấp cấp do chủng mới của virus Corona gây ra','BẢNG TỔNG HỢP ĐĂNG KÝ GIẢNG DẠY TRỰC TUYẾN (từ ngày 06/04/2020)',1,1,NULL,1),(2,'2020-01-02','Thông báo V/v tiếp tục nghỉ học đối với học viên và sinh viên để phòng, chống dịch bệnh viêm đường hô hấp cấp do chủng mới của virus Corona gây ra','Thông báo V/v tiếp tục nghỉ học đối với học viên và sinh viên để phòng, chống dịch bệnh viêm đường hô hấp cấp do chủng mới của virus Corona gây ra',1,1,NULL,1),(3,'2020-01-02','Vào sáng 13/12/2019, tại Hội trường E4 - Trường Đại học Công Nghiệp Thành phố Hồ Chí Minh (IUH) đã diễn ra buổi Hội thảo với chủ đề “Tự chủ tài chính trong trường Đại học: Kinh nghiệm quốc tế và ứng dụng vào Việt Nam”. Hội thảo do Ngân hàng Thế giới, Ban Quản lí dự án Nâng cao chất lượng giáo dục đại học (SAHEP) phối hợp cùng IUH thực hiện. Đến dự với hội thảo có sự tham dự của chuyên gia cấp cao về giáo dục của Ngân hàng Thế giới, Thành viên ban quản lý dự ánSAHEP của Bộ Giáo dục Đào tạo và các trường thành viên, cùng Ban Giám hiệu các trường có mối quan tâm đến chủ đề hội thảo.','Hội thảo quốc tế: Tự chủ tài chính trong trường Đại học: Kinh nghiệm quốc tế và ứng dụng vào Việt Nam',1,0,NULL,0),(4,'2020-12-16','4','aaaaa',1,1,NULL,1),(5,NULL,'5','aaaaa',1,1,NULL,1),(6,NULL,'6','aaaaa',1,1,NULL,1),(7,NULL,'7','aaaaa',1,1,NULL,1),(8,NULL,'11111111111111111111111111111111111111111111111111111111111111111','aaaaa',1,1,NULL,1),(9,'2021-12-06','chinh sua','chinh sua',1,1,'2021-12-07',0),(10,'2021-12-06','Acosc gi day','ahihihiTest21231',1,1,'2021-12-07',0),(11,'2021-12-06','đừng sợ','Cô test thông báo nha ,không có gì đâu',1,1,'2021-12-09',1),(12,'2021-12-06','Đừng sợ , cô test ','AhuhuD',1,1,'2021-12-07',1),(13,'2021-12-06','aaaaaaaasssssssssss','adasd',1,1,'2021-12-06',1),(14,'2021-12-06','ádasdasd','aaa',1,0,'2021-12-06',1),(15,'2021-12-09','123123123','Ahihi co nè',1,0,'2021-12-09',1);
/*!40000 ALTER TABLE `thongbao` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `thongbao_lop`
--

DROP TABLE IF EXISTS `thongbao_lop`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `thongbao_lop` (
  `id` int NOT NULL AUTO_INCREMENT,
  `idLop` int NOT NULL,
  `idThongBao` int NOT NULL,
  PRIMARY KEY (`id`,`idLop`,`idThongBao`),
  KEY `fk_ThongBao_Lop_Lop1` (`idLop`),
  KEY `fk_ThongBao_Lop_ThongBao1` (`idThongBao`),
  CONSTRAINT `fk_ThongBao_Lop_Lop1` FOREIGN KEY (`idLop`) REFERENCES `lop` (`id`),
  CONSTRAINT `fk_ThongBao_Lop_ThongBao1` FOREIGN KEY (`idThongBao`) REFERENCES `thongbao` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `thongbao_lop`
--

LOCK TABLES `thongbao_lop` WRITE;
/*!40000 ALTER TABLE `thongbao_lop` DISABLE KEYS */;
INSERT INTO `thongbao_lop` VALUES (1,1,1),(2,1,9),(3,1,10),(4,1,11),(5,1,12),(6,1,13),(7,1,14),(8,1,15);
/*!40000 ALTER TABLE `thongbao_lop` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `thongbao_lophocphan`
--

DROP TABLE IF EXISTS `thongbao_lophocphan`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `thongbao_lophocphan` (
  `id` int NOT NULL AUTO_INCREMENT,
  `idThongBao` int NOT NULL,
  `idLopHocPhan` int NOT NULL,
  PRIMARY KEY (`id`,`idThongBao`,`idLopHocPhan`),
  KEY `fk_ThongBao_LopHocPhan_ThongBao2` (`idThongBao`),
  KEY `fk_ThongBao_LopHocPhan_LopHocPhan2` (`idLopHocPhan`),
  CONSTRAINT `fk_ThongBao_LopHocPhan_LopHocPhan2` FOREIGN KEY (`idLopHocPhan`) REFERENCES `lophocphan` (`id`),
  CONSTRAINT `fk_ThongBao_LopHocPhan_ThongBao2` FOREIGN KEY (`idThongBao`) REFERENCES `thongbao` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `thongbao_lophocphan`
--

LOCK TABLES `thongbao_lophocphan` WRITE;
/*!40000 ALTER TABLE `thongbao_lophocphan` DISABLE KEYS */;
INSERT INTO `thongbao_lophocphan` VALUES (1,1,1),(2,2,1),(3,3,1),(4,4,1),(5,5,1),(6,6,1),(7,7,1),(8,8,1);
/*!40000 ALTER TABLE `thongbao_lophocphan` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-12-09  0:47:28
