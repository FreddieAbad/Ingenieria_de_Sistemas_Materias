----VALIDACION CEDULA
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
--PRUEBA
declare
    returnvalue NUMBER;
begin
    validarCIEC('0104496765',returnvalue);
    DBMS_OUTPUT.PUT_LINE (returnvalue);
    commit;
end;
----
