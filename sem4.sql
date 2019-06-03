-- phpMyAdmin SQL Dump
-- version 4.8.5
-- https://www.phpmyadmin.net/
--
-- Máy chủ: 127.0.0.1
-- Thời gian đã tạo: Th6 02, 2019 lúc 08:43 PM
-- Phiên bản máy phục vụ: 10.1.38-MariaDB
-- Phiên bản PHP: 5.6.40

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Cơ sở dữ liệu: `sem4`
--

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `account`
--

CREATE TABLE `account` (
  `id` varchar(30) NOT NULL,
  `userName` varchar(50) NOT NULL,
  `passWord` text NOT NULL,
  `salt` text NOT NULL,
  `createdAt` bigint(50) NOT NULL,
  `updatedAt` bigint(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Đang đổ dữ liệu cho bảng `account`
--

INSERT INTO `account` (`id`, `userName`, `passWord`, `salt`, `createdAt`, `updatedAt`) VALUES
('', 'rootlkjio', 'adminmanager', '', 0, 0),
('A001', 'duyle10', 'xxxxxxxxxxxxxxxx', '1559303214741', 1559303214743, 1559303214743),
('A009', 'rootlkjio', 'adminmanager', '', 211638, 211638),
('A123', 'sang', '123456', '1', 20190524, 20190524),
('A1232', 'sang123', '123456', '1', 20190524, 20190524);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `score`
--

CREATE TABLE `score` (
  `scoreId` int(11) NOT NULL,
  `idSubject` varchar(50) NOT NULL,
  `idStudent` varchar(50) NOT NULL,
  `score` int(2) NOT NULL,
  `accountId` varchar(50) NOT NULL,
  `createdAt` bigint(50) NOT NULL,
  `updatedAt` bigint(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Đang đổ dữ liệu cho bảng `score`
--

INSERT INTO `score` (`scoreId`, `idSubject`, `idStudent`, `score`, `accountId`, `createdAt`, `updatedAt`) VALUES
(1, '223', '12', 5, 'A001', 2019, 2019),
(2, 'M1', 'A003', 23, 'A001', 1559498792611, 1559500161451),
(3, 'M3', 'A003', 23, 'A001', 1559499451944, 1559499451944);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `student`
--

CREATE TABLE `student` (
  `name` text CHARACTER SET utf8 NOT NULL,
  `gender` text CHARACTER SET utf8 NOT NULL,
  `bod` bigint(50) NOT NULL,
  `phone` text NOT NULL,
  `status` int(1) NOT NULL DEFAULT '1',
  `address` text CHARACTER SET utf8 NOT NULL,
  `cmnd` text NOT NULL,
  `email` varchar(50) NOT NULL,
  `mediumScore` float NOT NULL,
  `rollNumber` varchar(50) NOT NULL,
  `accountId` varchar(50) NOT NULL,
  `createdAt` bigint(50) NOT NULL,
  `updatedAt` bigint(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Đang đổ dữ liệu cho bảng `student`
--

INSERT INTO `student` (`name`, `gender`, `bod`, `phone`, `status`, `address`, `cmnd`, `email`, `mediumScore`, `rollNumber`, `accountId`, `createdAt`, `updatedAt`) VALUES
('hoang long22', 'male2', 1321290000000, '091035151', 1, '51 truong dinh', '213213212311', 'long@gmail.com', 9, 'A0002', 'B0002', 132132132132, 1559304324588),
('Dinh Phuoc', 'male', 1576083600000, '09312321', 1, '50 bach khoa', '1232131231', 'phuoc@gmail.com', 8, 'A003', 'B002', 1559307984814, 1559307984814),
('Hoang Sang', 'male', 1576083600000, '0913512124', 1, '104 bach khoa', '13213213', 'sang@gmail.com', 9, 'A019', 'A001', 1559500652486, 1559500662281);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `subject`
--

CREATE TABLE `subject` (
  `id` varchar(50) NOT NULL,
  `name` text CHARACTER SET utf8 NOT NULL,
  `status` int(1) DEFAULT '1',
  `createdAt` bigint(50) NOT NULL,
  `updatedAt` bigint(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Đang đổ dữ liệu cho bảng `subject`
--

INSERT INTO `subject` (`id`, `name`, `status`, `createdAt`, `updatedAt`) VALUES
('M1', 'Math', 1, 1559305898818, 1559500674965),
('M2', 'Technology', 1, 1559307591250, 1559307591250),
('M3', 'Physics', 1, 1559307615751, 1559307615751),
('M4', 'C#', 1, 1559307626102, 1559307626102),
('M5', 'Java', 1, 1559307631338, 1559307631338);

--
-- Chỉ mục cho các bảng đã đổ
--

--
-- Chỉ mục cho bảng `account`
--
ALTER TABLE `account`
  ADD PRIMARY KEY (`id`),
  ADD KEY `userName` (`userName`),
  ADD KEY `createdAt` (`createdAt`),
  ADD KEY `updateAt` (`updatedAt`);

--
-- Chỉ mục cho bảng `score`
--
ALTER TABLE `score`
  ADD PRIMARY KEY (`scoreId`),
  ADD KEY `idSubject` (`idSubject`),
  ADD KEY `idStudent` (`idStudent`),
  ADD KEY `score` (`score`),
  ADD KEY `createdAt` (`createdAt`),
  ADD KEY `updateAt` (`updatedAt`),
  ADD KEY `accountId` (`accountId`);

--
-- Chỉ mục cho bảng `student`
--
ALTER TABLE `student`
  ADD PRIMARY KEY (`rollNumber`),
  ADD KEY `createdAt` (`createdAt`),
  ADD KEY `updateAt` (`updatedAt`),
  ADD KEY `acco` (`accountId`),
  ADD KEY `email` (`email`);

--
-- Chỉ mục cho bảng `subject`
--
ALTER TABLE `subject`
  ADD PRIMARY KEY (`id`),
  ADD KEY `createdAt` (`createdAt`),
  ADD KEY `updateAt` (`updatedAt`);

--
-- AUTO_INCREMENT cho các bảng đã đổ
--

--
-- AUTO_INCREMENT cho bảng `score`
--
ALTER TABLE `score`
  MODIFY `scoreId` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
