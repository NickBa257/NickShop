-- phpMyAdmin SQL Dump
-- version 3.3.5
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: Nov 22, 2023 at 12:20 PM
-- Server version: 5.1.49
-- PHP Version: 5.3.3

SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `vente_en_ligne`
--
CREATE DATABASE `vente_en_ligne` DEFAULT CHARACTER SET latin1 COLLATE latin1_swedish_ci;
USE `vente_en_ligne`;

-- --------------------------------------------------------

--
-- Table structure for table `acheteur`
--

CREATE TABLE IF NOT EXISTS `acheteur` (
  `AId` int(11) NOT NULL AUTO_INCREMENT,
  `Nom` varchar(50) DEFAULT NULL,
  `Adresse` varchar(50) DEFAULT NULL,
  `Telephone` int(11) DEFAULT NULL,
  `Identifiant` varchar(20) DEFAULT NULL,
  `Mot_de_passe` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`AId`),
  UNIQUE KEY `Mot_de_passe` (`Mot_de_passe`)
) ENGINE=MyISAM  DEFAULT CHARSET=latin1 AUTO_INCREMENT=6 ;

--
-- Dumping data for table `acheteur`
--

INSERT INTO `acheteur` (`AId`, `Nom`, `Adresse`, `Telephone`, `Identifiant`, `Mot_de_passe`) VALUES
(1, 'Gahembuye Patient', 'Carama', 76123147, 'Patient', '0000'),
(2, 'Ishimwe Beni Charbel', 'Nyakabiga', 71547896, 'Charbel', '1111'),
(3, 'MAREGEYA Kenny Marty', 'Mutanga Nord', 6632547, 'Kenny', '2222'),
(4, 'AYINKAMIYE Fidia', 'Maramvya', 65456878, 'Fidia', 'Ayinkamiye192'),
(5, 'Ngenderakurinda Flodouard', 'Maramvya', 75125698, 'Flodouard', 'loan');

-- --------------------------------------------------------

--
-- Table structure for table `bloque`
--

CREATE TABLE IF NOT EXISTS `bloque` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `Ip` varchar(20) DEFAULT NULL,
  `Tentatives` int(11) DEFAULT NULL,
  `Date` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

--
-- Dumping data for table `bloque`
--


-- --------------------------------------------------------

--
-- Table structure for table `bloquedefinitivement`
--

CREATE TABLE IF NOT EXISTS `bloquedefinitivement` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `Ip` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

--
-- Dumping data for table `bloquedefinitivement`
--


-- --------------------------------------------------------

--
-- Table structure for table `commande`
--

CREATE TABLE IF NOT EXISTS `commande` (
  `CommandeId` int(11) NOT NULL AUTO_INCREMENT,
  `NomProduit` varchar(100) DEFAULT NULL,
  `NomClient` varchar(30) DEFAULT NULL,
  `PrixTotal` int(11) DEFAULT NULL,
  `Date_Commande` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`CommandeId`)
) ENGINE=MyISAM  DEFAULT CHARSET=latin1 AUTO_INCREMENT=2 ;

--
-- Dumping data for table `commande`
--

INSERT INTO `commande` (`CommandeId`, `NomProduit`, `NomClient`, `PrixTotal`, `Date_Commande`) VALUES
(1, 'T SHIRT 3', 'Ishimwe Beni Charbel', 18500, '13/11/2023 20:30:43');

-- --------------------------------------------------------

--
-- Table structure for table `commandev`
--

CREATE TABLE IF NOT EXISTS `commandev` (
  `CommandeId` int(11) NOT NULL AUTO_INCREMENT,
  `NomProduit` varchar(30) DEFAULT NULL,
  `Quantite` int(11) DEFAULT NULL,
  `PrixTotal` int(11) DEFAULT NULL,
  `NomClient` varchar(60) DEFAULT NULL,
  `Date_Commande` varchar(20) DEFAULT NULL,
  `Effectue` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`CommandeId`)
) ENGINE=MyISAM  DEFAULT CHARSET=latin1 AUTO_INCREMENT=2 ;

--
-- Dumping data for table `commandev`
--

INSERT INTO `commandev` (`CommandeId`, `NomProduit`, `Quantite`, `PrixTotal`, `NomClient`, `Date_Commande`, `Effectue`) VALUES
(1, 'T SHIRT 3', 1, 18500, 'Ishimwe Beni Charbel', '13/11/2023 20:30:43', 'false');

-- --------------------------------------------------------

--
-- Table structure for table `produit`
--

CREATE TABLE IF NOT EXISTS `produit` (
  `Produit_id` int(11) NOT NULL AUTO_INCREMENT,
  `Nom` varchar(20) NOT NULL,
  `Categorie` varchar(10) NOT NULL,
  `Quantite` int(11) DEFAULT NULL,
  `Prix` int(11) NOT NULL,
  `image` varchar(40) NOT NULL,
  `VId` int(11) DEFAULT NULL,
  PRIMARY KEY (`Produit_id`),
  KEY `VId` (`VId`)
) ENGINE=MyISAM  DEFAULT CHARSET=latin1 AUTO_INCREMENT=6 ;

--
-- Dumping data for table `produit`
--

INSERT INTO `produit` (`Produit_id`, `Nom`, `Categorie`, `Quantite`, `Prix`, `image`, `VId`) VALUES
(1, 'T SHIRT 1', 'T-shirt', 10, 18000, 'T SHIRT 1.jpg', 1),
(2, 'Chaussure 1', 'chaussure', 15, 180000, 'CHAUSSURE 1.jpg', 1),
(3, 'Pantalon 1 ', 'pantalon', 20, 35000, 'PANTALON 1.jpg', 1),
(4, 'T SHIRT 2', 'T-shirt', 20, 26000, 'T SHIRT 2.jpg', 4),
(5, 'T SHIRT 3', 'T-shirt', 15, 18500, 'T SHIRT 3.jpg', 4);

-- --------------------------------------------------------

--
-- Table structure for table `vendeur`
--

CREATE TABLE IF NOT EXISTS `vendeur` (
  `Vid` int(11) NOT NULL AUTO_INCREMENT,
  `Nom` varchar(100) DEFAULT NULL,
  `Adresse` varchar(50) DEFAULT NULL,
  `Telephone` int(11) DEFAULT NULL,
  `Identifiant` varchar(20) DEFAULT NULL,
  `Mot_de_Passe` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`Vid`),
  UNIQUE KEY `Mot_de_Passe` (`Mot_de_Passe`)
) ENGINE=MyISAM  DEFAULT CHARSET=latin1 AUTO_INCREMENT=5 ;

--
-- Dumping data for table `vendeur`
--

INSERT INTO `vendeur` (`Vid`, `Nom`, `Adresse`, `Telephone`, `Identifiant`, `Mot_de_Passe`) VALUES
(1, 'HATUNGIMANA Nick Baptiste', 'Maramvya', 68546923, 'Nick Ba', 'admin'),
(2, 'Akimana ardis', 'Ngagara', 68965412, 'Ardis', '3333'),
(3, 'HORANUMUKAMA Yvette', 'Ville', 68965412, 'Yvette', 'yvette'),
(4, 'GAHIMBARE Marie Médiatrice', 'Ville', 76987123, 'Marie', 'marie');
