<%@page import="java.util.Date"%>
<%@page import="BD.Registros"%>
<%@page import="Modelo.Registro"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="https://fonts.googleapis.com/css?family=Pinyon+Script" rel="stylesheet">
        <link rel="stylesheet" type="text/css" href="css\Opciones_style.css">
        <title>Buscar Registros</title>
    </head>
    <body background="fondo.png">
        <form action="Registros1">
            <h1>Buscar Registro</h1>
            <table>
                <tr>
                    <td>digite Id:</td>
                    <td><input type="number" name="id" max-leng="2" size="2" placeholder="Ingrese el Id"></td>
                </tr>
                <tr>
                    <td><input type="submit" id="submit" name="buscar" value="Buscar"/></td>
                    <td><input type="button" id="button" onClick="window.location.href = 'index.jsp'" name="regresar" value="Regresar"></td>
                </tr>

                <input type="hidden" name="tipo" value="1"/>
            </table>
            <input type="button" id="button" value="Filtrar por fecha" onClick="location.href = 'BuscarRegistro2.jsp'">            
            <%
                if (request.getAttribute("Mensaje") != null) {%>
            <h1><%=(String) request.getAttribute("Mensaje")%></h1> 
            <% request.removeAttribute("Mensaje");
                }
                Registro f = (Registro) request.getAttribute("registro");
                if (f != null) {

                    out.println("<p>Id: " + f.getIdRegistro() + "</p>");
                    out.println("<p>Fecha de ingreso: " + f.getFechaIngreso().getYear() + "/"
                            + f.getFechaIngreso().getMonth() + "/" + f.getFechaIngreso().getDate() + "</p>");
                    out.println("<p>Fecha de salida: " + f.getFechaSalida().getYear() + "/"
                            + f.getFechaSalida().getMonth() + "/" + f.getFechaSalida().getDate() + "</p>");
                    out.println("<p>num serie Equipo: " + f.getEquipo().getNumSerie() + "</p>");
                    out.println("<p>Empleado: " + String.copyValueOf(f.getEmpleadoTrabajo().getNombre()) + "</p>");
                    out.println("<p>Descripcion: " + String.copyValueOf(f.getDescripcion()) + "</p>");

                }
            %>
        </form>
    </body>
</html>
