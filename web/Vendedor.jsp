<%-- 
    Document   : Vendedor
    Created on : 28 sep. 2020, 19:43:58
    Author     : javy
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="css/Estilos.css">
        <title>Vendedor</title>
    </head>
    <body>
        <h1>Hola Vendedor ${nombre}!</h1>
        <h1>Bienvenido!</h1>
        
        <table border="1" cellspacing="1" cellpadding="1">
            <thead>
                <tr>
                    <th id="cod1">COD</th>
                    <th id="cod2">Nombre</th>
                    <th id="cod3">Piezas</th>
                    <th id="cod4">Cantidad en Stock</th>
                    <th id="cod5">Precio</th>
                    <th id="cod6">Venta</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var = "bici" items="${listaBici}">
                <tr>
                    <td>${bici.codigo}</td>
                    <td>${bici.nombre}</td>
                    <td>${bici.piezas}</td>
                    <td>${bici.cantidad}</td>
                    <td>${bici.precio}</td>
                    <td><a href="ControladorVendedor?accion=VenderBicicleta&codigo=${bici.codigo}&nombre=${bici.nombre}&piezas=${bici.piezas}&cantidad=${bici.cantidad}&precio=${bici.precio}">Vender Unidad/es</a></td>
                </tr>
             </c:forEach>
            </tbody>
        </table>
<a href="ControladorVendedor?accion=salir">Salir</a>
        
    </body>
</html>
