package com.bootcamp.roshka.model.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {
    private static final String URL = "jdbc:postgresql://localhost:5432/vacasDB";
    private static final String USER = "postgres";
    private static final String PASSWORD = "liamiamor";

    public static Connection getConnection() throws SQLException{
        try{
            Class.forName("org.postgresql.Driver");
            return DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (SQLException | ClassNotFoundException e) {
            System.out.println("Error en la conexion: " + e.getMessage());
            throw new SQLException(e);
        }
    }
}
