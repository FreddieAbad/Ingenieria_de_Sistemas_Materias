--------------------------------------------------------
-- Archivo creado  - lunes-enero-21-2019   
--------------------------------------------------------
--------------------------------------------------------
--  DDL for Table RESPUESTATEXTO
--------------------------------------------------------

  CREATE TABLE "RESPUESTATEXTO" 
   (	"IDRESPUESTATEXTO" NUMBER, 
	"IDPREGUNTA" NUMBER, 
	"IDENCUESTA" NUMBER, 
	"RESPUESTA" VARCHAR2(200 BYTE), 
	"IDUSUARIO" VARCHAR2(10 BYTE)
   ) PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM" ;
REM INSERTING into RESPUESTATEXTO
SET DEFINE OFF;
Insert into RESPUESTATEXTO (IDRESPUESTATEXTO,IDPREGUNTA,IDENCUESTA,RESPUESTA,IDUSUARIO) values (0,1,1,'1','1212121212');
Insert into RESPUESTATEXTO (IDRESPUESTATEXTO,IDPREGUNTA,IDENCUESTA,RESPUESTA,IDUSUARIO) values (1,2,1,'2','1212121212');
Insert into RESPUESTATEXTO (IDRESPUESTATEXTO,IDPREGUNTA,IDENCUESTA,RESPUESTA,IDUSUARIO) values (2,1,1,'o1','1111111111');
Insert into RESPUESTATEXTO (IDRESPUESTATEXTO,IDPREGUNTA,IDENCUESTA,RESPUESTA,IDUSUARIO) values (3,2,1,'o2','1111111111');
Insert into RESPUESTATEXTO (IDRESPUESTATEXTO,IDPREGUNTA,IDENCUESTA,RESPUESTA,IDUSUARIO) values (4,1,1,'aaaaaaaaa1','aaaaaaaaa1');
Insert into RESPUESTATEXTO (IDRESPUESTATEXTO,IDPREGUNTA,IDENCUESTA,RESPUESTA,IDUSUARIO) values (5,2,1,'aaaaaaaaa1','aaaaaaaaa1');
--------------------------------------------------------
--  DDL for Index RESPUESTATEXTO_PK
--------------------------------------------------------

  CREATE UNIQUE INDEX "RESPUESTATEXTO_PK" ON "RESPUESTATEXTO" ("IDRESPUESTATEXTO") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM" ;
--------------------------------------------------------
--  Constraints for Table RESPUESTATEXTO
--------------------------------------------------------

  ALTER TABLE "RESPUESTATEXTO" ADD CONSTRAINT "RESPUESTATEXTO_PK" PRIMARY KEY ("IDRESPUESTATEXTO")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM"  ENABLE;
 
  ALTER TABLE "RESPUESTATEXTO" MODIFY ("IDRESPUESTATEXTO" NOT NULL ENABLE);
 
  ALTER TABLE "RESPUESTATEXTO" MODIFY ("IDPREGUNTA" NOT NULL ENABLE);
 
  ALTER TABLE "RESPUESTATEXTO" MODIFY ("IDENCUESTA" NOT NULL ENABLE);
 
  ALTER TABLE "RESPUESTATEXTO" MODIFY ("RESPUESTA" NOT NULL ENABLE);
 
  ALTER TABLE "RESPUESTATEXTO" MODIFY ("IDUSUARIO" NOT NULL ENABLE);
