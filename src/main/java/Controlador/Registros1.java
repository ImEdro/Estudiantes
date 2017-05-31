/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import BD.Aeronaves;
import BD.Empleados;
import BD.Equipos;
import BD.Registros;
import Modelo.Aeronave;
import Modelo.Empleado;
import Modelo.Equipo;
import Modelo.Registro;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Date;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author
 */
public class Registros1 extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    private Registros e;

    public Registros1() throws FileNotFoundException {
        e = new Registros();
    }

     protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
            int tipo = Integer.parseInt(request.getParameter("tipo"));
            if (tipo == 0) {
                int dia=0,mes=0,ao=0;
                dia = Integer.parseInt(request.getParameter("dia"));
                mes = Integer.parseInt(request.getParameter("mes"));
                ao = Integer.parseInt(request.getParameter("ao"));
                Date d = new Date(ao, mes, dia);
                request.setAttribute("fecha", "" + d.getYear() + "-" + d.getMonth() + "-" + d.getDate());
                RequestDispatcher dispacher = request.getRequestDispatcher("BuscarRegistro2.jsp");
                dispacher.forward(request, response);
            } else if (tipo == 1) {
                int id = Integer.parseInt(request.getParameter("id"));
                Registro e1 = e.buscar(id);
                if (e1 == null) {
                    request.setAttribute("Mensaje", "No se encontro ");
                    request.setAttribute("r", null);
                } else {
                    request.setAttribute("Mensaje", null);
                    request.setAttribute("r", e1);
                }
                RequestDispatcher dispacher = request.getRequestDispatcher("BuscarRegistro.jsp");
                dispacher.forward(request, response);
            } else if (tipo == 2) {
                int id = Integer.parseInt(request.getParameter("id"));
                boolean p = this.e.eliminar(id);
                if (p) {
                    request.setAttribute("Mensaje", "Se a eliminado correctamente ");
                } else {
                    request.setAttribute("Mensaje", "no se encontro ");
                }
                RequestDispatcher dispacher = request.getRequestDispatcher("EliminarRegistro.jsp");
                dispacher.forward(request, response);
            } else if (tipo == 3) {
                int id = Integer.parseInt(request.getParameter("id"));
                int h = Integer.parseInt(request.getParameter("corr"));
                if (request.getParameter("nombre").length() != 0 && h >= 1 && h <= 2) {
                    char[] nombre = request.getParameter("nombre").trim().toCharArray();
                    int diai = Integer.parseInt(request.getParameter("diai"));
                    int mesi = Integer.parseInt(request.getParameter("mesi"));
                    int aoi = Integer.parseInt(request.getParameter("aoi"));
                    int diaf = Integer.parseInt(request.getParameter("diaf"));
                    int mesf = Integer.parseInt(request.getParameter("mesf"));
                    int aof = Integer.parseInt(request.getParameter("aof"));
                    Date fechaIngreso = new Date(aoi, mesi, diai), fechaSalida = new Date(aof, mesf, diaf);
                    int idequipo = Integer.parseInt(request.getParameter("equipo"));
                    int idaero = Integer.parseInt(request.getParameter("aeronave"));
                    int idempt = Integer.parseInt(request.getParameter("empt"));
                    int idempr = Integer.parseInt(request.getParameter("empr"));
                    Equipo equip = new Equipos().buscar(idequipo);
                    Aeronave a = new Aeronaves().buscar(idaero);
                    Empleado et = new Empleados().buscar(idempt);
                    Empleado er = new Empleados().buscar(idempr);
                    String t1 = "";

                    if (h == 1) {
                        t1 = "correctivo";
                    } else if (h == 2) {
                        t1 = "preventivo";
                    }
                    char[] t = t1.trim().toCharArray();
                    if (equip != null && a != null && et != null && er != null) {
                        Registro p = new Registro(id, fechaIngreso, fechaSalida, equip, nombre, a, et, er);
                        boolean n = this.e.agregar(p);
                        if (n) {
                            request.setAttribute("Mensaje", "Se agrego correctamente ");
                        } else {
                            request.setAttribute("Mensaje", "id repetido intente nuevamente ");
                        }
                    } else {
                        request.setAttribute("Mensaje", "error no existe alguna id ");
                    }
                } else {
                    request.setAttribute("Mensaje", "casillas incompletas intente nuevamente ");
                }
                RequestDispatcher dispacher = request.getRequestDispatcher("NuevoRegistro.jsp");
                dispacher.forward(request, response);
            } else {
                int id = Integer.parseInt(request.getParameter("id"));
                int h = Integer.parseInt(request.getParameter("corr"));
                if (request.getParameter("nombre").length() != 0 && h >= 1 && h <= 2) {
                    char[] nombre = request.getParameter("nombre").trim().toCharArray();
                    int diai = Integer.parseInt(request.getParameter("diai"));
                    int mesi = Integer.parseInt(request.getParameter("mesi"));
                    int aoi = Integer.parseInt(request.getParameter("aoi"));
                    int diaf = Integer.parseInt(request.getParameter("diaf"));
                    int mesf = Integer.parseInt(request.getParameter("mesf"));
                    int aof = Integer.parseInt(request.getParameter("aof"));
                    Date fechaIngreso = new Date(aoi, mesi, diai), fechaSalida = new Date(aof, mesf, diaf);
                    int idequipo = Integer.parseInt(request.getParameter("equipo"));
                    int idaero = Integer.parseInt(request.getParameter("aeronave"));
                    int idempt = Integer.parseInt(request.getParameter("empt"));
                    int idempr = Integer.parseInt(request.getParameter("empr"));
                    Equipo equip = new Equipos().buscar(idequipo);
                    Aeronave a = new Aeronaves().buscar(idaero);
                    Empleado et = new Empleados().buscar(idempt);
                    Empleado er = new Empleados().buscar(idempr);
                    String t1 = "";

                    if (h == 1) {
                        t1 = "correctivo";
                    } else if (h == 2) {
                        t1 = "preventivo";
                    }
                    char[] t = t1.trim().toCharArray();
                    if (equip != null && a != null && et != null && er != null) {
                        Registro p = new Registro(id, fechaIngreso, fechaSalida, equip, nombre, a, et, er);
                        boolean n = this.e.actualizar(p);
                        if (n) {
                            request.setAttribute("Mensaje", "Se modifico correctamente ");
                        } else {
                            request.setAttribute("Mensaje", "no existe el registro con este id");
                        }
                    } else {
                        request.setAttribute("Mensaje", "error no existe alguna id ");
                    }
                } else {
                    request.setAttribute("Mensaje", "casillas incompletas intente nuevamente ");
                }
                RequestDispatcher dispacher = request.getRequestDispatcher("ActualizarRegistro.jsp");
                dispacher.forward(request, response);
            }
        
    }

}
