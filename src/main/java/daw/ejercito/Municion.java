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
public class Municion {

    //Atributos
    private String nombre;
    private String tipo;
    private int numBalas;

    //Método constructor por defecto
    public Municion() {
        this.nombre = "MBalaZP9";
        this.tipo = "rifle";
        this.numBalas = 3;
    }
    
    //Método constructor parametrizado
    public Municion(String nombre, String tipo) {
        this.nombre = nombre;
        this.tipo = tipo;
        this.numBalas = 3; //El número de balas siempre será 3
    }
    
    //Método constructor copia devolverá un clon de la munición
    //No es un constructor copia, es un método que se copia a si mismo
    public Municion copia() {
        Municion aux = new Municion(this.nombre, this.tipo);
        return aux;
    }
    
    //Método constructor copia -- En el constructor tengo que inicializar los atributos this siempre
    public Municion(Municion a){
        this.nombre = a.nombre;
        this.tipo = a.tipo;
        this.numBalas = 3;
    }
    
    //No es un constructor copia es un método que crea una copia del objeto que le pasamos
    //Debe ser estático porque no depende de ningún objeto
    public static Municion copia(Municion a){
        return new Municion(a.nombre, a.tipo);
    }
    
    //Métodos getters y setters
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public int getNumBalas() {
        return numBalas;
    }

    public void setNumBalas(int numBalas) {
        this.numBalas = numBalas;
    }
    
    //Método toString
    @Override
    public String toString() {
        return "Municion{" + "nombre=" + nombre + ", tipo=" + tipo + ", numBalas=" + numBalas + '}';
    }
}
