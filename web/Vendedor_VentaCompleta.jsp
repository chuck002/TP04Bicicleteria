<%-- 
    Document   : Vendedor_Listar
    Created on : 28 sep. 2020, 19:44:11
    Author     : javy
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="css/Estilos.css">
        <title>${nombre} (${venta})</title>
    </head>
    <body>
        <h1>${cantidad} ${nombre} VENDIDA a ${precio}!</h1>
        <table border="1" cellspacing="1" cellpadding="1">
            <thead>
                <tr>
                    <th>CODIGO</th>
                    <th>Nombre</th>
                    <th>Piezas</th>
                    <th>Cantidad</th>
                    <th>Precio Total</th>
                </tr>
            </thead>
            <tbody>
                <tr>
                    <td>${codigo}</td>
                    <td>${nombre}</td>
                    <td>${piezas}</td>
                    <td>${cantidad}</td>
                    <td>${precio}</td>
                </tr>

            </tbody>
        </table>
                
                <a href="ControladorVendedor?accion=volver">Volver Atras</a>
    </body>
</html>
