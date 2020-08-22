-- Creacion Base de Datos
CREATE DATABASE interciclo_dw
    WITH 
    OWNER = postgres
    ENCODING = 'UTF8'
    LC_COLLATE = 'Spanish_Ecuador.1252'
    LC_CTYPE = 'Spanish_Ecuador.1252'
    TABLESPACE = pg_default
    CONNECTION LIMIT = -1;

--Creacion de Tabla
create table personas (
	nombre VARCHAR(50),
	apellido VARCHAR(50),
	cedula VARCHAR(50),
	ciudad VARCHAR(50)
);

--Insercion de Datos
insert into personas (nombre, apellido, cedula, ciudad) values ('victor', 'saquicela', '109599577', 'cuenca');
insert into personas (nombre, apellido, cedula, ciudad) values ('juan', 'perez', '1111111', null);
insert into personas (nombre, apellido, cedula, ciudad) values ('milton', 'castro',null, null);
