<%-- 
    Document   : Bicicletero_Listar
    Created on : 28 sep. 2020, 19:43:34
    Author     : javy
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="css/Estilos.css">
        <title>Lista de Bicicletas</title>
    </head>
    <body>
        <h1>Bicicletas en Stock</h1>
        <table border="1" cellspacing="1">
            <thead>
                <tr>
                    <th><b>COD</b></th>
                    <th><b>Nombre</b></th>
                    <th><b>Cantidad</b></th>
                    <th><b>Piezas</b></th>
                    <th><b>Precio</b></th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="bici" items="${ListaBicis}">
                    <tr>
                        <td>${bici.codigo}</td>
                        <td>${bici.nombre}</td>
                        <td>${bici.cantidad}</td>
                        <td>${bici.piezas}</td>
                        <td>$${bici.precio}</td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
        <a href="Bicicletero.jsp">Volver Atras</a>
    </body>
</html>
