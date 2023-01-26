-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 25-01-2023 a las 02:54:30
-- Versión del servidor: 10.4.24-MariaDB
-- Versión de PHP: 8.1.6

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `bd_vitamed`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `copago`
--

CREATE TABLE `copago` (
  `id_copago` int(11) NOT NULL,
  `tarifa` varchar(100) CHARACTER SET utf8 NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `copago`
--

INSERT INTO `copago` (`id_copago`, `tarifa`) VALUES
(1, '70.000'),
(2, '25.000'),
(3, '30.000');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `especialistas`
--

CREATE TABLE `especialistas` (
  `id_especialistas` int(11) NOT NULL,
  `nombres` varchar(100) NOT NULL,
  `apellidos` varchar(100) NOT NULL,
  `tipo_identificacion` enum('C.C','CD','CE') NOT NULL,
  `numero_identificacion` int(30) NOT NULL,
  `especialidad` enum('general','psicologia','fisioterapia') NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `especialistas`
--

INSERT INTO `especialistas` (`id_especialistas`, `nombres`, `apellidos`, `tipo_identificacion`, `numero_identificacion`, `especialidad`) VALUES
(1, 'Carlos daniel', 'caceres cortes', 'C.C', 1093265472, 'general'),
(2, 'fabian alejandro', 'uribe valdez', 'C.C', 1837646263, 'psicologia');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `historia_clinica`
--

CREATE TABLE `historia_clinica` (
  `id_hc` int(20) NOT NULL,
  `id_paciente` int(11) NOT NULL,
  `id_especialistas` int(11) NOT NULL,
  `id_copago` int(11) NOT NULL,
  `fecha_atencion` date NOT NULL,
  `nombre_eps` varchar(100) NOT NULL,
  `regimen_afiliado` enum('Contributivo','Subsidiado') NOT NULL,
  `n_orden_servicio` int(50) NOT NULL,
  `codigo_unidad_m` enum('1','2','3','4','5','6') NOT NULL,
  `atencion_lugar` varchar(100) NOT NULL,
  `evaluacion_inicial_paci` varchar(100) NOT NULL,
  `embarazo` varchar(100) NOT NULL,
  `ginecoobstetrico` varchar(100) NOT NULL,
  `dificultad_respiratoria` varchar(100) NOT NULL,
  `psiquiatrico` varchar(100) NOT NULL,
  `piel` varchar(100) NOT NULL,
  `escala_cincinnati` enum('1','2','3') NOT NULL,
  `revision_gene_paci` varchar(100) NOT NULL,
  `hallazgos_paci` varchar(100) NOT NULL,
  `impresion_diagnos` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `historia_clinica`
--

INSERT INTO `historia_clinica` (`id_hc`, `id_paciente`, `id_especialistas`, `id_copago`, `fecha_atencion`, `nombre_eps`, `regimen_afiliado`, `n_orden_servicio`, `codigo_unidad_m`, `atencion_lugar`, `evaluacion_inicial_paci`, `embarazo`, `ginecoobstetrico`, `dificultad_respiratoria`, `psiquiatrico`, `piel`, `escala_cincinnati`, `revision_gene_paci`, `hallazgos_paci`, `impresion_diagnos`) VALUES
(16, 11, 1, 2, '2023-01-01', 'salud total', 'Contributivo', 1234, '1', 'trabajo', 'afección respiratoria', 'no aplica', 'no aplica', 'paciente con infección respiratoria ', 'no aplica', 'no aplica', '1', 'se encuentra al paciente con dificultad al respirar ', 'no se encontró otros problemas de salud', 'paciente con problemas de neumonia'),
(17, 11, 2, 1, '2023-01-04', 'Mutualser eps', 'Subsidiado', 2345, '2', 'casa', 'perdida del conocimiento paciente desmayado', 'no aplica', 'no aplica', 'no aplica', 'no aplica', 'no aplica', '3', 'se encuentra al paciente desmayado', 'el paciente respira normalmente no se encuentra contusiones', 'el paciente revela traumatismo severo alimenticio');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `paciente`
--

CREATE TABLE `paciente` (
  `id_paciente` int(11) NOT NULL,
  `tipo_documento` enum('RC','TI','C.C','CD','CE') NOT NULL,
  `doc_paciente` int(20) NOT NULL,
  `nombres` varchar(50) NOT NULL,
  `apellidos` varchar(50) NOT NULL,
  `fecha_nacimiento` date NOT NULL,
  `edad` int(20) NOT NULL,
  `direccion` varchar(100) NOT NULL,
  `barrio` varchar(50) NOT NULL,
  `telefono` varchar(20) NOT NULL,
  `correo_elec` varchar(50) NOT NULL,
  `estado_civil` enum('soltero(a)','Casado(a)','Divorciado(a)','viudo(a)','Unión libre') NOT NULL,
  `sexo` enum('Masculino','Femenino') NOT NULL,
  `ocupacion` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `paciente`
--

INSERT INTO `paciente` (`id_paciente`, `tipo_documento`, `doc_paciente`, `nombres`, `apellidos`, `fecha_nacimiento`, `edad`, `direccion`, `barrio`, `telefono`, `correo_elec`, `estado_civil`, `sexo`, `ocupacion`) VALUES
(11, 'C.C', 1220223618, 'cristian david', 'parra garnika', '0000-00-00', 3, 'cra 78 g # 78 - 45 casa 2 piso\r\n', 'ferias', '3118415300', 'cristiandavi@hotmail.com', 'soltero(a)', 'Masculino', 'menor de edad'),
(13, 'C.C', 93439109, 'sergio andres', 'caceres', '1984-08-30', 36, 'cl. 68 b # 99 - 59\r\n', 'alamos norte', '3173665351', 'sergioandre@hotmail.com', 'soltero(a)', 'Masculino', 'ingeniero'),
(14, 'C.C', 646253525, 'Fauricio', 'Cantabria', '1984-08-22', 23, 'calle 23 45-67', 'suba', '3002343546', 'FauricioCantabria@hotmail.com', 'soltero(a)', 'Masculino', 'Asesor'),
(15, 'C.C', 174636224, 'Patricia ', 'Beltran Hoyos', '1977-01-17', 47, 'calle 23 23-67', 'Cienpies', '364635252', 'BeltranHoyos@hotmail.com', 'Casado(a)', 'Masculino', 'Pensionado'),
(16, 'C.C', 274626362, 'Alejandra ', 'Potes', '1966-02-23', 60, 'calle 45 35-34', 'San juan', '3046563723', 'AlejandraPotes@hotmail.com', 'Casado(a)', 'Femenino', 'Pensionada');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `copago`
--
ALTER TABLE `copago`
  ADD PRIMARY KEY (`id_copago`);

--
-- Indices de la tabla `especialistas`
--
ALTER TABLE `especialistas`
  ADD PRIMARY KEY (`id_especialistas`);

--
-- Indices de la tabla `historia_clinica`
--
ALTER TABLE `historia_clinica`
  ADD PRIMARY KEY (`id_hc`),
  ADD KEY `id_paciente` (`id_paciente`),
  ADD KEY `id_especialistas` (`id_especialistas`),
  ADD KEY `id_copago` (`id_copago`);

--
-- Indices de la tabla `paciente`
--
ALTER TABLE `paciente`
  ADD PRIMARY KEY (`id_paciente`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `copago`
--
ALTER TABLE `copago`
  MODIFY `id_copago` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT de la tabla `especialistas`
--
ALTER TABLE `especialistas`
  MODIFY `id_especialistas` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT de la tabla `historia_clinica`
--
ALTER TABLE `historia_clinica`
  MODIFY `id_hc` int(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=18;

--
-- AUTO_INCREMENT de la tabla `paciente`
--
ALTER TABLE `paciente`
  MODIFY `id_paciente` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=17;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `historia_clinica`
--
ALTER TABLE `historia_clinica`
  ADD CONSTRAINT `historia_clinica_ibfk_1` FOREIGN KEY (`id_paciente`) REFERENCES `paciente` (`id_paciente`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `historia_clinica_ibfk_2` FOREIGN KEY (`id_especialistas`) REFERENCES `especialistas` (`id_especialistas`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `historia_clinica_ibfk_3` FOREIGN KEY (`id_copago`) REFERENCES `copago` (`id_copago`) ON DELETE CASCADE ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
