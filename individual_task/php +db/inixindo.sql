-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Feb 09, 2022 at 05:57 AM
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
-- Database: `inixindo`
--

-- --------------------------------------------------------

--
-- Table structure for table `detail_kelas`
--

CREATE TABLE `detail_kelas` (
  `det_kel_id` int(11) NOT NULL,
  `kel_id` int(11) NOT NULL,
  `pes_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `detail_kelas`
--

INSERT INTO `detail_kelas` (`det_kel_id`, `kel_id`, `pes_id`) VALUES
(1, 1, 3),
(2, 1, 2),
(3, 1, 1),
(4, 20, 3),
(5, 20, 2),
(6, 20, 1),
(7, 2, 4),
(8, 3, 4),
(9, 4, 5),
(10, 4, 6),
(11, 5, 5),
(12, 5, 6),
(13, 5, 7),
(14, 5, 8),
(15, 19, 7),
(16, 19, 8),
(17, 6, 9),
(18, 6, 10),
(19, 18, 9),
(20, 18, 10),
(21, 7, 11),
(22, 7, 12),
(23, 17, 11),
(24, 17, 12),
(25, 8, 13),
(26, 8, 14),
(27, 16, 13),
(28, 16, 14),
(29, 9, 15),
(30, 9, 16),
(31, 15, 15),
(32, 15, 16),
(33, 10, 17),
(34, 10, 18),
(35, 14, 17),
(36, 14, 18),
(37, 11, 19),
(38, 11, 20),
(39, 13, 19),
(40, 13, 20),
(41, 12, 3),
(42, 12, 2),
(43, 12, 1),
(44, 2, 4),
(45, 3, 4),
(46, 12, 5),
(47, 12, 6),
(48, 13, 5),
(49, 13, 6),
(50, 1, 15),
(51, 1, 16);

-- --------------------------------------------------------

--
-- Table structure for table `instruktur`
--

CREATE TABLE `instruktur` (
  `ins_id` int(11) NOT NULL,
  `ins_nama` varchar(30) NOT NULL,
  `ins_email` varchar(20) NOT NULL,
  `ins_hp` varchar(13) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `instruktur`
--

INSERT INTO `instruktur` (`ins_id`, `ins_nama`, `ins_email`, `ins_hp`) VALUES
(1, 'Abdul Rachman', 'abdul@gmail.com', '082371923121'),
(2, 'Achmad Fadjar', 'fadjar@gmail.com', '08143192312'),
(3, 'Ade R. Syarief', 'ade@gmail.com', '08266542312'),
(4, 'Adi Sumito', 'adi@gmail.com', '08237192312'),
(5, 'Adimitra Baratama Nusantara', 'adimitra@gmail.com', '08335678312'),
(6, 'Adji Muljo Teguh', 'adji@gmail.com', '08222331234'),
(7, 'Adri Achmad Drajat', 'adri@gmail.com', '08983242343'),
(8, 'Adryansyah', 'adryansyah@gmail.com', '08237195532'),
(9, 'Ago Harlim', 'ago@gmail.com', '08234432345'),
(10, 'Agung Salim', 'agung@gmail.com', '08344692312'),
(11, 'Baldeo Singh', 'baldeo@gmail.com', '08237177652'),
(12, 'Bambang Tijoso Tedjokusumo', 'bambang@gmail.com', '08237554312'),
(13, 'Bayu Irianto', 'bayu@gmail.com', '08235532512'),
(14, 'Belinda Natalia Tanoko', 'belinda@gmail.com', '08288567443'),
(15, 'Benny Tenges', 'benny@gmail.com', '08783373487'),
(16, 'Bernadette Ruth Irawati', 'bernadette@gmail.com', '08665327654'),
(17, 'Celin Tanardi', 'celin@gmail.com', '08766628391'),
(18, 'Chin Chin Chandera', 'chin@gmail.com', '08122579094'),
(19, 'Christianto', 'christianto@gmail.co', '08979646274'),
(20, 'Dani Ismulyatie', 'dani@gmail.com', '08988836802');

-- --------------------------------------------------------

--
-- Table structure for table `kelas`
--

CREATE TABLE `kelas` (
  `kel_id` int(11) NOT NULL,
  `kel_tgl_mulai` date NOT NULL,
  `kel_tgl_akhir` date NOT NULL,
  `ins_id` int(11) NOT NULL,
  `mat_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `kelas`
--

INSERT INTO `kelas` (`kel_id`, `kel_tgl_mulai`, `kel_tgl_akhir`, `ins_id`, `mat_id`) VALUES
(1, '2022-01-01', '2022-09-08', 1, 1),
(2, '2022-02-02', '2022-07-09', 2, 2),
(3, '2022-03-10', '2022-10-17', 3, 3),
(4, '2022-04-11', '2022-11-18', 4, 4),
(5, '2022-05-12', '2022-12-19', 5, 5),
(6, '2022-06-13', '2023-01-20', 6, 6),
(7, '2022-07-01', '2023-02-08', 7, 7),
(8, '2022-08-02', '2023-03-09', 8, 8),
(9, '2022-09-03', '2023-04-10', 9, 9),
(10, '2022-10-04', '2023-05-11', 10, 10),
(11, '2022-11-05', '2023-06-12', 11, 11),
(12, '2022-12-06', '2023-12-18', 12, 12),
(13, '2022-03-11', '2023-03-18', 13, 13),
(14, '2022-04-12', '2023-04-19', 14, 14),
(15, '2022-05-13', '2023-05-20', 15, 15),
(16, '2022-06-14', '2023-06-21', 16, 16),
(17, '2022-07-15', '2023-07-22', 17, 17),
(18, '2022-08-16', '2023-08-23', 18, 18),
(19, '2022-09-17', '2023-09-24', 19, 19),
(20, '2022-10-18', '2023-10-25', 20, 20);

-- --------------------------------------------------------

--
-- Table structure for table `materi`
--

CREATE TABLE `materi` (
  `mat_id` int(11) NOT NULL,
  `mat_nama` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `materi`
--

INSERT INTO `materi` (`mat_id`, `mat_nama`) VALUES
(1, 'Android Java'),
(2, 'Cisco Devnet'),
(3, 'Checkpoint Security'),
(4, 'Palo Alto Security'),
(5, 'Mikrotik Network'),
(6, 'Cisco ACI'),
(7, 'Python'),
(8, 'Oracle'),
(9, 'Azure'),
(10, 'Microsoft'),
(11, 'Internet of Things'),
(12, 'Cisco Network'),
(13, 'C++'),
(14, 'Javascript'),
(15, 'PostgreSQL'),
(16, 'MongoDB'),
(17, 'Andr'),
(18, 'Cyberark'),
(19, 'Docker'),
(20, 'Data Science');

-- --------------------------------------------------------

--
-- Table structure for table `peserta`
--

CREATE TABLE `peserta` (
  `pes_id` int(11) NOT NULL,
  `pes_nama` varchar(50) NOT NULL,
  `pes_email` varchar(30) NOT NULL,
  `pes_hp` varchar(13) NOT NULL,
  `pes_instansi` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `peserta`
--

INSERT INTO `peserta` (`pes_id`, `pes_nama`, `pes_email`, `pes_hp`, `pes_instansi`) VALUES
(1, 'Abdul Rachman', 'abdul@gmail.com', '08237192312', 'Maybank'),
(2, 'Kia Dzaky', 'kia@maybank.co.id', '08337829933', 'Maybank'),
(3, 'Abi Praya', 'abi@maybank.co.id', '082362829122', 'Maybank'),
(4, 'Sepli Ariyanto', 'sepli@unl.com', '083378292333', 'Universitas Lampung'),
(5, 'Dendika Dwi', 'dika@telkomuniversity.ac.id', '0823628291233', 'Telkom University'),
(6, 'Lutfiah Intan', 'intan@telkomuniversity.ac.id', '082362829213', 'Telkom University'),
(7, 'Nasrullah', 'nasrul@pertamina.co.id', '083378292432', 'Pertamina'),
(8, 'Rafiq Alfansa', 'rafiq@pertamina.co.id', '083378299221', 'Pertamina'),
(9, 'Ilham Ahmad', 'ilham@telkomsel.com', '083378291234', 'Telkomsel'),
(10, 'Ghozie Ikhsan', 'ghozie@telkomsel.com', '082362822413', 'Telkomsel'),
(11, 'Defi Permata', 'defi@unsoed.com', '082362829127', 'Universitas Jendral Soedirman'),
(12, 'Dona Sari', 'dona@unsoed.com', '082362812327', 'Universitas Jendral Soedirman'),
(13, 'Sari Putri', 'sari@unsoed.com', '08236282317', 'Universitas Jendral Soedirman'),
(14, 'Rizka Putri', 'rizka@unsoed.com', '082323112327', 'Universitas Jendral Soedirman'),
(15, 'Coki Muslim', 'coki@bri.com', '08223212327', 'BRI'),
(16, 'Tona Toni', 'tona@bri.com', '082797112327', 'BRI'),
(17, 'Bagas Cimay', 'bagas@bri.com', '081378112325', 'BRI'),
(18, 'Isna Farih', 'isna@bni.com', '083692011232', 'BNI'),
(19, 'Eta Putri', 'eta@bni.com', '084292011217', 'BNI'),
(20, 'Esra Mugi', 'esra@bni.com', '087392012327', 'BNI'),
(22, 'Amynia', 'admin@crudbooster.com', '08970604452', 'Galaxy1'),
(23, 'Amynia', 'admin@crudbooster.com', '0876544677', 'Galaxy'),
(24, 'Amynia', 'admin@crudbooster.com', '0876544677', 'Galaxy');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `detail_kelas`
--
ALTER TABLE `detail_kelas`
  ADD PRIMARY KEY (`det_kel_id`),
  ADD KEY `pes_id` (`pes_id`),
  ADD KEY `kel_id` (`kel_id`);

--
-- Indexes for table `instruktur`
--
ALTER TABLE `instruktur`
  ADD PRIMARY KEY (`ins_id`);

--
-- Indexes for table `kelas`
--
ALTER TABLE `kelas`
  ADD PRIMARY KEY (`kel_id`),
  ADD KEY `ins_id` (`ins_id`,`mat_id`),
  ADD KEY `mat_id` (`mat_id`);

--
-- Indexes for table `materi`
--
ALTER TABLE `materi`
  ADD PRIMARY KEY (`mat_id`);

--
-- Indexes for table `peserta`
--
ALTER TABLE `peserta`
  ADD PRIMARY KEY (`pes_id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `detail_kelas`
--
ALTER TABLE `detail_kelas`
  MODIFY `det_kel_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=52;

--
-- AUTO_INCREMENT for table `instruktur`
--
ALTER TABLE `instruktur`
  MODIFY `ins_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=21;

--
-- AUTO_INCREMENT for table `kelas`
--
ALTER TABLE `kelas`
  MODIFY `kel_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=21;

--
-- AUTO_INCREMENT for table `materi`
--
ALTER TABLE `materi`
  MODIFY `mat_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=21;

--
-- AUTO_INCREMENT for table `peserta`
--
ALTER TABLE `peserta`
  MODIFY `pes_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=25;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `detail_kelas`
--
ALTER TABLE `detail_kelas`
  ADD CONSTRAINT `detail_kelas_ibfk_1` FOREIGN KEY (`pes_id`) REFERENCES `peserta` (`pes_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `detail_kelas_ibfk_2` FOREIGN KEY (`kel_id`) REFERENCES `kelas` (`kel_id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `kelas`
--
ALTER TABLE `kelas`
  ADD CONSTRAINT `kelas_ibfk_1` FOREIGN KEY (`ins_id`) REFERENCES `instruktur` (`ins_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `kelas_ibfk_2` FOREIGN KEY (`mat_id`) REFERENCES `materi` (`mat_id`) ON DELETE CASCADE ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
