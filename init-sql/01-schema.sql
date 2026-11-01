-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jul 01, 2026 at 07:42 PM
-- Server version: 10.4.32-MariaDB
-- PHP Version: 8.2.12

SET FOREIGN_KEY_CHECKS=0;
SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `quanlysieuthi`
--
DROP DATABASE IF EXISTS `quanlysieuthi`;
CREATE DATABASE IF NOT EXISTS `quanlysieuthi` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci;
USE `quanlysieuthi`;

-- --------------------------------------------------------

--
-- Table structure for table `chitietdonhang`
--

DROP TABLE IF EXISTS `chitietdonhang`;
CREATE TABLE IF NOT EXISTS `chitietdonhang` (
  `madonhang` varchar(50) DEFAULT NULL,
  `masanpham` varchar(50) DEFAULT NULL,
  `tensanpham` varchar(50) DEFAULT NULL,
  `soluong` int(11) DEFAULT NULL,
  `dongia` decimal(10,0) DEFAULT NULL,
  `thanhtien` decimal(10,0) DEFAULT NULL,
  KEY `madonhang` (`madonhang`),
  KEY `masanpham` (`masanpham`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Truncate table before insert `chitietdonhang`
--

TRUNCATE TABLE `chitietdonhang`;
--
-- Dumping data for table `chitietdonhang`
--

INSERT INTO `chitietdonhang` (`madonhang`, `masanpham`, `tensanpham`, `soluong`, `dongia`, `thanhtien`) VALUES
('mdh04', 'SP03', 'bánh ngọt chocopice', 1, 1000000, 1000000);

-- --------------------------------------------------------

--
-- Table structure for table `chucvu`
--

DROP TABLE IF EXISTS `chucvu`;
CREATE TABLE IF NOT EXISTS `chucvu` (
  `machucvu` varchar(50) NOT NULL,
  `tenchucvu` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`machucvu`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Truncate table before insert `chucvu`
--

TRUNCATE TABLE `chucvu`;
--
-- Dumping data for table `chucvu`
--

INSERT INTO `chucvu` (`machucvu`, `tenchucvu`) VALUES
('CV01', 'Quản lý'),
('CV02', 'Nhân viên bán hàng'),
('CV03', 'Thu ngân'),
('CV04', 'Kho'),
('CV05', 'Kế toán'),
('CV06', 'Quản lý'),
('CV07', 'giám đốc điều hành');

-- --------------------------------------------------------

--
-- Table structure for table `donhang`
--

DROP TABLE IF EXISTS `donhang`;
CREATE TABLE IF NOT EXISTS `donhang` (
  `madonhang` varchar(50) NOT NULL,
  `makhachhang` varchar(50) DEFAULT NULL,
  `manhanvien` varchar(50) DEFAULT NULL,
  `makhuyenmai` varchar(50) DEFAULT NULL,
  `ngaylap` datetime DEFAULT current_timestamp(),
  `phuongthucban` varchar(50) DEFAULT NULL,
  `thanhtoan` varchar(50) DEFAULT NULL,
  `tongtien` decimal(10,0) DEFAULT 0,
  PRIMARY KEY (`madonhang`),
  KEY `makhachhang` (`makhachhang`),
  KEY `manhanvien` (`manhanvien`),
  KEY `makhuyenmai` (`makhuyenmai`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Truncate table before insert `donhang`
--

TRUNCATE TABLE `donhang`;
--
-- Dumping data for table `donhang`
--

INSERT INTO `donhang` (`madonhang`, `makhachhang`, `manhanvien`, `makhuyenmai`, `ngaylap`, `phuongthucban`, `thanhtoan`, `tongtien`) VALUES
('mdh04', 'KH001', 'NV01', NULL, '2026-05-10 07:00:00', 'Online', 'Tiền mặt', 900000);

-- --------------------------------------------------------

--
-- Table structure for table `hangthanhvien`
--

DROP TABLE IF EXISTS `hangthanhvien`;
CREATE TABLE IF NOT EXISTS `hangthanhvien` (
  `makhachhang` varchar(50) NOT NULL,
  `tenkhachhang` varchar(50) NOT NULL,
  `Tenhang` varchar(50) NOT NULL,
  PRIMARY KEY (`makhachhang`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Truncate table before insert `hangthanhvien`
--

TRUNCATE TABLE `hangthanhvien`;
-- --------------------------------------------------------

--
-- Table structure for table `khachhang`
--

DROP TABLE IF EXISTS `khachhang`;
CREATE TABLE IF NOT EXISTS `khachhang` (
  `makhachhang` varchar(20) NOT NULL,
  `tenkhachhang` varchar(100) NOT NULL,
  `gioitinh` varchar(10) DEFAULT NULL,
  `ngaysinh` date DEFAULT NULL,
  `diachi` varchar(255) DEFAULT NULL,
  `email` varchar(100) DEFAULT NULL,
  `sdt` int(11) DEFAULT NULL,
  `diemtichluy` int(11) DEFAULT 0,
  `hangthanhvien` varchar(50) DEFAULT 'Chưa xếp hạng',
  `diemhientai` int(11) DEFAULT 0,
  PRIMARY KEY (`makhachhang`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Truncate table before insert `khachhang`
--

TRUNCATE TABLE `khachhang`;
--
-- Dumping data for table `khachhang`
--

INSERT INTO `khachhang` (`makhachhang`, `tenkhachhang`, `gioitinh`, `ngaysinh`, `diachi`, `email`, `sdt`, `diemtichluy`, `hangthanhvien`, `diemhientai`) VALUES
('KH001', 'Nguyễn Đình Chiểu', 'Nam', '1990-01-01', 'Hà Nội', 'nguyendinhchieu@gmail.com', 2312631, 100, 'Chưa xếp hạng', 0),
('KH002', 'Đặng Trần Tùng', 'Nam', '1995-05-20', 'Đà Nẵng', 'trantung@gmail.com', 123557, 50, 'Chưa xếp hạng', 0),
('KH003', 'Lê Tuấn Kiệt', 'Nam', '2005-06-09', 'Lạng Sơn', 'ltk@gmail.com', 91326688, 5000, 'Chưa xếp hạng', 0);

-- --------------------------------------------------------

--
-- Table structure for table `khuyenmai`
--

DROP TABLE IF EXISTS `khuyenmai`;
CREATE TABLE IF NOT EXISTS `khuyenmai` (
  `makhuyenmai` varchar(50) NOT NULL,
  `tenkhuyenmai` varchar(50) DEFAULT NULL,
  `mota` varchar(200) DEFAULT NULL,
  `sotiengiam` int(11) DEFAULT NULL,
  `ngaytao` date DEFAULT NULL,
  PRIMARY KEY (`makhuyenmai`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Truncate table before insert `khuyenmai`
--

TRUNCATE TABLE `khuyenmai`;
--
-- Dumping data for table `khuyenmai`
--

INSERT INTO `khuyenmai` (`makhuyenmai`, `tenkhuyenmai`, `mota`, `sotiengiam`, `ngaytao`) VALUES
('KM01', 'Giảm giá 10%', 'Giảm 10% cho tất cả sản phẩm', 10000, '2025-01-01'),
('KM02', 'Tết 2025', 'Khuyến mãi dịp Tết Nguyên Đán', 20000, '2025-01-15'),
('KM03', 'Khách hàng thân thiết', 'Ưu đãi cho khách hàng VIP', 30000, '2025-02-01'),
('KM04', 'Mua 1 tặng 1', 'Áp dụng cho sản phẩm chọn lọc', 50000, '2025-02-10'),
('KM05', 'Black Friday', 'Giảm sâu cuối năm', 100000, '2025-11-25');

-- --------------------------------------------------------

--
-- Table structure for table `lichsudoiqua`
--

DROP TABLE IF EXISTS `lichsudoiqua`;
CREATE TABLE IF NOT EXISTS `lichsudoiqua` (
  `magiaodich` int(11) NOT NULL AUTO_INCREMENT,
  `makhachhang` varchar(20) NOT NULL,
  `tenqua` varchar(100) NOT NULL,
  `diemtru` int(11) NOT NULL,
  `thoigian` datetime NOT NULL,
  PRIMARY KEY (`magiaodich`),
  KEY `makhachhang` (`makhachhang`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Truncate table before insert `lichsudoiqua`
--

TRUNCATE TABLE `lichsudoiqua`;
--
-- Dumping data for table `lichsudoiqua`
--

INSERT INTO `lichsudoiqua` (`magiaodich`, `makhachhang`, `tenqua`, `diemtru`, `thoigian`) VALUES
(1, 'KH003', 'Mũ Bảo Hiểm 3/4', 1000, '2026-05-10 11:33:09');

-- --------------------------------------------------------

--
-- Table structure for table `loaihang`
--

DROP TABLE IF EXISTS `loaihang`;
CREATE TABLE IF NOT EXISTS `loaihang` (
  `maloai` varchar(50) NOT NULL,
  `tenloai` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`maloai`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Truncate table before insert `loaihang`
--

TRUNCATE TABLE `loaihang`;
--
-- Dumping data for table `loaihang`
--

INSERT INTO `loaihang` (`maloai`, `tenloai`) VALUES
('L01', 'Rau củ'),
('L02', 'Đồ uống'),
('L03', 'Bánh kẹo'),
('L04', 'Đồ đông lạnh');

-- --------------------------------------------------------

--
-- Table structure for table `nhacungcap`
--

DROP TABLE IF EXISTS `nhacungcap`;
CREATE TABLE IF NOT EXISTS `nhacungcap` (
  `manhacungcap` varchar(50) NOT NULL,
  `tennhacungcap` varchar(100) DEFAULT NULL,
  `loaihinh` varchar(50) DEFAULT NULL,
  `email` varchar(100) DEFAULT NULL,
  `sodienthoai` varchar(20) DEFAULT NULL,
  `diachi` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`manhacungcap`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Truncate table before insert `nhacungcap`
--

TRUNCATE TABLE `nhacungcap`;
--
-- Dumping data for table `nhacungcap`
--

INSERT INTO `nhacungcap` (`manhacungcap`, `tennhacungcap`, `loaihinh`, `email`, `sodienthoai`, `diachi`) VALUES
('NCC01', 'Vinamilk', 'Doanh nghiệp', 'contact@vinamilk.com', '028123456', 'TP.HCM'),
('NCC02', 'Nông trại A', 'Cá nhân', 'nongtrai@gmail.com', '0912345678', 'Đà Lạt'),
('NCC03', 'Nông trại B', 'Doanh nghiệp', 'bfa@gmail.com', '099999999', 'bắc ninh');

-- --------------------------------------------------------

--
-- Table structure for table `nhanvien`
--

DROP TABLE IF EXISTS `nhanvien`;
CREATE TABLE IF NOT EXISTS `nhanvien` (
  `manhanvien` varchar(50) NOT NULL,
  `tennhanvien` varchar(50) DEFAULT NULL,
  `ngaysinh` date DEFAULT NULL,
  `gioitinh` varchar(10) DEFAULT NULL,
  `sodienthoai` varchar(50) DEFAULT NULL,
  `email` varchar(50) DEFAULT NULL,
  `diachi` varchar(255) DEFAULT NULL,
  `machucvu` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`manhanvien`),
  KEY `machucvu` (`machucvu`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Truncate table before insert `nhanvien`
--

TRUNCATE TABLE `nhanvien`;
--
-- Dumping data for table `nhanvien`
--

INSERT INTO `nhanvien` (`manhanvien`, `tennhanvien`, `ngaysinh`, `gioitinh`, `sodienthoai`, `email`, `diachi`, `machucvu`) VALUES
('NV01', 'Hoàng Hải Nam', '1995-03-12', 'Nam', '0901111111', 'nam@gmail.com', 'Hà Nội', 'CV01'),
('NV02', 'Nguyễn Thị A', '1997-07-21', 'Nữ', '0902222222', 'a@gmail.com', 'TP HCM', 'CV02'),
('NV03', 'Nguyễn Việt Hoàng', '1993-11-05', 'Nam', '0903333333', 'hoang@gmail.com', 'Đà Nẵng', 'CV03'),
('NV04', 'Lê Tấn Khang', '1998-02-18', 'Nam', '0904444444', 'khang@gmail.com', 'Hải Phòng', 'CV04'),
('NV05', 'Vũ Hùng Hải', '1996-09-30', 'Nam', '0905555555', 'hai@gmail.com', 'Cần Thơ', 'CV05');

-- --------------------------------------------------------

--
-- Table structure for table `quatang`
--

DROP TABLE IF EXISTS `quatang`;
CREATE TABLE IF NOT EXISTS `quatang` (
  `maqua` varchar(20) NOT NULL,
  `tenqua` varchar(100) NOT NULL,
  `diemycau` int(11) NOT NULL,
  `mota` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`maqua`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Truncate table before insert `quatang`
--

TRUNCATE TABLE `quatang`;
--
-- Dumping data for table `quatang`
--

INSERT INTO `quatang` (`maqua`, `tenqua`, `diemycau`, `mota`) VALUES
('Q01', 'Mũ Bảo Hiểm 3/4', 1000, 'An toàn, kính chống tia UV'),
('Q02', 'Nồi chiên không dầu Elmich', 2500, 'Tiện lợi, chống dính, đa năng'),
('Q03', 'Túi Đeo Chéo Thời Trang', 1200, 'Chống nước, nhiều ngăn'),
('Q04', 'Balo Laptop Cao Cấp', 5000, 'Chống sốc, bảo hành 1 năm');

-- --------------------------------------------------------

--
-- Table structure for table `sanpham`
--

DROP TABLE IF EXISTS `sanpham`;
CREATE TABLE IF NOT EXISTS `sanpham` (
  `masanpham` varchar(50) NOT NULL,
  `tensanpham` varchar(100) DEFAULT NULL,
  `maloai` varchar(50) DEFAULT NULL,
  `manhacungcap` varchar(50) DEFAULT NULL,
  `xuatxu` varchar(100) DEFAULT NULL,
  `soluong` int(11) DEFAULT 0,
  `ngaysanxuat` date DEFAULT NULL,
  `hansudung` date DEFAULT NULL,
  `tinhtrang` varchar(50) DEFAULT NULL,
  `gianhap` decimal(10,0) DEFAULT 0,
  `giaban` decimal(10,0) DEFAULT 0,
  `donvitinh` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`masanpham`),
  KEY `maloai` (`maloai`),
  KEY `manhacungcap` (`manhacungcap`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Truncate table before insert `sanpham`
--

TRUNCATE TABLE `sanpham`;
--
-- Dumping data for table `sanpham`
--

INSERT INTO `sanpham` (`masanpham`, `tensanpham`, `maloai`, `manhacungcap`, `xuatxu`, `soluong`, `ngaysanxuat`, `hansudung`, `tinhtrang`, `gianhap`, `giaban`, `donvitinh`) VALUES
('SP01', 'Sữa tươi tiệt trùng', 'L02', 'NCC01', 'Việt Nam', 100, '2023-10-01', '2024-04-01', 'Tốt', 25000, 30000, 'Hộp'),
('SP02', 'Cà chua Đà Lạt', 'L01', 'NCC02', 'Việt Nam', 50, '2023-12-29', '2024-01-05', 'Tốt', 15000, 20000, 'Kg'),
('SP03', 'bánh ngọt chocopice', 'L01', 'NCC02', 'Việt Nam', 4, '2026-05-16', '2026-05-23', 'Tốt', 200, 1000000, 'Hộp'),
('sp04', 'NƯỚC NGỌT', 'L01', 'NCC01', 'lục', 1, '2005-02-10', '2006-02-10', 'Tốt', 4, 5, 'kg');

-- --------------------------------------------------------

--
-- Table structure for table `taikhoan`
--

DROP TABLE IF EXISTS `taikhoan`;
CREATE TABLE IF NOT EXISTS `taikhoan` (
  `taikhoan` varchar(50) NOT NULL,
  `matkhau` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`taikhoan`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Truncate table before insert `taikhoan`
--

TRUNCATE TABLE `taikhoan`;
--
-- Dumping data for table `taikhoan`
--

INSERT INTO `taikhoan` (`taikhoan`, `matkhau`) VALUES
('admin', 'admin');

--
-- Constraints for dumped tables
--

--
-- Constraints for table `chitietdonhang`
--
ALTER TABLE `chitietdonhang`
  ADD CONSTRAINT `chitietdonhang_ibfk_1` FOREIGN KEY (`madonhang`) REFERENCES `donhang` (`madonhang`),
  ADD CONSTRAINT `chitietdonhang_ibfk_2` FOREIGN KEY (`masanpham`) REFERENCES `sanpham` (`masanpham`);

--
-- Constraints for table `donhang`
--
ALTER TABLE `donhang`
  ADD CONSTRAINT `donhang_ibfk_1` FOREIGN KEY (`makhachhang`) REFERENCES `khachhang` (`makhachhang`),
  ADD CONSTRAINT `donhang_ibfk_2` FOREIGN KEY (`manhanvien`) REFERENCES `nhanvien` (`manhanvien`),
  ADD CONSTRAINT `donhang_ibfk_3` FOREIGN KEY (`makhuyenmai`) REFERENCES `khuyenmai` (`makhuyenmai`);

--
-- Constraints for table `hangthanhvien`
--
ALTER TABLE `hangthanhvien`
  ADD CONSTRAINT `hangthanhvien_ibfk_1` FOREIGN KEY (`makhachhang`) REFERENCES `khachhang` (`makhachhang`);

--
-- Constraints for table `lichsudoiqua`
--
ALTER TABLE `lichsudoiqua`
  ADD CONSTRAINT `lichsudoiqua_ibfk_1` FOREIGN KEY (`makhachhang`) REFERENCES `khachhang` (`makhachhang`);

--
-- Constraints for table `nhanvien`
--
ALTER TABLE `nhanvien`
  ADD CONSTRAINT `nhanvien_ibfk_1` FOREIGN KEY (`machucvu`) REFERENCES `chucvu` (`machucvu`);

--
-- Constraints for table `sanpham`
--
ALTER TABLE `sanpham`
  ADD CONSTRAINT `sanpham_ibfk_1` FOREIGN KEY (`maloai`) REFERENCES `loaihang` (`maloai`),
  ADD CONSTRAINT `sanpham_ibfk_2` FOREIGN KEY (`manhacungcap`) REFERENCES `nhacungcap` (`manhacungcap`);
SET FOREIGN_KEY_CHECKS=1;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
