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
@WebServlet(name = "ProductosMenosVendidos", urlPatterns = {"/ProductosMenosVendidos"})
public class ProductosMenosVendidos extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try (Connection conn = Conexion.connect(getServletContext())){
            String sql =
                    "SELECT p.id, " +
                            "p.nombre, " +
                            "COUNT(fd.id) AS totalventas " +
                            "FROM producto p " +
                            "INNER JOIN factura_detalle fd "  +
                            "ON p.id = fd.producto_id " +
                            "GROUP BY p.id, p.nombre " +
                            "ORDER BY totalventas " +
                            "LIMIT 10; ";

            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            ResultSet rs = preparedStatement.executeQuery();

            List<Map<String, Object>> lista;
            lista = new ArrayList<>();

            while (rs.next()){
                Map<String, Object> row = new HashMap<>();
                row.put("id", rs.getInt("id"));
                row.put("nombre", rs.getString("nombre"));
                row.put("totalventas", rs.getInt("totalventas"));
                lista.add(row);
            }

            request.setAttribute("productos_menos_vendidos", lista);
            request.getRequestDispatcher("productosmenosvendidos.jsp").forward(request, response);

        } catch (SQLException e ){
            response.getWriter().println("ERROR: " +  e.getMessage());
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
