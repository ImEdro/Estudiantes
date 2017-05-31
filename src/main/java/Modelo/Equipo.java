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
public class Equipo {
    
    private Integer numSerie;
    private Integer numParte;
    private char[] nombre;
    private Fabricante Fabricante;
    private Aeronave Aeronave;

    public Equipo(Integer numSerie, Integer numParte, char[] nombre, Fabricante Fabricante, Aeronave Aeronave) {
        this.numSerie = numSerie;
        this.numParte = numParte;
        this.nombre = nombre;
        this.Fabricante = Fabricante;
        this.Aeronave = Aeronave;
    }

    public Integer getNumSerie() {
        return numSerie;
    }

    public void setNumSerie(Integer numSerie) {
        this.numSerie = numSerie;
    }

    public Integer getNumParte() {
        return numParte;
    }

    public void setNumParte(Integer numParte) {
        this.numParte = numParte;
    }

    public char[] getNombre() {
        return nombre;
    }

    public void setNombre(char[] nombre) {
        this.nombre = nombre;
    }

    public Fabricante getFabricante() {
        return Fabricante;
    }

    public void setFabricante(Fabricante Fabricante) {
        this.Fabricante = Fabricante;
    }

    public Aeronave getAeronave() {
        return Aeronave;
    }

    public void setAeronave(Aeronave Aeronave) {
        this.Aeronave = Aeronave;
    }

   
   
}
