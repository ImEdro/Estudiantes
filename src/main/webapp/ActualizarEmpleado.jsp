<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="https://fonts.googleapis.com/css?family=Pinyon+Script" rel="stylesheet">
        <link rel="stylesheet" type="text/css" href="css\Opciones_style.css">
        <title>Actualizar Empleado</title>
    </head>
    <body background="fondo.png">
        <form action="Empleados1">
            <h1>Actualizar Empleado</h1>
            <table>
                <tr>
                    <td>id:</td>     
                    <td><input type="number" name="id" size="2" placeholder="Ingrese el id"/> </td>
                </tr>
                <tr>
                    <td>Nombre: </td>  
                    <td><input type="text" name="nombre" size="20" placeholder="Ingrese el nombre"/>  </td>
                <tr>
                    <td>seccion: </td>    
                    <td><input type="number" name="seccion" size="3" placeholder="Ingrese la sección"/> </td>
                </tr>
                <tr>
                    <td> num equipos reparados: </td>    
                    <td> <input type="number" name="cant" size="3" placeholder="Ingrese el N° de equipos reparados"/></td>
                </tr>
                <tr>
                    <td>email: </td>    
                    <td><input type="text" name="email" size="20" placeholder="Ingrese su email"/> </td>
                </tr>
                <tr>
                    <td>contraseña: </td>    
                    <td><input type="password" name="password1" size="20" placeholder="Ingrese la contraseña"/> </td>
                </tr>
                <tr>
                    <td>Confirmar contraseña: </td>    
                    <td><input type="password" name="password2" size="20" placeholder="Ingrese la contraseña nuevamente"/> </td>
                </tr>
                <tr>
                    <td>rol: </td>    
                    <td><input type="text" name="rol" size="20" placeholder="Ingrese el rol"/> </td>
                </tr>
                <tr>
                    <td><input type="submit" id="submit" name="Actualizar" value="Actualiar"></td>
                    <td><input type="button" id="button" onClick="window.location.href = 'index.html'" name="regresar" value="Regresar"> </td>
                </tr>
                <input type="hidden" name="tipo" value="3">
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
