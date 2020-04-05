-- phpMyAdmin SQL Dump
-- version 5.0.1
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1
-- Généré le : sam. 04 avr. 2020 à 14:28
-- Version du serveur :  10.4.11-MariaDB
-- Version de PHP : 7.2.27

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données : `mabddtest`
--

-- --------------------------------------------------------

--
-- Structure de la table `frais_forfaitaire`
--

CREATE TABLE `frais_forfaitaire` (
  `id_frais_forfaitaire` int(11) NOT NULL,
  `id_ask` int(11) NOT NULL,
  `cout_hotel` int(11) NOT NULL,
  `cout_repas` int(11) NOT NULL,
  `cout_kilometrage` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `frais_forfaitaire`
--

INSERT INTO `frais_forfaitaire` (`id_frais_forfaitaire`, `id_ask`, `cout_hotel`, `cout_repas`, `cout_kilometrage`) VALUES
(1, 1, 75, 35, 14);

-- --------------------------------------------------------

--
-- Structure de la table `remboursement`
--

CREATE TABLE `remboursement` (
  `id_remboursement` int(11) NOT NULL,
  `id_user_ask_remboursement` int(11) NOT NULL,
  `montant_remboursement` int(11) NOT NULL,
  `id_perso_ok_remboursement` int(11) NOT NULL,
  `accepter_remboursement` int(11) NOT NULL DEFAULT 0,
  `raison_remboursement` varchar(255) NOT NULL,
  `date_ask_remboursement` date DEFAULT current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `remboursement`
--

INSERT INTO `remboursement` (`id_remboursement`, `id_user_ask_remboursement`, `montant_remboursement`, `id_perso_ok_remboursement`, `accepter_remboursement`, `raison_remboursement`, `date_ask_remboursement`) VALUES
(3, 1, 200, 2, 1, 'Kebab', '2020-03-04'),
(10, 1, 200, 3, 1, 'test', '2020-04-04'),
(12, 1, 201, 2, 1, 'test current date', '2020-04-04');

-- --------------------------------------------------------

--
-- Structure de la table `utilisateurs`
--

CREATE TABLE `utilisateurs` (
  `id_user` int(11) NOT NULL,
  `identifiant_user` varchar(255) NOT NULL,
  `mot_de_pass_user` varchar(255) NOT NULL,
  `grade_user` int(11) NOT NULL,
  `nom_user` varchar(255) NOT NULL,
  `prenom_user` varchar(255) NOT NULL,
  `id_vehicle` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `utilisateurs`
--

INSERT INTO `utilisateurs` (`id_user`, `identifiant_user`, `mot_de_pass_user`, `grade_user`, `nom_user`, `prenom_user`, `id_vehicle`) VALUES
(1, 'Rooky', 'GTPewihfNxvdVR8IeInuhQ==', 1, 'Krzykawsky', 'Alexi', 0),
(2, 'Valentin', 'GTPewihfNxvdVR8IeInuhQ==', 1, 'Martins', 'Valentin', 0),
(3, 'Pierre', 'SFda8FXJ5ofs9CyAOO3IRw==', 1, 'Legros', 'Pierre', 0);

-- --------------------------------------------------------

--
-- Structure de la table `vehicule`
--

CREATE TABLE `vehicule` (
  `id_vehicule` int(11) NOT NULL,
  `cv_vehicule` int(11) NOT NULL,
  `type_vehicule` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `vehicule`
--

INSERT INTO `vehicule` (`id_vehicule`, `cv_vehicule`, `type_vehicule`) VALUES
(1, 4, 1);

--
-- Index pour les tables déchargées
--

--
-- Index pour la table `frais_forfaitaire`
--
ALTER TABLE `frais_forfaitaire`
  ADD PRIMARY KEY (`id_frais_forfaitaire`),
  ADD KEY `id_ask` (`id_ask`);

--
-- Index pour la table `remboursement`
--
ALTER TABLE `remboursement`
  ADD PRIMARY KEY (`id_remboursement`),
  ADD KEY `id_user_ask_remboursementent` (`id_user_ask_remboursement`);

--
-- Index pour la table `utilisateurs`
--
ALTER TABLE `utilisateurs`
  ADD PRIMARY KEY (`id_user`);

--
-- Index pour la table `vehicule`
--
ALTER TABLE `vehicule`
  ADD PRIMARY KEY (`id_vehicule`);

--
-- AUTO_INCREMENT pour les tables déchargées
--

--
-- AUTO_INCREMENT pour la table `frais_forfaitaire`
--
ALTER TABLE `frais_forfaitaire`
  MODIFY `id_frais_forfaitaire` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT pour la table `remboursement`
--
ALTER TABLE `remboursement`
  MODIFY `id_remboursement` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=13;

--
-- AUTO_INCREMENT pour la table `utilisateurs`
--
ALTER TABLE `utilisateurs`
  MODIFY `id_user` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT pour la table `vehicule`
--
ALTER TABLE `vehicule`
  MODIFY `id_vehicule` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- Contraintes pour les tables déchargées
--

--
-- Contraintes pour la table `frais_forfaitaire`
--
ALTER TABLE `frais_forfaitaire`
  ADD CONSTRAINT `frais_forfaitaire_ibfk_1` FOREIGN KEY (`id_ask`) REFERENCES `utilisateurs` (`id_user`);

--
-- Contraintes pour la table `remboursement`
--
ALTER TABLE `remboursement`
  ADD CONSTRAINT `remboursement_ibfk_1` FOREIGN KEY (`id_user_ask_remboursement`) REFERENCES `utilisateurs` (`id_user`);

--
-- Contraintes pour la table `vehicule`
--
ALTER TABLE `vehicule`
  ADD CONSTRAINT `vehicule_ibfk_1` FOREIGN KEY (`id_vehicule`) REFERENCES `utilisateurs` (`id_user`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
