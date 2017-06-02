/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import BD.Fabricantes;
import Modelo.Fabricante;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URISyntaxException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author
 */
public class Fabricantes1 extends HttpServlet {

   
    private Fabricantes f;

    public Fabricantes1() throws FileNotFoundException, URISyntaxException {
        f = new Fabricantes();
    }

     protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
            int id = Integer.parseInt(request.getParameter("id"));
            int tipo = Integer.parseInt(request.getParameter("tipo"));
            if (tipo == 1) {
                Fabricante e = f.buscar(id);
                if (e == null) {
                    request.setAttribute("Mensaje", "No se encontro ");
                    request.setAttribute("fabricante", null);
                } else {
                    request.setAttribute("Mensaje", null);
                    request.setAttribute("fabricante", e);
                }
                RequestDispatcher dispacher = request.getRequestDispatcher("BuscarFabricante.jsp");
                dispacher.forward(request, response);
            } else if (tipo == 2) {
                boolean p = this.f.eliminar(id);
                if (p) {
                    request.setAttribute("Mensaje", "Se a eliminado correctamente ");
                } else {
                    request.setAttribute("Mensaje", "no se encontro ");
                }
                RequestDispatcher dispacher = request.getRequestDispatcher("EliminarFabricante.jsp");
                dispacher.forward(request, response);
            } else if (tipo == 3) {
                if (request.getParameter("nombre").length() != 0) {
                    char[] nombre = request.getParameter("nombre").trim().toCharArray();

                    Fabricante p = new Fabricante(id, nombre);
                    boolean n = this.f.agregar(p);
                    if (n) {
                        request.setAttribute("Mensaje", "Se agrego correctamente ");
                    } else {
                        request.setAttribute("Mensaje", "id repetido intente nuevamente ");
                    }
                } else {
                    request.setAttribute("Mensaje", "casillas incompletas intente nuevamente ");
                }
                RequestDispatcher dispacher = request.getRequestDispatcher("NuevoFabricante.jsp");
                dispacher.forward(request, response);
            }else{
                 if (request.getParameter("nombre").length() != 0) {
                    char[] nombre = request.getParameter("nombre").trim().toCharArray();
                    Fabricante p = new Fabricante(id, nombre);
                    boolean n = this.f.actualizar(p);
                   if (n) {
                        request.setAttribute("Mensaje", "Se modifico correctamente ");
                    } else {
                        request.setAttribute("Mensaje", "no existe el registro con este id");
                    }
                } else {
                    request.setAttribute("Mensaje", "casillas incompletas intente nuevamente ");
                }
                RequestDispatcher dispacher = request.getRequestDispatcher("ActualizarFabricante.jsp");
                dispacher.forward(request, response);
            }
    }

}
