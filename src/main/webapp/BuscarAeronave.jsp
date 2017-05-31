<%@page import="BD.Aeronaves"%>
<%@page import="Modelo.Aeronave"%>
<%@page import="Modelo.Registro"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="https://fonts.googleapis.com/css?family=Pinyon+Script" rel="stylesheet">
        <link rel="stylesheet" type="text/css" href="css\Opciones_style.css">
        <title>Buscar Aeronave</title>
    </head>
    <body background="fondo.png">  
        <form method= "POST" action="Aeronaves1">
            <h1>Buscar Aeronave</h1>
            <table>
                <tr>
                    <td>digite Id:</td>
                    <td><input type="number" name="id" max-leng="2" size="2" placeholder="Ingrese el Id"></td>
                </tr>
                <tr>
                    <td><input type="submit" id="submit" name="buscar" value="Buscar"/></td>
                    <td><input type="button" id="button" onClick="window.location.href = 'index.jsp'" name="regresar" value="Regresar"></td>
                </tr>
            </table>
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
