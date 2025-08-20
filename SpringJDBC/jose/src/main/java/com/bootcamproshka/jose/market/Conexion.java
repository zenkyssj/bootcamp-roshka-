package com.bootcamproshka.jose.market;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {
    public static Connection connect() throws SQLException {

        try {
            var jdbcUrl = "jdbc:postgresql://localhost:5432/market";
            var user = "postgres";
            var pass = "liamiamor";
            return DriverManager.getConnection(jdbcUrl, user, pass);

        } catch (SQLException e) {
            System.err.println(e.getMessage());
            return null;
        }
    }
}
