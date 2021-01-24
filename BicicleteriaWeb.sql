-- phpMyAdmin SQL Dump
-- version 5.0.2
-- https://www.phpmyadmin.net/
--
-- Servidor: localhost
-- Tiempo de generación: 26-10-2020 a las 06:33:23
-- Versión del servidor: 10.4.14-MariaDB
-- Versión de PHP: 7.4.9

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `BicicleteriaWeb`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `Bicicletas`
--

CREATE TABLE `Bicicletas` (
  `COD` int(11) NOT NULL,
  `Nombre` varchar(30) NOT NULL,
  `Piezas` varchar(130) NOT NULL,
  `Cantidad` int(11) NOT NULL,
  `Precio` decimal(10,0) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `Bicicletas`
--

INSERT INTO `Bicicletas` (`COD`, `Nombre`, `Piezas`, `Cantidad`, `Precio`) VALUES
(1, 'Vairo Storn II', '2 Ruedas; 1 Manubrio; 1 Cuadro; 1 Asiento; 1 Kit Mecanico.2 Pedales; ', 2, '25000');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `Piezas`
--

CREATE TABLE `Piezas` (
  `COD` int(11) NOT NULL,
  `Tipo` varchar(15) NOT NULL,
  `Cantidad` int(11) NOT NULL,
  `Precio` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `Piezas`
--

INSERT INTO `Piezas` (`COD`, `Tipo`, `Cantidad`, `Precio`) VALUES
(1, 'Rueda', 10, 600),
(1, 'Manubrio', 33, 900),
(1, 'Cuadro', 33, 2000),
(1, 'Asiento', 27, 1200),
(1, 'Kit Mecanico', 33, 300),
(2, 'Kit Mecanico', 56, 1500),
(3, 'Cuadro', 56, 1500),
(3, 'Pedal', 100, 600),
(4, 'Pedal', 18, 1200),
(1, 'Pedal', 146, 1200),
(2, 'Pedal', 100, 1500);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `Usuarios`
--

CREATE TABLE `Usuarios` (
  `User` varchar(15) NOT NULL,
  `Pass` varchar(15) NOT NULL,
  `Nombre` varchar(25) NOT NULL,
  `Rol` varchar(12) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='Usuarios del Sistema';

--
-- Volcado de datos para la tabla `Usuarios`
--

INSERT INTO `Usuarios` (`User`, `Pass`, `Nombre`, `Rol`) VALUES
('bici1', 'bici1', 'Javier Luna', 'Bicicletero'),
('venta1', 'venta1', 'Macarena Luna Diaz', 'Vendedor'),
('venta2', 'venta2', 'Valentina Luna Diaz', 'Vendedor'),
('enc1', 'enc1', 'Siomara Diaz', 'Encargado');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `Bicicletas`
--
ALTER TABLE `Bicicletas`
  ADD PRIMARY KEY (`COD`),
  ADD UNIQUE KEY `COD` (`COD`),
  ADD UNIQUE KEY `COD_2` (`COD`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `Bicicletas`
--
ALTER TABLE `Bicicletas`
  MODIFY `COD` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
