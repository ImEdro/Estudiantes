<%@page import="java.sql.SQLException"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@page import="BD.Registros"%>
<%@page import="Modelo.Registro"%>
<%@page import="java.util.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="https://fonts.googleapis.com/css?family=Pinyon+Script" rel="stylesheet">
        <link rel="stylesheet" type="text/css" href="css\Opciones_style.css">
        <title>Listado Registros</title>
    </head>
    <body  background="fondo.png">
        <form>
            <h1>Listado Registros</h1>
            <table border="0">
                <tr>
                    <td> ID</td> 
                    <td> fecha de Ingreso</td> 
                    <td> fecha de Salida</td> 
                    <td> equipo</td> 
                    <td> descripcion</td> 
                    <td> Aeronave</td> 
                    <td> Empleado que le trabajo</td> 
                    <td> Empleado que lo recibio</td> 
                </tr>
                <%
                    Registros c = new Registros();
                    String query = "SELECT * FROM Registro";
                    Connection connection = c.getConnection();
                    try {
                        // create the java statement
                        Statement st = connection.createStatement();
                        // execute the query, and get a java resultset
                        ResultSet rs = st.executeQuery(query);
                        // iterate through the java resultset
                        while (rs.next()) {
                            int id = rs.getInt("idRegistro");
                            String fing = rs.getString("fechaIngreso");
                            String fsal = rs.getString("fechaSalida");
                            int equipo = rs.getInt("equipo");
                            String descripcion = rs.getString("descripcion");
                            int aeronave = rs.getInt("aeronave");
                            int EmpleadoTrabajo = rs.getInt("EmpleadoTrabajo");
                            int EmpleadoReceptor = rs.getInt("EmpleadoReceptor");
                            // print the results
                            out.println("<tr>");
                            out.println("<td> " + id + "</td>");
                            out.println("<td> " + fing + "</td>");
                            out.println("<td> " + fsal + "</td>");
                            out.println("<td> " + equipo + "</td>");
                            out.println("<td> " + descripcion + "</td>");
                            out.println("<td> " + aeronave + "</td>");
                            out.println("<td> " + EmpleadoTrabajo + "</td>");
                            out.println("<td> " + EmpleadoReceptor + "</td>");
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
            <input type="button" id="button" onClick="window.location.href = 'index.jsp'" name="regresar" value="Regresar"> 
        </form>
    </body>
</html>
