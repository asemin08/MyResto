-- phpMyAdmin SQL Dump
-- version 5.1.0
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1
-- Généré le : mar. 29 juin 2021 à 10:47
-- Version du serveur :  10.4.18-MariaDB
-- Version de PHP : 8.0.3

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données : `myresto`
--
CREATE DATABASE IF NOT EXISTS `myresto` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci;
USE `myresto`;

-- --------------------------------------------------------

--
-- Structure de la table `category`
--

DROP TABLE IF EXISTS `category`;
CREATE TABLE IF NOT EXISTS `category` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  `image` text DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4;

--
-- Tronquer la table avant d'insérer `category`
--

TRUNCATE TABLE `category`;
--
-- Déchargement des données de la table `category`
--

INSERT INTO `category` (`id`, `name`, `image`) VALUES
(1, 'entree', '');

-- --------------------------------------------------------

--
-- Structure de la table `listproducts`
--

DROP TABLE IF EXISTS `listproducts`;
CREATE TABLE IF NOT EXISTS `listproducts` (
  `id_product` int(11) NOT NULL,
  `id_order` int(11) NOT NULL,
  KEY `id_product` (`id_product`,`id_order`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Tronquer la table avant d'insérer `listproducts`
--

TRUNCATE TABLE `listproducts`;
--
-- Déchargement des données de la table `listproducts`
--

INSERT INTO `listproducts` (`id_product`, `id_order`) VALUES
(1, 1);

-- --------------------------------------------------------

--
-- Structure de la table `order_product`
--

DROP TABLE IF EXISTS `order_product`;
CREATE TABLE IF NOT EXISTS `order_product` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `id_user` int(11) NOT NULL,
  `date` date NOT NULL DEFAULT current_timestamp(),
  `status` text NOT NULL DEFAULT 'New',
  PRIMARY KEY (`id`),
  KEY `id_user` (`id_user`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4;

--
-- Tronquer la table avant d'insérer `order_product`
--

TRUNCATE TABLE `order_product`;
--
-- Déchargement des données de la table `order_product`
--

INSERT INTO `order_product` (`id`, `id_user`, `date`, `status`) VALUES
(1, 1, '3921-02-12', 'NEW');

-- --------------------------------------------------------

--
-- Structure de la table `product`
--

DROP TABLE IF EXISTS `product`;
CREATE TABLE IF NOT EXISTS `product` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  `price` float NOT NULL,
  `description` text NOT NULL,
  `image` varchar(255) NOT NULL,
  `id_category` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `id_category` (`id_category`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4;

--
-- Tronquer la table avant d'insérer `product`
--

TRUNCATE TABLE `product`;
--
-- Déchargement des données de la table `product`
--

INSERT INTO `product` (`id`, `name`, `price`, `description`, `image`, `id_category`) VALUES
(1, 'Coca', 3.5, 'C\'est du coca haha', '', 1);

-- --------------------------------------------------------

--
-- Structure de la table `user`
--

DROP TABLE IF EXISTS `user`;
CREATE TABLE IF NOT EXISTS `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `firstname` varchar(255) NOT NULL,
  `lastname` varchar(255) NOT NULL,
  `login` varchar(255) NOT NULL,
  `address` varchar(255) NOT NULL,
  `role` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  `salt` varchar(255) DEFAULT NULL,
  `image` text DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4;

--
-- Tronquer la table avant d'insérer `user`
--

TRUNCATE TABLE `user`;
--
-- Déchargement des données de la table `user`
--

INSERT INTO `user` (`id`,`login`, `firstname`, `lastname`, `address`, `role`, `password`, `salt`, `image`) VALUES
(1,'test', 'test', 'test', '', '', '', '', '');

--
-- Contraintes pour les tables déchargées
--

--
-- Contraintes pour la table `product`
--
ALTER TABLE `product`
  ADD CONSTRAINT `fk_category` FOREIGN KEY (`id_category`) REFERENCES `category` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Contraintes pour la table `listproducts`
--
ALTER TABLE `listproducts`
  ADD CONSTRAINT `fk_order` FOREIGN KEY (`id_order`) REFERENCES `order_product` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `fk_product` FOREIGN KEY (`id_product`) REFERENCES `product` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Contraintes pour la table `order_product`
--
ALTER TABLE `order_product`
  ADD CONSTRAINT `fk_user` FOREIGN KEY (`id_user`) REFERENCES `user` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
