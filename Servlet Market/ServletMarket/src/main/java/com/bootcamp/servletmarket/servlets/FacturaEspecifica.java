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
@WebServlet(name = "FacturaEspecifica", urlPatterns = {"/FacturaEspecifica"})
public class FacturaEspecifica extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        try (Connection conn = Conexion.connect(getServletContext())){
            response.getWriter().println("Conexion exitosa a la base de datos.");

            String sql =
                    "SELECT f.fecha_emision, " +
                    "c.nombre, " +
                    "c.apellido, " +
                    "p.nombre AS producto, " +
                    "fd.cantidad, " +
                    "ft.nombre AS tipo_factura " +
                    "FROM factura f " +
                    "INNER JOIN cliente c " +
                    "ON c.id = f.cliente_id " +
                    "INNER JOIN factura_detalle fd " +
                    "ON fd.factura_id = f.id " +
                    "INNER JOIN producto p " +
                    "ON p.id = fd.producto_id " +
                    "INNER JOIN factura_tipo ft " +
                    "ON ft.id = f.factura_tipo_id " +
                    "WHERE f.id = 1;";

            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            ResultSet rs = preparedStatement.executeQuery();

            List<Map<String, Object>> lista;
            lista = new ArrayList<>();

            while (rs.next()){
                Map<String, Object> row = new HashMap<>();
                row.put("fecha_emision", rs.getDate("fecha_emision"));
                row.put("nombre", rs.getString("nombre"));
                row.put("apellido", rs.getString("apellido"));
                row.put("producto", rs.getString("producto"));
                row.put("cantidad", rs.getInt("cantidad"));
                row.put("tipo_factura", rs.getString("tipo_factura"));
                lista.add(row);
            }

            request.setAttribute("factura", lista);

            request.getRequestDispatcher("facturaespecifica.jsp").forward(request, response);

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
