<%-- 
    Document   : Encargado_Listar
    Created on : 28 sep. 2020, 19:44:47
    Author     : javy
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="css/Estilos.css">
        <title>Listar Piezas</title>
    </head>
    <body>
        <h1>Lista de Piezas</h1>
        <table border="1" cellspacing="1" cellpadding="1">
            <thead>
                <tr>
                    <th>COD</th>
                    <th>Tipo</th>
                    <th>Cantidad</th>
                    <th>Precio</th>
                </tr>
            </thead>
           
            <tbody>
                <c:forEach var="piezas" items="${ListaPiezas}">
                <tr>
                    <td>${piezas.codigo}</td>
                    <td>${piezas.tipo}</td>
                    <td>${piezas.cantidad}</td>
                    <td>${piezas.precio}</td>
                </tr>
                </c:forEach>
            </tbody>
        </table>
        <a href="Encargado.jsp">Volver Atras</a>
    </body>
</html>
