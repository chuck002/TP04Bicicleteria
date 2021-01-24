<%-- 
    Document   : Encargado_Agregar
    Created on : 28 sep. 2020, 19:44:57
    Author     : javy
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="css/Estilos.css">
        <title>Agregar Nueva Pieza</title>
    </head>
    <body>
        <h1>Agregar Nueva Pieza al Stock</h1>
        <form action="ControladorEncargado">
            <table border="1" cellspacing="1">
                <thead>
                    <tr>
                        <th>COD</th>
                        <th>Tipo</th>
                        <th>Cantidad</th>
                        <th>Precio</th>
                    </tr>
                </thead>
                <tbody>
                    <tr>
                        <td><input type="text" name="codigoPieza"></td>
                        <td><select name="Pieza">
                                <option>Pedal</option>
                                <option>Rueda</option>
                                <option>Manubrio</option>
                                <option>Cuadro</option>
                                <option>Asiento</option>
                                <option>Kit Mecanico</option>
                            </select></td>
                        <td><input type="text" name="cantidadPieza"></td>
                        <td><input type="text" name="precioPieza"></td>
                    </tr>
                </tbody>
            </table>
            <input type="submit" name="accion" value="Agregar Pieza">
            
        </form>
        <a href="Encargado.jsp">Volver Atras</a>
    </body>
</html>
