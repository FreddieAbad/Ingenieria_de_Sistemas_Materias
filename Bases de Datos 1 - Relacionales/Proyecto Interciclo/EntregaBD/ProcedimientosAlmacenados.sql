set serveroutput on size 30000;
CREATE OR REPLACE PROCEDURE conteoEncuesta(id IN number,nombre in varchar2, descripcion in varchar2, idtipoencuesta in number)
is
total NUMBER;
l_mensaje VARCHAR2(100) := '¡Incorrecto!';
begin
    total :=0;
    select count(*) into total from encuesta where IDENCUESTA = id; 
    if total=0 then 
        insert into ENCUESTA values (id, nombre, descripcion, idtipoencuesta);
    ELSE
        DBMS_OUTPUT.put_line(l_mensaje); 
    end if;
end conteoEncuesta;

begin 
    conteoencuesta(773,'hola','hola',1);
    commit;
end;


--join de tablas respuesta con encuesta
select count(*) from encuesta e 
inner join respuestaopcionmultiple r on e.idencuesta=r.idencuesta and r.idusuario='0104496765'
inner join respuestatexto re on re.idencuesta=e.idencuesta and re.idusuario='0104496765';
--------------------------------------------------------------------------------------------------------------------------------
------------------------PROCEDIMIENTO VERIFICACION MAS DE 10 ENCUESTAS----------------------------------------------------------
--------------------------------------------------------------------------------------------------------------------------------
--------------------------------------------------------------------------------------------------------------------------------
---procedimiento conteo mas de 10 encuestas '0104496765'
set serveroutput on size 30000;
CREATE OR REPLACE PROCEDURE conteoEncuestaUsuario(ci varchar2, suscripcion out number)
is 
total number;
mensajeAdelante VARCHAR2(100) := '¡Adelante!';
mensajeAlto VARCHAR2(100) := '¡Contrata una suscripcion!';
begin
    total:=0;
    suscripcion:=0;
    select count(*) into total from encuesta e 
    inner join respuestaopcionmultiple r on e.idencuesta=r.idencuesta and r.idusuario=ci
    inner join respuestatexto re on re.idencuesta=e.idencuesta and re.idusuario=ci;
    if total>10 then
        suscripcion:=0;
        DBMS_OUTPUT.put_line(mensajeAlto); 
    else
        suscripcion:=1;
        DBMS_OUTPUT.put_line(mensajeAdelante); 
    end if;
end conteoEncuestaUsuario;
--------------INICIO PRUEBA VERIFICACION COMPRA MEMBRESIA
declare
    returnvalue NUMBER;
    salida NUMBER;
begin
    conteoEncuestaUsuario('0104496765',returnvalue);
    DBMS_OUTPUT.PUT_LINE (returnvalue);
    commit;
end;
--------------INICIO PRUEBA ADELANTE
declare
    returnvalue NUMBER;
    salida NUMBER;
begin
    conteoEncuestaUsuario('010446765',returnvalue);
    DBMS_OUTPUT.PUT_LINE (returnvalue);
    commit;
end;
------ LISTO 
--------------------------------------------------------------------------------------------------------------------------------
--------------------------------------------------------------------------------------------------------------------------------
---------------------------------------------------VALIDACION CEDULA------------------------------------------------------------
--------------------------------------------------------------------------------------------------------------------------------
--------------------------------------------------------------------------------------------------------------------------------
CREATE OR REPLACE PROCEDURE validarCIEC(ci in varchar2, valido out number)
is
verificador number;
finalS number;
suma number;
aux number;
begin
    suma :=0;
    aux:=0;
    valido:=0;
    verificador:=to_number(substr(ci,-1));
    if to_number(substr(ci,1,2))<24 then
        if to_number(substr(ci,3,1))<6 then
            FOR i IN 1..9 LOOP
                if MOD(i,2) = 0 then
                    aux :=TO_NUMBER((SUBSTR(ci,i,1)));
                    if aux >=10 then
                        aux :=aux -9;
                    end if;
                else
                    aux := TO_NUMBER((SUBSTR(ci,i,1)))*2;
                    if aux >=10 then
                        aux :=aux -9;
                    end if;
                end if;
                suma := suma + aux;
                aux:=0;
            END LOOP;
        end if;
        finalS:=suma+verificador;
        if mod(finalS,10)=0 then
            DBMS_OUTPUT.PUT_LINE ('Cedula Correcta');
            valido:=1;
        else
            DBMS_OUTPUT.PUT_LINE ('Cedula Incorrecta');
            valido:=0;
        end if;
    else
        DBMS_OUTPUT.PUT_LINE ('Cedula Incorrecta');
        valido:=0;
    end if;
end validarCIEC;
--LISTO VALIDACION
--PRUEBA CORRECTA
declare
    returnvalue NUMBER;
begin
    validarCIEC('0104496765',returnvalue);
    DBMS_OUTPUT.PUT_LINE (returnvalue);
    commit;
end;
----INCORRECTA
declare
    returnvalue NUMBER;
begin
    validarCIEC('0104497765',returnvalue);
    DBMS_OUTPUT.PUT_LINE (returnvalue);
    commit;
end;



SELECT LENGTH(TRIM(TRANSLATE('1f2cccc3', ' +-.0123456789',' '))) FROM dual;
--------------------------------------------------------------------------------------------------------------------------------
--------------------------------------------------------------------------------------------------------------------------------
--------------------Procedimiento Separar Respuesta Numerica Texto de OM -------------------------------------------------------
--------------------------------------------------------------------------------------------------------------------------------
--------------------------------------------------------------------------------------------------------------------------------

create or replace procedure preguntaAlphaNumOpcionM(ci varchar2, respuestasNum in out varchar2,respuestasString out varchar2) 
is
    numRespuesta number;
    respuestaOM varchar2(500):='';
    validacion number;
    salidaT varchar2(3900) := '';
    salidaN varchar2(3900) := '';
    idrom varchar2(100):='';
    idp varchar2(100):='';
    ide varchar2(100):='';
    ido varchar2(100):='';
begin
    numRespuesta:=0;
    respuestasString:='';
    respuestasNum:='';
    select count(o.nombreopcion) into numRespuesta from encuesta e 
    inner join respuestaopcionmultiple r on e.idencuesta=r.idencuesta and r.idusuario=ci
    inner join opciones o on o.idopcion=r.idopcion and r.idusuario=ci;
    for i in  1..numRespuesta LOOP
        select o.nombreopcion,r.idrespuestaopcionmultiple,r.idpregunta,r.idencuesta,r.idopcion  
        into respuestaOM,idrom,idp,ide,ido
        from encuesta e 
        inner join respuestaopcionmultiple r on e.idencuesta=r.idencuesta and r.idusuario=ci
        inner join opciones o on o.idopcion=r.idopcion and r.idusuario=ci;
        SELECT LENGTH(TRIM(TRANSLATE(respuestaOM, ' +-.0123456789',' '))) into validacion FROM dual;
        if validacion>=1 then 
            salidaT:=salidaT || ' ' || TO_CHAR(idrom) || ' ' || TO_CHAR(idp)|| ' ' || TO_CHAR(ide) || ' ' || TO_CHAR(ido)|| ' ' || respuestaOM || '~';
        else
            salidaN:=salidaN || ' ' || TO_CHAR(idrom) || ' ' || TO_CHAR(idp)|| ' ' || TO_CHAR(ide) || ' ' || TO_CHAR(ido)|| ' ' || respuestaOM || '~';
        end if;
        respuestaOM:='';
    end loop;
    DBMS_OUTPUT.PUT_LINE (respuestasString);
    DBMS_OUTPUT.PUT_LINE (respuestasNum);
    --if condicion=1 then
    respuestasString:=salidaT;
    --else
    respuestasNum:=salidaN;
    --end if;
end;
--listo
--inicio prueba
declare
    returnTexto varchar2(3950);
    returnNum varchar2(3950);
begin
preguntaAlphaNumOpcionM('1111111111',returnNum,returnTexto);
    DBMS_OUTPUT.PUT_LINE (returnTexto);
    DBMS_OUTPUT.PUT_LINE (returnNum);
commit;
end;
--LISTO


--------------------------------------------------------------------------------------------------------------------------------
----------------------------PROC SEPARAR RESPUESTAS NUMERICAS DE TEXTO EN RESPUESTAS TEXTO--------------------------------------
--------------------------------------------------------------------------------------------------------------------------------
--------------------------------------------------------------------------------------------------------------------------------
create or replace procedure preguntaAlphaNumTexto(ci varchar2, respuestasNum in out varchar2,respuestasString out varchar2) 
is
    numRespuesta number;
    respuestaT varchar2(500):='';
    validacion number;                   -- si es mayor a 1 es texto, si es null es numero
    salidaT varchar2(3900) := '';
    salidaN varchar2(3900) := '';
    idrt varchar2(100):='';
    idp varchar2(100):='';
    ide varchar2(100):='';
begin
    numRespuesta:=0;
    respuestasString:='';
    respuestasNum:='';
    select count(r.respuesta) into numRespuesta 
    from encuesta e 
    inner join respuestatexto r on e.idencuesta=r.idencuesta and r.idusuario=ci;
    for i in  1..numRespuesta LOOP
        select r.respuesta,r.idrespuestatexto,r.idpregunta,r.idencuesta  
        into respuestaT,idrt,idp,ide
        from encuesta e 
        inner join respuestatexto r on e.idencuesta=r.idencuesta and r.idusuario=ci;
        SELECT LENGTH(TRIM(TRANSLATE(respuestaT, ' +-.0123456789',' '))) into validacion FROM dual;
        if validacion>=1 then 
            salidaT:=salidaT || ' ' || TO_CHAR(idrt) || ' ' || TO_CHAR(idp)|| ' ' || TO_CHAR(ide) || ' ' || respuestaT || '~';
        else
            salidaN:=salidaN || ' ' || TO_CHAR(idrt) || ' ' || TO_CHAR(idp)|| ' ' || TO_CHAR(ide) || ' ' || respuestaT || '~';
        end if;
        respuestaT:='';
    end loop;
    respuestasString:=salidaT;
    respuestasNum:=salidaN;
end preguntaAlphaNumTexto;
--listo
--inicio prueba
declare
    returnTexto varchar2(3950);
    returnNum varchar2(3950);
begin
    preguntaAlphaNumTexto('0104301338',returnNum,returnTexto);
    DBMS_OUTPUT.PUT_LINE (returnTexto);
    DBMS_OUTPUT.PUT_LINE (returnNum);
    commit;
end;
--LISTO
