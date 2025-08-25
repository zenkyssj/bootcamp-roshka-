/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.bootcamp.servletmarket.servlets;

import com.bootcamp.servletmarket.database.Conexion;
import org.postgresql.shaded.com.ongres.scram.common.StringPreparation;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.persistence.criteria.CriteriaBuilder;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Jose
 */
@WebServlet(name = "InsertarProveedor", urlPatterns = {"/InsertarProveedor"})
public class InsertarProveedor extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try (Connection conn = Conexion.connect(getServletContext())){
            String id = request.getParameter("id_proveedor");
            String nombre = request.getParameter("nombre_proveedor");
            String ruc = request.getParameter("ruc");
            String id_pais = request.getParameter("id_pais");

            String sql = "INSERT INTO proveedor (id, nombre, ruc, pais_id) VALUES (?, ?, ?, ?);";

            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setInt(1, Integer.parseInt(id));
            preparedStatement.setString(2, nombre);
            preparedStatement.setString(3, ruc);
            preparedStatement.setInt(4, Integer.parseInt(id_pais));

            int inserted = preparedStatement.executeUpdate();

            if (inserted > 0) {
                request.setAttribute("id", id);
                request.setAttribute("nombre", nombre);
                request.setAttribute("ruc", ruc);
                request.setAttribute("id_pais", id_pais);

                request.getRequestDispatcher("proveedorinsertado.jsp").forward(request, response);
            } else {
                response.getWriter().println("No se pudo insertar el proveedor.");
            }

        } catch (SQLException e){
            response.getWriter().println("ERROR: " + e.getMessage());
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
