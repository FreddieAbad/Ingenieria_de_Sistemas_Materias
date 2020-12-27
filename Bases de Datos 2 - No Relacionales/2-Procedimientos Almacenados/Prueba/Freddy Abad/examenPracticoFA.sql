--Insercion Datos

insert into tratamiento values (1,'Tratamiento Medico Gripe',20.3,1);
insert into tratamiento values (2,'Tratamiento Medico Tos',15.43,2);
insert into tratamiento values (3,'Tratamiento Medico Reflujo',17.3,2);
insert into pacientes values (1,'0104496765','Abad Fredd','Cdla CATT','0988596203',15.5);
insert into pacientes values (2,'0104496766','Abad Maria','Cdla UvY','0988596223',17);
insert into pacientes values (3,'0104496767','Abad Francisco','Cdla XmL','0988596233',25);
insert into citas values ('2008/12/31','13:00:59','1');
insert into citas values ('2008/12/31','13:00:59','2');
insert into citas values ('2008/12/31','13:00:59','3');

--Creadcion de funcion
create or replace function validocostopago(bigint, character varying,bigint) returns text 
as 
$$
declare 
	costo_trat alias for $1;
	nombre_trat alias for $2;
	num_cita alias for $3;
	costo_max_pago   bigint;
	indice_mayor bigint;
  	retorno_char text  default 'Query Ingresada';
BEGIN
	costo_max_pago := (select max(max_pago) from pacientes);	
	indice_mayor := (select max(id) from tratamiento);
	if costo_max_pago > costo_trat  then
		insert into tratamiento values (indice_mayor+1,nombre_trat,costo_trat,num_cita);
  	else
		retorno_char:='Query No Ingresada - Costo Tratamiento mayor a costo max_pago';
	end if;
	return retorno_char;
	end;
$$
language plpgsql;
