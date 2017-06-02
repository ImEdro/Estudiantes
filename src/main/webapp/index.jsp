<%@taglib prefix="t" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Index</title>
        <meta charset="UTF-8">
        <link rel="stylesheet"  href="css/Index_style.css" type="text/css"><link>
        <link rel="stylesheet" type="text/css" href="css/estilos.css">
        <link href="https://fonts.googleapis.com/css?family=Pinyon+Script" rel="stylesheet">
        <script type="text/javascript">
            if (history.forward(1)) {
                location.replace(history.forward(1));
            }
        </script>
        <script src="jquery-1.11.3.min.js"></script>
    </head>
    <body background="fondo.png">
        Bienvenido ${sessionScope.usuario}
        <div style="width: 780px; position: relative; margin-left: auto; margin-right: auto;"> 
            <h1>Proyecto Bases De Datos</h1>
            <header>
                <li><a class="actual" href="Index.jsp">Inicio</a></li>
                <li class="accion"><a href="#">Aeronaves</a>
                    <div class="mostrar">
                        <a href="NuevoAeronave.jsp">Crear</a>
                        <a href="ListarAeronaves.jsp">Listar</a>
                        <a href="BuscarAeronave.jsp">Buscar</a>
                        <a href="EliminarAeronave.jsp">Eliminar</a>
                        <a href="ActualizarAeronave.jsp">Actualizar</a>
                    </div>
                </li>
                <li class="accion"><a href="#">Equipos</a>
                    <div class="mostrar">
                        <a href="NuevoEquipo.jsp">Crear</a>
                        <a href="ListarEquipos.jsp">Listar</a>
                        <a href="BuscarEquipo.jsp">Buscar</a>
                        <a href="BuscarEquipo.jsp">Ver historial</a>
                        <a href="EliminarEquipo.jsp">Eliminar</a>
                        <a href="ActualizarEquipo.jsp">Actualizar</a>
                    </div>
                </li>
                <li class="accion"><a href="#">Empleados</a>
                    <div class="mostrar">
                        <a href="NuevoEmpleado.jsp">Crear</a>
                        <a href="ListarEmpleados.jsp">Listar</a>
                        <a href="BuscarEmpleado.jsp">Buscar</a>
                        <a href="EliminarEmpleado.jsp">Eliminar</a>
                        <a href="ActualizarEmpleado.jsp">Actualizar</a>
                        <a href="EmpDisponible.jsp">Disponibilidad</a>
                        <a href="EditarDisponibilidad.jsp"> Editar Disponibilidad</a>
                    </div>
                </li>
                <li class="accion"><a href="#">Fabricantes</a>
                    <div class="mostrar">
                        <a href="NuevoFabricante.jsp">Crear</a>
                        <a href="ListarFabricantes.jsp">Listar</a>
                        <a href="BuscarFabricante.jsp">Buscar</a>
                        <a href="EliminarFabricante.jsp">Eliminar</a>
                        <a href="ActualizarFabricante.jsp">Actualizar</a>
                    </div>
                </li>
                <li class="accion"><a href="#">Registros</a>
                    <div class="mostrar">
                        <a href="NuevoRegistro.jsp">Crear</a>
                        <a href="ListarRegistros.jsp">Listar</a>
                        <a href="BuscarRegistro.jsp">Buscar</a>
                        <a href="BuscarRegistro2.jsp">Filtrar registros por fecha</a>
                        <a href="EliminarRegistro.jsp">Eliminar</a>
                        <a href="ActualizarRegistro.jsp">Actualizar</a>
                    </div>
                </li>
                <li class="accion"><a href="#">Cuenta</a>
                    <div class="mostrar">
                        <a href="#">Perfil</a>
                        <a href="#">Cambiar datos personales</a>
                        <a href="#">Cambiar Contraseña</a>
                        <a href="logout.jsp">Cerrar Sesión</a>
                    </div>
                </li>
            </header>
            <div id="contenedor-slider" class="contenedor-slider">
                <div id="slider" class="slider">
                    <section class="slider__section"><img src="http://welltechnically.com/wp-content/uploads/2013/08/android-wallpapers-700x300.jpg" class="slider__img"></section>
                    <section class="slider__section"><img src="http://pgembeddedsystems.org/images/vlsifront.png" class="slider__img"></section>
                    <section class="slider__section"><img src="http://welltechnically.com/wp-content/uploads/2013/09/android-widescreen-wallpaper-14165-hd-wallpapers-700x300.jpg" class="slider__img"></section>
                    <section class="slider__section"><img src="http://youghaltennisclub.ie/wp-content/uploads/2014/06/Tennis-Wallpaper-High-Definition-700x300.jpg" class="slider__img"></section>
                </div>
                <div id="btn-prev" class="btn-prev">&#60;</div>
                <div id="btn-next" class="btn-next">&#62;</div>
            </div>
            <script src="slider.js"></script>
        </div>
    </body>
</html>
