package com.badra.ObjetsDuJeu;

import com.badra.ApplicationDuJeu.Main;

public class ObjetJeu {

    ////////  VARIABLES  ///////////

     private int largeur, hauteur; // Dimension de l'objet'
     private int x,y; // Position de l'objet

    ////////  CONSTRUCTEUR  ///////////

    public ObjetJeu(int x, int y, int largeur, int hauteur ) {
        this.largeur = largeur;
        this.hauteur = hauteur;
        this.x = x;
        this.y = y;
    }

    ////////  GETTERS  ///////////

    public int getLargeur() {return largeur;}

    public int getHauteur() {return hauteur;}

    public int getX() {return x;}

    public int getY() {return y;}


    ////////  SETTERS  ///////////

    public void setLargeur(int largeur) {this.largeur = largeur;}

    public void setHauteur(int hauteur) {this.hauteur = hauteur;}

    public void setX(int x) {this.x = x;}

    public void setY(int y) {this.y = y;}


    ////////  METHODES  ///////////

    public void deplacement() {
        if (Main.scene.getxPos() >= 0) {
            this.x = this.x - Main.scene.getDx();
        }
    }
}
