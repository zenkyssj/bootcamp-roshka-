/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bootcamp.servletmarket.database;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 *
 * @author Jose
 */
public class DBInitListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent sce){
        ServletContext context = sce.getServletContext();

        String dbUrl = context.getInitParameter("dbUrl");
        String dbUser = context.getInitParameter("dbUser");
        String dbPassword = context.getInitParameter("dbPassword");

        context.setAttribute("dbUrl", dbUrl);
        context.setAttribute("dbUser", dbUser);
        context.setAttribute("dbPassword", dbPassword);

        System.out.println("Parametros de la DB cargados desde web.xml");
    }
}
