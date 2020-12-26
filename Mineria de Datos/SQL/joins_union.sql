-- union combinar los resultados de dos consultas juntas. En este sentido, UNION es parecido a Join, ya que los dos se utilizan para información 
-- relacionada en múltiples tablas.
-- Una restricción de UNION es que todas las columnas correspondientes necesitan ser del mismo tipo de datos.
select id_cliente,  'Compra' from compra
union
select id_cliente,  'Cliente' from cliente;

--union all
--combinar los resultados de dos consultas juntas. La diferencia entre UNION ALL y UNION es que, mientras UNION sólo selecciona valores distintos, UNION ALL selecciona todos los valores.
select id_cliente,  'Compra' from compra
union all
select id_cliente,  'Cliente' from cliente;

--inner join 
select * from compra as co
inner join cliente as cl
on cl.id_cliente=co.id_cliente;
--left
select * from compra as co
left join cliente as cl
on cl.id_cliente=co.id_cliente;
--right
select * from compra as co
right join cliente as cl
on cl.id_cliente=co.id_cliente;
--full
select * from compra as co
full join cliente as cl
on cl.id_cliente=co.id_cliente;
--cross all relacionles con all relaciones
select * from compra as co
full join cliente as cl
on cl.id_cliente=co.id_cliente;
