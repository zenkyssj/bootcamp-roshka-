package com.bootcamproshka.jose.market;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TopMonedasUtilizadas {
    public static void main(String[] args) {

        try (var connection = Conexion.connect()) {
            String sql = """
                    SELECT m.id,
                    	m.nombre,
                    	COUNT(f.id) AS total
                    FROM moneda m
                    INNER JOIN factura f
                    	ON m.id = f.moneda_id
                    GROUP BY m.id, m.nombre
                    ORDER BY total DESC
                    LIMIT 5;
                    """;

            assert connection != null;
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("id");
                String nombre = rs.getString("nombre");
                int total = rs.getInt("total");
                System.out.println("ID: " + id + " | Nombre: " + nombre +  " | Total: " + total);
            }

        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }

    }
}
