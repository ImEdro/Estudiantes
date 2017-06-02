<%@taglib prefix="t" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%-- En caso de que exista una sesion iniciada redirecciono a index.jsp. "NO tiene caso mostrar este formulario cuando hay una sesion iniciada --%>
<t:if test="${sessionScope['sessionEmail']!=null}">
    <% response.sendRedirect("index.jsp");%>
</t:if>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="css\Opciones_style.css">
        <link href="https://fonts.googleapis.com/css?family=Pinyon+Script" rel="stylesheet">
        <script type="text/javascript">
            if (history.forward(1)) {
                location.replace(history.forward(1));
            }
        </script>
        <title>Iniciar sesión</title>
    </head>
    <body background="fondo.png">
        <p style="color: #ff0000">${sessionScope['error']}</p>
        <form action="Login" method="post">
            <h1>Iniciar sesión</h1>
            <table>
                <tr>
                    <td>Email:</td> 
                    <td><input type="text" name="email" placeholder="ingrese su email"></td>
                </tr>
                <tr>
                    <td>Contraseña: </td>
                    <td><input type="password" name="password" placeholder="ingrese su contraseña"></td>
                </tr>
                <tr>
                    <td><input type="submit" id="button" value="Iniciar Sesión"></td>
                    <td><input type="button" id="button" onClick="window.location.href = 'NuevoEmpleado2.jsp'" name="registrare" value="Registrarse"></td>
                </tr>
            </table>
        </form>
    </body>
</html>