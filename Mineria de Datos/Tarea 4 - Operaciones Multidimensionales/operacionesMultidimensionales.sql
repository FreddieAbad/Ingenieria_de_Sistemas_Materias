use practica_dw_operaciones;

select * from `estacion`;
select * from `medicion`;
select * from `responsable`;
select *  from `tiempo`;
select * from `tipoestacion`;
-- DRILL ACROSS
-- general 
CREATE OR REPLACE VIEW tabla_vista_medicion_gb 
AS
SELECT est.pais, test.tipoEstacion,
sum(md.temperaturaCelsius) t_celsius, sum(md.humedadRelativa) hR, sum(md.viento) viento
FROM medicion as md
INNER JOIN estacion as est on md.idestacion=est.idestacion
INNER JOIN responsable as resp on resp.idresponsable=md.idresponsable
INNER JOIN tipoestacion as test on test.idtipoEstacion=md.idtipoestacion
INNER JOIN tiempo as tp on tp.idtiempo = md.idtiempo
GROUP BY test.tipoEstacion;
-- especifico
CREATE OR REPLACE VIEW tabla_vista_medicion_da 
AS
SELECT est.nombreEstacion, est.pais, resp.nombreResponsable,  test.tipoEstacion, tp.mes, tp.anio,
md.temperaturaCelsius t_celsius, md.humedadRelativa hR, md.viento viento
FROM medicion as md
INNER JOIN estacion as est on md.idestacion=est.idestacion
INNER JOIN responsable as resp on resp.idresponsable=md.idresponsable
INNER JOIN tipoestacion as test on test.idtipoEstacion=md.idtipoestacion
INNER JOIN tiempo as tp on tp.idtiempo = md.idtiempo;

select * from tabla_vista_medicion_gb;
select * from tabla_vista_medicion_da;


-- Funcion Pivote
CREATE OR REPLACE VIEW tabla_vista_medicion_piv
AS
SELECT est.nombreEstacion, est.pais, resp.nombreResponsable,  test.tipoEstacion, tp.idtiempo ,tp.mes, tp.anio,
md.temperaturaCelsius t_celsius, md.humedadRelativa hR, md.viento viento
FROM medicion as md
INNER JOIN estacion as est on md.idestacion=est.idestacion
INNER JOIN responsable as resp on resp.idresponsable=md.idresponsable
INNER JOIN tipoestacion as test on test.idtipoEstacion=md.idtipoestacion
INNER JOIN tiempo as tp on tp.idtiempo = md.idtiempo;

CREATE OR REPLACE VIEW tp_nomest
AS
	select nombreEstacion, pais, nombreResponsable, tipoestacion, mes, anio, t_celsius, hR, viento from tabla_vista_medicion_piv order by nombreEstacion;

CREATE OR REPLACE VIEW tp_nomresp
AS
	select nombreResponsable, nombreEstacion, pais, tipoestacion, mes, anio, t_celsius, hR, viento from tabla_vista_medicion_piv order by nombreResponsable ASC;

CREATE OR REPLACE VIEW tp_tipest
AS
	select tipoestacion, nombreEstacion, pais, nombreResponsable, mes, anio, t_celsius, hR, viento from tabla_vista_medicion_piv order by tipoestacion ASC;

select * from tabla_vista_medicion_piv;
select * from tp_nomest;
select * from tp_nomresp;
select * from tp_tipest;

-- PAGE
CREATE OR REPLACE VIEW vista_medicion_page_digital
AS
SELECT est.nombreEstacion, est.pais, resp.nombreResponsable,  test.tipoEstacion, tp.mes, tp.anio,
md.temperaturaCelsius t_celsius, md.humedadRelativa hR, md.viento viento
FROM medicion as md
INNER JOIN estacion as est on md.idestacion=est.idestacion
INNER JOIN responsable as resp on resp.idresponsable=md.idresponsable
INNER JOIN tipoestacion as test on test.idtipoEstacion=md.idtipoestacion
INNER JOIN tiempo as tp on tp.idtiempo = md.idtiempo
where test.idtipoEstacion=1;

CREATE OR REPLACE VIEW vista_medicion_page_analogico
AS
SELECT est.nombreEstacion, est.pais, resp.nombreResponsable,  test.tipoEstacion, tp.mes, tp.anio,
md.temperaturaCelsius t_celsius, md.humedadRelativa hR, md.viento viento
FROM medicion as md
INNER JOIN estacion as est on md.idestacion=est.idestacion
INNER JOIN responsable as resp on resp.idresponsable=md.idresponsable
INNER JOIN tipoestacion as test on test.idtipoEstacion=md.idtipoestacion
INNER JOIN tiempo as tp on tp.idtiempo = md.idtiempo
where test.idtipoEstacion=2;

CREATE OR REPLACE VIEW vista_medicion_page_profesional
AS
SELECT est.nombreEstacion, est.pais, resp.nombreResponsable,  test.tipoEstacion, tp.mes, tp.anio,
md.temperaturaCelsius t_celsius, md.humedadRelativa hR, md.viento viento
FROM medicion as md
INNER JOIN estacion as est on md.idestacion=est.idestacion
INNER JOIN responsable as resp on resp.idresponsable=md.idresponsable
INNER JOIN tipoestacion as test on test.idtipoEstacion=md.idtipoestacion
INNER JOIN tiempo as tp on tp.idtiempo = md.idtiempo
where test.idtipoEstacion=3;

CREATE OR REPLACE VIEW vista_medicion_page_portatil
AS
SELECT est.nombreEstacion, est.pais, resp.nombreResponsable,  test.tipoEstacion, tp.mes, tp.anio,
md.temperaturaCelsius t_celsius, md.humedadRelativa hR, md.viento viento
FROM medicion as md
INNER JOIN estacion as est on md.idestacion=est.idestacion
INNER JOIN responsable as resp on resp.idresponsable=md.idresponsable
INNER JOIN tipoestacion as test on test.idtipoEstacion=md.idtipoestacion
INNER JOIN tiempo as tp on tp.idtiempo = md.idtiempo
where test.idtipoEstacion=4;

select * from vista_medicion_page_digital;
select * from vista_medicion_page_analogico;
select * from vista_medicion_page_profesional;
select * from vista_medicion_page_portatil;
