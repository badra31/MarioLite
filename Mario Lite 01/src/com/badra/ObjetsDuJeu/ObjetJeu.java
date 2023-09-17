package com.badra.ObjetsDuJeu;

import com.badra.ApplicationDuJeu.Main;

import javax.swing.*;
import java.awt.*;
import java.util.Objects;

public class ObjetJeu {

    ////////  VARIABLES  ///////////

     private int largeur, hauteur; // Dimension de l'objet'
     private int x,y; // Position de l'objet

     protected ImageIcon icoObjet;
     protected Image imgObjet;

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

    public ImageIcon getIcoObjet() {return icoObjet;}

    public Image getImgObjet() {return imgObjet;}

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
