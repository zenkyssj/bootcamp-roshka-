package com.bootcamproshka.jose.market;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TopClientesGasto {
    public static void main(String[] args) {

        try (var connection = Conexion.connect()) {
            String sql = """
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
                    LIMIT 10;""";

            assert connection != null;
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("cliente_id");
                String nombre = rs.getString("apellido");
                String apellido = rs.getString("apellido");
                int totalGastado = rs.getInt("total_gastado");
                System.out.println("ID: " + id + " - Nombre: " + nombre + " - Total Gastado: " + totalGastado);
            }

        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }

    }
}

