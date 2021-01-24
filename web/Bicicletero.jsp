<%-- 
    Document   : Bicicletero
    Created on : 28 sep. 2020, 19:43:07
    Author     : javy
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="css/Estilos.css">

        <title>Bicicletero</title>
    </head>
    <body>
        <h1>Hola Bicicletero ${nombre}!</h1>
        <h1>Bienvenido!</h1>
        <table border="0" cellspacing="1">
            <thead>
                <tr>
                    <th></th>
                </tr>
            </thead>
            <tbody>
                <tr>
                    <td><a href="ControladorBicicletero?accion=Crear">Crear Bicicleta</a> </td>
                </tr>
                <tr>
                    <td><a href="ControladorBicicletero?accion=Listar">Listar Bicicletas</a></td>
                </tr>
                <tr>
                    <td><a href="ControladorBicicletero?accion=Salir">Salir</a></td>
                </tr>
            </tbody>
        </table>

    </body>
</html>
