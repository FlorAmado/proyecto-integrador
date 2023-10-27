<%-- 
    Document   : list
    Created on : 05/10/2023, 19:07:12
    Author     : estudiante
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Administracion de empleados</title>
    </head>
    <body>
        <h1>Nuevo Empleado</h1>

        <a href="EmpleadoController?accion=nuevo"> <h3>Nuevo Empleado</h3> </a>


        <table border="1">
            <thead>
                <tr>
                    <th>Id</th>
                    <th>Nombre</th>
                    <th>Departamento</th>
                    <th>Acciones</th>
                </tr>
            </thead>
            
            <tbody>
                <c:forEach var="empleado" items="${list}">
                    <tr>
                        <td><c:out value="${empleado.id}"></c:out></td>
                        <td><c:out value="${empleado.nombre}"></c:out></td>
                        <td><c:out value="${empleado.dpto}"></c:out></td>
                        
                        <td><a href="EmpleadoController?accion=edit">Actualizar</a></td>
                    </tr>
                </c:forEach>
                
            </tbody>
            
        </table>




    </body>


</html>
