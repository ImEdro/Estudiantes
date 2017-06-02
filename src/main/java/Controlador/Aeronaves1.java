/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import BD.Aeronaves;
import BD.Empleados;
import Modelo.Aeronave;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URISyntaxException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author
 */
public class Aeronaves1 extends HttpServlet {

    private Aeronaves c;

    public Aeronaves1() throws FileNotFoundException, URISyntaxException {
        c = new Aeronaves();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        int id = Integer.parseInt(request.getParameter("id"));
        int tipo = Integer.parseInt(request.getParameter("tipo"));
        if (tipo == 1) {
            Aeronave e1 = c.buscar(id);
            if (e1 == null) {
                request.setAttribute("Mensaje", "No se encontro ");
            } else {
                request.setAttribute("Mensaje", "Nombre: " + String.copyValueOf(e1.getNombre()));
            }
            RequestDispatcher dispacher = request.getRequestDispatcher("BuscarAeronave.jsp");
            dispacher.forward(request, response);
        } else if (tipo == 2) {
            boolean p = this.c.eliminar(id);
            if (p) {
                request.setAttribute("Mensaje", "Se a eliminado correctamente ");
            } else {
                request.setAttribute("Mensaje", "no se encontro ");
            }
            RequestDispatcher dispacher = request.getRequestDispatcher("EliminarAeronave.jsp");
            dispacher.forward(request, response);
        } else if (tipo == 3) {
            if (request.getParameter("nombre").length() != 0) {
                char[] nombre = request.getParameter("nombre").trim().toCharArray();
                Aeronave p = new Aeronave(id, nombre);
                boolean n = this.c.agregar(p);
                if (n) {
                    request.setAttribute("Mensaje", "Se agrego correctamente ");
                } else {
                    request.setAttribute("Mensaje", "id repetido intente nuevamente ");
                }
            } else {
                request.setAttribute("Mensaje", "casillas incompletas intente nuevamente ");
            }
            RequestDispatcher dispacher = request.getRequestDispatcher("NuevoAeronave.jsp");
            dispacher.forward(request, response);
        } else {
            if (request.getParameter("nombre").length() != 0) {
                char[] nombre = request.getParameter("nombre").trim().toCharArray();
                Aeronave p = new Aeronave(id, nombre);
                boolean n = this.c.actualizar(p);
                if (n) {
                    request.setAttribute("Mensaje", "Se modifico correctamente ");
                } else {
                    request.setAttribute("Mensaje", "no existe el registro con este id");
                }
            } else {
                request.setAttribute("Mensaje", "casillas incompletas intente nuevamente ");
            }
            RequestDispatcher dispacher = request.getRequestDispatcher("ActualizarAeronave.jsp");
            dispacher.forward(request, response);
        }

    }

}
