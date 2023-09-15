package com.badra.personnagesDuJeu;

import com.badra.ApplicationDuJeu.Main;
import com.badra.ObjetsDuJeu.ObjetJeu;

import javax.swing.*;
import java.awt.*;
import java.util.Objects;

public class Personnage {

    ////////  VARIABLES  ///////////

    private int largeur, hauteur;  // Dimension du personnage
    private int x, y;  // Position du personnage
    private boolean marche; // true quand le personnage marche
    private boolean versDroite;  // true quand le personnage est tourné vers la droite
    private int compteur;  // compteur des pas du personnage

    ///////  CONSTRUCTEUR  /////

    public  Personnage(int x, int y, int largeur, int hauteur) {
        this.x = x;
        this.y = y;
        this.largeur = largeur;
        this.hauteur = hauteur;
        this.compteur = 0;
        this.marche = false;
        this.versDroite = true;
    }

    /////// GETTERS ////////

    public int getX() {return x;}

    public int getY() {return y;}

    public int getLargeur() {return largeur;}

    public int getHauteur() {return hauteur;}

    public boolean isMarche() {return marche;}

    public boolean isVersDroite() {return versDroite;}

    public int getCompteur() {return compteur;}


    ////// SETTERS ///////

    public void setX(int x) {this.x = x;}

    public void setY(int y) {this.y = y;}

    public void setMarche(boolean marche) {this.marche = marche;}

    public void setVersDroite(boolean versDroite) {this.versDroite = versDroite;}

    public void setCompteur(int compteur) {this.compteur = compteur;}


    //////  METHODES  ////////

    public Image marche(String nom, int frequence) {

        String str;
        ImageIcon ico;
        Image img;

        // Condition de posture et de position du Personnage
        if(this.marche == false || Main.scene.getxPos() <= 0) {
            if(versDroite) {str = "/images/" + nom + "ArretDroite.png";}
            else {str = "/images/" + nom + "ArretGauche.png";}
        }else{
                this.compteur++;
                if(this.compteur / frequence == 0) {
                    if(this.versDroite == true) {str = "/images/" + nom + "ArretDroite.png";}
                    else {str = "/images/" + nom + "ArretGauche.png";}
                }else{
                    if(this.versDroite == true) {str = "/images/" + nom + "MarcheDroite.png";}
                    else {str = "/images/" + nom + "MarcheGauche.png";}
                }
                if (this.compteur == 2 * frequence) {this.compteur = 0;}
        }

        // Affichage de l'image du personnage
        ico = new ImageIcon(Objects.requireNonNull(getClass().getResource(str)));
        img = ico.getImage();
        return img;
    }


    public boolean contactAvant(ObjetJeu objet) {
        if (this.isVersDroite() == true){
            if (this.x + this.largeur < objet.getX() // mario trop a gauche
                    || this.x + this.largeur < objet.getX() + 5 // mario trop à droite
                    || this.y + this.hauteur <= objet.getY() // mario est trop haut
                    || this.y >= objet.getY() + objet.getHauteur()) // mario est trop bas
            {
                return false;
            }else{return true;}
        } else {return  false;}
    }
}
