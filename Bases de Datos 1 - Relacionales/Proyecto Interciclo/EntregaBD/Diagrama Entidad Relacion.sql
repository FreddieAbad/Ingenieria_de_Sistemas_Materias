

select DISTINCT o.IDENCUESTA , o.IDPREGUNTA,en.pregunta,o.idrespuestatexto,o.respuesta from RESPUESTATEXTO o 
INNER JOIN PREGUNTA en ON o.idencuesta=en.IDENCUESTA AND o.idusuario='1212121212' and o.idpregunta=en.idpregunta;


select EN.IDPREGUNTA,o.idencuesta,o.idrespuestatexto, en.pregunta from (RESPUESTATEXTO o)  
inner JOIN PREGUNTA en ON o.idencuesta=en.IDENCUESTA AND o.idusuario='1212121212' and o.idpregunta=en.idpregunta;


select DISTINCT EN.IDPREGUNTA,o.idencuesta,o.idrespuestaopcionmultiple, en.pregunta 
from (respuestaopcionmultiple o)  inner JOIN PREGUNTA en ON o.idencuesta=en.IDENCUESTA where o.idusuario='1212121212' ;

select * from pregunta , USUARIO U WHERE U.CEDULA='1212121212' ;
select * from respuestatexto;

select * from RESPUESTATEXTO;
SELECT PE.IDPREGUNTA,PE.PREGUNTA,PE.IDTIPORESPUESTA,PE.idencuesta pidencuesta  FROM PREGUNTA PE WHERE (PE.IDENCUESTA = 0);
truncate table encuesta;
SELECT COUNT(DISTINCT IDPREGUNTA) FROM PREGUNTA WHERE (IDENCUESTA = 1);