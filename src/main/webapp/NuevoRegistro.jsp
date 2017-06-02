<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="https://fonts.googleapis.com/css?family=Pinyon+Script" rel="stylesheet">
        <link rel="stylesheet" type="text/css" href="css\Opciones_style.css">
        <title>Nuevo Registro</title>
    </head>
    <body background="fondo.png">
        <form  action="Registros1">
            <h1>Nuevo Registro</h1>
            <table>
                <tr>
                    <td>id:</td>      
                    <td><input type="number" name="id" size="3" placeholder="Ingrese el id"/></td> 
                </tr>
                <tr>
                    <td>dia ingreso:</td>  
                    <td><input type="number" name="diai" size="3" placeholder="Ingrese dia de ingreso"/></td> 
                </tr>
                <tr>
                    <td>mes ingreso:</td>  
                    <td><input type="number" name="mesi" size="3" placeholder="Ingrese mes de ingreso"/></td> 
                </tr> 
                <tr>
                    <td>año ingreso:</td>  
                    <td><input type="number" name="añoi" size="3" placeholder="Ingrese año de ingreso"/></td> 
                </tr> 
                <tr>
                    <td>dia salida:</td>  
                    <td><input type="number" name="diaf" size="3" placeholder="Ingrese dia de salida"/></td> 
                </tr>
                <tr>
                    <td>mes salida:</td>   
                    <td><input type="number" name="mesf" size="3" placeholder="Ingrese mes de salida"/></td> 
                </tr>
                <tr>
                    <td>año salida:</td>   
                    <td><input type="number" name="añof" size="3" placeholder="Ingrese año de salida"/></td> 
                </tr> 
                <tr>
                    <td>descripcion:</td>  
                    <td><input type="text" name="nombre" size="20" placeholder="Ingrese la descripcion"/></td>
                </tr>
                <tr>
                    <td>id equipo:</td>  
                    <td><input type="number" name="equipo" size="3" placeholder="Ingrese el id del equipo"/></td>
                </tr>
                <tr>
                    <td>id aeronave:</td>
                    <td><input type="number" name="aeronave" size="3" placeholder="Ingrese el id de la aeronave"/></td>
                </tr> 
                <tr> 
                    <td>id empleado que le trabajo:</td>  
                    <td><input type="number" name="empt" size="3" placeholder="Ingrese el id del empleado que le trabaja"/></td>
                </tr>  
                <tr>
                    <td>id empleado que recibe:</td>  
                    <td><input type="number" name="empr" size="3" placeholder="Ingrese el id del empleado que lo recibe"/></td>
                </tr>
                <tr>
                    <td><input type="submit" id="submit" name="Crear" value="Crear"></td>
                    <td><input type="button" id="button" onClick="window.location.href = 'index.jsp'" name="regresar" value="Regresar"> </td>
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
