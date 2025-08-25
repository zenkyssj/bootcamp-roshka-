<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="Styles\index.css?v=2.6.1">
    <title>Document</title>
</head>

<body>
    <div class="container">
        <div class="title-container">Consultas</div>
        <div class="buttons-container">
            <form class="form-buttons" action="ClientesMasFacturas" method="get">
                <button type="submit">Clientes con mas facturas</button>
            </form>

            <form class="form-buttons" action="ClientesMasGastaron" method="get">
                <button type="submit">Clientes que mas gastaron</button>
            </form>

            <form class="form-buttons" action="MonedasMasUtilizadas" method="get">
                <button type="submit">Monedas mas utilizadas</button>
            </form>

            <form class="form-buttons" action="ProveedorDeProductos" method="get">
                <button type="submit">Top proveedor de productos</button>
            </form>

            <form class="form-buttons" action="ProductosMasVendidos" method="get">
                <button type="submit">Productos mas vendidos</button>
            </form>

            <form class="form-buttons" action="ProductosMenosVendidos" method="get">
                <button type="submit">Productos menos vendidos</button>
            </form>

            <form class="form-buttons" action="FacturaEspecifica" method="get">
                <button type="submit">Factura especifica</button>
            </form>

            <form class="form-buttons" action="FacturasPorTotales" method="get">
                <button type="submit">Facturas por totales</button>
            </form>

            <form class="form-buttons" action="FacturasIVA" method="get">
                <button type="submit">Facturas (IVA 10%)</button>
            </form>

        </div>


    </div>

    <div class="forms">
        <form action="InsertarProducto" method="post">
            <h3>Insertar Producto</h3>

            <br><label for="id_producto">ID</label>
            <input type="text" name="id_producto" id="id_producto" required>    

            <label for="nombre">Nombre: </label>
            <input type="text" id="nombre" name="nombre" required>

            <label for="precio">Precio: </label>
            <input type="text" id="precio" name="precio" required>

            <label for="proveedor">Proveedor (id): </label>
            <input type="text" id="proveedor" name="proveedor" required>

            <label for="cost">Costo: </label>
            <input type="costo" id="costo" name="costo" required>

            <input type="submit" value="Insertar">
        </form>

        <form action="InsertarProveedor" method="post">
            <h3>Insertar Proveedor</h3>

            <br><label for="id_proveedor">ID</label>
            <input type="text" id="id_proveedor" name="id_proveedor" required>
            
            <label for="nombre_proveedor">Nombre: </label>
            <input type="text" id="nombre_proveedor" name="nombre_proveedor" required>

            <label for="ruc">RUC:</label>
            <input type="ruc" id="ruc" name="ruc" required>

            <label for="id_pais">Pais (id):</label>
            <input type="text" id="id_pais" name="id_pais" required>

            <input type="submit" value="Insertar">
        </form>

        <form action="InsertarPais" method="post">
            <h3>Insertar Pais</h3>

            <br><label for="id_pais">ID: </label>
            <input type="text" id="id_pais" name="id_pais">
            
            <label for="nombre_pais">Nombre: </label>
            <input type="text" id="nombre_pais" name="nombre_pais">

            <input type="submit" value="Insertar">
        </form>
    </div>

</body>

</html>