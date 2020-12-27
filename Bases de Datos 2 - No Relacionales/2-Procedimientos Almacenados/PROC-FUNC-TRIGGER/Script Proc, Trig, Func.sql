--CREACION DE TABLAS
CREATE TABLE DESCARTABLES
( idDescartable number NOT NULL,
  nombreDescartable varchar2(50) NOT NULL,
  CONSTRAINT descartables_pk PRIMARY KEY (idDescartable)
);
CREATE TABLE TIPOUSUARIO
( idTUsuario number NOT NULL,
  descripcion varchar2(50) NOT NULL,
  CONSTRAINT tusuario_pk PRIMARY KEY (idTUsuario)
);
CREATE TABLE USUARIO
( idUsuario number NOT NULL,
  password varchar2(50) NOT NULL,
  tusuario number NOT NULL,
  CONSTRAINT usuario_pk PRIMARY KEY (idUsuario),
  CONSTRAINT tusuario_fk 
    FOREIGN KEY (tusuario)
    REFERENCES TIPOUSUARIO(idTUsuario)
);
CREATE TABLE CONSUMO
(   idUsuario number NOT NULL,
    idDescartable number NOT NULL,
    hora date NOT NULL,
    CONSTRAINT usuario_fk 
        FOREIGN KEY (idUsuario)
        REFERENCES USUARIO(idUsuario),
    CONSTRAINT descartable_fk 
        FOREIGN KEY (idDescartable)
        REFERENCES DESCARTABLES(idDescartable)
);
CREATE TABLE COMPRAS
(   idCompra number NOT NULL,
    idDescartable number NOT NULL,
    CONSTRAINT compra_pk PRIMARY KEY (idCompra),
    CONSTRAINT descartableC_fk 
        FOREIGN KEY (idDescartable)
        REFERENCES DESCARTABLES(idDescartable)
);
--CREACION DE TRIGGER
CREATE OR REPLACE TRIGGER productoConsumidoCompra
AFTER INSERT ON CONSUMO FOR EACH ROW
DECLARE
BEGIN
    INSERT INTO compras values (SEQ_COMPRAS.NEXTVAL,:new.idDescartable);
END;
--CREACION DE PROC
CREATE OR REPLACE Procedure limitarProductoUsuario
   ( idUsuarioV IN number)
IS
    c1 number;
    verificacion varchar2(100);
BEGIN
    c1:=0;
    SELECT count(idDescartable) into c1
        FROM consumo
        WHERE idUsuario = idUsuarioV;
    if c1>3 then
        verificacion := 'Usuario Restringido a uso de productos';
    else
        verificacion := 'Usuario tiene disponible usar productos';
    end if;
    DBMS_OUTPUT.PUT_LINE(verificacion);
END;
--CREACION DE FUNCION
CREATE OR REPLACE FUNCTION productoRecienteFunction
   ( idUsuarioV IN number) RETURN varchar2
is
    productoReciente varchar2(300);
    maxHora date;
BEGIN
    SELECT max(hora) into maxHora
        FROM consumo
        WHERE idUsuario = idUsuarioV;
    
    SELECT cnsm.idDescartable|| ' '|| descrt.nombreDescartable || ' ' || cnsm.idUsuario || ' ' || cnsm.hora into productoReciente
    FROM CONSUMO cnsm,DESCARTABLES descrt
    WHERE cnsm.idUsuario=idUsuarioV and cnsm.hora=maxHora and cnsm.idDescartable=descrt.idDescartable ;
  RETURN productoReciente;
END;
-- FORMATO DIAS
select * from nls_session_parameters;
alter session set nls_date_format ='DD-MM-RR';
--INICIO INSERCION DATOS
CREATE SEQUENCE SEQ_COMPRAS START WITH 1 INCREMENT BY 1;
INSERT INTO TIPOUSUARIO VALUES(1,'Secretaria');
INSERT INTO TIPOUSUARIO VALUES(2,'Odontologo');
INSERT INTO TIPOUSUARIO VALUES(3,'Asistente');
INSERT INTO DESCARTABLES VALUES(1,'Algodon');
INSERT INTO DESCARTABLES VALUES(2,'Servilletas');
INSERT INTO DESCARTABLES VALUES(3,'Cotonete');
INSERT INTO USUARIO VALUES(1,'Lic. Maria Romero',1);
INSERT INTO USUARIO VALUES(2,'Odtlg. Juan Orellana',2);
INSERT INTO USUARIO VALUES(3,'Tcn. Juan Brito',3);
INSERT INTO CONSUMO VALUES(1,3,TO_DATE('06/03/2019', 'DD/MM/YYYY'));
INSERT INTO CONSUMO VALUES(1,2,TO_DATE('07/03/2019', 'DD/MM/YYYY'));
INSERT INTO CONSUMO VALUES(3,3,TO_DATE('08/03/2019', 'DD/MM/YYYY'));
INSERT INTO CONSUMO VALUES(3,3,TO_DATE('08/03/2019', 'DD/MM/YYYY'));
INSERT INTO CONSUMO VALUES(3,3,TO_DATE('08/03/2019', 'DD/MM/YYYY'));
INSERT INTO CONSUMO VALUES(3,3,TO_DATE('08/03/2019', 'DD/MM/YYYY'));
INSERT INTO CONSUMO VALUES(3,3,TO_DATE('08/03/2019', 'DD/MM/YYYY'));
INSERT INTO CONSUMO VALUES(3,3,TO_DATE('08/03/2019', 'DD/MM/YYYY'));
--VERIFICACION DE TRIGGER
SELECT * FROM COMPRAS;
SELECT productoRecienteFunction(3) FROM DUAL;
--VERIFICACION DE FUNCTION
SET SERVEROUTPUT ON
EXEC DBMS_OUTPUT.PUT_LINE(productoRecienteFunction(3));
--VERIFICACION DE PROCEDIMEINTO
begin 
limitarProductoUsuario(3);
end;
