-- phpMyAdmin SQL Dump
-- version 4.8.2
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: May 23, 2019 at 04:38 PM
-- Server version: 10.1.34-MariaDB
-- PHP Version: 7.2.7

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `sem4`
--

-- --------------------------------------------------------

--
-- Table structure for table `account`
--

CREATE TABLE `account` (
  `id` varchar(30) NOT NULL,
  `userName` varchar(50) NOT NULL,
  `passWord` text NOT NULL,
  `salt` text NOT NULL,
  `createdAt` bigint(50) NOT NULL,
  `updatedAt` bigint(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `score`
--

CREATE TABLE `score` (
  `idSubject` varchar(50) NOT NULL,
  `idStudent` varchar(50) NOT NULL,
  `score` int(2) NOT NULL,
  `accountId` varchar(50) NOT NULL,
  `createdAt` bigint(50) NOT NULL,
  `updatedAt` bigint(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `student`
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

-- --------------------------------------------------------

--
-- Table structure for table `subject`
--

CREATE TABLE `subject` (
  `id` varchar(50) NOT NULL,
  `name` text CHARACTER SET utf8 NOT NULL,
  `status` int(1) DEFAULT '1',
  `createdAt` bigint(50) NOT NULL,
  `updatedAt` bigint(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `account`
--
ALTER TABLE `account`
  ADD PRIMARY KEY (`id`),
  ADD KEY `userName` (`userName`),
  ADD KEY `createdAt` (`createdAt`),
  ADD KEY `updateAt` (`updatedAt`);

--
-- Indexes for table `score`
--
ALTER TABLE `score`
  ADD KEY `idSubject` (`idSubject`),
  ADD KEY `idStudent` (`idStudent`),
  ADD KEY `score` (`score`),
  ADD KEY `createdAt` (`createdAt`),
  ADD KEY `updateAt` (`updatedAt`),
  ADD KEY `accountId` (`accountId`);

--
-- Indexes for table `student`
--
ALTER TABLE `student`
  ADD PRIMARY KEY (`rollNumber`),
  ADD KEY `createdAt` (`createdAt`),
  ADD KEY `updateAt` (`updatedAt`),
  ADD KEY `acco` (`accountId`),
  ADD KEY `email` (`email`);

--
-- Indexes for table `subject`
--
ALTER TABLE `subject`
  ADD PRIMARY KEY (`id`),
  ADD KEY `createdAt` (`createdAt`),
  ADD KEY `updateAt` (`updatedAt`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
