/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.util.Date;

/**
 *
 * @author 
 */
public class Registro {
    
    
    private int idRegistro;
    private Date fechaIngreso;
    private Date fechaSalida;
    private Equipo equipo;
    private char[] descripcion;
    private Aeronave aeronave;
    private Empleado EmpleadoTrabajo;
    private Empleado EmpleadoReceptor;

    public Registro(int idRegistro, Date fechaIngreso, Date fechaSalida, Equipo equipo, char[] descripcion, Aeronave aeronave, Empleado EmpleadoTrabajo, Empleado EmpleadoReceptor) {
        this.idRegistro = idRegistro;
        this.fechaIngreso = fechaIngreso;
        this.fechaSalida = fechaSalida;
        this.equipo = equipo;
        this.descripcion = descripcion;
        this.aeronave = aeronave;
        this.EmpleadoTrabajo = EmpleadoTrabajo;
        this.EmpleadoReceptor = EmpleadoReceptor;
    }

    public int getIdRegistro() {
        return idRegistro;
    }

    public void setIdRegistro(int idRegistro) {
        this.idRegistro = idRegistro;
    }

    public Date getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(Date fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    public Date getFechaSalida() {
        return fechaSalida;
    }

    public void setFechaSalida(Date fechaSalida) {
        this.fechaSalida = fechaSalida;
    }

    public Equipo getEquipo() {
        return equipo;
    }

    public void setEquipo(Equipo equipo) {
        this.equipo = equipo;
    }

    public char[] getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(char[] descripcion) {
        this.descripcion = descripcion;
    }

    public Aeronave getAeronave() {
        return aeronave;
    }

    public void setAeronave(Aeronave aeronave) {
        this.aeronave = aeronave;
    }

    public Empleado getEmpleadoTrabajo() {
        return EmpleadoTrabajo;
    }

    public void setEmpleadoTrabajo(Empleado EmpleadoTrabajo) {
        this.EmpleadoTrabajo = EmpleadoTrabajo;
    }

    public Empleado getEmpleadoReceptor() {
        return EmpleadoReceptor;
    }

    public void setEmpleadoReceptor(Empleado EmpleadoReceptor) {
        this.EmpleadoReceptor = EmpleadoReceptor;
    }
   
    
}
