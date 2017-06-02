<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="https://fonts.googleapis.com/css?family=Pinyon+Script" rel="stylesheet">
        <link rel="stylesheet" type="text/css" href="css\Opciones_style.css">
        <title>Actualizar Equipo</title>
    </head>
    <body background="fondo.png">
        <form action="Equipos1">
            <h1>Actualizar Equipo</h1>
            <table>
                <tr>
                    <td>Numero de serie:</td>     
                    <td><input type="number" name="id" size="3" placeholder="Ingrese el N° de serie"/></td> 
                </tr>
                <tr>
                    <td>Nombre:</td>              
                    <td><input type="text" name="nombre" size="20" placeholder="Ingrese el nombre"/></td>
                </tr>
                <tr>
                    <td>numero de parte:</td>     
                    <td><input type="number" name="parte" size="3" placeholder="Ingrese el N° de partes"/></td>
                </tr>
                <tr>
                    <td>Idfabricante:</td>        
                    <td><input type="number" name="fabricante" size="3" placeholder="Ingrese el id del fabricante"/></td>  
                </tr>
                <tr>
                    <td>Idaeronave:</td>          
                    <td><input type="number" name="aeronave" size="3" placeholder="Ingrese el id del aeronave"/></td>
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
            %>
            <%
                }
            %>
        </form>
    </body>
</html>
