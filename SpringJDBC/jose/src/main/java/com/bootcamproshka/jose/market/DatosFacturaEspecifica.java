package com.bootcamproshka.jose.market;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DatosFacturaEspecifica {

    public static void main(String[] args) {

        try (var connection = Conexion.connect()) {
            String sql = """
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
                    """;

            assert connection != null;
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                Date fecha = rs.getDate("fecha_emision");
                String nombre = rs.getString("nombre");
                String apellido = rs.getString("apellido");
                String nombre_producto = rs.getString("producto");
                int cantidad = rs.getInt("cantidad");
                String tipo_factura = rs.getString("tipo_factura");
                System.out.println("Nombre: " + nombre + " | Apellido: " + apellido + " | Producto: " + nombre_producto + " | Cantidad: " + cantidad
                    + " | Tipo de Factura: " + tipo_factura);
            }

        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }
}
