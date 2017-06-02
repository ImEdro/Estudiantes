/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import BD.Dao;
import BD.Empleados;
import Modelo.Empleado;
import Modelo.Validador;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URISyntaxException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author
 */
public class Empleados2 extends HttpServlet {

    private Empleados e;

    public Empleados2() throws FileNotFoundException, URISyntaxException {
        e = new Empleados();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        HttpSession respuesta = request.getSession(true);
            int id = Integer.parseInt(request.getParameter("id"));
            int tipo = Integer.parseInt(request.getParameter("tipo"));
            if (tipo == 1) {
                Empleado e1 = e.buscar(id);
                if (e1 == null) {
                    request.setAttribute("Mensaje", "No se encontro ");
                    request.setAttribute("empleado", null);
                    request.setAttribute("r", null);
                } else {
                    request.setAttribute("Mensaje", null);
                    request.setAttribute("empleado", e1);
                }
                RequestDispatcher dispacher = request.getRequestDispatcher("BuscarEmpleado.jsp");
                dispacher.forward(request, response);
            } else if (tipo == 2) {
                boolean p = this.e.eliminar(id);
                if (p) {
                    request.setAttribute("Mensaje", "Se a eliminado correctamente ");
                } else {
                    request.setAttribute("Mensaje", "no se encontro ");
                }
                RequestDispatcher dispacher = request.getRequestDispatcher("EliminarEmpleado.jsp");
                dispacher.forward(request, response);
            } else if (tipo == 3) {
                char[] nombre = request.getParameter("nombre").trim().toCharArray();
                int sec = Integer.parseInt(request.getParameter("seccion"));
                int cant = Integer.parseInt(request.getParameter("cant"));
                char[] rol = request.getParameter("rol").trim().toCharArray();
                String nomu = request.getParameter("email");
                String cont = request.getParameter("password1");
                String confirm_password = request.getParameter("password2");
                Pattern p = Pattern.compile("^([0-9a-zA-Z]([_.w]*[0-9a-zA-Z])*@([0-9a-zA-Z][-w]*[0-9a-zA-Z].)+([a-zA-Z]{2,9}.)+[a-zA-Z]{2,3})$");
                Matcher m = p.matcher(nomu);
                Validador v = new Validador();
                Dao d = new Dao();
                if (nomu.isEmpty() || cont.isEmpty() || confirm_password.isEmpty() || nombre.length==0 || sec==0 || cant==0 || rol.length==0) {
                    respuesta.setAttribute("error", "Hay campos vacios");

                } else//No hay campos vacios, veo que la direccion de email sea válida
                {
                    if (m.find()) {
                        if (v.isUsernameOrPasswordValid(cont)) {
                            //Ahora verifico si la contraseña 1 y la contraseña 2 son iguales
                            if (cont.equals(confirm_password)) {
                                try {
                                    d.conectar();
                                    if (d.isEmailRegistered(nomu)) {
                                        respuesta.setAttribute("error", "Esta direccion de correo ya fue registrada");
                                    } else {
                                        //Legado a este punto significa que todo esta correcto, por lo tanto ingreso a la DB
                                        Empleado a = new Empleado(id, sec, cant, nombre, nomu, cont, rol);
                                        System.out.println(a);
                                        boolean n = this.e.agregar(a);
                                        if (n) {
                                            request.setAttribute("Mensaje", "Se agrego correctamente ");
                                        } else {
                                            request.setAttribute("Mensaje", "id repetido intente nuevamente ");
                                        }
                                        respuesta.setAttribute("error", null);
                                    }
                                    d.desconectar();
                                } catch (Exception i) {
                                }
                            } else {
                                respuesta.setAttribute("error", "Las contraseñas no son iguales");
                            }
                        } else {
                            respuesta.setAttribute("error", "Contraseña no es válida");
                        }
                    } else //La direccion de email si es correcta, verifico que la contraseña tambien lo sea
                    {
                        respuesta.setAttribute("error", "La direccion de email no es correcta");
                    }
                }
                RequestDispatcher dispacher = request.getRequestDispatcher("NuevoEmpleado2.jsp");
                dispacher.forward(request, response);
            } else {
                if (request.getParameter("nombre").length() != 0 && request.getParameter("email").length() != 0
                        && request.getParameter("password").length() != 0 && request.getParameter("rol").length() != 0) {
                    char[] nombre = request.getParameter("nombre").trim().toCharArray();
                    int sec = Integer.parseInt(request.getParameter("seccion"));
                    int cant = Integer.parseInt(request.getParameter("cant"));
                    String nomu = request.getParameter("email");
                    String cont = request.getParameter("password1");
                    char[] rol = request.getParameter("rol").trim().toCharArray();
                    Empleado p = new Empleado(id, sec, cant, nombre, nomu, cont, rol);
                    boolean n = this.e.actualizar(p);
                    if (n) {
                        request.setAttribute("Mensaje", "Se modifico correctamente ");
                    } else {
                        request.setAttribute("Mensaje", "no existe el registro con este id");
                    }
                } else {
                    request.setAttribute("Mensaje", "casillas incompletas intente nuevamente ");
                }
                RequestDispatcher dispacher = request.getRequestDispatcher("ActualizarEmpleado.jsp");
                dispacher.forward(request, response);
            }
        
    }
}
