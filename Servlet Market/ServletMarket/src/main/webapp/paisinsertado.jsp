<%-- Document : paisinsertado Created on : 25 ago 2025, 12:56:15 Author : Jose --%>

    <%@page contentType="text/html" pageEncoding="UTF-8" %>
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
            <link rel="stylesheet" href="\Styles\paisinsertado.css?v=1">
            <title>JSP Page</title>
        </head>

        <body>

            <div>
                <h1 style="text-align:center;">Producto Insertado</h1>
                <table>
                    <tr>
                        <th>ID</th>
                        <th>Nombre</th>
                    </tr>

                    <tr>
                        <td>${id}</td>
                        <td>${nombre}</td>
                    </tr>
                </table>

            </div>
        </body>
    </html>