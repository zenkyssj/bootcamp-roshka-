<%-- 
    Document   : facturastotales
    Created on : 22 ago 2025, 15:00:57
    Author     : Jose
--%>

<%@page import="java.util.Map"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <style>
            *{
                font-family: system-ui, -apple-system, BlinkMacSystemFont, 'Segoe UI', Roboto, Oxygen, Ubuntu, Cantarell, 'Open Sans', 'Helvetica Neue', sans-serif;
                font-weight: bold;
            }
            html, body{
                height: 100%;
                margin: 0;
                padding: 0;
            }
            body{
                background: linear-gradient(135deg, #584166, #928DAB);
                display: grid;
                place-items: center;
                box-sizing: border-box;
            }
            table {
                border-collapse: collapse;
                width: 80%;
                margin: 20px auto;
                background: #f4f4f4;
                border-radius: 8px;
                overflow: hidden;
                box-shadow: 0 15px 30px rgba(0, 0, 0, 0.4);
                border: none;
                border-radius: 1rem;
                transition: transform 0.3s ease;
            }

            table:hover{
                transform: scale(1.01);
            }
                
            th,
            td {
                border: 1px solid #ccc;
                padding: 10px;
                text-align: center;
                }
                
            th {
                background: #54396B;
                color: white;
                }
            
            tr:nth-child(even) {
                background: #e8e8e8;
            }
        </style>
        <title>JSP Page</title>
    </head>
    <body>
        <div>
            <h1 style="text-align:center;">Facturas por Totales</h1>
            <table>
                <tr>
                    <th>ID Factura</th>
                    <th>Fecha de Emision</th>
                    <th>Fecha de Vencimiento</th>
                    <th>ID Cliente</th>
                    <th>Nombre</th>
                    <th>Apellido</th>
                    <th>Tipo de Facturas</th>
                    <th>Moneda</th>
                    <TH>Total</TH>
                </tr>
            
        
        
        
        <%
            List<Map<String, Object>> facturas = (List<Map<String, Object>>) request.getAttribute("facturas_totales");
            if (facturas != null && !facturas.isEmpty()) {
                for (Map<String, Object> row : facturas) {
        %>
        
            <tr>
                <td><%= row.get("factura_id")%></td>
                <td><%= row.get("fecha_emision")%></td>
                <td><%= row.get("fecha_vencimiento")%></td>
                <td><%= row.get("cliente_id")%></td>
                <td><%= row.get("nombre")%></td>
                <td><%= row.get("apellido")%></td>
                <td><%= row.get("tipo_factura")%></td>
                <td><%= row.get("moneda")%></td>
                <td><%= row.get("total")%></td>
            </tr>

        <% 
            }
        %>
        
        </table>
        
        <%      
            } else { 
        %>

            <p>No se encontraron resultados.</p>

        <% 
            } 
        %>
        </div>
    </body>
</html>
