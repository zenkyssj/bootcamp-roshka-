package com.bootcamproshka.jose.market;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ProductosMasVendidos {

    public static void main(String[] args) {

        try (var connection = Conexion.connect()) {
            String sql = """
                    SELECT p.id,
                    	p.nombre,
                    	COUNT(fd.id) AS totalventas
                    FROM producto p
                    INNER JOIN factura_detalle fd
                    	ON p.id = fd.producto_id
                    GROUP BY p.id, p.nombre
                    ORDER BY totalventas DESC
                    LIMIT 10;
                    """;

            assert connection != null;
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("id");
                String nombre = rs.getString("nombre");
                int totalVentas = rs.getInt("totalventas");
                System.out.println("ID: " + id + " | Producto: " + nombre + " | Cantidad Vendido: " + totalVentas);
            }

        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }
}
