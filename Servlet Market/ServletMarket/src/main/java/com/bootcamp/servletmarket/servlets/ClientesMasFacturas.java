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
@WebServlet(name = "ClientesMasFacturas", urlPatterns = {"/ClientesMasFacturas"})
public class ClientesMasFacturas extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        /*String test = getServletContext().getInitParameter("dbUrl");
        response.getWriter().println("dbUrl leído: " + test);
        */

        try (Connection conn = Conexion.connect(getServletContext())){
            response.getWriter().println("Conexion exitosa a la base de datos:");

            String sql = "SELECT cliente_id, count(factura.id) AS TotalFacturas FROM factura GROUP BY cliente_id ORDER BY cliente_id DESC LIMIT 10;";

            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            ResultSet rs = preparedStatement.executeQuery();

            List<Map<String, Object>> lista;
            lista = new ArrayList<>();

            while (rs.next()){
                Map<String, Object> row = new HashMap<>();
                row.put("cliente_id", rs.getInt("cliente_id"));
                row.put("TotalFacturas", rs.getInt("TotalFacturas"));
                lista.add(row);
            }

            request.setAttribute("clientes", lista);

            request.getRequestDispatcher("clientesmasfacturas.jsp").forward(request, response);

        } catch (SQLException e){
            response.getWriter().println("Error: "+ e);
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
