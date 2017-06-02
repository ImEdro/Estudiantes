<%@page import="java.sql.SQLException"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@page import="BD.Registros"%>
<%@page import="BD.Empleados"%>
<%@page import="Modelo.Empleado"%>
<%@page import="Modelo.Registro"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="https://fonts.googleapis.com/css?family=Pinyon+Script" rel="stylesheet">
        <link rel="stylesheet" type="text/css" href="css\Opciones_style.css">
        <title>Buscar Empleado</title>
    </head>
    <body background="fondo.png">
        <form  action="Empleados1">
            <h1>Buscar Empleado</h1>
            <table>
                <tr>
                    <td>Id:     
                    <td><input type="number" name="id" size="2" placeholder="Ingrese el Id"/></td>
                </tr>
                <tr>
                    <td><input type="submit" id="submit" name="buscar" value="Buscar"/></td>
                    <td><input type="button" id="button" onClick="window.location.href = 'index.jsp" name="regresar" value="Regresar"></td>
                </tr>
                <input type="hidden" name="tipo" value="1"/>
            </table>

            <%
                if (request.getAttribute("Mensaje") != null) {%>
            <h1><%=(String) request.getAttribute("Mensaje")%></h1> 
            <% request.removeAttribute("Mensaje");%>
            <%
                }
                Empleado e = (Empleado) request.getAttribute("empleado");
                if (e != null) {%> 
            <p> Empleado</p>
            <p>     Nombre:     <%=(String) String.copyValueOf(e.getNombre())%>     </p>
            <p>     seccion:   <%=(int) e.getSeccion()%> </p>
            <%

                Registros c = new Registros();
                String query = "SELECT * FROM Registros where EmpleadoTrabajo = " + e.getIdEmpleado();
                Connection connection = c.getConnection();
                try {

                    // create the java statement
                    Statement st = connection.createStatement();
                    // execute the query, and get a java resultset
                    ResultSet rs = st.executeQuery(query);
                    // iterate through the java resultset
            %>
            <%
                    } catch (SQLException ex) {
                        // TODO Auto-generated catch block
                        System.out.println("no hay registros ");
                        ex.printStackTrace();
                    }
                }
            %>  

        </form>
    </body>
</html>