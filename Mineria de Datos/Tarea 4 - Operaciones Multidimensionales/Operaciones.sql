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
