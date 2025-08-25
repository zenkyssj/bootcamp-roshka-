/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.bootcamp.servletmarket.servlets;

import com.bootcamp.servletmarket.database.Conexion;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Jose
 */
@WebServlet(name = "ClientesMasGastaron", urlPatterns = {"/ClientesMasGastaron"})
public class ClientesMasGastaron extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try (Connection conn = Conexion.connect(getServletContext())){
            response.getWriter().println("Conexion exitosa a la base de datos");

            String sql = 
                "SELECT c.id AS cliente_id, " +
                "c.nombre, " +
                "c.apellido, " +
                "SUM(fd.cantidad * p.precio) AS total_gastado " +
                "FROM cliente c " +
                "INNER JOIN factura f ON c.id = f.cliente_id " +
                "INNER JOIN factura_detalle fd ON f.id = fd.factura_id " +
                "INNER JOIN producto p ON fd.producto_id = p.id " +
                "GROUP BY c.id, c.nombre, c.apellido " +
                "ORDER BY total_gastado DESC " +
                "LIMIT 10;";

            PreparedStatement preparedStatement =  conn.prepareStatement(sql);
            ResultSet rs = preparedStatement.executeQuery();

            List<Map<String, Object>> lista;
            lista = new ArrayList<>();

            while (rs.next()){
                Map<String, Object> row = new HashMap<>();
                row.put("cliente_id", rs.getInt("cliente_id"));
                row.put("nombre", rs.getString("nombre"));
                row.put("apellido", rs.getString("apellido"));
                row.put("total_gastado", rs.getInt("total_gastado"));
                lista.add(row);
            }

            request.setAttribute("clientes", lista);

            request.getRequestDispatcher("clientesmasgastaron.jsp").forward(request, response);

        } catch (SQLException e){
            response.getWriter().println("ERROR: " + e.getMessage());
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }


    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
