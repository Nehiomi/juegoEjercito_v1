/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daw.ejercito;

/**
 *
 * @author naomi
 */
public class Arma {
    
    //Atributos
    private String nombre;
    private int danio;
    private Municion municion;
    
    //Método constructor por defecto
    public Arma() {
        this.nombre = "AK47";
        this.danio = 20;
        this.municion = new Municion();
    }
    
    //Método constructor parametrizado
    public Arma(String nombre, int danio, Municion municion) {
        this.nombre = nombre;
        this.danio = danio;
        this.municion = municion;
    }
    
    //Método constructor copia devolverá un clon del arma
    //IMPORTANTE PARA MAÑANA
    public Arma(Arma arma){
        this.danio = arma.danio;
        this.nombre = arma.nombre;
        this.municion = new Municion(arma.getMunicion()); //copia la clase munición
    }
    
    
    //Método que hace una copia de si misma
    public Arma copia() {
        Arma aux = new Arma(this.nombre, this.danio, this.municion);
        return aux;
    }
    
    //Métodos getters y setters
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getDanio() {
        return danio;
    }

    public void setDanio(int danio) {
        this.danio = danio;
    }

    public Municion getMunicion() {
        return municion;
    }

    public void setMunicion(Municion municion) {
        this.municion = municion;
    }
    
    //Método toString
    @Override
    public String toString() {
        return "Arma{" + "nombre=" + nombre + ", danio=" + danio + ", municion=" + municion + '}';
    }
}
