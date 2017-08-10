<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="https://fonts.googleapis.com/css?family=Pinyon+Script" rel="stylesheet">
        <link rel="stylesheet" type="text/css" href="css\Opciones_style.css">
        <title>Nuevo Aeronave</title>

    </head>
    <body background="fondo.png">
       
        <form action="Aeronaves1">
             <h1>Nueva Aeronave</h1>
            <table>
                <tr>
                    <td>Nombre:</td> 
                    <td><input type="text" name="nombre" size="2" placeholder="Ingrese el nombre"/> </td>
                </tr>
                <tr>
                    <td>Apellido:</td>  
                    <td><input type="text" name="apellido" size="20" placeholder="Ingrese el apellido"/></td>
                </tr>
                <tr>
                    <tr>
                    <td>Telefono:</td> 
                    <td><input type="number" name="telefono" size="2" placeholder="Ingrese el telefono"/> </td>
                </tr>
                <tr>
                    <td>Celular:</td>  
                    <td><input type="number" name="celular" size="20" placeholder="Ingrese el celular"/></td>
                </tr>
                <tr>
                    <td><input type="submit" id="submit" name="Crear" value="Crear"></td>
                    <td><input type="button" id="button" onClick="window.location.href='index.jsp'" name="regresar" value="Regresar"> </td>
                </tr>
                <input type="hidden" name="tipo" value="3">
            </table>
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
