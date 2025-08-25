/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bootcamp.servletmarket.database;

import javax.servlet.ServletContext;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Jose
 */
public class Conexion {
    public static Connection connect(ServletContext context) throws SQLException{
        try{
            String jdbcUrl =  context.getInitParameter("dbUrl");
            String user =  context.getInitParameter("dbUser");
            String pass =  context.getInitParameter("dbPassword");
               
            Class.forName("org.postgresql.Driver");
            return DriverManager.getConnection(jdbcUrl, user, pass);

        } catch (SQLException | ClassNotFoundException e){
            System.err.println("Error de conexion: " + e.getMessage());
            throw new SQLException(e);
        }
    }
}
