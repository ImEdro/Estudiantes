<%@page import="java.sql.SQLException"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@page import="BD.Equipos"%>
<%@page import="Modelo.Equipo"%>
<%@page import="java.util.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="https://fonts.googleapis.com/css?family=Pinyon+Script" rel="stylesheet">
        <link rel="stylesheet" type="text/css" href="css\Opciones_style.css">
        <title>Listado Equipos</title>
    </head>
    <body background="fondo.png">
        <form>
            <h1>Listado Equipos</h1>
            <table border="0">
                <tr> 
                    <td> Nº Serie </td> 
                    <td> Nº Parte </td> 
                    <td> Nombre </td> 
                    <td> Aeronave </td> 
                    <td> Fabricante </td>
                </tr>
                <%
                    Equipos c = new Equipos();
                    String query = "SELECT * FROM Empleado";
                    Connection connection = c.getConnection();
                    try {
                        // create the java statement
                        Statement st = connection.createStatement();
                        // execute the query, and get a java resultset
                        ResultSet rs = st.executeQuery(query);
                        // iterate through the java resultset
                        while (rs.next()) {
                            int numserie = rs.getInt("numSerie");
                            int numparte = rs.getInt("numParte");
                            String nombre = rs.getString("nombre");
                            int Fabricante = rs.getInt("Fabricante");
                            int Aeronave = rs.getInt("Aeronave");
                            // print the results
                            out.println("<tr>");
                            out.println("<td> " + numserie + "</td>");
                            out.println("<td> " + numparte + "</td>");
                            out.println("<td> " + nombre + "</td>");
                            out.println("<td> " + Fabricante + "</td>");
                            out.println("<td> " + Aeronave + "</td>");
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
