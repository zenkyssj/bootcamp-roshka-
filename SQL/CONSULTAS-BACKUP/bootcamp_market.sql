
-- Top clientes con mas facturas.
SELECT cliente_id, count(factura.id)
	AS TotalFacturas
	FROM factura
	GROUP BY cliente_id
	ORDER BY TotalFacturas DESC
	LIMIT 10;

-- Top clientes que más gastaron
SELECT c.id AS cliente_id,
       c.nombre,
       c.apellido,
       SUM(fd.cantidad * p.precio) AS total_gastado
FROM cliente c
INNER JOIN factura f 
    ON c.id = f.cliente_id
INNER JOIN factura_detalle fd 
    ON f.id = fd.factura_id
INNER JOIN producto p 
    ON fd.producto_id = p.id
GROUP BY c.id, c.nombre, c.apellido
ORDER BY total_gastado DESC
LIMIT 10;

-- Top monedas mas utilizadas
SELECT m.id,
	m.nombre,
	COUNT(f.id) AS total
FROM moneda m
INNER JOIN factura f
	ON m.id = f.moneda_id
GROUP BY m.id, m.nombre
ORDER BY total DESC
LIMIT 5;

-- Top proveedor de productos

SELECT pr.id,
	pr.nombre,
	pa.nombre,
	COUNT(p.id) AS total
FROM proveedor pr
INNER JOIN producto p
	ON pr.id = p.proveedor_id
INNER join pais pa
	ON pr.pais_id = pa.id
GROUP BY pr.id, pr.nombre, pa.nombre
ORDER BY total DESC
LIMIT 10;

-- Productos mas vendidos
SELECT p.id,
	p.nombre,
	COUNT(fd.id) AS totalventas
FROM producto p
INNER JOIN factura_detalle fd
	ON p.id = fd.producto_id
GROUP BY p.id, p.nombre
ORDER BY totalventas DESC
LIMIT 10;

-- Productos menos vendidos
SELECT p.id,
	p.nombre,
	COUNT(fd.id) AS totalventas
FROM producto p
INNER JOIN factura_detalle fd
	ON p.id = fd.producto_id
GROUP BY p.id, p.nombre
ORDER BY totalventas
LIMIT 10;

/* Consulta que muestre fecha de emisión de factura, nombre y apellido del cliente, 
nombres de productos de esa factura, cantidades compradas, nombre de tipo de factura
de una factura específica
*/
SELECT f.fecha_emision,
	c.nombre,
	c.apellido,
	p.nombre AS producto,
	fd.cantidad,
	ft.nombre AS tipo_factura
FROM factura f
INNER JOIN cliente c
	ON c.id = f.cliente_id
INNER JOIN factura_detalle fd
	ON fd.factura_id = f.id
INNER JOIN producto p
	ON p.id = fd.producto_id
INNER JOIN factura_tipo ft
	ON ft.id = f.factura_tipo_id
WHERE f.id = 1;

-- Montos de facturas con cliente, tipo de factura y moneda
SELECT f.id AS factura_id,
       f.fecha_emision,
       f.fecha_vencimiento,
       c.id AS cliente_id,
       c.nombre,
       c.apellido,
       ft.nombre AS tipo_factura,
       m.nombre AS moneda,
       SUM(fd.cantidad * p.precio) AS total
FROM factura f
INNER JOIN cliente c
    ON c.id = f.cliente_id
INNER JOIN factura_detalle fd
    ON fd.factura_id = f.id
INNER JOIN producto p
    ON p.id = fd.producto_id
INNER JOIN factura_tipo ft
    ON ft.id = f.factura_tipo_id
INNER JOIN moneda m
    ON m.id = f.moneda_id
GROUP BY f.id, c.id, c.nombre, c.apellido, ft.nombre, m.nombre, f.fecha_emision, f.fecha_vencimiento
ORDER BY total DESC;

-- Totales de facturas con IVA 10%
SELECT f.id AS factura_id,
       f.fecha_emision,
       f.fecha_vencimiento,
       c.id AS cliente_id,
       c.nombre,
       c.apellido,
       SUM(fd.cantidad * p.precio) AS total_sin_iva,
       SUM(fd.cantidad * p.precio) * 0.10 AS iva_10,
       SUM(fd.cantidad * p.precio) * 1.10 AS total_con_iva
FROM factura f
INNER JOIN cliente c
    ON c.id = f.cliente_id
INNER JOIN factura_detalle fd
    ON fd.factura_id = f.id
INNER JOIN producto p
    ON p.id = fd.producto_id
GROUP BY f.id, c.id, c.nombre, c.apellido, f.fecha_emision, f.fecha_vencimiento
ORDER BY total_sin_iva DESC;
