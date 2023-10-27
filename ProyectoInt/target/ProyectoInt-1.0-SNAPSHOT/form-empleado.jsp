<%-- 
    Document   : form-empleado
    Created on : 05/10/2023, 19:09:42
    Author     : estudiante
                /value="<c:ount value="${empleado.dpto}"></c:out>"/

--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Formulario empleado</h1>

        <form action="EmpleadoController" method="post">
            <p>
                Nombre:
                <input type="text" name="nombre">
            </p>
            <p>
                Departamento:
                <input type="text" name="dpto" > <br/>
            </p>
            
            <p>
                <input type="submit" value="Guardar">
            </p>


        </form>
    </body>
</html>
