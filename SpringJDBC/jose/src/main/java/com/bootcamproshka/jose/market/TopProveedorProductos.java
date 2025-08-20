package com.bootcamproshka.jose.market;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TopProveedorProductos {

    public static void main(String[] args) {

        try (var connection = Conexion.connect()) {
            String sql = """
                    SELECT pr.id,
                    	pr.nombre,
                    	pa.nombre AS nombre_pais,
                    	COUNT(p.id) AS total
                    FROM proveedor pr
                    INNER JOIN producto p
                    	ON pr.id = p.proveedor_id
                    INNER join pais pa
                    	ON pr.pais_id = pa.id
                    GROUP BY pr.id, pr.nombre, pa.nombre
                    ORDER BY total DESC
                    LIMIT 10;
                    """;

            assert connection != null;
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("id");
                String nombre = rs.getString("nombre");
                String nombre_pais = rs.getString("nombre_pais");
                int total = rs.getInt("total");
                System.out.println("ID: " + id + " | Nombre: " + nombre + " | Pais: " + nombre_pais + " | Cantidad: " + total);
            }

        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }

    }
}
