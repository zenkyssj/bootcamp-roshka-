<%-- 
    Document   : topmonedas
    Created on : 25 ago 2025, 06:59:45
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
                transform: scale(1.08);
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
            <h1 style="text-align:center;">Monedas Mas Utilizadas</h1>
            <table>
                <tr>
                    <th>ID Moneda</th>
                    <th>Nombre</th>
                    <th>Total</th>
                </tr>
        
            <%
                List<Map<String, Object>> monedas = (List<Map<String, Object>>) request.getAttribute("monedas_mas_utilizadas");
                if (monedas != null && !monedas.isEmpty()) {
                    for (Map<String, Object> row : monedas) {
            %>
            
                <tr>
                    <td><%= row.get("id")%></td>
                    <td><%= row.get("nombre")%></td>
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
