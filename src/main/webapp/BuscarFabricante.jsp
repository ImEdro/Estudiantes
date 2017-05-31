<%@page import="BD.Fabricantes"%>
<%@page import="Modelo.Fabricante"%>
<%@page import="Modelo.Registro"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="https://fonts.googleapis.com/css?family=Pinyon+Script" rel="stylesheet">
        <link rel="stylesheet" type="text/css" href="css\Opciones_style.css">
        <title>Buscar Fabbricante</title>
    </head>
    <body background="fondo.png">
        <form method= "POST" action="Fabricantes1">
            <h1>Buscar Fabricante</h1>
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
            <%
            if (request.getAttribute("Mensaje") != null) {%>
            <h1><%=(String) request.getAttribute("Mensaje")%></h1> 
            <% request.removeAttribute("Mensaje");
                }
                Fabricante f = (Fabricante) request.getAttribute("fabricante");
                if (f != null) {
            %>
            <h1> nombre fabricante: <%=(String) String.copyValueOf(f.getNombre())%></h1> 
            <%
                }
            %>
        </form>
    </body>
</html>
