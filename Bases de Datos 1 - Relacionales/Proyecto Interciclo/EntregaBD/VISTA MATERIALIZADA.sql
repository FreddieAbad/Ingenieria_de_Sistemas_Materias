--como system o como sysdba
CREATE MATERIALIZED VIEW VW_CONEXION_BD
BUILD IMMEDIATE 
REFRESH COMPLETE
AS
    select USER#,USERNAME,OWNERID,SERVER,SCHEMA#,SCHEMANAME,MACHINE,PORT,sql_exec_start,prev_exec_start,LOGON_TIME,STATE,creator_addr,creator_serial# 
    from v$session
    where audsid = SYS_CONTEXT('USERENV','sessionid'); 
    
    
CREATE MATERIALIZED VIEW VW_CONEXION_BD_FIN
BUILD IMMEDIATE 
REFRESH COMPLETE
AS
     select USER#,USERNAME,OWNERID,SERVER,SCHEMA#,SCHEMANAME,MACHINE,PORT,sql_exec_start,prev_exec_start,LOGON_TIME,STATE,creator_addr,creator_serial# 
        from v$session;
desc v$session






CREATE MATERIALIZED VIEW VW_CONEXION_BD_FIN
BUILD IMMEDIATE 
REFRESH COMPLETE
AS
     select USER#,USERNAME,OWNERID,SCHEMANAME,MACHINE,PORT,LOGON_TIME,STATE,creator_addr
        from v$session
        where extract(month from LOGON_TIME)<EXTRACT(month FROM sysdate)
        ;
        
        
        
--IMPORTATE PARA CONEXIONES DE USUARIO
SELECT PASSWORD FROM DBA_USERS WHERE USER_ID=5;
SELECT * FROM DBA_TABLESPACES;