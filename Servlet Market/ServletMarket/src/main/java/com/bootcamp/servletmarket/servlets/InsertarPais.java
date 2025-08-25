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
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Jose
 */
@WebServlet(name = "InsertarPais", urlPatterns = {"/InsertarPais"})
public class InsertarPais extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try (Connection conn = Conexion.connect(getServletContext())){
            String id = request.getParameter("id_pais");
            String nombre = request.getParameter("nombre_pais");

            String sql = "INSERT INTO pais (id, nombre) VALUES (?, ?);";

            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setInt(1, Integer.parseInt(id));
            preparedStatement.setString(2, nombre);

            int inserted = preparedStatement.executeUpdate();

            if (inserted > 0) {
                request.setAttribute("id", id);
                request.setAttribute("nombre", nombre);

                request.getRequestDispatcher("paisinsertado.jsp").forward(request, response);
            }

        } catch (SQLException e) {
            response.getWriter().println("No se pudo insertar el pais.");
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
