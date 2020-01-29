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
public class Medico {

    //Atributos
    private String id;
    private int vida;
    private int cura;

    //Método constructor por defecto
    public Medico() {
        this.id = "M987";
        this.vida = 100;
        this.cura = 100;
    }

    //Método constructor parametrizado
    public Medico(String id, int vida, int cura) {
        this.id = id;
        this.vida = vida;
        this.cura = cura;
    }

    //Método constructor copia devolverá un clon del médico
    public Medico copia() {
        Medico aux = new Medico(this.id, this.vida, this.cura);
        return aux;
    }

    //Método sanar(Soldado). Carga de vida al soldado.
    public void sanar(Soldado elegido, Medico cura) {
        if (elegido.getVida() >= 100) {
            elegido.setVida(100);
        } else {
            elegido.setVida(elegido.getVida() + cura.getCura());
            cura.setCura(cura.getCura() - 10);
        }
    }

    //Método sanar(Medico). Carga de vida al médico.
    public void sanar(Medico elegido, Medico cura) {
        if (elegido.getVida() >= 100) {
            elegido.setVida(100);
        } else {
            elegido.setVida(elegido.getVida() + cura.getCura());
            cura.setCura(cura.getCura() - 10);
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

    public int getCura() {
        return cura;
    }

    public void setCura(int cura) {
        this.cura = cura;
    }

    //Método toString
    @Override
    public String toString() {
        return "Medico{" + "id=" + id + ", vida=" + vida + ", cura=" + cura + '}';
    }
}
