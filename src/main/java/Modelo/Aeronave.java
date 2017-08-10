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
public class Aeronave {
    
    private char[] nombre;
    private char[] apellido;
    private int telefono;
    private int celular;

    public Aeronave(int telefono, char[] nombre) {
        this.telefono = telefono;
        this.nombre = nombre;
    }

    public int getIdAeronave() {
        return telefono;
    }

    public void setIdAeronave(int telefono) {
        this.telefono = telefono;
    }

    public Aeronave(char[] nombre, char[] apellido, int telefono, int celular) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.telefono = telefono;
        this.celular = celular;
    }

    public char[] getApellido() {
        return apellido;
    }

    public void setApellido(char[] apellido) {
        this.apellido = apellido;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public int getCelular() {
        return celular;
    }

    public void setCelular(int celular) {
        this.celular = celular;
    }

    public char[] getNombre() {
        return nombre;
    }

    public void setNombre(char[] nombre) {
        this.nombre = nombre;
    }
    
    
}
