/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author 
 */
public class Empleado {
    private int idEmpleado;
    private int seccion;
    private int CantEquiReparados;
    private char[] Nombre;
    private String email;
    private String password;
    private char[] rol;

    public Empleado(int idEmpleado, int seccion, int CantEquiReparados, char[] Nombre, String email, String password, char[] rol) {
        this.idEmpleado = idEmpleado;
        this.seccion = seccion;
        this.CantEquiReparados = CantEquiReparados;
        this.Nombre = Nombre;
        this.email = email;
        this.password = password;
        this.rol = rol;
    }

    public int getIdEmpleado() {
        return idEmpleado;
    }

    public void setIdEmpleado(int idEmpleado) {
        this.idEmpleado = idEmpleado;
    }

    public int getSeccion() {
        return seccion;
    }

    public void setSeccion(int seccion) {
        this.seccion = seccion;
    }

    public int getCantEquiReparados() {
        return CantEquiReparados;
    }

    public void setCantEquiReparados(int CantEquiReparados) {
        this.CantEquiReparados = CantEquiReparados;
    }

    public char[] getNombre() {
        return Nombre;
    }

    public void setNombre(char[] Nombre) {
        this.Nombre = Nombre;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public char[] getRol() {
        return rol;
    }

    public void setRol(char[] rol) {
        this.rol = rol;
    }

}