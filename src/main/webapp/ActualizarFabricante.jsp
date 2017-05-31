<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="https://fonts.googleapis.com/css?family=Pinyon+Script" rel="stylesheet">
        <link rel="stylesheet" type="text/css" href="css\Opciones_style.css">
        <title>Actualizar Fabricante</title>
    </head>
    <body background="fondo.png">
        <form method= "POST" action="Fabricantes1">
            <h1>Actualizar Fabricante</h1>
            <table>
                <tr>
                    <td>Id:</td> 
                    <td><input type="number" name="id" size="2" placeholder="Ingrese el id"/> </td>
                </tr>
                <tr>
                    <td>Nombre:</td>  
                    <td><input type="text" name="nombre" size="20" placeholder="Ingrese el nombre"/></td>
                </tr>
                <tr>
                    <td><input type="submit" id="submit" name="Actualizar" value="Actualizar"></td>
                    <td><input type="button" id="button" onClick="window.location.href = 'index.jsp'" name="regresar" value="Regresar"> </td>
                </tr>
                <input type="hidden" name="tipo" value="4">
            </table>
            <%
            if (request.getAttribute("Mensaje") != null) {%>
            <h1><%=(String) request.getAttribute("Mensaje")%></h1> 
            <% request.removeAttribute("Mensaje");
                }
            %>
        </form>
    </body>
</html>
