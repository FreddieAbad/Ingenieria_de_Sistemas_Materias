CREATE OR REPLACE PROCEDURE enviar_correo (p_to        IN VARCHAR2,
                                       p_from      IN VARCHAR2,
                                       p_subject   IN VARCHAR2,
                                       p_message   IN VARCHAR2,
                                       p_smtp_host IN VARCHAR2,
                                       p_smtp_port IN NUMBER DEFAULT 25)
AS
  l_mail_conn   UTL_SMTP.connection;
BEGIN
  l_mail_conn := UTL_SMTP.open_connection(p_smtp_host, p_smtp_port);
  UTL_SMTP.helo(l_mail_conn, p_smtp_host);
  UTL_SMTP.mail(l_mail_conn, p_from);
  UTL_SMTP.rcpt(l_mail_conn, p_to);

  UTL_SMTP.open_data(l_mail_conn);
  
  UTL_SMTP.write_data(l_mail_conn, 'Date: ' || TO_CHAR(SYSDATE, 'DD-MON-YYYY HH24:MI:SS') || UTL_TCP.crlf);
  UTL_SMTP.write_data(l_mail_conn, 'To: ' || p_to || UTL_TCP.crlf);
  UTL_SMTP.write_data(l_mail_conn, 'From: ' || p_from || UTL_TCP.crlf);
  UTL_SMTP.write_data(l_mail_conn, 'Subject: ' || p_subject || UTL_TCP.crlf);
  UTL_SMTP.write_data(l_mail_conn, 'Reply-To: ' || p_from || UTL_TCP.crlf || UTL_TCP.crlf);
  
  UTL_SMTP.write_data(l_mail_conn, p_message || UTL_TCP.crlf || UTL_TCP.crlf);
  UTL_SMTP.close_data(l_mail_conn);

  UTL_SMTP.quit(l_mail_conn);
END;
/
BEGIN
  enviar_correo(p_to        => 'me@mycompany.com',
            p_from      => 'admin@mycompany.com',
            p_subject   => 'Test Message',
            p_message   => 'This is a test message.',
            p_smtp_host => 'smtp.mycompany.com');
END;
/
SELECT * FROM dba_network_acls;
begin
  dbms_network_acl_admin.create_acl (
    acl         => 'utl_mail.xml',
    description => 'Allow mail to be send',
    principal   => 'SCOTT',
    is_grant    => TRUE,
    privilege   => 'connect'
    );
    commit;
end;




-----------------
DECLARE
    l_vc_arr2    APEX_APPLICATION_GLOBAL.VC_ARR2;
BEGIN
    l_vc_arr2 := APEX_UTIL.STRING_TO_TABLE('1:2:3');
    FOR z IN 1..l_vc_arr2.count LOOP
        htp.p(l_vc_arr2(z));
    END LOOP;
END;



----incompleto
CREATE OR REPLACE PROCEDURE enviarCorreo(receptor        IN VARCHAR2,
                                       emisor      IN VARCHAR2,
                                       asunto   IN VARCHAR2,
                                       mensaje   IN VARCHAR2,
                                       smtp_host IN VARCHAR2,
                                       smtp_port IN NUMBER DEFAULT 25,
                                       ci varchar2,
                                       valorRetorno OUT number)
is


begin


end enviarCorreo;

DECLARE
  v_From      VARCHAR2(80) := 'freddy.abadl@gmail.com';
  v_Recipient VARCHAR2(80) := 'freddy.abadl@ucuenca.edu.ec';
  v_Subject   VARCHAR2(80) := 'test subject';
  v_Mail_Host VARCHAR2(30) := '//smtp.googlemail.com';
  v_Mail_Conn utl_smtp.Connection;
  crlf        VARCHAR2(2)  := chr(13)||chr(10);
BEGIN
 v_Mail_Conn := utl_smtp.Open_Connection(v_Mail_Host, 465);
 utl_smtp.Helo(v_Mail_Conn, v_Mail_Host);
 utl_smtp.Mail(v_Mail_Conn, v_From);
 utl_smtp.Rcpt(v_Mail_Conn, v_Recipient);
 utl_smtp.Data(v_Mail_Conn,
   'Date: '   || to_char(sysdate, 'Dy, DD Mon YYYY hh24:mi:ss') || crlf ||
   'From: '   || v_From || crlf ||
   'Subject: '|| v_Subject || crlf ||
   'To: '     || v_Recipient || crlf ||
   crlf ||
   'some message text'|| crlf ||	-- Message body
   'more message text'|| crlf
 );
 utl_smtp.Quit(v_mail_conn);
EXCEPTION
 WHEN utl_smtp.Transient_Error OR utl_smtp.Permanent_Error then
   raise_application_error(-20000, 'Unable to send mail', TRUE);
END;