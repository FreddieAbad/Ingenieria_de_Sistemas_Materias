CREATE OR REPLACE TRIGGER validaPrecio 
BEFORE INSERT ON ENCUESTA FOR EACH ROW
DECLARE
--VARIABLES
BEGIN 
IF INSERTING and :new.idtipoencuesta>1 then
    :new.idtipoencuesta:=0;
end if;
END;

insert into encuesta values(150,'sdfs','fsdf',9);
SELECT * FROM ENCUESTA;
-------------------------BITACORAAAAAAAAAAAAAAA
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
--ME DA EL VALOR DEL INDICE DE ID
CREATE SEQUENCE sec_bitacora INCREMENT BY 1 START WITH 1;

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
    VALUES (:new.IDUSUARIO,operador,SYSDATE,temp,:old.idencuesta,:new.idencuesta);
END;
---------------------------------------------------------
SELECT * FROM respuestaopcionmultiple;
SELECT * FROM bitacoraencuesta_usuario;
SELECT NOMBRE  FROM ENCUESTA WHERE IDENCUESTA=0;
DESC respuestaopcionmultiple;
INSERT INTO respuestaopcionmultiple VALUES(7,2,0,1,'0104496765');
UPDATE respuestaopcionmultiple SET IDOPCION=2  WHERE idrespuestaopcionmultiple=7;
DELETE FROM respuestaopcionmultiple WHERE idrespuestaopcionmultiple=6;

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
insert into respuestatexto values(3,1,0,'dasd','0104496765');
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
DELETE FROM respuestatexto WHERE IDRESPUESTATEXTO=3;
desc respuestatexto;
select * from bitacoraencuesta_usuario;








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