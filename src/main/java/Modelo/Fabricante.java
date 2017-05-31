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
public class Fabricante {
    private int idFabricante;
    private char[] Nombre;

    public Fabricante(int idFabricante, char[] Nombre) {
        this.idFabricante = idFabricante;
        this.Nombre = Nombre;
    }

    public int getIdFabricante() {
        return idFabricante;
    }

    public void setIdFabricante(int idFabricante) {
        this.idFabricante = idFabricante;
    }

    public char[] getNombre() {
        return Nombre;
    }

    public void setNombre(char[] Nombre) {
        this.Nombre = Nombre;
    }
    
    
}
