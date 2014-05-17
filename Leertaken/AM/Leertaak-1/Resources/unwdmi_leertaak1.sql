/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


--
-- Create schema unwdmi
--

CREATE DATABASE IF NOT EXISTS unwdmi;
USE unwdmi;

--
-- Definition of table `measurement`
--
DROP TABLE IF EXISTS `measurement`;
CREATE TABLE `measurement` (
  `stn` int(10) unsigned NOT NULL,
  `date` date NOT NULL,
  `time` time NOT NULL,
  `temp` double NOT NULL,
  `dewp` double NOT NULL,
  `stp` double NOT NULL,
  `slp` double NOT NULL,
  `visib` double NOT NULL,
  `wdsp` double NOT NULL,
  `prcp` double NOT NULL,
  `sndp` double NOT NULL,
  `frshtt` int(10) NOT NULL,
  `cldc` double NOT NULL,
  `wnddir` int(10) NOT NULL,
  KEY `FK_measurement_stations` (`stn`),
  CONSTRAINT `FK_measurement_stations` FOREIGN KEY (`stn`) REFERENCES `stations` (`stn`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=ascii;