-- phpMyAdmin SQL Dump
-- version 4.6.4
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 31-07-2017 a las 20:33:15
-- Versión del servidor: 5.7.14
-- Versión de PHP: 5.6.25

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `db_tv_digital`
--
CREATE DATABASE IF NOT EXISTS `db_tv_digital` DEFAULT CHARACTER SET latin1 COLLATE latin1_swedish_ci;
USE `db_tv_digital`;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `categoria`
--

CREATE TABLE `categoria` (
  `id_categoria` int(11) NOT NULL,
  `id_sucategoria` int(11) DEFAULT NULL,
  `id_categoria_padre` int(11) DEFAULT NULL,
  `descripcion` varchar(150) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `categoria`
--

INSERT INTO `categoria` (`id_categoria`, `id_sucategoria`, `id_categoria_padre`, `descripcion`) VALUES
(1, 0, 0, 'multimedia'),
(2, 1, 0, 'Peliculas'),
(3, 2, 0, 'Series'),
(4, 3, 0, 'Documentales'),
(5, 4, 1, 'Terror'),
(6, 5, 1, 'Suspenso'),
(7, 6, 1, 'Comedia'),
(8, 7, 1, 'Animados'),
(9, 8, 2, 'Accion');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `loggin`
--

CREATE TABLE `loggin` (
  `user_id` varchar(10) NOT NULL,
  `user` varchar(150) DEFAULT NULL,
  `password` varchar(150) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `loggin`
--

INSERT INTO `loggin` (`user_id`, `user`, `password`) VALUES
('0104035514', 'Gustavo', 'Sistemas1');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `mpaa`
--

CREATE TABLE `mpaa` (
  `id_mpaa` int(11) NOT NULL,
  `clasificacion` varchar(10) DEFAULT NULL,
  `edad_mayor` int(11) DEFAULT NULL,
  `detalle` varchar(150) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `mpaa`
--

INSERT INTO `mpaa` (`id_mpaa`, `clasificacion`, `edad_mayor`, `detalle`) VALUES
(1, 'A', 0, 'Se admiten todas las edades.'),
(2, 'B', 5, 'Se recomienda la guía/orientación de los padres.'),
(3, 'PG-13', 12, 'Parte del material puede no ser apto para los niños menores de 13 años.'),
(4, 'R', 14, 'No se admiten menores de 17 años sin ser acompañados por los padres o un tutor adulto.'),
(5, 'NC-17', 16, 'No se admiten menores de 17 años.'),
(6, '18+', 17, 'Mayores de 18 años.');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `multimedia`
--

CREATE TABLE `multimedia` (
  `id_multimedia` int(11) NOT NULL,
  `id_categoria` int(11) DEFAULT NULL,
  `id_mpaa` int(11) DEFAULT NULL,
  `nombre` varchar(250) DEFAULT NULL,
  `duracion` varchar(45) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `multimedia`
--

INSERT INTO `multimedia` (`id_multimedia`, `id_categoria`, `id_mpaa`, `nombre`, `duracion`) VALUES
(1, 5, 6, 'Pelicula 1', '2:00:34'),
(2, 5, 1, 'Pelicula 2', '1:30:34'),
(3, 6, 2, 'Pelicula 3', '2:20:34'),
(4, 7, 3, 'Pelicula 4', '2:50:00'),
(5, 8, 5, 'Pelicula 5', '2:00:34'),
(6, 8, 6, 'Pelicula 6', '2:00:34'),
(7, 9, 1, 'Pelicula 7', '2:00:34'),
(8, 8, 2, 'Pelicula 8', '2:00:34'),
(9, 7, 4, 'Pelicula 9', '2:00:34'),
(10, 7, 4, 'Pelicula 10', '2:00:34');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `preferencia`
--

CREATE TABLE `preferencia` (
  `id_preferencia` int(11) NOT NULL,
  `id_persona` varchar(45) DEFAULT NULL,
  `id_multimedia` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `ranking`
--

CREATE TABLE `ranking` (
  `id_ranking` int(11) NOT NULL,
  `id_persona` varchar(10) DEFAULT NULL,
  `id_multimedia` int(11) DEFAULT NULL,
  `nota` int(11) DEFAULT NULL,
  `porcentaje` varchar(5) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `ranking`
--

INSERT INTO `ranking` (`id_ranking`, `id_persona`, `id_multimedia`, `nota`, `porcentaje`) VALUES
(1, '0104035514', 1, 1, '20'),
(2, '0104035514', 2, 2, '40'),
(3, '0104035514', 3, 1, '20'),
(4, '0104035514', 4, 4, '80'),
(5, '0104035514', 5, 3, '60'),
(6, '0104035514', 6, 5, '100'),
(7, '0104035514', 7, 2, '40'),
(8, '0104035514', 8, 3, '60'),
(9, '0104035514', 9, 4, '80'),
(10, '0104035514', 10, 5, '100');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuario`
--

CREATE TABLE `usuario` (
  `persona_id` varchar(10) NOT NULL,
  `nombre` varchar(45) DEFAULT NULL,
  `apellido` varchar(45) DEFAULT NULL,
  `fecha_nacimiento` varchar(100) DEFAULT NULL,
  `email` varchar(150) DEFAULT NULL,
  `genero` varchar(1) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `usuario`
--

INSERT INTO `usuario` (`persona_id`, `nombre`, `apellido`, `fecha_nacimiento`, `email`, `genero`) VALUES
('0104035514', 'Gustavo', 'Mora', '23/12/1990', 'g.mora@yahoo.com', 'M');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `categoria`
--
ALTER TABLE `categoria`
  ADD PRIMARY KEY (`id_categoria`);

--
-- Indices de la tabla `loggin`
--
ALTER TABLE `loggin`
  ADD PRIMARY KEY (`user_id`);

--
-- Indices de la tabla `mpaa`
--
ALTER TABLE `mpaa`
  ADD PRIMARY KEY (`id_mpaa`);

--
-- Indices de la tabla `multimedia`
--
ALTER TABLE `multimedia`
  ADD PRIMARY KEY (`id_multimedia`);

--
-- Indices de la tabla `preferencia`
--
ALTER TABLE `preferencia`
  ADD PRIMARY KEY (`id_preferencia`);

--
-- Indices de la tabla `ranking`
--
ALTER TABLE `ranking`
  ADD PRIMARY KEY (`id_ranking`);

--
-- Indices de la tabla `usuario`
--
ALTER TABLE `usuario`
  ADD PRIMARY KEY (`persona_id`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `categoria`
--
ALTER TABLE `categoria`
  MODIFY `id_categoria` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;
--
-- AUTO_INCREMENT de la tabla `mpaa`
--
ALTER TABLE `mpaa`
  MODIFY `id_mpaa` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;
--
-- AUTO_INCREMENT de la tabla `multimedia`
--
ALTER TABLE `multimedia`
  MODIFY `id_multimedia` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;
--
-- AUTO_INCREMENT de la tabla `preferencia`
--
ALTER TABLE `preferencia`
  MODIFY `id_preferencia` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT de la tabla `ranking`
--
ALTER TABLE `ranking`
  MODIFY `id_ranking` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
