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
    private int idAeronave;
    private char[] nombre;

    public Aeronave(int idAeronave, char[] nombre) {
        this.idAeronave = idAeronave;
        this.nombre = nombre;
    }

    public int getIdAeronave() {
        return idAeronave;
    }

    public void setIdAeronave(int idAeronave) {
        this.idAeronave = idAeronave;
    }

    public char[] getNombre() {
        return nombre;
    }

    public void setNombre(char[] nombre) {
        this.nombre = nombre;
    }
    
    
}
