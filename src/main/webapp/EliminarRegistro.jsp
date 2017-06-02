<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="https://fonts.googleapis.com/css?family=Pinyon+Script" rel="stylesheet">
        <link rel="stylesheet" type="text/css" href="css\Opciones_style.css">
        <title>Eliminar Registro</title>
    </head>
    <body background="fondo.png">
        <form  action="Registros1">
            <h1>Eliminar Registro</h1>
            <h1>digite Id: </h1>
            <input type="number" name="id" max-leng="2" size="2" placeholder="Ingrese el Id">
            <input type="submit" id="submit" name="eliminar" value="Eliminar"/>
            <input type="button" id="button" onClick="window.location.href = 'index.jsp'" name="regresar" value="Regresar">
            <input type="hidden" name="tipo" value="1"/>
            <%
            if (request.getAttribute("Mensaje") != null) {%>
            <h1><%=(String) request.getAttribute("Mensaje")%></h1> 
            <% request.removeAttribute("Mensaje");%>
            <%
                }
            %>
        </form>
    </body>
</html>
