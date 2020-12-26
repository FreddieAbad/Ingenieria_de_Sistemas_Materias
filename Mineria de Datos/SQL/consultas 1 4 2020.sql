-- CONSULTA TOTAL VENTAS CLIENTES POR MES
select po.id_producto id_producto,
po.nombre nombre,
po.precio,
sum(cp.cantidad) Cant_Comprada,
sum(cp.cantidad*po.precio) total_compra,
co.fecha fecha
from compra_producto as cp
inner join producto as po on po.id_producto = cp.id_producto
inner join compra as co on co.id_compra=cp.id_compra
group by po.id_producto, cp.id_producto, co.fecha having cp.id_producto=10 order by fecha asc;

-- TABLA DINAMICA 
-- Consultas total compras de un cliente
SELECT DISTINCT co.id_cliente, cl.nombre, count(cp.id_compra) compras_anuales,
    sum(CASE WHEN EXTRACT(month from co.fecha)='1' THEN (po.precio*cp.cantidad) ELSE 0 END) EN,
    sum(CASE WHEN EXTRACT(month from co.fecha)='2' THEN (po.precio*cp.cantidad) ELSE 0 END) FEB,
    sum(CASE WHEN EXTRACT(month from co.fecha)='3' THEN (po.precio*cp.cantidad) ELSE 0 END) MAR,
    sum(CASE WHEN EXTRACT(month from co.fecha)='4' THEN (po.precio*cp.cantidad) ELSE 0 END) AB,
    sum(CASE WHEN EXTRACT(month from co.fecha)='5' THEN (po.precio*cp.cantidad) ELSE 0 END) MAY,
    sum(CASE WHEN EXTRACT(month from co.fecha)='6' THEN (po.precio*cp.cantidad) ELSE 0 END) JUN,
    sum(CASE WHEN EXTRACT(month from co.fecha)='7' THEN (po.precio*cp.cantidad) ELSE 0 END) JUL,
    sum(CASE WHEN EXTRACT(month from co.fecha)='8' THEN (po.precio*cp.cantidad) ELSE 0 END) AGO,
    sum(CASE WHEN EXTRACT(month from co.fecha)='9' THEN (po.precio*cp.cantidad) ELSE 0 END) SEP,
    sum(CASE WHEN EXTRACT(month from co.fecha)='10' THEN (po.precio*cp.cantidad) ELSE 0 END) OCT,
    sum(CASE WHEN EXTRACT(month from co.fecha)='11' THEN (po.precio*cp.cantidad) ELSE 0 END) NOV,
    sum(CASE WHEN EXTRACT(month from co.fecha)='12' THEN (po.precio*cp.cantidad) ELSE 0 END) DIC
FROM compra_producto as cp
INNER JOIN compra as co on co.id_compra=cp.id_compra
INNER JOIN cliente as cl on cl.id_cliente=co.id_cliente
INNER JOIN producto as po on po.id_producto=cp.id_producto
GROUP BY co.id_cliente, cl.nombre;




-----------------------------------------------------------------------------------------------------------------------------------------------------------
------------------------------------------  FUNCION COMPOSITE ---------------------------------------------------------------------------------------------
-- Basado en https://www.youtube.com/watch?v=r5lDC7TC2yc
-----------------------------------------------------------------------------------------------------------------------------------------------------------

CREATE OR REPLACE VIEW tabla_pivote_compras_producto 
AS
SELECT co.id_cliente, cl.nombre, count(cp.id_compra) compras_anuales, sum(cp.cantidad) Cant_Comprada, EXTRACT(month from co.fecha) mes,
sum(cp.cantidad*po.precio) total_compra
FROM compra_producto as cp
INNER JOIN compra as co on co.id_compra=cp.id_compra
INNER JOIN cliente as cl on cl.id_cliente=co.id_cliente
INNER JOIN producto as po on po.id_producto=cp.id_producto
GROUP BY co.id_cliente, cl.nombre, co.fecha;


SELECT * 
FROM CROSSTAB
(
	$$ 
	SELECT nombre, mes,  SUM(total_compra) 
	FROM tabla_pivote_compras_producto
	GROUP BY nombre, mes ORDER BY nombre,mes
	$$,
	$$ 
	SELECT DISTINCT mes FROM tabla_pivote_compras_producto 
	ORDER BY mes 
	$$ 
)
AS crosstab_ventas(nombre text, "Enero" double precision , "Febrero"  double precision, "Marzo"  double precision, "Abril"  double precision, 
	  "Mayo"  double precision, "Junio"  double precision, "Julio"  double precision, "Agosto"  double precision, "Septiembre"  double precision, 
	  "Octubre"   double precision, "Noviembre" double precision, "Diciembre"  double precision)
	  




------------------------- Alternativa, donde cada mes se maneja con 1,2,3,... 12

SELECT * 
FROM CROSSTAB
(
	$$ 
	SELECT nombre, mes,  SUM(total_compra) 
	FROM tabla_pivote_compras_producto
	GROUP BY nombre, mes ORDER BY nombre,mes
	$$,
	$$ 
	SELECT DISTINCT mes FROM tabla_pivote_compras_producto 
	ORDER BY mes 
	$$ 
)
AS CT(nombre text, "1" double precision, "2"  double precision, "3"  double precision, "4"  double precision, 
	  "5"  double precision, "6"  double precision, "7"  double precision, "8"  double precision, "9"  double precision, 
	  "10"   double precision, "11"   double precision, "12"  double precision)
-----------------------------------------------------------------------------------------------------------------------------------------------------------
-----------------------------------------------------------------------------------------------------------------------------------------------------------




