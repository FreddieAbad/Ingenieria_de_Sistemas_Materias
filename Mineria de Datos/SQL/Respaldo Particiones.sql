use dw_practicas;
------------------------------------------------------------------------------------------------------
------------------------------------- PARTICIONAMIENTO HORIZONTAL ------------------------------------
------------------------------------------------------------------------------------------------------

-- PARTICIONAMIENTO H. POR ESTRATEGIA RANGE
DROP TABLE IF EXISTS ventas_range;

CREATE TABLE ventas_range(
  id_venta INT,
  id_producto INT,
  fecha DATE,
  cantidad REAL,
  precio REAL
) 
PARTITION BY RANGE (YEAR(fecha)) (
  PARTITION `ventas_2019`
  VALUES
    LESS THAN (2020),
    PARTITION `ventas_2020`
  VALUES
    LESS THAN (2021),
    PARTITION `ventas_2021`
  VALUES
    LESS THAN (2022)
);

-- INSERTAR DATOS
INSERT INTO `ventas_range` (`id_venta`,`id_producto`,`fecha`,`cantidad`,`precio`) VALUES (1,8,"2020/06/24",18,"6.25"),(2,6,"2020/09/18",2,"2.23"),(3,4,"2019/12/05",94,"8.64"),(4,8,"2019/07/08",95,"9.78"),(5,1,"2019/08/26",96,"8.83"),(6,10,"2019/11/18",29,"8.02"),(7,8,"2019/11/21",15,"6.42"),(8,10,"2019/12/17",19,"3.29"),(9,8,"2019/04/12",13,"9.37"),(10,4,"2019/09/10",9,"9.27"),(11,4,"2020/12/28",94,"3.38"),(12,4,"2021/01/11",36,"4.76"),(13,8,"2019/12/15",31,"9.13"),(14,5,"2020/01/09",41,"4.33"),(15,3,"2019/04/06",29,"2.87"),(16,4,"2020/02/14",73,"9.17"),(17,2,"2020/08/10",7,"9.75"),(18,8,"2019/04/30",53,"3.22"),(19,3,"2019/05/26",86,"0.50"),(20,7,"2020/04/08",74,"3.74"),(21,7,"2019/10/12",42,"6.77"),(22,1,"2021/01/10",44,"5.58"),(23,10,"2019/11/24",26,"1.11"),(24,7,"2019/11/06",80,"5.34"),(25,3,"2019/08/23",74,"2.88"),(26,6,"2020/04/24",84,"0.74"),(27,6,"2020/02/17",18,"0.20"),(28,1,"2021/02/17",61,"1.67"),(29,5,"2020/02/07",14,"7.91"),(30,5,"2019/10/02",93,"2.94"),(31,8,"2019/12/25",99,"7.01"),(32,1,"2020/02/07",98,"5.64"),(33,1,"2020/09/23",98,"3.62"),(34,3,"2019/04/26",24,"2.85"),(35,2,"2020/07/04",13,"7.27"),(36,2,"2019/04/08",45,"9.82"),(37,5,"2020/08/16",68,"8.06"),(38,4,"2019/04/18",42,"1.49"),(39,8,"2020/06/10",79,"6.04"),(40,9,"2020/05/29",93,"9.12"),(41,10,"2020/04/26",44,"8.34"),(42,7,"2020/05/22",1,"3.16"),(43,8,"2021/01/14",14,"8.04"),(44,8,"2019/08/03",84,"7.53"),(45,8,"2021/02/12",9,"5.79"),(46,2,"2020/08/22",31,"9.63"),(47,5,"2019/05/22",64,"2.31"),(48,4,"2020/10/03",17,"8.31"),(49,1,"2020/12/26",31,"7.05"),(50,10,"2020/09/22",50,"5.77"),(51,2,"2020/11/24",81,"8.85"),(52,1,"2019/07/15",83,"5.53"),(53,4,"2019/12/06",27,"1.30"),(54,10,"2021/01/14",39,"3.38"),(55,6,"2019/10/23",62,"8.07"),(56,3,"2019/12/24",27,"8.85"),(57,9,"2020/09/11",6,"5.47"),(58,9,"2020/03/18",53,"9.56"),(59,10,"2020/07/13",26,"2.48"),(60,2,"2020/04/10",81,"0.59"),(61,4,"2020/08/04",53,"3.17"),(62,1,"2019/08/04",77,"5.67"),(63,8,"2020/08/15",36,"0.52"),(64,2,"2019/07/14",89,"2.35"),(65,7,"2020/06/28",48,"0.53"),(66,10,"2020/03/31",69,"0.08"),(67,10,"2020/11/28",4,"7.15"),(68,8,"2020/09/15",97,"6.76"),(69,7,"2019/07/16",35,"2.50"),(70,2,"2019/10/26",56,"9.02"),(71,6,"2020/06/13",38,"9.46"),(72,10,"2021/01/26",9,"7.09"),(73,2,"2020/12/12",93,"7.05"),(74,7,"2021/03/24",4,"2.03"),(75,8,"2021/03/29",90,"9.72"),(76,3,"2019/10/21",42,"1.98"),(77,8,"2020/09/22",75,"8.97"),(78,10,"2020/04/24",46,"1.40"),(79,4,"2019/07/19",15,"7.27"),(80,1,"2020/02/28",50,"9.71"),(81,9,"2020/04/28",39,"1.32"),(82,9,"2020/06/09",23,"0.47"),(83,4,"2019/11/16",35,"4.70"),(84,10,"2019/06/29",74,"9.59"),(85,5,"2021/01/31",71,"3.78"),(86,5,"2019/07/19",49,"0.53"),(87,10,"2020/11/21",95,"9.38"),(88,8,"2020/10/03",58,"8.83"),(89,9,"2019/10/21",83,"2.06"),(90,5,"2020/07/14",21,"0.98"),(91,4,"2019/07/28",1,"6.03"),(92,2,"2020/03/08",46,"2.18"),(93,5,"2020/04/24",58,"1.35"),(94,3,"2019/11/14",30,"6.70"),(95,8,"2019/06/26",72,"3.60"),(96,2,"2020/10/12",92,"8.14"),(97,4,"2019/04/12",65,"9.06"),(98,1,"2019/09/09",49,"7.62"),(99,5,"2020/04/15",34,"4.95"),(100,5,"2019/06/07",3,"8.89");

-- SELECTs particiones
SELECT COUNT(*) FROM ventas_range;

-- Resumen Particiones
SELECT PARTITION_NAME as `Nombre Particion`, TABLE_ROWS
FROM INFORMATION_SCHEMA.PARTITIONS
WHERE TABLE_NAME = 'ventas_range';

-- BORRAR PARTICION
ALTER TABLE `ventas_range` DROP PARTITION `ventas_2020`;
SELECT count(*) FROM `ventas_range` PARTITION (`ventas_2020`); 

-- AGREGAR PARTICION
ALTER TABLE `ventas_range` ADD PARTITION (PARTITION `ventas_2018` VALUES LESS THAN MAXVALUE);
SELECT count(*) FROM `ventas_range` PARTITION (`ventas_2018`); 


---------------------------------------------------
---------------------------------------------------
-- PARTICIONAMIENTO H. POR ESTRATEGIA LIST
DROP TABLE IF EXISTS ventas_list;

CREATE TABLE ventas_list (
	id_venta INT,
	id_producto INT,
	fecha DATE,
	cantidad REAL,
	precio REAL
) 
PARTITION BY LIST(id_producto)
(
	PARTITION venta_fruta VALUES IN (1, 2,3,4),
	PARTITION venta_verdura VALUES IN (5,6,7,8,9,10)
);

-- INSERTAR DATOS
INSERT INTO `ventas_list` (`id_venta`,`id_producto`,`fecha`,`cantidad`,`precio`) VALUES (1,8,"2020/06/24",18,"6.25"),(2,6,"2020/09/18",2,"2.23"),(3,4,"2019/12/05",94,"8.64"),(4,8,"2019/07/08",95,"9.78"),(5,1,"2019/08/26",96,"8.83"),(6,10,"2019/11/18",29,"8.02"),(7,8,"2019/11/21",15,"6.42"),(8,10,"2019/12/17",19,"3.29"),(9,8,"2019/04/12",13,"9.37"),(10,4,"2019/09/10",9,"9.27"),(11,4,"2020/12/28",94,"3.38"),(12,4,"2021/01/11",36,"4.76"),(13,8,"2019/12/15",31,"9.13"),(14,5,"2020/01/09",41,"4.33"),(15,3,"2019/04/06",29,"2.87"),(16,4,"2020/02/14",73,"9.17"),(17,2,"2020/08/10",7,"9.75"),(18,8,"2019/04/30",53,"3.22"),(19,3,"2019/05/26",86,"0.50"),(20,7,"2020/04/08",74,"3.74"),(21,7,"2019/10/12",42,"6.77"),(22,1,"2021/01/10",44,"5.58"),(23,10,"2019/11/24",26,"1.11"),(24,7,"2019/11/06",80,"5.34"),(25,3,"2019/08/23",74,"2.88"),(26,6,"2020/04/24",84,"0.74"),(27,6,"2020/02/17",18,"0.20"),(28,1,"2021/02/17",61,"1.67"),(29,5,"2020/02/07",14,"7.91"),(30,5,"2019/10/02",93,"2.94"),(31,8,"2019/12/25",99,"7.01"),(32,1,"2020/02/07",98,"5.64"),(33,1,"2020/09/23",98,"3.62"),(34,3,"2019/04/26",24,"2.85"),(35,2,"2020/07/04",13,"7.27"),(36,2,"2019/04/08",45,"9.82"),(37,5,"2020/08/16",68,"8.06"),(38,4,"2019/04/18",42,"1.49"),(39,8,"2020/06/10",79,"6.04"),(40,9,"2020/05/29",93,"9.12"),(41,10,"2020/04/26",44,"8.34"),(42,7,"2020/05/22",1,"3.16"),(43,8,"2021/01/14",14,"8.04"),(44,8,"2019/08/03",84,"7.53"),(45,8,"2021/02/12",9,"5.79"),(46,2,"2020/08/22",31,"9.63"),(47,5,"2019/05/22",64,"2.31"),(48,4,"2020/10/03",17,"8.31"),(49,1,"2020/12/26",31,"7.05"),(50,10,"2020/09/22",50,"5.77"),(51,2,"2020/11/24",81,"8.85"),(52,1,"2019/07/15",83,"5.53"),(53,4,"2019/12/06",27,"1.30"),(54,10,"2021/01/14",39,"3.38"),(55,6,"2019/10/23",62,"8.07"),(56,3,"2019/12/24",27,"8.85"),(57,9,"2020/09/11",6,"5.47"),(58,9,"2020/03/18",53,"9.56"),(59,10,"2020/07/13",26,"2.48"),(60,2,"2020/04/10",81,"0.59"),(61,4,"2020/08/04",53,"3.17"),(62,1,"2019/08/04",77,"5.67"),(63,8,"2020/08/15",36,"0.52"),(64,2,"2019/07/14",89,"2.35"),(65,7,"2020/06/28",48,"0.53"),(66,10,"2020/03/31",69,"0.08"),(67,10,"2020/11/28",4,"7.15"),(68,8,"2020/09/15",97,"6.76"),(69,7,"2019/07/16",35,"2.50"),(70,2,"2019/10/26",56,"9.02"),(71,6,"2020/06/13",38,"9.46"),(72,10,"2021/01/26",9,"7.09"),(73,2,"2020/12/12",93,"7.05"),(74,7,"2021/03/24",4,"2.03"),(75,8,"2021/03/29",90,"9.72"),(76,3,"2019/10/21",42,"1.98"),(77,8,"2020/09/22",75,"8.97"),(78,10,"2020/04/24",46,"1.40"),(79,4,"2019/07/19",15,"7.27"),(80,1,"2020/02/28",50,"9.71"),(81,9,"2020/04/28",39,"1.32"),(82,9,"2020/06/09",23,"0.47"),(83,4,"2019/11/16",35,"4.70"),(84,10,"2019/06/29",74,"9.59"),(85,5,"2021/01/31",71,"3.78"),(86,5,"2019/07/19",49,"0.53"),(87,10,"2020/11/21",95,"9.38"),(88,8,"2020/10/03",58,"8.83"),(89,9,"2019/10/21",83,"2.06"),(90,5,"2020/07/14",21,"0.98"),(91,4,"2019/07/28",1,"6.03"),(92,2,"2020/03/08",46,"2.18"),(93,5,"2020/04/24",58,"1.35"),(94,3,"2019/11/14",30,"6.70"),(95,8,"2019/06/26",72,"3.60"),(96,2,"2020/10/12",92,"8.14"),(97,4,"2019/04/12",65,"9.06"),(98,1,"2019/09/09",49,"7.62"),(99,5,"2020/04/15",34,"4.95"),(100,5,"2019/06/07",3,"8.89");
-- Resumen Particiones
SELECT PARTITION_NAME as `Nombre Particion`, TABLE_ROWS
FROM INFORMATION_SCHEMA.PARTITIONS
WHERE TABLE_NAME = 'ventas_list';


---------------------------------------------------
---------------------------------------------------
--  PARTICIONAMIENTO H. POR ESTRATEGIA HASH
DROP TABLE IF EXISTS ventas_hash;

CREATE TABLE ventas_hash(
	id_venta INT,
	id_producto INT,
	fecha DATE,
	cantidad REAL,
	precio REAL
) 
PARTITION BY HASH(id_venta)
PARTITIONS 4;

-- INSERTAR DATA
INSERT INTO `ventas_hash` (`id_venta`,`id_producto`,`fecha`,`cantidad`,`precio`) VALUES (1,8,"2020/06/24",18,"6.25"),(2,6,"2020/09/18",2,"2.23"),(3,4,"2019/12/05",94,"8.64"),(4,8,"2019/07/08",95,"9.78"),(5,1,"2019/08/26",96,"8.83"),(6,10,"2019/11/18",29,"8.02"),(7,8,"2019/11/21",15,"6.42"),(8,10,"2019/12/17",19,"3.29"),(9,8,"2019/04/12",13,"9.37"),(10,4,"2019/09/10",9,"9.27"),(11,4,"2020/12/28",94,"3.38"),(12,4,"2021/01/11",36,"4.76"),(13,8,"2019/12/15",31,"9.13"),(14,5,"2020/01/09",41,"4.33"),(15,3,"2019/04/06",29,"2.87"),(16,4,"2020/02/14",73,"9.17"),(17,2,"2020/08/10",7,"9.75"),(18,8,"2019/04/30",53,"3.22"),(19,3,"2019/05/26",86,"0.50"),(20,7,"2020/04/08",74,"3.74"),(21,7,"2019/10/12",42,"6.77"),(22,1,"2021/01/10",44,"5.58"),(23,10,"2019/11/24",26,"1.11"),(24,7,"2019/11/06",80,"5.34"),(25,3,"2019/08/23",74,"2.88"),(26,6,"2020/04/24",84,"0.74"),(27,6,"2020/02/17",18,"0.20"),(28,1,"2021/02/17",61,"1.67"),(29,5,"2020/02/07",14,"7.91"),(30,5,"2019/10/02",93,"2.94"),(31,8,"2019/12/25",99,"7.01"),(32,1,"2020/02/07",98,"5.64"),(33,1,"2020/09/23",98,"3.62"),(34,3,"2019/04/26",24,"2.85"),(35,2,"2020/07/04",13,"7.27"),(36,2,"2019/04/08",45,"9.82"),(37,5,"2020/08/16",68,"8.06"),(38,4,"2019/04/18",42,"1.49"),(39,8,"2020/06/10",79,"6.04"),(40,9,"2020/05/29",93,"9.12"),(41,10,"2020/04/26",44,"8.34"),(42,7,"2020/05/22",1,"3.16"),(43,8,"2021/01/14",14,"8.04"),(44,8,"2019/08/03",84,"7.53"),(45,8,"2021/02/12",9,"5.79"),(46,2,"2020/08/22",31,"9.63"),(47,5,"2019/05/22",64,"2.31"),(48,4,"2020/10/03",17,"8.31"),(49,1,"2020/12/26",31,"7.05"),(50,10,"2020/09/22",50,"5.77"),(51,2,"2020/11/24",81,"8.85"),(52,1,"2019/07/15",83,"5.53"),(53,4,"2019/12/06",27,"1.30"),(54,10,"2021/01/14",39,"3.38"),(55,6,"2019/10/23",62,"8.07"),(56,3,"2019/12/24",27,"8.85"),(57,9,"2020/09/11",6,"5.47"),(58,9,"2020/03/18",53,"9.56"),(59,10,"2020/07/13",26,"2.48"),(60,2,"2020/04/10",81,"0.59"),(61,4,"2020/08/04",53,"3.17"),(62,1,"2019/08/04",77,"5.67"),(63,8,"2020/08/15",36,"0.52"),(64,2,"2019/07/14",89,"2.35"),(65,7,"2020/06/28",48,"0.53"),(66,10,"2020/03/31",69,"0.08"),(67,10,"2020/11/28",4,"7.15"),(68,8,"2020/09/15",97,"6.76"),(69,7,"2019/07/16",35,"2.50"),(70,2,"2019/10/26",56,"9.02"),(71,6,"2020/06/13",38,"9.46"),(72,10,"2021/01/26",9,"7.09"),(73,2,"2020/12/12",93,"7.05"),(74,7,"2021/03/24",4,"2.03"),(75,8,"2021/03/29",90,"9.72"),(76,3,"2019/10/21",42,"1.98"),(77,8,"2020/09/22",75,"8.97"),(78,10,"2020/04/24",46,"1.40"),(79,4,"2019/07/19",15,"7.27"),(80,1,"2020/02/28",50,"9.71"),(81,9,"2020/04/28",39,"1.32"),(82,9,"2020/06/09",23,"0.47"),(83,4,"2019/11/16",35,"4.70"),(84,10,"2019/06/29",74,"9.59"),(85,5,"2021/01/31",71,"3.78"),(86,5,"2019/07/19",49,"0.53"),(87,10,"2020/11/21",95,"9.38"),(88,8,"2020/10/03",58,"8.83"),(89,9,"2019/10/21",83,"2.06"),(90,5,"2020/07/14",21,"0.98"),(91,4,"2019/07/28",1,"6.03"),(92,2,"2020/03/08",46,"2.18"),(93,5,"2020/04/24",58,"1.35"),(94,3,"2019/11/14",30,"6.70"),(95,8,"2019/06/26",72,"3.60"),(96,2,"2020/10/12",92,"8.14"),(97,4,"2019/04/12",65,"9.06"),(98,1,"2019/09/09",49,"7.62"),(99,5,"2020/04/15",34,"4.95"),(100,5,"2019/06/07",3,"8.89");

-- Resumen Particiones
SELECT PARTITION_NAME as `Nombre Particion`, TABLE_ROWS
FROM INFORMATION_SCHEMA.PARTITIONS
WHERE TABLE_NAME = 'ventas_hash';
-- DELETE PARTICIONES
ALTER TABLE `ventas_hash` DISCARD PARTITION `p0`,`p1`,`p2`,`p3` TABLESPACE;
SELECT count(*) FROM `ventas_hash` PARTITION (`p0`); 

---------------------------------------------------
---------------------------------------------------
-- PARTICIONAMIENTO H. POR ESTRATEGIA KEY
DROP TABLE IF EXISTS `ventas_key`;

CREATE TABLE `ventas_key`(
	id_venta INT PRIMARY KEY,
	id_producto INT,
	fecha DATE,
	cantidad REAL,
	precio REAL
) 
PARTITION BY KEY()
PARTITIONS 2;

-- INSERTAR DATA
INSERT INTO `ventas_key` (`id_venta`,`id_producto`,`fecha`,`cantidad`,`precio`) VALUES (1,8,"2020/06/24",18,"6.25"),(2,6,"2020/09/18",2,"2.23"),(3,4,"2019/12/05",94,"8.64"),(4,8,"2019/07/08",95,"9.78"),(5,1,"2019/08/26",96,"8.83"),(6,10,"2019/11/18",29,"8.02"),(7,8,"2019/11/21",15,"6.42"),(8,10,"2019/12/17",19,"3.29"),(9,8,"2019/04/12",13,"9.37"),(10,4,"2019/09/10",9,"9.27"),(11,4,"2020/12/28",94,"3.38"),(12,4,"2021/01/11",36,"4.76"),(13,8,"2019/12/15",31,"9.13"),(14,5,"2020/01/09",41,"4.33"),(15,3,"2019/04/06",29,"2.87"),(16,4,"2020/02/14",73,"9.17"),(17,2,"2020/08/10",7,"9.75"),(18,8,"2019/04/30",53,"3.22"),(19,3,"2019/05/26",86,"0.50"),(20,7,"2020/04/08",74,"3.74"),(21,7,"2019/10/12",42,"6.77"),(22,1,"2021/01/10",44,"5.58"),(23,10,"2019/11/24",26,"1.11"),(24,7,"2019/11/06",80,"5.34"),(25,3,"2019/08/23",74,"2.88"),(26,6,"2020/04/24",84,"0.74"),(27,6,"2020/02/17",18,"0.20"),(28,1,"2021/02/17",61,"1.67"),(29,5,"2020/02/07",14,"7.91"),(30,5,"2019/10/02",93,"2.94"),(31,8,"2019/12/25",99,"7.01"),(32,1,"2020/02/07",98,"5.64"),(33,1,"2020/09/23",98,"3.62"),(34,3,"2019/04/26",24,"2.85"),(35,2,"2020/07/04",13,"7.27"),(36,2,"2019/04/08",45,"9.82"),(37,5,"2020/08/16",68,"8.06"),(38,4,"2019/04/18",42,"1.49"),(39,8,"2020/06/10",79,"6.04"),(40,9,"2020/05/29",93,"9.12"),(41,10,"2020/04/26",44,"8.34"),(42,7,"2020/05/22",1,"3.16"),(43,8,"2021/01/14",14,"8.04"),(44,8,"2019/08/03",84,"7.53"),(45,8,"2021/02/12",9,"5.79"),(46,2,"2020/08/22",31,"9.63"),(47,5,"2019/05/22",64,"2.31"),(48,4,"2020/10/03",17,"8.31"),(49,1,"2020/12/26",31,"7.05"),(50,10,"2020/09/22",50,"5.77"),(51,2,"2020/11/24",81,"8.85"),(52,1,"2019/07/15",83,"5.53"),(53,4,"2019/12/06",27,"1.30"),(54,10,"2021/01/14",39,"3.38"),(55,6,"2019/10/23",62,"8.07"),(56,3,"2019/12/24",27,"8.85"),(57,9,"2020/09/11",6,"5.47"),(58,9,"2020/03/18",53,"9.56"),(59,10,"2020/07/13",26,"2.48"),(60,2,"2020/04/10",81,"0.59"),(61,4,"2020/08/04",53,"3.17"),(62,1,"2019/08/04",77,"5.67"),(63,8,"2020/08/15",36,"0.52"),(64,2,"2019/07/14",89,"2.35"),(65,7,"2020/06/28",48,"0.53"),(66,10,"2020/03/31",69,"0.08"),(67,10,"2020/11/28",4,"7.15"),(68,8,"2020/09/15",97,"6.76"),(69,7,"2019/07/16",35,"2.50"),(70,2,"2019/10/26",56,"9.02"),(71,6,"2020/06/13",38,"9.46"),(72,10,"2021/01/26",9,"7.09"),(73,2,"2020/12/12",93,"7.05"),(74,7,"2021/03/24",4,"2.03"),(75,8,"2021/03/29",90,"9.72"),(76,3,"2019/10/21",42,"1.98"),(77,8,"2020/09/22",75,"8.97"),(78,10,"2020/04/24",46,"1.40"),(79,4,"2019/07/19",15,"7.27"),(80,1,"2020/02/28",50,"9.71"),(81,9,"2020/04/28",39,"1.32"),(82,9,"2020/06/09",23,"0.47"),(83,4,"2019/11/16",35,"4.70"),(84,10,"2019/06/29",74,"9.59"),(85,5,"2021/01/31",71,"3.78"),(86,5,"2019/07/19",49,"0.53"),(87,10,"2020/11/21",95,"9.38"),(88,8,"2020/10/03",58,"8.83"),(89,9,"2019/10/21",83,"2.06"),(90,5,"2020/07/14",21,"0.98"),(91,4,"2019/07/28",1,"6.03"),(92,2,"2020/03/08",46,"2.18"),(93,5,"2020/04/24",58,"1.35"),(94,3,"2019/11/14",30,"6.70"),(95,8,"2019/06/26",72,"3.60"),(96,2,"2020/10/12",92,"8.14"),(97,4,"2019/04/12",65,"9.06"),(98,1,"2019/09/09",49,"7.62"),(99,5,"2020/04/15",34,"4.95"),(100,5,"2019/06/07",3,"8.89");
 
-- Resumen Particiones
SELECT PARTITION_NAME as `Nombre Particion`, TABLE_ROWS
FROM INFORMATION_SCHEMA.PARTITIONS
WHERE TABLE_NAME = 'ventas_key';


---------------------------------------------------
---------------------------------------------------
-- PARTICIONAMIENTO H. POR ESTRATEGIA COMPUESTA
DROP TABLE IF EXISTS `ventas_compuesta`;

CREATE TABLE ventas_compuesta(
	id_venta INT,
	id_producto INT,
	fecha DATE,
	cantidad REAL,
	precio REAL
)
PARTITION BY RANGE (YEAR(fecha))
SUBPARTITION BY HASH(TO_DAYS(fecha))
(PARTITION `ventas_c_2019` VALUES LESS THAN (2020) (
	SUBPARTITION s0,
	SUBPARTITION s1
),
	PARTITION `ventas_c_2020` VALUES LESS THAN (2021)(
	SUBPARTITION s2,
	SUBPARTITION s3
),
	PARTITION `ventas_c_undef` VALUES LESS THAN MAXVALUE(
	SUBPARTITION s4,
	SUBPARTITION s5
)
);

-- INSERTAR DATA
INSERT INTO `ventas_compuesta` (`id_venta`,`id_producto`,`fecha`,`cantidad`,`precio`) VALUES (1,8,"2020/06/24",18,"6.25"),(2,6,"2020/09/18",2,"2.23"),(3,4,"2019/12/05",94,"8.64"),(4,8,"2019/07/08",95,"9.78"),(5,1,"2019/08/26",96,"8.83"),(6,10,"2019/11/18",29,"8.02"),(7,8,"2019/11/21",15,"6.42"),(8,10,"2019/12/17",19,"3.29"),(9,8,"2019/04/12",13,"9.37"),(10,4,"2019/09/10",9,"9.27"),(11,4,"2020/12/28",94,"3.38"),(12,4,"2021/01/11",36,"4.76"),(13,8,"2019/12/15",31,"9.13"),(14,5,"2020/01/09",41,"4.33"),(15,3,"2019/04/06",29,"2.87"),(16,4,"2020/02/14",73,"9.17"),(17,2,"2020/08/10",7,"9.75"),(18,8,"2019/04/30",53,"3.22"),(19,3,"2019/05/26",86,"0.50"),(20,7,"2020/04/08",74,"3.74"),(21,7,"2019/10/12",42,"6.77"),(22,1,"2021/01/10",44,"5.58"),(23,10,"2019/11/24",26,"1.11"),(24,7,"2019/11/06",80,"5.34"),(25,3,"2019/08/23",74,"2.88"),(26,6,"2020/04/24",84,"0.74"),(27,6,"2020/02/17",18,"0.20"),(28,1,"2021/02/17",61,"1.67"),(29,5,"2020/02/07",14,"7.91"),(30,5,"2019/10/02",93,"2.94"),(31,8,"2019/12/25",99,"7.01"),(32,1,"2020/02/07",98,"5.64"),(33,1,"2020/09/23",98,"3.62"),(34,3,"2019/04/26",24,"2.85"),(35,2,"2020/07/04",13,"7.27"),(36,2,"2019/04/08",45,"9.82"),(37,5,"2020/08/16",68,"8.06"),(38,4,"2019/04/18",42,"1.49"),(39,8,"2020/06/10",79,"6.04"),(40,9,"2020/05/29",93,"9.12"),(41,10,"2020/04/26",44,"8.34"),(42,7,"2020/05/22",1,"3.16"),(43,8,"2021/01/14",14,"8.04"),(44,8,"2019/08/03",84,"7.53"),(45,8,"2021/02/12",9,"5.79"),(46,2,"2020/08/22",31,"9.63"),(47,5,"2019/05/22",64,"2.31"),(48,4,"2020/10/03",17,"8.31"),(49,1,"2020/12/26",31,"7.05"),(50,10,"2020/09/22",50,"5.77"),(51,2,"2020/11/24",81,"8.85"),(52,1,"2019/07/15",83,"5.53"),(53,4,"2019/12/06",27,"1.30"),(54,10,"2021/01/14",39,"3.38"),(55,6,"2019/10/23",62,"8.07"),(56,3,"2019/12/24",27,"8.85"),(57,9,"2020/09/11",6,"5.47"),(58,9,"2020/03/18",53,"9.56"),(59,10,"2020/07/13",26,"2.48"),(60,2,"2020/04/10",81,"0.59"),(61,4,"2020/08/04",53,"3.17"),(62,1,"2019/08/04",77,"5.67"),(63,8,"2020/08/15",36,"0.52"),(64,2,"2019/07/14",89,"2.35"),(65,7,"2020/06/28",48,"0.53"),(66,10,"2020/03/31",69,"0.08"),(67,10,"2020/11/28",4,"7.15"),(68,8,"2020/09/15",97,"6.76"),(69,7,"2019/07/16",35,"2.50"),(70,2,"2019/10/26",56,"9.02"),(71,6,"2020/06/13",38,"9.46"),(72,10,"2021/01/26",9,"7.09"),(73,2,"2020/12/12",93,"7.05"),(74,7,"2021/03/24",4,"2.03"),(75,8,"2021/03/29",90,"9.72"),(76,3,"2019/10/21",42,"1.98"),(77,8,"2020/09/22",75,"8.97"),(78,10,"2020/04/24",46,"1.40"),(79,4,"2019/07/19",15,"7.27"),(80,1,"2020/02/28",50,"9.71"),(81,9,"2020/04/28",39,"1.32"),(82,9,"2020/06/09",23,"0.47"),(83,4,"2019/11/16",35,"4.70"),(84,10,"2019/06/29",74,"9.59"),(85,5,"2021/01/31",71,"3.78"),(86,5,"2019/07/19",49,"0.53"),(87,10,"2020/11/21",95,"9.38"),(88,8,"2020/10/03",58,"8.83"),(89,9,"2019/10/21",83,"2.06"),(90,5,"2020/07/14",21,"0.98"),(91,4,"2019/07/28",1,"6.03"),(92,2,"2020/03/08",46,"2.18"),(93,5,"2020/04/24",58,"1.35"),(94,3,"2019/11/14",30,"6.70"),(95,8,"2019/06/26",72,"3.60"),(96,2,"2020/10/12",92,"8.14"),(97,4,"2019/04/12",65,"9.06"),(98,1,"2019/09/09",49,"7.62"),(99,5,"2020/04/15",34,"4.95"),(100,5,"2019/06/07",3,"8.89");

-- Resumen Particiones
SELECT PARTITION_NAME as `Nombre Particion`, TABLE_ROWS
FROM INFORMATION_SCHEMA.PARTITIONS
WHERE TABLE_NAME = 'ventas_compuesta';
-- Ejemplo select en subparticiones
SELECT * FROM `ventas_compuesta` PARTITION (`ventas_c_undef`); 



