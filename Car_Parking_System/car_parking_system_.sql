-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Apr 05, 2023 at 03:48 PM
-- Server version: 10.4.27-MariaDB
-- PHP Version: 8.2.0

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `car_parking_system_`
--

-- --------------------------------------------------------

--
-- Table structure for table `login`
--

CREATE TABLE `login` (
  `Username` varchar(20) DEFAULT NULL,
  `Password` varchar(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `login`
--

INSERT INTO `login` (`Username`, `Password`) VALUES
('User1', 'Dorothy'),
('User2', 'James');

-- --------------------------------------------------------

--
-- Table structure for table `parking_slots`
--

CREATE TABLE `parking_slots` (
  `slots_id` varchar(20) DEFAULT NULL,
  `status` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `parking_slots`
--

INSERT INTO `parking_slots` (`slots_id`, `status`) VALUES
('1', 'booked'),
('2', 'available'),
('3', 'available'),
('4', 'available'),
('5', 'available'),
('1', 'booked'),
('2', 'available'),
('3', 'available'),
('4', 'available'),
('5', 'available'),
('1', 'booked'),
('2', 'available'),
('3', 'available'),
('4', 'available'),
('5', 'available'),
('1', 'booked'),
('2', 'available'),
('3', 'available'),
('4', 'available'),
('5', 'available'),
('1', 'booked'),
('2', 'available'),
('3', 'available'),
('4', 'available'),
('5', 'available'),
('1', 'booked'),
('2', 'available'),
('3', 'available'),
('4', 'available'),
('5', 'available'),
('1', 'booked'),
('2', 'available'),
('3', 'available'),
('4', 'available'),
('5', 'available'),
('1', 'booked'),
('2', 'available'),
('3', 'available'),
('4', 'available'),
('5', 'available'),
('1', 'booked'),
('2', 'available'),
('3', 'available'),
('4', 'available'),
('5', 'available'),
('1', 'booked'),
('2', 'available'),
('3', 'available'),
('4', 'available'),
('5', 'available'),
('1', 'booked'),
('2', 'available'),
('3', 'available'),
('4', 'available'),
('5', 'available'),
('1', 'booked'),
('2', 'available'),
('3', 'available'),
('4', 'available'),
('5', 'available'),
('1', 'booked'),
('2', 'available'),
('3', 'available'),
('4', 'available'),
('5', 'available'),
('1', 'booked'),
('2', 'available'),
('3', 'available'),
('4', 'available'),
('5', 'available'),
('1', 'booked'),
('2', 'available'),
('3', 'available'),
('4', 'available'),
('5', 'available');

-- --------------------------------------------------------

--
-- Table structure for table `visitor`
--

CREATE TABLE `visitor` (
  `First Name` varchar(100) NOT NULL,
  `Last Name` varchar(100) DEFAULT NULL,
  `Vehicle Registration Number` varchar(50) DEFAULT NULL,
  `Vehicle Type` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `visitor`
--

INSERT INTO `visitor` (`First Name`, `Last Name`, `Vehicle Registration Number`, `Vehicle Type`) VALUES
('Dorothy', 'Vaughan', 'KBS 234K', 'Nissan X-Trail'),
('James ', 'Matthews', 'KCA 234S', 'Toyota Subaru'),
('Jeremy', 'Ouma', 'KDH 334H', 'Mercedes');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `visitor`
--
ALTER TABLE `visitor`
  ADD PRIMARY KEY (`First Name`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
