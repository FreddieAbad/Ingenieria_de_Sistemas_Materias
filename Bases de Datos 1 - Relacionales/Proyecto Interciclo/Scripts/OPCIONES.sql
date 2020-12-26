--------------------------------------------------------
-- Archivo creado  - sábado-enero-12-2019   
--------------------------------------------------------
--------------------------------------------------------
--  DDL for Table OPCIONES
--------------------------------------------------------

  CREATE TABLE "OPCIONES" 
   (	"IDOPCION" NUMBER, 
	"IDPREGUNTA" NUMBER, 
	"IDENCUESTA" NUMBER, 
	"IDSELECCION" NUMBER, 
	"NOMBREOPCION" VARCHAR2(200 BYTE)
   ) PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM" ;
--------------------------------------------------------
--  Constraints for Table OPCIONES
--------------------------------------------------------

  ALTER TABLE "OPCIONES" MODIFY ("IDPREGUNTA" NOT NULL ENABLE);
 
  ALTER TABLE "OPCIONES" MODIFY ("IDENCUESTA" NOT NULL ENABLE);
 
  ALTER TABLE "OPCIONES" MODIFY ("IDSELECCION" NOT NULL ENABLE);
 
  ALTER TABLE "OPCIONES" MODIFY ("NOMBREOPCION" NOT NULL ENABLE);
 
  ALTER TABLE "OPCIONES" MODIFY ("IDOPCION" NOT NULL ENABLE);
