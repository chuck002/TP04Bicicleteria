<%-- 
    Document   : index
    Created on : 28 sep. 2020, 19:41:29
    Author     : javy
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="css/Estilos.css">
        <title>Bicicleteria V1.0</title>
    </head>
    <body>
        <div >
            <h1>Bienvenido a la Bicicleteria V1.0</h1>
            <form action="LoginIntro" method="POST">
                <%--
            <table border="0" cellspacing="1">
                <thead>
                    <tr>
                        <th><label><b>Usuario: </b></label></th>
                        <th><input type="text" name="user"></th>
                    </tr>
                </thead>
                <tbody>
                    <tr>
                        <td><label><b>Contraseña: </b></label></td>
                        <td><input type="Password" name="pass"></td>
                    </tr>
                    <tr>
                        <td><input type="submit" value="Ingresar"></td>
                    </tr>
                </tbody>
            </table>
                --%>
                <p> <label><b>Usuario: </b></label>
                    <input type="text" name="user"><label><b> Contraseña: </b></label>
                    <input type="Password" name="pass"></p>
                <input type="submit" value="Ingresar">
            </form>
        </div>
    </body>
</html>
