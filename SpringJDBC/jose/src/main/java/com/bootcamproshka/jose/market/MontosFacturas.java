package com.bootcamproshka.jose.market;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MontosFacturas {
    public static void main(String[] args) {

        try (var connection = Conexion.connect()) {
            String sql = """
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
                    """;

            assert connection != null;
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("factura_id");
                Date fecha_emision = rs.getDate("fecha_emision");
                Date fecha_vencimiento = rs.getDate("fecha_vencimiento");
                int cliente_id = rs.getInt("cliente_id");
                String nombre = rs.getString("nombre");
                String apellido = rs.getString("apellido");
                String tipo_factura = rs.getString("tipo_factura");
                String nombre_moneda = rs.getString("nombre");
                int total = rs.getInt("total");
                System.out.println("ID: " + id + " | Emision: " + fecha_emision +  " | Vencimiento: " + fecha_vencimiento + " | Id Cliente: " + cliente_id +
                        " | Nombre: " + nombre + " | Apellido: " + apellido + " | Tipo de Factura: " + tipo_factura + " | Nombre de Moneda: " + nombre_moneda + " | Total: " + total);
            }

        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }

    }
}
