<%-- 
    Document   : Bicicletero_Agregar
    Created on : 28 sep. 2020, 19:43:49
    Author     : javy
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="css/Estilos.css">
        <title>Crear Nueva Bicicleta</title>
    </head>
    <body>
        <h1>Crear Nueva Bicicleta</h1>
        <c:if test="${codigo == 0}">
            <h1>Inserte el Codigo de las piezas.</h1>
            <h2>Piezas Disponibles</h2>
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
            <form method="post" action="ControladorBicicletero">
                <label>Codigo: </label>
                <input type="text" name="pruebaCodigo">
                <input type="hidden" name="accion" value="prueba">
                <input type="submit" value="Agregar Codigo">
            </form>
        </c:if>
        <c:if test="${codigo < 0 && codigo != -1000}">
            <h1>Codigo Equivocado. Vuelva a intentarlo.</h1>
            
        </c:if>
        <c:if test="${codigo == -1000}">
            <h1>No se encuentran todas las piezas para esta Bicicleta. <br>Vuelva a intentarlo con otro codigo.</h1>
          
        </c:if>
        <c:if test="${codigo > 0}">

            <form method="post" action="ControladorBicicletero">
                <table border="1" cellspacing="1" cellpadding="1">
                    <thead>
                        <tr>
                            <th>COD</th>
                            <th>Tipo</th>
                            <th>Cantidad en Stock</th>
                            <th>Precio</th>
                            <th>Agregar Pieza</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach var="pieza" items="${piezasCodigo}">
                            <tr>

                                <td>
                                    ${pieza.codigo}
                                </td>
                                <td>${pieza.tipo}</td>
                                <td>${pieza.cantidad}</td>
                                <td>${pieza.precio}</td>
                                <td><input type="checkbox" value=1 name="piezasCargadas"></td>

                            </tr>     
                        </c:forEach>

                    </tbody>
                </table>


                <table border="1" cellspacing="1">
                    <tbody>
                        <tr>
                            <td><label>Cantidad:</label></td>
                            <td><input type="text" name="cantidadBici"></td>
                        </tr>
                        <tr>
                            <td><label>Precio:</label></td>
                            <td><input type="text" name="precioBici"></td>
                        </tr>
                        <tr>
                            <td><label>Nombre:</label></td>
                            <td><input type="text" name="nombreBici" value=""></td>
                        </tr>
                    </tbody>
                </table>
                <input type="hidden" name="codigoBici" value="${proxCodigo}">
                
                <input type="hidden" name="pruebaCodigo" value="${codigo}">
                <input type="hidden" name="accion" value="agregaBici">
                <input type="submit" value="Crear Bicicleta">
            </form>
        </c:if>
        <c:if test="${salida} != 0">
            <label>${salida}</label>
        </c:if>
        <a href="Bicicletero.jsp">Volver Atras</a>
    </body>
</html>
