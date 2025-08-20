package com.bootcamproshka.jose.market;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TopClientesFacturas {
    public static void main(String[] args) {

        try (var connection = Conexion.connect()) {
            String sql = "SELECT cliente_id, count(factura.id)AS TotalFacturas FROM factura GROUP BY cliente_id ORDER BY TotalFacturas DESC LIMIT 10;";

            assert connection != null;
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("cliente_id");
                int totalFacturas = rs.getInt("TotalFacturas");
                System.out.println("(ID) " + id + " - (TotalFacturas) " + totalFacturas);
            }

        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }

    }
}
