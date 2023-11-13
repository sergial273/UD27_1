-- Drop the database if it exists
DROP DATABASE IF EXISTS Tarea1;

-- Create the database
CREATE DATABASE Tarea1;

-- Switch to the new database
USE Tarea1;
-- Elimina las tablas si existen
DROP TABLE IF EXISTS `piezas`;
DROP TABLE IF EXISTS `suministra`;
DROP TABLE IF EXISTS `proveedores`;

-- Crea la tabla `piezas`
CREATE TABLE `piezas` (
  `codigo` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(250) DEFAULT NULL,
  PRIMARY KEY (`codigo`)
);

-- Crea la tabla `proveedores`
CREATE TABLE `proveedores` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(250) DEFAULT NULL,
  PRIMARY KEY (`id`)
);

-- Crea la tabla `suministra`
CREATE TABLE `suministra` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `pieza` int(11) NOT NULL,
  `idprov` int(11) NOT NULL,
  `precio` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT `pieza_FK` FOREIGN KEY (`pieza`) REFERENCES `piezas` (`codigo`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `proveedor_FK` FOREIGN KEY (`idprov`) REFERENCES `proveedores` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
);

-- Inserta datos en la tabla `piezas`
INSERT INTO `piezas` (nombre) VALUES
('Pieza 1'),
('Pieza 2'),
('Pieza 3'),
('Pieza 4'),
('Pieza 5');

-- Inserta datos en la tabla `proveedores`
INSERT INTO `proveedores` (nombre) VALUES
('Proveedor 1'),
('Proveedor 2'),
('Proveedor 3'),
('Proveedor 4'),
('Proveedor 5');

-- Inserta datos en la tabla `suministra`
INSERT INTO `suministra` (pieza, idprov, precio) VALUES
(1, 1, 100),
(2, 2, 150),
(3, 3, 120),
(4, 4, 200),
(5, 5, 180);






