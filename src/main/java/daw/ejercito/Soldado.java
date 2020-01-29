/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daw.ejercito;

import java.util.Random;

/**
 *
 * @author naomi
 */
public class Soldado {

    //Atributos
    private String id;
    private int vida;
    private boolean armadura;
    private static int turno  = 0;
    //Contador de instancias
    private static int contador = 0;

    //Método constructor por defecto
    public Soldado() {
        this.id = "S111";
        this.vida = 100;
        this.armadura = true;
        contador++;
    }

    //Método constructor parametrizado
    public Soldado(String id, int vida, boolean armadura) {
        this.id = id;
        this.vida = vida;
        this.armadura = armadura;
        contador++;
    }

    //Método constructor copia devolverá un clon del soldado
    public Soldado(Soldado copia){
        this.id = copia.id;
        this.vida = copia.vida;
        this.armadura = copia.armadura;
        contador++; //contador de instancias que cuenta cada vez que se crea un soldado nuevo
    }
    
    //Método que copia el soldado que le pasamos
    public Soldado copia(Soldado copia) {
        //Aquí no debemos pasar el contador sólo sepone en el constructor
       return new Soldado(copia.id, copia.vida, copia.armadura);
    }

    //Método atacar(Arma, Soldado). Ataca al soldado con el arma seleccionada
    public void atacar(Arma usada, Soldado elegido) {

        if (elegido.vida - usada.getDanio() <= 0) {
            elegido.vida = 0;
        } else {
            elegido.vida -= usada.getDanio();
        }
    }

    //Método atacar(Arma, Medico). Ataca al médico con el arma seleccionada
    public void atacar(Arma usada, Medico elegido) {

        if (elegido.getVida() - usada.getDanio() <= 0) {
            elegido.setVida(0);
        } else {
            elegido.setVida(elegido.getVida() - usada.getDanio());
        }
    }
    
    public static int tirada() {
        Random aleatorio = new Random();
        int opcion;
        return opcion = aleatorio.nextInt(4) + 1;
    }

    //Método de clase que devuelve un boolean para controlar el turno de los jugadores
    public static boolean turno() {
        if (turno % 2 == 0) {
            turno++;
            return true;
        } else {
            turno++;
            return false;
        }
    }

    //Métodos getters y setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getVida() {
        return vida;
    }

    public void setVida(int vida) {
        this.vida = vida;
    }

    public boolean getArmadura() {
        return armadura;
    }

    public void setArmadura(boolean armadura) {
        this.armadura = armadura;
    }

    //Método toString
    @Override
    public String toString() {
        return "Soldado{" + "id=" + id + ", vida=" + vida + ", armadura=" + armadura + '}';
    }
}
