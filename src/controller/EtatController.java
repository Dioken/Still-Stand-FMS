/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

/**
 *
 * @author bah
 * Cette classe nous aide determiner dans quel contexte on se trouve
 * Contexte: Normal par defaut
 *           Vibration en vibration
 *           Luminosité manque de la lumiére
 */
public class EtatController {
    private Etat etat;
    public enum Etat{
        Normal,
        Vibration,
        Luminosite
    }    
    public Etat getEtat() {
        return etat;
    }

    public void setEtat(Etat etat) {
        this.etat = etat;
    }
}
