<%@page import="java.sql.SQLException"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@page import="BD.Fabricantes"%>
<%@page import="Modelo.Fabricante"%>
<%@page import="java.util.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="https://fonts.googleapis.com/css?family=Pinyon+Script" rel="stylesheet">
        <link rel="stylesheet" type="text/css" href="css\Opciones_style.css">
        <title>Listado Fabricantes</title>
    </head>
    <body  background="fondo.png">
        <form>
            <h1>Listado Fabricantes</h1>
            <table border="0">
            <tr>
                <td> ID</td> 
                <td> Nombre</td> 
            </tr>
            <%
                Fabricantes c = new Fabricantes();
                String query = "SELECT * FROM Fabricante";
                 Connection connection=c.getConnection();
                try {
                    // create the java statement
                    Statement st = connection.createStatement();
                    // execute the query, and get a java resultset
                    ResultSet rs = st.executeQuery(query);
                    // iterate through the java resultset
                    while (rs.next()) {
                        int id = rs.getInt("idFabricante");
                        String nom = rs.getString("nombre");
                        // print the results
                        out.println("<tr>");
                        out.println("<td> " + id + "</td>");
                        out.println("<td> " + nom + "</td>");
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
            <input type="button" id="button" onClick="window.location.href = 'index.jsp" name="regresar" value="Regresar"> 
        </form>
    </body>
</html>
