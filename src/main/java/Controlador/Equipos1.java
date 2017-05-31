/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import BD.Aeronaves;
import BD.Equipos;
import BD.Fabricantes;
import BD.Registros;
import Modelo.Aeronave;
import Modelo.Equipo;
import Modelo.Fabricante;
import Modelo.Registro;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author
 */
public class Equipos1 extends HttpServlet {

    private Equipos e;

    public Equipos1() throws FileNotFoundException {
        e = new Equipos();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
       
            int id = Integer.parseInt(request.getParameter("id"));
            int tipo = Integer.parseInt(request.getParameter("tipo"));
            if (tipo == 1) {
                Equipo e1 = e.buscar(id);
                if (e == null) {
                    request.setAttribute("Mensaje", "No se encontro ");
                    request.setAttribute("equipo", null);
                } else {
                    request.setAttribute("Mensaje", " ");
                    request.setAttribute("equipo", e1);
                }
                RequestDispatcher dispacher = request.getRequestDispatcher("BuscarEquipo.jsp");
                dispacher.forward(request, response);
            } else if (tipo == 2) {
                boolean p = this.e.eliminar(id);
                if (p) {
                    request.setAttribute("Mensaje", "Se a eliminado correctamente ");
                } else {
                    request.setAttribute("Mensaje", "no se encontro ");
                }
                RequestDispatcher dispacher = request.getRequestDispatcher("EliminarEquipo.jsp");
                dispacher.forward(request, response);
            } else if (tipo == 3) {
                if (request.getParameter("nombre").length() != 0) {
                    char[] nombre = request.getParameter("nombre").trim().toCharArray();
                    int parte = Integer.parseInt(request.getParameter("parte"));
                    int idfab = Integer.parseInt(request.getParameter("fabricante"));
                    int idae = Integer.parseInt(request.getParameter("aeronave"));
                    Fabricante f = new Fabricantes().buscar(idfab);
                    Aeronave a = new Aeronaves().buscar(idae);
                    if (f != null && a != null) {
                        Equipo p = new Equipo(id, parte, nombre, f, a);
                        boolean n = this.e.agregar(p);
                        if (n) {
                            request.setAttribute("Mensaje", "Se agrego correctamente ");
                        } else {
                            request.setAttribute("Mensaje", "id repetido intente nuevamente ");
                        }
                    } else {
                        request.setAttribute("Mensaje", "id de fabricante o aeronave no se encontro ");
                    }
                } else {
                    request.setAttribute("Mensaje", "casillas incompletas intente nuevamente ");
                }
                RequestDispatcher dispacher = request.getRequestDispatcher("NuevoEquipo.jsp");
                dispacher.forward(request, response);
            } else {
                if (request.getParameter("nombre").length() != 0) {
                    char[] nombre = request.getParameter("nombre").trim().toCharArray();
                    int parte = Integer.parseInt(request.getParameter("parte"));
                    int idfab = Integer.parseInt(request.getParameter("fabricante"));
                    int idae = Integer.parseInt(request.getParameter("aeronave"));
                    Fabricante f = new Fabricantes().buscar(idfab);
                    Aeronave a = new Aeronaves().buscar(idae);
                    if (f != null && a != null) {
                        Equipo p = new Equipo(id, parte, nombre, f, a);
                        boolean n = this.e.agregar(p);
                        if (n) {
                            request.setAttribute("Mensaje", "Se modifico correctamente ");
                        } else {
                            request.setAttribute("Mensaje", "no existe el registro con este id");
                        }
                    } else {
                        request.setAttribute("Mensaje", "id de fabricante o aeronave no se encontro ");
                    }
                } else {
                    request.setAttribute("Mensaje", "casillas incompletas intente nuevamente ");
                }
                RequestDispatcher dispacher = request.getRequestDispatcher("ActualizarEquipo.jsp");
                dispacher.forward(request, response);
            }
        
    }

}
