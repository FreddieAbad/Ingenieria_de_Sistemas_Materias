create or replace trigger trg_no_sys_logon_3
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
/




---funciona para seleccion
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
where s.sid = (select sid from v$mystat where rownum = 1)
