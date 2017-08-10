<%@page import="BD.Aeronaves"%>
<%@page import="java.sql.SQLException"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="https://fonts.googleapis.com/css?family=Pinyon+Script" rel="stylesheet">
        <link rel="stylesheet" type="text/css" href="css\Opciones_style.css">
        <title>Listado Aeronaves</title>
    </head>
    <body background="fondo.png">
        <form> 
            <h1>Listado Aeronaves</h1>
            <table border="0">
                <tr>
                    <td> ID</td> 
                    <td> Nombre</td> 
                </tr>
                <%
                    Aeronaves c = new Aeronaves();
                    String query = "SELECT * FROM Aeronave";
                     Connection connection=c.getConnection();
                    try {
                        // create the java statement
                        Statement st = connection.createStatement();
                        // execute the query, and get a java resultset
                        ResultSet rs = st.executeQuery(query);
                        // iterate through the java resultset
                        while (rs.next()) {
                            
                            String nom = rs.getString("nombre");
                            String ape = rs.getString("apellido");
                            int tel = rs.getInt("telefono");
                            int cel = rs.getInt("celular");
                            
                            // print the results
                            out.println("<tr>");
                            out.println("<td> " + nom + "</td>");
                            out.println("<td> " + ape + "</td>");
                            out.println("<td> " + tel + "</td>");
                            out.println("<td> " + cel + "</td>");
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
            <h1>Descargar Excel <a href="HSSFCreateAeronave">Descargar</a></h1>
            <input type="button" id="button" onClick="window.location.href = 'index.jsp'" name="regresar" value="Regresar"> 
        </form>
    </body>
</html>