
--------------------------------------------------------------------------------------------------------------------------------
--------------------------------------------------BITACORA----------------------------------------------------------------------
--------------------------------------------------------------------------------------------------------------------------------

--CREO TABLA BITACORA
CREATE TABLE bitacora(
    id_bitacora INT,
    fecha DATE,
    usr VARCHAR(250),
    cuenta_anterior INT,
    cuenta_actual INT,
    operacion VARCHAR(250),
    PRIMARY KEY(id_bitacora)
);
--CREA SEQUENCE
CREATE SEQUENCE sec_bitacora INCREMENT BY 1 START WITH 1;
--------------------------------------------------------------------------------------------------------------------------------
-------------------------------------------------BITACORA-----------------------------------------------------------------------
--------------------------------------------------------------------------------------------------------------------------------

CREATE OR REPLACE TRIGGER trg_bitacora
BEFORE INSERT ON bitacora
FOR EACH ROW
BEGIN
SELECT sec_bitacora.NextVal INTO :new.id_bitacora FROM dual;
END;


--trigger
CREATE OR REPLACE TRIGGER trg_encuesta
BEFORE INSERT OR UPDATE OR DELETE ON ENCUESTA
FOR EACH ROW
DECLARE operador VARCHAR(255);
BEGIN 
IF INSERTING THEN operador:='Insertando'; END IF;
IF UPDATING THEN operador:='Editando'; END IF;
IF DELETING THEN operador:='Borrando'; END IF;
INSERT INTO BITACORA(fecha,usr,cuenta_anterior,cuenta_actual,operacion) VALUES (SYSDATE,'Mervin Saquic',:old.idencuesta,:new.idencuesta,operador);
END;

INSERT INTO ENCUESTA(IDENCUESTA,NOMBRE,DESCRIPCION,IDTIPOENCUESTA) VALUES (199,'FSD','FSDFFSD',8);
INSERT INTO ENCUESTA(IDENCUESTA,NOMBRE,DESCRIPCION,IDTIPOENCUESTA) VALUES (132,'FSD','FSDFFSD',9);
UPDATE ENCUESTA SET NOMBRE='CAMBIO'  WHERE idencuesta=199;
SELECT * FROM ENCUESTA;
SELECT * FROM BITACORA;

--------------------------------------------------------------------------------------------------------------------------------
--------------------------------------------------------------------------------------------------------------------------------
------------------------BITACORA ENCUESTAS CONTESTADAS POR USUARIO OPCION MULTIPLE----------------------------------------------
--------------------------------------------------------------------------------------------------------------------------------
--------------------------------------------------------------------------------------------------------------------------------
CREATE TABLE BITACORAENCUESTA_USUARIO(
IDBITACORA INT,
USUARIO VARCHAR(250),
OPERACION VARCHAR(250),
FECHA DATE,
NOMBRE VARCHAR2(500),
ENCUESTAANTERIOR INT,
ENCUESTAACTUAL INT,
PRIMARY KEY(IDBITACORA)
);
--DROP TABLE BITACORAENCUESTA_USUARIO
--ME DA EL VALOR DEL INDICE DE IDBITACORA
--DROP SEQUENCE  SECBITACORAENC_USR
CREATE SEQUENCE SECBITACORAENC_USR INCREMENT BY 1 START WITH 1;

CREATE OR REPLACE TRIGGER TRG_BITACORA_ENC_USR
BEFORE INSERT ON BITACORAENCUESTA_USUARIO
FOR EACH ROW
BEGIN
SELECT SECBITACORAENC_USR.NextVal INTO :new.IDBITACORA FROM dual;
END;
--TRIGGER RESPUESTA ENCUESTA
create or replace TRIGGER TRG_ENCUESTA_USUARIO
BEFORE INSERT OR UPDATE OR DELETE ON RESPUESTAOPCIONMULTIPLE
    FOR EACH ROW
    DECLARE 
    operador VARCHAR(255);
    temp VARCHAR(100):='';
BEGIN 
    SELECT e.NOMBRE INTO temp FROM ENCUESTA e WHERE e.IDENCUESTA = :new.IDENCUESTA;
    dbms_output.put(temp);
    operador :='';
    IF INSERTING 
        THEN operador := 'INSERTAR';
    END IF;    
    IF UPDATING 
        THEN operador := 'EDITAR'; 
    END IF;    
    IF DELETING 
        THEN operador := 'BORRAR'; 
    END IF;
    INSERT INTO BITACORAENCUESTA_USUARIO(USUARIO,OPERACION,FECHA,NOMBRE,ENCUESTAANTERIOR,ENCUESTAACTUAL) 
        VALUES (:new.IDUSUARIO,operador,SYSTIMESTAMP ,temp,:old.idencuesta,:new.idencuesta);
END;
create or replace TRIGGER TRG_ENCUESTA_USUARIO_TX
BEFORE INSERT OR UPDATE ON RESPUESTATEXTO
    FOR EACH ROW
    DECLARE 
    operador VARCHAR(255);
    temp VARCHAR(100):='';
BEGIN 
    SELECT e.NOMBRE INTO temp FROM ENCUESTA e WHERE e.IDENCUESTA = :new.IDENCUESTA;
    dbms_output.put(temp);
    operador :='';
    IF INSERTING 
        THEN operador := 'INSERTAR';
    END IF;    
    IF UPDATING 
        THEN operador := 'EDITAR'; 
    END IF;    
    IF DELETING 
        THEN operador := 'BORRAR'; 
    END IF;
    INSERT INTO BITACORAENCUESTA_USUARIO(USUARIO,OPERACION,FECHA,NOMBRE,ENCUESTAANTERIOR,ENCUESTAACTUAL) 
        VALUES (:new.IDUSUARIO,operador,SYSTIMESTAMP ,temp,:old.idencuesta,:new.idencuesta);
END;
---------------------------------------------------------
SELECT * FROM respuestaopcionmultiple;
-----BITACORA

SELECT * FROM bitacoraencuesta_usuario ORDER BY IDBITACORA;
INSERT INTO respuestaopcionmultiple VALUES(86,2,0,1,'2222222222');
UPDATE respuestaopcionmultiple SET IDOPCION=3  WHERE idrespuestaopcionmultiple=7;
--DELETE FROM respuestaopcionmultiple WHERE idrespuestaopcionmultiple=85;

--------------------------------------------------------------------------------------------------------------------------------
--------------------------------------------------------------------------------------------------------------------------------
----------------------------------------BITACORA ENCUESTAS CONTESTADAS POR USUARIO TEXTO----------------------------------------
--------------------------------------------------------------------------------------------------------------------------------
--------------------------------------------------------------------------------------------------------------------------------
create or replace TRIGGER TRG_ENCUESTA_USUARIO_TEXTO
BEFORE INSERT OR UPDATE ON RESPUESTATEXTO
FOR EACH ROW
DECLARE 
operador VARCHAR(255):='';
temp VARCHAR(100):='';
BEGIN 
SELECT e.NOMBRE INTO temp FROM ENCUESTA e WHERE e.IDENCUESTA = :new.IDENCUESTA;
dbms_output.put(temp);
operador :='';
IF INSERTING 
    THEN operador := 'INSERTAR';
END IF;    
IF UPDATING 
    THEN operador := 'EDITAR'; 
END IF;    
INSERT INTO BITACORAENCUESTA_USUARIO(USUARIO,OPERACION,FECHA,NOMBRE,ENCUESTAANTERIOR,ENCUESTAACTUAL) 
    VALUES (:new.IDUSUARIO,operador,SYSDATE,temp,:old.idencuesta,:new.idencuesta);
END;
---
insert into respuestatexto values(4,2,0,'dasd','0104496765');
desc respuestatexto;
select * from bitacoraencuesta_usuario;

------delete
create or replace TRIGGER TRG_ENC_USR_TXT_BRRAR
BEFORE DELETE ON RESPUESTATEXTO
FOR EACH ROW
DECLARE 
operador VARCHAR(255):='';
temp VARCHAR(100):='';
BEGIN 
SELECT e.NOMBRE INTO temp FROM ENCUESTA e WHERE e.IDENCUESTA = :old.IDENCUESTA;
operador :='BORRAR';
INSERT INTO BITACORAENCUESTA_USUARIO(USUARIO,OPERACION,FECHA,NOMBRE,ENCUESTAANTERIOR,ENCUESTAACTUAL) 
    VALUES (:old.IDUSUARIO,operador,SYSDATE,temp,:old.idencuesta,:old.idencuesta);
END;
---
--DROP TRIGGER TRG_ENCUESTA_USUARIO_TX
DELETE FROM respuestatexto WHERE IDRESPUESTATEXTO=4;
desc respuestatexto;
select * from bitacoraencuesta_usuario ORDER BY IDBITACORA;






















ALTER SYSTEM SET AUDIT_TRAIL=DB SCOPE=SPFILE;
AUDIT ALL BY scott BY ACCESS;
  AUDIT SESSION;
--recracion de ALTER SYSTEM ENABLE RESTRICTED SESSION lo siguiente
-- https://asktom.oracle.com/pls/asktom/f?p=100:11:0::::P11_QUESTION_ID:49818662859946
CREATE OR REPLACE TRIGGER logon_system_maintenance
AFTER LOGON on DATABASE 
declare
    system_is_connected varchar2(1) := 'N';
BEGIN
    select 'Y' into system_is_connected
    from v$session 
    where username = 'SYSTEM' and status = 'ACTIVE';

    -- this will not prevent users with ADMINISTER DATABASE TRIGGER privilege from connecting
    RAISE_APPLICATION_ERROR (-20001, 'SYSTEM user is performing maintenance, please try again later');

EXCEPTION
    WHEN NO_DATA_FOUND THEN
        null; -- system not connected, OK
    WHEN OTHERS THEN
        null; -- probably the user doesn't have permission to view V$SESSION! 
        -- should they be able to connect, or not?
END;
---
create or replace trigger sys.trg_no_sys_logon_3
after logon
on database
declare
begin
if ( user = 'SYSTEM' or user = 'SYS') 
then
insert into audit_table
(
INSTANCE_NAME -- I can't get this info from v$session
, USERNAME
, COMMAND
, OSUSER
, PROCESS
, MACHINE
, TERMINAL
, PROGRAM
, ACTION
, CLIENT_INFO
, LOGON_TIME
, CLIENT_IDENTIFIER
) 
select
i.INSTANCE_NAME
,s.USERNAME
,s.COMMAND
,s.OSUSER
,s.PROCESS
,s.MACHINE
,s.TERMINAL
,s.PROGRAM
,s.ACTION
,s.CLIENT_INFO
,s.LOGON_TIME
,s.CLIENT_IDENTIFIER
from v$session s, v$instance i
where s.sid = (select sid from v$mystat where rownum = 1 )
and machine in (select machine from gdemo.host_machine );
end if;
commit;
exception
when others then
NULL;
end trg_no_sys_logon_3;
