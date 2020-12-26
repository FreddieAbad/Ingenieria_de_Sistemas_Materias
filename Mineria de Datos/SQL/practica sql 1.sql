--SELECT generate_series(1,10) AS id, md5(random()::text) AS descr;
INSERT INTO cliente (id_cliente,nombre) VALUES (1,'Cathleen Parker'),(2,'Phillip Mercado'),(3,'Griffith Hudson'),(4,'Ian Lang'),(5,'Daria Daniel'),(6,'Serena Harrington'),(7,'Amy Alvarado'),(8,'Justina Holman'),(9,'Briar Booth'),(10,'Declan Petty'),(11,'Cruz Torres'),(12,'Jena Moreno'),(13,'Thane Simmons'),(14,'Daphne Shelton'),(15,'Signe Pruitt'),(16,'Hakeem Wilkinson'),(17,'Phyllis Cobb'),(18,'Emery Howe'),(19,'Alexandra Harper'),(20,'Rhoda Odonnell'),(21,'Nyssa Morton'),(22,'Adrian Thornton'),(23,'Gray Riddle'),(24,'Ignatius Moses'),(25,'Carl Holman'),(26,'Vaughan Thornton'),(27,'Callum Bradford'),(28,'Sara Sellers'),(29,'Vanna Lang'),(30,'Silas Zamora'),(31,'Keane Garrett'),(32,'Eleanor Campos'),(33,'Nissim Newman'),(34,'Josiah Mathews'),(35,'Patience Norton'),(36,'Shaeleigh Ray'),(37,'Jescie Sanford'),(38,'Duncan Wiggins'),(39,'Jamal Marks'),(40,'Driscoll Duncan'),(41,'James Pena'),(42,'Kirsten Odom'),(43,'Basia Sexton'),(44,'Duncan Lowe'),(45,'Kennan Hutchinson'),(46,'Lysandra Ward'),(47,'Indira Mathews'),(48,'Lilah Gill'),(49,'Jonah Leach'),(50,'Steel Strong'),(51,'Matthew Sherman'),(52,'Sydnee Owen'),(53,'Venus Martin'),(54,'Anika Britt'),(55,'Emma Torres'),(56,'Matthew Woodard'),(57,'Kasimir Pitts'),(58,'Zia Herring'),(59,'Benedict Booth'),(60,'Belle Case'),(61,'Ila Daniel'),(62,'Ivan Rowland'),(63,'Suki Barton'),(64,'Dana Lloyd'),(65,'Trevor Carpenter'),(66,'Sebastian Acosta'),(67,'Indira Rodriguez'),(68,'Reese Vasquez'),(69,'Mannix Mcintyre'),(70,'Gareth Landry'),(71,'Beverly Underwood'),(72,'Skyler Fox'),(73,'Linda Cole'),(74,'Quon Lester'),(75,'Harlan Thompson'),(76,'Thor Clay'),(77,'Whilemina Romero'),(78,'Amery Carroll'),(79,'Bell Mclaughlin'),(80,'Pascale Bowen'),(81,'Jada Contreras'),(82,'Karina Mclaughlin'),(83,'Yolanda Roy'),(84,'Mark Fulton'),(85,'Emery Steele'),(86,'Mikayla Whitley'),(87,'Frances Edwards'),(88,'Lana Salas'),(89,'Kiayada Salazar'),(90,'Noel Sheppard'),(91,'Hilel Willis'),(92,'Wanda Holmes'),(93,'Judith Watson'),(94,'Gareth Russell'),(95,'Wesley English'),(96,'Neil Peterson'),(97,'Stacey Rowe'),(98,'Cruz Perry'),(99,'Cassidy Lawrence'),(100,'Mary Blake');
select * from producto;


INSERT INTO "producto" (id_producto,nombre,stock,precio) VALUES (1,'Duis gravida.',9535,'57.22'),(2,'eros.',1760,'52.90'),(3,'lacinia vitae,',1286,'48.66'),(4,'Nullam velit dui,',8981,'15.64'),(5,'blandit viverra. Donec tempus,',7427,'83.98'),(6,'non, sollicitudin a, malesuada',1442,'1.14'),(7,'sem',3837,'0.58'),(8,'Donec',35,'97.58'),(9,'sed consequat auctor, nunc',9012,'64.62'),(10,'a, arcu. Sed',5190,'35.67');
INSERT INTO "producto" (id_producto,nombre,stock,precio) VALUES (11,'leo,',4768,'35.13'),(12,'et, commodo at, libero.',8328,'73.05'),(13,'fermentum vel, mauris.',2940,'44.48'),(14,'at pede.',2872,'92.91'),(15,'enim diam vel',4657,'11.97'),(16,'felis ullamcorper viverra. Maecenas',102,'65.21'),(17,'aliquam arcu. Aliquam',6402,'82.16'),(18,'habitant morbi tristique',7044,'78.84'),(19,'nunc',763,'99.31'),(20,'ipsum ac mi eleifend',7308,'84.17');
INSERT INTO "producto" (id_producto,nombre,stock,precio) VALUES (21,'eu metus.',8459,'73.16'),(22,'pharetra nibh.',664,'44.48'),(23,'sit amet luctus vulputate,',4741,'77.41'),(24,'ut nisi a',2624,'74.54'),(25,'vel',3100,'55.32'),(26,'libero. Morbi accumsan',260,'49.20'),(27,'placerat. Cras dictum',7778,'13.50'),(28,'litora torquent per',407,'43.34'),(29,'Mauris vestibulum, neque sed',5785,'46.21'),(30,'magna. Duis dignissim',652,'6.41');
INSERT INTO "producto" (id_producto,nombre,stock,precio) VALUES (31,'hendrerit a, arcu. Sed',2094,'40.64'),(32,'eget lacus. Mauris',1106,'8.37'),(33,'pede. Suspendisse',3285,'86.04'),(34,'molestie arcu. Sed',8243,'64.95'),(35,'Aliquam fringilla cursus purus.',7056,'32.41'),(36,'erat, eget tincidunt dui',3547,'66.74'),(37,'neque',411,'74.65'),(38,'Pellentesque',1750,'60.97'),(39,'sed pede. Cum',899,'61.43'),(40,'lectus pede et risus.',4578,'6.71');
INSERT INTO "producto" (id_producto,nombre,stock,precio) VALUES (41,'a,',9183,'82.37'),(42,'nisl',1793,'91.25'),(43,'diam',5559,'59.04'),(44,'malesuada',9947,'51.56'),(45,'nisi. Aenean',6337,'55.84'),(46,'orci, consectetuer euismod',487,'36.39'),(47,'a,',5091,'40.15'),(48,'diam. Sed',9355,'66.33'),(49,'penatibus et magnis',8823,'73.54'),(50,'cursus purus. Nullam',13,'32.19');
INSERT INTO "producto" (id_producto,nombre,stock,precio) VALUES (51,'ornare. In faucibus.',641,'24.03'),(52,'odio.',6718,'91.41'),(53,'vulputate, posuere',3457,'54.62'),(54,'Integer sem',1407,'86.84'),(55,'nunc est,',5393,'19.80'),(56,'velit. Pellentesque',2201,'18.61'),(57,'Sed congue,',2731,'89.66'),(58,'dui. Fusce diam',2813,'75.45'),(59,'sem',7960,'66.30'),(60,'bibendum sed, est.',1168,'35.96');
INSERT INTO "producto" (id_producto,nombre,stock,precio) VALUES (61,'sit amet metus. Aliquam',4203,'51.77'),(62,'ipsum.',9095,'39.67'),(63,'Praesent eu dui.',2815,'98.96'),(64,'sem. Pellentesque ut',6715,'30.21'),(65,'erat.',1278,'10.58'),(66,'in,',5724,'10.86'),(67,'nec, imperdiet nec,',6066,'21.97'),(68,'non arcu. Vivamus sit',502,'23.66'),(69,'nulla. Cras eu tellus',7465,'16.63'),(70,'nec, eleifend non,',8342,'47.95');
INSERT INTO "producto" (id_producto,nombre,stock,precio) VALUES (71,'Cum sociis',9289,'52.09'),(72,'a, malesuada id,',163,'66.68'),(73,'mauris. Morbi',2350,'19.59'),(74,'Vivamus nibh dolor,',6504,'50.84'),(75,'Suspendisse dui. Fusce',2833,'62.07'),(76,'accumsan sed,',3345,'64.32'),(77,'tincidunt, nunc ac mattis',1911,'32.44'),(78,'nulla. In tincidunt',7646,'34.48'),(79,'nunc',6835,'99.19'),(80,'Duis risus odio, auctor',7738,'84.77');
INSERT INTO "producto" (id_producto,nombre,stock,precio) VALUES (81,'malesuada fames',5493,'15.46'),(82,'enim.',9796,'85.91'),(83,'molestie',8402,'64.71'),(84,'In at pede.',7593,'70.80'),(85,'egestas, urna',3916,'83.17'),(86,'Aenean sed pede nec',5180,'87.48'),(87,'ac',5127,'16.66'),(88,'Fusce mi lorem,',7460,'12.24'),(89,'penatibus',7179,'44.96'),(90,'Nulla aliquet. Proin',5371,'45.02');
INSERT INTO "producto" (id_producto,nombre,stock,precio) VALUES (91,'Aliquam ornare, libero at',46,'94.18'),(92,'tellus. Aenean egestas hendrerit',2808,'26.11'),(93,'ultrices. Duis volutpat nunc',5338,'8.10'),(94,'et',3403,'50.35'),(95,'euismod',808,'40.36'),(96,'Donec tempor,',7790,'42.62'),(97,'consectetuer ipsum',6775,'28.80'),(98,'metus vitae velit',137,'89.81'),(99,'orci. Donec nibh. Quisque',795,'40.62'),(100,'aliquet',2605,'51.89');
select * from producto;

INSERT INTO "compra" (id_compra,fecha,id_cliente) VALUES (1,'29/11/2020',8),(2,'04/07/2019',73),(3,'23/10/2019',33),(4,'07/11/2019',25),(5,'14/08/2019',17),(6,'11/02/2020',94),(7,'14/05/2020',57),(8,'11/11/2020',50),(9,'07/01/2021',7),(10,'04/07/2020',19);
INSERT INTO "compra" (id_compra,fecha,id_cliente) VALUES (11,'21/07/2019',33),(12,'24/04/2020',18),(13,'08/02/2021',1),(14,'09/05/2019',100),(15,'05/01/2021',21),(16,'21/04/2019',24),(17,'02/06/2019',11),(18,'03/01/2021',35),(19,'17/11/2019',61),(20,'03/05/2019',95);
INSERT INTO "compra" (id_compra,fecha,id_cliente) VALUES (21,'26/05/2019',16),(22,'10/02/2021',22),(23,'12/01/2021',94),(24,'10/12/2019',57),(25,'03/02/2020',67),(26,'12/01/2020',64),(27,'26/07/2020',79),(28,'03/04/2019',14),(29,'07/06/2020',57),(30,'21/08/2020',22);
INSERT INTO "compra" (id_compra,fecha,id_cliente) VALUES (31,'13/06/2019',11),(32,'28/10/2019',32),(33,'06/12/2019',93),(34,'26/03/2020',31),(35,'28/11/2019',58),(36,'18/12/2020',42),(37,'01/07/2019',41),(38,'15/11/2020',30),(39,'26/11/2019',56),(40,'25/03/2021',73);
INSERT INTO "compra" (id_compra,fecha,id_cliente) VALUES (41,'11/09/2020',73),(42,'12/07/2019',40),(43,'27/08/2020',43),(44,'11/12/2019',95),(45,'16/04/2020',24),(46,'10/04/2020',55),(47,'23/03/2021',78),(48,'27/06/2019',33),(49,'19/10/2020',85),(50,'21/05/2019',79);
INSERT INTO "compra" (id_compra,fecha,id_cliente) VALUES (51,'09/04/2019',96),(52,'31/07/2020',32),(53,'16/04/2020',47),(54,'25/03/2020',52),(55,'08/08/2020',50),(56,'14/08/2020',51),(57,'17/02/2021',72),(58,'01/11/2019',84),(59,'10/03/2020',85),(60,'10/01/2020',1);
INSERT INTO "compra" (id_compra,fecha,id_cliente) VALUES (61,'28/02/2021',55),(62,'13/02/2020',4),(63,'19/01/2021',94),(64,'20/10/2019',8),(65,'23/11/2019',32),(66,'08/05/2020',42),(67,'19/04/2020',66),(68,'26/06/2020',75),(69,'29/07/2020',42),(70,'25/11/2019',60);
INSERT INTO "compra" (id_compra,fecha,id_cliente) VALUES (71,'17/05/2019',46),(72,'14/03/2020',9),(73,'19/09/2019',45),(74,'28/08/2019',77),(75,'15/08/2020',68),(76,'27/07/2019',2),(77,'14/03/2020',60),(78,'02/01/2020',8),(79,'10/07/2019',45),(80,'28/12/2019',48);
INSERT INTO "compra" (id_compra,fecha,id_cliente) VALUES (81,'15/08/2019',60),(82,'14/09/2019',93),(83,'19/07/2020',46),(84,'05/07/2019',60),(85,'05/03/2020',70),(86,'16/09/2020',86),(87,'06/07/2020',48),(88,'07/01/2020',53),(89,'26/09/2019',44),(90,'18/08/2019',89);
INSERT INTO "compra" (id_compra,fecha,id_cliente) VALUES (91,'15/12/2020',41),(92,'08/06/2019',56),(93,'14/07/2019',7),(94,'23/01/2021',86),(95,'21/02/2020',3),(96,'14/11/2020',71),(97,'04/07/2020',48),(98,'17/01/2020',41),(99,'26/06/2019',21),(100,'19/07/2020',76);
select * from compra;



INSERT INTO "compra_producto" (id_compra_producto,id_compra,id_producto,cantidad,precio) VALUES (1,53,34,1572,'5.90'),(2,58,15,230,'0.09'),(3,30,100,799,'4.40'),(4,27,41,47,'7.24'),(5,88,45,680,'2.17'),(6,85,59,1446,'4.85'),(7,13,72,646,'8.55'),(8,98,1,1033,'8.82'),(9,44,9,83,'9.10'),(10,52,97,565,'9.97');
INSERT INTO "compra_producto" (id_compra_producto,id_compra,id_producto,cantidad,precio) VALUES (11,84,41,235,'4.38'),(12,53,8,1010,'2.97'),(13,6,75,640,'2.34'),(14,34,82,1949,'6.47'),(15,27,51,392,'8.50'),(16,41,44,1089,'3.73'),(17,8,54,1685,'0.35'),(18,35,92,896,'1.60'),(19,32,75,497,'2.71'),(20,45,95,1431,'3.19');
INSERT INTO "compra_producto" (id_compra_producto,id_compra,id_producto,cantidad,precio) VALUES (21,50,40,34,'0.36'),(22,58,66,1781,'8.62'),(23,8,11,1182,'5.69'),(24,47,58,334,'9.78'),(25,61,66,510,'6.06'),(26,39,80,1930,'2.60'),(27,67,47,562,'1.04'),(28,47,92,1922,'6.37'),(29,15,17,227,'7.04'),(30,9,27,1589,'5.54');
INSERT INTO "compra_producto" (id_compra_producto,id_compra,id_producto,cantidad,precio) VALUES (31,31,21,1165,'2.25'),(32,58,70,371,'6.39'),(33,20,68,1402,'8.70'),(34,98,54,174,'8.13'),(35,39,46,583,'0.60'),(36,70,86,2033,'2.08'),(37,5,10,1272,'2.62'),(38,38,73,1951,'8.19'),(39,12,81,1897,'3.08'),(40,22,23,1917,'8.26');
INSERT INTO "compra_producto" (id_compra_producto,id_compra,id_producto,cantidad,precio) VALUES (41,3,13,1087,'1.53'),(42,86,16,338,'5.74'),(43,42,56,1379,'1.60'),(44,51,94,199,'6.46'),(45,35,75,1239,'5.59'),(46,65,83,711,'8.14'),(47,47,39,595,'1.24'),(48,62,50,369,'3.76'),(49,17,95,1098,'6.27'),(50,98,38,1111,'6.64');
INSERT INTO "compra_producto" (id_compra_producto,id_compra,id_producto,cantidad,precio) VALUES (51,16,2,362,'3.91'),(52,64,97,934,'1.97'),(53,91,88,53,'9.69'),(54,26,2,1632,'6.82'),(55,9,12,720,'7.43'),(56,85,21,1529,'0.37'),(57,10,62,1470,'0.09'),(58,40,56,1736,'3.23'),(59,44,98,974,'5.48'),(60,37,82,1266,'5.92');
INSERT INTO "compra_producto" (id_compra_producto,id_compra,id_producto,cantidad,precio) VALUES (61,96,3,1148,'1.31'),(62,49,68,1954,'5.75'),(63,22,72,971,'2.53'),(64,93,100,636,'5.78'),(65,63,85,1767,'4.59'),(66,33,93,743,'3.90'),(67,55,53,368,'1.89'),(68,63,39,1966,'8.64'),(69,17,91,374,'8.23'),(70,78,68,1443,'7.29');
INSERT INTO "compra_producto" (id_compra_producto,id_compra,id_producto,cantidad,precio) VALUES (71,45,50,1034,'3.39'),(72,97,17,1666,'7.36'),(73,96,47,652,'2.17'),(74,53,6,940,'9.75'),(75,19,69,839,'4.02'),(76,45,6,1426,'9.80'),(77,28,46,1036,'3.32'),(78,95,22,798,'5.74'),(79,46,69,716,'8.67'),(80,47,55,1405,'1.04');
INSERT INTO "compra_producto" (id_compra_producto,id_compra,id_producto,cantidad,precio) VALUES (81,66,1,1959,'4.67'),(82,40,77,467,'9.36'),(83,1,16,1100,'3.50'),(84,99,71,682,'4.85'),(85,70,45,1665,'9.29'),(86,59,12,1902,'8.15'),(87,22,23,954,'6.10'),(88,61,7,1770,'6.20'),(89,28,46,1941,'2.39'),(90,86,60,486,'0.83');
INSERT INTO "compra_producto" (id_compra_producto,id_compra,id_producto,cantidad,precio) VALUES (91,72,38,645,'3.13'),(92,17,100,280,'9.82'),(93,25,78,1301,'7.06'),(94,34,94,1825,'8.87'),(95,79,74,1456,'2.55'),(96,89,70,1587,'1.64'),(97,97,52,1184,'9.75'),(98,46,16,1418,'1.60'),(99,14,17,1167,'0.33'),(100,48,97,1899,'6.32');
select * from compra_producto;

--Consulta de todo
select cl.id_cliente,cl.nombre cliente, co.id_compra, co.fecha, pr.nombre producto , pr.precio Precio_Producto, pr.stock, cp.cantidad Cantidad_Compra, cp.precio Precio_Compra
from compra_producto cp, compra co, producto pr, cliente cl where cl.id_cliente=co.id_cliente and co.id_compra=cp.id_compra and cp.id_producto=pr.id_producto; 
--consulta datos calculo de datos precio
select cl.nombre cliente, co.id_compra, co.fecha, pr.nombre producto , pr.precio Precio_Producto, pr.precio*cp.cantidad precio_tot_producto, cp.cantidad Cantidad_Compra, cp.precio Precio_Compra, cp.precio*cp.cantidad precio_tot_compra
from compra_producto cp, compra co, producto pr, cliente cl where cl.id_cliente=co.id_cliente and co.id_compra=cp.id_compra and cp.id_producto=pr.id_producto; 





-- FUNCIONES DE AGREGACION
-- https://www.postgresql.org/docs/12/functions-aggregate.html
-- Contar datos distintos segun nombre columna
SELECT COUNT(*) FROM (SELECT DISTINCT cantidad FROM compra_producto) AS temp;
--promedio de columna
SELECT avg(cantidad) FROM compra_producto;
--minimo de columna
SELECT min(cantidad) FROM compra_producto;
--maximo de columna
SELECT max(cantidad) FROM compra_producto;
-- group by, agrupa segun columna que designo
select cantidad, max(id_compra_producto), precio from compra_producto
group by id_compra_producto;


select cantidad, max(id_compra_producto), precio from compra_producto
group by id_compra_producto,cantidad;

--having cuando cumple una funcion, cuando trabaja en un grupo no en la tabla inicial
select cantidad, max(id_compra_producto), precio from compra_producto
group by id_compra_producto,cantidad
having precio>1;

--between
select cantidad, id_compra_producto, precio from compra_producto
where precio between 0.1 and 1;
--not between
select cantidad, id_compra_producto, precio from compra_producto
where precio between 0.1 and 1;
