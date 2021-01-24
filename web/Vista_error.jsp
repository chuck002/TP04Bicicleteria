<%-- 
    Document   : Error_PagInexistente
    Created on : 28 sep. 2020, 19:45:18
    Author     : javy
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="css/Estilos.css">
        <title>¡ERROR!</title>
    </head>
    <body>
        <c:if test="${codigo == 1}">
        <h1>${Error1}</h1>
        <a href="ControladorVendedor?accion=salir">Volver Atras</a>
        </c:if>
        <c:if test="${codigo == 2}">
        <h1>${Error2}</h1>
        <a href="Bicicletero_Agregar.jsp">Volver Atras</a>
        </c:if>
        <c:if test="${codigo == 3}">
        <h1>${Error3}</h1>
        <a href="Bicicletero_Agregar.jsp">Volver Atras</a>
        </c:if>
    </body>
</html>
