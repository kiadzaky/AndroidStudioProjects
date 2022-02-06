-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Feb 06, 2022 at 08:33 AM
-- Server version: 10.4.22-MariaDB
-- PHP Version: 7.4.27

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `db_android`
--

-- --------------------------------------------------------

--
-- Table structure for table `tb_nasabah`
--

CREATE TABLE `tb_nasabah` (
  `id` int(2) NOT NULL,
  `nasabah_nama` varchar(30) NOT NULL,
  `nasabah_alamat` text NOT NULL,
  `nasabah_telepon` varchar(13) NOT NULL,
  `nasabah_pekerjaan` varchar(15) NOT NULL,
  `nasabah_saldo` int(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `tb_nasabah`
--

INSERT INTO `tb_nasabah` (`id`, `nasabah_nama`, `nasabah_alamat`, `nasabah_telepon`, `nasabah_pekerjaan`, `nasabah_saldo`) VALUES
(1, 'Kia Dzaky', 'Perum Pesona', '08970605445', 'Swasta', 10000000),
(2, 'Dzaky', 'Jl Surya ', '089706054235', 'TNI', 800000),
(3, 'Eri', 'Jl Milenia ', '08970624235', 'POLRI', 7600000),
(4, 'Nia', 'Jl Ga jadian ', '0823054235', 'Swasta', 10000000),
(5, 'Putri', 'Jl Mulu ya capek ', '081506054235', 'Wiraswasta', 90000000),
(6, 'Sri', 'Jl aja yuk ', '087806054235', 'Wiraswasta', 800000);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `tb_nasabah`
--
ALTER TABLE `tb_nasabah`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `tb_nasabah`
--
ALTER TABLE `tb_nasabah`
  MODIFY `id` int(2) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
