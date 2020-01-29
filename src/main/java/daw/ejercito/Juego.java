/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daw.ejercito;

import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author naomi
 */
public class Juego {

    public static void main(String[] args) {

        System.out.println("[Juegos del Cord]");
        System.out.println("Acabas de aterrizar en territorio enemigo con una misión bien clara."
                + "\nDejar la zona hóstil libre para que el resto del ejercito pueda acceder sin problemas y formar una base en la zona.");

        //Soldado:
        Soldado soldado = new Soldado("R2312", 100, true);
        Municion municion = new Municion("45-80-500", "calibre 45");
        Arma arma = new Arma("AK-47", 10, municion);
        Medico medico = new Medico("RM2322", 100, 10);

        //Enemigo:
        Soldado enemigo = new Soldado("E5512", 100, true);
        Municion municionEne = new Municion("Browning M1917", "30-06");
        Arma armaEne = new Arma("Metralleta", 10, municionEne);
        Medico medicoEnemigo = new Medico("EM5522", 100, 10);

        //do { //Do-while para comprobar que tanto el soldado como el enemigo pueden ganar
        do {
            //Turno del soldado
            if (Soldado.turno()) {
                System.out.println("-----------------");
                System.out.println("TURNO DEL SOLDADO");
                switch (Soldado.tirada()) {
                    case 1:
                        //Disparar al enemigo
                        if (enemigo.getArmadura() == true) {
                            System.out.println("El enemigo ha recibido un disparo pero su armadura lo ha protegido.");
                            enemigo.setArmadura(false);
                        } else if (enemigo.getVida() > 0) {
                            soldado.atacar(arma, enemigo);
                            System.out.println("El enemigo ha recibido un disparo. Su nivel de vida es " + enemigo.getVida());
                        } else {
                            System.out.println("El enemigo ha recibido un tiro mortal.");
                        }
                        break;
                    case 2:
                        //Disparar al médico enemigo
                        if (arma.getMunicion().getNumBalas() > 0) {
                            soldado.atacar(arma, medicoEnemigo);
                            System.out.println("El médico del enemigo ha recibido un disparo. Su nivel de vida es " + medicoEnemigo.getVida());
                        } else {
                            System.out.println("Munición: " + arma.getMunicion().getNumBalas() + ". El soldado se ha quedado sin munición. No puede disparar.");
                        }
                        break;
                    case 3:
                        //Sanar al soldado
                        if (medico.getVida() > 0 && medico.getCura() > 0 && soldado.getVida() != 100) {
                            medico.sanar(soldado, medico);
                            System.out.println("El médico del soldado acaba de sanar al soldado. Su nivel de vida actual es " + soldado.getVida());
                        } else if (soldado.getVida() == 100) {
                            System.out.println("El soldado no necesita cura porque su nivel de vida está completo.");
                        } else {
                            if (medico.getVida() <= 0) {
                                System.out.println("El médico del soldado no puede realizar la cura al soldado.\nNivel de vida: " + medico.getVida());
                            } else {
                                System.out.println("Nivel de cura: " + medico.getCura() + ". La cura se ha agotado. El médico del soldado no puede sanar al soldado. ");
                            }
                        }
                        break;
                    case 4:
                        //Sanar al médico
                        if (medico.getVida() > 0 && medico.getCura() > 0 && medico.getVida() != 100) {
                            medico.sanar(medico, medico);
                            System.out.println("El médico del soldado acaba de sanarse. Su nivel de vida actual es " + medico.getVida());
                        } else if (medico.getVida() == 100) {
                            System.out.println("El médico del soldado no necesita cura porque su nivel de vida está completo.");
                        } else {
                            if (medico.getVida() <= 0) {
                                System.out.println("El médico del soldado no puede realizarse la cura.\nNivel de vida: " + medico.getVida());
                            } else {
                                System.out.println("Nivel de cura: " + medico.getCura() + ". La cura se ha agotado. El médico del soldado no puede sanarse. ");
                            }
                        }
                        break;
                }

                //Turno del enemigo
            } else {
                System.out.println("-----------------");
                System.out.println("TURNO DEL ENEMIGO");
                switch (Soldado.tirada()) {
                    case 1:
                        //Disparar al soldado
                        if (soldado.getArmadura() == true) {
                            System.out.println("El soldado ha recibido un disparo pero su armadura lo ha protegido.");
                            soldado.setArmadura(false);
                        } else if (soldado.getVida() > 0) {
                            enemigo.atacar(armaEne, soldado);
                            System.out.println("El soldado ha recibido un disparo. Su nivel de vida es " + soldado.getVida());
                        } else {
                            System.out.println("El soldado ha recibido un tiro mortal.");
                        }
                        break;
                    case 2:
                        //Disparar al médico
                        if (armaEne.getMunicion().getNumBalas() > 0) {
                            enemigo.atacar(armaEne, medico);
                            System.out.println("El médico del soldado ha recibido un disparo. Su nivel de vida es " + medico.getVida());
                        } else {
                            System.out.println("Munición: " + armaEne.getMunicion().getNumBalas() + ". El enemigo se ha quedado sin munición. No te puede disparar.");
                        }
                        break;
                    case 3:
                        //Sanar al enemigo
                        if (medicoEnemigo.getVida() > 0 && medicoEnemigo.getCura() > 0 && enemigo.getVida() != 100) {
                            medicoEnemigo.sanar(soldado, medicoEnemigo);
                            System.out.println("El médico enemigo acaba de sanar al enemigo. Su nivel de vida actual es " + medicoEnemigo.getVida());
                        } else if (enemigo.getVida() == 100) {
                            System.out.println("El enemigo no necesita cura porque su nivel de vida está completo.");
                        } else {
                            if (medicoEnemigo.getVida() <= 0) {
                                System.out.println("El médico del enemigo no puede realizar la cura.\nNivel de vida: " + medicoEnemigo.getVida());
                            } else {
                                System.out.println("Nivel de cura: " + medicoEnemigo.getCura() + ". La cura se ha agotado. El médico del enemigo no puede realizar la cura.");
                            }
                        }
                        break;
                    case 4:
                        //Sanar al médico enemigo
                        if (medicoEnemigo.getVida() > 0 && medicoEnemigo.getVida() != 100 && medicoEnemigo.getCura() > 0) {
                            medicoEnemigo.sanar(medicoEnemigo, medicoEnemigo);
                            System.out.println("El médico enemigo acaba de sanarse. Su nivel de vida actual es " + medicoEnemigo.getVida());
                        } else if (medicoEnemigo.getVida() == 100) {
                            System.out.println("El médico del enemigo no necesita cura porque su nivel de vida está completo.");
                        } else {
                            if (medicoEnemigo.getVida() <= 0) {
                                System.out.println("El médico del enemigo no puede realizarse la cura.\nNivel de vida: " + medicoEnemigo.getVida());
                            } else {
                                System.out.println("Nivel de cura: " + medicoEnemigo.getCura() + ". La cura se ha agotado. El médico del enemigo no puede sanarse. ");
                            }
                        }
                        break;
                }
            }
        } while (soldado.getVida() > 0 && enemigo.getVida() > 0);
        if (soldado.getVida() == 0) {
            System.out.println("El enemigo ha ganado la partida. Tu misión no ha tenido éxito.");
        } else {
            System.out.println("¡Enhorabuena has conseguido tu objetivo! El enemigo ha quedado reducido y tu ejército puede comentar a montar la base.");
        }

        //} while (soldado.getVida() > 0);
    }
}
