--------------------------------------------------------------------------------------------------------------------------------
---------------------------------------PROCEDIMIENTO DE ENVIO DE CORREO---------------------------------------------------------
--------------------------------------------------------------------------------------------------------------------------------
CREATE OR REPLACE PROCEDURE enviarCorreo(
  v_From      VARCHAR2(80) := 'freddy.abadl@gmail.com',
  v_Recipient VARCHAR2(80) := 'freddy.abadl@ucuenca.edu.ec',
  v_Subject   VARCHAR2(80) := 'Menjaje de prueba',
  v_Mail_Host VARCHAR2(30) := '//smtp.googlemail.com',
  v_Mail_Conn utl_smtp.Connection,
  crlf        VARCHAR2(2)  := chr(13)||chr(10),
  mensaje varchar2(3950)
  )
is 
    temp:=varchar2(200);
BEGIN
    v_Mail_Conn := utl_smtp.Open_Connection(v_Mail_Host, 465);
     utl_smtp.Helo(v_Mail_Conn, v_Mail_Host);
     utl_smtp.Mail(v_Mail_Conn, v_From);
     utl_smtp.Rcpt(v_Mail_Conn, v_Recipient);
     utl_smtp.Data(v_Mail_Conn,
       'Fecha: '   || to_char(sysdate, 'Dy, DD Mon YYYY hh24:mi:ss') || crlf ||
       'Emisor: '   || v_From || crlf ||
       'Mensaje: '|| v_Subject || crlf ||
       'A: '     || v_Recipient || crlf ||
         );
         utl_smtp.Quit(v_mail_conn);
EXCEPTION
 WHEN utl_smtp.Transient_Error OR utl_smtp.Permanent_Error then
   raise_application_error(-20000, 'Unable to send mail', TRUE);
END enviarcorreo;