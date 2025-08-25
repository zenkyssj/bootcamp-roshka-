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
import javax.imageio.plugins.jpeg.JPEGImageReadParam;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Jose
 */
@WebServlet(name = "InsertarProducto", urlPatterns = {"/InsertarProducto"})
public class InsertarProducto extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try (Connection conn = Conexion.connect(getServletContext())) {
            String id = request.getParameter("id_producto");
            String nombre = request.getParameter("nombre");
            String precio = request.getParameter("precio");
            String proveedor = request.getParameter("proveedor");
            String costo = request.getParameter("costo");
            
            System.out.println("Nombre: " + nombre);
            System.out.println("Precio: " + precio);
            System.out.println("Proveedor: " + proveedor);
            System.out.println("Costo: " + costo);
            String sql = "INSERT INTO producto (id, nombre, precio, proveedor_id, costo) VALUES (? ,?, ?, ?, ?); ";

            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setInt(1, Integer.parseInt(id));
            preparedStatement.setString(2, nombre);
            preparedStatement.setDouble(3,  Double.parseDouble(precio));
            preparedStatement.setInt(4, Integer.parseInt(proveedor));
            preparedStatement.setDouble(5, Double.parseDouble(costo));

            int inserted = preparedStatement.executeUpdate();

            if (inserted > 0){
                request.setAttribute("id", id);
                request.setAttribute("nombre", nombre);
                request.setAttribute("precio", precio);
                request.setAttribute("proveedor", proveedor);
                request.setAttribute("costo", costo);

                request.getRequestDispatcher("productoinsertado.jsp").forward(request, response);
            } else {
                response.getWriter().println("No se pudo insertar el producto.");
            }

        } catch (SQLException e) {
            response.getWriter().println("ERROR. " + e.getMessage());
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
