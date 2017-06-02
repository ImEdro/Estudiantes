<%@page import="java.sql.SQLException"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.Statement"%>
<%@page import="BD.Registros"%>
<%@page import="java.util.ArrayList"%>
<%@page import="Modelo.Registro"%>
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
            <h1> Buscar Registro por fecha </h1>
            <table>
                <tr>
                    <td>dia:</td>
                    <td><input type="number" name="dia" max-leng="2" size="2" placeholder="Ingrese el dia"></td>
                </tr>
                <tr>
                    <td>mes:</td>
                    <td><input type="number" name="mes" max-leng="2" size="2" placeholder="Ingrese el mes"></td>
                </tr>
                <tr>
                    <td>año:</td>
                    <td><input type="number" name="ao" max-leng="2" size="2" placeholder="Ingrese el año"></td>
                </tr>
                <tr>
                    <td><input type="submit" id="submit" name="buscar" value="Buscar"/></td>
                    <td><input type="button" id="button" onClick="window.location.href = 'index.jsp'" name="regresar" value="Regresar"></td>
                </tr>
                <input type="hidden" name="tipo" value="0"/>
            </table>

            <% if (request.getAttribute("fecha") != null) {
            %>
            <table border="0">
                <tr>
                    <td><h6> IDregistro</h6></td> 
                    <td><h6> Fecha ingreso</h6></td> 
                    <td><h6> Fecha salida</h6></td> 
                    <td><h6> num serie Equipo</h6></td> 
                    <td><h6> empleado que le trabajo</h6></td> 
                    <td><h6> empleado que recibio</h6></td> 
                    <td><h6> descripcion</h6></td> 
                </tr>
                <%
                    Registros c = new Registros();
                    String query = "SELECT * FROM Registro where fechaIngreso > '" + request.getAttribute("fecha") + "'";
                    Connection connection = c.getConnection();
                    try {
                        // create the java statement
                        Statement st = connection.createStatement();
                        // execute the query, and get a java resultset
                        ResultSet rs = st.executeQuery(query);
                        // iterate through the java resultset
                        while (rs.next()) {
                            int id = rs.getInt("idRegistro");
                            String fini = rs.getString("fechaIngreso");
                            String fsal = rs.getString("fechaSalida");
                            int equipo = rs.getInt("equipo");
                            int empt = rs.getInt("EmpleadoTrabajo");
                            int empr = rs.getInt("EmpleadoReceptor");
                            String descripcion = rs.getString("descripcion");
                            // print the results
                            out.println("<tr>");
                            out.println("<td> " + id + "</td>");
                            out.println("<td> " + fini + "</td>");
                            out.println("<td> " + fsal + "</td>");
                            out.println("<td> " + equipo + "</td>");
                            out.println("<td> " + empt + "</td>");
                            out.println("<td> " + empr + "</td>");
                            out.println("<td> " + descripcion + "</td>");
                            out.println("</tr>");
                        }
                        st.close();
                    } catch (SQLException e) {
                        // TODO Auto-generated catch block
                        System.out.println("Failed to make update!");
                        e.printStackTrace();
                    }

                %>
            </table>
            <%                    }
            %>
        </form>
    </body>
</html>
