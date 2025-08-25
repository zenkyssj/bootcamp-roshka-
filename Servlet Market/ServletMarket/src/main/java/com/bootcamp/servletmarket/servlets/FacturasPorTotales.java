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
@WebServlet(name = "FacturasPorTotales", urlPatterns = {"/FacturasPorTotales"})
public class FacturasPorTotales extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try (Connection conn = Conexion.connect(getServletContext())){
            String sql =
                    "SELECT f.id AS factura_id, " +
                    "f.fecha_emision, " +
                    "f.fecha_vencimiento, " +
                    "c.id AS cliente_id, " +
                    "c.nombre, " +
                    "c.apellido, " +
                    "ft.nombre AS tipo_factura, " +
                    "m.nombre AS moneda, " +
                    "SUM(fd.cantidad * p.precio) AS total " +
                    "FROM factura f " +
                    "INNER JOIN cliente c " +
                    "ON c.id = f.cliente_id " +
                    "INNER JOIN factura_detalle fd " +
                    "ON fd.factura_id = f.id " +
                    "INNER JOIN producto p " +
                    "ON p.id = fd.producto_id " +
                    "INNER JOIN factura_tipo ft " +
                    "ON ft.id = f.factura_tipo_id " +
                    "INNER JOIN moneda m " +
                    "ON m.id = f.moneda_id " +
                    "GROUP BY f.id, c.id, c.nombre, c.apellido, ft.nombre, m.nombre, f.fecha_emision, f.fecha_vencimiento " +
                    "ORDER BY total DESC; ";

            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            ResultSet rs = preparedStatement.executeQuery();

            List<Map<String, Object>> lista;
            lista = new ArrayList<>();

            while (rs.next()){
                Map<String, Object> row = new HashMap<>();
                row.put("factura_id", rs.getInt("factura_id"));
                row.put("fecha_emision", rs.getDate("fecha_emision"));
                row.put("fecha_vencimiento", rs.getDate("fecha_vencimiento"));
                row.put("cliente_id", rs.getInt("cliente_id"));
                row.put("nombre", rs.getString("nombre"));
                row.put("apellido", rs.getString("apellido"));
                row.put("tipo_factura", rs.getString("tipo_factura"));
                row.put("moneda", rs.getString("moneda"));
                row.put("total", rs.getInt("total"));
                lista.add(row);
            }

            request.setAttribute("facturas_totales", lista);

            request.getRequestDispatcher("facturastotales.jsp").forward(request, response);

        } catch (SQLException e){
            response.getWriter().println("ERROR: " + e);
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
