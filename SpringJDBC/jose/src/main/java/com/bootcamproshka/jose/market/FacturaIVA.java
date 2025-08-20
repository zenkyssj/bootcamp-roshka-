package com.bootcamproshka.jose.market;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class FacturaIVA {
    public static void main(String[] args) {

        try (var connection = Conexion.connect()) {
            String sql = """
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
                    """;

            assert connection != null;
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("factura_id");
                Date emision = rs.getDate("fecha_emision");
                Date vencimiento = rs.getDate("fecha_vencimiento");
                int cliente_id = rs.getInt("cliente_id");
                String nombre = rs.getString("nombre");
                String apellido = rs.getString("apellido");
                int total_sin_iva = rs.getInt("total_sin_iva");
                int iva_10 = rs.getInt("iva_10");
                int total_con_iva = rs.getInt("total_con_iva");
                System.out.println("ID: " + id + " | Emision: " + emision + " | Vencimiento: " + vencimiento + " | ID Cliente: " + cliente_id + " | Nombre: " +
                        nombre + " | Apellido: " + apellido + " | Sin IVA: " + total_sin_iva + " | IVA 10%: " + iva_10 + " | Total Con IVA: " + total_con_iva);
            }

        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }

    }
}
