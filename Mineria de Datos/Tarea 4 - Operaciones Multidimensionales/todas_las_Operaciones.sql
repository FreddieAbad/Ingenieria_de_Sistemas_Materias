
/**
  Drill down datos en mayor detalle, bajando por una jerarquia
  definida en un cubo
  Drill up Permite apreciar los datos en menos nivel de detalle, subiendo por una
  jerarquía definida en un cubo
  Para nuestro ejemplo hay dos jerarquias:
        1. Tabla estacion, que contiene estado y pais
        2. Tabla tiempo, que contiene mes y año
 */

/**
  Drill down Conocer el nombre y estado de la estacion donde se tomo esa medicion
 */
select m.idmedicion  identificador,
       m.temperaturaCelsius temp,
       m.radiacionUV radUV,
       m.humedadRelativa humRel,
       m.viento velVi,
       m.idestacion estacionID,
       e.nombreEstacion nombreEstacion,
       e.estado estadoEstacion,
       e.pais paisEstacion
from medicion m
inner join estacion e on m.idestacion = e.idestacion;
/**

/**
  Drill up  solo conocer el idEstacion
 */
select m.idmedicion  identificador,
       m.temperaturaCelsius temp,
       m.radiacionUV radUV,
       m.humedadRelativa humRel,
       m.viento velVi,
       m.idestacion estacionID
from medicion m;
/**
  Drill down tiempo

 */

select m.idmedicion  identificador,
       m.temperaturaCelsius temp,
       m.radiacionUV radUV,
       m.humedadRelativa humRel,
       m.viento velVi,
       m.idtiempo idTiempoT,
       t.mes mesTiempo,
       t.anio anioTiempo
from medicion m
inner join tiempo t on m.idtiempo = t.idtiempo;

/**
  Drill up
 */
select m.idmedicion  identificador,
       m.temperaturaCelsius temp,
       m.radiacionUV radUV,
       m.humedadRelativa humRel,
       m.viento velVi,
       m.idtiempo idTiempo
from medicion m;

/***
    Drill-across
    Funcionamiento similar a drill-down con la diferencia de que no se
    realiza sobre una jerarquía, sino que su forma de ir de lo general a lo
    específico es agregar un atributo a la consulta como nuevo criterio de
    análisis.
 */

/**
   General
 */

SELECT est.pais,
       test.tipoEstacion,
       sum(md.temperaturaCelsius) t_celsius,
       sum(md.humedadRelativa) hR,
       sum(md.viento) viento
FROM medicion as md
INNER JOIN estacion as est on md.idestacion=est.idestacion
INNER JOIN responsable as resp on resp.idresponsable=md.idresponsable
INNER JOIN tipoestacion as test on test.idtipoEstacion=md.idtipoestacion
INNER JOIN tiempo as tp on tp.idtiempo = md.idtiempo
GROUP BY test.tipoEstacion;
/***
  Especifica
 */

SELECT est.nombreEstacion,
       est.pais,
       resp.nombreResponsable,
       test.tipoEstacion,
       tp.mes,
       tp.anio,
       md.temperaturaCelsius t_celsius,
       md.humedadRelativa hR,
       md.viento viento
FROM medicion as md
INNER JOIN estacion as est on md.idestacion=est.idestacion
INNER JOIN responsable as resp on resp.idresponsable=md.idresponsable
INNER JOIN tipoestacion as test on test.idtipoEstacion=md.idtipoestacion
INNER JOIN tiempo as tp on tp.idtiempo = md.idtiempo;

/***
  Roll across no se realiza sobre una jeraquia, para lograr
  su cometido de ir de lo especifico a lo mas general es quitando un atributo
  eliminando de esta manera un criterio de analisis
 */


 select m.idmedicion  identificador,
       m.temperaturaCelsius temp,
       m.radiacionUV radUV,
       m.humedadRelativa humRel,
       m.viento velVi,
       m.idestacion estacionID
from medicion m
inner join estacion e on m.idestacion = e.idestacion;

/***
  Pivot
  Permite seleccionar el orden de visualización de los atributos e indicadores,
  con el objeto de analizar la información desde diferentes perspectivas.
 */
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

/*
  Page
  Presenta el cubo dividido en secciones, a través de los valores de un
  atributo, como si se tratase de páginas de un libro.
 */


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


/**
  Drill-through
  Permite apreciar los datos en su máximo nivel de detalle
  Brinda la posibilidad de analizar cuales son los datos relacionados al
  valor de un indicador, que se ha sumarizado dentro del cubo
  multidimensional
*/
/**
  Consulta por mes especifico
*/
select mes ,count(*) conteo from medicion inner JOIN tiempo t on medicion.idtiempo = t.idtiempo
where mes = 'Dec';
/**
   Vamos a contar cuantas mediciones se han hecho por mes en todo el tiempo
 */
select
       count(t.idtiempo) conteo,
       t.mes mesTiempo
from medicion m
inner join tiempo t on m.idtiempo = t.idtiempo
group by mesTiempo;

/*
  Obtener todo de cada medicion
 */

select
       m.idmedicion ,
       r.nombreResponsable,
       m.temperaturaCelsius,
       m.radiacionUV,
       m.humedadRelativa,
       m.viento,
       e.nombreEstacion nombreEstacion,
       e.estado estadoEstacion,
       e.pais paisEstado,
       t2.tipoEstacion tipoEstacion,
       t.mes mesMedicion,
       t.anio anioMedicion
from medicion m
inner join tiempo t on m.idtiempo = t.idtiempo
inner join estacion e on m.idestacion = e.idestacion
inner join tipoestacion t2 on m.idtipoestacion = t2.idtipoEstacion
inner join responsable r on m.idresponsable = r.idresponsable;

select m.idmedicion  identificador,
       m.temperaturaCelsius temp,
       m.radiacionUV radUV,
       m.humedadRelativa humRel,
       m.viento velVi,
       e.nombreEstacion nombreEstacion,
       e.estado estadoEstacion,
       e.pais paisEstacion
from medicion m
inner join estacion e on m.idestacion = e.idestacion;
