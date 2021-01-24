<%-- 
    Document   : Vendedor_Agregar
    Created on : 28 sep. 2020, 19:44:23
    Author     : javy
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="css/Estilos.css">
        <title>Vender Bicicletas</title>
    </head>
    <body>
        <h1>Bicicleta ${nombre}</h1>
        <form action="ControladorVendedor" method="Post">
            <table border="0" cellspacing="1" cellpadding="1">
                <thead>
                    <tr>
                        <th></th>
                        <th></th>
                    </tr>
                </thead>
                <tbody>
                    <tr>
                        <td>Codigo</td>
                        <td>${codigo}</td>
                    </tr>
                    <tr>
                        <td>Nombre</td>
                        <td>${nombre}</td>
                    </tr>
                    <tr>
                        <td>Piezas</td>
                        <td>${piezas}</td>
                    </tr>
                    <tr>
                        <td>Cantidad</td>
                        <td>${cantidad}</td>
                    </tr>
                    <tr>
                        <td>Precio</td>
                        <td>${precio}</td>
                    </tr>
                    <tr>
                        <td><label>Cuantas desea vender:</label></td>
                        <td><input type="text" name="cantidadBici"></td>

                    </tr>

                </tbody>
            </table>     
            <input type="hidden" name="codigo" value="${codigo}">
            <input type="hidden" name="nombre" value="${nombre}">
            <input type="hidden" name="piezas" value="${piezas}">
            <input type="hidden" name="precio" value="${precio}">
            <input type="submit" value="Vender Unidad/es">
            
        </form>
            <a href="ControladorVendedor?accion=volver">Volver Atras</a>
    </body>
</html>
