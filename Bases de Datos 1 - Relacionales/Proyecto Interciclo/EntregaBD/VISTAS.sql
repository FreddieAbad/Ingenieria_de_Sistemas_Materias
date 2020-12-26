----VISTAS (visualizar encuestaS respondida por un usuario determinado)
CREATE VIEW  VW_ENCUESTAS_X_USUARIO
AS  
        --FINAL LISTO    
        SELECT DISTINCT *
        FROM  (
            SELECT DISTINCT USUARIO.CEDULA, USUARIO.NOMBRES
                FROM USUARIO
                INNER JOIN RESPUESTATEXTO ON respuestatexto.idusuario=usuario.cedula
                INNER JOIN RESPUESTAOPCIONMULTIPLE ON respuestaopcionmultiple.idusuario=usuario.cedula
        ), (
            SELECT DISTINCT ENCUESTA.NOMBRE 
            FROM ENCUESTA
                INNER JOIN RESPUESTAOPCIONMULTIPLE ON respuestaopcionmultiple.idencuesta=encuesta.idencuesta
                INNER JOIN RESPUESTATEXTO ON respuestaopcionmultiple.idencuesta=encuesta.idencuesta
        )WHERE CEDULA='0104496765';
        
----VISTAS (visualizar toda la encuesta respondida por un usuario determinado)
CREATE VIEW  VW_ENC_X_USR_1_TEXTO
AS  
        --FINAL LISTO PREGUNTA TEXTO
        SELECT CEDULA, NOMBRES,NOMBRE_ENCUESTA,ID_RESPUESTA_TEXTO,PREGUNTA_TEXTO
        FROM (
            SELECT DISTINCT *
            FROM  ENCUESTA,(
                SELECT DISTINCT USUARIO.CEDULA,USUARIO.NOMBRES 
                    FROM USUARIO
                    INNER JOIN RESPUESTATEXTO ON respuestatexto.idusuario=usuario.cedula
                    INNER JOIN RESPUESTAOPCIONMULTIPLE ON respuestaopcionmultiple.idusuario=usuario.cedula
            ),
            (
                SELECT DISTINCT ENCUESTA.NOMBRE NOMBRE_ENCUESTA
                FROM ENCUESTA
                    INNER JOIN RESPUESTAOPCIONMULTIPLE ON respuestaopcionmultiple.idencuesta=encuesta.idencuesta
                    INNER JOIN RESPUESTATEXTO ON respuestaopcionmultiple.idencuesta=encuesta.idencuesta
            ),(
                SELECT DISTINCT respuestatexto.idpregunta ID_RESPUESTA_TEXTO, pregunta.pregunta PREGUNTA_TEXTO
                FROM respuestatexto
                    INNER JOIN USUARIO ON respuestatexto.idusuario=usuario.cedula
                    INNER JOIN PREGUNTA ON respuestatexto.idpregunta=PREGUNTA.idpregunta
            )
            WHERE CEDULA='0104496765' and ENCUESTA.IDENCUESTA=0
        );
----VISTAS (visualizar toda la encuesta respondida por un usuario determinado)
CREATE VIEW  VW_ENC_X_USR_1_OM
AS  
    --FINAL LISTO RESPUESTA OM
        SELECT CEDULA, NOMBRES, NOMBRE_ENCUESTA, ID_PREGUNTA_OPCIONMULTIPLE,PREGUNTA_OM 
        FROM (
            SELECT DISTINCT *
            FROM  ENCUESTA,(
                SELECT DISTINCT USUARIO.CEDULA, USUARIO.NOMBRES
                    FROM USUARIO
                    INNER JOIN RESPUESTATEXTO ON respuestatexto.idusuario=usuario.cedula
                    INNER JOIN RESPUESTAOPCIONMULTIPLE ON respuestaopcionmultiple.idusuario=usuario.cedula
            ), (
                SELECT DISTINCT ENCUESTA.NOMBRE NOMBRE_ENCUESTA
                FROM ENCUESTA
                    INNER JOIN RESPUESTAOPCIONMULTIPLE ON respuestaopcionmultiple.idencuesta=encuesta.idencuesta
                    INNER JOIN RESPUESTATEXTO ON respuestaopcionmultiple.idencuesta=encuesta.idencuesta
            ),(
                SELECT DISTINCT RESPUESTAOPCIONMULTIPLE.idpregunta ID_PREGUNTA_OPCIONMULTIPLE, respuestaopcionmultiple.idpregunta PREGUNTA_OM
                FROM RESPUESTAOPCIONMULTIPLE
                    INNER JOIN USUARIO ON RESPUESTAOPCIONMULTIPLE.idusuario=usuario.cedula
                    INNER JOIN PREGUNTA ON RESPUESTAOPCIONMULTIPLE.idpregunta=PREGUNTA.idpregunta
            )
            WHERE CEDULA='0104496765' and ENCUESTA.IDENCUESTA=0
        );        

---VISTA ESTADISTICA PREGUNTA
CREATE VIEW VW_ESTADISTICA_PREG_RESP
AS
    --TABLA CON RESPUESTA 
    SELECT * FROM
    (
        SELECT ID_ENCUESTA, ID_TENCUESTA,ID_PREGUNTA_R1,TIPO_RESPUESTA,ID_RESPUESTA,nombreopcion RESPUESTA
            FROM
            (    SELECT  DISTINCT respuestaopcionmultiple.IDENCUESTA ID_ENCUESTA ,ENCOM.idtipoencuesta ID_TENCUESTA,
                respuestaopcionmultiple.idpregunta ID_PREGUNTA_R1 , pregunta.idtiporespuesta TIPO_RESPUESTA,
                respuestaopcionmultiple.IDRESPUESTAOPCIONMULTIPLE ID_RESPUESTA,
                respuestaopcionmultiple.idopcion RESPUESTA
                    FROM ENCUESTA ENCOM
                        INNER JOIN RESPUESTAOPCIONMULTIPLE ON respuestaopcionmultiple.idencuesta=ENCOM.idencuesta
                        INNER JOIN pregunta ON pregunta.idpregunta=respuestaopcionmultiple.idpregunta AND PREGUNTA.IDENCUESTA=ENCOM.IDENCUESTA
            ),OPCIONES WHERE(
                opciones.idopcion=RESPUESTA
                --AND
                --ESTA LINEA HACE QUE SE FILTRE POR PREGUNTAS
                --opciones.idpregunta=1
             )   
    )FULL OUTER JOIN(          
        SELECT DISTINCT enctx.idencuesta ID_ENCUESTA, ENCTX.idtipoencuesta ID_TENCUESTA, RESPUESTATEXTO.idpregunta ID_PREGUNTA_R,pregunta.idtiporespuesta TIPO_RESPUESTA1 ,respuestatexto.idrespuestatexto ID_RESPUESTA,RESPUESTATEXTO.respuesta RESPUESTA
            FROM ENCUESTA ENCTX
                INNER JOIN RESPUESTATEXTO ON RESPUESTATEXTO.idencuesta=ENCTX.idencuesta  
                INNER JOIN pregunta ON pregunta.idpregunta=RESPUESTATEXTO.idpregunta AND PREGUNTA.IDENCUESTA=ENCTX.IDENCUESTA
            --WHERE 
                --FILTRO POR PREGUNTA
                --RESPUESTATEXTO.IDPREGUNTA=1
     )ON ID_PREGUNTA_R1=ID_PREGUNTA_R
     --WHERE TIPO_RESPUESTA1=TIPO_RESPUESTA
     ;
    


SELECT * FROM vw_enc_x_usr_1_om;
SELECT * FROM vw_enc_x_usr_1_texto;
SELECT * FROM vw_encuestas_x_usuario;
SELECT * FROM vw_estadistica_preg_resp;
SELECT * FROM vw_enc_x_usr_1_om;
-------
----------------
-----------------
select Username 
from v$session
where audsid = SYS_CONTEXT('USERENV','sessionid'); 

DESC v$session

------
SELECT USERNAME, ACTION_NAME,EXTENDED_TIMESTAMP,RETURNCODE FROM DBA_AUDIT_SESSION;
commit;

































create or replace function prettyerrors (p_coderror number)
return varchar2 is 
  msg varchar2(50);
begin
  case p_coderror
    when 1017 then msg := 'bad password';
    when 28000 then msg := 'account locked';
    else msg := 'unknown';
  end case;
return msg;
end prettyerrors;
/
 
create or replace procedure FailedCons 
is 
  cursor c_es 
  is 
  select username, action_name, returncode, extended_timestamp 
  from dba_audit_session 
  where action_name='LOGON' 
  and returncode != 0 
  order by extended_timestamp; 
begin 
  for a in c_es loop
    dbms_output.put_line('Usuario: '|| a.username); 
    dbms_output.put_line('Fecha: '|| a.extended_timestamp); 
    dbms_output.put_line('Motivo: ' || prettyerrors(a.returncode));    
    dbms_output.put_line('------------------'); 
  end loop; 
end FailedCons;
/