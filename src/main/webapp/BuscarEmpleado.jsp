
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
            <h1>Buscar Aeronave</h1>
            <table>
                <tr>
                    <td>Id:     
                    <td><input type="number" name="id" size="2" placeholder="Ingrese el Id"/></td>
                </tr>
                <tr>
                <h1>fecha filtro Rgistros</h1>
                </tr>
                <tr>
                    <td>dia:</td>     
                    <td><input type="number" name="dia" size="2" placeholder="Ingrese el dia"/></td>
                </tr>
                <tr>
                    <td>mes:</td>     
                    <td><input type="number" name="mes" size="2" placeholder="Ingrese el mes"/></td>
                </tr> 
                <tr>
                    <td>año:</td>     
                    <td><input type="number" name="ao" size="2" placeholder="Ingrese el año"/></td>
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
            <table border="0">
                <tr> 
                    <td> IDregistro</td> 
                    <td> Fecha ingreso</td> 
                    <td> Fecha salida</td> 
                    <td> equipo</td> 
                    <td> descripcion</td> 
                </tr> 
                <%
                    while (rs.next()) {
                        int id = rs.getInt("idAeronave");
                        String fini = rs.getString("fechaIngreso");
                        String fsal = rs.getString("fechaSalida");
                        int equipo = rs.getInt("equipo");
                        String descripcion = rs.getString("descripcion");
                        // print the results
                        out.println("<tr>");
                        out.println("<td> " + id + "</td>");
                        out.println("<td> " + fini + "</td>");
                        out.println("<td> " + fsal + "</td>");
                        out.println("<td> " + equipo + "</td>");
                        out.println("<td> " + descripcion + "</td>");
                        out.println("</tr>");
                    }
                    st.close();
                %>    
            </table>  
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
